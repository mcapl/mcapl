// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
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
package pbdi.syntax.ast;

import ail.syntax.ast.Abstract_Agent;

public class Abstract_PBDIAgent extends Abstract_Agent {
	public Abstract_PythonFunc[] funcs = new Abstract_PythonFunc[0];
	public String[] rulenames = new String[0];
	
	public Abstract_PBDIAgent(String name) {
		super(name);
	}
	
	public void addFunc(Abstract_PythonFunc func) {
		int newsize = funcs.length + 1;
		Abstract_PythonFunc[] newfuncs = new Abstract_PythonFunc[newsize];
		for (int i = 0; i < funcs.length; i++) {
			newfuncs[i] = funcs[i];
		}
		newfuncs[funcs.length] = func;
		funcs = newfuncs;
	}
	
	public void addRuleName(String name) {
		int newsize = rulenames.length + 1;
		String[] newnames = new String[newsize];
		for (int i = 0; i < rulenames.length; i++) {
			newnames[i] = rulenames[i];
		}
		newnames[rulenames.length] = name;
		rulenames = newnames;
	}
	
	public String toString() {
		String s = getAgName();
		s += "\n";
		for (int i = 0; i < rulenames.length; i++) {
			s += rulenames[i] + "\n";
		}
		return s;
		
	}

}
