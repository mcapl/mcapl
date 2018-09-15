// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Martin Mose Bentzen, Michael Fisher 
// 
// This file is part of HERA Java Implementation
// 
// HERA Java is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// HERA Java is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with HERA Java; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package hera.semantics;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ail.util.ComparableTuple;
import ail.util.Tuple;
import ajpf.util.VerifyList;
import ajpf.util.VerifyMap;
import hera.language.Causes;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.Gt;
import hera.language.IntegerTerm;
import hera.language.Not;
import hera.language.U;
import hera.principles.Principle;

public class CausalModel extends Model {
		protected VerifyList<String> actions = new VerifyList<String>();
		protected VerifyMap<String, Double> utilities = new VerifyMap<String, Double>();
		protected VerifyList<String> patients = new VerifyList<String>();
		protected String description = "No Description";
		protected VerifyList<String> consequences = new VerifyList<String>();
		protected VerifyList<String> background = new VerifyList<String>();
		protected VerifyMap<String, Formula> mechanisms = new VerifyMap<String, Formula>();
		public VerifyMap<String, VerifyList<String>> intentions = new VerifyMap<String, VerifyList<String>>();
		public VerifyMap<String, VerifyList<String>> goals = new VerifyMap<String, VerifyList<String>>();
		public VerifyList<String> goalbase = new VerifyList<String>();
		protected VerifyMap<String, VerifyList<ComparableTuple<String,String>>> affects = new VerifyMap<String, VerifyList<ComparableTuple<String, String>>>();
		protected VerifyMap<Formula, VerifyList<FormulaString>> network = new VerifyMap<Formula,VerifyList<FormulaString>>();
		public FormulaString action = new FormulaString("noactionyet");
		
		protected ArrayList<String> domainOfQuantification = new ArrayList<String>();
		public VerifyMap<Formula,Boolean> world;
		protected HashMap<Formula,Boolean> intervention = new HashMap<Formula,Boolean>();
		
		protected CausalModel() {};

		public CausalModel(String file, VerifyMap<Formula,Boolean> world) {
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader(file));
				JSONObject model = (JSONObject) obj;
				JSONArray actions = (JSONArray) model.get("actions");
				JSONArraytoVerifyListString(actions, this.actions);
				
				// Optional entries
				try {
					JSONObject utilities = (JSONObject) model.get("utilities");
					JSONObjecttoVerifyHashDouble(utilities, this.utilities);
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
					description = (String) model.get("description");
				} catch (Exception e) {}
				
				try {
					JSONArray consequences = (JSONArray) model.get("consequences");
					JSONArraytoVerifyListString(consequences, this.consequences);
				} catch (Exception e) {
					
				}

				try {
					JSONArray background = (JSONArray) model.get("background");
					JSONArraytoVerifyListString(background, this.background);
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
				
				_computeNetwork();

				try {
					JSONObject intentions = (JSONObject) model.get("intentions");
					JSONObjecttoVerifyMapList(intentions, this.intentions);
				} catch (Exception e) {
					
				}

				try {
					// JSONArray goalbase = (JSONArray) model.get("goalbase");
					// JSONArraytoArrayListString(goalbase, this.goalbase);
					JSONObject goals = (JSONObject) model.get("goals");
					if (goals != null) {
					 	JSONObjecttoVerifyMapList(goals, this.goals);
					}
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
				} catch (Exception e) {
					
				}
				
				domainOfQuantification.addAll(this.actions);
				domainOfQuantification.addAll(consequences);
				domainOfQuantification.addAll(background);
				domainOfQuantification.addAll(patients);
				this.world = world;
				checker = new CausalModelChecker();
				_setAction();
				

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		public void setUtilities(VerifyMap<String, Double> u) {
			utilities = u;
		}
		
		public void clearIntervention() {
			intervention = new HashMap<Formula, Boolean>();
		}
		
		public Set<HashSet<Formula>> powerset(List<Formula> i) {
			HashSet<HashSet<Formula>> sets = new HashSet<HashSet<Formula>>();
			sets.add(new HashSet<Formula>());
			for (Formula s: i) {
				HashSet<HashSet<Formula>> newsets = new HashSet<HashSet<Formula>>();
				for (HashSet<Formula> set: sets) {
					newsets.add(set);
					HashSet<Formula> setcopy = (HashSet<Formula>) set.clone();
					setcopy.add(s);
					newsets.add(setcopy);
				}
				sets = newsets;
			}
			return sets;
		}
		
		public void setFlippedIntervention(List<Formula> variables) {
			for (Formula variable: variables) {
				boolean currValue = models(variable);
				if (variable instanceof FormulaString) {
					intervention.put(variable, (Boolean) !(currValue));
				} else if (variable instanceof Not) {
					intervention.put(((Not) variable).f1, (Boolean) currValue);
				}
			}
		}
		
		public void setInterventionWithVariablesFixedToOriginal(Set<Formula> variables) {
			VerifyMap<Formula,Boolean> intervention_backup = (VerifyMap<Formula,Boolean>) intervention.clone();
			HashMap<Formula,Boolean> intervention_new = new HashMap<Formula,Boolean>();
			clearIntervention();
			for (Formula v: variables) {
				boolean currValue = models(v);
				if (v instanceof FormulaString) {
					intervention_new.put(v, (Boolean) currValue);
				} else if (v instanceof Not) {
					intervention_new.put(v, (Boolean) (!currValue));
				}
			}
			intervention.putAll(intervention_backup);
			intervention.putAll(intervention_new);
		}
		
		public void setNewIntervention(ArrayList<Formula> intervention) {
			clearIntervention();
			for (Formula v: intervention) {
				if (v instanceof FormulaString) {
					this.intervention.put(v, Boolean.TRUE);
				} else if (v instanceof Not) {
					this.intervention.put(v.f1, Boolean.FALSE);
				}
			}
		}
		
		public void _addToNetwork(Formula v, String k) {
			if (network.containsKey(v)) {
				if (! network.get(v).contains(k)) {
					network.get(v).add(new FormulaString(k));
				}
			} else {
				network.put(v, new VerifyList<FormulaString>());
				network.get(v).add(new FormulaString(k));
			}
		}
		
		public void _computeNetwork() {
			network = new VerifyMap<Formula, VerifyList<FormulaString>>();
			for (String k: mechanisms.keySet()) {
				Formula v = mechanisms.get(k);
				if (v instanceof FormulaString) {
					_addToNetwork(v, k);
				} else {
					ArrayList<Formula> parents = v.stripParentsFromMechanism();
					for (Formula p: parents) {
						_addToNetwork(p, k);
					}
				}
			}
		}
		
		public boolean path(ArrayList<Formula> a, Formula b, ArrayList<Formula> v) {
			if (a.contains(b)) {
				return true;
			}
			
			for (Formula x: a) {
				if (!v.contains(x)) {
					if (network.keySet().contains(x)) {
						a.addAll(network.get(x));
					}
					v.add(x);
					return path(a, b, v);
				}
			}
			
			return false;
		}
		
		public void _setAction() {
			boolean ok = false;
			for (String a: actions) {
				if (models(new FormulaString(a))) {
					action = new FormulaString(a);
					ok = true;
					break;
				}
			}
			if (!ok) {
				action = null;
			}
		}
		
		public ArrayList<Formula> getDirectConsequences() {
			ArrayList<Formula> cs = new ArrayList<Formula>();
			for (String c: consequences) {
				if (models(new Causes(action, new FormulaString(c)))) {
					cs.add(new FormulaString(c));
				}
				
				if (models(new Causes(action, new Not(new FormulaString(c))))) {
					cs.add(new Not(new FormulaString(c)));
				}
			}
			
			return cs;
		}
		
		public ArrayList<Formula> getDirectBadConsequences() {
			ArrayList<Formula> direct = getDirectConsequences();
			ArrayList<Formula> cs = new ArrayList<Formula>();
			for (Formula c: direct) {
				if (models(new Gt(new IntegerTerm(0), new U(c)))) {
					cs.add(c);
				}
			}
			return cs;
		}
		
		public ArrayList<Formula> getAllBadConsequences() {
			Set<Formula> cons = getAllConsequences();
			ArrayList<Formula> cs = new ArrayList<Formula>();
			for (Formula c: cons) {
				if (models(new Gt(new IntegerTerm(0), new U(c)))) {
					cs.add(c);
				}
			}
			return cs;
		}
		
		public Set<Formula> getAllConsequences() {
			Set<Formula> cs = new HashSet<Formula>();
			for (String c: consequences) {
				// System.err.println("AAA");
				if (models(new FormulaString(c))) {
					cs.add(new FormulaString(c));
				} else {
					cs.add(new Not(new FormulaString(c)));
				}
			}
			return cs;
		}
		
		public Boolean evaluate(Principle p) {
			p.init(this);
			try {
				boolean perm = p.permissible();
				return perm;
			} catch (NullPointerException e) {
				return null;
			}
		}
		
		public void __checkProbabilities(ArrayList<Model> k) {
			for (Model m:k) {
				if (probability != null) {
					__setDefaultProbabilities(k);
					return;
				}
			}
		}
		
		public void __setDefaultProbabilities(ArrayList<Model> k) {
			double prob = 1/k.size();
			for (Model m : k) {
				m.probability = prob;
			}
		}
		
		public Double degPerm(Principle principle) {
			ArrayList<Model> k_a = this.getEpistemicAlternatives(action);
			__checkProbabilities(k_a);
			double prob_sum = 0;
			double prob_perm = 0;
			for (Model w: k_a) {
				boolean p = ((CausalModel) w).evaluate(principle);
				prob_sum = prob_sum + w.probability;
				if (p) {
					prob_perm = prob_perm + w.probability;
				}
			}
			
			if (prob_sum > 0.0) {
				return prob_perm/prob_sum;
			}
			
			return null;
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
		private <T> void JSONObjecttoHashDouble(JSONObject jo, HashMap<String, Double> map) {
			Set<Object> keySet = (Set<Object>) jo.keySet();
			for (Object s: keySet) {
				Number  n = (Number) jo.get(s);
				double d = n.doubleValue();
				map.put((String) s, new Double(d)); 
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
		
		private <T extends Comparable<? super T>> void JSONObjecttoVerifyMapList(JSONObject jo, VerifyMap<String, VerifyList<T>> a) {
			Set<Object> keySet = (Set<Object>) jo.keySet();
			for (Object s: keySet) {
				JSONArray list = (JSONArray) jo.get(s);
				VerifyList<T> arrayl = new VerifyList<T>();
				for (Object o: list) {
					arrayl.add((T) o);
				}
				a.put((String) s, arrayl); 
			}
		
		}

		public FormulaString getAction() {
			return action;
		}
		
		public void addGoal(String s) {
			VerifyList<String> goals = new VerifyList<String>();
			goals.add(s);
			this.goals.put(action.getString(), goals);
		}
		
		public void setIntention(FormulaString s, VerifyList<String> cs) {
			intentions.put(s.getString(), cs); 
		}
		
		public void clearIntentions() {
			intentions = new VerifyMap<String, VerifyList<String>>();
		}
}
