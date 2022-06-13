package gwendolen.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.syntax.ast.Abstract_MAS;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;

public class GwendolenAILVisitor extends GwendolenBaseVisitor<Object> {

	// mas  :  aoagents;
	@Override public Object visitMas(GwendolenParser.MasContext ctx) { 
		Abstract_MAS mas = new Abstract_MAS();
		ArrayList<Abstract_GwendolenAgent> gags = (ArrayList<Abstract_GwendolenAgent>) visitGwendolenagents(ctx.gwendolenagents()); 
		mas.setAgs(gags);
		return mas;
	}

	
	private LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}

}
