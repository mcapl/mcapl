package goal.programming_guide;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.util.test.TestJPF;

public class Chapter1Tests extends TestJPF {
	 static final String[] JPF_ARGS = {  "-show" };

	 @Test //----------------------------------------------------------------------
	  public void ex1 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/goal/programming_guide/chapter1/hello_world.ail";
	    	String prop_filename =  "/src/examples/goal/programming_guide/chapter1/simple.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "1";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }
	 
	 @Test //----------------------------------------------------------------------
	  public void ex2 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/goal/programming_guide/chapter1/hello_world10.ail";
	    	String prop_filename =  "/src/examples/goal/programming_guide/chapter1/simple.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "2";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }

	 @Test //----------------------------------------------------------------------
	  public void ex3 () {
	    if (verifyNoPropertyViolation(JPF_ARGS)){
	    	String filename =  "/src/examples/goal/programming_guide/chapter1/hello_worldwEnvironment.ail";
	    	String prop_filename =  "/src/examples/goal/programming_guide/chapter1/simple.psl";
	    	String[] args = new String[3];
	    	args[0] = filename;
	    	args[1] = prop_filename;
	    	args[2] = "2";
	    	AJPF_w_AIL.run(args);
	 	 }
	  }

}
