// ----------------------------------------------------------------------------
// Copyright (C) 2012 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of Gwendolen
// 
// Gwendolen is free software; you can redistribute it and/or
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

package gwendolen;

import ail.syntax.Plan;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GwendolenPlanBuilder {
	Plan plan;

	public GwendolenPlanBuilder() {
	}

	public List<Plan> parsePlanFile(String filepath) throws IOException {
		return parsefile(filepath);
	}

	public String[] getPlanStrings(String filepath) throws IOException {
		String fileAsString = new String(Files.readAllBytes(Paths.get(filepath)));
		return fileAsString.split("\\n");

	}

	public List<Plan> parsefile(String filepath) throws IOException {
		String[] planStrings = getPlanStrings(filepath);
		ArrayList<Plan> planList = new ArrayList<>();
		for (String planString : planStrings) {
			try {
				//GwendolenLexer plan_lexer = new GwendolenLexer(new ANTLRFileStream(masstring));
				GwendolenLexer plan_lexer = new GwendolenLexer(new ANTLRStringStream(planString));
				//System.out.print("Plan Lexer done");
				CommonTokenStream plan_tokens = new CommonTokenStream(plan_lexer);
				//System.out.print("Plan tokens done");
				GwendolenParser plan_parser = new GwendolenParser(plan_tokens);
				//System.out.print("Plan parser done");
				Plan plan = (plan_parser.plan()).toMCAPL();
				//System.out.print("plan parsed");
				planList.add(plan);
				//System.out.print("plan added to plan list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return planList;

	}
}
