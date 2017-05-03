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

import java.util.HashMap;
import java.util.Map;

import ajpf.util.ProbabilisticEdgeAnnotationException;

/**
 * An annotation on a  model indicating the probability of a transition from this state to another.
 * @author louiseadennis
 *
 */
public class ProbAnnotation implements ModelAnnotation {
	Map<Integer, Double> edge_probs = new HashMap<Integer, Double>();
	Integer from;
	
	public ProbAnnotation(Integer f) {
		from = f;
	}
	
	/**
	 * Get the probabiltity of a transition from the state annotated with this annotation to 
	 * state i.
	 * @param i
	 * @return
	 */
	public double getProbability(Integer i) {
		if (edge_probs.containsKey(i)) {
			return edge_probs.get(i);
		} else {
			return 0;
		}
	}
	
	/**
	 * Annotate the probability of a transition from this state to i with a.
	 * @throws AJPFException 
	 */
	public void edge_annotate_double(Integer to, double a) throws ProbabilisticEdgeAnnotationException {
		edge_probs.put(to, a);
		double prob_sum = 0;
		for (Double prob: edge_probs.values()) {
			prob_sum += prob;
			if (prob_sum > 1) {
				throw new ProbabilisticEdgeAnnotationException(to, prob_sum);
			}
		}
	}
}
