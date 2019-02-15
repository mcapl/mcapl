// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
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
package pbdi.syntax;

import java.util.ArrayList;

import ail.syntax.Deed;
import gov.nasa.jpf.annotation.FilterField;

public class PythonIfStmt extends Deed {
	@FilterField
    public static final byte	IfStmt = 20;
	
	PythonExpr condition;
	ArrayList<Deed> ifclause;
	ArrayList<Deed> elseclause;
	
	public PythonIfStmt(PythonExpr condition, ArrayList<Deed> ifbody, ArrayList<Deed> elsebody) {
		super(IfStmt);
		this.condition = condition;
		ifclause = ifbody;
		elseclause = elsebody;
	}
	
	public PythonIfStmt(PythonExpr condition, ArrayList<Deed> ifbody) {
		super(IfStmt);
		this.condition = condition;
		ifclause = ifbody;
		elseclause = new ArrayList<Deed>();
	}

	
	public PythonExpr condition() {
		return condition;
	}
	
	public ArrayList<Deed> if_clause() {
		return ifclause;
	}
	
	public ArrayList<Deed> else_clause() {
		return elseclause;
	}

}
