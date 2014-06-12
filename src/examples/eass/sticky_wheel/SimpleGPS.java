package eass.sticky_wheel;

import java.util.ArrayList;
import java.util.List;

import ail.mas.vehicle.Sensor;
import ail.syntax.Predicate;
import ail.syntax.NumberTerm;

public class SimpleGPS implements Sensor {
	Predicate position;

	@Override
	public int compareTo(Sensor o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Predicate> getPercepts() {
		// TODO Auto-generated method stub
		ArrayList<Predicate> percepts = new ArrayList<Predicate>();
		if (position != null) {
			percepts.add(position);
		}
		return percepts;
	}

	@Override
	public void addPercept(Predicate l) {
		if (l.getFunctor().equals("position")) {
			position = l;
		}

	}

	@Override
	public void removePercept(Predicate l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearPercepts() {
		// TODO Auto-generated method stub

	}
	
	public double getX() {
		return ((NumberTerm) position.getTerm(0)).solve();
	}
	
	public double getY() {
		return ((NumberTerm) position.getTerm(1)).solve();
	}

	public double getTheta() {
		return ((NumberTerm) position.getTerm(2)).solve();
	}


}
