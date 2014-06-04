package eass.mas.vehicle;

import java.util.Set;
import java.util.TreeSet;

import eass.mas.DefaultEASSEnvironment;

import ail.mas.vehicle.Sensor;
import ail.mas.vehicle.Vehicle;
import ail.mas.vehicle.VehicleEnv;
import ail.mas.vehicle.VehicleInterface;
import ail.semantics.AILAgent;
import ail.syntax.Action;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.Unifier;
import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ajpf.util.VerifyList;
import ajpf.util.VerifySet;

public class EASSVehicle extends DefaultEASSEnvironment implements VehicleInterface {
	/**
	 * The agent that controls the vehicle.
	 */
	AILAgent agent;
	/**
	 * The vehicle's sensors.
	 */
	VerifyList<Sensor> sensors = new VerifyList<Sensor>();
	/**
	 * The environment the vehicle operates in.
	 */
	VehicleEnv env;
	/**
	 * The vehicle's inbox.
	 */
	VerifySet<Message> inbox = new VerifySet<Message>();

	@Override
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executeAction(java.lang.String, ail.syntax.Action)
	 * 
	 * When the agent executes an action this is passed through to the environment.  If we add actuators to vehicles
	 * then they should mediate between the vehicle and the environment.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		return env.executeAction(agName, act);
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getPercepts(java.lang.String, boolean)
	 * 
	 * The agent gets percepts from the vehicle's sensors.
	 */
	public Set<Predicate> getPercepts(String ag, boolean b) {
		TreeSet<Predicate> percepts = new TreeSet<Predicate>();
		for (Sensor s: sensors) {
			percepts.addAll(s.getPercepts());
		}
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getMessages(java.lang.String)
	 */
	public Set<Message> getMessages(String s) {
		VerifySet<Message> messages = new VerifySet<Message>();
		for (Message m: inbox) {
			messages.add(m);
		}
		inbox.clear();
		return messages;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#done()
	 */
	public boolean done() {
		return env.done();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#lastAction()
	 */
	public Action lastAction() {
		return env.lastAction();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#lastActionby()
	 */
	public String lastActionby() {
		return env.lastActionby();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#configure(ail.util.AILConfig)
	 */
	public void configure(AILConfig config) {
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#addPerceptListener(ajpf.PerceptListener)
	 */
	public void addPerceptListener(PerceptListener p) {
		env.addPerceptListener(p);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#addAgent(ail.semantics.AILAgent)
	 */
	public void addAgent(AILAgent a) {
		agent = a;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getScheduler()
	 */
	public MCAPLScheduler getScheduler() {
		return env.getScheduler();
	}
	    
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setScheduler(ajpf.MCAPLScheduler)
	 */
	public void setScheduler(MCAPLScheduler s) {
		env.setScheduler(s);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Vehicle v) {
		return getName().compareTo(v.getName());
	}
	
	/**
	 * We use the name of the agent as a name for the vehicle.  And use this to provide a hacky version of compareTo.
	 * @return
	 */
	public String getName() {
		return agent.getAgName();
	}
	
	/**
	 * Add a message to the inbox.
	 * @param m
	 */
	public void addMessage(Message m) {
		inbox.add(m);
	}
	
	/**
	 * Remove a message from the inbox.
	 * @param m
	 */
	public void removeMessage(Message m) {
		inbox.remove(m);
	}
	
	/**
	 * Clear the inbox.
	 */
	public void clearMessages() {
		inbox.clear();
	}

	/**
	 * Add a percept to the sensors.
	 * @param l
	 */
	public void addPercept(Predicate l) {
		for (Sensor s: sensors) {
			s.addPercept(l);
		}
	}

	/**
	 * Remove a percept from the sensors.
	 * @param l
	 */
	public boolean removePercept(Predicate l) {
		for (Sensor s: sensors) {
			s.removePercept(l);
		}
		return true;
	}
	
	/**
	 * Clear the sensors.
	 */
	public void clearPercepts() {
		for (Sensor s: sensors) {
			s.clearPercepts();
		}
	}
	
	/**
	 * Add a sensor to the vehicle.
	 * @param s
	 */
	public void addSensor(Sensor s) {
		sensors.add(s);
	}
	
	/**
	 * Set the vehicle's environment.
	 * @param e
	 */
	public void setEnv(VehicleEnv e) {
		env = e;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	public void finalize() {}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#initialise()
	 */
	public void initialise() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executing(java.lang.String, ail.syntax.Action)
	 */
	public boolean executing(String agName, Action act) {
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#actionResult(java.lang.String, ail.syntax.Action)
	 */
	public Unifier actionResult(String agName, Action act) {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#agentIsUpToDate(java.lang.String)
	 */
	public boolean agentIsUpToDate(String agName) {
		return false;
	}


}
