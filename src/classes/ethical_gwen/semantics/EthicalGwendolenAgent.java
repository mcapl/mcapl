// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis, Michael Fisher, Marija Slavkovik and Matt Webster
// 
// This file is part of Ethical Gwendolen
//
// Ethical Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Ethical Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package ethical_gwen.semantics;

import gwendolen.semantics.GwendolenAgent;

import ethical_gwen.syntax.Ethic;
import ethical_gwen.syntax.annotation.EthicsAnnotation;
import ethical_gwen.syntax.MixedRule;

import ail.mas.MAS;
import ail.util.AILexception;
import ail.syntax.ApplicablePlan;
import ail.syntax.Event;
import ail.syntax.GBelief;
import ail.syntax.Guard;
import ail.syntax.Intention;
import ail.syntax.Plan;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Rule;
import ail.syntax.Unifier;
import ail.syntax.Predicate;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Term;
import ail.syntax.NumberTermImpl;
import ail.syntax.BeliefBase;
import ail.syntax.Literal;
import ail.syntax.StringTermImpl;
import ail.syntax.annotation.SourceAnnotation;
import ail.util.MergeIterator;
import ajpf.psl.MCAPLFormula;
import ajpf.psl.MCAPLPredicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class EthicalGwendolenAgent extends GwendolenAgent {
	Map<GBelief, Set<Ethic>> ethics = new HashMap<GBelief, Set<Ethic>>();
	
	public EthicalGwendolenAgent(MAS mas, String name) throws AILexception {
		super(mas, name);
		setTrackPlanUsage(true);
		setReasoningCycle(new EthicalGwendolenRC());
		addBeliefBase(new BeliefBase(), "plan_selection");
		addBeliefBase(new BeliefBase(), "applicable_plans");
		addBeliefBase(new BeliefBase(), "ethics");

	}
	
	/**
	 * Add a rule to the rule base.
	 * @param r
	 */
	public void addRule(Rule r) {
		MixedRule mr = new MixedRule(r);
		mr.addEBs(this);
		getRuleBase().add(mr);
	}


    public EthicalGwendolenAgent(String name) throws AILexception {
		super(name);
		setTrackPlanUsage(true);
		setReasoningCycle(new EthicalGwendolenRC());
		addBeliefBase(new BeliefBase(), "plan_selection");
		addBeliefBase(new BeliefBase(), "applicable_plans");
		addBeliefBase(new BeliefBase(), "ethics");

	}
	
	public void addEthic(Ethic e) {
		if (ethics.containsKey(e.getContext())) {
			ethics.get(e.getContext()).add(e);
		} else {
			HashSet<Ethic> eset = new HashSet<Ethic>();
			eset.add(e);
			ethics.put(e.getContext(), eset);
		}
	}
	
    /**
     * Overridable function for scoring a plan.  By default, if trackplanusage
     * is enabled, this gives the highest score to the plan which has been
     * considered most often, but not chosen.
     * @param p
     * @return
     */
	protected int scoreplan(ApplicablePlan p) {
		return ethicalScore(p);
	}
	
    public ApplicablePlan choosePlan(Iterator<ApplicablePlan> aps, Intention inte) {
    	ApplicablePlan candidate = null;
		
    	while(aps.hasNext()) {
    		ApplicablePlan p = aps.next();
    		if (candidate == null) {
    			candidate = p;
    		} else {
    			boolean value = compareEthics(p, candidate);
    			if (value) {
    				candidate = p;
    			}
    		}
    	}
			
    	updatePlanUsage(candidate);
    	return candidate;
     }

	
	/**
     * Filter out plans from a list of applicable plans.  Identity unless over-ridden.
     * 
     * @param aps A linked list of applicable plans.
     * @return A linked list of applicable plans from which some may have been
     *         filtered.
     */
   public Iterator<ApplicablePlan> filterPlans(Iterator<ApplicablePlan> aps) {
	   getBB("applicable_plans").clear();
	   getBB("ethics").clear();

	   ArrayList<ApplicablePlan> pl = new ArrayList<ApplicablePlan>();
	   
	   while (aps.hasNext()) {
		   ApplicablePlan p = aps.next();
		   Literal applicable = new Literal("applicable");
		   applicable.addTerm(new StringTermImpl(p.keyString()));
		   addBel(applicable, BeliefBase.TSelf, "applicable_plans");
		   
		   int idnum = p.getID();
		   String library = p.getLib();
		   Plan plan = getPL(library).getPlanbyID(idnum);
		   if (plan != null ) {
			   EthicsAnnotation e = (EthicsAnnotation) plan.getAnnotation();
			   if (e != null ) {
				   for (Term ethic : e.getEthics()) {
					   Literal pred = new Literal("ethics_of");
					   pred.addTerm(new StringTermImpl(p.keyString()));
					   pred.addTerm(ethic);
					   addBel(pred, BeliefBase.TSelf, "ethics");
				   }
			   }
		   }

		   
		   
		   if (p.getID() != 0 && generated.containsKey(p.keyString())) {
			   
		   } else {
			   pl.add(p);
		   }
	   }
	   return pl.iterator();
    }
   
	/**
	 * Overridable method which decides which plans are relevant to a trigger
	 * event.
	 * @param ple
	 * @return
	 */
	public Iterator<ApplicablePlan> getAllRelevantPlans(Event ple) {
		Iterator<ApplicablePlan> pl = getPL().getAllRelevant(ple.getPredicateIndicator(), this);
		if (plmap.containsKey(ple.toString())) {
			return new MergeIterator<ApplicablePlan>(pl, getPL(ple.toString()).getAllRelevant(ple.getPredicateIndicator(), this));
		}
		return pl;
	}
	
	public void clearPlanLibrary(String s) {
		plmap.remove(s);
	}



	public ListTerm getCurrentPolicy() {
		ListTermImpl l = new ListTermImpl();
		for (GBelief g: ethics.keySet()) {
			if (this.believesyn(new Guard(g), new Unifier())) {
				for (Ethic e: ethics.get(g)) {
					l.add(e.getEthic());
				}
			}
		}
		return l;
	}
	
	public Set<Ethic> getEthics(GBelief g) {
		return ethics.get(g);
	}
	
	
	public int ethicalScore(ApplicablePlan p) {
		int idnum = p.getID();
		String library = p.getLib();
		if (library != null) {
			Plan plan = getPL(library).getPlanbyID(idnum);
			if (plan != null) {
				EthicsAnnotation ea = (EthicsAnnotation) plan.getAnnotation();
				if (ea != null) {
					ListTerm ethics = ea.getEthics();
					return scoreEthics(ethics);
				}
			}
		}
		return 0;
	}
	
	public boolean compareEthics(ApplicablePlan newplan, ApplicablePlan oldplan) {
		int np_idnum = newplan.getID();
		String np_library = newplan.getLib();
		Plan np = getPL(np_library).getPlanbyID(np_idnum);
		int op_idnum = oldplan.getID();
		String op_library = oldplan.getLib();
		Plan op = getPL(op_library).getPlanbyID(op_idnum);
		
		if (np != null & op == null) {
			return false;
		}
		
		if (newplan == null) {
			return false;
		}
		
		EthicsAnnotation npe = (EthicsAnnotation) np.getAnnotation();
		EthicsAnnotation ope = (EthicsAnnotation) op.getAnnotation();
		if (npe != null & ope == null) {
			return false;
		}
		
		if (npe == null) {
			return true;
		}
		
		ListTerm n_eth_list = npe.getEthics();
		ListTerm o_eth_list = ope.getEthics();
		ListTerm n_noto_eths = new ListTermImpl();
		ListTerm o_notn_eths = new ListTermImpl();
		
		for (Term t: n_eth_list) {
			if (! o_eth_list.contains(t)) {
				n_noto_eths.add(t);
			}
		}
		
		for (Term t: o_eth_list) {
			if (! n_eth_list.contains(t)) {
				o_notn_eths.add(t);
			}
		}
		
		int nscore = scoreEthics(n_noto_eths);
		int oscore = scoreEthics(o_notn_eths);
		
		return (oscore > nscore);
		
	}
	
	public void score(Term eths, Term score, Unifier u) {
		ListTerm eth_list = (ListTerm) eths;
		int current_score = scoreEthics(eth_list);
		u.unifies(score, new NumberTermImpl(current_score));
		
	}
	
	public int scoreEthics(ListTerm eths) {
		Object[] ethic_array = eths.toArray();
		HashSet<Predicate> eth_set = new HashSet<Predicate>();
		int current_score = 0;
		boolean start = true;
		for (Object o : ethic_array) {
			Predicate e = (Predicate) o;
			eth_set.add(e);
		}
		for (GBelief g: ethics.keySet()) {
			if (this.believesyn(new Guard(g), new Unifier())) {
				for (Ethic e: ethics.get(g)) {
					if (eth_set.contains(e.getEthic())) {
						if (start || e.getScore() > current_score) {
							current_score = e.getScore();
							start = false;
						}
					}
				}
			}
		}
		return current_score;
	} 
	
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
 		s1.append(getBB("ethics").toString());
 		s1.append("\n");
 		s1.append(getBB("plan_selection").toString());
 		s1.append("\n");
 		s1.append(getBB("applicable_plans").toString());
 		s1.append("\n");
 		s1.append(getOutbox().toString());
 		s1.append("\n");
		s1.append(is);
		s1.append("\n");
		s1.append(Is);
		s1.append("\n");
		s1.append(getPL());
		String s = s1.toString();
 		return s;
	}
	
	public boolean MCAPLbelieves(MCAPLFormula fmla) {
		if (! super.MCAPLbelieves(fmla)) {
			GBelief  gb = new GBelief(new Literal(Literal.LPos, new PredicatewAnnotation((MCAPLPredicate) fmla)));
			gb.setEB(new StringTermImpl("ethics"));
			Guard gu = new Guard(gb);
			Unifier un = new Unifier();
			if (! believesyn(gu, un)) {
				gb.setEB(new StringTermImpl("applicable_plans"));
				return believesyn(gu, un);
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	
}
