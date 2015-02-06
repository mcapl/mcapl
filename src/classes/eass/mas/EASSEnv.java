// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package eass.mas;

import ail.mas.AILEnv;
import ail.syntax.Literal;
import ajpf.MCAPLJobber;
import ail.syntax.Literal;

public interface EASSEnv extends AILEnv, MCAPLJobber {
	public void addAbstractionEngine(String s, String foragent);
	
	public String rationalName(String name);
	
	public String getName();
	
	public void eachrun();
	
	public void addSharedBelief(String agName, Literal per);
	
	public boolean removeSharedBelief(String agName, Literal per);
	
	public void notifySharedListeners(String agName);
	
	public boolean removeUnifiesShared(String agName, Literal per);
}
