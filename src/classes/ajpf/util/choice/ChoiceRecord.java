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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	String logname = "ajpf.choice.ChoiceRecord";
	
	static String recordseparator = ":";
	
	public ChoiceRecord() {}
	
	public ChoiceRecord(String fileName) throws IOException {
	    if (fileName != null && fileName.length() > 0) {
		      try {
		        BufferedReader f = new BufferedReader( new FileReader(fileName));
		        if (f.ready()) {
		        	if (AJPFLogger.ltFine(logname)) {
		        		AJPFLogger.fine(logname, "loading record file: " + fileName);
		        	}
		          String line;
		          
		          while ((line = f.readLine()) != null) {
		              choicelist.add(Integer.parseInt(line));
		          }
		          
		          f.close();
		        } else {
		        	if (AJPFLogger.ltFine(logname)) {
		        		AJPFLogger.fine(logname, "record file is empty: " + fileName);
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
		System.err.println("here");
		if (AJPFLogger.ltInfo(logname)) {
			AJPFLogger.info(logname, "Record: " + this.toString());
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
			
			for (int i : choicelist) {
				f.write("" + i);
				f.write("\n");
			}
			
			f.close();
		} catch (IOException iex) {
	        throw iex;
	      } 
	}
	
	public String toString() {
		return choicelist.toString();
	}
	
	
}
