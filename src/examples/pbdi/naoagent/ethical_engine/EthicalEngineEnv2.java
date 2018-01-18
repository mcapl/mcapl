// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis and Michael Fisher
//
// This file is part of the Python BDI Agent Model (PBDI) Library.
// 
// The PBDI Library is free software; you can redistribute it and/or
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

public class EthicalEngineEnv2 extends PBDIVerificationEnvironment {
	String logname = "pbdi.naoagent.ethical_engine.EthicalEngineEnv2";
	int num_plans = 3;
	
	public Set<Predicate> getPercepts(String agName, boolean update) {
		// System.err.println("HERE1");
		return super.getPercepts(agName, update);
	}

	@Override
	public Set<Predicate> generate_sharedbeliefs() { 
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		boolean too_close_to_human = true;
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
	
	
	public Set<PythonCalculation> generate_calcs() {
		TreeSet<PythonCalculation> calcs = new TreeSet<PythonCalculation>();
		
		ArrayList<String> strings = new ArrayList<String>();
		for (int i=1; i <= num_plans; i++) {
			String plan_string = "plan" + i;
			strings.add(plan_string);
		}
		
		EthicalEngineEnv.EthicsOrder order = new EthicalEngineEnv.EthicsOrder(strings);
		
		/* PythonCalculation waittime12 = new PythonCalculation(new Literal("plan1.wait_timeLTplan2.wait_time"));
		waittime12.addTerm(new Literal("plan1"));
		waittime12.addTerm(new Literal("plan2"));
		
		PythonCalculation waittime13 = new PythonCalculation(new Literal("plan1.wait_timeLTplan2.wait_time"));
		waittime13.addTerm(new Literal("plan1"));
		waittime13.addTerm(new Literal("plan3"));

		PythonCalculation waittime23 = new PythonCalculation(new Literal("plan1.wait_timeLTplan2.wait_time"));
		waittime23.addTerm(new Literal("plan2"));
		waittime23.addTerm(new Literal("plan3"));
		calcs.add(waittime12);
		calcs.add(waittime13);
		calcs.add(waittime23); */
				

		order.addWalkingTime("plan1", "plan2");
		order.addWalkingTime("plan1", "plan3");
		order.addWalkingTime("plan2", "plan3");
		
		order.addHumanDanger("plan1", "plan2");

		order.addRobotObj("plan2", "plan1");
		order.addRobotObj("plan3", "plan1");

		// order.addRobotObj("plan3", "plan1");
		int robot_danger_int = order.check_constraints_robot_obj("plan2", "plan3");
		
		/* for (int i=1; i <= num_plans; i++) {
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
		} */

		/* PythonCalculation worse_rdd = new PythonCalculation(new Literal("much_worse_plan1_plan2_robot_danger_dist_"));
		PythonCalculation worse_rdd_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_robot_danger_dist_"));
		worse_rdd.addTerm(new Literal("plan1"));
		worse_rdd.addTerm(new Literal("plan2"));
		worse_rdd_flip.addTerm(new Literal("plan2"));
		worse_rdd_flip.addTerm(new Literal("plan1"));
		calcs.add(worse_rdd);
		calcs.add(worse_rdd_flip);
				
		PythonCalculation worse_rod = new PythonCalculation(new Literal("much_worse_plan1_plan2_robot_obj_dist_"));
		PythonCalculation worse_rod_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_robot_obj_dist_"));
		worse_rod.addTerm(new Literal("plan1"));
		worse_rod.addTerm(new Literal("plan2"));
		worse_rod_flip.addTerm(new Literal("plan2"));
		worse_rod_flip.addTerm(new Literal("plan1"));
		calcs.add(worse_rod);
		calcs.add(worse_rod_flip); */

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
