// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.mas;

import org.junit.Test;
import org.junit.Assert;

import ajpf.MCAPLcontroller;
import ajpf.psl.MCAPLPredicate;
import ajpf.psl.MCAPLTermImpl;

import ail.syntax.Action;
import ail.syntax.VarTerm;

import eass.EASSMASBuilder;
import eass.verification.leo.LEOVerificationEnvironmentASEPaper;

/**
 * Regression tests for methods involving the multi-agent system.
 * @author lad
 *
 */
public class MASQuickTests {
	
	/*
	 * Test that lastActionWas will work when the action taken includes a variable, but is being tested against a ground term.
	 */
	@Test public void lastActionWasTest() {
    	String filename = "/src/examples/eass/verification/leo/satellite_middle_line.eass";
    	try {
    		String abs_filename = MCAPLcontroller.getFilename(filename);

    		MAS mas = (new EASSMASBuilder(abs_filename, true)).getMAS();
    		LEOVerificationEnvironmentASEPaper env = new LEOVerificationEnvironmentASEPaper();
    		mas.setEnv(env);
		
    		Action envaction = new Action("does");
    		envaction.addTerm(new VarTerm("P"));
		
    		MCAPLPredicate agentaction = new MCAPLPredicate("does");
    		agentaction.addTerm(new MCAPLTermImpl("something"));
    		env.lastAction = envaction;
    		env.lastAgent = "ag1";
		
    		Assert.assertTrue(mas.lastActionWas("ag1", agentaction)); 
    	} catch (Exception e) {
    		System.err.println(e.getMessage());
    		Assert.fail(e.getMessage());
    	}
		
	} 


}
