// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, Michael Fisher, Nicholas K. Lincoln, Alexei
// Lisitsa and Sandor M. Veres
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
// 
// The EASS Library is free software; you can redistribute it and/or
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
//----------------------------------------------------------------------------

package eass.leo;

import ail.util.AILexception;
import ail.mas.scheduling.ActionScheduler;
import ail.mas.scheduling.NActionScheduler;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.NumberTerm;
import ail.syntax.Literal;
import ail.syntax.VarTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.StringTermImpl;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import eass.mas.eass.EASSOriginalEnvironment;
import gov.nasa.jpf.annotation.FilterField;

/**
 * Specialised environment for the LEO satellite example.  It comes with a fair bit of machinery for running the example without a MATLAB
 * connection in order to speed up debugging.
 *
 */
public class LEOEnvironment extends EASSOriginalEnvironment {
	// A counter used to control the frequency of collision detection requests.
	@FilterField
	int mycounter = 0;	
	
	String logname = "eass.leo.LEOEnvironment";
	
	/**
	 * Constructor.
	 *
	 */
	public LEOEnvironment() {
		super();
		super.scheduler_setup(this, new NActionScheduler(100));
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#initialise()
	 */
	public void initialise() {
		super.initialise();
		// If not connected to matlab make the scheduler more verification friendly.
		if (!connectedtomatlab) {
			NActionScheduler s = (NActionScheduler) getScheduler();
			removePerceptListener(s);
			ActionScheduler s1 = new ActionScheduler();
			s1.addJobber(this);
			setScheduler(s1);
			addPerceptListener(s1);
		}
	}

	// When not running with matlab the flag is used to switch between possible destinations for the two agents.
	boolean flag = false;
	
	// Again, when not running with matlab, a2plan and a3plan are used to track how many times each agent has
	// requested a plan.
	int a2plan = 0;
	int a3plan = 0;

	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#eachrun()
	 */
	public void eachrun() {

		if (AJPFLogger.ltFine(logname)) {
			AJPFLogger.fine(logname, "Counter is " + mycounter);
		}
		
		// pings are used to trigger checks for collision by the agent.
		if (mycounter == 0 ) {
			addPercept("abstraction_ag1", new Literal("ping"));
			AJPFLogger.fine("eass.leo.LEOEnvironment", "ping");
		}
		
		if (mycounter == 3 || mycounter == 6 || mycounter == 9 ) {

			// This is all used to pretend to be a simulator if the system isn't connected to
			// Matlab
			if (! connectedtomatlab) {
				if (a2plan == 2 && a3plan == 2) {
					// It's random which point in the line is selected as the final destination for a2 and a3, therefore
					// once we've reached that stage in the run we switch between them
					if (flag) {
						Literal a2state = new Literal("a2stateinfo");
						a2state.addTerm(new NumberTermImpl(0));
						a2state.addTerm(new NumberTermImpl(20));
						a2state.addTerm(new NumberTermImpl(0));
						a2state.addTerm(new NumberTermImpl(1));
						a2state.addTerm(new NumberTermImpl(1));
						a2state.addTerm(new NumberTermImpl(1));
						addUniquePercept("abstraction_ag2", a2state);
						Literal a3state = new Literal("a3stateinfo");
						a3state.addTerm(new NumberTermImpl(0));
						a3state.addTerm(new NumberTermImpl(10));
						a3state.addTerm(new NumberTermImpl(0));
						a3state.addTerm(new NumberTermImpl(1));
						a3state.addTerm(new NumberTermImpl(1));
						a3state.addTerm(new NumberTermImpl(1));
						addUniquePercept("abstraction_ag3", a3state);
						flag = false;
					} else {
						Literal a2state = new Literal("a2stateinfo");
						a2state.addTerm(new NumberTermImpl(0));
						a2state.addTerm(new NumberTermImpl(10));
						a2state.addTerm(new NumberTermImpl(0));
						a2state.addTerm(new NumberTermImpl(1));
						a2state.addTerm(new NumberTermImpl(1));
						a2state.addTerm(new NumberTermImpl(1));
						addUniquePercept("abstraction_ag2", a2state);
						Literal a3state = new Literal("a3stateinfo");
						a3state.addTerm(new NumberTermImpl(0));
						a3state.addTerm(new NumberTermImpl(20));
						a3state.addTerm(new NumberTermImpl(0));
						a3state.addTerm(new NumberTermImpl(1));
						a3state.addTerm(new NumberTermImpl(1));
						a3state.addTerm(new NumberTermImpl(1));
						addUniquePercept("abstraction_ag3", a3state);
						flag = true;
						
					}
					
				} else {
					// We need to send some possition data to start off reasoning
					Literal a2state = new Literal("a2stateinfo");
					a2state.addTerm(new NumberTermImpl(10));
					a2state.addTerm(new NumberTermImpl(10));
					a2state.addTerm(new NumberTermImpl(10));
					a2state.addTerm(new NumberTermImpl(1));
					a2state.addTerm(new NumberTermImpl(1));
					a2state.addTerm(new NumberTermImpl(1));
					addUniquePercept("abstraction_ag2", a2state);
					Literal a3state = new Literal("a3stateinfo");
					a3state.addTerm(new NumberTermImpl(10));
					a3state.addTerm(new NumberTermImpl(10));
					a3state.addTerm(new NumberTermImpl(10));
					a3state.addTerm(new NumberTermImpl(1));
					a3state.addTerm(new NumberTermImpl(1));
					a3state.addTerm(new NumberTermImpl(1));
					addUniquePercept("abstraction_ag3", a3state);
				}
			}
		}
		
		if (mycounter == 2) {
			removePercept("abstraction_ag1", new Literal("ping"));
			AJPFLogger.fine("eass.leo.LEOEnvironment", "no ping");
		}
		
		mycounter++;
		
		if (mycounter == 10) {
			mycounter = 0;
		} 
		
	} 
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#printvalues(ail.syntax.Literal)
	 */
	public void printvalues(Literal pred) {
		if (pred.getFunctor().equals("a2zthruster")) {
			AJPFLogger.fine("eass.leo", pred.toString());
		} 
		if (pred.getFunctor().equals("a3stateinfo")) {
			AJPFLogger.fine("eass.leo", pred.toString());
		} 
		if (pred.getFunctor().equals("a2stateinfo")) {
			AJPFLogger.fine("eass.leo", pred.toString());
		} 

	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#noconnection_run(java.lang.String, ail.syntax.Action)
	 */
	public void noconnection_run(String agname, Action act) {
		
		/// Mostly, if we're running without MatLab, we ignore run command execpte where we want to update
		// The plan request counters.
		if (act.getFunctor().equals("run")) {
		   Predicate predlist = (Predicate) act.getTerm(0);
		   Predicate predargs = (Predicate) act.getTerm(1);
		   int num_name_comps = predlist.getTermsSize();
		   String predname = "";
		   for (int i=0; i<num_name_comps; i++) {
			   // Lots of extra work to get the string correct.
			   Term nb = predlist.getTerm(i);
			   String s = nb.toString();
			   if (nb instanceof VarTerm) {
				   VarTerm v = (VarTerm) nb;
				   nb = v.getValue();
			   }
			   if (nb instanceof NumberTerm) {
				   NumberTerm num = (NumberTerm) nb;
				   Double number = num.solve();
				   int num_as_int = number.intValue();
				   s = ((Integer) num_as_int).toString();
			   }
			   if (nb instanceof StringTermImpl) {
				   StringTermImpl string = (StringTermImpl) nb;
				   s = string.getString();
			   }
			   predname += s;
		   }
		   
		   Term arg = predargs.getTerm(0);
		   String s = arg.toString();
		   
		   if(predname.equals("a2set_control")) {
			   if (s.startsWith("\"Follow_")) {
				   a2plan++;
	   			}
		   }
		
		   if(predname.equals("a3set_control")) {
			   if (s.startsWith("\"Follow_")) {
				   a3plan++;
	   			}
		   }
		}
		System.err.println("No Matlab Connection: " + act.toString());
	}
	
	// Counter for the number of plans generated.  Used when not connected to MATLAB
	int plan_number = 0;
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#noconnection_calc(ail.syntax.Predicate, ail.syntax.VarTerm, ail.syntax.Unifier)
	 */
	public Literal noconnection_calc(Predicate predicate, VarTerm val, Unifier u) {
		if (predicate.getFunctor().equals("plan_named_approach_to_location_multi")) {
			String planname = "PlanAIL" + plan_number;
			plan_number++;
			val.unifies(new Predicate(planname), u);
			
		}
		
		if (predicate.getFunctor().equals("any_future_collision")) {
			// If one plan has been requested by each agent then we simulate a collision course.
			if (a2plan == 1 & a3plan == 1) {
				val.unifies(new NumberTermImpl(1), u);
			} else {
				val.unifies(new NumberTermImpl(0), u);
			}
		}
		
		val.apply(u);
		Literal result = new Literal("result");
		result.addTerm(predicate);
		result.addTerm(val);
		return result;
		
	}

 
				
	/*
	 * (non-Javadoc)
	 * @see ail2matlab.DefaultEASSEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
	   Unifier u = new Unifier();
		     
	   	if (act.getFunctor().equals("comp_distance")) {
	   		double a1 = ((NumberTerm) act.getTerm(0)).solve();
	   		double a2 = ((NumberTerm) act.getTerm(1)).solve();
	   		double a3 = ((NumberTerm) act.getTerm(2)).solve();
	   		double a4 = ((NumberTerm) act.getTerm(3)).solve();
	   		double a5 = ((NumberTerm) act.getTerm(4)).solve();
	   		double a6 = ((NumberTerm) act.getTerm(5)).solve();
	   		
	   		double d1 = a1 - a4;
	   		double d2 = a2 - a5;
	   		double d3 = a3 - a6;
	   		
	   		double result = Math.sqrt((d1 * d1) + (d2 * d2) + (d3 * d3));
	   		double bound = ((NumberTerm) act.getTerm(6)).solve();
	   		VarTerm out = (VarTerm) act.getTerm(7);
	   		Literal l = new Literal("no");
	   		if (result < bound) {
	   			l = new Literal("yes");
	   		}
	   		u.unifies(out, l);
	   		if (AJPFLogger.ltFine(logname)) {
	   			AJPFLogger.fine(logname, act.toString());
	   		}
	   	} else {
		   u = super.executeAction(agName, act);
	   	}
	     
	   	return (u);
	  }
	  

}

