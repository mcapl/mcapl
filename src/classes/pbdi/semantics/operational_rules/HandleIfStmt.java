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
package pbdi.semantics.operational_rules;

import java.util.ArrayList;

import ail.semantics.AILAgent;
import ail.semantics.OSRule;
import ail.semantics.operationalrules.HandleTopDeed;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import gov.nasa.jpf.annotation.FilterField;
import pbdi.semantics.PBDIAgent;
import pbdi.syntax.PythonIfStmt;

public class HandleIfStmt extends HandleTopDeed implements OSRule {
	@FilterField
	private String name = "Handle If Stmt";

	@Override
	public boolean checkPreconditions(AILAgent a) {
		return topdeed.getCategory() == PythonIfStmt.IfStmt;
	}

	@Override
	public void apply(AILAgent a) {
		PBDIAgent pbdi_agent = (PBDIAgent) a;
		PythonIfStmt if_stmt = (PythonIfStmt) topdeed;
		ArrayList<Guard> guardstack = new ArrayList<Guard>();
		guardstack.add(new Guard(new GBelief()));
		 i = pbdi_agent.getIntention();
		if (if_stmt.condition().evaluates_to(pbdi_agent)) {
			pbdi_agent.getIntention().iConcat(i.hdE(),if_stmt.if_clause(), guardstack, i.hdU());
		} else {
			pbdi_agent.getIntention().iConcat(i.hdE(),if_stmt.else_clause(), guardstack, i.hdU());
		}
	}

	@Override
	public String getName() {
		return name;
	}

}
