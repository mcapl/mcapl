// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Agent JPF (AJPF)
// 
// AJPF is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// AJPF is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with AJPF; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ajpf.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.JPFException;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.NativePeer;
import gov.nasa.jpf.annotation.MJI;

public class JPF_ajpf_util_AJPFLogger extends NativePeer {
	  //--- those need to be kept in sync with the model side
	  public static final int SEVERE = 1;
	  public static final int WARNING = 2;
	  public static final int INFO = 3;
	  public static final int FINE = 4;
	  public static final int FINER = 5;
	  public static final int FINEST = 6;

	  private static void log (JPFLogger logger, int logLevel, String msg){
		    switch (logLevel){
		    case SEVERE:
		      logger.severe( msg);
		      break;
		    case WARNING:
		      logger.warning( msg);
		      break;
		    case INFO:
		      logger.info( msg);
		      break;
		    case FINE:
		      logger.fine( msg);
		      break;
		    case FINER:
		      logger.finer( msg);
		      break;
		    case FINEST:
		      logger.finest( msg);
		      break;
		    default:
		      throw new JPFException("unknown log level " + logLevel + " for logger " + logger.getName());
		    }    
		  }
	  
	  @MJI
		public static void setConsoleHandlerFormatBrief____V() {
			for (Handler h: Logger.getLogger("").getHandlers()){
				if (h instanceof ConsoleHandler) {
					h.setFormatter(new BriefLogFormatter());
				}
				
			}
		}
		
		public static Level levelfromInt(int i) {
		    switch (i){
		    case SEVERE:
		      return Level.SEVERE;
		    case WARNING:
		    	return Level.WARNING;
		    case INFO:
		    	return Level.INFO;
		    case FINE:
		    	return Level.FINE;
		    case FINER:
		    	return Level.FINER;
		    case FINEST:
		    	return Level.FINEST;
		    default:
		      throw new JPFException("unknown log level " + i);
		    }    
			
		}
		
		@MJI
		public static int getIntLevel__Ljava_lang_String_2__I(MJIEnv env, int clsObjRef, int loggerIdRef) {
				String logname = env.getStringObject(loggerIdRef);
				JPFLogger logger = JPF.getLogger(logname);
				Level l = logger.getLevel();
			    while (l == null && logger.getParent() != null) {
			        logger = (JPFLogger) logger.getParent();
			        l = logger.getLevel();
			    }
			    if (l == null) {
			    	return INFO;
			    }
				return l.intValue();
		}
		
		@MJI
	public static void setIntLevel__Ljava_lang_String_2I__V(MJIEnv env, int clsObjRef, int loggerIdRef, int logLevelRef) {
				String logname = env.getStringObject(loggerIdRef);
				JPFLogger logger = JPF.getLogger(logname);
				Level logLevel = levelfromInt(logLevelRef);
				logger.setLevel(logLevel);
				for (Handler h: Logger.getLogger("").getHandlers()) {
					if (h.getLevel().intValue() > logLevelRef) {
						h.setLevel(logLevel);
					}
				}
		}

		  @MJI
	  public static void info__Ljava_lang_String_2Ljava_lang_String_2__V (MJIEnv env, int clsObjRef, int loggerIdRef, int msgRef){
		    String loggerId = env.getStringObject(loggerIdRef);
		    String msg = env.getStringObject(msgRef);
		    JPFLogger logger = JPF.getLogger(loggerId);
		    
		    log( logger, INFO, msg);
		  }

	  @MJI
	  public static void fine__Ljava_lang_String_2Ljava_lang_String_2__V (MJIEnv env, int clsObjRef, int loggerIdRef, int msgRef){
		    String loggerId = env.getStringObject(loggerIdRef);
		    String msg = env.getStringObject(msgRef);
		    JPFLogger logger = JPF.getLogger(loggerId);
		    
		    log( logger, FINE, msg);
		  }
	  
	  @MJI
	  public static void finer__Ljava_lang_String_2Ljava_lang_String_2__V (MJIEnv env, int clsObjRef, int loggerIdRef, int msgRef){
		    String loggerId = env.getStringObject(loggerIdRef);
		    String msg = env.getStringObject(msgRef);
		    JPFLogger logger = JPF.getLogger(loggerId);
		    
		    log( logger, FINER, msg);
		  }
	  
	  @MJI
	  public static void finest__Ljava_lang_String_2Ljava_lang_String_2__V (MJIEnv env, int clsObjRef, int loggerIdRef, int msgRef){
		    String loggerId = env.getStringObject(loggerIdRef);
		    String msg = env.getStringObject(msgRef);
		    JPFLogger logger = JPF.getLogger(loggerId);
		    
		    log( logger, FINEST, msg);
		  }

	  @MJI
	  public static void warning__Ljava_lang_String_2Ljava_lang_String_2__V (MJIEnv env, int clsObjRef, int loggerIdRef, int msgRef){
		    String loggerId = env.getStringObject(loggerIdRef);
		    String msg = env.getStringObject(msgRef);
		    JPFLogger logger = JPF.getLogger(loggerId);
		    
		    log( logger, WARNING, msg);
}

	  @MJI
	  public static void severe__Ljava_lang_String_2Ljava_lang_String_2__V (MJIEnv env, int clsObjRef, int loggerIdRef, int msgRef){
			    String loggerId = env.getStringObject(loggerIdRef);
			    String msg = env.getStringObject(msgRef);
			    JPFLogger logger = JPF.getLogger(loggerId);
			    
			    log( logger, SEVERE, msg);
	  }


}
