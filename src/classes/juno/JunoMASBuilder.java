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


import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.mas.MAS;
import ail.mas.MASBuilder;
import juno.semantics.JunoAgent;
import juno.syntax.ast.Abstract_JunoAgent;
import juno.syntax.parser.JunoAILVisitor;
import juno.syntax.parser.JunoLexer;
import juno.syntax.parser.JunoParser;

/**
 * Utility class.  Builds a Juno MAS by parsing a string or a file.
 * @author louiseadennis
 *
 */
public class JunoMASBuilder implements MASBuilder {
	MAS mas;
	Abstract_JunoAgent a_juno;
	
	public JunoMASBuilder() {};
	
	public JunoMASBuilder(String masstring, boolean filename) {
		parsefile(masstring);
		JunoAgent juno = a_juno.toMCAPL();
		mas = new MAS();
		mas.addAg(juno);
     }
	
	
	public void parsefile(String masstring) {
		try {
			JunoLexer lexer = new JunoLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			JunoParser parser = new JunoParser(tokens);
			JunoAILVisitor visitor = new JunoAILVisitor();
			a_juno = (Abstract_JunoAgent) visitor.visitJunoAgent(parser.junoAgent());
			//JunoAgent juno = ajuno.toMCAPL();
    		//return juno;
      	} catch (Exception e) {
     		e.printStackTrace();
    	}
		//return null;
		
	}

	/**
	 * Getter method for the resulting MAS.
	 * @return
	 */
	public MAS getMAS() {
		return mas;
	}
	
	public MAS getMAS(String filename) {
		parsefile(filename);
	public MAS getMAS(String filename, String tracedir) {
		JunoAgent juno = parsefile(filename);
		mas = new MAS();
		JunoAgent juno = a_juno.toMCAPL();
		mas.setTraceDir(tracedir);
		mas.addAg(juno);

		return mas;
	}
	

}
