package goal.programming_guide.chapter6;

import java.util.HashMap;
import java.util.Set;

import ail.syntax.Action;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import goal.mas.GoalEnvironment;

public class SimpleTowerWorldEnvironment extends GoalEnvironment {
	
	public enum Block {
		a, b, c, d, e, f;
	}
	
	public Block holding;
	public Block newholding;
	
	public HashMap<Block, Block> onlist = new HashMap<Block, Block>();
	public HashMap<Block, Block> newonlist = new HashMap<Block, Block>();
	
	public SimpleTowerWorldEnvironment() {
		super();
		setPercepts();
	}
		
	private boolean ontable(Block b) {
		return (!onlist.containsKey(b) && holding != b);
	}
	
	private boolean clear(Block b) {
		return !(onlist.containsValue(b));
	}
	
	int percept_call_counter = 0;
	@Override 
	public Set<Predicate> getPercepts(String agName, boolean update) {
		if (percept_call_counter < 5) {
			percept_call_counter++;
		} else {
			holding = newholding;
			onlist = newonlist;
			setPercepts();
			percept_call_counter = 0;
		}
		Set<Predicate> returns = super.getPercepts(agName, update);
		// System.err.println(returns);
		return returns;
		
	}
	
	private String getBlockName(Block b) {
		switch (b) {
		case a:
			return "a";
		case b:
			return "b";
		case c:
			return "c";
		case d:
			return "d";
		case e:
			return "e";
		default:
			return "f";
		}
	}
	
	private Block getBlock(String s) {
		if (s.equals("a")) {
			return Block.a;
		}
		
		if (s.equals("b")) {
			return Block.b;
		}
		if (s.equals("c")) {
			return Block.c;
		}
		if (s.equals("d")) {
			return Block.d;
		}
		if (s.equals("e")) {
			return Block.e;
		}
		return Block.f;
	}
	
	
	private void addLocation(Block b) {
		Predicate block = new Predicate("block");
		block.addTerm(new Predicate(getBlockName(b)));
		addPercept(block);
		
		Predicate on = new Predicate("on");
		on.addTerm(new Predicate(getBlockName(b)));
		if (ontable(b)) {
			on.addTerm(new Predicate("table"));
		} else if (holding != b){
			on.addTerm(new Predicate(getBlockName(onlist.get(b))));
		}
		addPercept(on);
		
	}
	
	private void setPercepts() {
		clearPercepts();
		if (holding != null) {
			Predicate holdingp = new Predicate("holding");
			holdingp.addTerm(new Predicate(getBlockName(holding)));
			addPercept(holdingp);
		} 
		
		addLocation(Block.a);
		addLocation(Block.b);
		addLocation(Block.c);
		addLocation(Block.d);
		addLocation(Block.e);
		addLocation(Block.f);
		
		
	}
	
	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();
				
		String functor = act.getFunctor();
		if (functor.equals("pickup")) {
			holding = getBlock(act.getTerm(0).getFunctor());
			newholding = holding;
			if (!ontable(holding)) {
				onlist.remove(holding, onlist.get(holding));
			} 
			newonlist = onlist;
		} else if (functor.equals("putdown")) {
			Block putdown = holding;
			newholding = null;
			String target = act.getTerm(1).getFunctor();
			if (! target.equals("table")) {
				newonlist.put(putdown, getBlock(target));
			}
		} else if (functor.equals("nil")) {
			newonlist = onlist;
			newholding = holding;
		}
		setPercepts();
		
		return u;
	}
	

}
