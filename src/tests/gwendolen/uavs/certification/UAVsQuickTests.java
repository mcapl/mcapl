package gwendolen.uavs.certification;


import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import ail.util.AJPF_w_AIL;

public class UAVsQuickTests extends TestJPF {
	 static final String[] JPF_ARGS = { "suppress_version = true" };
	


	  @Test //----------------------------------------------------------------------
	  public void certification_ajpf_lineup () {
	   if (verifyNoPropertyViolation(JPF_ARGS)) {
	    	String filename =  "/src/examples/gwendolen/uavs/certification/uav1.ail";
	    	String prop_filename =  "/src/examples/gwendolen/uavs/certification/certification.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "3";
	    	AJPF_w_AIL.run(args);
	   }
	 	// }
	  }



}
