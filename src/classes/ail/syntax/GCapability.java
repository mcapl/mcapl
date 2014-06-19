package ail.syntax;

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;
import java.util.ArrayList;

public class GCapability implements GuardAtom<Capability> {
	Capability cap;
	StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultCBname);;
	
	public GCapability(LogicalFormula f1, Predicate p, LogicalFormula f2) {
		cap = new Capability(f1, p, f2);
	}
	
	public GCapability clone() {
		return new GCapability(cap.getPre().clone(), cap.getCap().clone(), cap.getPost().clone());
	}

	@Override
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un,
			List<String> varnames) {
		
		CapabilityLibrary leb = ag.getCL();
		return new EvaluationBaseIterator<Capability>(leb, un, this);
	}
	
	public Capability getCap() {
		return cap;
	}

	@Override
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof GCapability) {
			return getCap().unifies(((GCapability) t).getCap(), u);
		}
		
		return false;
	}

	@Override
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {
		cap.standardise_apart(t,  u, varnames);
	}

	@Override
	public List<String> getVarNames() {
		return cap.getVarNames();
	}

	@Override
	public void renameVar(String oldname, String newname) {
		cap.renameVar(oldname, newname);
	}

	@Override
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof GCapability) {
			return cap.match(((GCapability) t).getCap(), u);
		}
		return false;
	}

	@Override
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof GCapability) {
			return cap.matchNG(((GCapability) t).getCap(), u);
		}
		return false;
	}

	@Override
	public boolean isGround() {
		return cap.isGround();
	}

	@Override
	public boolean apply(Unifier theta) {
		return cap.apply(theta);
	}

	@Override
	public void makeVarsAnnon() {
		cap.makeVarsAnnon();
	}

	@Override
	public Unifiable strip_varterm() {
		return new GCapability((LogicalFormula) cap.getPre().strip_varterm(), (Predicate) cap.getCap().strip_varterm(), (LogicalFormula) cap.getPost().strip_varterm());
	}

	@Override
	public boolean unifieswith(Capability obj, Unifier u, String ebname) {
		return cap.unifies(obj, u);
	}

	@Override
	public boolean isVar() {
		return false;
	}

	@Override
	public PredicateIndicator getPredicateIndicator() {
		return cap.getCap().getPredicateIndicator();
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
		return DefaultAILStructure.AILCapability;
	}
}
