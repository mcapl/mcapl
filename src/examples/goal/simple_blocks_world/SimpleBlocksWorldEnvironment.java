package goal.simple_blocks_world;

import java.util.HashMap;
import java.util.List;

import ail.syntax.Action;
import ail.syntax.ListTermImpl;
import ail.syntax.Predicate;
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
		brick_locations.put("Room2", brick2);
		brick_locations.put("Room3", brick3);
		brick_locations.put("Room4", brick4);
		addPercept(location_pred);
		
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
	
	

	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
				
		String functor = act.getFunctor();
		if (functor.equals("goTo")) {
			removePercept(location_pred);
			if (visible_brick != null) {
				removePercept(visible_brick);
				Predicate notvisible = new Predicate("not");
				notvisible.addTerm(visible_brick);
				addPercept(notvisible);
				visible_brick = null;
			}
			if (at_a_brick) {
				removePercept(at_brick);
				at_a_brick = false;
				Predicate notatbrick = new Predicate("not");
				notatbrick.addTerm(at_brick);
				addPercept(notatbrick);
			}
			location_pred = new Predicate("in");
			location = act.getTerm(0).getFunctor();
			location_pred.addTerm(act.getTerm(0));
			addPercept(location_pred);
			if (brick_locations.containsKey(location)) {
				visible_brick = new Predicate("visible");
				Brick b = brick_locations.get(location);
				visible_brick.addTerm(new Predicate(b.brick_name));
				visible_brick.addTerm(new Predicate(b.colour));
				addPercept(visible_brick);
			}
			System.err.println("moving to " + act.getTerm(0));
		} else if (functor.equals("goToBrick")) {
			at_a_brick = true;
			at_brick = new Predicate("atBrick");
			at_brick.addTerm(act.getTerm(0));
			System.err.println("moving to " + act.getTerm(0));
			addPercept(at_brick);			
		} else if (functor.equals("pickUp")) {
			if (at_a_brick) {
				if (visible_brick != null) {
					removePercept(visible_brick);
					visible_brick = null;
				}
				Predicate holding_pred = new Predicate("holding");
				holding = at_brick.getTerm(0).getFunctor();
				System.err.println("picking up brick");
				removePercept(at_brick);
				at_brick = null;
				
				holding_pred.addTerm(new Predicate(holding));
				addPercept(holding_pred);
				at_a_brick = false;
				
			}
			
			
		} else if (functor.equals("putDown")) {
			if (holding != null) {
				Predicate holding_pred = new Predicate("holding");
				holding_pred.addTerm(new Predicate(holding));
				removePercept(holding_pred);
				System.err.println("putting down brick");
				holding = null;
			}
		}
		
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
		atbrick1.addTerm(new Predicate("brick4"));
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
		holding1.addTerm(new Predicate("brick4"));
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
		
		
	}

}
