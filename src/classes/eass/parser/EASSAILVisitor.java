package eass.parser;

import ail.parser.FOFVisitor;
import ail.syntax.ast.*;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import eass.syntax.ast.Abstract_EASSAgent;
import gwendolen.parser.GwendolenParser;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.ArrayList;
import java.util.List;

public class EASSAILVisitor extends EASSBaseVisitor<Object> {
    @Override public Object visitMas(EASSParser.MasContext ctx) {
        Abstract_MAS mas = new Abstract_MAS();
        ArrayList<Abstract_EASSAgent> gags = (ArrayList<Abstract_EASSAgent>) visitEassagents(ctx.eassagents());
        mas.setAgs(gags);
        return mas;
    }

    @Override public Object visitEassagents(EASSParser.EassagentsContext ctx) {
        ArrayList<Abstract_EASSAgent> gags = new ArrayList<Abstract_EASSAgent>();
        List<EASSParser.EassagentContext> gctxs = ctx.eassagent();
        for (EASSParser.EassagentContext gctx: gctxs) {
            Abstract_EASSAgent g = (Abstract_EASSAgent) visitEassagent(gctx);
            gags.add(g);
        }
        return gags;
    }


    /* CURLYOPEN (pre=clogicalfmla)? CURLYCLOSE
            cap=pred {$c = new Abstract_Capability($cap.t); if ($pre.f != null) {$c.addPre($pre.f);}}
    CURLYOPEN post=clogicalfmla {$c.addPost($post.f);} CURLYCLOSE; */
    @Override public Object visitCapability(EASSParser.CapabilityContext ctx) {
        FOFVisitor fofvisitor = new FOFVisitor();
        LogicalFmlasParser fofparser_cap = fofparser(ctx.cap.getText());
        Abstract_Predicate pred = (Abstract_Predicate) fofvisitor.visitPred(fofparser_cap.pred());

        Abstract_Capability c = new Abstract_Capability(pred);

        List<EASSParser.Guard_atomContext> ga_ctxs = ctx.guard_atom();
        Abstract_Guard pre = new Abstract_Guard();
        Abstract_Guard post = new Abstract_Guard();
        int count = 1;
        for (EASSParser.Guard_atomContext ga_ctx: ga_ctxs) {
            boolean gneg = true;
            if (ga_ctx.NOT() != null) {
                gneg = false;
            }
            if (count == 1) {
                pre.add((Abstract_GLogicalFormula) visitGuard_atom(ga_ctx), gneg);
                c.addPre(pre);
            } else {
                post.add((Abstract_GLogicalFormula) visitGuard_atom(ga_ctx), gneg);
                c.addPost(post);
            }
        }

        return c;
    }

    private LogicalFmlasParser fofparser(String s) {
        LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
        return parser;
    }

}
