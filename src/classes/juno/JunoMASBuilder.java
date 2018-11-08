// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package juno;


import ail.mas.MAS;
import ail.mas.MASBuilder;
import juno.semantics.JunoAgent;

/**
 * Utility class.  Builds a Juno MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class JunoMASBuilder implements MASBuilder {
	MAS mas;
	
	public JunoMASBuilder() {};
	
	public JunoMASBuilder(String masstring, boolean filename) {
		JunoAgent juno = parsefile(masstring);
		mas = new MAS();
		mas.addAg(juno);
     }
	
	
	public JunoAgent parsefile(String masstring) {
		try {
			JunoAgent juno = new JunoAgent(masstring);
    		return juno;
      	} catch (Exception e) {
     		e.printStackTrace();
    	}
		return null;
		
	}

	/**
	 * Getter method for the resulting MAS.
	 * @return
	 */
	public MAS getMAS() {
		return mas;
	}
	
	public MAS getMAS(String filename, String tracedir) {
		JunoAgent juno = parsefile(filename);
		mas = new MAS();
		mas.setTraceDir(tracedir);
		mas.addAg(juno);

		return mas;
	}
	

}
