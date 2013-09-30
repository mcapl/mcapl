// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of the Agent Infrastructure Layer (AIL)
//
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
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
//
// This file is based on code from the Open Source software "Jason", copyright
// by Jomi F. Hubner and Rafael H. Bordini.  http://jason.sf.net
//----------------------------------------------------------------------------

package ail.semantics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

import ail.mas.AILEnv;
import ail.util.AILexception;
import ail.mas.MAS;
import ail.syntax.BeliefBase;
import ail.syntax.RuleBase;
import ail.syntax.GoalBase;
import ail.syntax.GBelief;
import ail.syntax.Literal;
import ail.syntax.Plan;
import ail.syntax.PlanLibrary;
import ail.syntax.Term;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.Event;
import ail.syntax.Deed;
import ail.syntax.Guard;
import ail.syntax.Goal;
import ail.syntax.Action;
import ail.syntax.VarTerm;
import ail.syntax.Rule;
import ail.syntax.StringTerm;
import ail.syntax.Intention;
import ail.syntax.ApplicablePlan;
import ail.syntax.AILAnnotation;
import ail.syntax.Message;
import ail.syntax.Unifier;
import ail.syntax.annotation.SourceAnnotation;

import ajpf.util.VerifyMap;
import ajpf.MCAPLLanguageAgent;
import ajpf.psl.MCAPLFormula;
import ajpf.util.AJPFLogger;
import ajpf.psl.MCAPLPredicate;

import gov.nasa.jpf.annotation.FilterField;


/**
 * Workhorse class that implements AIL Agent State. We expect this to be subclassed
 * in many situations.  Agent State components are as described in various AIL 
 * technical reports.  Based on the Jason Agent class implemented by Rafael H. Bordini 
 * and Jomi F. Hubner.
 * 
 * Note that an AILAgent must first be created using the constructors but then
 * the init method must be called before its initial state is transformed into 
 * intentions etc.,  This allows initialisation methods to create the agent and
 * then add initial beliefs and goals separately.
 * 
 * @author louiseadennis
 *
 */
public class AILAgent implements MCAPLLanguageAgent {
	 /**
	 * The environment.
	 */
	@FilterField
    protected AILEnv	fEnv = null;
	
	/**
	 * The Multi-agent system.
	 */
	@FilterField
    protected MAS       fMAS = null;

    /**
	 * The agent's name.
	 */
	protected String fAgName = null;

	/**
	 * This is a map from strings to belief bases.  In general an agent only has one belief base (accessed by AILdefaultBBname) but this
	 * structure allows for languages in which agents can maintain multiple belief bases.
	 */
	protected Map<String, BeliefBase> bbmap = new VerifyMap<String, BeliefBase>();
	
	
	/**
	 * This is a map from strings to rule bases which allow deductive reasoning.  In general an agent only has one rules base (accessed by AILdefaultRBname) but this
	 * structure allows for languages in which agents can maintain multiple rule bases.
	 */
	protected Map<String, RuleBase> rbmap = new VerifyMap<String, RuleBase>();
	
	/**
	 * This is a map from strings to goal bases.  In general an agent only has one goal base (accessed by AILdefaultGBname) but this
	 * structure allows for languages in which agents can maintain multiple goal bases.
	 */
	protected Map<String, GoalBase> gbmap = new VerifyMap<String, GoalBase>();
	
	/**
	 * This is a map from strings to plan libraries.  In general an agent only has one plan library (accessed by AILdefaultPLname) but this
	 * structure allows for languages in which agents can maintain multiple plan libraries.
	 */
	protected Map<String, PlanLibrary> plmap = new VerifyMap<String, PlanLibrary>();
		
	/**
	 * The current intention.
	 */
	protected Intention I = new Intention();

	/**
	 * Other intentions.
	 */
    protected ArrayList<Intention> Is = new ArrayList<Intention>();

    /**
     * Currently applicable plans.
     */
    protected Iterator<ApplicablePlan> AP = new ArrayList<ApplicablePlan>().iterator();
 
    /**
     * Language specific annotations.  Unused by any AIL methods but may be
     * important when these methods are over-ridden.
     */
    protected List<AILAnnotation> Anns = null;

    /**
     * Actions performed during planning (or at least theoretically performed).
     */
    @FilterField
    protected List<Action> Actions = new ArrayList<Action>();
       
    /**
     * An inbox of messages received (emptied as messages are processed).
     */
    protected List<Message> Inbox = new ArrayList<Message>();
    
    /**
     * An outbox of messages sent.
     */
    protected List<Message> Outbox = new ArrayList<Message>();
    
    /**
     * The content of the agent.
     */
    protected List<String> content = new ArrayList<String>();
    
    /**
     * The context of the agent.
     */
    protected List<String> context = new ArrayList<String>();
    
    /**
     * The reasoning cycle used by the agent.  AIL itself provides no classes
     * that implement this interface.
     */
    protected ReasoningCycle RC;

    /**
     * Flag used to indicate the agent intends to sleep if no events are pending
     * next time it exits the reasoning cycle.
     */
	private boolean wanttosleep = false;
	
	/**
	 * Keeps track of how many times each plan has been used.  Useful for writing
	 * selection heuristics.
	 */
	protected VerifyMap<String, Integer> generated = new VerifyMap<String, Integer>();
		  	   
	/**
	 * Should plan usage be tracked?  If you don't track plan usage more states
	 * in the agent will match.
	 */
	boolean trackplanusage = true;
	
    /**
     * Is the agent running.
     */
    private boolean		fRunning = true;

    /**
     * The name of the last rule executed.  Used in pretty printing but potentially also
     * useful in building reasoning cycles.
     */
    @FilterField
    public String lastruleexecuted;
    
    /**
     * The default Belief Base name for AIL;
     */
    public static final String AILdefaultBBname = "";
    
    /*
     * The default belief base name for this agent;
     */
    protected String defaultbbname = AILdefaultBBname;
     
    /**
     * The default Goal Base name for AIL;
     */
    public static final String AILdefaultGBname = "";
    
    /*
     * The default goal base name for this agent;
     */
    protected String defaultgbname = AILdefaultGBname;
 
    /**
     * The default Rule Base name for AIL;
     */
    public static final String AILdefaultRBname = "";
    
    /*
     * The default belief base name for this agent;
     */
    protected String defaultrbname = AILdefaultRBname;

    /**
     * The default Plan Library name for AIL;
     */
    public static final String AILdefaultPLname = "";
    
    /*
     * The default belief base name for this agent;
     */
    protected String defaultplname = AILdefaultPLname;
 
    /**
     * The default Constraint Library name for AIL;
     */
    public static final String AILdefaultCLname = "";
    
    /*
     * The default belief base name for this agent;
     */
    protected String defaultclname = AILdefaultCLname;
    
    /* The default log name for this class */
    protected String logname = "ail.semantics.AILAgent";
    
    
     //-----------------CONSTRUCTORS---------------//
 
    /**
     * Constructor
     * 
     * Create an agent.
     */
    public AILAgent() {
       	setBeliefBase(new BeliefBase());
    	setRuleBase(new RuleBase());
    	setPlanLibrary(new PlanLibrary());
    	setGoalBase(new GoalBase());
     }
    

    /**
     * Constructor
     * 
     * Create an agent with just a name.
     */
    public AILAgent(String name) {
    	this();
    	fAgName = name;
     }
    

    /**
     * Constructor.
     * 
     * @param mas The multi-agent system within which the agent finds itself.
     * @param name The name of the agent.
     */
    public AILAgent(MAS mas, String name) {
    	this(name);
    	fEnv = mas.getEnv();
    	fMAS = mas; 
 	}
      
     
     /**
     * Constructor.
     * 
     * @param arch The Agent Architecture that links the agent with the environment
     *             and multi-agent system.  NB. improperly caught exception.
     * @param name The name of the agent.
     * @param ig   The agent's initial goals.
     * @param ib   The agent's initial beliefs.
     * @param pl   The agent's plans.
     */
    public AILAgent(MAS mas, String name, List<Goal> ig, List<Literal> ib, List<Plan> pl) {
    	this(mas, name);
    	
    	for (Literal b: ib) {
    		addInitialBel(b);
    	}
    	
    	for (Goal g: ig) {
    		addInitialGoal(g);
    	}
    	
    	for (Plan p: pl) {
    		try {
    			addPlan(p, refertoself());
    		} catch (Exception e) {
    			AJPFLogger.severe(logname, e.getMessage());
    		}
    	}
    }
    
    
    //----------------------GETTERS,  SETTERS and ADDING and REMOVING THINGS -------------//
    
    
    /**
     * Setter for the MAS an agent is within.
     * @param mas
     */
    public void setMAS(MAS mas) {
    	fEnv = mas.getEnv();
    	fMAS = mas;
    }
    
	/**
	 * Getter method for the multi-agent system.
     * 
     * @return the Multi-Agen system.
     */
    public MAS getMAS() {
    	return fMAS;
    }
    
    /**
	 * Getter for last rule executed.
	 * @return
	 */
	public String getNameOfLastRule() {
		return lastruleexecuted;
	}
	
	/**
	 * Set agent name.
	 * @param name
	 */
	public void setAgName(String name) {
		fAgName = name;
	}
	
	/**
     * Getter method for the agent's name.
     * @return the name of the agent.
     */
    public String getAgName() {
    	return fAgName;
    }
    

	/**
	 * Setter method for trackplanusage.
	 * @param b
	 */
	public void setTrackPlanUsage(boolean b) {
		trackplanusage = b;
	}
	
	/**
	 * Getter for trackplanusage.
	 * @return
	 */
	public boolean getTrackPlanUsage() {
		return trackplanusage;
	}
	
	
	// --- Beliefs
	
    /**
    * Getter method for the agent's belief base.
    * 
    * @return the Belief Base.
    */
	public BeliefBase getBB() {
		return bbmap.get(getDefaultBBName());
	}
   
	/**
	 * Get a Beliefbase indexed by a number.  It is preferable to use the
	 * string version of this.
	 * @param dbnum
	 * @return
	 */
	public BeliefBase getBB(int dbnum) {
		if (dbnum == 0) {
			return getBB();
		} else {
			return bbmap.get(dbnum);
		}
	}
   
	/**
	 * Get a Beliefbase indexed by a stringterm.
	 * @param dbnumt
	 * @return
	 */
	public BeliefBase getBB(StringTerm dbnumt) {
		String dbnum = getDefaultBBName();
		if (dbnumt.getString() != null) {
			dbnum = dbnumt.getString();
		}
		if (dbnum.equals(getDefaultBBName())) {
			return getBB();
		} else {
			return bbmap.get(dbnum);
		}
	}
   
	/**
	 * Get a Beliefbase indexed by a string.
	 *	 @param dbnum
	 * @return
	 */
	public BeliefBase getBB(String dbnum) {
		if (dbnum.equals(getDefaultBBName())) {
			return getBB();
		} else {
			return bbmap.get(dbnum);
		}
	}
   
	/**
	 * Get the index names for all the non-primary belief bases.
	 * @return
	 */
	public Set<String> getBBList() {
		return bbmap.keySet();
	}

	/**
	 * Set the belief base.
	 * 
	 * @param bb the belief base.
	 */
	public void setBeliefBase(BeliefBase bb) {
		bbmap.put(getDefaultBBName(), bb);
	}
	
	/**
	 * Adds a belief to the belief base annotating it with a source.
	 * 
	 */
	public void addBel(Literal bel, AILAnnotation s) {
		bel.addAnnot(s);   
		getBB().add(bel);
	}
   
	/**
	 * Remove a literal from teh default belief base.
	 * @param bel
	 */
	public void delBel(Literal bel) {
		getBB().remove(bel);
	}

	/** 
	 * Remove a belief from belief base, dbnum.
	 * @param dbnum
	 * @param bel
	 */
	public void delBel(StringTerm dbnum, Literal bel) {
		getBB(dbnum).remove(bel);
	}
	   
	/**
	 * Adds a belief to the belief base indexed by n.
	 * @param bel
	 * @param s
	 * @param n
	 */
	public void addBel(Literal bel, AILAnnotation s, String n) {
		if (bel instanceof VarTerm) {
			bel = varterm_to_literal((VarTerm) bel);
		}
		bel.addAnnot(s);   
		getBB(n).add(bel);
	}
  
	/**
	 * Adds a belief to teh belief base indexed by n.
	 * @param bel
	 * @param s
	 * @param n
	 */
	public void addBel(Literal bel, AILAnnotation s, StringTerm n) {
		if (bel instanceof VarTerm) {
			bel = varterm_to_literal((VarTerm) bel);
		}
		bel.addAnnot(s);   
		getBB(n.getString()).add(bel);
	}

	/**
	 * Helper method necessary for inserting instantiated VarTerms into the belief base without causing problems 
	 * for unification (particularly of annotations).  Essentially this replaces a VarTerm object with an 
	 * object of the class stored as its value.
	 * @param v
	 * @return
	 */
	private Literal varterm_to_literal(VarTerm v) {
     	Literal l = v;
    	Term belcontents = v.getValue();
 		if (belcontents instanceof Literal) {
 			l = (Literal) belcontents;
 		} else if (belcontents instanceof PredicatewAnnotation) {
 			l = new Literal(! v.negated(), (PredicatewAnnotation) belcontents);
 		} else if (belcontents instanceof Predicate) {
    		l = new Literal(! v.negated(), new PredicatewAnnotation((Predicate) belcontents));
    		l.setAnnot(v.getAnnot());
 		}
 		return l;
   	
     } 

	/**
	 * Adds a belief to the belief base indexed by n.
	 * @param bb
	 * @param n
	 */
	public void addBeliefBase(BeliefBase bb, int n) {
		String s = "";
		s += n;
		bbmap.put(s, bb);
	}

	/**
	 * Adds a new belief base with a particular index.
	 * @param bb
	 * @param s
	 */
	public void addBeliefBase(BeliefBase bb, String s) {
		bbmap.put(s, bb);
	}

	//--Goals
	
	public void addGoal(Goal g) {
		StringTerm goalbase = g.getGoalBase();
		if (gbmap.containsKey(goalbase.getString())) {
			gbmap.get(goalbase.getString()).add(g);
		} else {
			gbmap.put(goalbase.getString(), new GoalBase());
			gbmap.get(goalbase.getString()).add(g);			
		}
	}
	
	/**
	 * Get a list of the goals (goals appearing in intentions).
	 * @return a list of the agent's goals.
	 */
	public Iterator<Goal> getGoals() {
		ArrayList<Goal> gs = new ArrayList<Goal>();
		for (GoalBase g: gbmap.values()) {
			gs.addAll(g.getAll());
		}
		
		return gs.iterator();
	}
	
	public GoalBase getGoalBase() {
		return gbmap.get(getDefaultGBName());
		
	}
	
	public void setGoalBase(GoalBase gb) {
		gbmap.put(getDefaultGBName(), gb);
	}

	/**
	 * Get a list of the goals (goals appearing in intentions) of a particular type.
	 * @return a list of the agent's goals.
	 */
	public Iterator<Goal> getGoals(int type) {
		ArrayList<Goal> gs = new ArrayList<Goal>();
		for (GoalBase gb: gbmap.values()) {
			for (Goal g: gb.getAll()) {
				if (g.getGoalType() == type) {
					gs.add(g);
				}
				
			}
		}
		
		return gs.iterator();
	}
	
	/**
	 * Remove a Goal.
	 * @param g
	 */
	public void removeGoal(Goal g) {
		GoalBase gb = gbmap.get(g.getGoalBase().getString());
		if (gb != null) {
			gb.remove(g);
		}
	}

     //--Plans
	
	/**
	 * Get the default plan library.
	 * 
	 * @return the plan library.
	 */
	public PlanLibrary getPL() {
		return plmap.get(getDefaultPLName());
	}
   
	/**
	 * Get a specific plan library.
	 * @param key
	 * @return
	 */
	public PlanLibrary getPL(String key) {
		return plmap.get(key);
	}

	/**
	 * Setter method for the Plan Library;
	 * 
	 * @param pl the new plan library.
	 */
	public void setPlanLibrary(PlanLibrary pl) {
		plmap.put(getDefaultPLName(), pl);
	}
   
	/**
	 * Add a plan to a specific library.
	 * @param pl
	 * @param key
	 */
	public void setPlanLibrary(PlanLibrary pl, String key) {
		pl.setLibId(key);
		plmap.put(key, pl);
	}
   
	/**
	 * Adds a plan to the plan library.
	 *	 
	 * @param p The plan to be added.
	 * @param s The source of the plan.
	 * @throws AILexception
	 */
	public void addPlan(Plan p, SourceAnnotation s) throws AILexception {
		p.setSource(s);
		getPL().add(p);
	}
   
	/**
	 * Adds a plan from itself to the library.
	 * 
	 * @param p The plan to be added.
	 * @throws AILexception
	 */
	public void addPlan(Plan p) throws AILexception {
		p.setSource(refertoself());
		getPL().add(p);
	}
	
	//--- Applicable Plans

	/**
	 * Getter method for the currently applicable plans.
	 * These are stored as an iterator to be more efficient (hopefully)
	 * when choosing them.
	 * 
	 * @return the currently applicable plans.
	 */
	public Iterator<ApplicablePlan> getApplicablePlans() {
		return AP;
	}
	
    /**
 	 * Setter method for the currently applicable plans.
 	 * 
 	 * @param ap
 	 */
 	public void setApplicablePlans(Iterator<ApplicablePlan> ap) {
 		AP = ap;
 	}
 	
	//--- Rules
	
	/**
	 * Setter method for the inference rules.
	 * @param rs
	 */
	public void setRuleBase(RuleBase rs) {
		rbmap.put(getDefaultRBName(), rs);
	}
   
	/**
	 * Getter method for the RuleBase.
	 * @return
	 */
	public RuleBase getRuleBase() {
		return rbmap.get(getDefaultRBName());
	}
   
	/**
	 * Add a rule to the rule base.
	 * @param r
	 */
	public void addRule(Rule r) {
		getRuleBase().add(r);
	}
   
	//--- Constraints
	
	/**
	 * There may be additional mechanisms for constraining plan applicability.  These should
	 * over-ride this method.
	 * @param p
	 * @param u
	 * @return
	 */
	public Iterator<Unifier> check_constraints(Plan p, Iterator<Unifier> u) {
		return u;
	}
	
	//--- Intentions
	/**
	 * Getter method for the current intention.
	 * 
	 * @return the current intention.
	 */
	public Intention getIntention() {
		return I;
	}
   
	/**
	 * Setter method for the current intention.
	 * 
	 * @param i the new current intention.
	 */
	public void setIntention(Intention i) {
		I = i;
	}
   
	/**
	 * Getter method for all intentions apart from the current one.
	 * 
	 * @return all intentions apart from the current one.
	 */
	public ArrayList<Intention> getIntentions() {
		return Is;
	}
   
	/**
	 * Setter method for the set of intentions.
	 * 
	 * @param is  return the set of intentions.
	 */
	public void setIntentions(ArrayList<Intention> is) {
		Is = is;
	}
	
	//--- Content/Context
	
    /**
     * Getter method for the agent content.
     * @return the agent content.
     */
    public List<String> getContent() {
    	return content;
    }
    
    /** 
     * Setter method for the agent content.
     * @param s the agent content.
     */
    public void setContent(List<String> s) {
    	content = s;
    }
    
    /**
     * Add a new agent to the content.
     * @param s The agent to be added.
     */
    public void addContent(String s) {
    	if (! getContent().contains(s)) {
    		content.add(s);
    	}
    }
    
    /**
     * Remove an agent from the content.
     * @param s the agent to be removed.
     */
    public void removeContent(String s) {
    	content.remove(s);
    }
    
    /**
     * Getter for the agent's context.
     * @return the agent's context.
     */
    public List<String> getContext() {
    	return context;
    }
    
    /**
     * Setter for the agent's context.
     * @param s the agent's context.
     */
    public void setContext(List<String> s) {
    	context = s;
    }
    
    /**
     * Adds an agent name to the context.
     * @param s agent to add.
     */
    public void addContext(String s) {
    	if (! getContext().contains(s)) {
    		context.add(s);
    	}
    }
    
    /**
     * Removes an agent from the context.
     * @param s the agent to remove.
     */
    public void removeContext(String s) {
    	context.remove(s);
    }
    
    
    //--- Annotations
 	
 	/**
 	 * Getter method for the annotations.
 	 * 
 	 * @return the annotations.
 	 */
 	public List<AILAnnotation> getAnnotations() {
 		return Anns;
 	}
 	
 	
 	/**
 	 * Setter method for the annotations.  Note, unlike most of the
 	 * other setters we do not ensure the incoming list is thread safe.  This
 	 * is the responsibiliy of those calling this method.
 	 * 
 	 * @param anns the new annotations.
 	 */
 	public void setAnnotations(List<AILAnnotation> anns) {
 		Anns = anns;
 	}
 	
 	
 	//--- Actions
 	/**
 	 * Getter method for the Actions.
 	 * 
 	 * @return the new actions.
 	 */
 	public List<Action> getActions() {
 		return Actions;
 	}
 	
 	/**
 	 * Setter method for the Actions.
 	 * 
 	 * @param acts the new action list.
 	 */
 	public void setActions(List<Action> acts) {
 		Actions = acts;
 	}
 	

 	//-- Inbox
 	/**
 	 * Getter message for the agent's inbox.
 	 * 
 	 * @return
 	 */
 	public List<Message> getInbox() {
 		return Inbox;
 	}
 	
 	/**
 	 * Setter message for the agent's inbox.
 	 * 
 	 * @param msgs
 	 */
 	public void setInbox(List<Message> msgs) {
 		Inbox = msgs;
 	}
 	
	/**
	 * Add new messages to the agent's inbox.
	 * 
	 * @param msgs the new messages for the inbox.
	 */
	public void newMessages(Set<Message> msgs) {
		Inbox.addAll(msgs);
	}
	
	/**
	 * Clear the inbox.
	 *
	 */
	public void clearInbox() {
		Inbox = new ArrayList<Message>();
	}
	
 	//--- Outbox
	/**
	 * Getter method fo the agent's outbox.
	 * @return
	 */
	public List<Message> getOutbox() {
		return Outbox;
	}
	
	/**
	 * Setter method for the agent's outbox.
	 * @param msgs
	 */
	public void setOutbox(List<Message> msgs) {
		Outbox = msgs;
	}
	
	/**
	 * Add a new sent message to the agent's outbox.
	 * 
	 * @param msg The new sent message.
	 */
	public void newSentMessage(Message msg) {
		List<Message> msgl = getOutbox();
		boolean done = false;
		int i = 0;
		while (i < msgl.size()) {
			if (msg.compareTo(msgl.get(i)) == 0) {
				done = true;
				break;
			} else if (msg.compareTo(msgl.get(i)) < 0) {
				msgl.add(i, msg);
				done = true;
				break;
			}
			i++;
		}
		
		if (! done) {
			msgl.add(i, msg);
		}
		
		setOutbox(msgl);
	}
    
	//--- Reasoning Cycle
	
	/**
	 * Getter method for the reasoning cycle.
	 * 
	 * @return the reasoning cycle.
	 */
    public ReasoningCycle getReasoningCycle() {
    	return RC;
    }
   
    /**
     * Setter method for the reasoning cycle.
     * 
     * @param R the reasoning cycle.
     */	
    public void setReasoningCycle(ReasoningCycle R) {
    	RC = R;
    }

    /**
     * Setter method for the stage of the Reasoning Cycle.
     * @param rcs
     */
     public void setCurrentStage(RCStage rcs) {
    	getReasoningCycle().setCurrentStage(rcs);
    }

     //--- Environment
    /**
     * Getter method for the Environment.
     * 
     * @return the Environment.
     */
    public AILEnv getEnv() {
    	return fEnv;
    }
   
    /**
     * Setter method for the Environment
     * @param env
     */
    public void setEnv(AILEnv env) {
    	fEnv = env;
    }


 //--- Default database names    
    /**
     * Set the name of the default belief base.  This is the belief base that will be used if no belief base is specified.
     * By default this name is the empty string.
     * @param s
     */
     public void setDefaultBBName(String s) {
    	 defaultbbname = s;
     }
     
     /**
      * Get the name of the default belief base.
      * @return
      */
     public String getDefaultBBName() {
    	 return defaultbbname;
     }
		
     /**
     * Set the name of the default goal base.  This is the goal base that will be used if no goal base is specified.
     * By default this name is the empty string.
     * @param s
     */
    public void setDefaultGBName(String s) {
    	 defaultgbname = s;
     }
     
    /**
     * Get the name of the default goal base.
     * @return
     */
     public String getDefaultGBName() {
    	 return defaultgbname;
     }

     /**
     * Set the name of the default rule base.  This is the rule base that will be used if no rule base is specified.
     * By default this name is the empty string.
     * @param s
     */
    public void setDefaultRBName(String s) {
    	 defaultrbname = s;
     }
     
    /**
     * Get the name of the default rule base.
     * @return
     */
     public String getDefaultRBName() {
    	 return defaultrbname;
     }

     /**
     * Set the name of the default plan library.  This is the plan library that will be used if no plan library is specified.
     * By default this name is the empty string.
     * @param s
     */
     public void setDefaultPLName(String s) {
    	 defaultplname = s;
     }
     
     /**
      * Set the name of the default plan library.
      * @return
      */
     public String getDefaultPLName() {
    	 return defaultplname;
     }

     /**
     * Set the name of the default constraint library.  This is the constraint library that will be used if no constraint library is specified.
     * By default this name is the empty string.
     * @param s
     */
     public void setDefaultCLName(String s) {
    	 defaultclname = s;
     }
     
     /**
      * Get the name of the default constraint library
      * @return
      */
     public String getDefaultCLName() {
    	 return defaultclname;
     }


	//---------------------STATIC SUPPORT METHODS ------------------//

	/**
     * Returns a "self" Atom used in ascribing the sources of beliefs and 
     * intentions.
     * 
     * @return a self atom.
     */
    public static SourceAnnotation refertoself() {
     	return BeliefBase.TSelf;
    }

    /**
     * Returns a "percept" Atom used in ascribing the sources of beliefs and 
     * intentions.
     * 
     * @return a self atom.
     */
    public static SourceAnnotation refertopercept() {
    	return BeliefBase.TPercept;
    }
    
    
    //-------------------Initialisation Methods-------------------------

    /**
     * Initialises the Agent
     */
    public void initAg() {
    	// Set the current intention
    	if (! Is.isEmpty()) {
    		setIntention(getIntentions().remove(0));
    	}
     }

    /**
     * Adds a new initial goal.
     * 
     * @param g the new initial Goal.
     */
    public void addInitialGoal(Goal g) {
    	Intention i = new Intention(g, refertoself());
    	getIntentions().add(i);
    }
    
    /**
     * Add a new inital belief to the default belief base.
     * 
     * @param b the new belief.
     */
    public void addInitialBel(Literal b) {
    	addBel(b, refertoself());
    }

    /**
     * Add and initial belief to belief base s.
     * @param b
     * @param s
     */
    public void addInitialBel(Literal b, String s) {
    	addBel(b, refertoself(), s);
    }
    
    
    //------------------- WORKING WITH BELIEFS --------------------
    
    /**
     * Whether a literal is consistent with the agent's belief base.  Defaults
     * to true.
     * 
     * @param l The literal for checking.
     * @return whether this literal is consistent with the agent's belief base.
     */
    public boolean consistent(Literal l) {
    	return true;
    }
   
    
    //------------------- WORKING WITH INTENTIONS --------------------
   
    /**
     * Adds a new intention.
     * @param i
     */
    public void addNewIntention(Intention i) {
    	getIntentions().add(i);
    }
    
    /**
     * Select an intention from a linked list of intentions.
     * 
     * @param intentions
     * @return the selected intention.
     */
    public Intention selectIntention(List<Intention> intentions) {
        // make sure the selected Intention is removed from 'intentions'
        // and make sure no intention will "starve"!!!
    	Iterator<Intention> ii = intentions.iterator();
    	ArrayList<Intention> iiprime = new ArrayList<Intention>();

    	while (ii.hasNext()) {
    		Intention ip = ii.next();
    		// Need a more principled way to handle this with select intention
    		if (!(ip == null) && (ip.empty() || ip.suspended())) {
     			ii.remove();
     			if (! ip.empty()) {
     				iiprime.add(ip);
     			}
    		}
    	}
        
    	Intention i;
    	if (intentions.isEmpty()) {
    		i = null;
    	} else {
    		i = intentions.remove(0);
    	}
    	intentions.addAll(iiprime);

    	return i;
    }
    
    /**
     * Sort intentions to assist state matching while model checking.
     */
	public void sortIntentions() {
		ArrayList<Intention> unsuspended = new ArrayList<Intention>();
		ArrayList<Intention> suspended = new ArrayList<Intention>();
		for (Intention i: Is) {
			if (i.suspended()) {
				suspended.add(i);
			} else {
				unsuspended.add(i);
			}
		}
		Collections.sort(suspended);
		setIntentions(unsuspended);
		Is.addAll(suspended);
	} 

	/**
	 * Unsuspends all intentions.
	 *
	 */
	public void unsuspendintentions() {
		if (I != null) {
			I.unsuspend();
		}
		for (Intention i: Is) {
			i.unsuspend();
		}
	}
	
	/**
	 * True if all the agent's intentions are suspended.
	 * 
	 * @return whether all the agent's intentions are suspended.
	 */
	public boolean allintentionssuspended() {
		if (getIntention() == null || getIntention().empty() || getIntention().suspended()) {
			for (Intention i: getIntentions()) {
				if (!i.suspended()) {
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}

	//----------------------- WORKING WITH PLANS
    
    /**
     * Returns a chosen plan in a list of applicable plans.  We use
     * this rather than selectPlan as the desired overridable function since it allows
     * rules to reason about which intention generated the chosen plan.
     * 
     * By default, if trackplanusage is enabled, this prefers the plan with the highest
     * score.
     * 
     * Note this may return null;
     * 
     * @param appPlans
     * @param i
     * @return
     */
    public ApplicablePlan choosePlan(Iterator<ApplicablePlan> aps, Intention inte) {
    	if (trackplanusage) {
    		int currentvalue = 0;	
    		ApplicablePlan candidate = null;
		
			while (aps.hasNext()) {
				ApplicablePlan p = aps.next();
				if (candidate == null) {
					currentvalue = scoreplan(p);
					candidate = p;
				} else {
				int value = scoreplan(p);
					if (value > currentvalue) {
						currentvalue = value;
						candidate = p;
					}
				}
			}
			
			updatePlanUsage(candidate);
			return candidate;
    	} else {
    		return aps.next();
    	}
    }
    
    /**
     * Select a plan applicable to an intention from a linked list of plans.  Uses choosePlan.
     * Strongly recommend subclassing choose plan as opposed to this method.
     * 
     * @param appPlans A linked list of plans applicable to the intention.
     * @param i The intention under consideration.
     * @return One applicable plan.
     */
    public ApplicablePlan selectPlan(Iterator<ApplicablePlan> appPlans, Intention i) {
    	ApplicablePlan p = choosePlan(appPlans, i);
    	return p;
    }
    
    /**
     * Updates an records of plan usage.
     * 
     * By default, if trackplanusage is enabled, this sets the usage to
     * zero.
     * @param p the plan used.
     */
    public void updatePlanUsage(ApplicablePlan p) {
       	if (trackplanusage) {
       		if (p != null && !p.noChangePlan()) {
       			String ps = p.keyString();
       			generated.put(ps, 0);
       		}
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
		if (trackplanusage) {
			String ps = p.keyString();
			if (generated.get(ps) != null) {
				int i = generated.get(ps);
				i++;
				generated.put(ps, i);
				return (i - 1);
			} else {
				generated.put(ps, 1);
				return 0;
			}
		} 
		return 0;
	}
 
	
	/**
     * Filter out plans from a list of applicable plans.  Identity unless over-ridden.
     * 
     * @param aps A linked list of applicable plans.
     * @return A linked list of applicable plans from which some may have been
     *         filtered.
     */
   public Iterator<ApplicablePlan> filterPlans(Iterator<ApplicablePlan> aps) {
	   return aps;
    }
    
   /**
    * Clear the applicable plan set.
    */
    public void clearApplicablePlans() {
    	AP = new ArrayList<ApplicablePlan>().iterator();
    }
    
    /**
     * Generates a list of all the plans AIL considers applicable to the
     * intention.  This list generated using continuePlans and matchPlans
     * as described in AIL technical reports.  final to prevent the meaning
     * of an applicable plan being changed by sub-classing.  If an APL has
     * a different meaning then its own equivalent of appPlans must be used.
     * 
     * @param i The intention for which applicable plans are sought.
     * @return A linked list of all plans that are applicable.
     */
    public final Iterator<ApplicablePlan> appPlans(final Intention i) {
    	if (i!= null && !i.empty()) {
    		
    		return new Iterator<ApplicablePlan>() {
    			Iterator <ApplicablePlan> continueplans = continuePlans(i).iterator();
    			boolean cp = true;
    			Iterator<ApplicablePlan> matchplans = matchPlans(i);
    			
    			public void remove() {};
    			
    			public boolean hasNext() {
    				if (cp) {
    					if (continueplans.hasNext()) {
    						return true;
    					} else {
    						cp = false;
    					}
    				}
					return matchplans.hasNext();
    			}
    			
    			public ApplicablePlan next() {
    				if (cp) {
    					if (continueplans.hasNext()) {
    						return continueplans.next();
    					} else {
    						cp = false;
    					}
    				}
    				
					return matchplans.next();

    			}
    			
    			
    		};
    	
    	} else {
    		return matchPlans(i);
    	}
 	}
	
    /**
     * Generates all the applicable plans that imply continued processing of 
     * the current intention.
     * 
     * @param i  The intention for which plans are required.
     * @return A listed of applicable plans generated by continuing to process
     *         the agent's current plans.
     */
	private final ArrayList<ApplicablePlan> continuePlans(Intention i) {
		ArrayList<ApplicablePlan> cp = new ArrayList<ApplicablePlan>();
		
		Deed d = (Deed) i.hdD().clone();
		if (! d.isNPY()) {
			Iterator<Unifier> ui = believes(i.hdG(), i.hdU());
			ApplicablePlan ap;
		
			while (ui.hasNext()) {
				Unifier theta = ui.next();
				if (! theta.equals(i.hdU())) {
					theta.compose(i.hdU());
				} 
				ArrayList<Deed> ds = new ArrayList<Deed>();
				ArrayList<Guard> gs = new ArrayList<Guard>();
					
				ds.add(i.hdD());
				gs.add(i.hdG());
				ap = new ApplicablePlan(i.hdE(), ds, gs, 1, theta, 0, AILdefaultPLname);

				cp.add(ap);
			}
		}
		
		return cp;
	}
	
	/**
	 * Overridable method to fetch all reactive plans.  Contains
	 * some simple comparisons of guards and the current belief base
	 * to try to limit the number of plans fetcehd.
	 * @param ple
	 * @return
	 */
	protected Iterator<ApplicablePlan> getAllReactivePlans(Event ple) {
		return getPL().getAllReactivePlans(this);
	}
	
	/**
	 * Overridable method which decides which plans are relevant to a trigger
	 * event.
	 * @param ple
	 * @return
	 */
	protected Iterator<ApplicablePlan> getAllRelevantPlans(Event ple) {
		return getPL().getAllRelevant(ple.getPredicateIndicator(), this);
	}

	/**
	 * Generates all the applicable plans generated by applying plans from the
	 * plan library to the current intention.
	 * 
	 * @param i the intention to be planned.
	 * @return All the applicable plans generated by applying the plan library
	 *         to the intention.
	 */
	private final Iterator<ApplicablePlan> matchPlans(Intention i) {
		boolean realintention = true;
		if (i != null && i.empty()) {
			realintention = false;
		}
		ArrayList<ApplicablePlan> mp = new ArrayList<ApplicablePlan>();
		if (i == null) {
			return mp.iterator();
		}
		Event ple = null;
	//	Unifier vc = new Unifier();
		if (realintention) {
			ple = i.hdE();
			//plec.apply(i.hdU());
		//	pl = getAllRelevantPlans(ple).iterator();
		//	vc = i.hdU().varClusters();
			return getAllRelevantPlans(ple);
		} else {
			ple = new Event(Event.AILAddition, new Goal(new VarTerm("Any"), Goal.achieveGoal));
			return getAllReactivePlans(ple);
		//	pl = getAllReactivePlans(ple).iterator();
		}

	}
   
	//---------------------- WORKING WITH ANNOTATIONS
	
    /**
     * Whether one source is relevant to another.  Defaults to true.
     * 
     * @param t1 A Source, is the other source relevant to this?
     * @param t2 A Source, is it relevant to the other?
     * @return whether the second source is relevant to the first.
     */
    public boolean relevant(Term t1, Term t2) {
    	return true;
    }
    

	
	//---------------------- LOGICAL CONSEQUENCE AND REASONING ABOUT GUARDS
	
	   /**
     * Checks if the agent believes a guard.  At present this just checks
     * the literals in the belief base.  Prolog-style belief reasoning to 
     * be added.
     * 
     * @param g The guard to be checked.
     * @param un A Unifier already to be applied to the guard.
     * @return An iterator over candidate unifiers for the guard.  The agent
     *         does not believe the guard if this iterator is empty.
     */
    public Iterator<Unifier> believes(Guard g, Unifier un) {
    	return g.logicalConsequence(this, un);
    }
    
	/**
	 * Yes or no, does the agent believe a guard.
	 * @param gu the guard in question.
	 * @param un the current unifier.
	 * @return whether the agent believes the guard.
	 */
	public boolean believesyn(Guard gu, Unifier un) {
		Iterator<Unifier> ui = believes(gu, un);
		if (ui.hasNext()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Does an event entail the trigger of this plan.
	 * @param e
	 * @param p
	 * @param un
	 * @return
	 */
	public boolean goalEntails(Event e, Plan p, Unifier un) {
		p.standardise_apart(e, un);
		return (e.unifies(p.getTriggerEvent(), un));
	}

	//---------------------- REASON
	
	/**
	 * Call the reasoning cycle.  This method relies heavily on the implementation
	 * of the reasoning cycle and OSRule interface.  While the Reasoning Cycle does
	 * not indicate a stop point (which should be a stop point appropriate to
	 * model checking) the method gets the rules for the current stage of the 
	 * cycle.  It processes these rules in turn until is finds one whose 
	 * preconditions succeed.  It the applies the rule and cycles the reasoning
	 * cycle.  
	 */
	public void reason() {
		if (RC.not_interrupted()) {
		RC.setStopandCheck(false);
	
		while(! RC.stopandcheck()) {
			RCStage stage = RC.getStage();
			if (AJPFLogger.ltFine(logname)) {
				AJPFLogger.fine(logname, "About to pick a rule for stage " + stage.getStageName());
			}
			
			Iterator<OSRule> rules = stage.getStageRules();
			
		    boolean stagerulefound = false;
			while(rules.hasNext()) {
				OSRule rule = rules.next();
				if (AJPFLogger.ltFine(logname)) {
					AJPFLogger.fine(logname, "checking " + rule.getName());
				}
				
				if (rule.checkPreconditions(this)) {
					stagerulefound = true;
					rule.apply(this);
					lastruleexecuted = rule.getName();
					if (AJPFLogger.ltFine(logname)) {
						AJPFLogger.fine(logname, "Applying " + lastruleexecuted);
					}
					printagentstate();
					RC.cycle(this);
					break;
				}
			
			}
			
			if (!stagerulefound) {
				RC.cycle(this);
			}
		}
		}
	
	}
	
	
	//------------------ STOPPING, SLEEPING AND WAKING
	
		
	/**
	 * Stop the agent completely.
	 */
	public void stop() {
	 	fRunning = false;
	}
	

	/**
	 * Send the agent to sleep - stop processing the reasoning cycle until notified otherwise.
	 *
	 */
	public void sleep() {
		AJPFLogger.fine(logname, "setting wanttosleep for agent");
		RC.setStopandCheck(true);
		wanttosleep = true;
	}
	

	/**
	 * Getter method for wanting to sleep.
	 * @return whether the agent wants to sleep.
	 */
	public boolean wantstosleep() {
		return (wanttosleep);
	}
	

	/**
	 * Sets the agent's fields for it to be awake.
	 *
	 */
	public void tellawake() {
		if (wanttosleep) {
			// unsuspendintentions();
		}
		wanttosleep = false;
		// unsuspendintentions();
	}
		
    /** Checks whether the agent is running 
     * 
     * @return whether the agent is running.
     */
     public boolean isRunning() {
    	 if (AJPFLogger.ltFine(logname)) {
    		 AJPFLogger.fine(logname, "isRunning: " + fRunning);   	 
    	 }
     	return fRunning;
    }
     
            	
    //------------------- PRINTING AND LOGGING
     
 	/**
 	 * Print the agent.
 	 *
 	 */
 	public void printagentstate() {
  		if (AJPFLogger.ltFine(logname)) {
 			AJPFLogger.fine(logname, toString());
 		}
 		
 		if (AJPFLogger.ltFiner(logname)) {
 			AJPFLogger.finer(logname, getPL().toString());
 		}

  	}
 	
 	/*
 	 * (non-Javadoc)
 	 * @see java.lang.Object#toString()
 	 */
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
		s1.append(getGoalBase().toString());
 		s1.append("\n");
 		s1.append(getOutbox().toString());
 		s1.append("\n");
		s1.append(is);
		s1.append("\n");
		s1.append(Is);
		String s = s1.toString();
 		return s;
 	}

    
    //-------------------- MCAPL Interface Methods
      
    /**
     * One reasoning step from the point of view of the model checker.  
     * Implemented as one full turn of the agent's reasoning cycle.
     * 
     *  @param An (unused) flag indicating whether or not this is a model
     *         checking run.
     */
	public void MCAPLreason(int flag) {
		reason();
	}
	

	/**
	 * Whether the agent should keep reasoning.
	 * 
	 * @return Whether the agent should keep reasoning.
	 */
	public boolean MCAPLcontinueRunning() {
		 return (isRunning());
	}
	

	/**
	 * Returns the name of the agent.
	 * 
	 * @return The name of the agent.
	 */
	public String getMCAPLAgName() {
		return getAgName();
	}
	

	/**
	 * Whether the agent believes a formula.  We interpret a MCAPLFormula
	 * as a Literal but we may want to generalise this.  We convert the literal
	 * into a guard (which are what AIL agents check as beliefs) and then check
	 * if the agent's belief method can return one (or more) unifiers for this
	 * guard.
	 * 
	 * @param  A MCAPLFormula for belief checking.  In AIL this is a Literal.
	 * @return Whether the agent can find a unifier for the literal among its
	 *         beliefs.
	 */
	public boolean MCAPLbelieves(MCAPLFormula fmla) {
		GBelief  gb = new GBelief(GBelief.AILBel, new Literal(Literal.LPos, new PredicatewAnnotation((MCAPLPredicate) fmla)));
		Guard gu = new Guard(gb);
		Unifier un = new Unifier();
		boolean return_value =  believesyn(gu, un);
 		if (return_value & AJPFLogger.ltFine(logname)) {
 			AJPFLogger.fine("property_logging", "Unifier for property " + un);
 		}
		return return_value;
	}
	

	/*
	 * (non-Javadoc)
	 * @see mcapl.MCAPLLanguageAgent#MCAPLhasGoal(mcapl.psl.MCAPLFormula)
	 */
	public boolean MCAPLhasGoal(MCAPLFormula fmla) {
		Iterator<Goal> gi = getGoals();
		while (gi.hasNext()) {
			if (gi.next().getLiteral().equals(new Literal(Literal.LPos, new PredicatewAnnotation((MCAPLPredicate) fmla)))) {
				return true;
			}
			
		}
		return false;
	}
	

	/*
	 * (non-Javadoc)
	 * @see mcapl.MCAPLLanguageAgent#MCAPLhasIntention(mcapl.psl.MCAPLFormula)
	 */
	// We give this the semantics that fmla is an event that has had some planning associated with it.  i.e, it has been comittee to.
	public boolean MCAPLhasIntention(MCAPLFormula fmla) {
		Literal fmla_lit = new Literal(Literal.LPos, new PredicatewAnnotation((MCAPLPredicate) fmla));
		if (getIntention() != null) {
		for (Event e: getIntention().getPlannedUnifiedEvents()) {
			if (e.referstoGoal() && e.isAddition()) {
				if (e.getGoal().getLiteral().equals(fmla_lit)) {
					return true;
				}
			}
		}
		}

		for (Intention i: getIntentions()) {
			for (Event e: i.getPlannedUnifiedEvents()) {
				if (e.referstoGoal() && e.isAddition()) {
					if (e.getGoal().getLiteral().equals(fmla_lit)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	

	/*
	 * (non-Javadoc)
	 * @see mcapl.MCAPLLanguageAgent#MCAPLwantstosleep()
	 */
	public boolean MCAPLwantstosleep() {
		return wantstosleep();
	}
	

	/*
	 * (non-Javadoc)
	 * @see mcapl.MCAPLLanguageAgent#MCAPLtellawake()
	 */
	public void MCAPLtellawake() {
		tellawake();
	}	


  
}