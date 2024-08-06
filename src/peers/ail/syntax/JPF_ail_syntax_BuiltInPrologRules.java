package ail.syntax;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ail.parser.FOFVisitor;
import ail.syntax.ast.Abstract_Predicate;
import ail.syntax.ast.Abstract_Rule;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;

public class JPF_ail_syntax_BuiltInPrologRules extends NativePeer {
	static FOFVisitor fofvisitor = new FOFVisitor();
	
	@MJI
	public static void abstract_predicate__Ljava_lang_String_2__ (MJIEnv env, int objref, int stringref) {
		String s = env.getStringObject(stringref);
		LogicalFmlasParser parser = fofparser(s);

		Abstract_Predicate rule = (Abstract_Predicate) fofvisitor.visitPred(parser.pred());
		// System.out.println(rule);
		int ref = rule.newJPFObject(env);
		env.setReferenceField(objref, "tmp_predicate", ref);
	}

	@MJI
	public static void abstract_rule__Ljava_lang_String_2__ (MJIEnv env, int objref, int stringref) {
		String s = env.getStringObject(stringref);
		LogicalFmlasParser parser = fofparser(s);

		Abstract_Rule rule = (Abstract_Rule) fofvisitor.visitProlog_rule(parser.prolog_rule());
		int ref = rule.newJPFObject(env);
		env.setReferenceField(objref, "tmp_rule", ref);
	}
	
	private static LogicalFmlasParser fofparser(String s) {
		LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
		return parser;
	}
}
