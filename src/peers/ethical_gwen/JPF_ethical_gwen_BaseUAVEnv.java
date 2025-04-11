package ethical_gwen;

import ajpf.util.AJPFLogger;
import ethical_gwen.parser.EthicalGwendolenLexer;
import ethical_gwen.parser.EthicalGwendolenParser;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import gwendolen.syntax.ast.Abstract_GPlan;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

public class JPF_ethical_gwen_BaseUAVEnv extends NativePeer {
    @MJI
    public static void planfromstring__Ljava_lang_String_2__(MJIEnv env, int objref, int stringRef) {
        String s = env.getStringObject(stringRef);
        EthicalGwendolenLexer lexer = new EthicalGwendolenLexer(new ANTLRStringStream(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EthicalGwendolenParser parser = new EthicalGwendolenParser(tokens);
        try {
            Abstract_GPlan aplan = parser.plan();
            int ref = aplan.newJPFObject(env);
            env.setReferenceField(objref, "pfs", ref);
        } catch (Exception e) {
            AJPFLogger.warning("ethical_gwen.BaseUAVEnv", "Couldn't parse plan: " + s + ":" + e.getMessage());
            e.printStackTrace();
        }
    }
}
