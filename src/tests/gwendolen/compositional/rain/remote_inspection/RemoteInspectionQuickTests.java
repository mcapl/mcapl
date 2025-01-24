package gwendolen.compositional.rain.remote_inspection;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.test.TestJPF;

public class RemoteInspectionQuickTests extends TestJPF {
	  static final String[] JPF_ARGS = {  "-show" 
	  };



	  //--- driver to execute single test methods
	  public static void main(String[] args) {
	    runTestsOfThisClass(args);
	  }

	  //--- test methods

	 
	  @Test //----------------------------------------------------------------------
	  public void quick_test () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/gwendolen/compositional/rain/remote_inspection/remote_inspection.ail";
	    	String prop_filename =  "/src/examples/gwendolen/compositional/rain/remote_inspection/remote_inspection.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "5";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	  
}
