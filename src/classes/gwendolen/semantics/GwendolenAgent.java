// ----------------------------------------------------------------------------
// Copyright (C) 2008-2012 Louise A. Dennis, Berndt Farwer, Michael Fisher and 
// Rafael H. Bordini.
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
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

package gwendolen.semantics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_StringTermImpl;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.mas.MAS;
import ail.semantics.AILAgent;
import ail.syntax.ast.Abstract_PredicateDescription;
import ail.tracing.explanations.PredicateDescriptions;
import ail.util.AILConfig;
import ail.util.AILPrettyPrinter;
import ail.util.AILexception;
import ajpf.MCAPLcontroller;
import ajpf.util.AJPFException;
//import gwendolen.parser.GwendolenSubLexer;
//import gwendolen.parser.GwendolenSubParser;
import gwendolen.util.GwendolenPrettyPrinter;

/**
 * A Gwendolen Agent - a demonstration of how to subclass an AIL Agent and
 * create a reasoning cycle.
 * 
 * @author louiseadennis
 *
 */
public class GwendolenAgent extends AILAgent {

	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public GwendolenAgent(MAS mas, String name) throws AILexception {
		// first we create an AIL Agent.
		super(mas, name);

		// try {
		// ((DefaultEnvironment) fEnv).addPerceptListener(this);
		// } catch (Exception e) {
		// throw new AILexception("AIL: error creating the agent architecture! - " + e);
		// }

		// Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle. See the GwendolenRC class for how
		// to create a language specific reasoning cycle. NB. this will
		// change when we get the rules to return state change objects.
		// setTrackPlanUsage(false);
		setReasoningCycle(new GwendolenRC());
	}

	/**
	 * Construct a Gwendolen agent from an architecture and a name.
	 * 
	 * @param arch the Agent Architecture.
	 * @param name te name of the agent.
	 */
	public GwendolenAgent(String name) throws AILexception {
		// first we create an AIL Agent.
		super(name);

		// try {
		// ((DefaultEnvironment) fEnv).addPerceptListener(this);
		// } catch (Exception e) {
		// throw new AILexception("AIL: error creating the agent architecture! - " + e);
		// }

		// Then we construct Gwendolen's reasoning cycle, starting with
		// an empty reasoning cycle. See the GwendolenRC class for how
		// to create a language specific reasoning cycle. NB. this will
		// change when we get the rules to return state change objects.
		// setTrackPlanUsage(false);
		setReasoningCycle(new GwendolenRC());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ail.semantics.AILAgent#configure(ail.util.AILConfig)
	 */
	@Override
	public void configure(AILConfig config) {
		super.configure(config);
		if (config.containsKey("ail.store_sent_messages")) {
			String store_sent_messages = config.getProperty("ail.store_sent_messages");
			if (store_sent_messages.equals("true")) {
				setStoreSentMessages(true);
			} else {
				setStoreSentMessages(false);
			}
		}
		// setPretty(new GwendolenPrettyPrinter());
		if (config.containsKey("tracing.descriptions")) {
			try {
				String descriptionsfile = MCAPLcontroller.getFilename(config.getProperty("tracing.descriptions"));
				BufferedReader read = new BufferedReader(new FileReader(descriptionsfile));
				Stream<String> lines = read.lines();
				FOFVisitor fofvisitor = new FOFVisitor();
				List<Abstract_PredicateDescription> descriptions = new ArrayList<Abstract_PredicateDescription>();
				lines.forEach(line -> {
					String[] pair = line.split(":");
					if (pair.length > 1) {
						String f_string = pair[0];
						String description = pair[1].replace("\"", "");
						LogicalFmlasParser parser = fofparser(f_string);
						Abstract_Predicate predicate = (Abstract_Predicate) fofvisitor.visitPred(parser.pred());
						Abstract_PredicateDescription d = new Abstract_PredicateDescription(predicate, new Abstract_StringTermImpl(description));
						descriptions.add(d);
					}
				});
				//GwendolenSubLexer lexer = new GwendolenSubLexer(CharStreams.fromFileName(descriptionsfile));
				//GwendolenSubParser parser = new GwendolenSubParser(new CommonTokenStream(lexer));
				//List<Abstract_PredicateDescription> descriptions = parser.descriptions().ds;
				setPretty(new GwendolenPrettyPrinter(new PredicateDescriptions(descriptions)));
			} catch (final AJPFException | IOException e) {
				e.printStackTrace(); // FIXME
			}
		}
		
		if (config.containsKey("pretty")) {
			String printer = config.getProperty("pretty");
			if (printer.equals("ail")) {
				setPretty(new AILPrettyPrinter());
			} 
			if (printer.equals("gwendolen")) {
				setPretty(new GwendolenPrettyPrinter());
			}
		}
	}

	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}
}
