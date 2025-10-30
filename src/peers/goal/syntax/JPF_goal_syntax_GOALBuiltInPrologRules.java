package goal.syntax;

import ail.syntax.ast.Abstract_LogExpr;
import ail.syntax.ast.Abstract_LogicalFormula;
import ail.syntax.ast.Abstract_Predicate;
import goal.parser.GOALLexer;
import goal.parser.GOALParser;
import gov.nasa.jpf.annotation.MJI;
import gov.nasa.jpf.vm.ClinitRequired;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.NativePeer;
import mcaplantlr.runtime.ANTLRStringStream;
import mcaplantlr.runtime.CommonTokenStream;

import java.util.ArrayList;

public class JPF_goal_syntax_GOALBuiltInPrologRules extends NativePeer {
    public static GOALParser getParser(String s) {
        GOALLexer lexer = new GOALLexer(new ANTLRStringStream(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new GOALParser(tokens);
    }

    @MJI
    public static void abstract_predicate__Ljava_lang_String_2__(MJIEnv env, int objref, int stringref) {
        String s = env.getStringObject(stringref);
        GOALParser parser = getParser(s);
        try {
            //System.err.println("GOALBUILDINPROLOGRULES A");
            Abstract_Predicate pred = parser.declarationOrCallWithTerms();
            int ref = pred.newJPFObject(env);
            //System.err.println("GOALBUILDINPROLOGRULES B");
            env.setReferenceField(objref, "tmp_predicate", ref);
        } catch (ClinitRequired e) {
            env.repeatInvocation();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @MJI
    public static void abstract_rule__Ljava_lang_String_2__(MJIEnv env, int objref, int stringref) {
        String s = env.getStringObject(stringref);
        try {
            GOALParser parser = getParser(s);
            //System.err.println("GOALBUILDINPROLOGRULES C");
            ArrayList<Abstract_LogicalFormula> rule_a = (parser.no_bracket_literals());
            boolean first = true;
            Abstract_LogExpr rule_body = new Abstract_LogExpr();
            //System.err.println("GOALBUILDINPROLOGRULES D");
            for (Abstract_LogicalFormula alf : rule_a) {
                if (first) {
                    rule_body = new Abstract_LogExpr(Abstract_LogExpr.none, alf);
                    first = false;
                } else {
                    rule_body = new Abstract_LogExpr(rule_body, Abstract_LogExpr.and, alf);
                }

            }
            //System.err.println("GOALBUILDINPROLOGRULES E");
            int ref = rule_body.newJPFObject(env);
            //System.err.println("GOALBUILDINPROLOGRULES F");
            env.setReferenceField(objref, "tmp_rule", ref);
        } catch (ClinitRequired e) {
            env.repeatInvocation();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
