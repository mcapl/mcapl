// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package juno;

import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import ail.mas.MAS;
import ail.syntax.ast.Abstract_MAS;
import ail.syntax.ast.Abstract_VarTerm;
import ail.mas.MASBuilder;

import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import juno.semantics.JunoAgent;

/**
 * Utility class.  Builds a Gwendolen MAS by parsing a string or a file.
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
	
	public MAS getMAS(String filename) {
		JunoAgent juno = parsefile(filename);
		mas = new MAS();
		mas.addAg(juno);

		return mas;
	}
	

}
