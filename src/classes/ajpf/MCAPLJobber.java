// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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

package ajpf;

import java.util.logging.Logger;
import java.util.logging.Level;

import ajpf.psl.MCAPLFormula;

//import gov.nasa.jpf.jvm.abstraction.filter.FilterField;
import gov.nasa.jpf.annotation.FilterField;
import gov.nasa.jpf.vm.Verify;

/**
 * An encapsulation class for agents in the agent programming language.
 * 
 * @author louiseadennis
 */
public interface MCAPLJobber extends Comparable<MCAPLJobber>{
	public void do_job();
	
	public String getName();
	    
}
