// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
// 
// This file is part of Agent JPF (AJPF)
//
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package ajpf;

import gov.nasa.jpf.PropertyListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.Types;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.Config;

import java.util.Set;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import ajpf.product.Product;
import ajpf.psl.ast.Property_AST;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.ast.Native_Proposition;
import ajpf.psl.Proposition;

/**
 * Special listener class for the MCAPL Project.
 * 
 * @author louiseadennis
 *
 */
public class MCAPLListener extends PropertyListenerAdapter {
	 protected static Logger log = JPF.getLogger("ajpf.MCAPLListener");
				
	/**
	 * The product automata associated with this  model checking run.
	 */
	protected Product product_automata;
		
	/**
	 * Used for a bit of control.  Flag showing whether initialisation of the product automata has yet occured.
	 */
	public boolean automata_initialised = false;
	
	/**
	 * The reference to the object containing the specificiation in the JVM.
	 */
	public int specRef;
	
	/**
	 * Storing some method infos for rapid checking.
	 */
	MethodInfo miCreateAutomaton;
	
	/** 
	 * Type of product automata used by this listener;
	 */
//	Product.AutomataType automata_type = Product.AutomataType.DEFAULT_AUTOMATA;
	
	/**
	 * Are we only interested in generating a model of the program itself in this run?
	 */
	boolean model_only = false;
		
	/*
	 * (non-Javadoc)
	 * @see gov.nasa.jpf.PropertyListenerAdapter#classLoaded(gov.nasa.jpf.jvm.JVM)
	 */
	public void classLoaded (VM vm, ClassInfo ci){
		// We particularly want to intercept the createAutomaton method so we save the method
		// info for quick look up later.
		if (ci.getName().equals("ajpf.MCAPLSpec")){
			miCreateAutomaton = ci.getMethod("createAutomaton()V", false);
			assert miCreateAutomaton != null;
		}
	}

     
	/*
	 * (non-Javadoc)
	 * @see gov.nasa.jpf.PropertyListenerAdapter#methodEntered(gov.nasa.jpf.jvm.JVM)
	 */
   public void methodEntered(VM vm, ThreadInfo ti, MethodInfo mi) {
		
		// We intercept the create automaton method in the JVM - we're going to do all the automaton 
		// creating stuff natively.
       	if (mi == miCreateAutomaton) {
      		log.fine("creating automaton");
      		Config config = vm.getConfig();
       		if (config.containsKey("ajpf.model_only")) {
       			if (config.getProperty("ajpf.model_only").equals("true")) {
       				model_only = true;
       			}
       		}
       		
      		
      		// Get a reference for the specification (the class that callde createAutomaton) held in the JVM
           	int objref = ti.getThis();
       		specRef = objref;
       		ElementInfo ei = vm.getElementInfo(specRef);
       		
       		// Get the string representing the property, parse it and set up sets of atomic propositions it contains
       		String propertystring = ei.getStringField("propertystring");
     		Property_AST prop_ast = new Property_AST();
    		prop_ast.parse(propertystring);
    		MCAPLProperty prop = prop_ast.toMCAPLNative();
    		Set<Proposition> props = prop.getProps();
    		
    		// Mirror the set of atomic propositions mentioned in the property up in the JVM version of
    		// the specification.
       		int index = 0;
    		Heap heap = vm.getHeap();
    	    String elementClsName = Types.getTypeSignature("ajpf.psl.MCAPLProperty", false);
    	    ElementInfo array_ei = heap.newArray(elementClsName, props.size(), ti);
    	    int arrayRef = array_ei.getObjectRef();
    		ei.setReferenceField("propArray", arrayRef);
     		for (Proposition p: props) {
    			if (p instanceof Native_Proposition) {
    				Native_Proposition p1 = (Native_Proposition) p;
    				int propRef = p1.createInJPF(vm);
    				array_ei.setReferenceElement(index, propRef);
    				index++;
    			}
    		}
    		
    		// Negate the property and initialise the product automataon
     		product_automata = new Product(prop.negate(), props, getAutomataType(), model_only);
    		automata_initialised = true;
       	} 
	}
 
   /*
    * (non-Javadoc)
    * @see gov.nasa.jpf.PropertyListenerAdapter#check(gov.nasa.jpf.search.Search, gov.nasa.jpf.jvm.JVM)
    */
	 public boolean check (Search search, VM vm) {
			 log.finer("checking " + search.getStateId());
			 log.finer(" is ignored " + search.isIgnoredState());
			 log.finer(" transition occured " + vm.transitionOccurred());
			 
			 if (search.getStateId() == -1) {
				 // If we've backtracked right past the beginning and, no, I'm not really clear what's going on
				 // internally in AJPF here.  Anyway we're done and we need to fully run the DFS and check for accepting paths.
				 product_automata.done(0);
				 return product_automata.DFS().isEmpty();
			 } else {
				 // This node in the model is fully explored, note as such in the program model
				 if (search.isDone()) {
					 product_automata.done(search.getStateId());
				 }
				 
				 // If a transition has occurred then we have a new edge in our model and the product automata needs to be updated.
				 if (vm.transitionOccurred()) {
					 // Check state returns true if an acccepting path hasn't been found in the product
					 return checkstate(search);
				 }

				 return true;
			 }
	 }
	 
	 /**
	  * Helper method for check.  Advancing of the automata happens here _not_ in state advanced because this is called first.
	  * @param search
	  * @return
	  */
	 private boolean checkstate (Search search) {
		 int newstate = search.getStateId();
		 
		 // Add this new state to the program model inside the product automaton.
		 if (automata_initialised) {
			 // If this is an end state in the program model check for accepting paths.  
			 // Don't generate a new product state because of trivial truths but do add the state to the program model
			 // so pruning will work properly when backtracking occurs.
			 if (search.isEndState()) {
				 log.fine("is end");
				 // Adding new state for pruning
				 boolean returnvalue = product_automata.currentPathEnded();
				 product_automata.justAddModelState(newstate);
				 return (! returnvalue);
			 }

			 // Otherwise we add a new model state to the product and check if we're in a state
			 // were there is state in the property that can be paired with this state in the model
			 // so all paths from this model node are trivially true.
			 if (!product_automata.addModelState(newstate)) {
			 
				 // Internal JPF stuff to force backtracking at this point since we're no longer interested in 
				 // exploring further.
				 log.fine("Setting Ignored");
				 search.getVM().getSystemState().setIgnored(true);
				 return true;
			 }


			 // If we've looped it wasn't an end state but we want to look for accepting runs anyway.
			 // If a loop was detected when we added the new state then these will have been generated.
			 return (! product_automata.hasAcceptingPath());
		 }
		 
		 return true;
	 }
	 
	 /*
	  * (non-Javadoc)
	  * @see gov.nasa.jpf.PropertyListenerAdapter#searchConstraintHit(gov.nasa.jpf.search.Search)
	  */
	 public void searchConstraintHit(Search search) {
		 log.warning("WARNING: search constraint encountered, eventualities not checked");
		 log.info("constraint: " + search.getSearchConstraint());
	 }
	 
	 /*
	  * (non-Javadoc)
	  * @see gov.nasa.jpf.PropertyListenerAdapter#stateBacktracked(gov.nasa.jpf.search.Search)
	  */
	 public void stateBacktracked(Search search) {
		 int id = search.getStateId();
		 if (search.isDone()) {
			 product_automata.done(search.getStateId());
		 }
		 log.fine("backtracking to " + id);

		 // Since we're maintaining the "current path" in the model and the product automata this need to be pruned accordingly.
		 if (product_automata != null) {
			 product_automata.pruneCurrentPath(id);
		 }

		 // Check in case we've pruned back beyond the creation of the automata
		 if (id < 0) {
	 		 automata_initialised = false;
	 	 }
	  }
	 	
	 /*
	  * (non-Javadoc)
	  * @see gov.nasa.jpf.PropertyListenerAdapter#stateProcessed(gov.nasa.jpf.search.Search)
	  */
	 public void stateProcessed(Search search) {
		 if (search.getStateId() > 0) {
			 product_automata.done(search.getStateId());
		 }
	 }

	 /**
	  * Reporting of the nature of the error by JPF.
	  */
	 public String getErrorMessage() {
		 String s = "An Accepting Path has been found: " + product_automata.getAcceptingPath();
		 return s;
	 }
	 
	 /**
	  * What sort of automata are we using?
	  * @return
	  */
	 public Product.AutomataType getAutomataType() {
		 return Product.AutomataType.DEFAULT_AUTOMATA;
	 }

	 /*
	  * (non-Javadoc)
	  * @see gov.nasa.jpf.PropertyListenerAdapter#searchFinished(gov.nasa.jpf.search.Search)
	  */
	 public void searchFinished(Search search) {
		 log.info("Number of States in Product Automata: " + product_automata.size());

		 Config config = search.getVM().getConfig();
		 product_automata.setConfig(config);

		 // Are we generating a model in some particular format 
		 if (config.containsKey("ajpf.model.location")) {

			 if (config.getProperty("ajpf.model.location").equals("stdout")) {
				 System.out.println(product_automata.getModel().toString());
			 } else {
				 // If we're outputting to a file.
				 try {
					 String file_path = ".";
					 if (config.containsKey("ajpf.model.path")) {
						 file_path = config.getProperty("ajpf.model.path");
					 }
					 File file = new File(file_path + "/" + config.getProperty("ajpf.model.location"));
					 if (!file.exists()) {
						 file.createNewFile();
					 }
					 
					 FileWriter fstream = new FileWriter(file.getAbsoluteFile());
					 BufferedWriter out = new BufferedWriter(fstream);
					 out.write(product_automata.getModel().toString());
					 out.close();
					 log.info("Model written to: " +file_path);
					 
					 // Whole load of specialised stuff to read the file into spin and then run it.
					 if (config.containsKey("ajpf.run_modelchecker") && (config.getProperty("ajpf.run_modelchecker").equals("true"))) {
						 if (config.getProperty("ajpf.target_modelchecker").equals("spin")) {
							 try {
								 String property_file = "prop.txt";
								 if (config.containsKey("ajpf.spin.property_file")) {
									 property_file = config.getProperty("ajpf.spin.property_file");
								 }
								 String spin_path = "";
								 if (config.containsKey("ajpf.spin.path")) {
									 spin_path = config.getProperty("ajpf.spin.path") + "/";
								 }

								 String command = "sh ./tools/spin.sh " + spin_path + " " + file_path + " " + file.getName() + " " + property_file;
								 log.finer(command);
								 Process spin = Runtime.getRuntime().exec(command);

								 InputStream cmdStdOut = spin.getInputStream();
								 InputStream cmdErr = spin.getErrorStream();
								 
								 BufferedReader stdOut = new BufferedReader(new InputStreamReader(cmdStdOut));
								 String line;
								 while ((line = stdOut.readLine()) != null) {
									 System.out.println(line);
								 }
								 cmdStdOut.close();
								 
								 BufferedReader error = new BufferedReader(new InputStreamReader(cmdErr));
								 while ((line = error.readLine()) != null) {
									 log.warning(line);
								 }
								 cmdErr.close();
							 } catch  (Exception e){
								 log.severe("Model Checking Failure: " + e.getMessage());
							 }
						 }
					 } 
					 		
				 } catch (Exception e) {
					 log.severe("File Writing Error: " + e.getMessage());
				 }
			 }
		 }
	 }
}
