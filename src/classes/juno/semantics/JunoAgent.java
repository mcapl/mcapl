package juno.semantics;

import java.util.ArrayList;
import java.util.HashMap;

import ail.semantics.AILAgent;
import ail.util.Tuple;
import hera.language.Formula;

public class JunoAgent extends AILAgent {
	ArrayList<String> actions = new ArrayList<String>();
	HashMap<String, Double> utilities = new HashMap<String, Double>();
	ArrayList<String> patients = new ArrayList<String>();
	String description = "No Description";
	ArrayList<String> consequences = new ArrayList<String>();
	ArrayList<String> background = new ArrayList<String>();
	HashMap<String, Formula> mechanisms = new HashMap<String, Formula>();
	HashMap<String, ArrayList<String>> intentions = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> goals = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<Tuple<String,String>>> affects = new HashMap<String, ArrayList<Tuple<String, String>>>();

	public ArrayList<String> getHeraActions() {
		return actions;
	}
	
	public void setUtilities(HashMap<String, Double> utilities) {
		this.utilities = utilities;
	}
}
