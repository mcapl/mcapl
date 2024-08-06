package gwendolen.uavs.prism;

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

public class UAVs3QuickTests extends TestJPF {
	 static final String[] JPF_ARGS = { "suppress_version = true" };
	
	// General framework for testing print statements.  Stolen from stackOverflow.
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private PrintStream systemStdErr = System.err;
	  
	public void setUpStreams() {
		System.setErr(new PrintStream(errContent));
	}

	public void cleanUpStreams() {
		System.setErr(systemStdErr);
	}

	  @Test //----------------------------------------------------------------------
	  public void simple_ajpf () {
	   if (verifyNoPropertyViolation(JPF_ARGS)) {
	    	String filename =  "/src/examples/gwendolen/uavs/prism/simple_uav.ail";
	    	String prop_filename =  "/src/examples/gwendolen/uavs/prism/simple_uav.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "2";
	    	AJPF_w_AIL.run(args);
	   }
	 	// }
	  }
	  

}
