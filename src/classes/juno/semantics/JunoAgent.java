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
import ail.util.ComparableTuple;
import ail.util.Tuple;
import ajpf.MCAPLcontroller;
import ajpf.util.VerifyList;
import ajpf.util.VerifyMap;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.principles.DoubleEffectPrinciple;
import hera.principles.KantianHumanityPrincipleReading1;
import hera.principles.Principle;
import hera.principles.UtilitarianPrinciple;

public class JunoAgent extends AILAgent {
	VerifyList<String> actions = new VerifyList<String>();
	VerifyMap<String, Double> utilities = new VerifyMap<String, Double>();
	VerifyMap<String, Double> default_utilities = new VerifyMap<String, Double>();
	VerifyList<String> default_goals = new VerifyList<String>();
	VerifyList<String> patients = new VerifyList<String>();
	VerifyMap<String, VerifyList<ComparableTuple<String,String>>> default_affects = new VerifyMap<String, VerifyList<ComparableTuple<String, String>>>();
	String description = "No Description";
	VerifyList<String> consequences = new VerifyList<String>();
	VerifyList<String> background = new VerifyList<String>();
	VerifyMap<String, Formula> mechanisms = new VerifyMap<String, Formula>();
	//HashMap<String, ArrayList<String>> intentions = new HashMap<String, ArrayList<String>>();
	//HashMap<String, VerifyList<String>> goals = new HashMap<String, VerifyList<String>>();
	public VerifyList<String> goalbase = new VerifyList<String>();
	VerifyMap<String, VerifyList<ComparableTuple<String,String>>> affects = new VerifyMap<String, VerifyList<ComparableTuple<String, String>>>();
	VerifyList<ComparableTuple<Formula, FormulaString>> context_background = new VerifyList<ComparableTuple<Formula, FormulaString>>();
	VerifyMap<Formula, VerifyMap<String, Double>> context_utilities = new VerifyMap<Formula, VerifyMap<String, Double>>();
	VerifyMap<Formula, VerifyList<String>> context_goals = new VerifyMap<Formula, VerifyList<String>>();
	VerifyMap<Formula, VerifyMap<String, VerifyList<ComparableTuple<String,String>>>> context_affects = new VerifyMap<Formula, VerifyMap<String, VerifyList<ComparableTuple<String,String>>>>();
	
	public static int UTILITARIAN = 0;
	public static int DOUBLE_EFFECT = 1;
	public static int KANTIAN = 2;
	
	FormulaString action = null;
	
	public int ethical_system = UTILITARIAN;

	public JunoAgent(String file) {
		super();
		this.setAgName("juno");
		this.setReasoningCycle(new JunoRC());

		parseFromFile(file);
	}
	
	public void parseFromFile(String file) {
		JSONParser parser = new JSONParser();
		try {
			String abs_filename = MCAPLcontroller.getFilename(file);
			Object obj = parser.parse(new FileReader(abs_filename));
			JSONObject model = (JSONObject) obj;
			JSONArray actions = (JSONArray) model.get("actions");
			JSONArraytoVerifyListString(actions, this.actions);
			
			// Optional entries
			try {
				JSONObject utilities = (JSONObject) model.get("utilities");
				JSONObjecttoVerifyHashDouble(utilities, this.utilities);
				default_utilities = this.utilities;
				// System.err.println(this.utilities);
			} catch (Exception e) {
					
			}
				
			try {
				JSONArray patients = (JSONArray) model.get("patients");
				if (patients != null) {
						JSONArraytoVerifyListString(patients, this.patients);
				}
			} catch (Exception e) {
					
			}
			
			try {
				JSONArray consequences = (JSONArray) model.get("consequences");
				JSONArraytoVerifyListString(consequences, this.consequences);
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject mechanisms = (JSONObject) model.get("mechanisms");
				System.err.println("AAA");
				for (Object s: mechanisms.keySet()) {
					System.err.println(s);
					String v = (String) mechanisms.get(s);
					this.mechanisms.put((String) s, (Formula) new FormulaString("tmp").fromString(v));
				}
			} catch (Exception e) {
				
			}
			
			// try {
			//	JSONObject intentions = (JSONObject) model.get("intentions");
			//	JSONObjecttoHashList(intentions, this.intentions);
			//} catch (Exception e) {
			//	
			//}

			try {
				JSONArray goalbase = (JSONArray) model.get("goalbase");
				JSONArraytoVerifyListString(goalbase, this.goalbase);
				default_goals = this.goalbase;
				// JSONObject goals = (JSONObject) model.get("goals");
				// if (goals != null) {
				// 	JSONObjecttoHashList(goals, this.goals);
				// }
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject affects = (JSONObject) model.get("affects");
				if (affects != null) {
					for (Object s: affects.keySet()) {
						JSONArray list = (JSONArray) affects.get(s);
						VerifyList<ComparableTuple<String, String>> arrayl = new VerifyList<ComparableTuple<String,String>>();
						for (Object o: list) {
							JSONArray tuple = (JSONArray) o;
							ComparableTuple<String, String> new_tuple = new ComparableTuple<String, String>((String) tuple.get(0), (String) tuple.get(1));
							arrayl.add(new_tuple);
						}
						this.affects.put((String) s, arrayl); 
						
					}
				}
				default_affects = this.affects;
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject context_background = (JSONObject) model.get("context_background");
				if (context_background != null) {
					for (Object s: context_background.keySet()) {
						String v = (String) context_background.get(s);
						this.context_background.add(new ComparableTuple((Formula) new FormulaString("tmp").fromString((String) s), 
								                              (Formula) new FormulaString("tmp").fromString(v)));
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
						VerifyMap<String, VerifyList<ComparableTuple<String,String>>> affects_for_context = new VerifyMap<String, VerifyList<ComparableTuple<String, String>>>();
						JSONObject affs = (JSONObject) context_affects.get(s);
						for (Object s1: affs.keySet()) {
							JSONArray list = (JSONArray) affs.get(s1);
							VerifyList<ComparableTuple<String, String>> arrayl = new VerifyList<ComparableTuple<String,String>>();
							for (Object o: list) {
								JSONArray tuple = (JSONArray) o;
								ComparableTuple<String, String> new_tuple = new ComparableTuple<String, String>((String) tuple.get(0), (String) tuple.get(1));
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
						VerifyList<String> gs = new VerifyList<String>();
						JSONArraytoVerifyListString(v, gs);
						this.context_goals.put((Formula) new FormulaString("tmp").fromString((String) s), gs);
					}
				}
			} catch (Exception e) {
				
			}
					

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}


		
	}
	
	public VerifyList<String> getHeraActions() {
		return actions;
	}
	
	public VerifyMap<Formula, VerifyMap<String, Double>> getContextUtilities() {
		return context_utilities;
	}
	
	public VerifyMap<Formula, VerifyList<String>> getContextGoals() {
		return context_goals;
	}
	
	public VerifyMap<Formula, VerifyMap<String, VerifyList<ComparableTuple<String, String>>>> getContextAffects() {
		return context_affects;
	}
	
	public void setUtilities(VerifyMap<String, Double> utilities) {
		this.utilities = utilities;
	}
	
	public void setUtility(String s, Double u) {
		this.utilities.put(s, u);
	}
	
	public void setGoals(VerifyList<String>  goals) {
		this.goalbase = goals;
	}
	
	public void setNewGoal(String goal) {
		this.goalbase.add(goal);
	}
	
	public void setAffects(VerifyMap<String, VerifyList<ComparableTuple<String, String>>> affs) {
		this.affects = affs;
	}
	
	public void setAffect(String s, VerifyList<ComparableTuple<String, String>> affs) {
		this.affects.put(s, affs);
	}
	
	public void removeAffect(String s) {
		if (affects.keySet().contains(s)) {
			affects.remove(s);
		}
	}
	
	public VerifyMap<String, Double> defaultUtilities() {
		VerifyMap<String, Double> us_clone = new VerifyMap<String, Double>();
		for (String s: default_utilities.keySet()) {
			us_clone.put(s, default_utilities.get(s));
		}
		return us_clone;
	}
	
	public VerifyList<String> defaultGoals() {
		VerifyList<String> g_clone = new VerifyList<String>();
		for (String s: default_goals) {
			g_clone.add(s);
		}
		return g_clone;
	}

	public VerifyMap<String, VerifyList<ComparableTuple<String,String>>> defaultAffects() {
		VerifyMap<String, VerifyList<ComparableTuple<String,String>>> us_clone = new VerifyMap<String, VerifyList<ComparableTuple<String,String>>>();
		for (String s: default_affects.keySet()) {
			VerifyList<ComparableTuple<String, String>> aff_list = default_affects.get(s);
			VerifyList<ComparableTuple<String, String>> new_aff_list = new VerifyList<ComparableTuple<String, String>>();
			for (ComparableTuple<String, String> t: aff_list) {
				new_aff_list.add(new ComparableTuple(t.getLeft(), t.getRight()));
			}
			us_clone.put(s, new_aff_list);
		}
		return us_clone;
	}

	public VerifyMap<String, Double> getUtilities() {
		return this.utilities;
	}
	
	public VerifyList<String> getPatients() {
		return this.patients;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public VerifyList<String> getConsequences() {
		return this.consequences;
	}
	
	public VerifyList<String> getBackground() {
		return this.background;
	}
	
	public VerifyMap<String, Formula> getMechanisms() {
		return this.mechanisms;
	}
	
	// public HashMap<String, ArrayList<String>> getHeraIntentions() {
	//	return this.intentions;
	// }
	
	// public HashMap<String, VerifyList<String>> getHeraGoals() {
	// 	return this.goals;
	// }
	
	public VerifyList<String> getHeraGoalBase() {
		return this.goalbase;
	}
	
	public VerifyMap<String, VerifyList<ComparableTuple<String, String>>> getAffects() {
		return this.affects;
	}
	
	public VerifyList<ComparableTuple<Formula, FormulaString>> getContextBackground() {
		return context_background;
	}
	
	public void clearBackground() {
		background = new VerifyList<String>();
	}
	
	public void addToBackground(FormulaString s) {
		background.add(s.getString());
	}
	
	private void JSONArraytoArrayListString(JSONArray ja, ArrayList<String> a) {
		for (Object s: ja) {
			String constant = (String) s;
			a.add(constant);
		}
		
	}
	
	private <T> void JSONObjecttoHashDouble(JSONObject jo, HashMap<String, Double> map) {
		Set<Object> keySet = (Set<Object>) jo.keySet();
		for (Object s: keySet) {
			Number  n = (Number) jo.get(s);
			double d = n.doubleValue();
			map.put((String) s, new Double(d)); 
		}
		
	}
	
	private <T> void JSONObjecttoHashList(JSONObject jo, HashMap<String, ArrayList<T>> a) {
		Set<Object> keySet = (Set<Object>) jo.keySet();
		for (Object s: keySet) {
			JSONArray list = (JSONArray) jo.get(s);
			ArrayList<T> arrayl = new ArrayList<T>();
			for (Object o: list) {
				arrayl.add((T) o);
			}
			a.put((String) s, arrayl); 
		}
	
	}
	
	private void JSONArraytoVerifyListString(JSONArray ja, VerifyList<String> a) {
		for (Object s: ja) {
			String constant = (String) s;
			a.add(constant);
		}
		
	}
	
	private void JSONArraytoVerifyListFormula(JSONArray ja, VerifyList<Formula> a) {
		for (Object s: ja) {
			Formula constant = new FormulaString(s.toString());
			a.add(constant);
		}
		
	}
	
	private <T> void JSONObjecttoVerifyHashDouble(JSONObject jo, VerifyMap<String, Double> map) {
		Set<Object> keySet = (Set<Object>) jo.keySet();
		for (Object s: keySet) {
			Number  n = (Number) jo.get(s);
			double d = n.doubleValue();
			map.put((String) s, new Double(d)); 
		}
		
	}


	
	public Principle getEthicalPrinciple() {
		if (ethical_system == UTILITARIAN) {
			return new UtilitarianPrinciple();
		} else if (ethical_system == KANTIAN) {
			return new KantianHumanityPrincipleReading1();
		} else {
			return new DoubleEffectPrinciple();
		}
	}
	
	public void setEthicalPrinciple(int principle) {
		ethical_system = principle;
	}
	
	public void setAction(FormulaString a) {
		action = a;
	}
	
	public FormulaString getAction() {
		return action;
	}
	
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
