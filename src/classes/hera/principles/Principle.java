package hera.principles;

import java.util.ArrayList;

import hera.language.Formula;
import hera.semantics.Model;

public abstract class Principle {
	Model model;
	ArrayList<Formula> formulae = new ArrayList<Formula>();
	ArrayList<Boolean> result = new ArrayList<Boolean>();
	String label;
	String action;
		
	public void init(Model m) {
		model = m;
	}
	
	public abstract ArrayList<Boolean> _check();
	
	public abstract Boolean permissible();
	
	public String explain() {
		Boolean pd = permissible();
		String result = "";
		if (pd == null) {
			result = "The " + label + " is not applicable to this instance!";
		} else if (pd == true) {
			result = "According to the "+ label + ", the action " + action + " is permissible!"; 
		} else {
			result = result + "According to the " + label + " principle, the action " + action +" is not permissible!\n";
		    result = result + "Because the following does not hold: \n";
		    for (int i = 0; i < this.result.size(); i++ ) {
		    		if (! this.result.get(i)) {
		    			result = result + formulae.get(i) + "\n";
		    		}
		    }
		}
		return result;
	}
}
