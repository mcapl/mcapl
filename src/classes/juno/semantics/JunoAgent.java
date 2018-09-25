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

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ail.semantics.AILAgent;
import ail.util.AILConfig;
import ail.util.Tuple;
import ajpf.MCAPLcontroller;
import ajpf.util.VerifyMap;
import gov.nasa.jpf.annotation.FilterField;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.principles.DoubleEffectPrinciple;
import hera.principles.KantianHumanityPrincipleReading1;
import hera.principles.Principle;
import hera.principles.UtilitarianPrinciple;

public class JunoAgent extends AILAgent {
	String description = "Juno Agent";

	ArrayList<String> actions = new ArrayList<String>();

	@FilterField
	HashMap<String, Double> utilities = new HashMap<String, Double>();
	HashMap<String, Double> default_utilities = new HashMap<String, Double>();
	VerifyMap<Formula, VerifyMap<String, Double>> context_utilities = new VerifyMap<Formula, VerifyMap<String, Double>>();

	@FilterField
	public ArrayList<String> goalbase = new ArrayList<String>();
	ArrayList<String> default_goals = new ArrayList<String>();
	HashMap<Formula, ArrayList<String>> context_goals = new HashMap<Formula, ArrayList<String>>();

	ArrayList<String> patients = new ArrayList<String>();
	@FilterField
	HashMap<String, ArrayList<Tuple<String,String>>> affects = new HashMap<String, ArrayList<Tuple<String, String>>>();
	HashMap<String, ArrayList<Tuple<String,String>>> default_affects = new HashMap<String, ArrayList<Tuple<String, String>>>();
	VerifyMap<Formula, VerifyMap<String, ArrayList<Tuple<String,String>>>> context_affects = new VerifyMap<Formula, VerifyMap<String, ArrayList<Tuple<String,String>>>>();

	ArrayList<String> consequences = new ArrayList<String>();
	HashMap<String, Formula> mechanisms = new HashMap<String, Formula>();

	@FilterField
	ArrayList<String> background = new ArrayList<String>();
	ArrayList<Tuple<Formula, FormulaString>> context_background = new ArrayList<Tuple<Formula, FormulaString>>();

	
	public static int UTILITARIAN = 0;
	public static int DOUBLE_EFFECT = 1;
	public static int KANTIAN = 2;
	
	FormulaString action = new FormulaString("refrain");
	
	public int ethical_system = UTILITARIAN;

	/**
	 * Construct an agent from a file.
	 * @param file
	 */
	public JunoAgent(String file) {
		super();
		this.setAgName("juno");
		this.setReasoningCycle(new JunoRC());

		parseFromFile(file);
	}
	
	/**
	 * Support for json parsing -- largely the same as JSON parsing of HERA agents.
	 * @param file
	 */
	public void parseFromFile(String file) {
		JSONParser parser = new JSONParser();
		try {
			String abs_filename = MCAPLcontroller.getFilename(file);
			Object obj = parser.parse(new FileReader(abs_filename));
			JSONObject model = (JSONObject) obj;
			JSONArray actions = (JSONArray) model.get("actions");
			JSONArraytoArrayListString(actions, this.actions);
			
			// Optional entries
			try {
				JSONObject utilities = (JSONObject) model.get("utilities");
				JSONObjecttoHashDouble(utilities, this.utilities);
				default_utilities = this.utilities;
			} catch (Exception e) {
					
			}
				
			try {
				JSONArray patients = (JSONArray) model.get("patients");
				if (patients != null) {
						JSONArraytoArrayListString(patients, this.patients);
				}
			} catch (Exception e) {
					
			}
			
			try {
				JSONArray consequences = (JSONArray) model.get("consequences");
				JSONArraytoArrayListString(consequences, this.consequences);
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject mechanisms = (JSONObject) model.get("mechanisms");
				for (Object s: mechanisms.keySet()) {
					String v = (String) mechanisms.get(s);
					this.mechanisms.put((String) s, (Formula) new FormulaString("tmp").fromString(v));
				}
			} catch (Exception e) {
				
			}
			
			// Juno infers intentions and goals from a goalbase (so this is different to HERA).
			try {
				JSONArray goalbase = (JSONArray) model.get("goalbase");
				JSONArraytoArrayListString(goalbase, this.goalbase);
				default_goals = this.goalbase;
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject affects = (JSONObject) model.get("affects");
				if (affects != null) {
					for (Object s: affects.keySet()) {
						JSONArray list = (JSONArray) affects.get(s);
						ArrayList<Tuple<String, String>> arrayl = new ArrayList<Tuple<String,String>>();
						for (Object o: list) {
							JSONArray tuple = (JSONArray) o;
							Tuple<String, String> new_tuple = new Tuple<String, String>((String) tuple.get(0), (String) tuple.get(1));
							arrayl.add(new_tuple);
						}
						this.affects.put((String) s, arrayl); 
						
					}
				}
				default_affects = this.affects;
			} catch (Exception e) {
				
			}
			
			// JUNO can have context specific background, utilities and affects relations.
			try {
				JSONObject context_background = (JSONObject) model.get("context_background");
				if (context_background != null) {
					for (Object s: context_background.keySet()) {
						String v = (String) context_background.get(s);
						this.context_background.add(new Tuple<Formula, FormulaString>((Formula) new FormulaString("tmp").fromString((String) s), 
								                              (FormulaString) new FormulaString("tmp").fromString(v)));
					}
				}
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject context_utilities = (JSONObject) model.get("context_utilities");
				if (context_utilities != null) {
					for (Object s: context_utilities.keySet()) {
						VerifyMap<String, Double> utilities_for_context = new VerifyMap<String, Double>();
						JSONObjecttoVerifyHashDouble((JSONObject) context_utilities.get(s), utilities_for_context);
						this.context_utilities.put((Formula) new FormulaString("tmp").fromString((String) s), utilities_for_context);
					}
				}
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject context_affects = (JSONObject) model.get("context_affects");
				if (context_affects != null) {
					for (Object s: context_affects.keySet()) {
						VerifyMap<String, ArrayList<Tuple<String,String>>> affects_for_context = new VerifyMap<String, ArrayList<Tuple<String, String>>>();
						JSONObject affs = (JSONObject) context_affects.get(s);
						for (Object s1: affs.keySet()) {
							JSONArray list = (JSONArray) affs.get(s1);
							ArrayList<Tuple<String, String>> arrayl = new ArrayList<Tuple<String,String>>();
							for (Object o: list) {
								JSONArray tuple = (JSONArray) o;
								Tuple<String, String> new_tuple = new Tuple<String, String>((String) tuple.get(0), (String) tuple.get(1));
								arrayl.add(new_tuple);
							}
							affects_for_context.put((String) s1, arrayl); 						
						}
						this.context_affects.put((Formula) new FormulaString("tmp").fromString((String) s), affects_for_context);
					}
				}
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject context_goals = (JSONObject) model.get("context_goals");
				if (context_goals != null) {
					for (Object s: context_goals.keySet()) {
						JSONArray v = (JSONArray) context_goals.get(s);
						ArrayList<String> gs = new ArrayList<String>();
						JSONArraytoArrayListString(v, gs);
						this.context_goals.put((Formula) new FormulaString("tmp").fromString((String) s), gs);
					}
				}
			} catch (Exception e) {
				
			}
					

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}


		
	}
	
	/**
	 * Getter for the actions (these are Hera Actions - not to be confused with AIL Actions).
	 * @return
	 */
	public ArrayList<String> getHeraActions() {
		return actions;
	}
	
	/**
	 * Getter for the context utilities.
	 * @return
	 */
	public VerifyMap<Formula, VerifyMap<String, Double>> getContextUtilities() {
		return context_utilities;
	}
	
	/** 
	 * Getter for the context goals.
	 * @return
	 */
	public HashMap<Formula, ArrayList<String>> getContextGoals() {
		return context_goals;
	}
	
	/**
	 * Getter for the context affects relation.
	 * @return
	 */
	public VerifyMap<Formula, VerifyMap<String, ArrayList<Tuple<String, String>>>> getContextAffects() {
		return context_affects;
	}
	
	/**
	 * Set the utilities.
	 * @param utilities
	 */
	public void setUtilities(HashMap<String, Double> utilities) {
		this.utilities = utilities;
	}
	
	/**
	 * Add a utility for some consequence.
	 * @param s
	 * @param u
	 */
	public void setUtility(String s, Double u) {
		this.utilities.put(s, u);
	}
	
	/**
	 * Set the goal base.  NB.  This is a list of strings, not an AIL goalbase.
	 * @param goals
	 */
	public void setGoals(ArrayList<String>  goals) {
		this.goalbase = goals;
	}
	
	/**
	 * Add a goal to the goalbase.  NB.  This is a list of strings, not an AIL goalbase.
	 * @param goal
	 */
	public void setNewGoal(String goal) {
		this.goalbase.add(goal);
	}
	
	/**
	 * Set the affects relation.
	 * @param affs
	 */
	public void setAffects(HashMap<String, ArrayList<Tuple<String, String>>> affs) {
		this.affects = affs;
	}
	
	/**
	 * Add a mapping to the affects relation.
	 * @param s
	 * @param affs
	 */
	public void setAffect(String s, ArrayList<Tuple<String, String>> affs) {
		this.affects.put(s, affs);
	}
	
	/**
	 * Remove the affects of some consequence.
	 * @param s
	 */
	public void removeAffect(String s) {
		if (affects.keySet().contains(s)) {
			affects.remove(s);
		}
	}
	
	/**
	 * Return the default utilities.  Clone them to keep avoid them being altered.
	 * @return
	 */
	public HashMap<String, Double> defaultUtilities() {
		HashMap<String, Double> us_clone = new HashMap<String, Double>();
		for (String s: default_utilities.keySet()) {
			us_clone.put(s, default_utilities.get(s));
		}
		return us_clone;
	}
	
	/**
	 * Return the default goal base.  Clone it to avoid it being altered.
	 * @return
	 */
	public ArrayList<String> defaultGoals() {
		ArrayList<String> g_clone = new ArrayList<String>();
		for (String s: default_goals) {
			g_clone.add(s);
		}
		return g_clone;
	}

	/**
	 * Return the default affects relation.  Cloned to avoid alteration.
	 * @return
	 */
	public HashMap<String, ArrayList<Tuple<String,String>>> defaultAffects() {
		HashMap<String, ArrayList<Tuple<String,String>>> us_clone = new HashMap<String, ArrayList<Tuple<String,String>>>();
		for (String s: default_affects.keySet()) {
			ArrayList<Tuple<String, String>> aff_list = default_affects.get(s);
			ArrayList<Tuple<String, String>> new_aff_list = new ArrayList<Tuple<String, String>>();
			for (Tuple<String, String> t: aff_list) {
				new_aff_list.add(new Tuple<String, String>(t.getLeft(), t.getRight()));
			}
			us_clone.put(s, new_aff_list);
		}
		return us_clone;
	}

	/**
	 * Getter for the utilities.
	 * @return
	 */
	public HashMap<String, Double> getUtilities() {
		return this.utilities;
	}
	
	/**
	 * Getter for the moral patients.
	 * @return
	 */
	public ArrayList<String> getPatients() {
		return this.patients;
	}
	
	/**
	 * Getter for the desciription.
	 * @return
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Getter for the possible consequenecs.
	 * @return
	 */
	public ArrayList<String> getConsequences() {
		return this.consequences;
	}
	
	/**
	 * Getter for the possible background facts.
	 * @return
	 */
	public ArrayList<String> getBackground() {
		return this.background;
	}
	
	/**
	 * Getter for the mechanism.
	 * @return
	 */
	public HashMap<String, Formula> getMechanisms() {
		return this.mechanisms;
	}
	
	/**
	 * Getter for the goal base.  NB.  This is a list of strings, not an AIL Goalbase.
	 * @return
	 */
	public ArrayList<String> getHeraGoalBase() {
		return this.goalbase;
	}
	
	/**
	 * Getter for the affects relation.
	 * @return
	 */
	public HashMap<String, ArrayList<Tuple<String, String>>> getAffects() {
		return this.affects;
	}
	
	/**
	 * Getter for the context related background facts.
	 * @return
	 */
	public ArrayList<Tuple<Formula, FormulaString>> getContextBackground() {
		return context_background;
	}
	
	// Support functions to help parsing.
	
	
	private void JSONArraytoArrayListString(JSONArray ja, ArrayList<String> a) {
		for (Object s: ja) {
			String constant = (String) s;
			a.add(constant);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private <T> void JSONObjecttoHashDouble(JSONObject jo, HashMap<String, Double> map) {
		Set<Object> keySet = (Set<Object>) jo.keySet();
		for (Object s: keySet) {
			Number  n = (Number) jo.get(s);
			double d = n.doubleValue();
			map.put((String) s, new Double(d)); 
		}
		
	}
		
	@SuppressWarnings("unchecked")
	private <T> void JSONObjecttoVerifyHashDouble(JSONObject jo, VerifyMap<String, Double> map) {
		Set<Object> keySet = (Set<Object>) jo.keySet();
		for (Object s: keySet) {
			Number  n = (Number) jo.get(s);
			double d = n.doubleValue();
			map.put((String) s, new Double(d)); 
		}
		
	}

	/**
	 * Get the ethical system for this agent.
	 * @return
	 */
	public Principle getEthicalPrinciple() {
		if (ethical_system == UTILITARIAN) {
			return new UtilitarianPrinciple();
		} else if (ethical_system == KANTIAN) {
			return new KantianHumanityPrincipleReading1();
		} else {
			return new DoubleEffectPrinciple();
		}
	}
	
	/**
	 * Set the ethical principle for this agent.
	 * @param principle
	 */
	public void setEthicalPrinciple(int principle) {
		ethical_system = principle;
	}
	
	/**
	 * Set the chosen action.
	 * @param a
	 */
	public void setAction(FormulaString a) {
		action = a;
	}
	
	/**
	 * Get the chosen action.
	 * @return
	 */
	public FormulaString getAction() {
		return action;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.AILAgent#configure(ail.util.AILConfig)
	 */
	@Override
	public void configure(AILConfig c) {
		if (c.containsKey("hera.principle")) {
			Object principle = c.get("hera.principle");
			String principle_string = principle.toString();
			if (principle_string.equals("utilitarian")) {
				setEthicalPrinciple(UTILITARIAN);
			} else if (principle_string.equals("kantian")) {
				setEthicalPrinciple(KANTIAN);
			} else {
				setEthicalPrinciple(DOUBLE_EFFECT);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.AILAgent#toString()
	 */
	@Override
 	public String toString() {
 		StringBuilder is = new StringBuilder();
 		if (getIntention() != null) {
 				is.append(getIntention().toString());
 		}
 		
 		StringBuilder s1 = new StringBuilder();
 		s1.append(getAgName());
 		s1.append("\n=============\n");
 		s1.append("After Stage ");
 		s1.append(RC.getStage().getStageName()); 
 		s1.append(" :\n");
 		s1.append(getBB().toString());
 		s1.append("\n");
		s1.append(getHeraGoalBase().toString());
 		s1.append("\n");
 		s1.append(getUtilities().toString());
 		s1.append("\n");
		s1.append(getAffects().toString());
		s1.append("\n");
		if (action != null) {
			s1.append(getAction().toString());
		} else {
			s1.append("NULL");
		}
		String s = s1.toString();
 		return s;
 	}


}
