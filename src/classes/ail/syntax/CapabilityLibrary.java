// ----------------------------------------------------------------------------
// Copyright (C) 2014-2016 Louise A. Dennis, and  Michael Fisher 
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;

import ail.semantics.AILAgent;
import org.apache.commons.lang3.StringUtils;

/**
 * A class for libraries of capabilities.
 * @author lad
 *
 */
public class CapabilityLibrary implements Iterable<Capability> {
	// We index capabilities by their action predicate.
	HashMap<PredicateIndicator, ArrayList<Capability>> capMap = new HashMap<PredicateIndicator, ArrayList<Capability>>();


	/**
	 * We get the capability that uses this action predicate - or several if there are several.
	 *
	 * @param cPred
	 * @return
	 */
	public Iterator<Capability> getRelevant(Predicate cPred, AILAgent.SelectionOrder so) {
		if (cPred.isVar()) {
			ArrayList<Capability> out = new ArrayList<Capability>();
			for (ArrayList<Capability> cl : capMap.values()) {
				out.addAll(cl);
			}
			return out.iterator();
		} else {
			ArrayList<Capability> cList = capMap.get(cPred.getPredicateIndicator());
			if (cList != null) {
				return cList.iterator();
			} else {
				return Collections.<Capability>emptyList().iterator();
			}
		}

	}

	public void removeRelevant(Predicate cPred) {
		ArrayList<Capability> relevantCaps = new ArrayList<>();
		for (ArrayList<Capability> capabilityArrayList : capMap.values()) {
			for (Capability cap : capabilityArrayList) {
				if (cap.getAction().equals(cPred)) {
					relevantCaps.add(cap);
				}
			}
		}
		capMap.remove(cPred.getPredicateIndicator(), relevantCaps);
		//System.out.print("Relevant capablities removed.\n");
	}

	/**
	 * An iterator of all the capabilities in the library.
	 *
	 * @return
	 */
	@Override
	public Iterator<Capability> iterator() {
		ArrayList<Capability> cs = new ArrayList<Capability>();
		for (ArrayList<Capability> cl : capMap.values()) {
			cs.addAll(cl);
		}

		return cs.iterator();

	}

	/**
	 * Add a capability to the library.
	 *
	 * @param c
	 */
	public void add(Capability c) {
		PredicateIndicator pi = c.getPredicateIndicator();
		if (capMap.containsKey(pi)) {
			capMap.get(pi).add(c);
		} else {
			ArrayList<Capability> cl = new ArrayList<Capability>();
			cl.add(c);
			capMap.put(pi, cl);
		}
	}

	/**
	 * Preliminary implementation for finding a capability in a library that can be exchanged for some other capability in the library
	 * on the assumption that certain preconditions hold and certain post-conditions are desired.
	 * <p>
	 * This needs to be compared to the use of planning techniques potentially over sequences of capabilities.
	 *
	 * @param oldcap
	 * @param Post
	 * @param rb      - A rulebase that may define reasoning involving the pre and post-conditions.
	 * @param u
	 * @return
	 */
	public Capability findEquivalent(Capability oldcap, Predicate Post, RuleBase rb, Unifier u) {
		Predicate capname = oldcap;
		PredicateIndicator pi = capname.getPredicateIndicator();

		GBelief pgb = new GBelief(Post);

		for (ArrayList<Capability> l : capMap.values()) {

			Capability c = l.get(0);

			Capability cc = (Capability) c.clone();
			cc.standardise_apart(oldcap, u, oldcap.getVarNames());
			// NB we are assuming that capability names are unique here (give or take)

			if (cc != capMap.get(pi).get(0)) {

				// We check first the preconditions.  Only tests with trivial preconditions.
				EvaluationBasewNames<PredicateTerm> eb =
						new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(oldcap.getPre()), "precondition");

				// NB. This needs to be generalised to GLogical Formulae in some way.
				GBelief gb = (GBelief) cc.getPre();

				// The preconditions of the new capability are implied by the preconditions of the old capability
				Iterator<Unifier> preuni = gb.logicalConsequence(eb, rb, new Unifier(), gb.getVarNames(), AILAgent.SelectionOrder.LINEAR);

				if (preuni.hasNext()) {

					u.compose(preuni.next());

					// Then we check postconditions.
					EvaluationBasewNames<PredicateTerm> posteb =
							new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(cc.getPost()), "post");
					Iterator<Unifier> postuni = pgb.logicalConsequence(posteb, rb, new Unifier(), c.getPost().getVarNames(), AILAgent.SelectionOrder.LINEAR);
					if (postuni.hasNext()) {
						u.compose(postuni.next());
						cc.apply(u);
						pgb.apply(u);

						EvaluationBasewNames<PredicateTerm> peb = new NamedEvaluationBase<PredicateTerm>(new ConjunctionFormulaEvaluationBase(oldcap.getPost()), "postcondition");
						Iterator<Unifier> pun = pgb.logicalConsequence(peb, rb, new Unifier(), Post.getVarNames(), AILAgent.SelectionOrder.LINEAR);
						Unifier puni = pun.next();

						u.compose(puni);

						return cc;


					}
				}
			}

		}

		return null;
	}

	public void remove() {
	}

	public Capability getCapability(Action act) {
		for (ArrayList<Capability> capabilityArrayList : capMap.values()) {
			for (Capability cap : capabilityArrayList) {
				if (cap.getAction().equals(act)) {
					return cap;
				}
			}
		}
		return null;
	}

	public ArrayList getCapabilitiesArrayList() {
		ArrayList<Capability> capabilities = new ArrayList<>();
		for (ArrayList<Capability> capabilityArrayList : capMap.values()) {
			for (Capability cap : capabilityArrayList) {
				capabilities.add(cap);
				}
			}
		return capabilities;
		}

	public void exportLibrary(String filepath) {
		File capabilitiesFile = new File(filepath);
		ArrayList<Capability> capabilities = getCapabilitiesArrayList();
		try {
			capabilitiesFile.createNewFile();
			FileWriter capabilitiesFileWriter = new FileWriter(capabilitiesFile);
			for (Capability capability : capabilities) {
				capabilitiesFileWriter.write(capability.toString());
			}
			capabilitiesFileWriter.flush();
			capabilitiesFileWriter.close();
		} catch (
		IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

}
