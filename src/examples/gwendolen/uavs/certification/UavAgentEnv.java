///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2010-12 University of Liverpool Virtual Engineering Centre.
// 
// Author: Matt Webster
///////////////////////////////////////////////////////////////////////////////


package gwendolen.uavs.certification;

import ail.mas.DefaultEnvironmentwRandomness;
import ail.mas.MAS;
import ail.util.AILexception;
// import ajpf.util.choice.UniformBoolChoice;
// import ajpf.util.choice.UniformIntChoice;
import ail.syntax.Unifier;
import ail.syntax.Action;

/**
 * Environment for a UAV agent to communicate with VESL.
 * 
 * @author matt
 *
 */
public class UavAgentEnv extends DefaultEnvironmentwRandomness {
	
	/**
	 * Two performatives, perform and tell.
	 */
	public static byte performILF = 2;
	public static byte tellILF = 1;
	//private static VESLTest veslInterface;
		
	// state explosion problem with inputsensors4...
	// introduced filter fields here.
	//@FilterField
	Atc atc;
	//@FilterField
	Planner planner;
	//@FilterField
	Nav nav;
	//@FilterField
	Fuel fuel;
	//@FilterField
	DetectAndAvoidSensor das;
	//@FilterField
	Env env;
	//@FilterField
	Vehicle veh;
	
		
	public UavAgentEnv() {
		super();
//		this.setOutputLevel(1);
		
		// instantiate the subsystems
	}
	
	@Override
	public void setMAS(MAS m) {
		super.setMAS(m);
		atc = new Atc(this, random_booleans);
		planner = new Planner(this);
		nav = new Nav(this);
		fuel = new Fuel(this);
		das = new DetectAndAvoidSensor(this, random_booleans);
		env = new Env(this);
		veh = new Vehicle(this, random_booleans);
		
		
		
		// establish link with VESL server
		//veslInterface = new VESLTest(this);
		System.out.println("done starting vesl test");

	}
	
	//int outputlevel = 1;
			
	
	/*
	 * (non-Javadoc)
	 * @see ail.others.DefaultEnvironment#run()
	 */
	public void run() {
		
	}
				
	public void sendMessage() {
		
	}
	
	/**
	 * Handles an agent executing an action.
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
	   	Unifier theta = new Unifier();



	   	
	   	// Send the information from the agent to flightlab.
	   	// if the action is of the format send2fl(x), then send x to the server.
	   	if (act.getFunctor().startsWith("send")) {
		   	System.out.println("Received message: " + act.getFunctor() + "(" + act.getTerm(0) + "), sending " + act.getTerm(0));
		   	//veslInterface.sendMessageFromAgent(act);
    		
		   	// forward the message on to the right sub-system
		   	if (act.getTerm(0).toString().equals("atc") )
			{
		   		atc.tell(act);
			}
		   	else if (act.getTerm(0).toString().equals("planner") )
		   	{
		   		planner.tell(act);
		   	}
		   	else if (act.getTerm(0).toString().equals("nav") )
		   	{
		   		nav.tell(act);
		   	}
		   	else if (act.getTerm(0).toString().equals("fuel") )
		   	{
		   		fuel.tell(act);
		   	}
		   	else if (act.getTerm(0).toString().equals("das") )
		   	{
		   		das.tell(act);
		   	}
		   	else if (act.getTerm(0).toString().equals("env") )
		   	{
		   		env.tell(act);
		   	}
		   	else if (act.getTerm(0).toString().equals("veh") )
		   	{
		   		veh.tell(act);
		   	}
		   	
	   	}
	   	else if (act.getFunctor().startsWith("poll")) {
		   	System.out.println("Polling agents.");
		   	
		
		   	
			// forward the message on to the right sub-system
		   	if (act.getTerm(0).toString().equals("atc") )
			{
		   		atc.step();
			}
		   	else if (act.getTerm(0).toString().equals("das") )
		   	{
		   		das.step();
		   	}
		   	else if (act.getTerm(0).toString().equals("env") )
		   	{
		   		env.step();
		   	}
		   	else if (act.getTerm(0).toString().equals("fuel") )
		   	{
		   		fuel.step();
		   	}
		   	else if (act.getTerm(0).toString().equals("nav") )
		   	{
		   		nav.step();
		   	}
		   	else if (act.getTerm(0).toString().equals("planner") )
		   	{
		   		planner.step();
		   	}
		   	else if (act.getTerm(0).toString().equals("veh") )
		   	{
		   		veh.step();
		   	}
    		
		   	
		   	//Structure s = new Structure("pollDone");
			//this.addMessage("exec", new Message(1,"env","exec",s));
	   	}
	   	

	   		
	   	
	   	

	   	
	   	try {
	   		theta = super.executeAction(agName, act);
    	} catch (AILexception e) {
    		throw e;
    	}
    //	run();

    	return theta;
    }

   	protected String ilfString(int ilf) {
   		if (ilf == performILF) {
   			return "do:";
   		} else {
   			return "tell:";
   		}
   	}
   	

}
