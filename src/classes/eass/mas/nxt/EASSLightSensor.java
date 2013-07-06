package eass.mas.nxt;

import java.io.PrintStream;

import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import lejos.nxt.LightSensor;

public class EASSLightSensor extends LightSensor implements EASSSensor {
	PrintStream out = System.out;

	public EASSLightSensor(NXTBrick brick, int i) {
		super(brick.getSensorPort(i));
	}

	public void addPercept(EASSNXTEnvironment env) {
		int lightvalue = readValue();
		out.println("Light Intensity is " + lightvalue);
		Literal light = new Literal("light");
		light.addTerm(new NumberTermImpl(lightvalue));
		env.addUniquePercept("light", light);
	}

	public void setPrintStream(PrintStream s) {out = s;};
}
