package ethical_gwen.syntax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ail.semantics.AILAgent;
import ail.syntax.GBelief;
import ail.syntax.GuardAtom;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.LogicalFormula;
import ail.syntax.NumberTermImpl;
import ail.syntax.PredicateTerm;
import ail.syntax.Term;
import ail.syntax.Unifiable;
import ail.syntax.Unifier;

import ethical_gwen.semantics.EthicalGwendolenAgent;

public class Ethic {
	GBelief context;
	Predicate ethic;
	int score;
	
	public Ethic (GBelief c, Predicate e, int s) {
		context = c;
		ethic = e;
		score = s;
	}
	
	public Ethic clone() {
		return new Ethic((GBelief) context.clone(), (Predicate) ethic.clone(), score);
	}
	
	public Ethic (Predicate c, Predicate e, int s) {
		context = new GBelief(new Literal(Literal.LPos, c));
		ethic = e;
		score = s;
	}

	public GBelief getContext() {
		return context;
	}
	
	public Predicate getEthic() {
		return ethic;
	}
	
	public int getScore() {
		return score;
	}
	
    public List<String> getVarNames() {
    	return ethic.getVarNames();
    }
    
/*    public Term toTerm() {
    	Predicate t = new Predicate("ethic");
    	t.addTerm(context.getContent());
    	t.addTerm(ethic);
    	t.addTerm(new NumberTermImpl(score));
    	return t;
    } */
    
    public boolean isRule() {
    	return false;
    }
    
    public void renameVar(String oldname, String newname) {
    	ethic.renameVar(oldname, newname);
    }
    
    public boolean unifies(Unifiable u, Unifier un) {
    	if (u instanceof Ethic) {
    		Ethic e = (Ethic) u;
    		if (getEthic().unifies(e.getEthic(), un)) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public boolean match(Unifiable u, Unifier un) {
       	if (u instanceof Ethic) {
    		Ethic e = (Ethic) u;
    		if (getEthic().match(e.getEthic(), un)) {
    			return true;
    		}
    	}
    	
    	return false;
    	
    }
    
    public void standardise_apart(Unifiable u, Unifier un) {
    	getEthic().standardise_apart(u, un);
    }

	public Iterator<Unifier> logicalConsequence(final AILAgent ag, final Unifier un) {
		EthicalGwendolenAgent eg = (EthicalGwendolenAgent) ag;
		LinkedList<Unifier> ul = new LinkedList<Unifier>();
		
		Set<Ethic> agEthics = eg.getEthics(context);
		for (Ethic e : agEthics) {
			Unifier unC = un.clone();
			if (e.getEthic().unifies(getEthic(), unC)) {
				ul.add(unC);
			}
		}
		return ul.iterator();
	}
	
	public boolean isGround() {
		return ethic.isGround();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String s = "E(";
		s += context.toString();
		s += ", ";
		s += ethic.toString();
		s += ", ";
		s += score;
		s += ")";
		return s;
	}
		
}
