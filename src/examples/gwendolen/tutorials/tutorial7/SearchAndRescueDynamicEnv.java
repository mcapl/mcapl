// ----------------------------------------------------------------------------
// Copyright (C) 2014 Louise A. Dennis and Michael Fisher 
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.tutorials.tutorial7;

import ail.mas.DefaultEnvironment;
import ail.mas.RoundRobinScheduler;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.NumberTermImpl;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a dynamic environment (as a 5x5 grid) in which an agent may attempt search and rescue action.
 * 
 * The environment contains
 * 	- up to 4 uninjured humans who may move around and do not require assistance but can be directed to leave
 *  - up to 4 injured humans who do not move and do require assistance
 *  - 4 humans total
 *  - up to 4 rubble that can be lifted and may reveal injuired humans beneath
 *  - up to 4 buildings that may collapse and may contain uninjured humans.
 * @author lad
 *
 */
public class SearchAndRescueDynamicEnv extends DefaultEnvironment implements
		MCAPLJobber {
	static final String logname = "gwendolen.tutorials.tutorial7.SearchAndRescueDynamicEnv";
	
	public ArrayList<Building> buildings = new ArrayList<Building>();
	public ArrayList<Rubble> rubble = new ArrayList<Rubble>();
	public ArrayList<Human> humans = new ArrayList<Human>();
	public ArrayList<Square> free_squares = new ArrayList<Square>();
	
	Random r = new Random();
	
	double max_x = 4;
	double max_y = 4;
	double min_x = 0;
	double min_y = 0;
	
	double robot_x = 0;
	double robot_y = 0;
	
	int numhumans = 4;
	
	Rubble holding_rubble;
	
	double building_collapse_chance = 0.1;
	double human_move_chance = 0.02;
	
	/**
	 * Constructor.  Decides upon the number of humans, buildings and rubble.
	 */
	public SearchAndRescueDynamicEnv() {
		super();
		RoundRobinScheduler scheduler = new RoundRobinScheduler();
		this.setScheduler(scheduler);
		addPerceptListener(scheduler);
		generatesquares();
		int numbuildings = r.nextInt(4);
		placebuildings(numbuildings, true);
		int numrubble = r.nextInt(4);
		placebuildings(numrubble, false);
		placehumans(numhumans);
		
		Predicate at = new Predicate("at");
		at.addTerm(new NumberTermImpl(robot_x));
		at.addTerm(new NumberTermImpl(robot_y));
		addPercept(at);
		
		getScheduler().addJobber(this);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#do_job()
	 */
	public void do_job() {
		collapsebuildings();
		movehumans();
		System.err.println(this);
	}

	/*
	 * (non-Javadoc)
	 * @see ajpf.MCAPLJobber#getName()
	 */
	public String getName() {
		return logname;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		String actionname = act.getFunctor();
		if (actionname.equals("back_left")) {
			if (robot_x > min_x && robot_y > min_y) {
				move(robot_x - 1, robot_y - 1);
			}
		} else if (actionname.equals("back")) {
			if (robot_y > min_y) {
				move(robot_x, robot_y - 1);
			}
		} else if (actionname.equals("back_right")) {
			if (max_x > robot_x && robot_y > min_y) {
				move(robot_x + 1, robot_y - 1);
			}
		} else if (actionname.equals("left")) {
			if (robot_x > min_x) {
				move(robot_x - 1, robot_y);
			}
		} else if (actionname.equals("right")) {
			if (max_x > robot_x) {
				move(robot_x + 1, robot_y);
			}
		} else if (actionname.equals("forward_left")) {
			if (robot_x > min_x && max_y > robot_y) {
				move(robot_x - 1, robot_y + 1);
			}
		} else if (actionname.equals("forward")) {
			if (max_y > robot_y) {
				move(robot_x, robot_y + 1);
			}
		} else if (actionname.equals("forward_right")) {
			if (max_x > robot_x && max_y > robot_y) {
				move(robot_x + 1, robot_y + 1);
			}
		} else if (actionname.equals("lift_rubble")) {
			Rubble r = rubble_at_location();
			if (r != null && holding_rubble == null) {
				r.lift();
			}
		} else if (actionname.equals("drop_rubble")) {
			if (holding_rubble != null) {
				holding_rubble.drop();
			}
		} else if (actionname.equals("assist_human")) {
			for (Human h: getHumans(robot_x, robot_y)) {
				if (h.injured) {
					h.assist();
					break;
				}
			}
		} else if (actionname.equals("direct_humans")) {
			for (Human h: getHumans(robot_x, robot_y)) {
				if (h != null) {
					h.direct();
				}
			}
		}
		return super.executeAction(agName, act);
	}
	
	/**
	 * Buildings in the area.
	 * @author lad
	 *
	 */
	public class Building extends Square {
		public Building(double x, double y) {
			super(x, y);
		}
	}
	
	/**
	 * Rubble in the area
	 * @author lad
	 *
	 */
	public class Rubble extends Square{
		public Rubble(double x, double y) {
			super(x, y);
		}		
		
		public void lift() {
			Predicate r = new Predicate("rubble");
			r.addTerm(new NumberTermImpl(x));
			r.addTerm(new NumberTermImpl(y));
			removePercept(r);
			
			Predicate holding = new Predicate("holding_rubble");
			addPercept(holding);
			rubble.remove(this);
			holding_rubble = this;
			
			for (Human h: getHumans(x, y)) {
				addHumanPercept(h);
			}
		}
		
		public void drop() {
			holding_rubble = null;
			x = robot_x;
			y = robot_y;

			Predicate r = new Predicate("rubble");
			r.addTerm(new NumberTermImpl(x));
			r.addTerm(new NumberTermImpl(y));
			addPercept(r);
			
			Predicate holding = new Predicate("holding_rubble");
			removePercept(holding);
			rubble.add(this);
			
			for (Human h: getHumans(x, y)) {
				h.injure();
				removeHumanPercept(h);
			}
		}
	}
	
	/**
	 * Humans in the area;
	 * @author lad
	 *
	 */
	public class Human extends Square{
		boolean injured;
		boolean directed = false;
		
		public Human(double x, double y, boolean inj) {
			super(x, y);
			injured = inj;
		}
		
		public void assist() {
			injured = false;
		}
		
		public void direct() {
			directed = true;
		}
		
		public void injure() {
			injured = true;
		}
		
		public boolean injured() {
			return injured;
		}
		
		public boolean inBuilding() {
			for (Building b: buildings) {
				if (b.getX() == x && b.getY() == y) {
					return true;
				}
			}
			
			return false;
		}
		
		public boolean directed() {
			return directed;
		}
		
		public void move(double dx, double dy) {
			if (dx > (min_x - 2) || dx < (max_x + 2)) {
				if (dy > (min_y - 2) || dy < (max_y + 2)) {
					if (! isVisible()) {
						removeHumanPercept(this);
					}
			
					x = dx;
					y = dy;
			
					if (isVisible()) {
						addHumanPercept(this);
					}
				}
			}
		}
		
		public boolean onGrid() {
			if (x > (min_x - 1) || x < (max_x + 1)) {
				if (y > (min_y - 1) || y < (max_y + 1)) {
					return true;
				}
			}
			
			humans.remove(this);
			return false;
		}
		
		/**
		 * Is this human visible
		 * @param h
		 * @return
		 */
		public boolean isVisible() {
			if ((SearchAndRescueDynamicEnv.this.rubble_at(getX(), getY()) && injured()) || SearchAndRescueDynamicEnv.this.building_at(getX(), getY())) {
				return false;
			}
			
			return true;
		}

		
		
	}
	
	/**
	 * A square
	 * @author lad
	 *
	 */
	public class Square {
		double x;
		double y;
		
		public Square(double xx, double yy) {
			x = xx;
			y = yy;
		}
		
		public double getX() {
			return x;
		}
		
		public double getY() {
			return y;
		}
	}
	
	/**
	 * Generates 25 empty squares;
	 */
	public void generatesquares() {
		double x = 0;
		double y = 0;
		for (int i = 0; i < 25; i++) {
			free_squares.add(new Square(x, y));
			if (x <= max_x) {
				x++;
			} else {
				x = min_x;
				if (y <= max_y) {
					y++;
				} else {
					AJPFLogger.warning(logname, "Generated too many squares!!!");
				}
			}
			
		}
	}
	
	/** 
	 * Decides at random where buildings should be placed on the map;
	 */
	public void placebuildings(int numbuildings, boolean standing) {
		int free_squares_num = free_squares.size();
		for (int i = 1; i <= numbuildings; i++) {
			int square = r.nextInt(free_squares_num);
			free_squares_num--;
			Square s = free_squares.remove(square);
			if (standing) {
				buildings.add(new Building(s.getX(), s.getY()));
				if (isVisible(s)) {
					addBuildingPercept(s);
				}
			} else {
				rubble.add(new Rubble(s.getX(), s.getY()));
				if (isVisible(s)) {
					addRubblePercept(s);
				}
			}
		}
	}
	
	/**
	 * Decides at random where humans should be placed on the map;
	 * @param numhumans
	 */
	public void placehumans(int numhumans) {
		for (int i = 1; i <= numhumans; i++) {
			int square = r.nextInt(25);
			double x = square % 5;
			int y = square / 5;
			Human h;
			if (isRubble(x, y)) {
				h = new Human(x, y, true);
			} else {
				h = new Human(x, y, r.nextBoolean());
			}
			
			if (h.isVisible()) {
				addHumanPercept(h);
			}
			humans.add(h);
		}
	}
	
	/**
	 * Checks if any buildings have collapsed and moves them to rubble if they have.
	 */
	public void collapsebuildings() {
		ArrayList<Integer> collapses = new ArrayList<Integer>();
		int i = 0;
		for (Building b: buildings) {
			if (r.nextDouble() < building_collapse_chance) {
				Rubble r = new Rubble(b.getX(), b.getY());
				rubble.add(r);
				collapses.add(i);
				ArrayList<Human> hs = getHumans(b.getX(), b.getY());
				for (Human h: hs) {
					h.injure();
				}
				if (isVisible(b)) {
					removeBuildingPercept(b);
					addRubblePercept(r);
				}
			}
			i++;
		}
		
		for (Integer it: collapses) {
			buildings.remove(it);
		}
	}
	
	/**
	 * Move the humans;
	 */
	public void movehumans() {
		for (Human h: humans) {
			if (! h.injured() && ! h.inBuilding() && ! h.directed() && h.onGrid()) {
				double prob = r.nextDouble();
				if (prob < human_move_chance * 8) {
					int option = 1;
					while (prob >= human_move_chance) {
						prob = prob - human_move_chance;
						option++;
					}
					double x = h.getX();
					double y = h.getY();
					if (option == 1) {
						h.move(x - 1, y - 1);
					} else if (option == 2) {
						h.move(x, y - 1);
					} else if (option == 3) {
						h.move(x + 1, y - 1);
					} else if (option == 4) {
						h.move(x - 1, y);
					} else if (option == 5) {
						h.move(x + 1, y);
					} else if (option == 6) {
						h.move(x + 1, y - 1);
					} else if (option == 7) {
						h.move(x + 1, y);
					} else {
						h.move(x + 1, y + 1);
					}
				}
			}
			
			if (h.directed()) {
				h.move(h.getX() - 1, h.getY() - 1);
			}
		}
		
	}
	
	/**
	 * The robot moves 1 square.
	 * @param x
	 * @param y
	 */
	public void move(double x, double y) {
		ArrayList<Square> visible = visible_squares();
		Predicate current = new Predicate("at");
		current.addTerm(new NumberTermImpl(robot_x));
		current.addTerm(new NumberTermImpl(robot_y));
		Predicate new_pos = new Predicate("at");
		new_pos.addTerm(new NumberTermImpl(x));
		new_pos.addTerm(new NumberTermImpl(y));
		
		robot_x = x;
		robot_y = y;
		removePercept(current);
		addPercept(new_pos);
		
		ArrayList<Square> visible_now = visible_squares();
		
		for (Square s: visible) {
			if (! visible_now.contains(s)) {
				removePerceptsFor(s);
			}
		}
		for (Square s: visible_now) {
			if (! visible.contains(s)) {
				addPerceptsFor(s);
			}
		}
	}
	
	/**
	 * Is there rubble at this location?
	 * @return
	 */
	public Rubble rubble_at_location() {
		for (Rubble r: rubble) {
			if (r.getX() == robot_x && r.getY() == robot_y) {
				return r;
			}
		}
		
		return null;
	}
	
	/**
	 * Is there rubble at (X, Y)?
	 * @return
	 */
	public boolean rubble_at(double x, double y) {
		for (Rubble r: rubble) {
			if (r.getX() == x && r.getY() == y) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Is there a building at (X, Y)?
	 * @return
	 */
	public boolean building_at(double x, double y) {
		for (Building b: buildings) {
			if (b.getX() == x && b.getY() == y) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Is there a human at this location?
	 * @return
	 */
/*	public Human human_at_location() {
		for (Human h: humans) {
			if (h.getX() == robot_x && h.getY() == robot_y) {
				return h;
			}
		}
		
		return null;
	} */
	
	/**
	 * Is there a human at (x, y)?
	 * @return
	 */
	public ArrayList<Human> getHumans(double x, double y) {
		ArrayList<Human> hs = new ArrayList<Human>();
		for (Human h: humans) {
			if (h.getX() == x && h.getY() == y) {
				hs.add(h);
			}
		}
		
		return hs;
	}

	/**
	 * Is this square visible to the robot?
	 */
	public boolean isVisible(Square s) {
		if (Math.abs(s.getX() - robot_x) <= 1 ) {
			if (Math.abs(s.getY() - robot_y) <= 1) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Add that a building can be seen in this square.
	 */
	public void addBuildingPercept(Square s) {
		Predicate building = new Predicate("building");
		building.addTerm(new NumberTermImpl(s.getX()));
		building.addTerm(new NumberTermImpl(s.getY()));
		addPercept(building);
	}
	
	/**
	 * Add that a building can be seen in this square.
	 */
	public void removeBuildingPercept(Square s) {
		Predicate building = new Predicate("building");
		building.addTerm(new NumberTermImpl(s.getX()));
		building.addTerm(new NumberTermImpl(s.getY()));
		removePercept(building);
	}

	/**
	 * Add that a rubble can be seen in this square.
	 */
	public void addRubblePercept(Square s) {
		Predicate building = new Predicate("rubble");
		building.addTerm(new NumberTermImpl(s.getX()));
		building.addTerm(new NumberTermImpl(s.getY()));
		addPercept(building);
	}
	
	/**
	 * Add that a building can be seen in this square.
	 */
	public void removeRubblePercept(Square s) {
		Predicate building = new Predicate("rubble");
		building.addTerm(new NumberTermImpl(s.getX()));
		building.addTerm(new NumberTermImpl(s.getY()));
		removePercept(building);
	}

	/**
	 * Add that a human can be seen in this square.
	 * @param h
	 */
	public void addHumanPercept(Human h) {
		if (h.injured()) {
			Predicate human = new Predicate("injured_human");
			human.addTerm(new NumberTermImpl(h.getX()));
			human.addTerm(new NumberTermImpl(h.getY()));
			addPercept(human);
		} else {
			Predicate human = new Predicate("uninjured_human");
			human.addTerm(new NumberTermImpl(h.getX()));
			human.addTerm(new NumberTermImpl(h.getY()));
			addPercept(human);			
		}
	}
	
	/**
	 * Remove that a human can be seen in this square.
	 * @param h
	 */
	public void removeHumanPercept(Human h) {
		if (h.injured()) {
			Predicate human = new Predicate("injured_human");
			human.addTerm(new NumberTermImpl(h.getX()));
			human.addTerm(new NumberTermImpl(h.getY()));
			removePercept(human);
		} else {
			Predicate human = new Predicate("uninjured_human");
			human.addTerm(new NumberTermImpl(h.getX()));
			human.addTerm(new NumberTermImpl(h.getY()));
			removePercept(human);			
		}
		
	}
	
	/**
	 * Is there rubble at this location?
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isRubble(double x, double y) {
		for (Rubble r: rubble) {
			if (r.getX() == x && r.getY() == y) {
				return true;
			}
		}
		
		return false;
	}
		
	
	/**
	 * Get an array of Squares visible to the robot.
	 * @return
	 */
	public ArrayList<Square> visible_squares() {
		ArrayList<Square> squares = new ArrayList<Square>();
		for (double x = robot_x - 1; x <= robot_x + 1; x++) {
			for (double y = robot_y - 1; y <= robot_y + 1; y++) {
				if (x >= min_x && y >= min_y && x <= max_x && y <= max_y) {
					squares.add(new Square(x, y));
				}
			}
		}
		return squares;
	}
	
	/**
	 * Remove any percepts associated with this square.
	 * @param s
	 */
	public void removePerceptsFor(Square s) {
		double x = s.getX();
		double y = s.getY();
		if  (rubble_at(x, y)) {
			removeRubblePercept(s);
		} else if  (building_at(x, y)) {
			removeBuildingPercept(s);
		}
		
		for (Human h: getHumans(x, y)) {
			if (h.isVisible()) {
				removeHumanPercept(h);
			}
		}

	}
	
	/**
	 * Add any percepts associated with this square.
	 * @param s
	 */
	public void addPerceptsFor(Square s) {
		double x = s.getX();
		double y = s.getY();
		if  (rubble_at(x, y)) {
			addRubblePercept(s);
		} else if  (building_at(x, y)) {
			addBuildingPercept(s);
		}
		
		for (Human h: getHumans(x, y)) {
			if (h.isVisible()) {
				addHumanPercept(h);
			}
		}

	}
	
	/**
	 * Print out this environment;
	 */
	public String toString() {
		String s = "---------------------\n";
		for (double y = 4; y >= 0; y--) {
			s += "|";
			for (double x = 0; x < 5; x++) {
				if (rubble_at(x, y)) {
					s += "R";
				} else if (building_at(x, y)) {
					s += "B";
				} else {
					s += " ";
				}
				
				ArrayList<Human> hs = getHumans(x, y);
				if (hs.size() > 0) {
					s += "h";
					s += hs.size();
				} else {
					s += "  ";
				}
				s+="|";
			}	
			s += "\n|";
			for (double x = 0; x < 5; x++) {
				if (x == robot_x && y == robot_y) {
					s += "r";
				} else {
					s += " ";
				}
				
				s += "  |";
			}
			s +="\n";
			s += "---------------------\n";
		}
		return s;
		
	}


}
