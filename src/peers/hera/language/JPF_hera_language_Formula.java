package hera.language;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import hera.parser.HeraLanguageVisitor;
import hera.parser.HeraLexer;
import hera.parser.HeraParser;

public class JPF_hera_language_Formula extends NativePeer {
	@MJI
	public static void createFormulaFromString__Ljava_lang_String_2__(MJIEnv env, int objref, int sRef) {
		String s = env.getStringObject(sRef);
		HeraLexer lexer = new HeraLexer(CharStreams.fromString(s));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HeraParser parser = new HeraParser(tokens);
		HeraLanguageVisitor visitor = new HeraLanguageVisitor();
		Formula formula = visitor.visitFormula(parser.formula());
		int formula_ref = formula.newJPFObject(env);
				
		env.setReferenceField(objref, "fromStringFormula", formula_ref);
	}

}
