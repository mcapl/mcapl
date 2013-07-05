// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package gwendolen.syntax.ast;

import ail.syntax.ast.Abstract_Literal;
import ail.syntax.ast.Abstract_Term;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_StringTerm;
import ail.syntax.ast.Abstract_StringTermImpl;

/**
 * Class for Gwendolen messages, making them simpler to constuct.
 * @author louiseadennis
 *
 */
public class Abstract_GMessage extends Abstract_Literal {
	
	public Abstract_GMessage() {
		super("message");
	}

	public Abstract_GMessage(Abstract_StringTerm sender, Abstract_StringTerm receiver, int performative, Abstract_Term content) {
		super("message");
		this.addTerm(new Abstract_StringTermImpl("mid"));
		this.addTerm(new Abstract_StringTermImpl("thid"));
		this.addTerm(sender);
		this.addTerm(receiver);
		this.addTerm(new Abstract_Predicate(((Integer) performative).toString()));
		this.addTerm(content);
	}
	
	public Abstract_GMessage(Abstract_Term sender, String receiver, Byte performative, Abstract_Term content) {
		super("message");
		this.addTerm(new Abstract_StringTermImpl("mid"));
		this.addTerm(new Abstract_StringTermImpl("thid"));
		this.addTerm(sender);
		this.addTerm(new Abstract_Predicate(receiver));
		this.addTerm(new Abstract_Predicate(performative.toString()));
		this.addTerm(content);
	}
	
	public Abstract_GMessage(Abstract_Term sender, Abstract_Term receiver, Byte performative, Abstract_Term content) {
		super("message");
		this.addTerm(new Abstract_StringTermImpl("mid"));
		this.addTerm(new Abstract_StringTermImpl("thid"));
		this.addTerm(sender);
		this.addTerm(receiver);
		this.addTerm(new Abstract_Predicate(performative.toString()));
		this.addTerm(content);
	}
	
	public Abstract_GMessage(Abstract_Term sender, Abstract_Term receiver, int performative, Abstract_Term content) {
		super("message");
		this.addTerm(new Abstract_StringTermImpl("mid"));
		this.addTerm(new Abstract_StringTermImpl("thid"));
		this.addTerm(sender);
		this.addTerm(receiver);
		this.addTerm(new Abstract_Predicate(((Integer) performative).toString()));
		this.addTerm(content);
	}
	
}
