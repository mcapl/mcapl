package goal.programming_guide;

import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.Test;

import ail.mas.AIL;
import ail.mas.MAS;
import ail.util.AILConfig;
import ail.util.AJPF_w_AIL;
import ajpf.MCAPLcontroller;

public class Chapter6Tests {

	  // General framework for testing print statements.  Stolen from stackOverflow.
	  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	  private PrintStream systemStdErr = System.err;
	  static final String[] JPF_ARGS = {  "-show" };
	  
	  public void setUpStreams() {
	      System.setErr(new PrintStream(errContent));
	  }

	  public void cleanUpStreams() {
	      System.setErr(systemStdErr);
	  }

	  @Test //----------------------------------------------------------------------
	  public void errorfreeeisconnection () {
		  setUpStreams();
		AILConfig config = new AILConfig("src/examples/goal/programming_guide/chapter6/table6_1.ail");
		AIL.configureLogging(config);
	
		MCAPLcontroller mccontrol = new MCAPLcontroller();

		// Create the initial state of the multi-agent program.
		MAS mas = AIL.AILSetup(config, mccontrol);
		
		// Set up a controller
		mccontrol.setMAS(mas, "", config);
		
		// Begin!
		mccontrol.begin(); 
		mas.cleanup();
		String expectedOutput = "goal_agent attempting move(b4,b3)\ngoal_agent attempting move(b2,table)\ngoal_agent attempting move(b1,table)\ngoal_agent attempting move(b4,b3)\ngoal_agent attempting move(b2,table)\ngoal_agent attempting move(b4,b3)\ngoal_agent attempting move(b5,b2)\ngoal_agent attempting move(b1,b5)\ngoal_agent attempting move(b6,b4)\n";
		Assert.assertEquals(expectedOutput, errContent.toString());
		cleanUpStreams();
	  }

}
