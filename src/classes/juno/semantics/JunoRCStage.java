package juno.semantics;

import java.util.Iterator;
import java.util.LinkedList;

import ail.semantics.OSRule;
import ail.semantics.RCStage;
import gov.nasa.jpf.annotation.FilterField;
import pbdi.semantics.PBDIRCStage;

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
	
	@Override
	public String getStageName() {
		return name;
	}

	@Override
	public Iterator<OSRule> getStageRules() {
		return(rules.iterator());
	}

	@Override
	public void setRule(OSRule r) {
		rules.add(r);
	}
	
	/**
	 * Compare two stages
	 * 
	 * @param arg0 a PBDI Reasoning Cycle Stage
	 * @return 1 if the stages are the same, 0 if they are not.
	 */
	public int compareTo(JunoRCStage arg0) {
		if (arg0.getStageNum() == stage) {
			return 1;
		}
		return 0;
	}

	
	@Override
	public String toString() {
		return name;
	}


}
