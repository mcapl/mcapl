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

import java.util.TreeSet;
import java.util.Set;

import ajpf.psl.MCAPLProperty;
import ajpf.psl.ast.Abstract_Property;
import ajpf.psl.Proposition;
import ajpf.psl.ast.Abstract_Proposition;
import ajpf.util.AJPFLogger;

/**
 * The Specification of the multi-agent system.
 * 
 * @author louiseadennis
 *
 */
public class MCAPLSpec {
	/**
	 * Holds the initial properties before initialiatisation of the Automaton.
	 */
	protected MCAPLProperty initialProperty;
	
	/**
	 * The set of atomic propositions in the specification
	 */
	
	protected Set<Tuple> props = new TreeSet<Tuple>();
	
	/**
	 * Flag  used by the listener to see if this state is accepting.
	 */
	protected boolean AcceptingStateExists = false;
		
	// Property String is used by the Listener in the Native JVM.
	@SuppressWarnings("all")
	private String propertystring;
	
	private Abstract_Property[] propArray;
	
	private MCAPLmas mas;
	
	private MCAPLcontroller c;
	
	int automata_state_num;
	 

	/**
	 * Check the multi-agent sysem still satisfied the specification.
	 * Sets the two flags noPropertiesViolated and allEventualitiesSatisfied
	 * which are then checked by the listener.
	 */
	public void checkProperties() {
		AJPFLogger.fine("ajpf.MCAPLSpec", "Checking Properties");
		for (Tuple t: props) {
			Proposition p = (Proposition) t.getMCAPL();
			p.updateTV();
			((Abstract_Proposition) t.getAbstract()).setTV(p.getTV());
			if (AJPFLogger.ltFiner("ajpf.MCAPLSpec")) {
				AJPFLogger.finer("ajpf.MCAPLSpec", t.toString());
			}
			
		}


	}
	
	
	/**
	 * Adds a new property to the specification.
	 * 
	 * @param p The property to be added.
	 */
	public void addProperty(MCAPLProperty p) {
		initialProperty = p;
		for (Proposition prop: p.getProps()) {
			prop.updateTV();
		}
	}
	
	/**
	 * Add a property string.
	 * @param p
	 */
	public void addPropertyString(String p) {
		propertystring = p;
	}
	
	
	/**
	 * Create the automaton from the initial properties - negating them in the
	 * process.
	 *
	 */
	public void createAutomaton() {
		if (propArray != null) {
			for (Abstract_Property p: propArray) {
				MCAPLProperty prop = p.toMCAPL(mas, c);
				((Proposition) prop).updateTV();
				((Abstract_Proposition) p).setTV(((Proposition) prop).getTV());
				props.add(new Tuple(p, prop));
			}
			if (AJPFLogger.ltFine("ajpf.MCAPSpec")) {
				AJPFLogger.fine("ajpf.MCAPLSpec", props.toString());
			}
		}
	} 
		
	/**
	 * Add a Multi-Agent system.
	 * @param m
	 */
	public void addMas(MCAPLmas m) {
		mas = m;
	}
	
	/**
	 * Add a controller.
	 * @param cont
	 */
	public void addController(MCAPLcontroller cont) {
		c = cont;
	}
	
	/**
	 * A Tuple class.  This is a tuple of an abstract 
	 * @author louiseadennis
	 *
	 */
	public class Tuple implements Comparable<Tuple>{
		Abstract_Property aprop;
		MCAPLProperty mprop;
		
		public Tuple(Abstract_Property a, MCAPLProperty m) {
			aprop = a;
			mprop = m;
		}
		
		Abstract_Property getAbstract() {
			return aprop;
		}
		
		MCAPLProperty getMCAPL() {
			return mprop;
		}
		
		public int compareTo(Tuple t) {
			return aprop.toString().compareTo(t.getAbstract().toString());
		}
		
		public String toString() {
			String s = "<" + aprop.toString() + ", " + mprop.toString() + ">";
			return s;
		}
	}
	
}
