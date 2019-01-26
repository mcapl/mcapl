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

package eass.verification.leo;

import java.util.Set;
import java.util.TreeSet;

import ail.util.AILConfig;
import ail.util.AILexception;
import ail.syntax.Message;
import ail.syntax.Unifier;
import ail.syntax.Action;
import ail.syntax.NumberTermImpl;
import ail.syntax.NumberTerm;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import eass.mas.verification.EASSVerificationEnvironment;
import eass.semantics.EASSAgent;
import ajpf.util.AJPFLogger;

/**
 * Specialised environment for the LEO Control example.
 * @author louiseadennis
 *
 */
public class LEOVerificationEnvironment extends EASSVerificationEnvironment {
	static final String logname = "eass.verification.leo.LEOVerificationEnvironment";
	private String agName;
	// Configuration settings for various tests
	boolean testing_movement = true;
	boolean testing_thrusters = false;
	boolean changing_formations = false;
	boolean allthrusters = false;
	boolean allpositions = false;
	boolean requesting_positions = false;
	boolean requesting_formation = false;

	boolean formation_line = true;
	boolean formation_square = false;

	boolean all_can_break = false;
	
	// Change variables for the agents
	boolean change_ag1 = true;
	boolean change_message_ag1 = true;
	
	boolean change_aglead = true;
	boolean change_message_aglead = true;
	
	// Variables randomly changed
	
	// Arguments to literals
	static NumberTerm one = new NumberTermImpl("1");
	static NumberTerm two = new NumberTermImpl("2");
	static Literal plan_middle = new Literal("plan_middle");
	static Literal plan_left = new Literal("plan_left");
	static Literal plan_right = new Literal("plan_right");
	static Literal plan_topleft = new Literal("plan_topleft");
	static Literal plan_topright = new Literal("plan_topright");
	static Literal plan_bottomleft = new Literal("plan_bottomleft");
	static Literal plan_bottomright = new Literal("plan_bottomright");
	static Literal xthruster = new Literal("x");
	static Literal ythruster = new Literal("y");
	static Literal zthruster = new Literal("z");
	static Literal middle = new Literal("middle");
	static Literal left = new Literal("left");
	static Literal right = new Literal("right");
	static Literal topleft = new Literal("topleft");
	static Literal topright = new Literal("topright");
	static Literal bottomleft = new Literal("bottomleft");
	static Literal bottomright = new Literal("bottomright");
	static Literal none = new Literal("none");
	static Literal agent1 = new Literal("ag1");
	static Literal agent2 = new Literal("ag2");
	static Literal agent3 = new Literal("ag3");
	static Literal agent4 = new Literal("ag4");
	static Literal line = new Literal("line");
	static Literal square = new Literal("square");
	static Literal thruster_failure = new Literal("thruster_failure");

	// Literals
	static Literal close_to_middle = new Literal("close_to");
	static {close_to_middle.addTerm(middle);}
	static Literal plan_to_middle = new Literal("get_close_to");
	static{plan_to_middle.addTerm(middle);
		plan_to_middle.addTerm(plan_middle);
	}
	static Literal close_to_left = new Literal("close_to");
	static {close_to_left.addTerm(left);}
	static Literal plan_to_left = new Literal("get_close_to");
	static{plan_to_left.addTerm(left);
		plan_to_left.addTerm(plan_left);
	}
	static Literal close_to_right = new Literal("close_to");
	static {close_to_right.addTerm(right);}
	static Literal plan_to_right = new Literal("get_close_to");
	static {plan_to_right.addTerm(right);
		plan_to_right.addTerm(plan_right);
	}
	static Literal close_to_topleft = new Literal("close_to");
	static {close_to_topleft.addTerm(topleft);}
	static Literal plan_to_topleft = new Literal("get_close_to");
	static {plan_to_topleft.addTerm(topleft);
		plan_to_topleft.addTerm(plan_topleft);
	}
	static Literal close_to_topright = new Literal("close_to");
	static {close_to_topright.addTerm(topright);}
	static Literal plan_to_topright = new Literal("get_close_to");
	static {plan_to_topright.addTerm(topright);
		plan_to_topright.addTerm(plan_topright);
	}
	static Literal close_to_bottomleft = new Literal("close_to");
	static {close_to_bottomleft.addTerm(bottomleft);}
	static Literal plan_to_bottomleft = new Literal("get_close_to");
	static {plan_to_bottomleft.addTerm(bottomleft);
		plan_to_bottomleft.addTerm(plan_bottomleft);
	}
	static Literal close_to_bottomright = new Literal("close_to");
	static {close_to_bottomright.addTerm(bottomright);}
	static Literal plan_to_bottomright = new Literal("get_close_to");
	static {plan_to_bottomright.addTerm(bottomright);
		plan_to_bottomright.addTerm(plan_bottomright);
	}

	static Literal broken_x = new Literal("broken");
	static Literal broken_y = new Literal("broken");
	static Literal broken_z = new Literal("broken");
	static {broken_x.addTerm(xthruster);
		broken_y.addTerm(ythruster);
		broken_z.addTerm(zthruster);
	}

	static Literal thruster_line_1x = new Literal("thruster_line");
	static {thruster_line_1x.addTerm(xthruster);
		thruster_line_1x.addTerm(one);
	}
	static Literal thruster_line_1y = new Literal("thruster_line");
	static {thruster_line_1y.addTerm(ythruster);
		thruster_line_1y.addTerm(one);
	}
	static Literal thruster_line_1z = new Literal("thruster_line");
	static {thruster_line_1z.addTerm(zthruster);
		thruster_line_1z.addTerm(one);
	}
	static Literal thruster_line_2x = new Literal("thruster_line");
	static {thruster_line_2x.addTerm(xthruster);
		thruster_line_2x.addTerm(two);
	}
	static Literal thruster_line_2y = new Literal("thruster_line");
	static {thruster_line_2y.addTerm(ythruster);
		thruster_line_2y.addTerm(two);
	}
	static Literal thruster_line_2z = new Literal("thruster_line");
	static {thruster_line_2z.addTerm(zthruster);
		thruster_line_2z.addTerm(two);
	}

	static Literal assuming_formation_line = new Literal("assuming_formation");
	static Literal assuming_formation_square = new Literal("assuming_formation");
	static {assuming_formation_line.addTerm(line);
		assuming_formation_square.addTerm(square);}

	static Literal middle_pos = new Literal("position");
	static {middle_pos.addTerm(middle);}
	static Literal left_pos = new Literal("position");
	static {left_pos.addTerm(left);}
	static Literal right_pos = new Literal("position");
	static {right_pos.addTerm(right);}
	static Literal topleft_pos = new Literal("position");
	static {topleft_pos.addTerm(topleft);}
	static Literal topright_pos = new Literal("position");
	static {topright_pos.addTerm(topright);}
	static Literal bottomleft_pos = new Literal("position");
	static {bottomleft_pos.addTerm(bottomleft);}
	static Literal bottomright_pos = new Literal("position");
	static {bottomright_pos.addTerm(bottomright);}
	static Literal none_pos = new Literal("position");
	static {none_pos.addTerm(none);}

	static Literal ag1_maintaining = new Literal("maintaining");
	static Literal ag2_maintaining = new Literal("maintaining");
	static Literal ag3_maintaining = new Literal("maintaining");
	static Literal ag4_maintaining = new Literal("maintaining");
	static {ag1_maintaining.addTerm(agent1);
		ag2_maintaining.addTerm(agent2);
		ag3_maintaining.addTerm(agent3);
		ag4_maintaining.addTerm(agent4);
	}

	static Literal ag1_ab_broken = new Literal("aborted");
	static Literal ag2_ab_broken = new Literal("aborted");
	static Literal ag3_ab_broken = new Literal("aborted");
	static Literal ag4_ab_broken = new Literal("aborted");
	static {ag1_ab_broken.addTerm(thruster_failure);
		ag2_ab_broken.addTerm(thruster_failure);
		ag3_ab_broken.addTerm(thruster_failure);
		ag4_ab_broken.addTerm(thruster_failure);
		ag1_ab_broken.addTerm(agent1);
		ag2_ab_broken.addTerm(agent2);
		ag3_ab_broken.addTerm(agent3);
		ag4_ab_broken.addTerm(agent4);}

	static Literal drop_line = new Literal("drop_formation");
	static Literal drop_square = new Literal("drop_formation");
	static {drop_line.addTerm(line);
		drop_square.addTerm(square);
	}
//	static Literal new_instruction_dline = new Literal("new_instruction");
//	static Literal new_instruction_dsquare = new Literal("new_instruction");
//	static {new_instruction_dline.addTerm(drop_line);
//		new_instruction_dsquare.addTerm(drop_square);
//	}
	
	static Literal send_pos_ag1 = new Literal("send_position");
	static Literal send_pos_ag2 = new Literal("send_position");
	static Literal send_pos_ag3 = new Literal("send_position");
	static Literal send_pos_ag4 = new Literal("send_position");
	static {send_pos_ag1.addTerm(agent1);
		send_pos_ag2.addTerm(agent2);
		send_pos_ag3.addTerm(agent3);
		send_pos_ag4.addTerm(agent4);
	}
				
	/**
	 * Randomly determine the messages received by the agent.
	 */
	public Set<Message> generate_messages(String AgName, Action act) {
		TreeSet<Message> messages = new TreeSet<Message>();
		if (agName.equals("ag1")) {
			if (change_message_ag1) {
				boolean send_start_line = false;
				boolean send_start_square = false;
				boolean send_middle = false;
				boolean send_left = false;
				boolean send_right = false;
				boolean send_topleft = false;
				boolean send_topright = false;
				boolean send_bottomleft = false;
				boolean send_bottomright = false;
				boolean send_none = false;
				//boolean newins_line = false;
				//boolean newins_square = false;
				boolean dropline = false;
				boolean dropsquare = false;

				if (testing_movement) {
					if (requesting_positions) {
						if (formation_line) {
							send_middle = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 position(middle): " + send_middle);
							if (allpositions) {
								send_left = random_bool_generator.nextBoolean();
								AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 position(left): " + send_left);
								send_right = random_bool_generator.nextBoolean();							
								AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 position(right): " + send_right);
							}
						}
						if (formation_square) {
							send_topleft = random_bool_generator.nextBoolean();
							if (allpositions) {
								send_topright = random_bool_generator.nextBoolean();
								send_bottomleft = random_bool_generator.nextBoolean();	
								send_bottomright = random_bool_generator.nextBoolean();							
							}
						}
					}
					if (requesting_formation) {
						if (formation_line) {
							send_start_line = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 assume_formation(line): " + send_start_line);
						}
						if (formation_square) {
							send_start_square = random_bool_generator.nextBoolean();
						}
					}
				}
								
				if (changing_formations) {
					dropline = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 drop_formation(line): " + dropline);
					dropsquare = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 drop_formation(square): " + dropsquare);
				}
										
				if (send_start_line) {
					Message msg = new Message(EASSAgent.PERFORM, "aglead", "ag1", assuming_formation_line);
					messages.add(msg);
				}
				if (send_start_square) {
					Message msg = new Message(2, "aglead", "ag1", assuming_formation_square);
					messages.add(msg);
				}
				if (send_middle) {
					Message msg = new Message(1, "aglead", "ag1", middle_pos);
					messages.add(msg);
				}
				if (send_left) {
					Message msg = new Message(1, "aglead", "ag1", left_pos);
					messages.add(msg);
				}
				if (send_right) {
					Message msg = new Message(1, "aglead", "ag1", right_pos);
					messages.add(msg);
				}
				if (send_topleft) {
					Message msg = new Message(1, "aglead", "ag1", topleft_pos);
					messages.add(msg);
				}
				if (send_topright) {
					Message msg = new Message(1, "aglead", "ag1", topright_pos);
					messages.add(msg);
				}
				if (send_bottomleft) {
					Message msg = new Message(1, "aglead", "ag1", bottomleft_pos);
					messages.add(msg);
				}
				if (send_bottomright) {
					Message msg = new Message(1, "aglead", "ag1", bottomright_pos);
					messages.add(msg);
				}
				if (send_none) {
					Message msg = new Message(1, "aglead", "ag1", none_pos);
					messages.add(msg);
				}
/*				if (newins_line) {
					Message msg = new Message(1, "aglead", "ag1", new_instruction_dline);
					messages.add(msg);
				}
				if (newins_square) {
					Message msg = new Message(1, "aglead", "ag1", new_instruction_dsquare);
					messages.add(msg);
				} */
				if (dropline) {
					Message msg = new Message(2, "aglead", "ag1", drop_line);
					messages.add(msg);
				}
				if (dropsquare) {
					Message msg = new Message(2, "aglead", "ag1", drop_square);
					messages.add(msg);
				}
				change_message_ag1 = false;
			}
		} 
			
		if (agName.equals("aglead")) {
			if (change_message_aglead) {
				boolean ag1maintain = false;
				boolean ag2maintain = false;
				boolean ag3maintain = false;
				boolean ag4maintain = false;
				boolean ag1broken = false;
				boolean ag2broken = false;
				boolean ag3broken = false;
				boolean ag4broken = false;
				boolean ag1_sendpos = false;
				boolean ag2_sendpos = false;
				boolean ag3_sendpos = false;
				boolean ag4_sendpos = false;
					
				ag1maintain = random_bool_generator.nextBoolean();
				AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random aglead maintaining(ag1): " + ag1maintain);
				ag2maintain = random_bool_generator.nextBoolean();
				AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random aglead maintaining(ag2): " + ag2maintain);
				ag3maintain = random_bool_generator.nextBoolean();
				AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random aglead maintaining(ag3): " + ag3maintain);
				ag4maintain = random_bool_generator.nextBoolean();
				AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random aglead maintaining(ag4): " + ag4maintain);
				if (testing_thrusters) {
					ag1broken = random_bool_generator.nextBoolean();
					if (all_can_break) {
						ag2broken = random_bool_generator.nextBoolean();
						ag3broken = random_bool_generator.nextBoolean();
						ag4broken = random_bool_generator.nextBoolean();
					}
				}
					
				if (requesting_positions) {
					ag1_sendpos = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 send_position(ag1): " + ag1_sendpos);
					ag2_sendpos = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 send_position(ag2): " + ag2_sendpos);
					ag3_sendpos = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 send_position(ag3): " + ag3_sendpos);
					ag4_sendpos = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 send_position(ag4): " + ag4_sendpos);
				}
					
				if (ag1maintain) {
					Message msg = new Message(1, "ag1", "aglead", ag1_maintaining);
					messages.add(msg);
				}
					
				if (ag2maintain) {
					Message msg = new Message(1, "ag2", "aglead", ag2_maintaining);
					messages.add(msg);
				}
					
				if (ag3maintain) {
					Message msg = new Message(1, "ag3", "aglead", ag3_maintaining);
					messages.add(msg);
				}
					
				if (ag4maintain) {
					Message msg = new Message(1, "ag4", "aglead", ag4_maintaining);
					messages.add(msg);
				}
					
				if (ag1broken) {
					Message msg = new Message(1, "ag1", "aglead", ag1_ab_broken);
					messages.add(msg);
				}
					
				if (ag2broken) {
					Message msg = new Message(1, "ag2", "aglead", ag2_ab_broken);
					messages.add(msg);
				}
					
				if (ag3broken) {
					Message msg = new Message(1, "ag3", "aglead", ag3_ab_broken);
					messages.add(msg);
				}
					
				if (ag4broken) {
					Message msg = new Message(1, "ag4", "aglead", ag4_ab_broken);
					messages.add(msg);
				}
					
				if (ag1_sendpos) {
					Message msg = new Message(2, "ag1", "aglead", send_pos_ag1);
					messages.add(msg);
				}
				if (ag2_sendpos) {
					Message msg = new Message(2, "ag2", "aglead", send_pos_ag2);
					messages.add(msg);
				}
				if (ag3_sendpos) {
					Message msg = new Message(2, "ag3", "aglead", send_pos_ag3);
					messages.add(msg);
				}
				if (ag4_sendpos) {
					Message msg = new Message(2, "ag4", "aglead", send_pos_ag4);
					messages.add(msg);
				}
						
				change_message_aglead = false;
			}
		}
		return messages;
	}

	/**
	 * Randomly determine the percepts received by the agent.
	 */
	public Set<Predicate> generate_sharedbeliefs(String AgName, Action Act) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean ag1_close_to_middle = false;
		boolean ag1_plan_to_middle = false;
		boolean ag1_close_to_left = false;
		boolean ag1_plan_to_left = false;
		boolean ag1_close_to_right = false;
		boolean ag1_plan_to_right = false;
		boolean ag1_close_to_topleft = false;
		boolean ag1_plan_to_topleft = false;
		boolean ag1_close_to_topright = false;
		boolean ag1_plan_to_topright = false;
		boolean ag1_close_to_bottomleft = false;
		boolean ag1_plan_to_bottomleft = false;
		boolean ag1_close_to_bottomright = false;
		boolean ag1_plan_to_bottomright = false;
		boolean ag1_broken_x = false;
		boolean ag1_broken_y = false;
		boolean ag1_broken_z = false;
		boolean ag1_tl_1x = false;
		boolean ag1_tl_1y = false;
		boolean ag1_tl_1z = false;
		boolean ag1_tl_2x = false;
		boolean ag1_tl_2y = false;
		boolean ag1_tl_2z = false;
		if (agName.equals("ag1")){
			if (change_ag1) {
				if (testing_movement) {
					if (formation_line) {
						ag1_plan_to_middle = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(middle, plan_middle): " + ag1_plan_to_middle);
						ag1_close_to_middle = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(middle): " + ag1_close_to_middle);
					}
					if (formation_square) {
						ag1_plan_to_topleft = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(topleft, plan_topleft): " + ag1_plan_to_topleft);
						ag1_close_to_topleft = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(topleft): " + ag1_close_to_topleft);
					}
					
					if (allpositions) {
						if (formation_line) {
							ag1_plan_to_left = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(left, plan_left): " + ag1_plan_to_left);
							ag1_close_to_left = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(left): " + ag1_close_to_left);
							ag1_plan_to_right = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(right, plan_right): " + ag1_plan_to_right);
							ag1_close_to_right = random_bool_generator.nextBoolean();		
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(right): " + ag1_close_to_right);
						}
						if (formation_square) {
							ag1_plan_to_topright = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(topright, plan_topright): " + ag1_plan_to_topright);
							ag1_close_to_topright = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(topright): " + ag1_close_to_topright);
							ag1_plan_to_bottomright = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(bottomright, plan_bottomright): " + ag1_plan_to_bottomright);
							ag1_close_to_bottomright = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(bottomright): " + ag1_close_to_bottomright);
							ag1_plan_to_bottomleft = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 get_close_to(bottomleft, plan_bottomleft): " + ag1_plan_to_bottomleft);
							ag1_close_to_bottomleft = random_bool_generator.nextBoolean();
							AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 close_to(bottomleft): " + ag1_close_to_bottomleft);
						}
						
					}
				}
				
				if (testing_thrusters) {
					ag1_broken_x = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 broken x: " + ag1_broken_x);
					if (allthrusters) {
						ag1_broken_y = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 broken y: " + ag1_broken_y);
						ag1_broken_z = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 broken z: " + ag1_broken_z);
					}
					ag1_tl_1x = random_bool_generator.nextBoolean();
					AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 thruster_line(x, 1): " + ag1_tl_1x);
					if (allthrusters) {
						ag1_tl_1y = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 thruster_line(y, 1): " + ag1_tl_1y);
						ag1_tl_1z = random_bool_generator.nextBoolean();
						AJPFLogger.info("eass.verification.leo.LEOVerificationEnvironment", "Random ag1 thruster_line(z, 1): " + ag1_tl_1z);
					}
				}
			}
			
			if (ag1_close_to_middle) {
				percepts.add(close_to_middle);
			}
			if (ag1_plan_to_middle) {
				percepts.add(plan_to_middle);
			}
			if (ag1_close_to_left) {
				percepts.add(close_to_left);
			}
			if (ag1_plan_to_left) {
				percepts.add(plan_to_left);
			}
			if (ag1_close_to_topleft) {
				percepts.add(close_to_topleft);
			}
			if (ag1_plan_to_topleft) {
				percepts.add(plan_to_topleft);
			}
			if (ag1_close_to_right) {
				percepts.add(close_to_right);
			}
			if (ag1_plan_to_right) {
				percepts.add(plan_to_right);
			}
			if (ag1_close_to_topright) {
				percepts.add(close_to_topright);
			}
			if (ag1_plan_to_topright) {
				percepts.add(plan_to_topright);
			}
			if (ag1_close_to_bottomleft) {
				percepts.add(close_to_bottomleft);
			}
			if (ag1_plan_to_bottomleft) {
				percepts.add(plan_to_bottomleft);
			}
			if (ag1_close_to_bottomright) {
				percepts.add(close_to_bottomright);
			}
			if (ag1_plan_to_bottomright) {
				percepts.add(plan_to_bottomright);
			}
			if (ag1_broken_x) {
				percepts.add(broken_x);
			}
			if (ag1_broken_y) {
				percepts.add(broken_y);
			}
			if (ag1_broken_z) {
				percepts.add(broken_z);
			}
			if (ag1_tl_1x) {
				percepts.add(thruster_line_1x);
			}
			if (ag1_tl_1y) {
				percepts.add(thruster_line_1y);
			}
			if (ag1_tl_1z) {
				percepts.add(thruster_line_1z);
			}
			if (ag1_tl_2x) {
				percepts.add(thruster_line_2x);
			}
			if (ag1_tl_2y) {
				percepts.add(thruster_line_2y);
			}
			if (ag1_tl_2z) {
				percepts.add(thruster_line_2z);
			}
			
			change_ag1 = false;
			
		} else {
			return percepts; 
		}
		return percepts;
	}
	

	/**
	 * When the agent executes an action then something may change.  This method doesn't do anything except alter the flags for generating random numbers.
	 */
   public Unifier executeAction(String agName, Action act) throws AILexception {
	   	
    	if (!act.getFunctor().equals("remove_shared")) {
    		change_for(agName);
    	}
 	   		   	 
    	return super.executeAction(agName, act);
    }
   
      
   /**
    * Manage flags indicating which agents may have things change.
    * @param name
    */
   public void change_for(String name) {
	   if (name.equals("ag1")) {
		   change_ag1 = true;
		   change_message_ag1 = true;		   
	   }
	   if (name.equals("aglead")) {
		   change_message_aglead = true;
	   }
   }
   
 	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig configuration) {
		super.configure(configuration);
		
		if (configuration.containsKey("testing_movement")) {
			testing_movement = Boolean.valueOf((String) configuration.get("testing_movement"));
		}
		if (configuration.containsKey("testing_thrusters")) {
			testing_thrusters = Boolean.valueOf((String) configuration.get("testing_thrusters"));
		}
		if (configuration.containsKey("allthrusters")) {
			allthrusters = Boolean.valueOf((String) configuration.get("allthrusters"));
		}
		if (configuration.containsKey("allpositions")) {
			allpositions = Boolean.valueOf((String) configuration.get("allpositions"));
		}

		if (configuration.containsKey("formation_line")) {
			formation_line = Boolean.valueOf((String) configuration.get("formation_line"));
		}
		if (configuration.containsKey("formation_square")) {
			formation_square = Boolean.valueOf((String) configuration.get("formation_square"));
		}

		if (configuration.containsKey("all_can_break")) {
			all_can_break = Boolean.valueOf((String) configuration.get("all_can_break"));
		}

		if (configuration.containsKey("requesting_positions")) {
			requesting_positions = Boolean.valueOf((String) configuration.get("requesting_positions"));
		}


		if (configuration.containsKey("requesting_formation")) {
			requesting_formation = Boolean.valueOf((String) configuration.get("requesting_formation"));
		}
		
		if (configuration.containsKey("agname")) {
			agName = configuration.getProperty("agname");
		}


		if (configuration.containsKey("changing_formation")) {
			changing_formations = Boolean.valueOf((String) configuration.get("changing_formations"));
			if (changing_formations) {
				formation_line = true;
				formation_square = true;
			} else {
				if (configuration.containsKey("initial_formation")) {
					if (configuration.get("initial_formation").equals("line")) {
						formation_line = true;
						formation_square = false;
					} else {
						formation_line = false;
						formation_square = true;
					}
				} else {
					formation_line = true;
					formation_square = false;
				}
			}
		}
	}



}

