// ----------------------------------------------------------------------------
// Copyright (C) 2016 Louise A. Dennis,  and Michael Fisher
//
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------
package gwendolen.ajpf_tutorials;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

import ail.util.AJPF_w_AIL;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.TypeRef;
import gov.nasa.jpf.util.test.TestJPF;

public class Tutorial3_prismQuickTests {
	 static final String[] JPF_ARGS = { "suppress_version = true" };

	  //--- test methods

	  /* @Test //----------------------------------------------------------------------
	  public void spin_output () {
	   // if (verifyNoPropertyViolation(JPF_SPIN_ARGS)) {
	    	String jpf_config = "src/examples/gwendolen/ajpf_tutorials/tutorial3/TwoPickUpAgents_SpinToFile.jpf";
	    	
	    	Config conf = JPF.createConfig(JPF_ARGS);
	    	conf.setProperty("ajpf.model.location", "tutorial3_spin.pml");
	    	FileInputStream is = null;
	    	try {
	    		File f = new File(jpf_config);
	    		if (f.isFile()) {
	    			is = new FileInputStream(f);
	    			conf.load(is);
	    		}
	    	JPF jpf = new JPF(conf);
	    	jpf.run();
	    	
	    	String tutorial_path = conf.getProperty("mcapl") + "/src/examples/gwendolen/ajpf_tutorials/tutorial3/";
	    	String example_filename = tutorial_path + "tutorial3_spin_example.pml";
	    	String test_filename = tutorial_path + "tutorial3_spin.pml";
	    	
	    	File example_file = new File(example_filename);
	    	File test_file = new File(test_filename);
	    	
	    	Path epath = example_file.toPath();
	    	Path tpath = test_file.toPath();
	    	
	    	Assert.assertTrue(sameContent(epath, tpath));
	    	} catch (Exception e) {
	    		Assert.assertFalse(true);
	    	}

	 	// }
	  } */
	  
	  @Test //----------------------------------------------------------------------
	  public void prism_output () {
	   // if (verifyNoPropertyViolation(JPF_SPIN_ARGS)) {
	    	String jpf_config = "src/examples/gwendolen/ajpf_tutorials/tutorial3/TwoPickUpAgents_PrismToFile.jpf";
	    	
	    	Config conf = JPF.createConfig(JPF_ARGS);
	    	FileInputStream is = null;
	    	try {
	    		File f = new File(jpf_config);
	    		if (f.isFile()) {
	    			is = new FileInputStream(f);
	    			conf.load(is);
	    		}
	    	JPF jpf = new JPF(conf);
	    	jpf.run();
	    	
	    	String tutorial_path = conf.getProperty("mcapl") + "/src/examples/gwendolen/ajpf_tutorials/tutorial3/";
	    	String example_filename = tutorial_path + "tutorial3_prism_example.pm";
	    	String test_filename = tutorial_path + "tutorial3_prism.pm";
	    	
	    	File example_file = new File(example_filename);
	    	File test_file = new File(test_filename);
	    	
	    	Path epath = example_file.toPath();
	    	Path tpath = test_file.toPath();
	    	
	    	Assert.assertTrue(sameContent(epath, tpath));
	    	} catch (Exception e) {
	    		Assert.assertFalse(true);
	    	}

	 	// }
	  }
	  	  
	  boolean sameContent(Path file1, Path file2) throws IOException {
		    /* final long size = Files.size(file1);
		    if (size != Files.size(file2))
		        return false;

		    if (size < 4096)
		        return Arrays.equals(Files.readAllBytes(file1), Files.readAllBytes(file2)); */

		    try (InputStream is1 = Files.newInputStream(file1);
		         InputStream is2 = Files.newInputStream(file2)) {
		        // Compare byte-by-byte.
		        // Note that this can be sped up drastically by reading large chunks
		        // (e.g. 16 KBs) but care must be taken as InputStream.read(byte[])
		        // does not neccessarily read a whole array!
		        int data;
		        while ((data = myread(is1)) != -1)
		            if (data != myread(is2))
		                return false;
		    }

		    return true;
		}

	  private int myread(InputStream is) throws IOException {
		  int c;
		  do {
			  c = is.read();
		  } while (c == '\n' || c == '\r');
		  return c;
	  }
	 

}
