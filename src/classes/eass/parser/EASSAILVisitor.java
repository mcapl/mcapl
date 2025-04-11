package eass.parser;

import ail.parser.FOFVisitor;
import ail.syntax.ast.*;
import ajpf.psl.parser.LogicalFmlasLexer;
import ajpf.psl.parser.LogicalFmlasParser;
import eass.syntax.ast.Abstract_EASSAgent;
import gwendolen.parser.GwendolenAILVisitor;
import gwendolen.parser.GwendolenLexer;
import gwendolen.parser.GwendolenParser;
import gwendolen.syntax.ast.Abstract_GPlan;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EASSAILVisitor extends EASSBaseVisitor<Object> {
    private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
    private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
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


    @Override public Object visitEassagent(EASSParser.EassagentContext ctx) {
        String name = ctx.CONST().getText();
        agentname = new Abstract_StringTermImpl(name);
        try {
            Abstract_EASSAgent g = new Abstract_EASSAgent(name);


            FOFVisitor fofvisitor = new FOFVisitor();
            GwendolenAILVisitor gwenvisitor = new GwendolenAILVisitor();

            if (ctx.bs != null) {
                List<TerminalNode> beliefblocks = ctx.BELIEF_BLOCK();
                for (TerminalNode bb: beliefblocks) {
                    LogicalFmlasParser fofparser_bs = fofparser(bb.getText());
                    ArrayList<Abstract_Literal> bs = (ArrayList<Abstract_Literal>) fofvisitor.visitLitlist_poss_empty(fofparser_bs.litlist_poss_empty());
                    for (Abstract_Literal l: bs) {
                        g.addInitialBel(l);
                    }
                }
            }

            if (ctx.rr != null) {
                List<TerminalNode> rrblocks = ctx.RR_BLOCK();
                for (TerminalNode rr: rrblocks) {
                    LogicalFmlasParser fofparser_brs = fofparser(rr.getText());
                    ArrayList<Abstract_Rule> brs = (ArrayList<Abstract_Rule>) fofvisitor.visitRulelist_poss_empty(fofparser_brs.rulelist_poss_empty());
                    for (Abstract_Rule r: brs) {
                        g.addRule(r);
                    }
                }
            }

            if (ctx.cap != null) {
                List<EASSParser.CapabilityContext> cctx = ctx.capability();
                for (EASSParser.CapabilityContext cap_ctx: cctx) {
                    Abstract_Capability cap = (Abstract_Capability) visitCapability(cap_ctx);
                    g.addCap(cap);
                }
            }

            List<EASSParser.Initial_goalContext> goals = ctx.initial_goal();
            for (EASSParser.Initial_goalContext gctx: goals) {
                GwendolenParser gparser = gwenparser(gctx.getText(), GwendolenLexer.GOALS);

                Abstract_Goal goal = (Abstract_Goal) gwenvisitor.visitInitial_goal(gparser.initial_goal());
                g.addInitialGoal(goal);
            }

            List<EASSParser.Eass_planContext> plans = ctx.eass_plan();
            for (EASSParser.Eass_planContext pctx: plans) {
                Abstract_GPlan plan = (Abstract_GPlan) visitEASS_plan(pctx);
                g.addPlan(plan);
                //CharStream tokens = pctx.start.getInputStream();
                //String originalText = tokens.getText(new Interval(pctx.start.getStartIndex(), pctx.stop.getStopIndex()));
               // GwendolenParser gparser = gwenparser(originalText, GwendolenLexer.PLANS_MODE);
                //Abstract_GPlan plan = (Abstract_GPlan) gwenvisitor.visitPlan(gparser.plan());
               // g.addPlan(plan);
            }

            return g;
        } catch (Exception e) {
            System.err.println(e);
            return name;
        }
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

    public Object visitEASS_plan(EASSParser.Eass_planContext ctx) {
        Abstract_Event event = (Abstract_Event) visitEvent(ctx.event());
        List<GwendolenParser.Guard_atomContext> ga_ctxs = ctx.guard_atom();
        Abstract_Guard guard = new Abstract_Guard();
        for (GwendolenParser.Guard_atomContext ga_ctx: ga_ctxs) {
            boolean gneg = true;
            if (ga_ctx.NOT() != null) {
                gneg = false;
            }
            guard.add((Abstract_GLogicalFormula) visitGuard_atom(ga_ctx), gneg);
        }

        ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>();
        List<EASS_deedContext> d_ctxs = ctx.eass_deed();
        for (EASS_deedContext d_ctx: d_ctxs) {
            deeds.add((Abstract_Deed) visitEASS_deed(d_ctx));
        }
    }

    private LogicalFmlasParser fofparser(String s) {
        LogicalFmlasLexer lexer = new LogicalFmlasLexer(CharStreams.fromString(s));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogicalFmlasParser parser = new LogicalFmlasParser(tokens);
        return parser;
    }

    private GwendolenParser gwenparser(String s, int Mode) {
        GwendolenLexer lexer = new GwendolenLexer(CharStreams.fromString(s));
        lexer.pushMode(Mode);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GwendolenParser parser = new GwendolenParser(tokens);
        return parser;
    }

}
