package goal.programming_guide.chapter1;

import ail.syntax.Action;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILexception;
import goal.mas.GoalEnvironment;

public class HelloWorldEnvironment extends GoalEnvironment {
	int printcount = 0;

	@Override
	public Unifier executeAction(String agName, Action act) throws AILexception {
		
		
		if (act.getFunctor().equals("printText")) {
			System.out.println(act.getTerm(0));
			
			this.clearPercepts();
			
			printcount++;
			Predicate lastprintedtext = new Predicate("lastPrintedText");
			lastprintedtext.addTerm(act.getTerm(0));
			
			Predicate printedtext = new Predicate("printedText");
			printedtext.addTerm(new NumberTermImpl(printcount));
			
			Predicate percept1 = new Predicate("percept");
			percept1.addTerm(lastprintedtext);
			
			Predicate percept2 = new Predicate("percept");
			percept2.addTerm(printedtext);
			
			addPercept(percept1);
			addPercept(percept2);
		}
		
		return super.executeAction(agName, act);
	}
}
