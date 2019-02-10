// ----------------------------------------------------------------------------
// Copyright (C) 2019 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The PBDI Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the PBDI Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package pbdi.naoagent.ethical_engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import ail.mas.DefaultEnvironment;
import ail.mas.scheduling.SingleAgentScheduler;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;
import ajpf.util.choice.UniformIntChoice;
import pbdi.mas.verification.PBDIVerificationEnvironment;
import pbdi.syntax.PythonCalculation;

public class EthicalEngineEnv extends PBDIVerificationEnvironment {
	String logname = "pbdi.naoagent.ethical_engine.EthicalEngineEnv";
	int num_plans = 3;
	
	public Set<Predicate> getPercepts(String agName, boolean update) {
		// System.err.println("HERE1");
		return super.getPercepts(agName, update);
	}

	@Override
	public Set<Predicate> generate_sharedbeliefs() { 
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean too_close_to_human = random_bool_generator.nextBoolean();
		if (too_close_to_human) {
			percepts.add(new Predicate("danger_close"));
			AJPFLogger.info(logname, "Danger Close to Human");
		} else {
			AJPFLogger.info(logname, "Danger not close to  human");
		}
		
		for (int i=1; i<=num_plans; i++) {
			String plan_string = "plan" + i;
			Predicate plan1 = new Predicate("plans");
			plan1.addTerm(new Predicate(plan_string));
			percepts.add(plan1);
		}

		return percepts;
	}
	
	public static class EthicsOrder {
		private class Tuple {
			String lhs;
			String rhs;
			
			public Tuple(String l, String r) {
				lhs = l;
				rhs = r;
			}
			
			@Override
			public boolean equals(Object o) {
				if (o instanceof Tuple) {
					Tuple t = (Tuple) o;
					if (t.getLHS().equals(lhs) & t.getRHS().equals(rhs)) {
						return true;
					}
				}
				return false;
			}
			
			@Override
			public int hashCode() {
				return lhs.hashCode() + rhs.hashCode();
			}
			
			public String getLHS() {
				return lhs;
			}
			
			public String getRHS() {
				return rhs;
			}
			
			public String toString() {
				return "(" + lhs + ", " + rhs + ")";
			}
		}
		
		private HashSet<Tuple> human_danger_order = new HashSet<Tuple>();
		private HashSet<Tuple> robot_obj_order = new HashSet<Tuple>();
		private HashSet<Tuple> robot_danger_order = new HashSet<Tuple>();
		private HashSet<Tuple> walking_time_order = new HashSet<Tuple>();
		private HashSet<Tuple> wait_time_order = new HashSet<Tuple>();
		
		private ArrayList<String> strings;
		
		public EthicsOrder(ArrayList<String> s) {
			strings = s;
		}
		
		public void addHumanDanger(String a, String b) {
			add(human_danger_order, new Tuple(a, b));
		}
		
		public void addWaitTime(String a, String b) {
			add(wait_time_order, new Tuple(a, b));
		}
		
		public void addWalkingTime(String a, String b) {
			add(walking_time_order, new Tuple(a, b));
		}
		public void addRobotObj(String a, String b) {
			add(robot_obj_order, new Tuple(a, b));
		}
		public void addRobotDanger(String a, String b) {
			add(robot_danger_order, new Tuple(a, b));
		}
		
		public boolean add(HashSet<Tuple> ts, Tuple t) {
			if (! ts.contains(t)) {
				Tuple reverse_tuple = new Tuple(t.getRHS(), t.getLHS());
				if (ts.contains(reverse_tuple)) {
					return false;
				}
				ts.add(t);
				HashSet<Tuple> new_ts = transitive_closure(ts, t.getLHS(), t.getRHS());
				if (new_ts == null) {
					return false;
				}
				ts.addAll(new_ts);
				return true;
			}
						
			/* if (!consistent(human_danger_order, robot_obj_order, robot_danger_order, walking_time_order) || !consistent(human_danger_order, robot_obj_order, robot_danger_order, wait_time_order)) {
				System.err.println("DANGER");
				System.exit(1);
			} */
			return true;
		}
		
		public  boolean add(HashSet<Tuple> ts, Tuple t, String lhsl, String rhsl) {
			if (! ts.contains(t)) {
				Tuple reverse_tuple = new Tuple(t.getRHS(), t.getLHS());
				if (ts.contains(reverse_tuple)) {
					return false;
				}
				ts.add(t);
				HashSet<Tuple> new_ts = transitive_closure(ts, lhsl, rhsl);
				if (new_ts == null) {
					return false;
				}
				ts.addAll(new_ts);
				return true;
			}
			
			/* if (!consistent(human_danger_order, robot_obj_order, robot_danger_order, walking_time_order) || !consistent(human_danger_order, robot_obj_order, robot_danger_order, wait_time_order)) {
				System.err.println("DANGER");
				System.exit(1);
			} */
			return true;
		}
		

		private HashSet<Tuple> transitive_closure(HashSet<Tuple> ts, String lhs, String rhs) {
			int index_l = strings.indexOf(lhs);
			int index_r = strings.indexOf(rhs);
			int index1 = 0;
			int index2 = 0;
			
			if (index_l < index_r) {
				index1 = index_l;
				index2 = index_r;
			} else {
				index1 = index_r;
				index2 = index_l;
			}
			
			HashSet<Tuple> ts_clone = (HashSet<Tuple>) ts.clone();
			boolean safe_to_add = true;
			
			for (int index_s1 = 0; index_s1 < strings.size(); index_s1++) {
				String s1 = strings.get(index_s1);
				for (int index_s2 = 0; index_s2 < strings.size(); index_s2++) {
					String s2 = strings.get(index_s2);
					if (! s1.equals(s2)) {
						Tuple t = new Tuple(s1, s2);
						if (!ts_clone.contains(t)) {
							for (int index_s3 = 0; index_s3 < strings.size(); index_s3++) {
								String s3 = strings.get(index_s3);
								if (!s1.equals(s3) && !s2.equals(s3)) {
									Tuple t1 = new Tuple(s1, s3);
									Tuple t2 = new Tuple(s3, s2);
									if (ts_clone.contains(t1) && ts_clone.contains(t2)) {
										if (index_s1 > index1 && index_s2 > index1) {
											safe_to_add = add(ts_clone, t, lhs, rhs);
											if (!safe_to_add) {
												return null;
											}
										} else if ((index_s1 == index1 && index_s2 > index2) || (index_s2 == index1 && index_s1 > index2)) {
											safe_to_add = add(ts_clone, t, lhs, rhs);
											if (!safe_to_add) {
												return null;
											}
										} else {
											return null;
										}
									}
								}
							}
						}
					}
				}
			}
			
			// ts = ts_clone;
			return ts_clone;
		}
		
		public boolean less_than(Set<Tuple> order1, Set<Tuple> order2, Set<Tuple> order3, Set<Tuple> order4, String a, String b) {
			Tuple t = new Tuple(a, b);
			Tuple t2 = new Tuple(b, a);
			if (order1.contains(t)) return true;
			else if (order1.contains(t2)) return false;
			else if (order2.contains(t)) return true;
			else if (order2.contains(t2)) return false;
			else if (order3.contains(t)) return true;
			else if (order3.contains(t2)) return false;
			else if (order4.contains(t2)) return true;
			else return false;
		}
		
		public boolean consistent(Set<Tuple> order1, Set<Tuple> order2, Set<Tuple> order3, Set<Tuple> order4) {
			HashSet<Tuple> trial_order = new HashSet<Tuple>();
			for (int i = 0; i < strings.size(); i++) {
				String s1 = strings.get(i);
				for (int j = i + 1; j < strings.size(); j++) {
					String s2 = strings.get(j);
					if (!s1.equals(s2)) {
						if (less_than(order1, order2, order3, order4, s1, s2)) {
							boolean cando = add(trial_order, new Tuple(s1, s2));
							if (!cando) {
								return false;
							}
						}
						
						if (less_than(order1, order2, order3, order4, s2, s1)) {
							boolean cando = add(trial_order, new Tuple(s2, s1));
							if (!cando) {
								return false;
							}							
						}
					}
				}
			}
			
			return true;
		}
		
		public int check_constraints_human_danger(String a, String b) {
			return check_constraints(1, human_danger_order, a, b);			
		}
		
		public int check_constraints_wait_time(String a, String b) {
			return check_constraints(4, wait_time_order, a, b);
		}
		
		public int check_constraints_walking_time(String a, String b) {
			return check_constraints(4, walking_time_order, a, b);
		}
		public int check_constraints_robot_obj(String a, String b) {
			return check_constraints(2, robot_obj_order, a, b);
		}
		public int check_constraints_robot_danger(String a, String b) {
			return check_constraints(3, robot_danger_order, a, b);
		}
		/**
		 * A return of 1 means a < b
		 * A return of 2 means b < a
		 * A return of 3 means not a < b
		 * A return of 4 means not b < a
		 * A return of 5 means "no constraint"
		 * A return of 6 means neither a < b nor b < a
		 * @param order_num
		 * @param ts
		 * @param a
		 * @param b
		 * @return
		 */
		public int check_constraints(int order_num, HashSet<Tuple> ts, String a, String b) {
			
			// This tuple already constrains these inputs -- keep the tuple consistent
			// System.err.println("Checking constraints: " + ts + " with " + a + " and " + b);
			Tuple t = new Tuple(a, b);
			if (ts.contains(t)) {
				return 1;
			}
			Tuple t1 = new Tuple(b, a);
			if (ts.contains(t1)) {
				return 2;
			}
			
			
			HashSet<Tuple> hypothetical = (HashSet<Tuple>) ts.clone();
			boolean safe_to_add1 = add(hypothetical, new Tuple(a, b));
			
			HashSet<Tuple> hypothetical2 = (HashSet<Tuple>) ts.clone();
			boolean safe_to_add2 = add(hypothetical2, new Tuple(b, a));
			
			if (!safe_to_add1 && !safe_to_add2) {
				// System.err.println("c");
				return 6;
			} 

			if (safe_to_add1 && safe_to_add2) {
				if (order_num == 1) {
					if (consistent(hypothetical, robot_obj_order, robot_danger_order, walking_time_order) && 
							consistent(hypothetical, robot_obj_order, robot_danger_order, wait_time_order)) {
						if (consistent(hypothetical2, robot_obj_order, robot_danger_order, walking_time_order) && 
							consistent(hypothetical2, robot_obj_order, robot_danger_order, wait_time_order)) {
								// System.err.println("f");
								return 5;
							} else {
								//System.err.println("g");
								return 4;
							}
					} else {
						if (!consistent(hypothetical2, robot_obj_order, robot_danger_order, walking_time_order) || !consistent(hypothetical2, robot_obj_order, robot_danger_order, wait_time_order)) {
							// System.err.println("h");
							return 6;
						}
						// System.err.println("i");
						return 3;
					}
				} else if (order_num == 2) {
					if (consistent(human_danger_order, hypothetical, robot_danger_order, walking_time_order) && 
							consistent(human_danger_order, hypothetical, robot_danger_order, wait_time_order)) {
						if (consistent(human_danger_order, hypothetical2, robot_danger_order, walking_time_order) && 
							consistent(human_danger_order, hypothetical2, robot_danger_order, wait_time_order)) {
								// System.err.println("k");
								return 5;
							} else {
								// System.err.println("l");
								return 4;
							}
					} else {
						if (!consistent(human_danger_order, hypothetical2, robot_danger_order, walking_time_order) || !consistent(human_danger_order, hypothetical2, robot_danger_order, wait_time_order)) {
							// System.err.println("m");
							return 6;
						}
						// System.err.println("n");
						return 3;
					}
				} else if (order_num == 3 ) {
					if (consistent(human_danger_order, robot_obj_order, hypothetical, walking_time_order) && 
							consistent(human_danger_order, robot_obj_order, hypothetical, wait_time_order)) {
						if (consistent(human_danger_order, robot_obj_order, hypothetical2, walking_time_order) && 
							consistent(human_danger_order, robot_obj_order, hypothetical2, wait_time_order)) {
								return 5;
							} else {
								return 4;
							}
					} else {
						if (!consistent(human_danger_order, robot_obj_order, hypothetical2, walking_time_order) || !consistent(human_danger_order, robot_obj_order, hypothetical2, wait_time_order)) {
							return 6;
						}
						return 3;
					}
				} else  {
					if (consistent(human_danger_order, robot_obj_order, robot_danger_order, hypothetical)) {
						if (consistent(human_danger_order, robot_obj_order, robot_danger_order, hypothetical2)) {
								return 5;
							} else {
								return 4;
							}
					} else {
						if (!consistent(human_danger_order, robot_obj_order, robot_danger_order, hypothetical2) ) {
							return 6;
						}
						return 3;
					}
				}
			} else if (safe_to_add1) {
				if (order_num == 1) {
					if (consistent(hypothetical, robot_obj_order, robot_danger_order, walking_time_order) && 
							consistent(hypothetical, robot_obj_order, robot_danger_order, wait_time_order)) {
							System.err.println("g");
							return 4;
					} else {
							return 6;
					}
				} else if (order_num == 2) {
					if (consistent(human_danger_order, hypothetical, robot_danger_order, walking_time_order) && 
							consistent(human_danger_order, hypothetical, robot_danger_order, wait_time_order)) {
								return 4;
					} else {
							return 6;
					}
				} else if (order_num == 3 ) {
					if (consistent(human_danger_order, robot_obj_order, hypothetical, walking_time_order) && 
							consistent(human_danger_order, robot_obj_order, hypothetical, wait_time_order)) {
								return 4;
					} else {
							return 6;
					}
				} else  {
					if (consistent(human_danger_order, robot_obj_order, robot_danger_order, hypothetical)) {
								return 4;
					} else {
							return 6;
					}
				}				
			} else {
				if (order_num == 1) {
						if (!consistent(hypothetical2, robot_obj_order, robot_danger_order, walking_time_order) || !consistent(hypothetical2, robot_obj_order, robot_danger_order, wait_time_order)) {
							return 6;
						}
						return 3;
				} else if (order_num == 2) {
						if (!consistent(human_danger_order, hypothetical2, robot_danger_order, walking_time_order) || !consistent(human_danger_order, hypothetical2, robot_danger_order, wait_time_order)) {
							// System.err.println("m");
							return 6;
						}
						// System.err.println("n");
						return 3;
				} else if (order_num == 3 ) {
						if (!consistent(human_danger_order, robot_obj_order, hypothetical2, walking_time_order) || !consistent(human_danger_order, robot_obj_order, hypothetical2, wait_time_order)) {
							return 6;
						}
						return 3;
				} else  {
						if (!consistent(human_danger_order, robot_obj_order, robot_danger_order, hypothetical2) ) {
							return 6;
						}
						return 3;
				}
			}
				
		}
	}
	
	public Set<PythonCalculation> generate_calcs() {
		TreeSet<PythonCalculation> calcs = new TreeSet<PythonCalculation>();
		
		ArrayList<String> strings = new ArrayList<String>();
		for (int i=1; i <= num_plans; i++) {
			String plan_string = "plan" + i;
			strings.add(plan_string);
		}
		
		EthicsOrder order = new EthicsOrder(strings);
		
		for (int i=1; i <= num_plans; i++) {
			for (int j=i + 1; j <= num_plans; j++ ) {
				String plan1_string = "plan" + i;
				String plan2_string = "plan" + j;
				
				PythonCalculation waittime = new PythonCalculation(new Literal("plan1.wait_timeLTplan2.wait_time"));
				int wait_int = order.check_constraints_wait_time(plan1_string, plan2_string);
				if (wait_int == 1 || wait_int == 4) {
					waittime.addTerm(new Literal(plan1_string));
					waittime.addTerm(new Literal(plan2_string));
					order.addWaitTime(plan1_string, plan2_string);
					AJPFLogger.info(logname, plan1_string + ".wait time less than " + plan2_string + ".wait time");											
				} else if (wait_int == 2 || wait_int == 3) {
					waittime.addTerm(new Literal(plan2_string));
					waittime.addTerm(new Literal(plan1_string));
					order.addWaitTime(plan2_string, plan1_string);
					AJPFLogger.info(logname, plan2_string + ".wait time less than " + plan1_string + ".wait time");																
				} else {
					boolean p1wtlessp2rdd = random_bool_generator.nextBoolean();
					if (p1wtlessp2rdd) {
						waittime.addTerm(new Literal(plan1_string));
						waittime.addTerm(new Literal(plan2_string));
						order.addWaitTime(plan1_string, plan2_string);
						AJPFLogger.info(logname, plan1_string + ".wait time less than " + plan2_string + ".wait time");						
					} else {
						waittime.addTerm(new Literal(plan2_string));
						waittime.addTerm(new Literal(plan1_string));
						order.addWaitTime(plan2_string, plan1_string);
						AJPFLogger.info(logname, plan2_string + ".wait time less than " + plan1_string + ".wait time");											
					}
				}
				calcs.add(waittime);
			}
		}
				
		for (int i=1; i <= num_plans; i++) {
			for (int j=i + 1; j <= num_plans; j++ ) {
				String plan1_string = "plan" + i;
				String plan2_string = "plan" + j;

				PythonCalculation walking_dist = new PythonCalculation(new Literal("plan1.robot_walking_distLTplan2.robot_walking_dist"));
				int walking_int = order.check_constraints_walking_time(plan1_string, plan2_string);
				if (walking_int == 1 || walking_int == 4) {
					walking_dist.addTerm(new Literal(plan1_string));
					walking_dist.addTerm(new Literal(plan2_string));
					order.addWalkingTime(plan1_string, plan2_string);
					AJPFLogger.info(logname, plan1_string + ".robot_walking_dist less than " + plan2_string + ".walking_dist");											
				} else  if (walking_int == 2 || walking_int == 3) {
					walking_dist.addTerm(new Literal(plan2_string));
					walking_dist.addTerm(new Literal(plan1_string));
					order.addWalkingTime(plan2_string, plan1_string);
					AJPFLogger.info(logname, plan2_string + ".robot_walking_dist less than " + plan1_string + ".walking_dist");																
				} else {
					boolean p1rwdlessp2rdd = random_bool_generator.nextBoolean();
					if (p1rwdlessp2rdd) {
						walking_dist.addTerm(new Literal(plan1_string));
						walking_dist.addTerm(new Literal(plan2_string));
						order.addWalkingTime(plan1_string, plan2_string);
						AJPFLogger.info(logname, plan1_string + ".robot_walking_dist less than " + plan2_string + ".walking_dist");						
					} else {
						walking_dist.addTerm(new Literal(plan2_string));
						walking_dist.addTerm(new Literal(plan1_string));
						order.addWalkingTime(plan2_string, plan1_string);
						AJPFLogger.info(logname, plan2_string + ".robot_walking_dist less than " + plan1_string + ".walking_dist");											
					}
				}
				calcs.add(walking_dist);
			}
		}
		
		/* PythonCalculation worse_hdd = new PythonCalculation(new Literal("much_worse_plan1_plan2_human_danger_dist_"));
		PythonCalculation worse_hdd_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_human_danger_dist_"));
		worse_hdd.addTerm(new Literal("plan1"));
		worse_hdd.addTerm(new Literal("plan2"));
		worse_hdd_flip.addTerm(new Literal("plan2"));
		worse_hdd_flip.addTerm(new Literal("plan1"));
		order.addHumanDanger("plan1", "plan2");
		calcs.add(worse_hdd);
		calcs.add(worse_hdd_flip); */
		for (int i=1; i <= num_plans; i++) {
			for (int j=i + 1; j <= num_plans; j++ ) {
				String plan1_string = "plan" + i;
				String plan2_string = "plan" + j;

				
				PythonCalculation worse_hdd = new PythonCalculation(new Literal("much_worse_plan1_plan2_human_danger_dist_"));
				PythonCalculation worse_hdd_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_human_danger_dist_"));
				int human_danger_int = order.check_constraints_human_danger(plan1_string, plan2_string);
				if (human_danger_int == 1) {
					worse_hdd.addTerm(new Literal(plan1_string));
					worse_hdd.addTerm(new Literal(plan2_string));
					worse_hdd_flip.addTerm(new Literal(plan2_string));
					worse_hdd_flip.addTerm(new Literal(plan1_string));
					AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'human_danger_dist')");
					calcs.add(worse_hdd);
					calcs.add(worse_hdd_flip);
					order.addHumanDanger(plan1_string, plan2_string);					
				} else if (human_danger_int == 2) {
					worse_hdd.addTerm(new Literal(plan2_string));
					worse_hdd.addTerm(new Literal(plan1_string));
					worse_hdd_flip.addTerm(new Literal(plan1_string));
					worse_hdd_flip.addTerm(new Literal(plan2_string));
					AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'human_danger_dist')");
					calcs.add(worse_hdd);
					calcs.add(worse_hdd_flip);
					order.addHumanDanger(plan2_string, plan1_string);					
				} else if (human_danger_int == 3) {
					boolean p1much_worsep2hdd = random_bool_generator.nextBoolean();
					if (p1much_worsep2hdd) {
						worse_hdd.addTerm(new Literal(plan2_string));
						worse_hdd.addTerm(new Literal(plan1_string));
						worse_hdd_flip.addTerm(new Literal(plan1_string));
						worse_hdd_flip.addTerm(new Literal(plan2_string));
						AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'human_danger_dist')");
						calcs.add(worse_hdd);
						calcs.add(worse_hdd_flip);
						order.addHumanDanger(plan2_string, plan1_string);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close human_danger_dist");
					}
				} else if (human_danger_int == 4) {
					boolean p1much_worsep2hdd = random_bool_generator.nextBoolean();
					if (p1much_worsep2hdd) {
						worse_hdd.addTerm(new Literal(plan1_string));
						worse_hdd.addTerm(new Literal(plan2_string));
						worse_hdd_flip.addTerm(new Literal(plan2_string));
						worse_hdd_flip.addTerm(new Literal(plan1_string));
						AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'human_danger_dist')");
						calcs.add(worse_hdd);
						calcs.add(worse_hdd_flip);
						order.addHumanDanger(plan1_string, plan2_string);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close human_danger_dist");
					}					
				} else if (human_danger_int == 5) {
					int p1much_worsep2hdd = random_int_generator.nextInt(3);
					if (p1much_worsep2hdd == 0) {
						worse_hdd.addTerm(new Literal(plan1_string));
						worse_hdd.addTerm(new Literal(plan2_string));
						worse_hdd_flip.addTerm(new Literal(plan2_string));
						worse_hdd_flip.addTerm(new Literal(plan1_string));
						AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'human_danger_dist')");
						calcs.add(worse_hdd);
						calcs.add(worse_hdd_flip);
						order.addHumanDanger(plan1_string, plan2_string);
					} else if (p1much_worsep2hdd == 1) {
						worse_hdd.addTerm(new Literal(plan2_string));
						worse_hdd.addTerm(new Literal(plan1_string));
						worse_hdd_flip.addTerm(new Literal(plan1_string));
						worse_hdd_flip.addTerm(new Literal(plan2_string));
						AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'human_danger_dist')");
						calcs.add(worse_hdd);
						calcs.add(worse_hdd_flip);
						order.addHumanDanger(plan2_string, plan1_string);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close human_danger_dist");
					}
				} else {
					AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close human_danger_dist");
				}
			}
		} 
				
		for (int i=1; i <= num_plans; i++) {
			for (int j=i + 1; j <= num_plans; j++ ) {
				String plan1_string = "plan" + i;
				String plan2_string = "plan" + j;
				
				PythonCalculation worse_rod = new PythonCalculation(new Literal("much_worse_plan1_plan2_robot_obj_dist_"));
				PythonCalculation worse_rod_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_robot_obj_dist_"));
				int robot_obj_int = order.check_constraints_robot_obj(plan1_string, plan2_string);
				// System.err.println("ROBOT OBJ" + robot_obj_int);
				if (robot_obj_int == 1) {
					worse_rod.addTerm(new Literal(plan1_string));
					worse_rod.addTerm(new Literal(plan2_string));
					worse_rod_flip.addTerm(new Literal(plan2_string));
					worse_rod_flip.addTerm(new Literal(plan1_string));
					order.addRobotObj(plan1_string, plan2_string);
					AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_obj_dist')");
					calcs.add(worse_rod);
					calcs.add(worse_rod_flip);					
				} else if (robot_obj_int == 2) {
					worse_rod.addTerm(new Literal(plan2_string));
					worse_rod.addTerm(new Literal(plan1_string));
					worse_rod_flip.addTerm(new Literal(plan1_string));
					worse_rod_flip.addTerm(new Literal(plan2_string));
					order.addRobotObj(plan2_string, plan1_string);
					AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_obj_dist')");
					calcs.add(worse_rod);
					calcs.add(worse_rod_flip);					
				} else if (robot_obj_int == 3) {
					boolean p1much_worsep2rod = random_bool_generator.nextBoolean();
					if (p1much_worsep2rod) {
						worse_rod.addTerm(new Literal(plan2_string));
						worse_rod.addTerm(new Literal(plan1_string));
						worse_rod_flip.addTerm(new Literal(plan1_string));
						worse_rod_flip.addTerm(new Literal(plan2_string));
						order.addRobotObj(plan2_string, plan1_string);
						AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_obj_dist')");
						calcs.add(worse_rod);
						calcs.add(worse_rod_flip);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_obj_dist");
					}					
				} else if (robot_obj_int == 4) {
					boolean p1much_worsep2rod = random_bool_generator.nextBoolean();
					if (p1much_worsep2rod) {
						worse_rod.addTerm(new Literal(plan1_string));
						worse_rod.addTerm(new Literal(plan2_string));
						worse_rod_flip.addTerm(new Literal(plan2_string));
						worse_rod_flip.addTerm(new Literal(plan1_string));
						order.addRobotObj(plan1_string, plan2_string);
						AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_obj_dist')");
						calcs.add(worse_rod);
						calcs.add(worse_rod_flip);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_obj_dist");
					}					
				} else if (robot_obj_int == 5) {
					int p1much_worsep2rod = random_int_generator.nextInt(3);
					if (p1much_worsep2rod == 0) {
						worse_rod.addTerm(new Literal(plan1_string));
						worse_rod.addTerm(new Literal(plan2_string));
						worse_rod_flip.addTerm(new Literal(plan2_string));
						worse_rod_flip.addTerm(new Literal(plan1_string));
						order.addRobotObj(plan1_string, plan2_string);
						AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_obj_dist')");
						calcs.add(worse_rod);
						calcs.add(worse_rod_flip);
					} else if (p1much_worsep2rod == 1) {
						worse_rod.addTerm(new Literal(plan2_string));
						worse_rod.addTerm(new Literal(plan1_string));
						worse_rod_flip.addTerm(new Literal(plan1_string));
						worse_rod_flip.addTerm(new Literal(plan2_string));
						order.addRobotObj(plan2_string, plan1_string);
						AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_obj_dist')");
						calcs.add(worse_rod);
						calcs.add(worse_rod_flip);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_obj_dist");
					}
				} else {
					AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_obj_dist");					
				}
			}
		}

				
		for (int i=1; i <= num_plans; i++) {
			for (int j=i + 1; j <= num_plans; j++ ) {
				String plan1_string = "plan" + i;
				String plan2_string = "plan" + j;
				
				PythonCalculation worse_rdd = new PythonCalculation(new Literal("much_worse_plan1_plan2_robot_danger_dist_"));
				PythonCalculation worse_rdd_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_robot_danger_dist_"));
				int robot_danger_int = order.check_constraints_robot_danger(plan1_string, plan2_string);
				if (robot_danger_int == 1) {
					worse_rdd.addTerm(new Literal(plan1_string));
					worse_rdd.addTerm(new Literal(plan2_string));
					worse_rdd_flip.addTerm(new Literal(plan2_string));
					worse_rdd_flip.addTerm(new Literal(plan1_string));
					order.addRobotDanger(plan1_string, plan2_string);
					AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_danger_dist')");
					calcs.add(worse_rdd);
					calcs.add(worse_rdd_flip);					
				} else if (robot_danger_int == 2) {
					worse_rdd.addTerm(new Literal(plan2_string));
					worse_rdd.addTerm(new Literal(plan1_string));
					worse_rdd_flip.addTerm(new Literal(plan1_string));
					worse_rdd_flip.addTerm(new Literal(plan2_string));
					order.addRobotDanger(plan2_string, plan1_string);
					AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_danger_dist')");
					calcs.add(worse_rdd);
					calcs.add(worse_rdd_flip);
				} else if (robot_danger_int == 3) {
					boolean p1much_worsep2rdd = random_bool_generator.nextBoolean();
					if (p1much_worsep2rdd) {
						worse_rdd.addTerm(new Literal(plan2_string));
						worse_rdd.addTerm(new Literal(plan1_string));
						worse_rdd_flip.addTerm(new Literal(plan1_string));
						worse_rdd_flip.addTerm(new Literal(plan2_string));
						order.addRobotDanger(plan2_string, plan1_string);
						AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_danger_dist')");
						calcs.add(worse_rdd);
						calcs.add(worse_rdd_flip);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_danger_dist");
					}
				} else if (robot_danger_int == 4) {
					boolean p1much_worsep2rdd = random_bool_generator.nextBoolean();
					if (p1much_worsep2rdd) {
						worse_rdd.addTerm(new Literal(plan1_string));
						worse_rdd.addTerm(new Literal(plan2_string));
						worse_rdd_flip.addTerm(new Literal(plan2_string));
						worse_rdd_flip.addTerm(new Literal(plan1_string));
						order.addRobotDanger(plan1_string, plan2_string);
						AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_danger_dist')");
						calcs.add(worse_rdd);
						calcs.add(worse_rdd_flip);
					} else  {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_danger_dist");
					}					
				} else if (robot_danger_int == 5) {
					int p1much_worsep2rdd = random_int_generator.nextInt(3);
					if (p1much_worsep2rdd == 0) {
						worse_rdd.addTerm(new Literal(plan1_string));
						worse_rdd.addTerm(new Literal(plan2_string));
						worse_rdd_flip.addTerm(new Literal(plan2_string));
						worse_rdd_flip.addTerm(new Literal(plan1_string));
						order.addRobotDanger(plan1_string, plan2_string);
						AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_danger_dist')");
						calcs.add(worse_rdd);
						calcs.add(worse_rdd_flip);
					} else if (p1much_worsep2rdd == 1) {
						worse_rdd.addTerm(new Literal(plan2_string));
						worse_rdd.addTerm(new Literal(plan1_string));
						worse_rdd_flip.addTerm(new Literal(plan1_string));
						worse_rdd_flip.addTerm(new Literal(plan2_string));
						order.addRobotDanger(plan2_string, plan1_string);
						AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_danger_dist')");
						calcs.add(worse_rdd);
						calcs.add(worse_rdd_flip);
					} else {
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_danger_dist");
					}
				} else {
					{
						AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_danger_dist");
					}
				}
			}
		}

		return calcs;
	}

	@Override
	public Set<Message> generate_messages() {
		return new TreeSet<Message>();
	}
	
	@Override
	public String toString() {
		return "Ethical Engine Environment";
	}

}
