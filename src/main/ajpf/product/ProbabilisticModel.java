// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
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
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.product;

import gov.nasa.jpf.JPF;
import ajpf.psl.Proposition;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * A model that annotates edges with probabilities.
 * @author louiseadennis
 *
 */
public class ProbabilisticModel extends MCAPLmodel {
	 protected static Logger log = JPF.getLogger("ajpf.product.ProbabilisticModel");
	 
	 /**
	  * Constructor.
	  * @param ps
	  */
	 ProbabilisticModel(Set<Proposition> ps) {
		 super(ps);
	 }
	
	
	 /*
	  * (non-Javadoc)
	  * @see ajpf.product.MCAPLmodel#addState(ajpf.product.ModelState)
	  */
	 public void addState(ModelState s) {
		 super.addState(s);
		 s.setAnnotation(new ProbAnnotation(s.getNum()));
	 }
	
	 /**
	  * Calculates the probability along a given path in the model.
	  * @param path
	  * @return
	  */
	 public double pathProb(List<Integer> path) {
		 double prob = 1;
		 int lasti = -1;
		 log.fine(path.toString());
		 Integer laststate = path.get(0);
		 for (Integer i: path) {
			 if (i != 0) {
				 log.fine("Checking: " + i);
				 prob = prob * edge_prob(i, laststate);
			 }
			 lasti++;
			 laststate = path.get(lasti);
		 }
		 return prob;
	 }
	
	 /**
	  * Calculates the probability of a transition between two states.
	  * @param i
	  * @param laststate
	  * @return
	  */
	 public double edge_prob(int to, int from) {
		 ProbAnnotation pa = (ProbAnnotation) this.getState(from).getAnnotation();
		 double edge_prob = pa.getProbability(to);
		 double prob;
		 // NB the probability defaults to 0 if no probabilitistic choice was
		 // involved but in the case of, for instance, scheduler choices which
		 // don't have explicit probabilities attached the probability is
		 // assumed to be equal among all choices - hence divided by the 
		 // number of other edges out of the "from" state.
		 if (edge_prob != 0) {
			 prob = edge_prob;
		 } else {
			 prob = 1 / equivalent_edges(from);
		 }
		 return prob;
		
	 }
	
	 /**
	  * What other edges lead out from this state?
	  * @param from
	  * @return
	  */
	 public int equivalent_edges(Integer from) {
		 log.fine(from.toString() + " has " + model_edges.get(from));
		 return model_edges.get(from).size();
	 }
	
	 /**
	  * Print support function.
	  */
	 public String printEdge(int from, int to, OutputFormat f) {
		 String s = "";
		 switch (f) {
		 	case Prism:
		 		s += edge_prob(to, from);
		 		s += ":";
		 		if (to >= 0) {
		 			s += "(state'=" + to + ")";
		 		} else {
		 			s += "(state'=" + higheststatenum + ")";
		 			higheststatenum--;
		 		}
		 		return s;
		 	case Default:
		 		s += edge_prob(to, from);
		 		s += " ::: ";
		 		s += super.printEdge(from, to, f);
		 		return s;
		 	case Promela:
		 }
		 return s;
	 }

}
