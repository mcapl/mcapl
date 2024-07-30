// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package goal.semantics;

import goal.syntax.GOALBuiltInPrologRules;
import goal.syntax.ConjGoal;
import goal.syntax.ConjGoalBase;
import goal.syntax.GOALModule;
import goal.syntax.MentalState;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ArrayList;

import ail.mas.MAS;
import ail.util.AILexception;
import ail.semantics.AILAgent;
import ail.syntax.Intention;
import ail.syntax.BeliefBase;
import ail.syntax.Goal;
import ail.syntax.Guard;
import ail.syntax.Plan;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.Literal;
import ail.syntax.Rule;
import ail.syntax.Event;
import ail.syntax.Predicate;
import ail.syntax.StringTerm;
import ajpf.util.AJPFLogger;
import ail.syntax.annotation.SourceAnnotation;
import ail.syntax.AILAnnotation;
import ail.syntax.GoalBase;


/**
 * A GOAL Agent.  This assumes the semantics for GOAL with communication as developed by Hindriks and
 * van Riemsdijk from "A Computational Semantics for Communicating Rational Agents
 * Based on Mental Models", ProMAS'09, 2009.
 * 
 * @author louiseadennis
 *
 */
public class GOALAgent extends AILAgent { 
	
	public GOALModule mainModule;
	
	public GOALModule eventModule;
	
	public GOALModule initModule;
	
	private GOALModule.ModuleType topLevelContext = GOALModule.ModuleType.MAIN;
	
    /**
     * Stack of (non-anonymous) modules that have been entered and not yet
     * exited; last element on the list has been entered last.
     */
    public final LinkedList<GOALModule> activeStackOfModules = new LinkedList<>();
    
    public MentalState ms;

	// Specific library for conditional actions/Action Rules.  Separate from
	// the library of Capabilities/Action Specs.  Use to control plan selection.
	//PlanLibrary CondActions = new PlanLibrary(2);
	
	// Used to record the important aspects of the plan state from Goal's 
	// persepctive.  Used to control plan selection and application.
	//@FilterField
	//String lastplanstate = "";
	
	// The plans that have already been applied in this state.  Used to
	// force agents to sleep if there is nothing new to be done
	// at present.
	//public ArrayList<String> generatedthis = new ArrayList<String>();

	/**
	 * Construct a GOAL agent from an multi-agent system and a name.
	 * 
	 * @param mas the Multi-agent System.
	 * @param name te name of the agent.
	 */
	public GOALAgent(MAS mas, String name) throws AILexception {
		super(mas, name);
		setReasoningCycle(new GOALRC(this));
	    setGoalBase(new ConjGoalBase());
	    addBeliefBase(new BeliefBase(), "percepts");
	    addBeliefBase(new BeliefBase(), "messages");
		GOALBuiltInPrologRules prolog = new GOALBuiltInPrologRules();
		for (Predicate p: prolog.getFacts()) {
			addBel(new Literal(p), refertoself());
		}
		for (Rule r: prolog.getRules()) {
			addRule(r);
		}
			}
	
	public GOALAgent(String name) throws AILexception {
		super(name);
		setReasoningCycle(new GOALRC(this));
		setGoalBase(new ConjGoalBase());
	    addBeliefBase(new BeliefBase(), "percepts");
	    addBeliefBase(new BeliefBase(), "messages");
		GOALBuiltInPrologRules prolog = new GOALBuiltInPrologRules();
		for (Predicate p: prolog.getFacts()) {
			addBel(new Literal(p), refertoself());
		}
		for (Rule r: prolog.getRules()) {
			addRule(r);
		}
	}
	
	public GOALModule getMainModule() {
		return mainModule;
	}
	
	@Override
	public void initAg() {
		super.initAg();
		ms = new MentalState(getAgName());
		ms.addBB(getBB());
		ms.addGB((ConjGoalBase) getGoalBase());
		ms.addRB(getRuleBase());
		ms.addPerceptBase(getBB("percepts"));
		ms.addMessageBase(getBB("messages"));
		ms.setAgName(getAgName());
		((GOALRC) getReasoningCycle()).init(this);
	}
	
	@Override
	public void setAgName(String name) {
		super.setAgName(name);
		if (ms != null) {
			ms.setAgName(name);
		}
	}

	/**
     * Adds a belief to the default belief base annotating it with a source.
     * 
     */
    public void addBel(Literal bel, SourceAnnotation s) {
    	bel.addAnnot(s);   
    	getBB().add(bel);
    	ms.updateGoalState();
      }
        
    /**
     * Adds a belief to the belief base indexed by n.
     */
     public void addBel(Literal bel, Term s, String n) {
		if (n == "") {
			if (bel.negated()) {
				Literal belpos = (Literal) bel.clone();
				belpos.setNegated(true);
				getBB().remove(belpos);
			} else {
				getBB().add(bel);
			}
		} else {
		if (! bbmap.containsKey(n)) {
			BeliefBase bbnew = new BeliefBase();
			addBeliefBase(bbnew, n);
		}
		if (bel.negated()) {
			Literal belpos = (Literal) bel.clone();
			belpos.setNegated(true);
			getBB(n).remove(belpos);
		} else {
			getBB(n).add(bel);
		}
		}
		ms.updateGoalState();
    }
    
    /**
     * Adds a belief to the belief base indexed by n.
     */
    public boolean addBel(Literal bel, AILAnnotation s, StringTerm n) {
 		bel.addAnnot(s);   
		if (! bbmap.containsKey(n.getString()) && n.getString() != "") {
			BeliefBase bbnew = new BeliefBase();
			addBeliefBase(bbnew, n.getString());
		}
		boolean success = false;
		if (bel.negated()) {
			Literal belpos = (Literal) bel.clone();
			belpos.setNegated(true);
			success = getBB(n.getString()).remove(belpos);
				} else {
			success = getBB(n.getString()).add(bel);
		}
	   	ms.updateGoalState();
    	return success;
    }	  

    /**
     * Removes a belief from the belief base indexed by i.  Creates the belief base
     * if necessary.  This is creation is intended to assist model checking but
     * may well not be necessary.
     * @param bel
     * @param i
     */
    public void delBel(Literal bel, String i) {
    	if (i == "") {
    		getBB().remove(bel);
   	} else {
    		if (! bbmap.containsKey(i)) {
    			BeliefBase bbnew = new BeliefBase();
    			addBeliefBase(bbnew, i);
    		}
    		getBB(i).remove(bel);
    	}
       }
    
    public void adopt(ConjGoal g) {
    	ms.adopt(g);
      }
    
    @Override
    public boolean addGoal(Goal g) {
    	ConjGoal gl = new ConjGoal();
    	gl.addConj(g.getLogicalContent());
    	return ms.adopt(gl);
    }
 
    /**
     * Adds a goal to the goal base indexed by i.  This is done by
     * annotations on goals in intentions - messy but there you are.
     * @param g
     * @param i
     */
 /*   public void addGoal(Term g) {
    	Goal gl = new Goal((Literal) g, Goal.achieveGoal);
    	StringTerm i = gl.getGoalBase();
    	Intention intention = new Intention(new Event(Event.AILAddition, gl), new SourceAnnotation(new Predicate(i.toString())));
    	getIntentions().add(intention);
    	ms.updateGoalState();
      // 	getPL().addGoal(g, i);
    //	getPL("2").addGoal(g, i);
    }
    
    public void addGoal(Term g, StringTerm i) {
    	Goal gl = new Goal((Literal) g, Goal.achieveGoal);
    	gl.setGoalBase(i);
    	Intention intention = new Intention(new Event(Event.AILAddition, gl), new SourceAnnotation(new Predicate(i.toString())));
    	getIntentions().add(intention);
    	ms.updateGoalState();
   //   	getPL().addGoal(g, i);
    ////	getPL("2").addGoal(g, i);
    } */
    /**
     * Some goals are conjunctions, we split into conjuncts to determine
     * if all are believed.
     * @param g
     * @return
     */
/*    public boolean believesUnSplitGoal(Goal g) {
    	ArrayList<Goal> gls = splitgoals(g);
 //   	Guard gu = new Guard();
   // 	for (Goal g1: gls) {
    //		gu.add(new GBelief(GBelief.AILBel, g1.getLiteral()));
    	//}
    	
    	//return believesyn(gu, new Unifier());
    	return gls.isEmpty();
    } */
    
    /**
     * Remove all achieved goals from the agent.
     *
     */
 /*   public void removeachievedgoals() {
		Iterator<Goal> gi = super.getGoals();
		while (gi.hasNext()) {
			Goal g = gi.next();
			if (believesUnSplitGoal(g)) {
				removeGoal(g);
		//	   	getPL().delGoal(g);
		//    	getPL("2").delGoal(g);
			}
		}
    } */

    /**
     * Adds a plan from itself to the lbirary.
     * 
     * @param p The plan to be added.
     * @throws AILexception
     */
/*    public void addPlan(Plan p) throws AILexception {
    		p.setSource(refertoself());
    		AJPFLogger.finer("goal.semantics.GOALAgent", "Adding plan " + p.toString());
         	if (p instanceof ActionRule) {
        		getPL(condaction_libname).add(p); 
        		// CondActions.init(this);
        	 } else {
        		getPL().add(p);
        		// fPL.init(this);
        	 }  
    } */ 
    
    /**
     * Gets all reactive plans.  Returns either Action Rules or
     * Action Specifications, depending on the stage of the reasoning cycle.
     */
 /*   protected Iterator<ApplicablePlan> getAllReactivePlans(Event ple) {
    	if (getReasoningCycle().getStage().getStageName().equals("Transformer Function")) {
    		return getPL().getAllReactivePlans(this);
    	} else {
    		return getPL(condaction_libname).getAllReactivePlans(this);
    	}
	} */

    /**
     * Gets all plans relevant to a particular trigger.  Returns either Action Rules
     * or Actions Specifications, depending on the stage of the reasoning cycle.
     */
/*	protected Iterator<ApplicablePlan> getAllRelevantPlans(Event ple) {
    	if (ple.referstoGoal()) {
    		if (getReasoningCycle().getStage().getStageName().equals("Transformer Function")) {
    			return getPL().getAllRelevant(ple.getPredicateIndicator(), this);
    		} else {
       			return getPL(condaction_libname).getAllReactivePlans(this);
    		}
    	} else {
    		return getPL().getAllRelevant(ple.getPredicateIndicator(), this);
    	}
	} */

	
	/**
	 * Override filterplans to filter out Conditional Action plans if
	 * the current intention is a Capability and Capability plans if the
	 * current intention is Goal triggered.
	 */
/*	public ArrayList<ApplicablePlan> filterPlans(ArrayList<ApplicablePlan> aps) {
		ArrayList<ApplicablePlan> nq = new ArrayList<ApplicablePlan>();
		
		String s = this.toString();
		if (s.equals(lastplanstate)) {
			for (ApplicablePlan p : aps) {
				if (! generatedthis.contains(p.keyString())) {
					nq.add(p);
				}
			}
		} else {
			generatedthis.clear();
			lastplanstate = s;
			for (ApplicablePlan p : aps) {
					// generatedthis.add(p.keyString());
					nq.add(p);
			}
		}
		// System.out.println(generatedthis);

		return nq;

	} */
	
	/**
	 * Updates all the plan usage information.
	 */
/*	public void updatePlanUsage(ApplicablePlan p) {
		String s = this.toString();
		String ps = p.keyString();
		if (s.equals(lastplanstate)) {
			if (generatedthis.contains(ps)) {
				
			} else {
				generatedthis.add(ps);
			}
		} else {
			lastplanstate = s;
			generatedthis.add(p.keyString());
		}
		if (generated.get(ps) != null) {
			generated.put(ps, 0);
		}
	} */
	

	/**
	 * Return a list of goals obtained by splitting up goal conjunctions.
	 * @param g
	 * @return
	 */
/*	public ArrayList<Goal> splitgoals(Goal g) {
		ArrayList<Goal> goals = new ArrayList<Goal>();
		AJPFLogger.finest("goal.semantics.GOALAgent", "Attempting to Split: " + g.getFunctor());
		
		if (g.getFunctor().equals("and")) {
			AJPFLogger.finest("goal.semantics.GOALAgent", "Found a Goal to Split");
			Goal g1 = new Goal((Literal) g.getTerm(0), g.getGoalType());
			g1.setGoalBase(g.getGoalBase());
			ArrayList<Goal> gls1 = splitgoals(g1);
			Goal g2 = new Goal((Literal) g.getTerm(1), g.getGoalType());
			g2.setGoalBase(g.getGoalBase());
			ArrayList<Goal> gls2 = splitgoals(g2);
			goals.addAll(gls1);
			goals.addAll(gls2);
		} else {
			GBelief gb = new GBelief(GBelief.AILBel, g.getLiteral());
			gb.setDBnum(g.getGoalBase());
			Guard gu = new Guard(gb);
			
	    	
	    	if (! believesyn(gu, new Unifier())) {
	    		goals.add(g);
	    	}
		}
		
		return goals;
	} */
	
	/**
	 * Get all goals in the agent, as conjunctions where applicable.
	 * @return
	 */
	public Iterator<Goal> getUnSplitGoals() {
		return super.getGoals();
	}
	
	/**
	 * Get all atomic goals in the agent.
	 */
	public Iterator<Goal> getGoals() {
		Iterator<Goal> gl = super.getGoals(Goal.achieveGoal);
		ArrayList<Goal> ngl = new ArrayList<Goal>();
		
		while (gl.hasNext()) {
			Goal g = gl.next();
		}
		
		return ngl.iterator();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.semantics.AILAgent#goalEntails(ail.syntax.Event, ail.syntax.Plan, ail.semantics.Unifier)
	 */
	public boolean goalEntails(Event e, Plan p, Unifier un) {
			return e.unifies(p.getTriggerEvent(), un);
	}
	
	public void printagentstate() {
		String s1 = toString();
		AJPFLogger.fine("goal.semantics.GOALAgent", s1);
 	}
	
	public String toStringSpecial() {
		return "testing";
	}
	
	/*
 	 * (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
 	public String toString() {
 		// Use of StringBuffers for efficiency.  Use of Atomic because
 		// StringBuffers aren't thread safe.
 		/* Iterator<Goal> ig = getUnSplitGoals();
 		ArrayList<String> gstrings = new ArrayList<String>();
 		StringBuilder gs = new StringBuilder();
 		while (ig.hasNext()) {
 			Goal g = ig.next();
 			if (g.getGoalType() == Goal.achieveGoal) {
 				StringBuilder gstring = new StringBuilder();
 				gstring.append("G(");
  				gstring.append(g.getGoalBase().toString());
  				gstring.append(g.toString());
  				gstring.append(")\n");
 				gstrings.add(gstring.toString());
 			}
 			
 		} 
 		
 		Collections.sort(gstrings);
 		
 		for (String gsr: gstrings) {
 			gs.append(gsr);
 		} */
 		
 		StringBuilder s = new StringBuilder();
 		s.append(getAgName());
 		s.append(":\n");
 		s.append(ms.toString());
		if (I != null) {
			s.append(I.toString());
			s.append("\n");
		}
		String s1 = s.toString();
 		return s1;
 	} 
 	

 	/**
 	 * Get a string with more details about the internals of the agent.  Can be useful for debugging.
 	 * @return
 	 */
	public String detailsString() {
 		String is = "";
 		if (getIntention() != null) {
 				is = getIntention().toString();
 		}
 		
 		String s = "After Stage " + RC.getStage().getStageName() + " :" + getOutbox().toString() + "\n";
		s += getAgName() + ":" + is + "\n" + Is + "\n" + getPL() + "\n" + getPL("2") + "\n" + getRuleBase();
		return s;
 	}
	
    /**
     * Select an intention from a linked list of intentions.
     * 
     * @param intentions
     * @return the selected intention.
     */
  /*   public Intention selectIntention(Queue<Intention> intentions) {
        // make sure the selected Intention is removed from 'intentions'
        // and make sure no intention will "starve"!!!
    	ArrayList<Intention> iiprime = new ArrayList<Intention>();
 
    	for (Intention ip: intentions) {
    		if (!(ip == null) && ip.suspended()  || (!ip.empty() && ip.hdE().referstoGoal() && ip.hdE().getGoal().getGoalType() == Goal.achieveGoal)) {
     			iiprime.add(ip);
    		} 
    	}
        
    	for (Intention ip: iiprime) {
    		intentions.remove(ip);
    	}
    	
    	Intention i;
    	if (intentions.isEmpty()) {
    		i = iiprime.remove(0);
    	} else {
    		i = intentions.poll();
    	}
    	intentions.addAll(iiprime);

    	return i;
    } */
    
    public void sleep() {
//    	generatedthis.clear();
    	super.sleep();
    }
    
    /**
     * For controlling experiments in plan indexing algorithms
     * @param pitype
     */
 /*   public void setPlanIndexingType(int pitype) {
    	CondActions.setPlanIndexingType(pitype);
    	Iterator<Goal> gs = getGoals();
    	while (gs.hasNext()) {
    		Goal g = gs.next();
    		fPL.addGoal(g);
    		CondActions.addGoal(g);
    	}
    	
    	for (Literal l: fBB.getAll()) {
    		fPL.addBel(l);
    		CondActions.addBel(l);
    	}
    } */

    
    public boolean delBel(Literal bel) {
       	return super.delBel(bel);
     }

    public void noteAddedGoal(Goal g) {
   // 	getPL().addGoal(g);
   // 	getPL("2").addGoal(g);
    }
    
    
    public void addModule(GOALModule m) {
		if (m.getType() == GOALModule.ModuleType.MAIN) {
			mainModule = m;
    	} else if (m.getType() == GOALModule.ModuleType.EVENT) {
    		eventModule = m;
    	} else if (m.getType() == GOALModule.ModuleType.INIT) {
    		initModule = m;
    	}
    }
    
    public boolean isMainModuleRunning() {
    	return (topLevelContext == GOALModule.ModuleType.MAIN);
    }

    public boolean exitModule(GOALModule module) {
      	module.clearModuleSubti();

        switch (module.getType()) {
        case ANONYMOUS:
           if (this.activeStackOfModules.peek() != null) {
            	((GOALRC) getReasoningCycle()).setCurrentModuleExecuteFully(this.activeStackOfModules.peek());
            }
        	return false;
        case EVENT:
        case INIT:
                // We're leaving the init or event module and returning
                // to main top level context.
                this.topLevelContext = GOALModule.ModuleType.MAIN;
                break;
        default:
                // top level context does not change for other
                // kinds of modules. If we're leaving the main module,
                // main module should be only element on stack; in that
                // case we're leaving the agent, no need to reset context.
        		this.topLevelContext = null;
        		if (this.activeStackOfModules.peek() == null) {
        			getEnv().getScheduler().removeJobber(this.getAgName());
        			getEnv().getScheduler().perceptChanged();
        		}
                break;
        }
        this.activeStackOfModules.pop();
        // Report module re-entry on module's debug channel.
      //  if (this.topLevelContext == null) {
       // 	this.topLevelContext = this.activeStackOfModules.peek().getType();
       // }
        // GOALModule.ModuleType tlc = this.topLevelContext;
        GOALModule pk = this.activeStackOfModules.peek();
        if (pk != null) {
        	((GOALRC) getReasoningCycle()).setCurrentModuleExecuteFully(pk);
         }
        return (pk != null);
	}
    
    public void enteredModule(GOALModule module) {
       	// System.err.println("Entering module " + module.toString());
       	
       	       	
       	if (module.getType() == GOALModule.ModuleType.ANONYMOUS) {
    		return;
    	}
    	
     	if (this.activeStackOfModules.peek() != module) {
    		this.activeStackOfModules.push(module);
    	}
    	
        switch (module.getType()) {
        case MAIN:
        case EVENT:
        case INIT:
                this.topLevelContext = module.getType();
                break;
        default:
                // top level context does not change for other
                // kinds of modules.
        }
    }
    
    public GoalBase getAttentionSet() {
    	return getGoalBase();
    }
    
    public boolean hasInitModule() {
    	return (initModule != null);
    }

    public boolean hasEventModule() {
    	return (eventModule != null);
    }
    
    public GOALModule getInitModule() {
    	return initModule;
    }
    
    public GOALModule getEventModule() {
    	return eventModule;
    }
    
    public MentalState getMentalState() {
    	return ms;
    }
    
    public void setTopLevelContext(GOALModule.ModuleType t) {
    	topLevelContext = t;
    }
    
	boolean actionPerformedLastCycle = false;
    public void actionPerformed() {
    	actionPerformedLastCycle = true;
    }
    
    public boolean actionPerformedLastCycle() {
    	return actionPerformedLastCycle;
    }
    
    public void clearActionPerformed() {
    	actionPerformedLastCycle = false;
    }
    
    @Override
    public Iterator<Unifier> believes(Guard g, Unifier un, SelectionOrder so) {
    	return g.logicalConsequence(this, un, g.getVarNames(), so);
    }

	public Goal getFocusGoal() {
		if (getIntention() != null) {
			Intention i = getIntention();
			if (!i.empty() && i.hdE().referstoGoal()) {
				return (Goal) i.hdE().getContent();
			}
		}
		return null;
	}

	public void setFocusGoal(Goal goal) {
		if (goal != null) {
			setIntention(new Intention(new Event(goal), new Unifier(), AILAgent.refertoself(), getPrettyPrinter()));
		}
	}

    


} 
