// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis, Michael Fisher and Alan Winfield
// 
// This file is part of Declarative Ethical Governor (DEG)
// 
// The DEG is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The DEG is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the DEG; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ethical_governor.human_hole;

import java.util.ArrayList;
import java.util.Iterator;

import ajpf.util.AJPFLogger;
import ajpf.util.choice.Choice;
import ail.mas.MAS;
import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.AILexception;
import ethical_governor.mas.DefaultEthicalGovernorEnv;
import ethical_governor.semantics.EthicalGovernor;
import actiononly.mas.ActionOnlyEnv;

/**
 * This is an environment for an ActionOnly Agent with a Consequence Engine being used to filter
 * out actions.  Two humans proceed randomly towards a hole in the ground which the agent must 
 * also avoid.
 * @author lad
 *
 */
public class HumanHoleGoalEnv extends DefaultEthicalGovernorEnv implements ActionOnlyEnv {
	private String logname = "ethical_governor.human_hole.HumanHoleGoalEnv";
	
	// We use a choice class so PRISM can be used for analysis if desired.
	Choice<Boolean> human_moves;
	
	int robot_x = 0;
	int robot_y = 2;
	
	int human1_x = 0;
	int human1_y = 0;
	
	int human2_x = 0;
	int human2_y = 4;
	
	int hole_x = 2;
	int hole_y = 2;
	
	boolean robot_hole = false;
	boolean human1_hole = false;
	boolean human2_hole = false;
	boolean robot_collision = false;
	boolean human1_collision = false;
	boolean human2_collision = false;

	/**
	 * Constructor.
	 */
	public HumanHoleGoalEnv() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		human_moves = new Choice<Boolean>(m.getController());
		human_moves.addChoice(0.5, false);
		human_moves.addChoice(0.5, true);

	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		double target_x = ((NumberTerm) act.getTerm(0)).solve();
		double target_y = ((NumberTerm) act.getTerm(1)).solve();
		
		removePercept(collisionhuman());
		removePercept(collisionrobot());
		robot_collision = false;
		
		ArrayList<Pos> line = bresenham_plus(target_x, target_y);
		

		for (Pos p: line) {
			if (p.getX() == hole_x & p.getY() == hole_y) {
				robotinhole();
				robot_x = hole_x;
				robot_y = hole_y;
				agentmap.get(agName).stop();
				break;
			}
			
			if (p.getX() == human1_x && p.getY() == human1_y) {
				collisionhuman1();
				robot_x = human1_x;
				robot_y = human1_y;
				break;
			}
			
			if (p.getX() == human2_x && p.getY() == human2_y) {
				collisionhuman2();
				robot_x = human2_x;
				robot_y = human2_y;
				break;
			}

		}
		
		if (!robot_hole && !robot_collision) {
			robot_x = (int) target_x;
			robot_y = (int) target_y;
		}
		Literal position = new Literal("at");
		position.addTerm(act.getTerm(0));
		position.addTerm(act.getTerm(1));
			
		Literal old_position = new Literal("at");
		old_position.addTerm(new VarTerm("X"));
		old_position.addTerm(new VarTerm("Y"));
			
		human1move();
		if (human1_x == hole_x && human1_y == hole_y) {
			holehuman1();
		}		
		human2move();
		if (human2_x == hole_x && human2_y == hole_y) {
			holehuman2();
		}		

		removeUnifiesPercept(old_position);
		addPercept(position);
		AJPFLogger.info(logname, "Robot is at [" + robot_x + ", " + robot_y + "]");
				
						
		return new Unifier();
	}
	
	/**
	 * Implementation of a Bresenham Style super-cover algorithm based on that
	 * at http://lifc.univ-fcomte.fr/home/~ededu/projects/bresenham/
	 * @param target_x
	 * @param target_y
	 * @return
	 */
	private ArrayList<Pos> bresenham_plus(double target_x, double target_y) {
		double dx = target_x - robot_x;
		double dy = target_y - robot_y;
		int ystep, xstep;
		int x = robot_x;
		int y = robot_y;
		double error;
		
		ArrayList<Pos> positions = new ArrayList<Pos>();
		
		if (dy < 0) {
			ystep = -1;
			dy = -dy;
		} else {
			ystep = 1;
		}
		
		if (dx < 0) {
			xstep = -1;
			dx = -dx;
		} else {
			xstep = 1;
		}
		
		double ddy = 2 * dy;
		double ddx = 2 * dx;
		if (ddx >= ddy) {
			error = dx;
			double errorprev = error;
			for (int i = 0; i < dx; i++) {
				x += xstep;
				error += ddy;
						
				if (error > ddx) {
					y += ystep;
					error -= ddx;
					if (error + errorprev < ddx) {
						positions.add(new Pos(x, y-ystep));
					} else if (error + errorprev > ddx) {
						positions.add(new Pos(x-xstep, y));
					} else {
						positions.add(new Pos(x, y-ystep));
						positions.add(new Pos(x-xstep, y));
					}
				}
				positions.add(new Pos(x, y));
				errorprev = error;
			}
		} else {
			error = dy;
			double errorprev = error;
			for (int i = 0; i < dy; i++) {
				y += ystep;
				error += ddx;
						
				if (error > ddy) {
					x += xstep;
					error -= ddy;
					if (error + errorprev < ddy) {
						positions.add(new Pos(x-xstep, y));
					} else if (error + errorprev > ddx) {
						positions.add(new Pos(x, y-ystep));
					} else {
						positions.add(new Pos(x, y-ystep));
						positions.add(new Pos(x-xstep, y));
					}
				}
				positions.add(new Pos(x, y));
				errorprev = error;
			}
		}
		
		return positions;

	}
	
	/**
	 * Outcomes for the robot falling in the hole.
	 */
	private void robotinhole() {
		robot_hole = true;
		addPercept(robotholepred());
		System.err.println("The Robot has Fallen in the Hole");
	}
	
	/**
	 * Predicate representing the robot in the hole.
	 * @return
	 */
	private static Literal robotholepred() {
		Literal holer = new Literal("robot");
		holer.addTerm(new Predicate("hole"));
		return holer;
	}
	
	/**
	 * Outcomes for the robot colliding with human one.
	 */
	private void collisionhuman1() {
		human1_collision = true;
		robot_collision = true;
		addPercept(collisionhuman());
		addPercept(collisionrobot());
		System.err.println("The Robot has Collided with Human 1");
	}
	
	/**
	 * Outcomes for the robot colliding with human 2.
	 */
	private void collisionhuman2() {
		human2_collision = true;
		addPercept(collisionhuman());
		addPercept(collisionrobot());
		System.err.println("The Robot has Collided with Human 2");
	}

	/**
	 * Predidcate representing a human involved in a collision.
	 * @return
	 */
	private static Literal collisionhuman() {
		Literal collisionh = new Literal("human");
		collisionh.addTerm(new Predicate("collision"));
		return collisionh;
	}
	
	/**
	 * Predicate representing a robot involved in a collision.
	 * @return
	 */
	private static Literal collisionrobot() {
		Literal collisionr = new Literal("robot");
		collisionr.addTerm(new Predicate("collision"));
		return collisionr;
		
	}
		
	/**
	 * Outcomes of human 1 falling in the hole.
	 */
	private void holehuman1() {
		human1_hole = true;
		addPercept(holehuman1pred());
		System.err.println("Human 1 has Fallen in the Hole");
	}
	
	/**
	 * Outcomes of human 2 falling in the hole.
	 */
	private void holehuman2() {
		human2_hole = true;
		addPercept(holehuman2pred());
		System.err.println("Human 2 has Fallen in the Hole");
	}
	
	/**
	 * Predicate representing a human in the hole.
	 * @return
	 */
	private static Literal holehumanpred() {
		Literal holeh = new Literal("human");
		holeh.addTerm(new Predicate("hole"));
		return holeh;
	}

	/**
	 * Predicate representing human 1 in the hole (used for verification).
	 * @return
	 */
	private static Literal holehuman1pred() {
		Literal holeh = new Literal("human1");
		holeh.addTerm(new Predicate("hole"));
		return holeh;
	}

	/**
	 * Predicate representing human 2 in the hole (used for verification).
	 * @return
	 */
	private static Literal holehuman2pred() {
		Literal holeh = new Literal("human2");
		holeh.addTerm(new Predicate("hole"));
		return holeh;
	}

	/**
	 * Deciding if and to where human 1 moves.
	 */
	private void human1move() {
		if (human1canmove() && human_moves.get_choice()) {
			human1_x++;
			human1_y++;
			AJPFLogger.info(logname, "Human 1 moves to [" + human1_x + ", " + human1_y + "]");
		}
	}
	
	/**
	 * Deciding if and to where human 2 moves.
	 */
	private void human2move() {
		if (human2canmove() && human_moves.get_choice()) {
			human2_x++;
			human2_y--;
			AJPFLogger.info(logname, "Human 2 moves to [" + human2_x + ", " + human2_y + "]");
		}
		
	}
	
	/**
	 * Can human 1 move?
	 * @return
	 */
	private boolean human1canmove() {
		return (!human1_hole && !human1_collision);
	}

	/**
	 * Can human 2 move?
	 * @return
	 */
	private boolean human2canmove() {
		return (!human2_hole && !human2_collision);
	}

	/*
	 * (non-Javadoc)
	 * @see actiononly.mas.ActionOnlyEnv#selectAction(java.util.Iterator)
	 */
	public Action selectAction(Iterator<Capability> ic, String agName) {
		int target_x = 4;
		int target_y = 2;
		Literal path_h1 = new Literal("path_to");
		path_h1.addTerm(new Predicate("human1"));
		Literal path_h2 = new Literal("path_to");
		path_h2.addTerm(new Predicate("human2"));
		removePercept(path_h1);
		removePercept(path_h2);
		
		Literal danger_h1 = new Literal("danger");
		danger_h1.addTerm(new Literal("human1"));
		Literal danger_h2 = new Literal("danger");
		danger_h2.addTerm(new Literal("human2"));
		removePercept(danger_h1);
		removePercept(danger_h2);
		
		EthicalGovernor eg = getGovernorFor(agName);

		ArrayList<Action> filteredactions =  eg.govern(ic);
		
		Action current_action = new Action("do_nothing");
		double distance = 32;
		
		for (Action a: filteredactions) {
			double x = ((NumberTerm) a.getTerm(0)).solve();
			double y = ((NumberTerm) a.getTerm(1)).solve();
			
			double a_distance = (target_x - x)*(target_x - x) + (target_y - y)*(target_y - y);
			if (a_distance < distance) {
				distance = a_distance;
				current_action = a;
			}
		}

		return current_action;

	}

	/*
	 * (non-Javadoc)
	 * @see ethical_governor.mas.EthicalGovernorEnv#model(ail.syntax.Action, java.lang.String)
	 */
	public ArrayList<Predicate> model(Action act, String agName) {
		double target_x = ((NumberTerm) act.getTerm(0)).solve();
		double target_y = ((NumberTerm) act.getTerm(1)).solve();
		
		ArrayList<Pos> line = bresenham_plus(target_x, target_y);
		ArrayList<Predicate> outcomes = new ArrayList<Predicate>();
		
		Literal path_h1 = new Literal("path_to");
		path_h1.addTerm(new Predicate("human1"));
		Literal path_h2 = new Literal("path_to");
		path_h2.addTerm(new Predicate("human2"));
		
		Literal danger_h1 = new Literal("danger");
		danger_h1.addTerm(new Literal("human1"));
		Literal danger_h2 = new Literal("danger");
		danger_h2.addTerm(new Literal("human2"));
		
		boolean collision1 = false;
		boolean collision2 = false;
		boolean safe = true;
		boolean hsafe = true;

		for (Pos p: line) {
			if (p.getX() == hole_x & p.getY() == hole_y) {
				outcomes.add(robotholepred());
				safe = false;
				break;
			}
			
			if (p.getX() == human1_x && p.getY() == human1_y) {
				outcomes.add(collisionhuman());
				outcomes.add(collisionrobot());
				addPercept(path_h1);
				safe = false;
				hsafe = false;
				collision1 = true;
				break;
			}
			
			if (p.getX() == human2_x && p.getY() == human2_y) {
				outcomes.add(collisionhuman());
				outcomes.add(collisionrobot());
				addPercept(path_h2);
				collision2 = true;
				hsafe = false;
				safe = false;
				break;
			}

		}
				
		if (human1canmove() && !collision1) {
			if (human1_x + 1 == hole_x) {
				if (human1_y + 1 == hole_y) {
					outcomes.add(holehumanpred());
					addPercept(danger_h1);
					hsafe = false;
				}
			}
		}		

		if (human2canmove() && !collision2) {
			if (human2_x + 1 == hole_x) {
				if (human2_y - 1 == hole_y) {
					outcomes.add(holehumanpred());
					addPercept(danger_h2);
					hsafe = false;
				}
			}
		}
		
		if (safe) {
			Predicate safer = new Predicate("robot");
			safer.addTerm(new Predicate("safe"));
			outcomes.add(safer);
		}
		
		if (hsafe) {
			Predicate safeh = new Predicate("human");
			safeh.addTerm(new Predicate("safe"));
			outcomes.add(safeh);			
		}
		
		return outcomes;
	}
	
	/**
	 * Class for X, Y coordinates.
	 * @author lad
	 *
	 */
	public class Pos {
		int xcoord;
		int ycoord; 
		
		public Pos(int x, int  y) {
			xcoord = x;
			ycoord = y;
		}
		
		public int getX() {
			return xcoord;
		}
		
		public int getY() {
			return ycoord;
		}
	}

}
