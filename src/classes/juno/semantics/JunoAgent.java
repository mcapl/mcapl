package juno.semantics;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ail.semantics.AILAgent;
import ail.util.Tuple;
import ajpf.MCAPLcontroller;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.principles.DoubleEffectPrinciple;
import hera.principles.KantianHumanityPrincipleReading1;
import hera.principles.Principle;
import hera.principles.UtilitarianPrinciple;

public class JunoAgent extends AILAgent {
	ArrayList<String> actions = new ArrayList<String>();
	HashMap<String, Double> utilities = new HashMap<String, Double>();
	HashMap<String, Double> default_utilities = new HashMap<String, Double>();
	ArrayList<String> patients = new ArrayList<String>();
	String description = "No Description";
	ArrayList<String> consequences = new ArrayList<String>();
	ArrayList<String> background = new ArrayList<String>();
	HashMap<String, Formula> mechanisms = new HashMap<String, Formula>();
	HashMap<String, ArrayList<String>> intentions = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> goals = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<Tuple<String,String>>> affects = new HashMap<String, ArrayList<Tuple<String, String>>>();
	ArrayList<Tuple<Formula, FormulaString>> context_background = new ArrayList<Tuple<Formula, FormulaString>>();
	HashMap<Formula, HashMap<String, Double>> context_utilities = new HashMap<Formula, HashMap<String, Double>>();
	
	static int UTILITARIAN = 0;
	static int DOUBLE_EFFECT = 1;
	static int KANTIAN = 2;
	
	FormulaString action;
	
	int ethical_system = UTILITARIAN;

	public JunoAgent(String file) {
		super();
		this.setAgName("juno");
		this.setReasoningCycle(new JunoRC());
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
					this.mechanisms.put((String) s, (Formula) Formula.fromString(v));
				}
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject intentions = (JSONObject) model.get("intentions");
				JSONObjecttoHashList(intentions, this.intentions);
			} catch (Exception e) {
				
			}

			try {
				JSONObject goals = (JSONObject) model.get("goals");
				if (goals != null) {
					JSONObjecttoHashList(goals, this.goals);
				}
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
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject context_background = (JSONObject) model.get("context_background");
				if (context_background != null) {
					for (Object s: context_background.keySet()) {
						String v = (String) context_background.get(s);
						this.context_background.add(new Tuple((Formula) Formula.fromString((String) s), 
								                              (Formula) Formula.fromString(v)));
					}
				}
			} catch (Exception e) {
				
			}
			
			try {
				JSONObject context_utilities = (JSONObject) model.get("context_utilities");
				if (context_utilities != null) {
					for (Object s: context_utilities.keySet()) {
						HashMap<String, Double> utilities_for_context = new HashMap<String, Double>();
						JSONObjecttoHashDouble((JSONObject) context_utilities.get(s), utilities_for_context);
						this.context_utilities.put((Formula) Formula.fromString((String) s), utilities_for_context);
					}
				}
			} catch (Exception e) {
				
			}
					

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}




	}
	
	public ArrayList<String> getHeraActions() {
		return actions;
	}
	
	public HashMap<Formula, HashMap<String, Double>> getContextUtilities() {
		return context_utilities;
	}
	
	public void setUtilities(HashMap<String, Double> utilities) {
		this.utilities = utilities;
	}
	
	public void setUtility(String s, Double u) {
		this.utilities.put(s, u);
	}
	
	public HashMap<String, Double> defaultUtilities() {
		return default_utilities;
	}
	
	public HashMap<String, Double> getUtilities() {
		return this.utilities;
	}
	
	public ArrayList<String> getPatients() {
		return this.patients;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public ArrayList<String> getConsequences() {
		return this.consequences;
	}
	
	public ArrayList<String> getBackground() {
		return this.background;
	}
	
	public HashMap<String, Formula> getMechanisms() {
		return this.mechanisms;
	}
	
	public HashMap<String, ArrayList<String>> getHeraIntentions() {
		return this.intentions;
	}
	
	public HashMap<String, ArrayList<String>> getHeraGoals() {
		return this.goals;
	}
	
	public HashMap<String, ArrayList<Tuple<String, String>>> getAffects() {
		return this.affects;
	}
	
	public ArrayList<Tuple<Formula, FormulaString>> getContextBackground() {
		return context_background;
	}
	
	public void clearBackground() {
		background = new ArrayList<String>();
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
	
	public Principle getEthicalPrinciple() {
		if (ethical_system == UTILITARIAN) {
			return new UtilitarianPrinciple();
		} else if (ethical_system == KANTIAN) {
			return new KantianHumanityPrincipleReading1();
		} else {
			return new DoubleEffectPrinciple();
		}
	}
	
	public void setAction(FormulaString a) {
		action = a;
	}
	
	public FormulaString getAction() {
		return action;
	}

}
