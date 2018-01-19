// ----------------------------------------------------------------------------
// Copyright (C) 2017 Louise A. Dennis, Michael Fisher, and Koen Hindriks
// 
// This file is part of AIL GOAL.  An AIL Implementation of the GOAL Programming
// Language
//
// AIL GOAL is free software: you can redistribute it and/or modify it under
// the terms of the GNU General Public License as published by the Free Software
// Foundation, either version 3 of the License, or (at your option) any later
// version.
//
// AIL GOAL is distributed in the hope that it will be useful, but WITHOUT
// ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
// details.
//
// You should have received a copy of the GNU General Public License along with
// this program. If not, see <http://www.gnu.org/licenses/>.
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package goal.simple_blocks_world;

import java.util.HashMap;
import java.util.List;

import ail.syntax.Action;
import ail.syntax.ListTermImpl;
import ail.syntax.Predicate;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.util.AILexception;
import goal.mas.GoalEnvironment;

public class SimpleBlocksWorldEnvironment extends GoalEnvironment {
	
	boolean instartb = true;
	boolean indropzoneb = false;
	boolean inroom1b = false;
	boolean inroom2b = false;
	boolean inroom3b = false;
	boolean inroom4b = false;
	boolean atbrick1b = false;
	boolean atbrick2b = false;
	boolean atbrick3b = false;
	boolean atbrick4b = false;
	boolean holdingbrick1 = false;
	boolean holdingbrick2 = false;
	boolean holdingbrick3 = false;
	boolean holdingbrick4 = false;
	
		
	public static class Brick {
		String colour;
		String brick_name;
		boolean visible = false;
		String room;
		
		public Brick() {};
		
		public void setAttributes(String n, String c) {
			brick_name = n;
			colour=c;
		}
		
		public void setVisible(boolean b) {
			visible = b;
		}
		
		public boolean isVisible() {
			return visible;
		}
		
	}
	
	public static Brick brick1 = new Brick();
	public static Brick brick2 = new Brick();
	public static Brick brick3 = new Brick();
	public static Brick brick4 = new Brick();
	
	static {
		brick1.setAttributes("brick1", "green");
		brick2.setAttributes("brick2", "green");
		brick3.setAttributes("brick3", "red");
		brick4.setAttributes("brick4", "blue");
	}
	
	HashMap<String, Brick> brick_locations = new HashMap<String,Brick>();
	
	public SimpleBlocksWorldEnvironment() {
		super();
		brick_locations.put("Room1", brick1);
		brick1.room = "Room1";
		brick_locations.put("Room2", brick2);
		brick2.room = "Room2";
		brick_locations.put("Room3", brick3);
		brick3.room = "Room3";
		brick_locations.put("Room4", brick4);
		brick4.room = "Room4";
		setPercepts();
		
		Predicate shopping_list = new Predicate("shopping_list");
		ListTermImpl list = new ListTermImpl();
		list.setTail(new ListTermImpl());
		list.setHead(new Predicate("red"));
		list.cons(new Predicate("green"));
		list.cons(new Predicate("green"));
		list.cons(new Predicate("blue"));
		shopping_list.addTerm(list);
		addPercept(shopping_list);
	}
	
	private void void_locations() {
		atbrick1b = false;
		atbrick2b = false;
		atbrick3b = false;
		atbrick4b = false;
		inroom1b = false;
		inroom2b = false;
		inroom3b = false;
		inroom4b = false;
		instartb = false;
		indropzoneb = false;
		brick1.setVisible(false);
		brick2.setVisible(false);
		brick3.setVisible(false);
		brick4.setVisible(false);
	}
	
	private void setRoom(String room) {
		if (room.equals("Room1")) {
			inroom1b = true;
		} else if (room.equals("Room2")) {
			inroom2b = true;
		} else if (room.equals("Room3")) {
			inroom3b = true;
		} else if (room.equals("Room4")) {
			inroom4b = true;
		} else if (room.equals("DropZone")) {
			indropzoneb = true;
		}
		
	}
	
	private Brick getBrick(String name) {
		if (name.equals("brick1")) {
			return brick1;
		}
		
		if (name.equals("brick2")) {
			return brick2;
		}
		if (name.equals("brick3")) {
			return brick3;
		}
		
		return brick4;
		
	}

	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
				
		String functor = act.getFunctor();
		if (functor.equals("goTo")) {
			void_locations();
			String room = ((StringTerm) act.getTerm(0)).getString();
			
			setRoom(room);

			if (brick_locations.containsKey(room)) {
				Brick b = brick_locations.get(room);
				b.setVisible(true);
			}
			System.err.println("moving to " + act.getTerm(0));
		} else if (functor.equals("goToBrick")) {
			void_locations();
			String brick_name = act.getTerm(0).getFunctor();
			Brick b = getBrick(brick_name);
			b.setVisible(true);
			
			setRoom(b.room);
			
			if (brick_name.equals("brick1")) {
				atbrick1b = true;
			} else if (brick_name.equals("brick2")) {
				atbrick2b = true;
			} else if (brick_name.equals("brick3")) {
				atbrick3b = true;
			} else if (brick_name.equals("brick4")) {
				atbrick4b = true;
			}

			System.err.println("moving to " + act.getTerm(0));
		} else if (functor.equals("pickUp")) {
			if (atbrick1b) {
				brick1.setVisible(false);
				atbrick1b = false;
				holdingbrick1 = true;
				brick_locations.remove(brick1.room);
				brick1.room = null;
			} else if (atbrick2b) {
				brick2.setVisible(false);
				atbrick2b = false;
				holdingbrick2 = true;
				brick_locations.remove(brick2.room);
				brick2.room = null;
			} else if (atbrick3b) {
				brick3.setVisible(false);
				atbrick3b = false;
				holdingbrick3 = true;
				brick_locations.remove(brick3.room);
				brick3.room = null;
			} else if (atbrick4b) {
				brick4.setVisible(false);
				atbrick4b = false;
				holdingbrick4 = true;
				brick_locations.remove(brick4.room);
				brick4.room = null;
			}			
		} else if (functor.equals("putDown")) {
			if (holdingbrick1) {
				holdingbrick1 = false;
			} else if (holdingbrick2 ){
				holdingbrick2 = false;
			} else if (holdingbrick3) {
				holdingbrick3 = false;
			} else if (holdingbrick4) {
				holdingbrick4 = false;
			}
		}
		
		setPercepts();
		return u;
	}
	
	private void setPercepts() {
		Predicate instart = new Predicate("in");
		instart.addTerm(new Predicate("start"));
		Predicate notinstart = new Predicate("not");
		notinstart.addTerm(instart);

		Predicate inroom1 = new Predicate("in");
		inroom1.addTerm(new StringTermImpl("Room1"));
		Predicate notinroom1 = new Predicate("not");
		notinroom1.addTerm(inroom1);
		
		Predicate inroom2 = new Predicate("in");
		inroom2.addTerm(new StringTermImpl("Room2"));
		Predicate notinroom2 = new Predicate("not");
		notinroom2.addTerm(inroom2);

		Predicate inroom3 = new Predicate("in");
		inroom3.addTerm(new StringTermImpl("Room3"));
		Predicate notinroom3 = new Predicate("not");
		notinroom3.addTerm(inroom3);

		Predicate inroom4 = new Predicate("in");
		inroom4.addTerm(new StringTermImpl("Room4"));
		Predicate notinroom4 = new Predicate("not");
		notinroom4.addTerm(inroom4);

		Predicate indropzone = new Predicate("in");
		indropzone.addTerm(new StringTermImpl("DropZone"));
		Predicate notindropzone = new Predicate("not");
		notindropzone.addTerm(indropzone);
		
		Predicate atbrick1 = new Predicate("atBrick");
		atbrick1.addTerm(new Predicate("brick1"));
		Predicate notatbrick1 = new Predicate("not");
		notatbrick1.addTerm(atbrick1);
		
		Predicate atbrick2 = new Predicate("atBrick");
		atbrick2.addTerm(new Predicate("brick2"));
		Predicate notatbrick2 = new Predicate("not");
		notatbrick2.addTerm(atbrick2);
		
		Predicate atbrick3 = new Predicate("atBrick");
		atbrick3.addTerm(new Predicate("brick3"));
		Predicate notatbrick3 = new Predicate("not");
		notatbrick3.addTerm(atbrick3);
		
		Predicate atbrick4 = new Predicate("atBrick");
		atbrick4.addTerm(new Predicate("brick4"));
		Predicate notatbrick4 = new Predicate("not");
		notatbrick4.addTerm(atbrick4);
		
		Predicate holding1 = new Predicate("holding");
		holding1.addTerm(new Predicate("brick1"));
		Predicate notholding1 = new Predicate("not");
		notholding1.addTerm(holding1);
		
		Predicate holding2 = new Predicate("holding");
		holding2.addTerm(new Predicate("brick2"));
		Predicate notholding2 = new Predicate("not");
		notholding2.addTerm(holding2);
		
		Predicate holding3 = new Predicate("holding");
		holding3.addTerm(new Predicate("brick3"));
		Predicate notholding3 = new Predicate("not");
		notholding3.addTerm(holding3);
		
		Predicate holding4 = new Predicate("holding");
		holding4.addTerm(new Predicate("brick4"));
		Predicate notholding4 = new Predicate("not");
		notholding4.addTerm(holding4);
		
		Predicate visible1 = new Predicate("visible");
		visible1.addTerm(new Predicate(brick1.brick_name));
		visible1.addTerm(new Predicate(brick1.colour));
		Predicate notvisible1 = new Predicate("not");
		notvisible1.addTerm(visible1);
		
		Predicate visible2 = new Predicate("visible");
		visible2.addTerm(new Predicate(brick2.brick_name));
		visible2.addTerm(new Predicate(brick2.colour));
		Predicate notvisible2 = new Predicate("not");
		notvisible2.addTerm(visible2);
		
		Predicate visible3 = new Predicate("visible");
		visible3.addTerm(new Predicate(brick3.brick_name));
		visible3.addTerm(new Predicate(brick3.colour));
		Predicate notvisible3 = new Predicate("not");
		notvisible3.addTerm(visible3);
		
		Predicate visible4 = new Predicate("visible");
		visible4.addTerm(new Predicate(brick4.brick_name));
		visible4.addTerm(new Predicate(brick4.colour));
		Predicate notvisible4 = new Predicate("not");
		notvisible4.addTerm(visible4);
		
		if (instartb) {
			addPercept(instart);
			removePercept(notinstart);
		} else {
			addPercept(notinstart);
			removePercept(instart);
		}
		
		if (indropzoneb) {
			addPercept(indropzone);
			removePercept(notindropzone);
		} else {
			addPercept(notindropzone);
			removePercept(indropzone);
		}
		
		if (inroom1b) {
			addPercept(inroom1);
			removePercept(notinroom1);
		} else {
			addPercept(notinroom1);
			removePercept(inroom1);
		}
		
		if (inroom2b) {
			addPercept(inroom2);
			removePercept(notinroom2);
		} else {
			addPercept(notinroom2);
			removePercept(inroom2);
		}
		
		if (inroom3b) {
			addPercept(inroom3);
			removePercept(notinroom3);
		} else {
			addPercept(notinroom3);
			removePercept(inroom3);
		}
		
		if (inroom4b) {
			addPercept(inroom4);
			removePercept(notinroom4);
		} else {
			addPercept(notinroom4);
			removePercept(inroom4);
		}
		
		if (atbrick1b) {
			addPercept(atbrick1);
			removePercept(notatbrick1);
		} else {
			addPercept(notatbrick1);
			removePercept(atbrick1);
		}
		
		if (atbrick2b) {
			addPercept(atbrick2);
			removePercept(notatbrick2);
		} else {
			addPercept(notatbrick2);
			removePercept(atbrick2);
		}
		
		if (atbrick3b) {
			addPercept(atbrick3);
			removePercept(notatbrick3);
		} else {
			addPercept(notatbrick3);
			removePercept(atbrick3);
		}
		
		if (atbrick4b) {
			addPercept(atbrick4);
			removePercept(notatbrick4);
		} else {
			addPercept(notatbrick4);
			removePercept(atbrick4);
		}
		
		if (holdingbrick1) {
			addPercept(holding1);
			removePercept(notholding1);
		} else {
			addPercept(notholding1);
			removePercept(holding1);
		}
		
		
		if (holdingbrick2) {
			addPercept(holding2);
			removePercept(notholding2);
		} else {
			addPercept(notholding2);
			removePercept(holding2);
		}
		
		
		if (holdingbrick3) {
			addPercept(holding3);
			removePercept(notholding3);
		} else {
			addPercept(notholding3);
			removePercept(holding3);
		}
		
		
		if (holdingbrick4) {
			addPercept(holding4);
			removePercept(notholding4);
		} else {
			addPercept(notholding4);
			removePercept(holding4);
		}
		
		if (brick1.isVisible()) {
			addPercept(visible1);
			removePercept(notvisible1);
		} else {
			addPercept(notvisible1);
			removePercept(visible1);
		}
		
		if (brick2.isVisible()) {
			addPercept(visible2);
			removePercept(notvisible2);
		} else {
			addPercept(notvisible2);
			removePercept(visible2);
		}
		
		if (brick3.isVisible()) {
			addPercept(visible3);
			removePercept(notvisible3);
		} else {
			addPercept(notvisible3);
			removePercept(visible3);
		}
		
		if (brick4.isVisible()) {
			addPercept(visible4);
			removePercept(notvisible4);
		} else {
			addPercept(notvisible4);
			removePercept(visible4);
		}
		
	}

}
