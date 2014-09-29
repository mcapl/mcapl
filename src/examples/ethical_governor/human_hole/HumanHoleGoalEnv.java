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
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ethical_governor.human_hole;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import ail.syntax.Action;
import ail.syntax.Capability;
import ail.syntax.NumberTerm;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import ethical_governor.mas.DefaultEthicalGovernorEnv;
import ethical_governor.semantics.EthicalGovernor;
import actiononly.mas.ActionOnlyEnv;

public class HumanHoleGoalEnv extends DefaultEthicalGovernorEnv implements ActionOnlyEnv {
	Random r = new Random();
	
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
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		double target_x = ((NumberTerm) act.getTerm(0)).solve();
		double target_y = ((NumberTerm) act.getTerm(1)).solve();
		
		ArrayList<Pos> line = bresenham_plus(target_x, target_y);
		
		for (Pos p: line) {
			if (p.getX() == hole_x & p.getY() == hole_y) {
				robotinhole();
				break;
			}
			
			if (p.getX() == human1_x && p.getY() == human1_y) {
				collsionhuman1();
				break;
			}
			
			if (p.getX() == human2_x && p.getY() == human2_y) {
				collsionhuman2();
				break;
			}

		}
				
		human1move();
		human2move();
				
		return new Unifier();
	}
	
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
			if (dx < 0) {
				xstep = -1;
				dx = -dx;
			} else {
				xstep = 1;
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
			}
		}
		
		return positions;

	}
	
	private void human1move() {
		if (!human1_hole && !human1_collision && r.nextBoolean()) {
			human1_x++;
			human1_y++;
		}
	}
	
	private void human2move() {
		if (!human2_hole && !human1_collision && r.nextBoolean()) {
			human2_x++;
			human2_y++;
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see actiononly.mas.ActionOnlyEnv#selectAction(java.util.Iterator)
	 */
	public Action selectAction(Iterator<Capability> ic, String agName) {
		int target_x = 2;
		int target_y = 4;
		
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

	}
	
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
