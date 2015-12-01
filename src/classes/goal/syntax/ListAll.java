package goal.syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent.SelectionOrder;
import ail.semantics.AgentMentalState;
import ail.syntax.DefaultAILStructure;
import ail.syntax.GLogicalFormula;
import ail.syntax.Guard;
import ail.syntax.ListTerm;
import ail.syntax.ListTermImpl;
import ail.syntax.Term;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;

public class ListAll implements GLogicalFormula {
	ListTerm list;
	Guard mental_state;
	List<String> ms_varnames;
	
	public ListAll(ListTerm v, Guard ms) {
		list = v;
		mental_state = ms;
		ms_varnames = mental_state.getVarNames();
	}
	
	public ListTerm getList() {
		return list;
	}
	
	public Guard getMS() {
		return mental_state;
	}

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof ListAll) {
			ListAll l = (ListAll) t;
			if (l.getMS().unifies(getMS(), u)) {
				if (l.getList().unifies(getList(), u)) {
					return true;
				}
			}
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
    		    	for (String n: ms_varnames) {
    		    		if (n.equals(s)) {
    		    			replaceName(n, s);
    		    		}
    		    	}
    			}
    		}
    	}		
	}

	@Override
	public List<String> getVarNames() {
		List<String> varnames = new ArrayList<String>();
		varnames.addAll(list.getVarNames());
		varnames.addAll(mental_state.getVarNames());
		return varnames;
	}
	
	private void replaceName(String oldname, String newname) {
		int index = ms_varnames.indexOf(oldname);
		ms_varnames.remove(index);
		ms_varnames.add(index, newname);		
	}

	@Override
	public void renameVar(String oldname, String newname) {
		list.renameVar(oldname, newname);
		mental_state.renameVar(oldname, newname);
		for (String s: ms_varnames) {
			if  (s.equals(oldname)) {
				replaceName(oldname, newname);
			}
		}
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof ListAll) {
			ListAll l = (ListAll) t;
			if (getMS().match(l.getMS(), u)) {
				if (getList().match(l.getList(), u)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof ListAll) {
			ListAll l = (ListAll) t;
			if (getMS().matchNG(l.getMS(), u)) {
				if (getList().matchNG(l.getList(), u)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isGround() {		
		return (list.isGround() && mental_state.isGround());
	}

	@Override
	public boolean apply(Unifier theta) {
		return (list.apply(theta) && mental_state.apply(theta));
	}

	@Override
	public void makeVarsAnnon() {
		list.makeVarsAnnon();
		mental_state.makeVarsAnnon();
		for (String s: ms_varnames) {
			replaceName(s, "_");
		}
	}

	@Override
	public Unifiable strip_varterm() {
		return new ListAll((ListTerm) list.strip_varterm(), (Guard) mental_state.strip_varterm());
	}

	@Override
	public Unifiable resolveVarsClusters() {
		return new ListAll((ListTerm) list.resolveVarsClusters(), (Guard) mental_state.resolveVarsClusters());
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AgentMentalState ag,
			Unifier un, List<String> varnames, SelectionOrder so) {
		Iterator<Unifier> allms = mental_state.logicalConsequence(ag, un, varnames, so);
		ListTermImpl newlist = new ListTermImpl();
		while (allms.hasNext()) {
			Unifier u = allms.next();
			ListTermImpl vartuple = new ListTermImpl();
			for (String s: ms_varnames) {
				Term t = u.get(s);
				vartuple.add(t);
			}
			newlist.add(vartuple);
		}
		if (list instanceof VarTerm) {
			list.unifies(newlist, un);
			return Guard.createUnifIterator(un);
		} else if (list.equals(newlist)){
			return Guard.createUnifIterator(un);
		} else {
			return Collections.emptyIterator();
		}
	}

	@Override
	public ListAll clone() {
		return new ListAll((ListTerm) list.clone(), mental_state.clone());
	}

}
