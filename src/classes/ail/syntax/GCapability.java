// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, and  Michael Fisher 
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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package ail.syntax;

import java.util.Iterator;
import java.util.List;

import ail.semantics.AILAgent;

/**
 * A Class for references to capabilities that can appear in plan guards.  This is untested and we're not sure if
 * we need this functionality.
 * @author lad
 *
 */
public class GCapability implements GuardAtom<Capability> {
	Capability cap;
	StringTerm DBnum = new StringTermImpl(AILAgent.AILdefaultCBname);;
	
	/**
	 * Constructor.
	 * @param f1
	 * @param p
	 * @param f2
	 */
	public GCapability(GLogicalFormula f1, Predicate p, GLogicalFormula f2) {
		cap = new Capability(f1, p, f2);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public GCapability clone() {
		return new GCapability(cap.getPre().clone(), cap.getCap().clone(), cap.getPost().clone());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GLogicalFormula#logicalConsequence(ail.semantics.AILAgent, ail.syntax.Unifier, java.util.List)
	 */
	public Iterator<Unifier> logicalConsequence(AILAgent ag, Unifier un,
			List<String> varnames) {
		
		CapabilityLibrary leb = ag.getCL();
		return new EvaluationBaseIterator<Capability>(leb, un, this);
	}
	
	/**
	 * Get the capability predicate.
	 * @return
	 */
	public Capability getCap() {
		return cap;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#unifies(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean unifies(Unifiable t, Unifier u) {
		if (t instanceof GCapability) {
			return getCap().unifies(((GCapability) t).getCap(), u);
		}
		
		if (t instanceof Capability) {
			return unifieswith((Capability) t, u, "");
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#standardise_apart(ail.syntax.Unifiable, ail.syntax.Unifier, java.util.List)
	 */
	public void standardise_apart(Unifiable t, Unifier u, List<String> varnames) {
		cap.standardise_apart(t,  u, varnames);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#getVarNames()
	 */
	public List<String> getVarNames() {
		return cap.getVarNames();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#renameVar(java.lang.String, java.lang.String)
	 */
	public void renameVar(String oldname, String newname) {
		cap.renameVar(oldname, newname);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#match(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean match(Unifiable t, Unifier u) {
		if (t instanceof GCapability) {
			return cap.match(((GCapability) t).getCap(), u);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#matchNG(ail.syntax.Unifiable, ail.syntax.Unifier)
	 */
	public boolean matchNG(Unifiable t, Unifier u) {
		if (t instanceof GCapability) {
			return cap.matchNG(((GCapability) t).getCap(), u);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#isGround()
	 */
	public boolean isGround() {
		return cap.isGround();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#apply(ail.syntax.Unifier)
	 */
	public boolean apply(Unifier theta) {
		return cap.apply(theta);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#makeVarsAnnon()
	 */
	public void makeVarsAnnon() {
		cap.makeVarsAnnon();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#strip_varterm()
	 */
	public Unifiable strip_varterm() {
		return new GCapability((GLogicalFormula) cap.getPre().strip_varterm(), (Predicate) cap.getCap().strip_varterm(), (GLogicalFormula) cap.getPost().strip_varterm());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.Unifiable#resolveVarsClusters()
	 */
	public Unifiable resolveVarsClusters() {
		return new GCapability((GLogicalFormula) cap.getPre().resolveVarsClusters(), (Predicate) cap.getCap().resolveVarsClusters(), (GLogicalFormula) cap.getPost().resolveVarsClusters());
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.EBCompare#unifieswith(ail.syntax.Unifiable, ail.syntax.Unifier, java.lang.String)
	 */
	public boolean unifieswith(Capability obj, Unifier u, String ebname) {
		return cap.unifies(obj, u);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isVar()
	 */
	public boolean isVar() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getPredicateIndicator()
	 */
	public PredicateIndicator getPredicateIndicator() {
		return cap.getCap().getPredicateIndicator();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#isTrivial()
	 */
	public boolean isTrivial() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEB()
	 */
	public StringTerm getEB() {
		return DBnum;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.syntax.GuardAtom#getEBType()
	 */
	public byte getEBType() {
		return DefaultAILStructure.AILCapability;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "C " + cap;
	}
}
