// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, Michael Fisher 
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
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.mas;

import ajpf.util.choice.UniformBoolChoice;
import ajpf.util.choice.UniformIntChoice;

public class DefaultEnvironmentwRandomness extends DefaultEnvironment {
	public UniformBoolChoice random_booleans;
	public UniformIntChoice random_ints;
	
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		random_booleans = new UniformBoolChoice(m.getController());
		random_ints = new UniformIntChoice(m.getController());
	}

}
