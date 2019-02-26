package juno;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import juno.syntax.ast.Abstract_JunoAgent;
import juno.syntax.parser.JunoAILVisitor;
import juno.syntax.parser.JunoLexer;
import juno.syntax.parser.JunoParser;

public class JPF_juno_JunoMASBuilder extends NativePeer {
	@MJI
	public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
		String masstring = env.getStringObject(masRef);
		try {
			JunoLexer lexer = new JunoLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			JunoParser parser = new JunoParser(tokens);
			JunoAILVisitor visitor = new JunoAILVisitor();
			Abstract_JunoAgent ajuno = (Abstract_JunoAgent) visitor.visitJunoAgent(parser.junoAgent());
			int jRef = ajuno.newJPFObject(env);
			env.setReferenceField(objref, "a_juno", jRef);
		} catch (ClinitRequired e) {
			env.repeatInvocation();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
