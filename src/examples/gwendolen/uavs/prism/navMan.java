package gwendolen.uavs.prism;

import java.util.List;

import ail.mas.vehicle.Sensor;
import ail.mas.vehicle.UnreliableSensor;
import ail.syntax.Predicate;
import ajpf.util.VerifyList;

public class navMan implements Sensor {
	/**
	 * The list of current data provided by the sensor to an agent.
	 */
	VerifyList<Predicate> percepts = new VerifyList<Predicate>();

	@Override
	public int compareTo(Sensor arg0) {
			if (arg0 instanceof navMan) {
				return 1;
			}
			return -1;
		}

	@Override
	public List<Predicate> getPercepts() {
		// TODO Auto-generated method stub
		return percepts;
	}

	@Override
	public void addPercept(Predicate l) {
		// TODO Auto-generated method stub
		String s = l.getFunctor();
		if (s.equals("landing") || s.equals("changeHeading") || s.equals("headingOK")) {
			percepts.clear();
			percepts.add(l);
		}

	}

	@Override
	public void removePercept(Predicate l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearPercepts() {
		percepts.clear();
		// TODO Auto-generated method stub

	}

}
