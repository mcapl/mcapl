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

public class EthicalEngineEnv_Unconstrained extends PBDIVerificationEnvironment {
	String logname = "pbdi.naoagent.ethical_engine.EthicalEngineEnv";
	int num_plans = 2;
	
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
	
	public Set<PythonCalculation> generate_calcs() {
		TreeSet<PythonCalculation> calcs = new TreeSet<PythonCalculation>();
		
		for (int i=1; i <= num_plans; i++) {
			for (int j=i + 1; j <= num_plans; j++ ) {
				String plan1_string = "plan" + i;
				String plan2_string = "plan" + j;
					
				boolean p1wtlessp2rdd = random_bool_generator.nextBoolean();
				PythonCalculation waittime = new PythonCalculation(new Literal("plan1.wait_timeLTplan2.wait_time"));
				if (p1wtlessp2rdd) {
					waittime.addTerm(new Literal(plan1_string));
					waittime.addTerm(new Literal(plan2_string));
					AJPFLogger.info(logname, plan1_string + ".wait time less than " + plan2_string + ".wait time");						
				} else {
					waittime.addTerm(new Literal(plan2_string));
					waittime.addTerm(new Literal(plan1_string));
					AJPFLogger.info(logname, plan2_string + ".wait time less than " + plan1_string + ".wait time");											
				}
				calcs.add(waittime);
				
				boolean p1rwdlessp2rdd = random_bool_generator.nextBoolean();
				PythonCalculation walking_dist = new PythonCalculation(new Literal("plan1.robot_walking_distLTplan2.robot_walking_dist"));
				if (p1rwdlessp2rdd) {
					walking_dist.addTerm(new Literal(plan1_string));
					walking_dist.addTerm(new Literal(plan2_string));
					AJPFLogger.info(logname, plan1_string + ".robot_walking_dist less than " + plan2_string + ".walking_dist");						
				} else {
					walking_dist.addTerm(new Literal(plan2_string));
					walking_dist.addTerm(new Literal(plan1_string));
					AJPFLogger.info(logname, plan2_string + ".robot_walking_dist less than " + plan1_string + ".walking_dist");											
				}
				calcs.add(walking_dist);
				
				int p1much_worsep2rdd = random_int_generator.nextInt(3);
				PythonCalculation worse_rdd = new PythonCalculation(new Literal("much_worse_plan1_plan2_robot_danger_dist_"));
				PythonCalculation worse_rdd_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_robot_danger_dist_"));
				if (p1much_worsep2rdd == 0) {
					worse_rdd.addTerm(new Literal(plan1_string));
					worse_rdd.addTerm(new Literal(plan2_string));
					worse_rdd_flip.addTerm(new Literal(plan2_string));
					worse_rdd_flip.addTerm(new Literal(plan1_string));
					AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_danger_dist')");
					calcs.add(worse_rdd);
					calcs.add(worse_rdd_flip);
				} else if (p1much_worsep2rdd == 1) {
					worse_rdd.addTerm(new Literal(plan2_string));
					worse_rdd.addTerm(new Literal(plan1_string));
					worse_rdd_flip.addTerm(new Literal(plan1_string));
					worse_rdd_flip.addTerm(new Literal(plan2_string));
					AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_danger_dist')");
					calcs.add(worse_rdd);
					calcs.add(worse_rdd_flip);
				} else {
					AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_danger_dist");
				}
				
				int p1much_worsep2rod = random_int_generator.nextInt(3);
				PythonCalculation worse_rod = new PythonCalculation(new Literal("much_worse_plan1_plan2_robot_obj_dist_"));
				PythonCalculation worse_rod_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_robot_obj_dist_"));
				if (p1much_worsep2rod == 0) {
					worse_rod.addTerm(new Literal(plan1_string));
					worse_rod.addTerm(new Literal(plan2_string));
					worse_rod_flip.addTerm(new Literal(plan2_string));
					worse_rod_flip.addTerm(new Literal(plan1_string));
					AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'robot_obj_dist')");
					calcs.add(worse_rod);
					calcs.add(worse_rod_flip);
				} else if (p1much_worsep2rod == 1) {
					worse_rod.addTerm(new Literal(plan2_string));
					worse_rod.addTerm(new Literal(plan1_string));
					worse_rod_flip.addTerm(new Literal(plan1_string));
					worse_rod_flip.addTerm(new Literal(plan2_string));
					AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'robot_obj_dist')");
					calcs.add(worse_rod);
					calcs.add(worse_rod_flip);
				} else {
					AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close robot_obj_dist");
				}
				
				int p1much_worsep2hdd = random_int_generator.nextInt(3);
				PythonCalculation worse_hdd = new PythonCalculation(new Literal("much_worse_plan1_plan2_human_danger_dist_"));
				PythonCalculation worse_hdd_flip = new PythonCalculation(new Literal("much_worse_plan2_plan1_human_danger_dist_"));
				if (p1much_worsep2hdd == 0) {
					worse_hdd.addTerm(new Literal(plan1_string));
					worse_hdd.addTerm(new Literal(plan2_string));
					worse_hdd_flip.addTerm(new Literal(plan2_string));
					worse_hdd_flip.addTerm(new Literal(plan1_string));
					AJPFLogger.info(logname, "much_worse(" + plan1_string + ", " + plan2_string + ", 'human_danger_dist')");
					calcs.add(worse_hdd);
					calcs.add(worse_hdd_flip);
				} else if (p1much_worsep2hdd == 1) {
					worse_hdd.addTerm(new Literal(plan2_string));
					worse_hdd.addTerm(new Literal(plan1_string));
					worse_hdd_flip.addTerm(new Literal(plan1_string));
					worse_hdd_flip.addTerm(new Literal(plan2_string));
					AJPFLogger.info(logname, "much_worse(" + plan2_string + ", " + plan1_string + ", 'human_danger_dist')");
					calcs.add(worse_hdd);
					calcs.add(worse_hdd_flip);
				} else {
					AJPFLogger.info(logname, plan1_string + " and " + plan2_string + " have close human_danger_dist");
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
