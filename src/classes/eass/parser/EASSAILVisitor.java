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
import javassist.runtime.Inner;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

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
        String name = ctx.w.getText();
        String abstraction_for = "";
        if (ctx.ABSTRACTION() != null) {
            abstraction_for = name;
            name = "abstraction_" + name;
        }
        agentname = new Abstract_StringTermImpl(name);
        try {
            Abstract_EASSAgent g = new Abstract_EASSAgent(name);
            if (ctx.ABSTRACTION() != null) {
                g.setAbstraction(abstraction_for);
            }


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
                Abstract_GPlan plan = (Abstract_GPlan) visitEass_plan(pctx);
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

        //Abstract_Guard pre = new Abstract_Guard();

        LogicalFmlasParser fofparser_pre = fofparser(ctx.pre.getText());
        Abstract_Guard pre = (Abstract_Guard) visitLogicalfmla(fofparser_pre.logicalfmla());


        c.addPre(pre);

        LogicalFmlasParser fofparser_post = fofparser(ctx.post.getText());
        Abstract_Guard post = (Abstract_Guard) visitLogicalfmla(fofparser_post.logicalfmla());

        c.addPost(post);

        return c;
    }

    public Object visitLogicalfmla(@org.antlr.v4.runtime.misc.NotNull LogicalFmlasParser.LogicalfmlaContext ctx) {
        // Abstract_LogicalFormula f = (Abstract_LogicalFormula) visitNotfmla(ctx.n);
        List<LogicalFmlasParser.NotfmlaContext> subfmlas = ctx.notfmla();
        Abstract_GLogicalFormula f = null;
        for (LogicalFmlasParser.NotfmlaContext n:subfmlas) {
            Abstract_GLogicalFormula f2 = (Abstract_GLogicalFormula) visitNotfmla(n);
            if (f == null) {
                f = f2;
            } else {
                f = new Abstract_Guard(f, Abstract_Guard.and, f2);
            }
        }
        return f;
    }

    //	//clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
    ////               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*;
    // //cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} |
    ////                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} |
    ////                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
    ////csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE;
   public Object visitNotfmla(@org.antlr.v4.runtime.misc.NotNull LogicalFmlasParser.NotfmlaContext ctx) {
        FOFVisitor fofvisitor = new FOFVisitor();

        if (ctx.gb != null) {
            return new Abstract_Guard(new Abstract_GBelief(new Abstract_Literal((Abstract_Predicate) fofvisitor.visitPred(ctx.gb))));
        }

        //if (ctx.eq != null) {
        //    return (Abstract_LogicalFormula) visitEquation(ctx.eq);
        //}

        if (ctx.gb2 != null) {
            return new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal((Abstract_Predicate) fofvisitor.visitPred(ctx.gb2))));
        }

        //if (ctx.eq2 != null) {
        //    return new Abstract_LogExpr(Abstract_LogExpr.not, (Abstract_LogicalFormula) visitEquation(ctx.eq2));
        //}

        //if (ctx.cut != null) {
        //    return new Abstract_PrologCut();
        //}

        return new Abstract_Guard(Abstract_Guard.not, (Abstract_GBelief) visitSubfmla(ctx.lf));

    }

    //	subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE;
    public Object visitSubfmla(@org.antlr.v4.runtime.misc.NotNull LogicalFmlasParser.SubfmlaContext ctx) {
        return visitLogicalfmla(ctx.lf);
    }


    @Override public Object visitEass_plan(@NotNull EASSParser.Eass_planContext ctx) {
        GwendolenAILVisitor gwenvisitor = new GwendolenAILVisitor();

        EASSParser.EventContext e_ctx = ctx.event();
        CharStream e_tokens = e_ctx.start.getInputStream();
        String e_orig = e_tokens.getText(new Interval(e_ctx.start.getStartIndex(), e_ctx.stop.getStopIndex()));
        GwendolenParser e_parser = gwenparser(e_orig, GwendolenLexer.PLANS_MODE);
        GwendolenParser.EventContext g_e_ctx = e_parser.event();
        Abstract_Event event = (Abstract_Event) gwenvisitor.visitEvent(g_e_ctx);

        List<EASSParser.Guard_atomContext> ga_ctxs = ctx.guard_atom();
        Abstract_Guard guard = new Abstract_Guard();
        for (EASSParser.Guard_atomContext ga_ctx: ga_ctxs) {
            CharStream tokens = ga_ctx.start.getInputStream();
            String originalText = tokens.getText(new Interval(ga_ctx.start.getStartIndex(), ga_ctx.stop.getStopIndex()));
            // Need this next bit for MASQuickTests to work
            String guardText = "{" + originalText + "}";

            GwendolenParser gparser = gwenparser(guardText, GwendolenLexer.PLANS_MODE);
            GwendolenParser.Guard_atomContext g_ga_ctx = gparser.guard_atom();
            boolean gneg = true;
            if (g_ga_ctx.NOT() != null) {
                gneg = false;
            }

            guard.add((Abstract_GLogicalFormula) gwenvisitor.visitGuard_atom(g_ga_ctx), gneg);
        }

        ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>();
        List<EASSParser.Eass_deedContext> d_ctxs = ctx.eass_deed();
        for (EASSParser.Eass_deedContext d_ctx: d_ctxs) {
            deeds.add((Abstract_Deed) visitEass_deed(d_ctx));
        }

        Abstract_GPlan p = new Abstract_GPlan(event, guard, deeds);
        p.reverseBody();
        variables.clear();
        return p;
    }

    //	deed[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d] : (((PLUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, $l.l);} |
//					SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILAddition, $g.g);} |
//					LOCK {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);}|
//					PLAN OPEN p=pred CLOSE {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.DPlan, $p.t);}) |
//				   MINUS (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, $l.l);} |
//					SHRIEK g=goal {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, $g.g);} |
//					LOCK {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);} |
//					PLAN OPEN p=pred CLOSE {$d = new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.DPlan, $p.t);}
//					)) |
//					UPDATE (l=literal {$d = new Abstract_Deed(Abstract_Deed.AILUpdate, Abstract_Deed.AILBel, $l.l);}) |
//					CALCULATE c=calculation[ds]  {$d = $c.d;}|
//					QUERYCOM q=query[ds] {$d = $q.d;}	|
//					WAIT w=wait[ds] {$d = $w.d;}	|
//					a=action {$d = new Abstract_Deed($a.a);}) |
//					wf=waitfor {$d = new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $wf.wf);} |
//					SUBSTITUTE s=substitution[ds] {$d = $s.d;}
//					)
//					;
    @Override
    public Object visitEass_deed(EASSParser.Eass_deedContext ctx) {
        GwendolenAILVisitor gwenvisitor = new GwendolenAILVisitor();
        if (ctx.PLUS() != null) {
            if (ctx.SHRIEK() != null) {
                GwendolenParser g_parser = gwenparser(ctx.g.getText(), GwendolenLexer.PLANS_MODE);
                GwendolenParser.GoalContext g_ctx = g_parser.goal();
                return new Abstract_Deed(Abstract_Deed.AILAddition, (Abstract_Goal) gwenvisitor.visitGoal(g_ctx));
            } else if (ctx.LOCK() != null) {
                return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dlock);
            } else {
                LogicalFmlasParser fofparser = fofparser(ctx.l.getText());
                FOFVisitor fofvisitor = new FOFVisitor();
                return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.AILBel, (Abstract_Literal) fofvisitor.visitLiteral(fofparser.literal()));
            }
        } else if (ctx.MINUS() != null) {
            if (ctx.SHRIEK() != null) {
                GwendolenParser g_parser = gwenparser(ctx.g.getText(), GwendolenLexer.PLANS_MODE);
                GwendolenParser.GoalContext g_ctx = g_parser.goal();
                return new Abstract_Deed(Abstract_Deed.AILDeletion, (Abstract_Goal) gwenvisitor.visitGoal(g_ctx));
            } else if (ctx.LOCK() != null) {
                return new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.Dlock);
            } else {
                LogicalFmlasParser fofparser = fofparser(ctx.l.getText());
                FOFVisitor fofvisitor = new FOFVisitor();
                return new Abstract_Deed(Abstract_Deed.AILDeletion, Abstract_Deed.AILBel, (Abstract_Literal) fofvisitor.visitLiteral(fofparser.literal()));
            }
        } else if (ctx.QUERYCOM() != null) {
            return new Abstract_Deed((Abstract_Action) visitQuery(ctx.q));
        } if (ctx.wf != null) {
            GwendolenParser g_parser = gwenparser(ctx.wf.getText(), GwendolenLexer.PLANS_MODE);
            GwendolenParser.WaitforContext wf_ctx = g_parser.waitfor();
                return new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, (Abstract_Literal) gwenvisitor.visitWaitfor(wf_ctx));
        } else {
            GwendolenParser g_parser = gwenparser(ctx.a.getText(), GwendolenLexer.PLANS_MODE);
            GwendolenParser.ActionContext a_ctx = g_parser.action();
                return new Abstract_Deed((Abstract_Action) gwenvisitor.visitAction(a_ctx));
        }
    }


    public Object visitQuery(EASSParser.QueryContext ctx) {
        LogicalFmlasParser fof = fofparser(ctx.l1.getText());
        FOFVisitor fofvisitor = new FOFVisitor();
        Abstract_Predicate query_body = (Abstract_Predicate) fofvisitor.visitPred(fof.pred());
        Abstract_Predicate query = new Abstract_Predicate("query");
        query.addTerm(query_body);
        return new Abstract_Action(query);

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
