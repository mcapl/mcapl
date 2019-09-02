package gwendolen.orca.Prototype6VK;

import ail.syntax.Message;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.StringTermImpl;

public class RoutePlanner {

	private ORCAEnv env;
	private String target;
	private String urgency;
	
	public RoutePlanner() {
		
	}
	
	public RoutePlanner(ORCAEnv e) {
		env=e;
		
	}
	
	public void getRoutes(String t, String u) {
		target=t;
		urgency=u;
		//this.start(); 
		
		// route planner returns routes like 
		// routePlanner(routeName, energy, time, risk)
		Predicate p1 = new Predicate("route1");
   		p1.addTerm(new NumberTermImpl("324")); // most energy efficient
   		p1.addTerm(new NumberTermImpl("28099"));
   		p1.addTerm(new NumberTermImpl("4"));
 		env.addMessage("executive", new Message(1,"routePlanner","executive",p1));
 		
 		Predicate p2 = new Predicate("route2");
   		p2.addTerm(new NumberTermImpl("345"));
   		p2.addTerm(new NumberTermImpl("28545"));
   		p2.addTerm(new NumberTermImpl("2"));	// least risky
 		env.addMessage("executive", new Message(1,"routePlanner","executive",p2));

 		Predicate p3 = new Predicate("route3");
   		p3.addTerm(new NumberTermImpl("410"));
   		p3.addTerm(new NumberTermImpl("24848"));  // quickest route
   		p3.addTerm(new NumberTermImpl("3"));
 		env.addMessage("executive", new Message(1,"routePlanner","executive",p3));
 		
 		Predicate p4 = new Predicate("routesSent");
   		p4.addTerm(new NumberTermImpl("3"));
 		env.addMessage("executive", new Message(1,"routePlanner","executive",p4));
 				
		
	}

	public void enactRoute(String r, String t, String u) {
		
		// just send a message back that we're doing the thing
		Predicate p1 = new Predicate("routing");
   		p1.addTerm(new Predicate(r));
   		p1.addTerm(new Predicate(t));
   		p1.addTerm(new Predicate(u));
 		env.addMessage("executive", new Message(1,"routePlanner","executive",p1));
		
	}	


	
	
}
