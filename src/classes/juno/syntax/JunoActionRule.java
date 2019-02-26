package juno.syntax;

import java.util.ArrayList;
import java.util.List;

import ail.syntax.Literal;

public class JunoActionRule {
	Literal trigger;
	List<Literal> beliefs = new ArrayList<Literal>();
	
	public JunoActionRule(Literal trigger) {
		this.trigger = trigger;
	}
	
	public void add_belief(Literal belief) {
		beliefs.add(belief);
	}
	
	public Literal getTrigger() {
		return trigger;
	}
	
	public List<Literal> getbeliefs() {
		return beliefs;
	}
}
