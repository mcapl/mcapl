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

import ajpf.util.AJPFException;

/**
 * An interface for annotation models.  TBH at the moment the only annotations I can off-hand think might be useful are
 * probabilities on edges (hence the one method) but I'm sure there may be others!
 * @author louiseadennis
 *
 */
public interface ModelAnnotation {
	/**
	 * Annotate then next edge from state i in the model with a double.
	 * @param i
	 * @param a
	 * @throws AJPFException 
	 */
	public void edge_annotate_double(Integer i, double a) throws AJPFException;
}
