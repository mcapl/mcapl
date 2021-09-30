package gwendolen.verifiableautonomoussystems.chapter9;


import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import ail.util.AJPF_w_AIL;

public class UAVCerficationTests extends TestJPF {
	 static final String[] JPF_ARGS = { "suppress_version = true" };
	
	  @Test //----------------------------------------------------------------------
	  public void certification_ajpf () {
	   if (verifyNoPropertyViolation(JPF_ARGS)) {
	    	String filename =  "/src/examples/gwendolen/verifiableautonomoussystems/chapter9/uav.ail";
	    	String prop_filename =  "/src/examples/gwendolen/verifiableautonomoussystems/chapter9/certification.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "1";
	    	AJPF_w_AIL.run(args);
	   }
	 	// }
	  }



}
