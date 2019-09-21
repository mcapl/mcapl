///////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2010-12 University of Liverpool Virtual Engineering Centre.
// 
// Author: Matt Webster
///////////////////////////////////////////////////////////////////////////////

package gwendolen.uavs.certification;

import java.util.ArrayList;

import mcapl.MCAPLTestRig;

/**
 * Model checking test rig.
 * 
 * @author matt
 *
 */
public class ModelCheckingTestRig_is7 {
	public static String executable = "marija.UavAgent";
	public static String outputlevel = "1";

	public static void main(String[] args) {
		ArrayList<String> test1 = new ArrayList<String>();
		int limit = 0;

		test1.add(executable);
		test1.add("2");
		test1.add(outputlevel);
		int expectedstates1 = 500; 
		
		if (args.length > 0) {
			limit = Integer.parseInt(args[0]);
		}
		
		MCAPLTestRig tr1 = new MCAPLTestRig("", test1, expectedstates1);

		tr1.testinjpf(limit);

		System.out.println("");
		System.out.println("Report for " + executable);
		tr1.report();
		
	}
}

