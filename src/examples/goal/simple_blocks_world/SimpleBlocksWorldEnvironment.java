package goal.simple_blocks_world;

import java.util.HashMap;
import java.util.List;

import ail.syntax.Action;
import ail.syntax.ListTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import goal.mas.GoalEnvironment;

public class SimpleBlocksWorldEnvironment extends GoalEnvironment {
	static Predicate start_pred = new Predicate("in");
	static {
		start_pred.addTerm(new Predicate("start"));
	}
	
	boolean at_a_brick = false;
	String holding;
	
	Predicate location_pred = start_pred;
	String location = "start";
	Predicate visible_brick;
	Predicate at_brick;
		
	public static class Brick {
		String colour;
		String brick_name;
		
		public Brick() {};
		
		public void setAttributes(String n, String c) {
			brick_name = n;
			colour=c;
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
				visible_brick = null;
			}
			if (at_a_brick) {
				removePercept(at_brick);
				at_a_brick = false;
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
		} else if (functor.equals("gotToBrick")) {
			at_a_brick = true;
			at_brick = new Predicate("atBrick");
			at_brick.addTerm(act.getTerm(0));
			addPercept(at_brick);			
		} else if (functor.equals("pickUp")) {
			if (at_a_brick) {
				if (visible_brick != null) {
					removePercept(visible_brick);
					visible_brick = null;
				}
				Predicate holding_pred = new Predicate("holding");
				holding = at_brick.getTerm(0).getFunctor();
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
			}
		}
		
		return u;
	}

}
