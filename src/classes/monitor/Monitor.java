
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
    Query query = new Query("type_check_aux(" + event + ")");
    boolean res = query.hasSolution();
    query.close();
    return res;
  }

}
