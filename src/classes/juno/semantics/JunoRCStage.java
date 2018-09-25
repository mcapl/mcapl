// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
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
//----------------------------------------------------------------------------
package juno.semantics;

import java.util.Iterator;
import java.util.LinkedList;

import ail.semantics.OSRule;
import ail.semantics.RCStage;
import gov.nasa.jpf.annotation.FilterField;

/**
 * A stage of a Juno Agent Reasoning Cycle.
 * @author louisedennis
 *
 */
public class JunoRCStage implements RCStage {
	@FilterField
	private int stage;
	/**
	 * The name of the stage.
	 */
	@FilterField
	private String name;

	/**
	 * The disjunction of rules for this stage.
	 */
	@FilterField
	private LinkedList<OSRule> rules = new LinkedList<OSRule>();
	
	public JunoRCStage(int st, String s) {
		stage = st;
		name = s;
	}
	
	/**
	 * Getter method for the number representing the stage.
	 * 
	 * @return the number representing the stage.
	 */
	private int getStageNum() {
		return stage;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.RCStage#getStageName()
	 */
	@Override
	public String getStageName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.RCStage#getStageRules()
	 */
	@Override
	public Iterator<OSRule> getStageRules() {
		return(rules.iterator());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.semantics.RCStage#setRule(ail.semantics.OSRule)
	 */
	@Override
	public void setRule(OSRule r) {
		rules.add(r);
	}
	
	/**
	 * Compare two stages
	 * 
	 */
	public int compareTo(JunoRCStage arg0) {
		if (arg0.getStageNum() == stage) {
			return 1;
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}


}
