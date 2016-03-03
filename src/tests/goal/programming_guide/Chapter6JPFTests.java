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

public class Chapter6JPFTests extends TestJPF {

	  static final String[] JPF_ARGS = {  "-show" };
	  
	  
	  @Test //----------------------------------------------------------------------
	  public void towerAgent () {
		  if (verifyNoPropertyViolation(JPF_ARGS)){
			  String filename =  "/src/examples/goal/programming_guide/chapter6/tower_agent_simple.ail";
			  String prop_filename =  "/src/examples/goal/programming_guide/chapter6/chapter6.psl";
			  String[] args = new String[3];
			  args[0] = filename;
			  args[1] = prop_filename;
			  args[2] = "1";
			  AJPF_w_AIL.run(args);
		  }
	  }
}
