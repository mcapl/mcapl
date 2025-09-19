// ----------------------------------------------------------------------------
// Copyright (C) 2024 Louise A. Dennis
//
// This file is part of the Engineering Autonomous Space Software (EASS) Library.
//
// The EASS Library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
//
// The EASS Library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with the EASS Library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// To contact the authors:
// http://www.cs.man.ac.uk/~dennisl/index.html
//
//----------------------------------------------------------------------------

grammar EASS;

options { tokenVocab = EASSLexer; }

import Gwendolen;

mas  : glist=eassagents;

eassagents : EASS (g=eassagent)+;


//eassagent returns [Abstract_EASSAgent g] :
//	(NAME w=word {try {$g = new Abstract_EASSAgent($w.s);} catch (Exception e) {System.err.println(e);}
//	              agentname = new Abstract_StringTermImpl($w.s);} |
//	ABSTRACTION w=word {String s = "abstraction_" + $w.s; $g = new Abstract_EASSAgent(s); g.setAbstraction($w.s);}
//				)
//	BELIEFS (l=literal {$g.addInitialBel($l.l);})*
//	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
//	(CAPABILITIES (c=capability {$g.addCap($c.c);})*)?
//	GOALS (gl=goal {$g.addInitialGoal($gl.g);})*
//	PLANS (p=plan {try {$g.addPlan($p.p);} catch (Exception e) {System.err.println(e);}})*
//	;
// Gwendolen Agent stuff
eassagent :  (EASS?)
	(NAME | NAME_PM | ABSTRACTION) w=CONST
	// BELIEF_BLOCKS should all be litlists from LogicalFmlas grammar
	BELIEFS (bs=BELIEF_BLOCK)*
	// RR_BLOCKS should be rulelists from LogicalFmlas grammar
	(BELIEFRULES (RR_NEWLINE)* (rr=RR_BLOCK)* )?
	((CAP_IB | CAP_RR) (CAP_NEWLINE)* (cap=capability)*)?
	(GOAL_IB | GOAL_RR | GOAL_C) (gs=initial_goal)*
	PLANS (p=eass_plan)+;


capability :
    	CAP_CURLYOPEN pre=CAP_BLOCK CAP_CURLYCLOSE
    	cap=CAP_BLOCK
    	CAP_CURLYOPEN post=CAP_BLOCK  CAP_CURLYCLOSE;

//clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
//               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*;
 //cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} |
//                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} |
//                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
//csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE;


//plan returns [Abstract_GPlan p]
//	: e=event  {ArrayList<Abstract_Deed> deeds=new ArrayList<Abstract_Deed>(); Abstract_Guard g = new Abstract_Guard();}
//		COLON CURLYOPEN {boolean gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);}
//		(COMMA {gneg=true;} (NOT {gneg=false;})? gb=guard_atom {g.add($gb.g, gneg);})* CURLYCLOSE (RULEARROW
//	d=deed[deeds] {deeds.add($d.d);} (COMMA d=deed[deeds] {deeds.add($d.d);})*)?
//	SEMI {$p = new Abstract_GPlan($e.e, g, deeds); $p.reverseBody(); variables.clear();};

eass_plan :
    e=event
    		COLON CURLYOPEN  gb=guard_atom  (COMMA  gb=guard_atom )* CURLYCLOSE
    		(RULEARROW
    		 d=eass_deed  (COMMA d=eass_deed )*)?
    		SEMI ;

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

eass_deed  : (
			((PLUS (l=fof_expr  | SHRIEK g=goal | LOCK))
				|
			(MINUS (l=fof_expr  | SHRIEK g=goal | LOCK)))
				|
//			UPDATE (l=fof_expr) |
//			CALCULATE c=calculation |
			QUERYCOM q=query |
//			WAIT w=wait |
			a=action |
			wf=waitfor |
//			SUBSTITUTE s=substitution
		);

//substitution[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN pl1=pred COMMA c1 = pred COMMA c2 =pred COMMA pl2 = pred CLOSE
//	{Abstract_Action a = new Abstract_Action("substitute"); a.addTerm($pl1.t); a.addTerm($c1.t); a.addTerm($c2.t); a.addTerm($pl2.t); $d = new Abstract_Deed(a);};

//substitution: OPEN pl1=fof_expr COMMA c1=fof_expr COMMA c2=fof_expr COMMA pl2=fof_expr CLOSE;

//calculation[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN l1 = literal COMMA v=var CLOSE
//	{Abstract_Action a = new Abstract_Action("calculate"); a.addTerm($l1.l); a.addTerm(new Abstract_VarTerm("NewVarForCalculate")); ds.add(new Abstract_Deed(a));
//	Abstract_Literal wf = new Abstract_Literal("result"); wf.addTerm($l1.l); wf.addTerm($v.v); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
//	Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); $d = new Abstract_Deed(rs);};

//calculation: OPEN l1=fof_expr COMMA v=fof_expr CLOSE;

//query[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN l1 = literal  CLOSE
//	{Abstract_Action a = new Abstract_Action("query"); a.addTerm($l1.l); ds.add(new Abstract_Deed(a));
//	ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, $l1.l));
//	Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm($l1.l); $d = new Abstract_Deed(rs);};

query: OPEN l1=fof_expr CLOSE;

//wait[ArrayList<Abstract_Deed> ds] returns [Abstract_Deed d]	: OPEN l1 = term COMMA l2=literal CLOSE
//	{Abstract_Action a = new Abstract_Action("wait"); a.addTerm($l1.t); a.addTerm($l2.l); ds.add(new Abstract_Deed(a));
//	Abstract_Literal wf = new Abstract_Literal("waited"); wf.addTerm($l2.l); ds.add(new Abstract_Deed(Abstract_Deed.AILAddition, Abstract_Deed.Dwaitfor, wf));
//	Abstract_Action rs = new Abstract_Action("remove_shared"); rs.addTerm(wf); $d = new Abstract_Deed(rs);};

//wait: OPEN l1=fof_expr COMMA l2=fof_expr CLOSE;