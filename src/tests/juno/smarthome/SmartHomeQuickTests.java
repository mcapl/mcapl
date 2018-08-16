package juno.smarthome;

import org.junit.Test;

import ail.util.AJPF_w_AIL;

public class SmartHomeQuickTests {
	
	@Test public void utilitariantest() {
		String file = "/src/examples/juno/smarthome/lights_and_fire.ail";
    	String prop_filename =  "/src/examples/juno/smarthome/smart_home.psl";
    	String[] args = new String[3];
    	args[0] = file;
    	args[1] = prop_filename;
    	args[2] = "sanity";
    	AJPF_w_AIL.run(args);
	}

}
