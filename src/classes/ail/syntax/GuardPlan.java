package ail.syntax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;

public class GuardPlan implements GuardAtom<Plan> {
	NumberTerm plan;
	Predicate cap;
	GLogicalFormula pre;
	LogicalFormula post;
	StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultPLname);
	
	public GuardPlan(NumberTerm p, Predicate c, GLogicalFormula f1, LogicalFormula f2) {
		plan = p;
		cap = c;
		pre = f1;
		post = f2;
	}
	
	public GuardPlan clone() {
		return new GuardPlan((NumberTerm) plan.clone(), cap.clone(), pre.clone(), post.clone());
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un,
			List<String> varnames) {
		PlanLibrary leb = ag.getPL();
		return new EvaluationBaseIterator<Plan>(leb, un, this);
	}
	
	public NumberTerm getPlan() {
		return plan;
	}
	
	public Predicate getCap() {
		return cap;
	}
	
	public GLogicalFormula getPre() {
		return pre;
	}
	
	public LogicalFormula getPost() {
		return post;
	}

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof GuardPlan) {
			GuardPlan gp = (GuardPlan) t;
			return plan.unifies(gp.getPlan(), u) &&
					cap.unifies(gp.getCap(), u) &&
					pre.unifies(gp.getPre(), u) &&
					post.unifies(gp.getPost(), u); 
		}
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {
		List<String> tvarnames = t.getVarNames();
		List<String> myvarnames = getVarNames();
		tvarnames.addAll(varnames);
	   	ArrayList<String> replacednames = new ArrayList<String>();
    	ArrayList<String> newnames = new ArrayList<String>();
    	for (String s:myvarnames) {
    		if (tvarnames.contains(s)) {
    			if (!replacednames.contains(s)) {
    				String s1 = DefaultAILStructure.generate_fresh(s, tvarnames, myvarnames, newnames, u);
    				renameVar(s, s1);
    				u.renameVar(s, s1);
    			}
    		}
    	}

	}

	@Override
	public List<String> getVarNames() {
		ArrayList<String> l = new ArrayList<String>();
		l.addAll(plan.getVarNames());
		l.addAll(cap.getVarNames());
		l.addAll(post.getVarNames());
		l.addAll(pre.getVarNames());
		return l;
	}

	@Override
	public void renameVar(String oldname, String newname) {
		plan.renameVar(oldname, newname);
		cap.renameVar(oldname, newname);
		post.renameVar(oldname, newname);
		pre.renameVar(oldname, newname);
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof GuardPlan) {
			GuardPlan gp = (GuardPlan) t;
			return plan.match(gp.getPlan(), u) &&
					cap.match(gp.getCap(), u) &&
					pre.match(gp.getPre(), u) &&
					post.match(gp.getPost(), u); 
		}
		
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof GuardPlan) {
			GuardPlan gp = (GuardPlan) t;
			return plan.matchNG(gp.getPlan(), u) &&
					cap.matchNG(gp.getCap(), u) &&
					pre.matchNG(gp.getPre(), u) &&
					post.matchNG(gp.getPost(), u); 
		}
		
		return false;
	}

	@Override
	public boolean isGround() {
		return plan.isGround() && cap.isGround() && pre.isGround() && post.isGround();
	}

	@Override
	public boolean apply(Unifier theta) {
		return plan.apply(theta) && cap.apply(theta) && pre.apply(theta) && post.apply(theta);
	}

	@Override
	public void makeVarsAnnon() {
		plan.makeVarsAnnon();
		cap.makeVarsAnnon();
		pre.makeVarsAnnon();
		post.makeVarsAnnon();
	}

	@Override
	public Unifiable strip_varterm() {
		return new GuardPlan((NumberTerm) plan.strip_varterm(), (Predicate) cap.strip_varterm(), (GLogicalFormula) pre.strip_varterm(), (LogicalFormula) post.strip_varterm());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	public Unifiable resolveVarsClusters() {
		return new GuardPlan((NumberTerm) plan.resolveVarsClusters(), (Predicate) cap.resolveVarsClusters(), (GLogicalFormula) pre.resolveVarsClusters(), (LogicalFormula) post.resolveVarsClusters());
	}

	@Override
	public boolean unifieswith(Plan obj, Unifier u, String ebname) {
		Event trigger = obj.getTriggerEvent();
		ArrayList<Guard> guard = obj.getContext();
		ArrayList<Deed> deeds = obj.getBody();
		
		if (trigger.getContent() instanceof Goal) {
			Goal goal = (Goal) trigger.getContent();
			if (goal.getGoalType() == Goal.achieveGoal) {
				if (post.unifies(goal.getLogicalContent(), u)) {
					boolean gunifies = false;
					if (guard.size() == 0) {
						gunifies = new GBelief().unifies(pre, u);
					} else if (guard.size() == 1) {
						gunifies = guard.get(0).unifies(pre, u);
					} else {
						boolean start = true;
						GLogicalFormula l = new Guard();
						for (Guard g: guard) {
							if (start) {
								start = false;
								l = g;
							} else {
								l = new Guard(l, Guard.GLogicalOp.and, g);
							}
						} 
						gunifies = l.unifies(pre, u);
					}
					
					if (gunifies) {
						if (new NumberTermImpl(obj.getID()).unifies(plan, u)) {
							for (Deed d: deeds) {
								if (d.getCategory() == Deed.DAction) {
									Action a = (Action) d.getContent();
									return a.unifies(cap, u);
								}
							}
						}
					}
				}
			}
		}
		
		return false;
		
	}

	@Override
	public boolean isVar() {
		return false;
	}

	@Override
	public PredicateIndicator getPredicateIndicator() {
		// random guess what this should be but post seems more likely since plans indexed by events.
		return new PredicateIndicator(cap.getFunctor(), cap.getTermsSize());
	}

	@Override
	public boolean isTrivial() {
		return false;
	}

	@Override
	public StringTerm getEB() {
		return DBnum;
	}

	@Override
	public byte getEBType() {
		return DefaultAILStructure.AILPlan;
	}

}
