package gwendolen.uavs.certification;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.test.TestJPF;
import gwendolen.GwendolenAgentBuilder;
import gwendolen.semantics.GwendolenAgent;
import junit.framework.Assert;
import ail.util.AJPF_w_AIL;
import ajpf.MCAPLcontroller;

public class UAVsQuickTests extends TestJPF {
	 static final String[] JPF_ARGS = { "suppress_version = true" };
	

	  @Test //----------------------------------------------------------------------
	  public void certification_ajpf_taxi () {
	   if (verifyNoPropertyViolation(JPF_ARGS)) {
	    	String filename =  "/src/examples/gwendolen/uavs/certification/uav1.ail";
	    	String prop_filename =  "/src/examples/gwendolen/uavs/certification/certification.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "2";
	    	AJPF_w_AIL.run(args);
	   }
	 	// }
	  }

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
