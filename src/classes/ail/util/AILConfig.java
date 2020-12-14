// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

package ail.util;

import ajpf.util.AJPFLogger;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.TreeSet;

/**
 * Represents a configuration for AIL, allowing user customisation of the system via an input file.
 * @author lad
 *
 */
public class AILConfig extends Properties {
	private String logname = "ail.util.AILConfig";
	
	private static final long serialVersionUID = 1L;

	/**
	 * where did we initialize from
	 */
	ArrayList<Object> sources = new ArrayList<Object>();

	/**
	 * single source Config constructor (does not process stack)
	 * @param fileName - single properties filename to initialize from 
	 */
	public AILConfig (String filename){
		  try {
			  String fileName = MCAPLcontroller.getFilename(filename);
			  loadProperties(fileName);
			  if (AJPFLogger.ltFine(logname)) {
				  AJPFLogger.fine(logname, this.toString());
			  }
		  } catch (AILexception e) {
			  AJPFLogger.warning(logname, e.getMessage());
		  } catch (AJPFException e) {
			  AJPFLogger.severe(logname, e.getMessage());
			  System.exit(0);
		  }
		  
		  //System.out.println(this.toString());
	  }
	
	/**
	 * Constructor for empty configurations.
	 */
	public AILConfig() {
		
	}

	/**
	 * Load the properties from the file.
	 * @param fileName
	 * @return
	 * @throws AILexception
	 */
	protected boolean loadProperties (String fileName) throws AILexception {
		    if (fileName != null && fileName.length() > 0) {
		      FileInputStream is = null;
		      try {
		        File f = new File(fileName);
		        if (f.isFile()) {
		          AJPFLogger.fine(logname, "loading property file: " + fileName);

		          setConfigPathProperties(f.getAbsolutePath());
		          sources.add(f);
		          is = new FileInputStream(f);
		          load(is);
		          return true;
		        } else {
		          throw new AILexception("property file does not exist: " + f.getAbsolutePath());
		        }
		      } catch (IOException iex) {
		        throw new AILexception("error reading properties: " + fileName);
		      } finally {
		        if (is != null){
		          try {
		            is.close();
		          } catch (IOException iox1){
		            AJPFLogger.warning(logname, "error closing input stream for file: " + fileName);
		          }
		        }
		      }
		    }

		    return false;
		  }
	  
	/**
	 * Set properties to do with the config path.
	 * @param fileName
	 */
	  protected void setConfigPathProperties (String fileName){
		    put("config", fileName);
		    int i = fileName.lastIndexOf(File.separatorChar);
		    if (i>=0){
		      put("config_path", fileName.substring(0,i));
		    } else {
		      put("config_path", ".");
		    }
		  }
	  
	  
	  /*
	   * (non-Javadoc)
	   * @see java.util.Hashtable#toString()
	   */
	  public String toString() {
		  String s = "----------- Config contents\n";

		    // just how much do you have to do to get a printout with keys in alphabetical order :<
		    TreeSet<String> kset = new TreeSet<String>();
		    for (Enumeration<?> e = propertyNames(); e.hasMoreElements();) {
		      Object k = e.nextElement();
		      if (k instanceof String) {
		        kset.add( (String)k);
		      }
		    }

		    for (String key : kset) {
		      String val = getProperty(key);
		      s += key;
		      s += " = ";
		      s += val;
		      s += "\n";
		    }
		    return s;
		  }




}
