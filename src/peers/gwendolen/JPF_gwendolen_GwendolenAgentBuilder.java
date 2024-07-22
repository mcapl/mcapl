package gwendolen;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;

public class JPF_gwendolen_GwendolenAgentBuilder extends NativePeer {


	  @MJI
	public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
		String masstring = env.getStringObject(masRef);
		try {
			GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromFileName(masstring));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			GwendolenParser parser = new GwendolenParser(tokens);
			GwendolenAILVisitor visitor = new GwendolenAILVisitor();
			Abstract_GwendolenAgent abs_agent = (Abstract_GwendolenAgent) visitor.visitGwendolenagent(parser.gwendolenagent());
	   		int ref = abs_agent.newJPFObject(env);
			env.setReferenceField(objref, "abs_agent", ref);
		} catch (ClinitRequired e) {
			env.repeatInvocation();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
