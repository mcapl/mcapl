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

package pbdi.semantics;

import java.util.Iterator;
import java.util.LinkedList;

import ail.semantics.OSRule;
import ail.semantics.RCStage;

import gov.nasa.jpf.annotation.FilterField;

/**
 * A PBDI Reasoning stage
 * 
 * @author louiseadennis
 *
 */
public class PBDIRCStage implements RCStage {
	/**
	 * An integer representing the stage.  These are named in the
	 * PBDI Reasoning Cycle object.
	 */
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
		
	/**
	 * Construct a stage from an integer and stage name.
	 * 
	 * @param st an integer representing the stage.
	 * @param s The name of the stage.
	 */
	public PBDIRCStage(int st, String s) {
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
	public String getStageName() {
		return name;
	}

	/**
	 * Compare two stages
	 * 
	 * @param arg0 a PBDI Reasoning Cycle Stage
	 * @return 1 if the stages are the same, 0 if they are not.
	 */
	public int compareTo(PBDIRCStage arg0) {
		if (arg0.getStageNum() == stage) {
			return 1;
		}
		return 0;
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
	public void setRule(OSRule rule) {
			rules.add(rule);
	}
	
	@Override
	public String toString() {
		return name;
	}

}
