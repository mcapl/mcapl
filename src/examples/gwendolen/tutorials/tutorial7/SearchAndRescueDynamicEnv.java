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
import ail.mas.MAS;
import ail.mas.scheduling.RoundRobinScheduler;
import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.syntax.NumberTermImpl;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.MCAPLcontroller;
import ajpf.util.choice.Choice;
import ajpf.util.choice.ProbBoolChoice;
import ajpf.util.choice.UniformBoolChoice;
import ajpf.util.choice.UniformIntChoice;

import java.util.ArrayList;

/**
 * This class represents a dynamic environment (as a 5x5 grid) in which an agent may attempt search and rescue action.
 * 
 * The environment contains
 * 	- up to 4 uninjured humans who may move around and do not require assistance but can be directed to leave
 *  - up to 4 injured humans who do not move and do require assistance
 *  - 4 humans total
 *  - up to 4 rubble that can be lifted and may reveal injuired humans beneath
 *  - up to 4 buildings that may collapse into rubble and may contain uninjured humans.
 *  - There may be multiple humans or rubble in one square, but there can't be multiple buildings.
 *  
 *  - The robot can not see humans in buildings or under rubble, it has to life the rubble or check the building to see them.
 * @author lad
 *
 */
public class SearchAndRescueDynamicEnv extends DefaultEnvironment implements
		MCAPLJobber {
	static final String logname = "gwendolen.tutorials.tutorial7.SearchAndRescueDynamicEnv";
	
	public ArrayList<Building> buildings = new ArrayList<Building>();
	public ArrayList<Rubble> rubble = new ArrayList<Rubble>();
	public ArrayList<Human> humans = new ArrayList<Human>();
	public ArrayList<Human> cleanup = new ArrayList<Human>();
	public ArrayList<Square> free_squares = new ArrayList<Square>();
	
	UniformIntChoice r;
	ProbBoolChoice building_collapse;
	ProbBoolChoice human_move;
	
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
		for (Human h: cleanup) {
			humans.remove(h);
		}
		collapsebuildings();
		movehumans();
		((RoundRobinScheduler) scheduler).perceptChanged();
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
		} else if (actionname.equals("check_building")) {
			for (Human h: getHumans(robot_x, robot_y)) {
				if (h != null) {
					addHumanPercept(h);
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
			
			if (! rubble_at(x, y)) {
				for (Human h: getHumans(x, y)) {
					h.free();
					addHumanPercept(h);
				}
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
				h.injured_by_falling_rubble();
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
		boolean in_building = false;
		boolean under_rubble = false;
		
		public Human(double x, double y) {
			super(x, y);
			if (SearchAndRescueDynamicEnv.this.building_at(x, y)) {
				in_building = true;
			}
		}
		
		public void assist() {
			injured = false;
			removeHumanPercept(this);
			addHumanPercept(this);
			((RoundRobinScheduler) scheduler).perceptChanged();
		}
		
		public void direct() {
			directed = true;
			in_building = false;
			((RoundRobinScheduler) scheduler).perceptChanged();
		}
		
		public void injured_by_falling_rubble() {
			injured = true;
			under_rubble = true;
		}
		
		public void free() {
			under_rubble = false;
		}
		
		public boolean injured() {
			return injured;
		}
		
		public boolean inBuilding() {
			return in_building;
		}
		
		public boolean directed() {
			return directed;
		}
		
		public void move(double dx, double dy) {
			removeHumanPercept(this);
			if ((dx >= min_x && dx <= max_x) || directed) {
				if ((dy >= min_y  && dy <= max_y) || directed) {
			
					x = dx;
					y = dy;
					
					if (building_at(x,y) && !directed) {
						enter_building();
					}
					
					System.err.println("MOVING " + x + " " + y);
			
					if (isVisible()) {
						addHumanPercept(this);
					}
					
					onGrid();
				}
			}
		}
		
		public void enter_building() {
			in_building = true;
		}
		
		public boolean onGrid() {
			if (x > (min_x - 1) && x < (max_x + 1)) {
				if (y > (min_y - 1) && y < (max_y + 1)) {
					return true;
				}
			}
			
			cleanup.add(this);
			return false;
		}
		
		
		/**
		 * Is this human visible
		 * @param h
		 * @return
		 */
		public boolean isVisible() {
			if ((! SearchAndRescueDynamicEnv.this.isVisible(new Square(getX(), getY()))) || (SearchAndRescueDynamicEnv.this.rubble_at(getX(), getY()) && injured()) || in_building) {
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
		
		public String toString() {
			String s = "(";
			s += x;
			s += ", ";
			s += y;
			s += ")";
			return s;
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
			if (x < max_x) {
				x++;
			} else {
				x = min_x;
				if (y < max_y) {
					y++;
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
			Human h = new Human(x, y);
			if (isRubble(x, y)) {
				h.injured_by_falling_rubble();
			} else if (building_at(x, y)){
				h.enter_building();
			}
			
			if (h.isVisible() ) {
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
			if (building_collapse.nextBoolean()) {
				Rubble r = new Rubble(b.getX(), b.getY());
				rubble.add(r);
				collapses.add(i);
				ArrayList<Human> hs = getHumans(b.getX(), b.getY());
				for (Human h: hs) {
					h.injured_by_falling_rubble();
				}
				if (isVisible(b)) {
					removeBuildingPercept(b);
					addRubblePercept(r);
				}
			}
			i++;
		}
		
		int modifier = 0;
		for (Integer it: collapses) {
			buildings.remove(it.intValue() - modifier);
			modifier++;
		}
	}
	
	/**
	 * Move the humans;
	 */
	public void movehumans() {
		for (Human h: humans) {
			if (! h.injured() && ! h.inBuilding() && ! h.directed() && h.onGrid()) {
				if (human_move.nextBoolean()) {
					int option = r.nextInt(8);
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
			} else {
				ArrayList<Human> humans = getHumans(s.getX(), s.getY());
				for (Human h: humans) {
					if (h.inBuilding()) {
						removeHumanPercept(h);
					}
				}
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
	 * Is there a human at (x, y)?
	 * @return
	 */
	public ArrayList<Rubble> getRubble(double x, double y) {
		ArrayList<Rubble> rs = new ArrayList<Rubble>();
		for (Rubble r: rubble) {
			if (r.getX() == x && r.getY() == y) {
				rs.add(r);
			}
		}
		
		return rs;
	}

	/**
	 * Is this square visible to the robot?
	 */
	public boolean isVisible(Square s) {
		if (Math.abs(s.getX() - robot_x) < 1 ) {
			if (Math.abs(s.getY() - robot_y) < 1) {
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
			Predicate human = new Predicate("injured_human");
			human.addTerm(new NumberTermImpl(h.getX()));
			human.addTerm(new NumberTermImpl(h.getY()));
			removePercept(human);

			Predicate uhuman = new Predicate("uninjured_human");
			uhuman.addTerm(new NumberTermImpl(h.getX()));
			uhuman.addTerm(new NumberTermImpl(h.getY()));
			removePercept(uhuman);			
		
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
	
	public boolean done() {
		return humans.isEmpty();
	}
	
	/**
	 * Print out this environment;
	 */
	public String toString() {
		String s = "---------------------\n";
		for (double y = 4; y >= 0; y--) {
			s += "|";
			for (double x = 0; x < 5; x++) {
				if (building_at(x, y)) {
					s += "B";
				} else {
					s += " ";
				}
				
				ArrayList<Rubble> rs = getRubble(x, y);
				if (rs.size() > 0) {
					s += "R";
					s += rs.size();
				} else {
					s+= "  ";
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
				
				ArrayList<Human> hs = getHumans(x, y);
				if (hs.size() > 0) {
					s += "h";
					s += hs.size();
				} else {
					s += "  ";
				}

				
				s += "|";
			}
			s +="\n";
			s += "---------------------\n";
		}
		return s;
		
	}
	
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		r = new UniformIntChoice(m.getController());
		building_collapse = new ProbBoolChoice(m.getController(), building_collapse_chance);
		human_move = new ProbBoolChoice(m.getController(), human_move_chance * 8);
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

	}


}
