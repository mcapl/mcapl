
package monitor;

import org.jpl7.Query;

public class Monitor {

  public Monitor(String texpFileName){
    JPLUtils.init(texpFileName);
  }

  public void initialize(String logFile, String protocolName){
    if(logFile == null || protocolName == null){
      throw new IllegalArgumentException("logFile and protocolName must not be null");
    }
    try{
      JPLUtils.createAndCheck("initialize('" + logFile + "', " + protocolName + ")");
    } catch(PrologException e){
      throw new IllegalArgumentException("Initialization failed. The logfile or the protocol name are not valid");
    }
  }

  public boolean check(String event){
	  System.err.println("entering check with " + event);
    Query query = new Query("type_check_aux(" + event + ")");
    	System.err.println("formed query");
    boolean res = query.hasSolution();
    	System.err.println("query has solution");
    query.close();
    	System.err.println("leaving check");
    return res;
  }

}
