package eass.mas.vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

import eass.mas.EASSEnv;
import ail.mas.vehicle.Sensor;
import ail.mas.vehicle.Vehicle;
import ail.mas.vehicle.VehicleEnv;
import ail.mas.vehicle.VehicleInterface;
import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ail.semantics.AILAgent;
import eass.semantics.EASSAgent;
import gov.nasa.jpf.annotation.FilterField;
import ail.syntax.Action;
import ail.syntax.BroadcastSendAction;
import ail.syntax.Literal;
import ail.syntax.Message;
import ail.syntax.Predicate;
import ail.syntax.PredicatewAnnotation;
import ail.syntax.SendAction;
import ail.syntax.StringTerm;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.AILConfig;
import ail.util.AILexception;
import ajpf.MCAPLJobber;
import ajpf.MCAPLScheduler;
import ajpf.PerceptListener;
import ajpf.util.AJPFLogger;
import ajpf.util.VerifyList;
import ajpf.util.VerifyMap;
import ajpf.util.VerifySet;

public class EASSVehicle implements VehicleInterface, EASSEnv {
	/**
	 * The agent that controls the vehicle.
	 */
	EASSAgent agent;
	
	EASSAgent abstraction;
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
	VerifySet<Message> agent_inbox = new VerifySet<Message>();
	VerifySet<Message> abstraction_inbox = new VerifySet<Message>();
	
	/**
	 * List of abstraction engines.
	 */
	protected List<String> abstractionenginelist = new ArrayList<String>();
	protected Map<String, String> abstractionengines = new HashMap<String, String>();

	private String logname = "eass.mas.vehicle.EASSVehicle";

	/**
	 * Beliefs shared by all agents.  May need to be modifed for multi-agent setting.
	 */
	private Map<String,ArrayList<Literal>>  agSharedBeliefs = new VerifyMap<String, ArrayList<Literal>>();

	/**
	 * List of agents who have already "collected" the current set of percepts.
	 */
	protected VerifySet<String> uptodateAgs = new VerifySet<String>();
	
	/**
	 * The multi-agent system.
	 */
	protected MAS mas;

	@Override
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#executeAction(java.lang.String, ail.syntax.Action)
	 * 
	 * When the agent executes an action this is passed through to the environment.  If we add actuators to vehicles
	 * then they should mediate between the vehicle and the environment.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
			Unifier u = new Unifier();
			boolean printed = false;
			 
		   if (act.getFunctor().equals("assert_shared")) {
			   addSharedBelief(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
			   printed = true;
			   if (AJPFLogger.ltFine(logname)) {
				   AJPFLogger.fine(logname, agName + " done " + act);
			   }
		   } else  if (act.getFunctor().equals("remove_shared")) {
			   removeSharedBelief(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
			   printed = true;
			   if (AJPFLogger.ltFine(logname)) {
				   AJPFLogger.fine(logname, agName + " done " + act);
			   }
		   } else  if (act.getFunctor().equals("remove_shared_unifies")) {
			   removeUnifiesShared(agName, new Literal(true, new PredicatewAnnotation((Predicate) act.getTerm(0))));
		   } else if (act.getFunctor().equals("perf")) {
			   Predicate run = (Predicate) act.getTerm(0);
			   Message m = new Message(2, agName, "abstraction", run);
			   String abs = abstractionengines.get(agName);
			   addMessage(abs, m);
			   if (AJPFLogger.ltFine(logname)) {
				   AJPFLogger.fine(logname, agName + " done PERF " + act);
			   }
		   } else if (act.getFunctor().equals("query")) {
			   Predicate query = (Predicate) act.getTerm(0);
			   Message m = new Message(2, agName, "abstraction", query);
			   String abs = abstractionengines.get(agName);
			   addMessage(abs, m);
		   }  else	if (act.getFunctor().equals("append_string_pred")) {
	    		StringTerm x = (StringTerm) act.getTerm(0);
	    		String y =  act.getTerm(1).toString();
	    		String append = x.getString() + y;
	    		VarTerm result = (VarTerm) act.getTerm(2);
	    		StringTermImpl z = new StringTermImpl(append);
	    		u.unifies(result, z);
	    		printed = true;
	    	} else {
	     		 u = env.executeAction(agent.getAgName(), act);
	    		 printed = true;
	    	}
		   
		   if (!printed) {
			   AJPFLogger.info(logname, agName + " done " + printAction(act));
		   }

		     
		   return u;
	}
	
	
    protected String printAction(Action act) {
    	if (act instanceof SendAction) {
    		SendAction sa = (SendAction) act;
     		String s = "send(" + ilfString(sa.getILF()) + sa.getContent().toString() + ", " + sa.getReceiver().toString() + ")";
    		return s;
    	} else if (act instanceof BroadcastSendAction) {
    		BroadcastSendAction sa = (BroadcastSendAction) act;
     		String s = "send(" + ilfString(sa.getILF()) + sa.getContent().toString() + ", " + sa.getReceivers().toString() + ")";
    		return s;
    	}
    		
    	return act.toString();
    	
    }
    
    /**
     * Overridable method for printing illocutionary forces.
     * @param ilf
     * @return
     */
    protected  String ilfString(int ilf) {
    	String s = ilf + ":";
    	return s;
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
		if (agSharedBeliefs.containsKey(ag)) {
			percepts.addAll(agSharedBeliefs.get(ag));
		}
		return percepts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#getMessages(java.lang.String)
	 */
	public Set<Message> getMessages(String s) {
		VerifySet<Message> messages = new VerifySet<Message>();
		VerifySet<Message> inbox = new VerifySet<Message>();
		if (s.equals(agent.getAgName())) {
			inbox = agent_inbox;
		} else {
			inbox = abstraction_inbox;
		}
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
	 * @see ail.mas.AILEnv#begin()
	 */
	public void begin() {
		env.begin();
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
		EASSAgent eass = (EASSAgent) a;
		if (eass.isAbstractionEngine()) {
			abstraction = eass;
			addAbstractionEngine(eass.getAgName(), eass.getReasoningName());
		} else {
			agent = eass;
		}
	}
	
	public void setInterface(JPanel ui) {
		((EASSVehicleEnvironment) env).setInterface(ui);
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
		if (agent != null) {
			return agent.getAgName();
		} else {
			return abstraction.getReasoningName();
		}
	}
		
	/**
	 * Add a message to the inbox.
	 * @param m
	 */
	public void addMessage(String agName, Message m) {
		if (agName.equals(agent.getAgName())) {
			agent_inbox.add(m);
			env.notifyListeners(agName);
		} else {
			abstraction_inbox.add(m);
			env.notifyListeners(agName);
		}
	}
	
	/**
	 * Remove a message from the inbox.
	 * @param m
	 */
	public void removeMessage(Message m) {
		agent_inbox.remove(m);
		abstraction_inbox.remove(m);
	}
	
	/**
	 * Clear the inbox.
	 */
	public void clearMessages() {
		agent_inbox.clear();
		abstraction_inbox.clear();
	}

	/**
	 * Add a percept to the sensors.
	 * @param l
	 */
	public void addPercept(Predicate l) {
		for (Sensor s: sensors) {
			s.addPercept(l);
		}
		
		env.notifyListeners(abstraction.getAgName());
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
	public void cleanup() {}


	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#init_before_adding_agents()
	 */
	@Override
	public void init_before_adding_agents() {}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#init_after_adding_agents()
	 */
	@Override
	public void init_after_adding_agents() {}
	
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

	@Override
	public void do_job() {
		eachrun();
		
	}

	@Override
	public int compareTo(MCAPLJobber o) {
		return o.getName().compareTo(getName());
	}

	@Override
	public void addAbstractionEngine(String s, String foragent) {
		abstractionengines.put(s, foragent);
		abstractionengines.put(foragent, s);
		abstractionenginelist.add(s);
	}

	@Override
	public String rationalName(String name) {
		int index = 12;
		if (name.length() > index) {
			return name.substring(index);
		} else {
			return name;
		}
	}

	@Override
	public void eachrun() {
		AJPFLogger.finer(logname, this.toString());
	}

	@Override
	public void addSharedBelief(String agName, Literal per) {
		if (per != null && agName != null) {
			ArrayList<Literal> agl = agSharedBeliefs.get(agName);
			if (agl == null) {
				agl = new ArrayList<Literal>();
				uptodateAgs.remove(agName);
				agl.add(per);
				agSharedBeliefs.put( agName, agl);
			} else {
				if (! agl.contains(per)) {
					uptodateAgs.remove(agName);
					agl.add(per);
					Collections.sort(agl);
				}
			}
			
			String partneragent = abstractionengines.get(agName);
			ArrayList<Literal> agl2 = agSharedBeliefs.get(partneragent);
			if (partneragent == null) {
				
			} else {
			if (agl2 == null) {
				agl2 = new ArrayList<Literal>();
				uptodateAgs.remove(partneragent);
				agl2.add(per);
				agSharedBeliefs.put(partneragent, agl2);
			} else {
				if (! agl2.contains(per)) {
					uptodateAgs.remove(partneragent);
					agl2.add(per);
					Collections.sort(agl2);
				}
			}
			}
	}
	// System.err.println(this);
	//System.err.println(agName + " releasing flag");
	
				
	notifySharedListeners(agName);
	}

	@Override
	public boolean removeSharedBelief(String agName, Literal per) {
		boolean result = true;
		// System.err.println(agName + " removing " + per);
		boolean resulttoreturn = false;
		// ArrayList<String> tonotify = new ArrayList<String>();
			// System.err.println(agName + " has flag");
			if (per != null && agName != null) {
				ArrayList<Literal> agl = agSharedBeliefs.get(agName);
				ArrayList<Literal> aglr = new ArrayList<Literal>();
				if (agl != null && ! agl.isEmpty()) {
					uptodateAgs.remove(agName);
					try {
						for (Literal l: agl) {
							if (l.equals(per)) {
								// notifyListeners(agName);
								//result = agl.remove(l);
								aglr.add(l);
							}
						}
						result = agl.removeAll(aglr);
					} catch (Exception e) {
						System.out.println("PROBLEM" + agl);
					}
				}
			
				String partneragent = abstractionengines.get(agName);
				List<Literal> agl2 = agSharedBeliefs.get(partneragent);
				if (agl2 != null && !agl2.isEmpty()) {
					uptodateAgs.remove(partneragent);
					for (Literal l: agl2) {
						if (l.equals(per)) {
							// System.err.println("i");
							if (result) {
								// System.err.println(agName + "agl2 remove");
								resulttoreturn = agl2.remove(l);
								break;
							} else {
								// System.err.println("g");
								agl2.remove(l);
								// System.err.println(agName + "return false 1");
								resulttoreturn = false;
								break;
							}
						}
					}
				}
		}
		// System.err.println("d");
		notifySharedListeners(agName);
		// System.err.println(agName + " return " + resulttoreturn);
		return resulttoreturn;
	}

	@Override
	public void notifySharedListeners(String agName) {
		env.notifyListeners(agName);
		env.notifyListeners(abstractionengines.get(agName));
	}

	@Override
	public boolean removeUnifiesShared(String agName, Literal per) {
		boolean b = false;
		// System.err.println(agName + " removing shared");
			Literal rper = null;
			if (per != null) {
				uptodateAgs.remove(agName);
				List<Literal> sharedbeliefs = agSharedBeliefs.get(agName);
				if (sharedbeliefs != null) {
					for (Literal p: sharedbeliefs) {
						if (p.unifies(per, new Unifier())) {
							rper = p;
						}
					}
				
						
					if (rper != null) {
						b = sharedbeliefs.remove(rper);
					}

					Collections.sort(sharedbeliefs);
				
					String partneragent = abstractionengines.get(agName);
					uptodateAgs.remove(partneragent);
					List<Literal> psharedbeliefs = agSharedBeliefs.get(agName);
					for (Literal p: psharedbeliefs) {
						if (p.unifies(per, new Unifier())) {
							rper = p;
						}
					}
						
					if (rper != null) {
						b = psharedbeliefs.remove(rper);
					}

					Collections.sort(psharedbeliefs);
				
				// notifySharedListeners(agName);
					return b;
				}
			} 
					
		// System.err.println(agName + " releasing flag");
		notifySharedListeners(agName);
		return b;
	}
	
	public AILAgent getAgent() {
		return agent;
	}


	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#setMAS(ail.mas.MAS)
	 */
	@Override
	public void setMAS(MAS m) {
		mas = m;
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#notifyListeners()
	 */
	@Override
	public void notifyListeners() {
		env.notifyListeners();
	}

	/*
	 * (non-Javadoc)
	 * @see ail.mas.AILEnv#notifyListeners(java.lang.String)
	 */
	@Override
	public void notifyListeners(String name) {
		env.notifyListeners(name);
	}

	/*
	 * 
	 */
	@Override
	public List<AILAgent> getAgents() {
		ArrayList<AILAgent> agents = new ArrayList<AILAgent>();
		agents.add(agent);
		agents.add(abstraction);
		return agents;
	}

}
