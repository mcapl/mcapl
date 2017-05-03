// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf;

import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ClassInfo;

import ajpf.product.ProbabilisticModel;
import ajpf.product.Product;

/**
 * A listener class for running AJPF when you want to do some probabilistic calculation.  I'm far from sure this works
 * accurately and it should be used with caution.
 * 
 * @author louiseadennis
 *
 */
public class MCAPLProbListener extends MCAPLListener {
	// Method info for the choose method, stored for quick comparisons.
	MethodInfo michoose;
	
	// We keep track of the overall probability of violation.
	// public static double overall_prob = 0;
		
	// This is the only way I could work out how to check the right probability
	// was calculated when using JUnit to test this class.  This is a references
	// to the test object in the JVM.
	int testRef = 0;
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLListener#classLoaded(gov.nasa.jpf.jvm.JVM)
	 */
	public void classLoaded (VM vm, ClassInfo ci){
		if (ci.getName().equals("ajpf.util.choice.Choice")) {
			michoose = ci.getMethod("choose()I", false);
			assert michoose != null;
		} 
		super.classLoaded(vm, ci);
	}
	
	/*
	 * (non-Javadoc)
	 * @see gov.nasa.jpf.PropertyListenerAdapter#objectCreated(gov.nasa.jpf.jvm.JVM)
	 */
	public void objectCreated (VM vm, ThreadInfo ti, ElementInfo ei)  {
		
		// Stuff only used in the Unit tests involving this listener.
       	int objref = ei.getObjectRef();
        ClassInfo ci = vm.getClassInfo(objref);
        // We're watching for a test object to be created.
 	}
	
	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLListener#methodEntered(gov.nasa.jpf.jvm.JVM)
	 */
	public void methodEntered(VM vm, ThreadInfo ti, MethodInfo mi) {
		super.methodEntered(vm, ti, mi);
	}

	/*
	 * (non-Javadoc)
	 * @see gov.nasa.jpf.PropertyListenerAdapter#methodExited(gov.nasa.jpf.jvm.JVM)
	 */
	public void methodExited(VM vm, ThreadInfo ti, MethodInfo mi) {
		// We intercept the choose method and annotate the edges in our program model with the probabilities of the choices.
       	if (mi == michoose) {
            	int objref = ti.getThis();
      		log.fine("Dealing with choices");
       		ElementInfo ei = vm.getElementInfo(objref);
       		double prob = ei.getDoubleField("thischoice");
    		// But we only want to perform the annotation if there was more than one choice otherwise no branching has occured at this 
       		// method call (see peer for Choice).
       		if (prob < 1.0) {
        			product_automata.annotate_edge(prob);
       		}
       	} 

	}
	
	 
	 /**
	  * Helper method for check.
	  * @param search
	  * @return
	  */
	/* public boolean check (Search search, VM vm) {
		 log.fine("calling check");

		 boolean violation = super.check(search, vm);

		 // If there is a violation we note it and instead of stopping the search we note the probability of this path and then
		 // force a backtrack.
		 if (!violation) {
			 double pathprob = ((ProbabilisticModel) product_automata.getModel()).pathProb(product_automata.getModelAcceptingPath());
			 overall_prob += pathprob;

			 log.info("Violation!  Probability: " + pathprob);
			 search.requestBacktrack();
		 }

		 return true;
	 } */
	 
	 /*
	  * (non-Javadoc)
	  * @see ajpf.MCAPLListener#searchFinished(gov.nasa.jpf.search.Search)
	  */
	// public void searchFinished(Search search) {
	//	 log.info("Probability of Violation is: " + overall_prob);
	//	 super.searchFinished(search);
//	 }
	 
	 /**
	  * A Getter for the overall probability of violation.
	  * @return
	  */
	// public double getProbability() {
	//	 return overall_prob;
	// }
	 
	 /*
	  * (non-Javadoc)
	  * @see ajpf.MCAPLListener#getAutomataType()
	  */
	 public Product.AutomataType getAutomataType() {
		 return Product.AutomataType.PROBABILISTIC_AUTOMATA;
	 }
}
