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

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.HashMap;

import gov.nasa.jpf.vm.Verify;

/**
 * A Logger class that can be used from a class that may be run within JPF.
 * @author louiseadennis
 *
 */
public final class AJPFLogger {
	  //--- those need to be kept in sync with the model side
	  public static final int SEVERE = 1;
	  public static final int WARNING = 2;
	  public static final int INFO = 3;
	  public static final int FINE = 4;
	  public static final int FINER = 5;
	  public static final int FINEST = 6;

	  static HashMap<String, Level> levels = new HashMap<String, Level>();
	  
	  /**
	   * The log level for this class is less than or equal to FINEST.  Useful for
	   * efficiency in order not to create logging strings unless they are to be used.
	   * @param logname
	   * @return
	   */
	  public static boolean ltFinest(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.FINEST.intValue();
			} else {
				return getIntLevel(logname) <= Level.FINEST.intValue();
			}
	  }

	  /**
	   * The log level for this class is less than or equal to FINER.  Useful for
	   * efficiency in order not to create logging strings unless they are to be used.
	   * @param logname
	   * @return
	   */
	  public static boolean ltFiner(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.FINER.intValue();
			} else {
				return getIntLevel(logname) <= Level.FINER.intValue();
			}
	  }
	
	  /**
	   * The log level for this class is less than or equal to FINE.  Useful for
	   * efficiency in order not to create logging strings unless they are to be used.
	   * @param logname
	   * @return
	   */
	  public static boolean ltFine(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.FINE.intValue();
			} else {
				return getIntLevel(logname) <= Level.FINE.intValue();			
			}
	  }

	  /**
	   * The log level for this class is less than or equal to INFO.  Useful for
	   * efficiency in order not to create logging strings unless they are to be used.
	   * @param logname
	   * @return
	   */
	  public static boolean ltInfo(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.INFO.intValue();
			} else {
				return getIntLevel(logname) <= Level.INFO.intValue();			
			}
	  }

	  //================================
	  /**
	   * added by Maryam
	   * set a log file handler
	   * 
	   */
	  public static void setFileHandler(String logname, FileHandler fh){
		  Logger logger = Logger.getLogger(logname);
		  logger.addHandler(fh);
		  logger.setUseParentHandlers(false);
	      fh.setFormatter(new BriefLogFormatter());  
	  }
	  //================================
	  
	  
	  /**
	   * Set the logging report format to Brief.
	   */
	  public static void setHandlerFormatBrief() {
		for (Handler h: Logger.getLogger("").getHandlers()){
				h.setFormatter(new BriefLogFormatter());
		}
	  }
	  	
	  /**
	   * Set the logging report format to look like regular program output.
	   */
	  public static void setHandlerFormatAsOutput() {
		for (Handler h: Logger.getLogger("").getHandlers()){
				h.setFormatter(new AsOutputLogFormatter());
		}
	  }
	  	

	  /**
	   * Get the level of this logging class.
	   * @param logname
	   * @return
	   */
	  public static Level getLevel(String logname) {
		if (!Verify.isRunningInJPF()) {
			Logger logger = Logger.getLogger(logname);
			if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
				setLevel(logname, levels.get(logname));
			}

			Level l = logger.getLevel();
			while (l == null && logger.getParent() != null) {
				logger = logger.getParent();
		        l = logger.getLevel();
			}
			return l;
		} else {
			int l = getIntLevel(logname);
			switch (l) {
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
					return Level.INFO;
			}
			}
	  }
	
	  /**
	   * This method exists to be intercepted by the native peer when running in JPF and should
	   * only be called when the class is running in JPF.  Therefore the actual code is irrelevant.
	   * @param logname
	   * @return
	   */
	  private static int getIntLevel(String logname) {
		  return INFO;
	  }
	
	  /**
	   * Set the log level for a particular log.
	   * @param logname
	   * @param l
	   */
	  public static void setLevel(String logname, Level l) {
		  if (!Verify.isRunningInJPF()) {
			  Logger logger = Logger.getLogger(logname);
			  logger.setLevel(l);
			  for (Handler h: Logger.getLogger("").getHandlers()) {
				  if (h.getLevel().intValue() > l.intValue()) {
					  h.setLevel(l);
				  }
			  }
			  levels.put(logname, l);
		  } else {
			  setIntLevel(logname, l.intValue());
		  }
	  }
	
	  /**
	   * This method is only called when the class is running in JPF and is intercepted by
	   * the native peer when it is called.
	   * @param logname
	   * @param l
	   */
	  public static void setIntLevel(String logname, int l) {};
	
	  /**
	   * Return this message if the log level is INFO or lower.
	   * @param logname
	   * @param msg
	   */
	  public static void info(String logname, String msg) {
		  Logger logger = Logger.getLogger(logname);
		  if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			  System.err.println(levels);
			  setLevel(logname, levels.get(logname));
			  System.err.println(levels);
		  }

		  logger.info(msg);
	  }

	  /**
	   * Return this message if the log level is SEVERE or lower.
	   * @param logname
	   * @param msg
	   */
	  public static void severe(String logname, String msg) {
		  Logger logger = Logger.getLogger(logname);
		  if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			  setLevel(logname, levels.get(logname));
		  }
		  logger.severe(msg);
	  }

	  /**
	   * Return this message if the log level is WARNING or lower.
	   * @param logname
	   * @param msg
	   */
	  public static void warning(String logname, String msg) {
		  Logger logger = Logger.getLogger(logname);
		  if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			  setLevel(logname, levels.get(logname));
		  }
		  logger.warning(msg);
	  }

	  /**
	   * Return this message if the log level is FINE or lower.
	   * @param logname
	   * @param msg
	   */
	  public static void fine(String logname, String msg) {
		  Logger logger = Logger.getLogger(logname);
		  if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			  setLevel(logname, levels.get(logname));
		  }
		  logger.fine(msg);
	  }

	  /**
	   * Return this message if the log level is FINER or lower.
	   * @param logname
	   * @param msg
	   */
	  public static void finer(String logname, String msg) {
		  Logger logger = Logger.getLogger(logname);
		  if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			  setLevel(logname, levels.get(logname));
		  }
		  logger.finer(msg);
	  }

	  /**
	   * Return this message if the log level is FINEST or lower.
	   * @param logname
	   * @param msg
	   */
	  public static void finest(String logname, String msg) {
		  Logger logger = Logger.getLogger(logname);
		  if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			  setLevel(logname, levels.get(logname));
		  }
		  logger.finer(msg);
	  }
}