package eass.verification.leo;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

public class NoThrustersTests extends TestJPF  {
	 static final String[] PICKUP_ARGS = { "-show", 
		 "+listener+=,.listener.ExecTracker",
	     "+et.print_insn=false"
	 };

	 //--- driver to execute single test methods
	  public static void main(String[] args) {
		  runTestsOfThisClass(args);
	  }

	  @Test //----------------------------------------------------------------------
	  public void testInValidUnderTwoEventualities() {
		  if (verifyPropertyViolation(new TypeRef("ajpf.MCAPLListener"), PICKUP_ARGS)) {
		    	String filename =  "/src/examples/eass/verification/leo/satellite_nothrusters.ail";
		    	String prop_filename =  "/src/examples/eass/verification/leo/satellite.psl";
		    	String[] args = new String[3];
		    	args[0] = filename;
		    	args[1] = prop_filename;
		    	args[2] = "15sanity";
		    	AJPF_w_AIL.run(args);
		  } else {
			    	 
		  }

	  }

}
