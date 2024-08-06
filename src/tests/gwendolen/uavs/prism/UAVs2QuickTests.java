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

public class UAVs2QuickTests extends TestJPF {
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

	//@Rule
	//public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	/* @Test
	public void really_simple_uav_ail() {
		  try {
			  String config_filename = MCAPLcontroller.getFilename("/src/examples/gwendolen/uavs/prism/really_simple_uav.ail");
			  ail.mas.AIL.runAIL(config_filename);
		  } catch (Exception e) {
			  System.err.println(e);
			  Assert.assertTrue(false);
		  }

	}
	
	@Test
	public void simple_uav_ail() {
		  try {
			  String config_filename = MCAPLcontroller.getFilename("/src/examples/gwendolen/uavs/prism/simple_uav.ail");
			  ail.mas.AIL.runAIL(config_filename);
		  } catch (Exception e) {
			  System.err.println(e);
			  Assert.assertTrue(false);
		  }

	}
	
	  @Test //----------------------------------------------------------------------
	  public void prism_output () {
	   // if (verifyNoPropertyViolation(JPF_SPIN_ARGS)) {
	    	String jpf_config = "src/examples/gwendolen/uavs/prism/really_simple_uav_modelonly.jpf";
	    	
	    	Config conf = JPF.createConfig(JPF_ARGS);
	    	FileInputStream is = null;
	    	try {
	    		File f = new File(jpf_config);
	    		if (f.isFile()) {
	    			is = new FileInputStream(f);
	    			conf.load(is);
	    		}
	    	JPF jpf = new JPF(conf);
	    	jpf.run();
	    	
	    	String example_path = conf.getProperty("mcapl") + "/src/examples/gwendolen/uavs/prism/";
	    	String example_filename = example_path + "prism_example.pm";
	    	String test_filename = example_path + "prism.pm";
	    	
	    	File example_file = new File(example_filename);
	    	File test_file = new File(test_filename);
	    	
	    	Path epath = example_file.toPath();
	    	Path tpath = test_file.toPath();
	    	
	    	Assert.assertTrue(sameContent(epath, tpath));
	    	} catch (Exception e) {
	    		Assert.assertFalse(true);
	    	}

	 	// }
	  } */
	  
	  @Test //----------------------------------------------------------------------
	  public void really_simple_ajpf () {
	   if (verifyNoPropertyViolation(JPF_ARGS)) {
	    	String filename =  "/src/examples/gwendolen/uavs/prism/really_simple_uav.ail";
	    	String prop_filename =  "/src/examples/gwendolen/uavs/prism/simple_uav.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "1";
	    	AJPF_w_AIL.run(args);
	   }
	 	// }
	  }

	  /* @Test //----------------------------------------------------------------------
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
	  boolean sameContent(Path file1, Path file2) throws IOException {
		    try (InputStream is1 = Files.newInputStream(file1);
		         InputStream is2 = Files.newInputStream(file2)) {
		        // Compare byte-by-byte.
		        // Note that this can be sped up drastically by reading large chunks
		        // (e.g. 16 KBs) but care must be taken as InputStream.read(byte[])
		        // does not neccessarily read a whole array!
		        int data;
		        while ((data = myread(is1)) != -1)
		            if (data != myread(is2))
		                return false;
		    }

		    return true;
		}

	  private int myread(InputStream is) throws IOException {
		  int c;
		  do {
			  c = is.read();
		  } while (c == '\n' || c == '\r');
		  return c;
	  } */



}
