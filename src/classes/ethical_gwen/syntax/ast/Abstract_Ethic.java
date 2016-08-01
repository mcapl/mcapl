// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Ethical Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.syntax.ast;

import ail.syntax.ast.Abstract_Predicate;

import ethical_gwen.syntax.Ethic;
import gov.nasa.jpf.vm.MJIEnv;

public class Abstract_Ethic {
	Abstract_Predicate context;
	Abstract_Predicate ethic;
	int score;
	
	public Abstract_Ethic(Abstract_Predicate c, Abstract_Predicate e, String s) {
		context = c;
		ethic = e;
		score = Integer.parseInt(s);
	}
	
	public Ethic toMCAPL() {
		return new Ethic(context.toMCAPL(), ethic.toMCAPL(), score);
	}
	
    public int newJPFObject(MJIEnv env) {
    	int objref = env.newObject("ethical_gwen.syntax.ast.Abstract_Ethic");
		env.setReferenceField(objref, "context", context.newJPFObject(env));
		env.setReferenceField(objref, "ethic", ethic.newJPFObject(env));
		env.setIntField(objref, "score", score);
		return objref;
    }
}
