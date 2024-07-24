package ethical_governor;

import ail.syntax.ast.Abstract_Agent;
import ethical_governor.parser.EthicalGovernorLexer;
import ethical_governor.parser.EthicalGovernorParser;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import mcaplantlr.runtime.ANTLRFileStream;
import mcaplantlr.runtime.CommonTokenStream;

public class JPF_ethical_governor_EthicalGovernorBuilder extends NativePeer {
    @MJI
    public static void parsefile__Ljava_lang_String_2__(MJIEnv env, int objref, int masRef) {
        String masstring = env.getStringObject(masRef);
        try {
            EthicalGovernorLexer lexer = new EthicalGovernorLexer(new ANTLRFileStream(masstring));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EthicalGovernorParser parser = new EthicalGovernorParser(tokens);
            Abstract_Agent abs_agent = parser.degagent();
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
