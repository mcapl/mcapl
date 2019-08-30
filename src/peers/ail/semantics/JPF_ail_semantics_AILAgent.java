package ail.semantics;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

public class JPF_ail_semantics_AILAgent extends NativePeer {
	
	// We intercept events related to tracing when model checking because a) JPF can't handle them and
	// b) we don't need to use debugging support when model checking
	@MJI
	public static void initializeTracing__Ljava_lang_String_2__ (MJIEnv env, int objref, int traceRef) {
	}

}
