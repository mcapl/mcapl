package ail.syntax;

import java.util.ArrayList;
import java.util.List;
import ail.semantics.AILAgent;

public class Capability implements Unifiable,
		Comparable<Capability> {
	
	LogicalFormula pre;
	LogicalFormula post;
	Predicate cap;
	protected int keynum;
	
	public Capability(LogicalFormula pr, Predicate c, LogicalFormula pt) {
		pre = pr;
		cap = c;
		post = pt;
	}
	
	public Capability clone() {
		return new Capability(pre.clone(), cap.clone(), post.clone());
	}

	@Override
	public int compareTo(Capability o) {
    	if (keynum == o.getID()) {
    		return 0;
    	} else if (keynum > o.getID()) {
    		return 1;
    	} else {
    		return -1;
    	}
	}
	
	public void setID(int i) {
		keynum = i;
	}
	
	public int getID() {
		return keynum;
	}
	
	public Predicate getCap() {
		return cap;
	}
	
	public LogicalFormula getPre() {
		return pre;
	}
	
	public LogicalFormula getPost() {
		return post;
	}

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof Capability) {
			Capability c = (Capability) t;
			LogExpr expr = new LogExpr(getCap(), LogExpr.LogicalOp.and, new LogExpr(getPre(), LogExpr.LogicalOp.and, getPost()));
			LogExpr oexpr = new LogExpr(c.getCap(), LogExpr.LogicalOp.and, new LogExpr(c.getPre(), LogExpr.LogicalOp.and, c.getPost()));
			return expr.unifies(oexpr, u);			
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
		ArrayList<String> varnames = new ArrayList<String>();
		varnames.addAll(cap.getVarNames());
		varnames.addAll(pre.getVarNames());
		varnames.addAll(post.getVarNames());
		return varnames;
	}

	@Override
	public void renameVar(String oldname, String newname) {
		cap.renameVar(oldname, newname);
		pre.renameVar(oldname, newname);
		post.renameVar(oldname, newname);
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof Capability) {
			Capability c = (Capability) t;
			LogExpr expr = new LogExpr(getCap(), LogExpr.LogicalOp.and, new LogExpr(getPre(), LogExpr.LogicalOp.and, getPost()));
			LogExpr oexpr = new LogExpr(c.getCap(), LogExpr.LogicalOp.and, new LogExpr(c.getPre(), LogExpr.LogicalOp.and, c.getPost()));
			return expr.match(oexpr, u);			
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof Capability) {
			Capability c = (Capability) t;
			LogExpr expr = new LogExpr(getCap(), LogExpr.LogicalOp.and, new LogExpr(getPre(), LogExpr.LogicalOp.and, getPost()));
			LogExpr oexpr = new LogExpr(c.getCap(), LogExpr.LogicalOp.and, new LogExpr(c.getPre(), LogExpr.LogicalOp.and, c.getPost()));
			return expr.matchNG(oexpr, u);			
		}
		return false;
	}

	@Override
	public boolean isGround() {
		if (cap.isGround()) {
			if (pre.isGround()) {
				return post.isGround();
			}
		}
		
		return false;
	}

	@Override
	public boolean apply(Unifier theta) {
		boolean c = cap.apply(theta);
		boolean p1 = pre.apply(theta);
		boolean p2 = post.apply(theta);
		return (c || p1 || p2);
	}

	@Override
	public void makeVarsAnnon() {
		cap.makeVarsAnnon();
		pre.makeVarsAnnon();
		post.makeVarsAnnon();
	}

	@Override
	public Unifiable strip_varterm() {
		return new Capability((LogicalFormula) pre.strip_varterm(), (Predicate) cap.strip_varterm(), (LogicalFormula) post.strip_varterm());
	}
	
	public String toString() {
		String s = "{";
		s += pre;
		s += "} " + cap + " {";
		s += post;
		s += "}";
		return s;
	}

}
