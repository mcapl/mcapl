package eass;

import eass.parser.EASSAILVisitor;
import eass.parser.EASSLexer;
import eass.parser.EASSParser;
import eass.syntax.ast.Abstract_EASSAgent;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

public class JPF_eass_EASSAgentBuilder extends NativePeer {


    @MJI
    public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        try {
            EASSLexer lexer = new EASSLexer(CharStreams.fromFileName(masstring));
            org.antlr.v4.runtime.CommonTokenStream tokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);
            EASSParser parser = new EASSParser(tokens);

            EASSAILVisitor visitor = new EASSAILVisitor();
            Abstract_EASSAgent abs_agent = (Abstract_EASSAgent) visitor.visitEassagent(parser.eassagent());

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
