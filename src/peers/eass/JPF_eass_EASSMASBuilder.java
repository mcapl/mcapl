package eass;

import ail.syntax.ast.Abstract_MAS;
import eass.parser.EASSLexer;
import eass.parser.EASSParser;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

public class JPF_eass_EASSMASBuilder extends NativePeer {
    @MJI
    public static void parse__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        EASSLexer lexer = new EASSLexer(new ANTLRStringStream(masstring));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EASSParser parser = new EASSParser(tokens);
        try {
            Abstract_MAS amas = parser.mas();
            int ref = amas.newJPFObject(env);
            env.setReferenceField(objref, "amas", ref);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @MJI
    public static void parsefile__Ljava_lang_String_2__ (MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        try {
            EASSLexer lexer = new EASSLexer(new ANTLRFileStream(masstring));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EASSParser parser = new EASSParser(tokens);

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
