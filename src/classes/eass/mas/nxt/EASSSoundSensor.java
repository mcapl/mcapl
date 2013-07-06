// ----------------------------------------------------------------------------
// Copyright (C) 2011 Louise A. Dennis and Michael Fisher
// 
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.liverpool.ac.uk/~lad
// http://www.csc.liv.ac.uk/~michael/
//
//----------------------------------------------------------------------------

package eass.mas.nxt;

import ail.syntax.Literal;
import ail.syntax.NumberTermImpl;
import lejos.nxt.SoundSensor;

import java.io.PrintStream;

public class EASSSoundSensor extends SoundSensor implements EASSSensor {
	PrintStream out = System.out;

	public EASSSoundSensor(NXTBrick brick, int i) {
		super(brick.getSensorPort(i));
	}
	
	public void addPercept(EASSNXTEnvironment env) {
		int soundvalue = readValue();
		out.println("volume is " + soundvalue);
		Literal sound = new Literal("sound");
		sound.addTerm(new NumberTermImpl(soundvalue));
		env.addUniquePercept("sound", sound);
	}
	
	public void setPrintStream(PrintStream s) {		out = s;
	};
}