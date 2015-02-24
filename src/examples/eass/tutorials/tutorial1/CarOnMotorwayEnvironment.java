package eass.tutorials.tutorial1;

import eass.mas.socket.EASSSocketEnvironment;
import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;

public class CarOnMotorwayEnvironment extends EASSSocketEnvironment {
	
	public void readPredicatesfromSocket() {
		int x = socket.readInt();
		int y = socket.readInt();
		int xdot = socket.readInt();
		int ydot = socket.readInt();
		
		Literal xpos = new Literal("xpos");
		xpos.addTerm(new NumberTermImpl(x));
		
		Literal ypos = new Literal("ypos");
		ypos.addTerm(new NumberTermImpl(y));
		
		Literal xspeed = new Literal("xspeed");
		xspeed.addTerm(new NumberTermImpl(xdot));
		
		Literal yspeed = new Literal("yspeed");
		yspeed.addTerm(new NumberTermImpl(ydot));
		
		addUniquePercept("xpos", xpos);
		addUniquePercept("ypos", ypos);
		addUniquePercept("xspeed", xspeed);
		addUniquePercept("yspeed", yspeed);
	}


}
