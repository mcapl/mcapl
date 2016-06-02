// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, Michael Fisher, Maryam Kamali, Owen McAree 
// and Sandor Veres
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
package eass.verification.platoon;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.FileHandler;

import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;
import gov.nasa.jpf.annotation.FilterField;
import ail.mas.MAS;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;
import ajpf.util.choice.UniformIntChoice;
import ail.syntax.Message;
import ail.syntax.ast.GroundPredSets;
import ail.util.AILexception;

public class PlatoonVerificationEnvironment extends EASSVerificationEnvironment {
		
	@FilterField
	public String logname = "eass.platooning.PlatoonVerificationEnvironment";
	@FilterField
	boolean assert_set_spacing_goal_once= true;
	
	// Predefining messages and percepts in order to reduce the number of objects
	static Predicate id_pred = new Predicate("id");
	static{ GroundPredSets.check_add(new NumberTermImpl(3)); id_pred.addTerm(new NumberTermImpl(3)); GroundPredSets.check_add_percept(id_pred);}
	
	static Predicate name = new Predicate("name");
	static{ GroundPredSets.check_add(new Predicate("follower3")); GroundPredSets.check_add(new Literal("follower3")); name.addTerm(new Predicate("follower3")); GroundPredSets.check_add_percept(name); }
	
	static Predicate name_front = new Predicate("name_front");
	static {GroundPredSets.check_add(new Predicate("follower1")); GroundPredSets.check_add(new Literal("follower1")); name_front.addTerm(new Literal("follower1")); GroundPredSets.check_add_percept(name_front); }
	
	static Predicate ready_to_join = new Predicate("ready_to_join");
	static Predicate ready_to_leave = new Predicate("ready_to_leave");
	
	static Predicate changed_lane = new Predicate("changed_lane");
	static Predicate initial_distance = new Predicate("initial_distance");
	static Predicate spacing = new Predicate("spacing");
	
	static {GroundPredSets.check_add_percept(ready_to_join); GroundPredSets.check_add_percept(ready_to_leave); GroundPredSets.check_add_percept(changed_lane); GroundPredSets.check_add_percept(initial_distance); GroundPredSets.check_add_percept(spacing);}
	
	static Predicate set_spacing_goal = new Predicate("set_spacing");
	static{GroundPredSets.check_add(new NumberTermImpl(17)); set_spacing_goal.addTerm(new NumberTermImpl(17)); GroundPredSets.check_add_percept(set_spacing_goal);}

	static Message set_spacing_message = new Message(EASSAgent.ACHIEVE, "leader", "follower3", set_spacing_goal);
	static{GroundPredSets.check_add(new Predicate("leader")); GroundPredSets.check_add(new Literal("leader"));}
	
	static Predicate join_agreement = new Predicate("join_agreement");
	static{join_agreement.addTerm(new Predicate("follower3"));
		join_agreement.addTerm(new Predicate("follower1")); GroundPredSets.check_add(join_agreement);}
	static Message join_message = new Message(EASSAgent.TELL, "leader", "follower3", join_agreement);

	static Predicate leave_agreement = new Predicate("leave_agreement");
	static{leave_agreement.addTerm(new Literal("follower3")); GroundPredSets.check_add(leave_agreement);}
	static Message leave_message = new Message(EASSAgent.TELL, "leader", "follower3", leave_agreement);
	
	static{GroundPredSets.check_add(new Predicate("platoon_m")); GroundPredSets.check_add(new Predicate("no_platoon_m"));}

	static Message platoon_m = new Message(EASSAgent.TELL, "leader", "follower3", new Predicate("platoon_m"));
	static Message no_platoon_m = new Message(EASSAgent.TELL, "leader", "follower3", new Predicate("no_platoon_m"));
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_sharedbeliefs()
	 */
	public Set<Predicate> generate_sharedbeliefs() {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
  		
		percepts.add(id_pred);

		percepts.add(name);

		percepts.add(name_front);

		int assertP = random_int_generator.nextInt(24);
		if (assertP == 0){
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 1) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 2){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 3) {
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 4) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 5){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 6){
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 7) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 8){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 9) {
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 10) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 11){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			AJPFLogger.info(logname, "No assert_spacing");
		} else if (assertP == 12){
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 13) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 14){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 15) {
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 16) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 17){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			AJPFLogger.info(logname, "No assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 18){
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 19) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 20){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			AJPFLogger.info(logname, "No assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 21) {
			percepts.add(ready_to_join);
			AJPFLogger.info(logname, "assert ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 22) {
			percepts.add(ready_to_leave);
			AJPFLogger.info(logname, "assert ready_to_leave");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} else if (assertP == 23){
			AJPFLogger.info(logname, "No assert ready_to_leave or ready_to_join");
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");			
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		} 

		
		/*boolean assert_change_lane = random_generator.nextBoolean();
		if(assert_change_lane){
			percepts.add(changed_lane);
			AJPFLogger.info(logname, "assert_changed_lane");
		}else{
			AJPFLogger.info(logname, "No assert_changed_lane");			
		} */

		/* boolean assert_init_dis = random_generator.nextBoolean();
		if(assert_init_dis){
			percepts.add(initial_distance);
			AJPFLogger.info(logname, "assert_initial_distance");
		}else{
			AJPFLogger.info(logname, "No assert_initial_distance");
		} */

		
		//boolean assert_spacing_x = random_generator.nextBoolean();

		// Having both spacing and spacing(17) seems redundant.  Keeping just spacing.
		/* if(assert_spacing_x){
			Predicate spacing_x = new Predicate("spacing");
			spacing_x.addTerm(new NumberTermImpl(17));
			percepts.add(spacing_x);
			AJPFLogger.info(logname, "assert_spacing_x");
		}else{
			AJPFLogger.info(logname, "Not assert_spacing_x");
		} */
		
		/*boolean assert_spacing = random_generator.nextBoolean();
		if(assert_spacing){
			percepts.add(spacing);
			AJPFLogger.info(logname, "assert_spacing");
		}else{
			AJPFLogger.info(logname, "No assert_spacing");
		} */

		
		
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.verification.EASSVerificationEnvironment#generate_messages()
	 */
	public Set<Message> generate_messages() {
		TreeSet<Message> messages = new TreeSet<Message>();

		if(assert_set_spacing_goal_once){ 
			boolean assert_set_spacing_goal = random_bool_generator.nextBoolean();
			if(assert_set_spacing_goal){
				messages.add(set_spacing_message);
				AJPFLogger.info(logname, "assert_set_spacing_goal");
				assert_set_spacing_goal_once=false;
			} else {
				AJPFLogger.info(logname, "Not assert_set_spacing_goal");				
			}
		}
		

		int assertM = random_int_generator.nextInt(9);
		if (assertM == 0) {
			messages.add(join_message);
			AJPFLogger.info(logname, "assert_join_agreement");
			messages.add(platoon_m);
			AJPFLogger.info(logname, "assert_platoon_m");
		} else if (assertM == 1) {
			messages.add(leave_message);
			AJPFLogger.info(logname, "assert_leave_agreement");
			messages.add(platoon_m);
			AJPFLogger.info(logname, "assert_platoon_m");
		} else if (assertM == 2){
			AJPFLogger.info(logname, "Not assert join_agreement or leave_agreement");
			messages.add(platoon_m);
			AJPFLogger.info(logname, "assert_platoon_m");
		} else if (assertM == 3) {
			messages.add(join_message);
			AJPFLogger.info(logname, "assert_join_agreement");
			messages.add(no_platoon_m);
			AJPFLogger.info(logname, "assert_no_platoon_m");
		} else if (assertM == 4) {
			messages.add(leave_message);
			AJPFLogger.info(logname, "assert_leave_agreement");
			messages.add(no_platoon_m);
			AJPFLogger.info(logname, "assert_no_platoon_m");
		} else if (assertM == 5){
			AJPFLogger.info(logname, "Not assert join_agreement or leave_agreement");
			messages.add(no_platoon_m);
			AJPFLogger.info(logname, "assert_no_platoon_m");
		} else if (assertM == 6) {
			messages.add(join_message);
			AJPFLogger.info(logname, "assert_join_agreement");
			AJPFLogger.info(logname, "Not assert platoon_m or no_platoon_m");
		} else if (assertM == 7) {
			messages.add(leave_message);
			AJPFLogger.info(logname, "assert_leave_agreement");
			AJPFLogger.info(logname, "Not assert platoon_m or no_platoon_m");
		} else if (assertM == 8){
			AJPFLogger.info(logname, "Not assert join_agreement or leave_agreement");
			AJPFLogger.info(logname, "Not assert platoon_m or no_platoon_m");
		} 
		
		/* int assert_platoon_m = random_generator.nextInt(3);
		if (assert_platoon_m == 0) {
			messages.add(platoon_m);
			AJPFLogger.info(logname, "assert_platoon_m");
		} else if (assert_platoon_m == 1){
			messages.add(no_platoon_m);
			AJPFLogger.info(logname, "assert_no_platoon_m");
		} else {
			AJPFLogger.info(logname, "Not assert platoon_m or no_platoon_m");
		} */

		
		return messages;
	};
	

	
}
