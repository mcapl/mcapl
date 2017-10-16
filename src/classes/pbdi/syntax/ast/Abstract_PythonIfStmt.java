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

import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_PythonIfStmt implements Abstract_PythonS {
	Abstract_PythonExpr condition;
	Abstract_PythonS[] ifbody;
	Abstract_PythonS[] elsebody;
	
	public Abstract_PythonIfStmt(Abstract_PythonExpr c, ArrayList<Abstract_PythonS> ifclause, ArrayList<Abstract_PythonS> elseclause) {
		condition = c;
		ifbody = (Abstract_PythonS[]) ifclause.toArray();
		elsebody = (Abstract_PythonS[]) elseclause.toArray();
	}
	
	
	public int newJPFObject(MJIEnv env) {
	    int objref = env.newObject("pbdi.syntax.ast.Abstract_PythonIfStmt");
	    env.setReferenceField(objref, "condition", condition.newJPFObject(env));
       	int ifRef = env.newObjectArray("pbdy.syntax.ast.Abstract_PythonS", ifbody.length);
       	for (int i = 0; i < ifbody.length; i++) {
       		env.setReferenceArrayElement(ifRef, i, ifbody[i].newJPFObject(env));
       	}
       	
       	int elseRef = env.newObjectArray("pbdi.syntax.ast.Abstract_PythonS",  elsebody.length);
       	for (int i = 0; i < elsebody.length; i++) {
       		env.setReferenceArrayElement(elseRef, i, elsebody[i].newJPFObject(env));
       	}
	    return objref;
	}
	

}
