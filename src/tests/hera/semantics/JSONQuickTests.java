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
import java.util.HashMap;

import org.junit.Test;

import ajpf.MCAPLcontroller;
import hera.language.Formula;
import hera.language.FormulaString;
import hera.principles.DoubleEffectPrinciple;
import hera.principles.Principle;
import hera.principles.UtilitarianPrinciple;

public class JSONQuickTests {
	
	@Test public void doubleeffecttest() {
		String rel_file = "/src/examples/hera/rescuerobot/rescuerobot.json";
		String file = MCAPLcontroller.getAbsFilename(rel_file);
		HashMap<Formula,Boolean> w1 = new HashMap<Formula,Boolean>();
		w1.put(new FormulaString("a1"), true);
		w1.put(new FormulaString("a2"), false);
		w1.put(new FormulaString("a3"), false);
		w1.put(new FormulaString("b1"), true);
		
		HashMap<Formula,Boolean> w2 = new HashMap<Formula,Boolean>();
		w2.put(new FormulaString("a1"), false);
		w2.put(new FormulaString("a2"), true);
		w2.put(new FormulaString("a3"), false);
		w2.put(new FormulaString("b1"), true);

		HashMap<Formula,Boolean> w3 = new HashMap<Formula,Boolean>();
		w3.put(new FormulaString("a1"), false);
		w3.put(new FormulaString("a2"), false);
		w3.put(new FormulaString("a3"), true);
		w3.put(new FormulaString("b1"), true);

		
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
		
		int b1 = m1.evaluate(new DoubleEffectPrinciple());
		assertTrue(b1 == Principle.PERMISSIBLE);
		int b2 = m2.evaluate(new DoubleEffectPrinciple());
		assertTrue(b2 == Principle.PERMISSIBLE);
		int b3 = m3.evaluate(new DoubleEffectPrinciple());
		assertTrue(b3 == Principle.NOT_APPLICABLE);
	}
	
	@Test public void utilitariantest() {
		String rel_file = "/src/examples/hera/rescuerobot/rescuerobot.json";
		String file = MCAPLcontroller.getAbsFilename(rel_file);
		HashMap<Formula,Boolean> w1 = new HashMap<Formula,Boolean>();
		w1.put(new FormulaString("a1"), true);
		w1.put(new FormulaString("a2"), false);
		w1.put(new FormulaString("a3"), false);
		w1.put(new FormulaString("b1"), true);
		
		HashMap<Formula,Boolean> w2 = new HashMap<Formula,Boolean>();
		w2.put(new FormulaString("a1"), false);
		w2.put(new FormulaString("a2"), true);
		w2.put(new FormulaString("a3"), false);
		w2.put(new FormulaString("b1"), true);

		HashMap<Formula,Boolean> w3 = new HashMap<Formula,Boolean>();
		w3.put(new FormulaString("a1"), false);
		w3.put(new FormulaString("a2"), false);
		w3.put(new FormulaString("a3"), true);
		w3.put(new FormulaString("b1"), true);

		
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
		
		int b1 = m1.evaluate(new UtilitarianPrinciple());
		assertTrue(b1 == Principle.PERMISSIBLE);
		int b2 = m2.evaluate(new UtilitarianPrinciple());
		assertTrue(b2 == Principle.PERMISSIBLE);
		int b3 = m3.evaluate(new UtilitarianPrinciple());
		assertTrue(b3 == Principle.NOT_PERMISSIBLE);
	}


}
