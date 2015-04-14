package eass.platooning;

import java.util.ArrayList;

import ail.mas.NActionScheduler;
import eass.platooning.util.Vehicle;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.NumberTerm;
import ail.syntax.NumberTermImpl;
import ail.syntax.Predicate;
import ail.syntax.StringTermImpl;
import ail.syntax.Term;
import ail.syntax.Unifier;
import ail.syntax.VarTerm;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;
import eass.mas.DefaultEASSEnvironment;


//import eass.mas.matlab.EASSMatLabEnvironment;


public class PlatoonEnvironment extends DefaultEASSEnvironment{
	String logname = "eass.platooning.PlatoonEnvironment";

	
	ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	Vehicle v1 = new Vehicle(1);
	Vehicle v2 = new Vehicle(2);
	Vehicle v3 = new Vehicle(3);
	int counter=0;
	/**
	 * Constructor.
	 *
	 */
	public PlatoonEnvironment() {
		super();
		NActionScheduler s = new NActionScheduler(50);
		s.addJobber(this);
		setScheduler(s);
		addPerceptListener(s);
	}
		
	
	/*
	 * (non-Javadoc)
	 * @see eass.mas.DefaultEASSEnvironment#initialise()
	 */
	public void initialise() {
		super.initialise();
		vehicles.add(v1);
		vehicles.add(v2);
		vehicles.add(v3);
	}

	public void eachrun() {
		counter++;
		if(counter ==5){
		for (Vehicle v: vehicles) {
			v.update();


//			Literal precedingPlatoonID = new Literal("precedingPID");
//			precedingPlatoonID.addTerm(new NumberTermImpl(v.getprecedingPID()));
//			addUniquePercept("abstraction_follower"+ v.getID(), "precedingPID", precedingPlatoonID);
			
//			Literal egoPlatoonID = new Literal("egoPID");
//			egoPlatoonID.addTerm(new NumberTermImpl(v.getegoPID()));
//			addUniquePercept("abstraction_follower"+ v.getID(), "egoPID", egoPlatoonID);

//			Literal precedingSpeed = new Literal("precedingSpeed");
//			precedingSpeed.addTerm(new NumberTermImpl(v.getprecedingSpeed()));
//			addUniquePercept("abstraction_follower"+ v.getID(), "precedingSpeed", precedingSpeed);
			
//			Literal speed = new Literal("speed");
//			speed.addTerm(new NumberTermImpl(v.getSpeed()));
//			addUniquePercept("abstraction_follower"+ v.getID(), "speed", speed);

			Literal timeStamp = new Literal("timeStamp");
			timeStamp.addTerm(new NumberTermImpl(v.getTimeStamp()));
			addUniquePercept("abstraction_follower"+ v.getID(), "timeStamp", timeStamp);

			
//			if(counter ==3){

//			Literal precedingLatency = new Literal("precedingLatency");
//			precedingLatency.addTerm(new NumberTermImpl(v.getPrecedingLatency()));
//			addUniquePercept("abstraction_follower"+ v.getID(), "precedingLatency", precedingLatency);
			
			Literal leaderLatency = new Literal("leaderLatency");
			leaderLatency.addTerm(new NumberTermImpl(v.getLeaderLatency()));
			addUniquePercept("abstraction_follower"+ v.getID(), "leaderLatency", leaderLatency);

			Literal distance = new Literal("distance");
			distance.addTerm(new NumberTermImpl(v.getDistance()));
			addUniquePercept("abstraction_follower"+ v.getID(), "distance", distance);		

			counter=0;
			}
			

//			Literal azimuth = new Literal("azimuth");
////			egoPlatoonId.addTerm(new NumberTermImpl(v.getegoPID());
//			azimuth.addTerm(new NumberTermImpl(v.getAzimuth()));
//			addUniquePercept("abstraction_follower"+ v.getID(), "azimuth", azimuth);
////			System.out.println("azimuth is "+ v.getAzimuth());
//			counter=0;
		} 
//		}

	}
	
	public boolean done() {
		   return false;
		}

	public Unifier executeAction(String agName, Action act) throws AILexception {
		   
		Unifier u = new Unifier();
		boolean printed = false;
		 
	   if (act.getFunctor().equals("run")) {
//			   int agentnum = Integer.parseInt(((String) agName).substring(14));
//			   System.out.println("agentnumber is "+ agentnum+ " and its name is "+ agName);
			   Predicate predlist = (Predicate) act.getTerm(0);
			   Predicate predargs = (Predicate) act.getTerm(1);
//			   int num_args = predargs.getTermsSize();
//			   System.out.println("number of arguments is "+ num_args);

			   //			   String num_arg_s = "" + num_args;
			   int num_name_comps = predlist.getTermsSize();
//			   System.out.println("length of action predicate is "+ num_name_comps);

			   String predname = "";

			   // to extract predname as String
			   for (int i=0; i<num_name_comps; i++) {
				   // Lots of extra work to get the string correct.
				   Term nb = predlist.getTerm(i);
				   String s = nb.toString();
				   if (nb instanceof VarTerm) {
					   VarTerm v = (VarTerm) nb;
					   nb = v.getValue();
				   }
				   if (nb instanceof NumberTerm) {
					   NumberTerm num = (NumberTerm) nb;
					   Double number = num.solve();
					   int num_as_int = number.intValue();
					   s = ((Integer) num_as_int).toString();
				   }
				   if (nb instanceof StringTermImpl) {
					   StringTermImpl string = (StringTermImpl) nb;
					   s = string.getString();
				   }
				   predname += s;
			   }
			   
			   	double arg_list[] = new double[1];
			   	for (int i=0; i < 1; i++) {
			   		Term arg = predargs.getTerm(i);
			   		arg_list[i]= 0;
//			   		String s = arg.toString();
			   		if (arg instanceof VarTerm) {
			   			VarTerm v = (VarTerm) arg;
			   			arg = v.getValue();
			   		}
			   		if (arg instanceof NumberTerm) {
			   			NumberTerm num = (NumberTerm) arg;
			   			Double number = num.solve();
			   			arg_list[i] = number.intValue();
			   		}
			   		if (arg instanceof StringTermImpl) {
			   			arg_list[i]= 0;
			   		}
			   	}
//			   System.out.println("real call for performing an action for "+ predname);

			   // send the predicate for vehicle to convert it to binary
				for (Vehicle v: vehicles) {
					if (agName.equals("abstraction_follower"+v.getID()))
//						System.out.println("action predicate is "+ predname);
//						System.out.println("argument predicate is "+ arg_list[0]);
					
						v.execute(predname, 1, arg_list);
				}
	   }  else {
     		 u = super.executeAction(agName, act);
    		 printed = true;
    	}
	   
	   if (!printed) {
		   AJPFLogger.info("eass.mas.DefaultEASSEnvironment", agName + " done " + printAction(act));
	   }
	   return u;
	  }	  		
}
