// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.util.choice;

import gov.nasa.jpf.annotation.FilterField;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ajpf.util.AJPFLogger;

/**
 * A class which represents a record of a series of choices made as an agent progresses through the system.  This can be used in two ways, firstly to record 
 * a series of choices and secondly to play back a series of choices.
 * @author louiseadennis
 *
 */
public class ChoiceRecord {
	@FilterField
	ArrayList<Integer> choicelist = new ArrayList<Integer>();
	
	@FilterField
	public int currentchoice = 0;
	
	@FilterField
	String logname = "ajpf.util.choice.ChoiceRecord";
	
	static String recordseparator = ":";
	
	public ChoiceRecord() {}
	
	public ChoiceRecord(String fileName) throws IOException {
	    if (fileName != null && fileName.length() > 0) {
		      try {
		        BufferedReader f = new BufferedReader( new FileReader(fileName));
		        if (f.ready()) {
		        	if (AJPFLogger.ltFiner(logname)) {
		        		AJPFLogger.finer(logname, "loading record file: " + fileName);
		        	}
		          String line = f.readLine();
		          
		          String regexpStr = "(([0-9]+)((,\\s)||\\]))";
		          Pattern regexp = Pattern.compile(regexpStr);
		          Matcher matcher = regexp.matcher(line);
		          
		          while (matcher.find()) {
		        	  MatchResult result = matcher.toMatchResult();
		        	  String intString = result.group(2);
		              choicelist.add(Integer.parseInt(intString));
		          }
		          
		          f.close();
		        } else {
		        	if (AJPFLogger.ltFiner(logname)) {
		        		AJPFLogger.finer(logname, "record file is empty: " + fileName);
		        	}
		        }
		      } catch (IOException iex) {
		        throw iex;
		      } 
		    }
	}

	/**
	 * Add a choice to the record.
	 * @param i
	 */
	public void add(int i) {
		choicelist.add(i);
		if (AJPFLogger.ltFine(logname)) {
			AJPFLogger.fine(logname, "Record: " + this.toString());
		}
	}
	
	/**
	 * Return the next choice from the record.
	 * @return
	 */
	public int next() {
		int choice = choicelist.get(currentchoice);
		currentchoice++;
		return choice;
	}
	
	/**
	 * Print out the record of this run.
	 * @param filename
	 * @throws AILexception
	 */
	public void printRecord(String filename) throws IOException {
		try {
			BufferedWriter f = new BufferedWriter( new FileWriter(filename));
			f.write("[");
			
			boolean start = true;
			for (int i : choicelist) {
				if (!start) {
					f.write(", ");
				}
				f.write("" + i);
				start = false;
			}
			
			f.write("]");
			f.close();
		} catch (IOException iex) {
	        throw iex;
	      } 
	}
	
	public String toString() {
		return choicelist.toString();
	}
	
	
}
