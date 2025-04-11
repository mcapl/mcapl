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

import java.util.HashMap;

import hera.language.Formula;
import hera.semantics.CausalModel;
import hera.semantics.CausalModelChecker;

/**
 * A class that allows us to  instantiate a HERA Causal Model from a Juno Agent.
 * @author louisedennis
 *
 */
public class JunoCausalModel extends CausalModel {

	public JunoCausalModel(JunoAgent juno, HashMap<Formula, Boolean> world) {
		this.actions = juno.getHeraActions();
		this.utilities = juno.getUtilities();
		//System.err.println("Juno Causal Model Utilities");
		//System.err.println(this.utilities);
		this.patients = juno.getPatients();
		this.description = juno.getDescription();
		this.consequences = juno.getConsequences();
		this.background = juno.getBackground();
		this.mechanisms = juno.getMechanisms();
		
		
		_computeNetwork();
		
		this.goalbase = juno.getHeraGoalBase();
		this.affects = juno.getAffects();
		
		domainOfQuantification.addAll(this.actions);
		domainOfQuantification.addAll(consequences);
		domainOfQuantification.addAll(background);
		domainOfQuantification.addAll(patients);
		this.world = world;
		checker = new CausalModelChecker();
		_setAction();
	}
}
