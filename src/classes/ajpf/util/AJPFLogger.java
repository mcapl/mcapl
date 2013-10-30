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

import java.util.logging.Handler;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.HashMap;

import gov.nasa.jpf.vm.Verify;
import gov.nasa.jpf.annotation.MJI;

public class AJPFLogger {
	  //--- those need to be kept in sync with the model side
	  public static final int SEVERE = 1;
	  public static final int WARNING = 2;
	  public static final int INFO = 3;
	  public static final int FINE = 4;
	  public static final int FINER = 5;
	  public static final int FINEST = 6;

	  static HashMap<String, Level> levels = new HashMap<String, Level>();
	  
	  public static boolean ltFiner(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.FINER.intValue();
			} else {
				return getIntLevel(logname) <= Level.FINER.intValue();
			}
	  }
	
	  public static boolean ltFine(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.FINE.intValue();
			} else {
				return getIntLevel(logname) <= Level.FINE.intValue();			}
	  }

	  public static boolean ltInfo(String logname) {
			if (!Verify.isRunningInJPF()) {
				return getLevel(logname).intValue() <= Level.INFO.intValue();
			} else {
				return getIntLevel(logname) <= Level.INFO.intValue();			}
	  }

	  public static void setConsoleHandlerFormatBrief() {
		for (Handler h: Logger.getLogger("").getHandlers()){
			if (h instanceof ConsoleHandler) {
				h.setFormatter(new BriefLogFormatter());
			}
			
		}
	}
	
	public static Level getLevel(String logname) {
		if (!Verify.isRunningInJPF()) {
			Logger logger = Logger.getLogger(logname);
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
	
	public static int getIntLevel(String logname) {
		return INFO;
	}
	
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
	
	public static void setIntLevel(String logname, int l) {};
	
	public static void info(String logname, String msg) {
			Logger logger = Logger.getLogger(logname);
			if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
				setLevel(logname, levels.get(logname));
			}

			logger.info(msg);
	}

	public static void severe(String logname, String msg) {
			Logger logger = Logger.getLogger(logname);
			if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
				setLevel(logname, levels.get(logname));
			}
			logger.severe(msg);
	}

	public static void warning(String logname, String msg) {
		Logger logger = Logger.getLogger(logname);
		if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
			setLevel(logname, levels.get(logname));
		}
		logger.warning(msg);
}

	public static void fine(String logname, String msg) {
			Logger logger = Logger.getLogger(logname);
			if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
				setLevel(logname, levels.get(logname));
			}
			logger.fine(msg);
	}

	public static void finer(String logname, String msg) {
			Logger logger = Logger.getLogger(logname);
			if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
				setLevel(logname, levels.get(logname));
			}
			logger.finer(msg);
	}

	public static void finest(String logname, String msg) {
			Logger logger = Logger.getLogger(logname);
			if (levels.containsKey(logname) && levels.get(logname) != logger.getLevel()) {
				setLevel(logname, levels.get(logname));
			}
			logger.finer(msg);
	}
}
