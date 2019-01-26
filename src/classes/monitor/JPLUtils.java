// ----------------------------------------------------------------------------
// Copyright (C) 2018 Angelo Ferrando, Louise A. Dennis, Davide Ancona, Michael Fisher and Viviana Mascardi
//
// This file is part of the Runtime Verification for MCAPL (RVMCAPL) Library.
// 
// The RVMCAPL Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
// ----------------------------------------------------------------------------

package monitor;

import java.util.ArrayList;
import java.util.List;

import org.jpl7.Atom;
import org.jpl7.Compound;
import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;

import ajpf.MCAPLcontroller;

public class JPLUtils {

	public static void init(String texpFileName){
		JPL.setTraditional();
		JPL.init();

		try {
			String library_filename = MCAPLcontroller.getFilename("/src/classes/monitor/prolog_files/library.pl");
			JPLUtils.createAndCheck("consult", new Atom(library_filename));
			String monitor_framework_file = MCAPLcontroller.getFilename("/src/classes/monitor/prolog_files/monitor_framework.pl");
			JPLUtils.createAndCheck("consult", new Atom(monitor_framework_file));
		} catch (Exception e) {
			
		}
		
		JPLUtils.createAndCheck("consult", new Atom(texpFileName));
	}

	public static List<Term> fromCompoundToList(Term term){
		List<Term> l = new ArrayList<>();
		while(term.arity() > 1){
    		l.add(term.arg(1));
    		term = term.arg(2);
    	}
		return l;
	}

	/* Method used to execute a predicate represented as a String */
	public static Query createAndCheck(String predicate){
		Query query = new Query(predicate);
		if(!query.hasSolution()){
			throw new PrologException(predicate + " predicate failed");
		}
		return query;
	}

	/* Method used to execute a predicate functor(term) */
	public static Query createAndCheck(String functor, Term term){
		Query query = new Query(functor, term);
		if(!query.hasSolution()){
			throw new PrologException(functor + " " + term + " predicate failed");
		}
		return query;
	}

	/* Method used to execute a predicate functor(term1, ..., termN) where terms = { term1, ..., termN } */
	public static Query createAndCheck(String functor, Term[] terms){
		Query query = new Query(functor, terms);
		if(!query.hasSolution()){
			throw new PrologException(functor + " predicate failed");
		}
		return query;
	}
}
