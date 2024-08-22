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

import ail.util.Tuple;
import hera.language.Causes;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.language.Gt;
import hera.language.IntegerTerm;
import hera.language.Not;
import hera.language.U;
import hera.principles.Principle;

public class CausalModel extends Model {
		protected ArrayList<String> actions = new ArrayList<String>();
		protected HashMap<String, Double> utilities = new HashMap<String, Double>();
		protected ArrayList<String> patients = new ArrayList<String>();
		protected String description = "No Description";
		protected ArrayList<String> consequences = new ArrayList<String>();
		protected ArrayList<String> background = new ArrayList<String>();
		protected HashMap<String, Formula> mechanisms = new HashMap<String, Formula>();
		public HashMap<String, ArrayList<String>> intentions = new HashMap<String, ArrayList<String>>();
		public HashMap<String, ArrayList<String>> goals = new HashMap<String, ArrayList<String>>();
		public ArrayList<String> goalbase = new ArrayList<String>();
		protected HashMap<String, ArrayList<Tuple<String,String>>> affects = new HashMap<String, ArrayList<Tuple<String, String>>>();
		protected HashMap<Formula, ArrayList<FormulaString>> network = new HashMap<Formula,ArrayList<FormulaString>>();
		public FormulaString action = new FormulaString("refrain");
		
		protected ArrayList<String> domainOfQuantification = new ArrayList<String>();
		public HashMap<Formula,Boolean> world;
		protected HashMap<Formula,Boolean> intervention = new HashMap<Formula,Boolean>();
		
		// In a bid to speed things up we introduce a cache of direct consequences of the world, so this is only called once on a model.
		ArrayList<Formula> directconsequencescache = null;
		
		/**
		 * Constructor used when called from a Juno Agent.
		 */
		protected CausalModel() {};

		/**
		 * Constructor from a json file.
		 * @param file
		 * @param world
		 */
		public CausalModel(String file, HashMap<Formula,Boolean> world) {
			JSONParser parser = new JSONParser();
			try {
				Object obj = parser.parse(new FileReader(file));
				JSONObject model = (JSONObject) obj;
				JSONArray actions = (JSONArray) model.get("actions");
				JSONArraytoArrayListString(actions, this.actions);
				
				// Optional entries
				try {
					JSONObject utilities = (JSONObject) model.get("utilities");
					JSONObjecttoHashDouble(utilities, this.utilities);
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
					description = (String) model.get("description");
				} catch (Exception e) {}
				
				try {
					JSONArray consequences = (JSONArray) model.get("consequences");
					JSONArraytoArrayListString(consequences, this.consequences);
				} catch (Exception e) {
					
				}

				try {
					JSONArray background = (JSONArray) model.get("background");
					JSONArraytoArrayListString(background, this.background);
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
		
		/**
		 * Set the model's utilities.
		 * @param u
		 */
		public void setUtilities(HashMap<String, Double> u) {
			utilities = u;
		}
		
		/**
		 * Reset the model's intervention.  See Bentzen and Lindner's papers for an explanation
		 * 
		 */
		public void clearIntervention() {
			intervention = new HashMap<Formula, Boolean>();
		}
		
		/**
		 * Create the powerset of a list of formulae.
		 * @param i
		 * @return
		 */
		public Set<HashSet<Formula>> powerset(List<Formula> i) {
			HashSet<HashSet<Formula>> sets = new HashSet<HashSet<Formula>>();
			sets.add(new HashSet<Formula>());
			for (Formula s: i) {
				HashSet<HashSet<Formula>> newsets = new HashSet<HashSet<Formula>>();
				for (HashSet<Formula> set: sets) {
					newsets.add(set);
					@SuppressWarnings("unchecked") 
					HashSet<Formula> setcopy = (HashSet<Formula>) set.clone();
					setcopy.add(s);
					newsets.add(setcopy);
				}
				sets = newsets;
			}
			return sets;
		}
		
		/**
		 * Create an intervention that negates the variables in the parameter list.
		 * @param variables
		 */
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
		
		/**
		 * Given a list of variables reset their values in the current
		 * intervention to their original values.
		 * @param variables
		 */
		@SuppressWarnings("unchecked")
		public void setInterventionWithVariablesFixedToOriginal(Set<Formula> variables) {
			HashMap<Formula,Boolean> intervention_backup = (HashMap<Formula,Boolean>) intervention.clone();
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
		
		/**
		 * Add a causal link in the network between formula v and string k.
		 * Formula v is causal in bringing about k.
		 * @param v
		 * @param k
		 */
		@SuppressWarnings("unlikely-arg-type")
		public void _addToNetwork(Formula v, String k) {
			if (network.containsKey(v)) {
				FormulaString fsk = new FormulaString(k);

				if (! network.get(v).contains(fsk)) {
					network.get(v).add(fsk);
				}
			} else {
				network.put(v, new ArrayList<FormulaString>());
				network.get(v).add(new FormulaString(k));
			}
		}
		
		/**
		 * Create the model's causal network.
		 */
		public void _computeNetwork() {
			network = new HashMap<Formula, ArrayList<FormulaString>>();
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
		
		/**
		 * I there a path from a to b in the causal network?
		 * @param a
		 * @param b
		 * @param v is used to store interim positions on potential paths.
		 * @return
		 */
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
		
		/**
		 * Set the model's action.
		 */
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
		
		/**
		 * Calculate the direct consequences of the action in this model.
		 * @return
		 */
		public ArrayList<Formula> getDirectConsequences() {
			 if (directconsequencescache != null) {
			 	return directconsequencescache;
			 }
			ArrayList<Formula> cs = new ArrayList<Formula>();
			for (String c: consequences) {
				if (models(new Causes(action, new FormulaString(c)))) {
					cs.add(new FormulaString(c));
				}
				
				if (models(new Causes(action, new Not(new FormulaString(c))))) {
					cs.add(new Not(new FormulaString(c)));
				}
			}
			
			directconsequencescache = cs;
			return cs;
		}
		
		/**
		 * Calculate the direct bad consequences of the action in this model.
		 * @return
		 */
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
		
		/**
		 * Get all bad consequences in this model.
		 * @return
		 */
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
		
		/**
		 * Get all consequences true in this model.
		 * @return
		 */
		public Set<Formula> getAllConsequences() {
			Set<Formula> cs = new HashSet<Formula>();
			for (String c: consequences) {
				if (models(new FormulaString(c))) {
					cs.add(new FormulaString(c));
				} else {
					cs.add(new Not(new FormulaString(c)));
				}
			}
			return cs;
		}
		
		/**
		 * Is this model permissalbe according to principle p?
		 * @param p
		 * @return
		 */
		public int evaluate(Principle p) {
			p.init(this);
			int perm = p.permissible();
			return perm;
		}
		
		// Not at all sure this method is correct.  It's copied from Python implementation
		// but we've not used it.
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
				int p = ((CausalModel) w).evaluate(principle);
				prob_sum = prob_sum + w.probability;
				if (p == Principle.PERMISSIBLE) {
					prob_perm = prob_perm + w.probability;
				}
			}
			
			if (prob_sum > 0.0) {
				return prob_perm/prob_sum;
			}
			
			return null;
		}

		/**
		 * Getter for the mdoel's action.
		 * @return
		 */
		public FormulaString getAction() {
			return action;
		}
		
		/**
		 * Add a new goal to the model.
		 * @param s
		 */
		public void addGoal(String s) {
			ArrayList<String> goals = new ArrayList<String>();
			goals.add(s);
			this.goals.put(action.getString(), goals);
		}
		
		/**
		 * Add a new intention to the model.
		 * @param s
		 * @param cs
		 */
		public void setIntention(FormulaString s, ArrayList<String> cs) {
			intentions.put(s.getString(), cs); 
		}
		
		/**
		 * Clear the model's intentions.
		 */
		public void clearIntentions() {
			intentions = new HashMap<String, ArrayList<String>>();
		}
		
		/*
		 * (non-Javadoc)
		 * @see hera.semantics.Model#cacheFormula(boolean, hera.language.Formula)
		 */
		public void cacheFormula(boolean value, Formula f) {
			// Only cache a formula if the intervention is empty -- i.e., we are not
			// exploring some counterfactual
			if (intervention.isEmpty()) {
				if (value) {
					cache.add(f);
				} else {
					falsecache.add(f);
				}
			}
		}
		
		
		// Methods to assist with parsing in from json.  Some commented out because not needed.
		/* 
		private void JSONArraytoVerifyListString(JSONArray ja, VerifyList<String> a) {
			for (Object s: ja) {
				String constant = (String) s;
				a.add(constant);
			}
			
		} */
		
		private void JSONArraytoArrayListString(JSONArray ja, ArrayList<String> a) {
			for (Object s: ja) {
				String constant = (String) s;
				a.add(constant);
			}
			
		}

		/*
		private void JSONArraytoVerifyListFormula(JSONArray ja, VerifyList<Formula> a) {
			for (Object s: ja) {
				Formula constant = new FormulaString(s.toString());
				a.add(constant);
			}
			
		}*/
		
		@SuppressWarnings("unchecked")
		private <T> void JSONObjecttoHashDouble(JSONObject jo, HashMap<String, Double> map) {
			Set<Object> keySet = (Set<Object>) jo.keySet();
			for (Object s: keySet) {
				Number  n = (Number) jo.get(s);
				double d = n.doubleValue();
				map.put((String) s, new Double(d)); 
			}
			
		}
		
		/*
		private <T> void JSONObjecttoVerifyHashDouble(JSONObject jo, VerifyMap<String, Double> map) {
			Set<Object> keySet = (Set<Object>) jo.keySet();
			for (Object s: keySet) {
				Number  n = (Number) jo.get(s);
				double d = n.doubleValue();
				map.put((String) s, new Double(d)); 
			}
			
		} */

		@SuppressWarnings("unchecked")
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
		
		/* private <T extends Comparable<? super T>> void JSONObjecttoVerifyMapList(JSONObject jo, VerifyMap<String, VerifyList<T>> a) {
			Set<Object> keySet = (Set<Object>) jo.keySet();
			for (Object s: keySet) {
				JSONArray list = (JSONArray) jo.get(s);
				VerifyList<T> arrayl = new VerifyList<T>();
				for (Object o: list) {
					arrayl.add((T) o);
				}
				a.put((String) s, arrayl); 
			}
		
		} */

}
