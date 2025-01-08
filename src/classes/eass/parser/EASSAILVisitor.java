package eass.parser;

import ail.syntax.ast.Abstract_MAS;
import eass.syntax.ast.Abstract_EASSAgent;
import gwendolen.parser.GwendolenParser;
import gwendolen.syntax.ast.Abstract_GwendolenAgent;

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

}
