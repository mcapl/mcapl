package ajpf.psl.buchi;

import ajpf.MCAPLListener;
import ajpf.psl.MCAPLProperty;
import ajpf.psl.ast.Abstract_Property;
import ajpf.psl.ast.Abstract_Until;
import ajpf.psl.parser.AJPF_PSLVisitor;
import ajpf.psl.parser.A_PSLLexer;
import ajpf.psl.parser.A_PSLParser;
import org.antlr.v4.runtime.CharStreams;
import org.junit.Assert;
import org.junit.Test;

public class BuchiAutomatonQuickTests {

    @Test
    public void falsePropContradictionTest() throws Exception {
        String propertystring = "<> (~ B (planreasoner, bad))";
        A_PSLLexer lexer = new A_PSLLexer((CharStreams.fromString(propertystring)));
        org.antlr.v4.runtime.CommonTokenStream psltokens = new org.antlr.v4.runtime.CommonTokenStream(lexer);

        A_PSLParser pslparser = new A_PSLParser(psltokens);
        AJPF_PSLVisitor visitor = new AJPF_PSLVisitor();
        Abstract_Property p = visitor.visitProperty(pslparser.property());
        Abstract_Property np = p.toNormalForm();
        MCAPLProperty mp = np.toMCAPLNative();

        MCAPLProperty negprop = mp.negate();
        BuchiState init = new BuchiState(0, negprop, 1);
        BuchiAutomaton b = new BuchiAutomaton();
        b.init(init, negprop.getUntils());

        Assert.assertTrue(b.numberstates == 1);
    }
}
