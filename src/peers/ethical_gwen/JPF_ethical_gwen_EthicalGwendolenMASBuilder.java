package ethical_gwen;

import ail.syntax.ast.Abstract_MAS;
import ethical_gwen.parser.EthicalGwendolenLexer;
import ethical_gwen.parser.EthicalGwendolenParser;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

public class JPF_ethical_gwen_EthicalGwendolenMASBuilder extends NativePeer {
    @MJI
    public static void parse__Ljava_lang_String_2__(MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        EthicalGwendolenLexer lexer = new EthicalGwendolenLexer(new ANTLRStringStream(masstring));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EthicalGwendolenParser parser = new EthicalGwendolenParser(tokens);
        try {
            Abstract_MAS amas = parser.mas();
            int ref = amas.newJPFObject(env);
            env.setReferenceField(objref, "amas", ref);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @MJI
    public static void parsefile__Ljava_lang_String_2__(MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        try {
            EthicalGwendolenLexer lexer = new EthicalGwendolenLexer(new ANTLRFileStream(masstring));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EthicalGwendolenParser parser = new EthicalGwendolenParser(tokens);
            Abstract_MAS amas = parser.mas();
            int ref = amas.newJPFObject(env);
            env.setReferenceField(objref, "amas", ref);
        } catch (ClinitRequired e) {
            env.repeatInvocation();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
