// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------
package hera.semantics;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import ajpf.MCAPLcontroller;
import ajpf.util.VerifyMap;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.principles.DoubleEffectPrinciple;
import hera.principles.KantianHumanityPrincipleReading1;
import hera.principles.UtilitarianPrinciple;

public class SmartHomeQuickTests {
	
	@Test public void doubleeffecttest() {
		String rel_file = "/src/examples/hera/smarthome/keeping_children_quiet_v2.json";
		String file = MCAPLcontroller.getAbsFilename(rel_file);
		VerifyMap<Formula,Boolean> w1 = new VerifyMap<Formula,Boolean>();
		w1.put(new FormulaString("turn_on_video_game"), true);
		w1.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), false);
		w1.put(new FormulaString("refrain"), false);
		
		VerifyMap<Formula,Boolean> w2 = new VerifyMap<Formula,Boolean>();
		w2.put(new FormulaString("turn_on_video_game"), false);
		w2.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), true);
		w2.put(new FormulaString("refrain"), false);

		VerifyMap<Formula,Boolean> w3 = new VerifyMap<Formula,Boolean>();
		w3.put(new FormulaString("turn_on_video_game"), false);
		w3.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), false);
		w3.put(new FormulaString("refrain"), true);

		
		CausalModel m1 = new CausalModel(file, w1);
		CausalModel m2 = new CausalModel(file, w2);
		CausalModel m3 = new CausalModel(file, w3);
		
		ArrayList<Model> alternatives = new ArrayList<Model>();
		alternatives.add(m1);
		alternatives.add(m2);
		alternatives.add(m3);
		
		m1.setAlternatives(alternatives);
		m2.setAlternatives(alternatives);
		m3.setAlternatives(alternatives);
		
		Boolean b1 = m1.evaluate(new DoubleEffectPrinciple());
		Boolean b2 = m2.evaluate(new DoubleEffectPrinciple());
		Boolean b3 = m3.evaluate(new DoubleEffectPrinciple());
		assertFalse(b1);
		assertFalse(b2);
		assertTrue(b3 == null); // Not Applicable because refrain has no consequences
	}
	
	@Test public void utilitariantest() {
		String file = "/Users/louiseadennis/Eclipse/mcapl/src/examples/hera/smarthome/keeping_children_quiet_v2.json";
		VerifyMap<Formula,Boolean> w1 = new VerifyMap<Formula,Boolean>();
		w1.put(new FormulaString("turn_on_video_game"), true);
		w1.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), false);
		w1.put(new FormulaString("refrain"), false);
		
		VerifyMap<Formula,Boolean> w2 = new VerifyMap<Formula,Boolean>();
		w2.put(new FormulaString("turn_on_video_game"), false);
		w2.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), true);
		w2.put(new FormulaString("refrain"), false);

		VerifyMap<Formula,Boolean> w3 = new VerifyMap<Formula,Boolean>();
		w3.put(new FormulaString("turn_on_video_game"), false);
		w3.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), false);
		w3.put(new FormulaString("refrain"), true);

		
		CausalModel m1 = new CausalModel(file, w1);
		CausalModel m2 = new CausalModel(file, w2);
		CausalModel m3 = new CausalModel(file, w3);
		
		ArrayList<Model> alternatives = new ArrayList<Model>();
		alternatives.add(m1);
		alternatives.add(m2);
		alternatives.add(m3);
		
		m1.setAlternatives(alternatives);
		m2.setAlternatives(alternatives);
		m3.setAlternatives(alternatives);
		
		Boolean b1 = m1.evaluate(new UtilitarianPrinciple());
		Boolean b2 = m2.evaluate(new UtilitarianPrinciple());
		Boolean b3 = m3.evaluate(new UtilitarianPrinciple());
		assertTrue(b1);
		assertTrue(b2);
		assertFalse(b3);
	}
	
	@Test public void kantiantest() {
		String file = "/Users/louiseadennis/Eclipse/mcapl/src/examples/hera/smarthome/keeping_children_quiet_v2.json";
		VerifyMap<Formula,Boolean> w1 = new VerifyMap<Formula,Boolean>();
		w1.put(new FormulaString("turn_on_video_game"), true);
		w1.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), false);
		w1.put(new FormulaString("refrain"), false);
		
		VerifyMap<Formula,Boolean> w2 = new VerifyMap<Formula,Boolean>();
		w2.put(new FormulaString("turn_on_video_game"), false);
		w2.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), true);
		w2.put(new FormulaString("refrain"), false);

		VerifyMap<Formula,Boolean> w3 = new VerifyMap<Formula,Boolean>();
		w3.put(new FormulaString("turn_on_video_game"), false);
		w3.put(new FormulaString("turn_on_video_game_and_remind_mom_about_Christmas_presents"), false);
		w3.put(new FormulaString("refrain"), true);

		
		CausalModel m1 = new CausalModel(file, w1);
		CausalModel m2 = new CausalModel(file, w2);
		CausalModel m3 = new CausalModel(file, w3);
		
		ArrayList<Model> alternatives = new ArrayList<Model>();
		alternatives.add(m1);
		alternatives.add(m2);
		alternatives.add(m3);
		
		m1.setAlternatives(alternatives);
		m2.setAlternatives(alternatives);
		m3.setAlternatives(alternatives);
		
		Boolean b1 = m1.evaluate(new KantianHumanityPrincipleReading1());
		Boolean b2 = m2.evaluate(new KantianHumanityPrincipleReading1());
		Boolean b3 = m3.evaluate(new KantianHumanityPrincipleReading1());
		assertFalse(b1);
		assertTrue(b2);
		assertFalse(b3);
	}


	

}
