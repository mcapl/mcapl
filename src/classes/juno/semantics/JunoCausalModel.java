package juno.semantics;

import java.util.HashMap;

import hera.language.Formula;
import hera.semantics.CausalModel;
import hera.semantics.CausalModelChecker;

public class JunoCausalModel extends CausalModel {

	public JunoCausalModel(JunoAgent juno, HashMap<Formula, Boolean> world) {
		this.actions = juno.getHeraActions();
		this.utilities = juno.getUtilities();
		this.patients = juno.getPatients();
		this.description = juno.getDescription();
		this.consequences = juno.getConsequences();
		this.background = juno.getBackground();
		this.mechanisms = juno.getMechanisms();
		this.intentions = juno.getHeraIntentions();
		this.goals = juno.getHeraGoals();
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
