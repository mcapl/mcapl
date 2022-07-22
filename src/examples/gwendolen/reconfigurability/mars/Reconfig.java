package gwendolen.reconfigurability.mars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import ail.mas.DefaultEnvironment;
import ail.syntax.Action;
import ail.syntax.Literal;
import ail.syntax.Predicate;
import ail.syntax.StringTermImpl;
import ail.syntax.Unifier;
import ail.util.AILexception;


public class Reconfig extends DefaultEnvironment{
	static final String logname = "gwendolen.reconfigurability.mars.Reconfig";
	
	private String at = "waypoint1";
	private boolean failure = true;
	private Predicate action_res = new Predicate("action_result");
	
	// reconfigurability input file paths
	// empty precondition or postcondition in capabilities have to be specified without any spaces, as {}
	private String capabilities = "./src/examples/gwendolen/reconfigurability/mars/capabilities.txt";
	// initial states, separate each state with empty space (eg. "at(waypoint1) obstacle(waypoint2)"; )
	private String initialState = "at(waypoint1)";
	// goal states, separate each state with empty space
	private String goals = "at(waypoint5)";
	
	public Reconfig() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see ail.mas.DefaultEnvironment#executeAction(java.lang.String, ail.syntax.Action)
	 */
	public Unifier executeAction(String agName, Action act) throws AILexception {
		String actionname = act.getFunctor();
		Literal waypoint = new Literal("at");
		boolean action_result = true;
		if (actionname.equals("moveW1W2")) {
			if (at.equals("waypoint1")) {
				if (!failure) {	
					at = "waypoint2";
					System.out.println("Rover has moved to "+at);
					waypoint.addTerm(new StringTermImpl(at));
					addPercept(waypoint);
				} else {
					System.out.println("Failure detected, starting reconfigurability.");
					action_result = false;
					reconfig(actionname);
				}
			} else {
				System.out.println("Precondition violated.");
			}
		} else if (actionname.equals("moveW2W1")) {
			if (at.equals("waypoint2")) {
				at = "waypoint1";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		} else if (actionname.equals("moveW1W3")) {
			if (at.equals("waypoint1")) {
				at = "waypoint3";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		} else if (actionname.equals("moveW3W1")) {
			if (at.equals("waypoint3")) {
				at = "waypoint1";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		} else if (actionname.equals("moveW3W2")) {
			if (at.equals("waypoint3")) {
				at = "waypoint2";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		} else if (actionname.equals("moveW2W3")) {
			if (at.equals("waypoint2")) {
				at = "waypoint3";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		} else if (actionname.equals("moveW1W4")) {
			if (at.equals("waypoint1")) {
				at = "waypoint4";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		}  else if (actionname.equals("moveW4W1")) {
			if (at.equals("waypoint4")) {
				at = "waypoint1";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		}  else if (actionname.equals("moveW2W5")) {
			if (at.equals("waypoint2")) {
				at = "waypoint5";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		}  else if (actionname.equals("moveW5W2")) {
			if (at.equals("waypoint5")) {
				at = "waypoint2";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		}  else if (actionname.equals("moveW5W4")) {
			if (at.equals("waypoint5")) {
				at = "waypoint4";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		}  else if (actionname.equals("moveW4W5")) {
			if (at.equals("waypoint4")) {
				at = "waypoint5";
				System.out.println("Rover has moved to "+at);
				waypoint.addTerm(new StringTermImpl(at));
				addPercept(waypoint);
			} else {
				System.out.println("Precondition violated.");
			}
		}  else if (actionname.equals("collect_soil")) {
			System.out.println("Rover has collected soil from "+at);
		}  else if (actionname.equals("collect_rock")) {
			System.out.println("Rover has collected rock from "+at);
		}
	
//		} else if (actionname.equals("inspect")) {
//		try {
//			Thread.sleep(3000);
//			receive_inspect();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		} else if (actionname.equals("wait")) {
//			NumberTerm period = (NumberTerm) act.getTerm(0);
//		try {
//			Thread.sleep((int) period.solve());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
		if (!actionname.equals("print")) {
			removePercept(action_res);
			action_res = new Predicate("action_result");
			action_res.addTerm(new StringTermImpl(""+action_result));
			addPercept(action_res);
		}
		
		return super.executeAction(agName, act);
	}
	
	public void reconfig(String failedAction) {
		createDomain(failedAction);
		createProblem();
		
		LinkedList<String> plan = null;
		
		try {
			plan = callPlanner();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        for (int i = 0; i < plan.size(); i++) {
            System.out.println(i +" = "+plan.get(i));
        }
	}
	
	
	private void createProblem() {
		File problemFile = new File("./src/examples/gwendolen/reconfigurability/mars/problem.pddl");
		try {
			problemFile.createNewFile();
			FileWriter problemFileWriter = new FileWriter(problemFile);
			String preamble = "(define (problem prob)\n"
	    					+ "\t(:domain reconfig)\n";
	    	problemFileWriter.write(preamble);
	    	
	    	problemFileWriter.write("\t(:objects");
	    	String[] objects = extractObjects();
	    	for (String object : objects) {
	    		problemFileWriter.write(" " + object);
	    	}
	    	problemFileWriter.write(")\n\n");
	    	
	    	problemFileWriter.write("\t(:init\n");
	    	String[] states = initialState.split("\\s+");
	    	for (String state : states) {
	    		String parameters = StringUtils.substringBetween(state, "(", ")");
	    		String predicate = StringUtils.substringBefore(state, "(");
	    		if (parameters == null) { 
	    			problemFileWriter.write("\t\t(" + predicate + ")\n"); 
	    		}
	    		else {
					if (parameters.contains(",")) {
						parameters = parameters.replace(",", " ");
					}
	    			problemFileWriter.write("\t\t(" + predicate + " " + parameters + ")\n");
	    		}
	    	}
	    	problemFileWriter.write(")\n\n");
	    	
	    	problemFileWriter.write("\t(:goal (and\n");
	    	states = goals.split("\\s+");
	    	for (String state : states) {
	    		String parameters = StringUtils.substringBetween(state, "(", ")");
	    		String predicate = StringUtils.substringBefore(state, "(");
	    		if (parameters == null) { 
	    			problemFileWriter.write("\t\t(" + predicate + ")\n"); 
	    		}
	    		else {
					if (parameters.contains(",")) {
						parameters = parameters.replace(",", " ");
					}
	    			problemFileWriter.write("\t\t(" + predicate + " " + parameters + ")\n");
	    		}
	    	}
	    	problemFileWriter.write("\t))\n\n");
	    	
	    	problemFileWriter.write(")");
	    	
	    	problemFileWriter.flush();
	    	problemFileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 
	private String[] extractObjects() {
		List<String> list = new ArrayList<String>();
		String[] init = initialState.split("\\s+");
		String[] gl = goals.split("\\s+");
		String[] states = ArrayUtils.addAll(init, gl);
		for (String state : states) {
			String object = StringUtils.substringBetween(state, "(", ")");
			if (!list.toString().contains(object) && object != null) {
				if (object.contains(",")) {
					object = object.replace(",", " ");
				}
				list.add(object);
			}
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(capabilities))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	String[] action = line.split("\\s+");
		    	if (!action[0].equals("{}")) {
		    		String[] precs = StringUtils.substringBetween(action[0], "{", "}").split(",");
		    		for (String prec : precs) {
			    			String parameters = StringUtils.substringBetween(prec, "(", ")");
			    			if (!list.toString().contains(parameters) && parameters != null) {
			    				if (parameters.contains(",")) {
			    					parameters = parameters.replace(",", " ");
			    				}
			    				list.add(parameters);
			    			}
		    		}
	    		}
		    	if (!action[2].equals("{}")) {
		    		String[] posts = StringUtils.substringBetween(action[2], "{", "}").replace("-", "").replace("+", "").split(",");
		    		for (String post : posts) {
		    			String parameters = StringUtils.substringBetween(post, "(", ")");
		    			if (!list.toString().contains(parameters) && parameters != null) {
		    				if (parameters.contains(",")) {
		    					parameters = parameters.replace(",", " ");
		    				}
		    				list.add(parameters);
		    			}
		    		}
		    	}
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] simpleArray = new String[ list.size() ];
		return list.toArray(simpleArray);
	}

	private void createDomain(String failedAction) {
		File domainFile = new File("./src/examples/gwendolen/reconfigurability/mars/domain.pddl");
	
		try {
			domainFile.createNewFile();
			FileWriter domainFileWriter = new FileWriter(domainFile);
			String preamble = "(define (domain reconfig)\n"
	    					+ "\t(:requirements :strips)\n";
			domainFileWriter.write(preamble);
			
			domainFileWriter.write("\t(:predicates ");
	    	String[] predicates = extractPredicates();
	    	for (String predicate : predicates) {
	    		domainFileWriter.write("(" + predicate + ") ");
	    	}
	    	domainFileWriter.write(")\n\n");
	    	
			try(BufferedReader br = new BufferedReader(new FileReader(capabilities))) {
			    for(String line; (line = br.readLine()) != null; ) {
//			        
			    	String[] action = line.split("\\s+");
			    	if (!action[1].equals(failedAction)) {
				    	domainFileWriter.write("\t(:action " + action[1] + "\n");
	//			    	
	//			    	domainFileWriter.write("\t\t:parameters(");
	//			    	domainFileWriter.write(")\n");
	//			    	
				    	domainFileWriter.write("\t\t:precondition(and ");
				    	if (!action[0].equals("{}")) {
				    		String[] precs = StringUtils.substringBetween(action[0], "{", "}").split(",");
				    		for (String prec : precs) {
				    			String predicate = StringUtils.substringBefore(prec, "(");
				    			String parameters = StringUtils.substringBetween(prec, "(", ")");
					    		if (parameters == null) { 
					    			domainFileWriter.write("(" + predicate + ") "); 
					    		}
					    		else {
									if (parameters.contains(",")) {
										parameters = parameters.replace(",", " ");
									}
									domainFileWriter.write("(" + predicate + " " + parameters + ") ");
					    		}
				    			
				    		}
				    	}
	//			    	String[] states = line.split(",");
	//			    	if (!states[0].equals("{}")) {
	//			    		domainFileWriter.write(states[0]);
	//			    	}
				    	domainFileWriter.write(")\n");
	
				    	domainFileWriter.write("\t\t:effect(and ");
				    	if (!action[2].equals("{}")) {
				    		String[] posts = StringUtils.substringBetween(action[2], "{", "}").split(",");
				    		for (String post : posts) {
				    			String predicate = StringUtils.substringBefore(post, "(");
				    			String parameters = StringUtils.substringBetween(post, "(", ")");
					    		if (parameters == null) { 
					    			if (predicate.charAt(0) == '-') {
					    				predicate = predicate.replace("-", "");
					    				domainFileWriter.write("(not (" + predicate + ")) "); 
					    			}
					    			else {
					    				predicate = predicate.replace("+", "");
					    				domainFileWriter.write("(" + predicate + ") "); 
					    			}
					    		}
					    		else {
									if (parameters.contains(",")) {
										parameters = parameters.replace(",", " ");
									}
					    			if (predicate.charAt(0) == '-') {
					    				predicate = predicate.replace("-", "");
					    				domainFileWriter.write("(not (" + predicate + " " + parameters + ")) "); 
					    			}
					    			else {
					    				predicate = predicate.replace("+", "");
					    				domainFileWriter.write("(" + predicate + " " + parameters + ") ");
					    			}
	//								domainFileWriter.write("(" + predicate + " " + parameters + ")\n");
					    		}
				    			
				    		}
				    	}
				    	domainFileWriter.write(")\n");
				    	
				    	domainFileWriter.write("\t)\n\n");
				    }
			    }
			}
			
			
			domainFileWriter.write(")");
			
			domainFileWriter.flush();
			domainFileWriter.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String[] extractPredicates() {
		List<String> list = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(capabilities))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	String[] action = line.split("\\s+");
		    	if (!action[0].equals("{}")) {
		    		String[] precs = StringUtils.substringBetween(action[0], "{", "}").split(",");
		    		for (String prec : precs) {
			    		String predicate = StringUtils.substringBefore(prec, "(");
			    		if (!list.toString().contains(predicate)) {
			    			String parameters = StringUtils.substringBetween(prec, "(", ")");
			    			String[] paramsSize = parameters.split(",");
			    			String predicateFull = predicate + " ";
			    			for (int i = 0; i < paramsSize.length; i++) {
			    				predicateFull = predicateFull + "?param" + i;
			    			}
			    			list.add(predicateFull);
			    		}
		    		}
	    		}
		    	if (!action[2].equals("{}")) {
		    		String[] posts = StringUtils.substringBetween(action[2], "{", "}").replace("-", "").replace("+", "").split(",");
		    		for (String post : posts) {
			    		String predicate = StringUtils.substringBefore(post, "(");
			    		if (!list.toString().contains(predicate)) {
			    			String parameters = StringUtils.substringBetween(post, "(", ")");
			    			String[] paramsSize = parameters.split(",");
			    			String predicateFull = predicate + " ";
			    			for (int i = 0; i < paramsSize.length; i++) {
			    				predicateFull = predicateFull + "?param" + i;
			    			}
			    			list.add(predicateFull);
			    		}
		    		}
		    	}
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] simpleArray = new String[ list.size() ];
		return list.toArray(simpleArray);
	}
	
	private LinkedList<String> callPlanner() throws IOException, InterruptedException {
		ProcessBuilder pb = null;
		pb = new ProcessBuilder("./run.sh", "domain.pddl", "problem.pddl");
//		
		pb.directory(new File("./src/examples/gwendolen/reconfigurability/mars/"));
		Process p = pb.start();
		p.waitFor();
		
		Scanner s = new Scanner(p.getInputStream());
		
		LinkedList<String> plan = new LinkedList<String>();
////		synchronized (EISArtifact.class) {
//			FileWriter cachedPlan = new FileWriter("./planner/cache/");
//			
			while(s.hasNextLine()) {
				String line = s.nextLine();
//				cachedPlan.write(line + "\n");
				if(line.equals("NO PLAN")) {
					s.close();
//					cachedPlan.close();
					return null;
				}
				if (!line.contains("cost =")) {
					plan.add(line);
				}
				
			}
//			cachedPlan.close();
			s.close();
//		}
		
		return plan;
		
	}
	

	@Override
	public boolean done() {
		return true;
	}

}

	
