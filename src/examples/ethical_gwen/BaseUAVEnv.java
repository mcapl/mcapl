package ethical_gwen;

import ail.mas.DefaultEnvironment;
import ail.mas.MAS;
import ajpf.MCAPLJobber;
import ajpf.util.AJPFLogger;
import ajpf.util.choice.UniformBoolChoice;
import ethical_gwen.mas.DefaultEthicalEnvironment;
import ethical_gwen.mas.DefaultEthicalVerificationEnvironment;
import ethical_gwen.parser.EthicalGwendolenLexer;
import ethical_gwen.parser.EthicalGwendolenParser;
import gwendolen.syntax.ast.Abstract_GPlan;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

public class BaseUAVEnv  extends DefaultEthicalVerificationEnvironment  {

    public BaseUAVEnv() {
        super("default");
    }

    public BaseUAVEnv(String s) {
        super(s);
    }


    //
    // Done this way because when model checking we run this in a NativePeer and then reconstructed the plan.
    public Abstract_GPlan pfs;
    public void planfromstring(String s) {
        EthicalGwendolenLexer lexer = new EthicalGwendolenLexer(new ANTLRStringStream(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        EthicalGwendolenParser parser = new EthicalGwendolenParser(tokens);
        try {
            Abstract_GPlan aplan = parser.plan();
            pfs = aplan;
        } catch (Exception e) {
            AJPFLogger.warning("ethical_gwen.lineup.LineUpEnv", "Couldn't parse plan: " + s + ":" + e.getMessage());
        }
    }

}
