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

import java.util.ArrayList;

import ail.syntax.ast.Abstract_Deed;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonIfStmt implements Abstract_PythonS {
	Abstract_PythonExpr condition;
	Abstract_PythonS[] ifbody;
	Abstract_PythonS[] elsebody;
	
	public Abstract_PythonIfStmt(Abstract_PythonExpr c, ArrayList<Abstract_PythonS> ifclause, ArrayList<Abstract_PythonS> elseclause) {
		condition = c;
		Abstract_PythonS[] ifb = new Abstract_PythonS[ifclause.size()];
		int i = 0;
		for (Abstract_PythonS s: ifclause) {
			ifb[i] = s;
			i++;
		}
		Abstract_PythonS[] elseb = new Abstract_PythonS[elseclause.size()];
		i = 0;
		for (Abstract_PythonS s: elseclause) {
			elseb[i] = s;
			i++;
		}
		ifbody = ifb;
		elsebody = elseb;
	}
	
	public Abstract_PythonS[] getElse() {
		return elsebody;
	}
	
	
	public int newJPFObject(MJIEnv env) {
	    int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonIfStmt");
	    env.setReferenceField(objref, "condition", condition.newJPFObject(env));
       	int ifRef = env.newObjectArray("pbdy.syntax.ast.Abstract_PythonS", ifbody.length);
       	for (int i = 0; i < ifbody.length; i++) {
       		env.setReferenceArrayElement(ifRef, i, ifbody[i].newJPFObject(env));
       	}
       	env.setReferenceField(objref, "ifbody", ifRef);
       	
       	int elseRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PythonS",  elsebody.length);
       	for (int i = 0; i < elsebody.length; i++) {
       		env.setReferenceArrayElement(elseRef, i, elsebody[i].newJPFObject(env));
       	}
       	env.setReferenceField(objref, "elsebody", elseRef);
	    return objref;
	}
	
	public Abstract_PythonExpr getCondition() {
		return condition;
	}


	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Abstract_Deed getDeed() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
