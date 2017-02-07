// ----------------------------------------------------------------------------
// Copyright (C) 2015 Louise A. Dennis, and Michael Fisher
//
// This file is part of GOAL (AIL version) - GOAL-AIL
//
// GOAL-AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
//
// GOAL-AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with GOAL-AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

grammar GOAL;


@header {
package goal.parser;

import ail.syntax.ast.*;
import ail.syntax.DefaultAILStructure;
import goal.syntax.ActionRule;
import goal.syntax.GOALSendAction;
import goal.syntax.ast.*;
import ail.syntax.PredicateIndicator;
import java.util.HashMap;
}

@lexer::header {
package goal.parser;
}

@members {
private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
private static HashMap<PredicateIndicator,Abstract_MentalState> macros = new HashMap<PredicateIndicator, Abstract_MentalState>();
private static HashMap<PredicateIndicator,Abstract_Term> macro_subs = new HashMap<PredicateIndicator, Abstract_Term>();
private String name = "";
}


mas returns [Abstract_MAS mas] 
	: {$mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();}
	// MAIN COLON i=id CURLYOPEN
	{ Abstract_GOALAgent gl = new Abstract_GOALAgent("goal_agent"); agents.add(gl);}
	(moduleImport | gm=module {gl.addModule(gm);})+
	// CURLYCLOSE
	{mas.setAgs(agents);}
	;

goalagent returns [Abstract_GOALAgent gl] 
	: { $gl = new Abstract_GOALAgent("goal_agent");}
	(moduleImport | gm=module {gl.addModule(gm);})+;

moduleImport
	: '#import' MODULEFILE STOP
	;

module returns [Abstract_GOALModule gl]
	: def=moduleDef {$gl = new Abstract_GOALModule(def);} (SQOPEN moduleOption[gl] (COMMA moduleOption[gl])* SQCLOSE)?
	CURLYOPEN krImport? knowledge[gl] ? beliefs[gl]? goals[gl]? program[gl]? 
	(as=actionSpecs {$gl.addAllCap(as);})? 
	CURLYCLOSE
	;

moduleDef returns [Abstract_ModuleDef i]
	: MODULE d=declaration {$i = new Abstract_ModuleDef(d);}
	| INIT MODULE {$i = Abstract_GOALModule.init;}
	| MAIN MODULE {$i = Abstract_GOALModule.main;}
	| EVENT MODULE {$i = Abstract_GOALModule.event;}
	;


moduleOption [Abstract_GOALModule gl]
	: key= 'exit' EQUALS value = ('always' {gl.setExitCondition(Abstract_GOALModule.always);} 
			| 'never' {gl.setExitCondition(Abstract_GOALModule.never);} 
			| 'nogoals' {gl.setExitCondition(Abstract_GOALModule.nogoals);} 
			 | 'noaction' {gl.setExitCondition(Abstract_GOALModule.noaction);} ) 
	| key = 'focus' EQUALS value = ('none' | 'new' | 'select' | 'filter')
	;

krImport
	: '#import' (stringLiteral | singleQuotedStringLiteral) STOP
	;

knowledge [Abstract_GOALModule gl]
	: KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE;


krspec[Abstract_GOALModule gl]: (hd=declarationOrCallWithTerms
	(STOP {$gl.addFact((Abstract_Predicate) hd);} |
	PROLOGARROW ( body=no_bracket_literals | body=forall_expr)  STOP {$gl.addKRule(new Abstract_Rule((Abstract_Predicate) hd, body));}))+;
	
beliefs [Abstract_GOALModule gl]
	: BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE;


brspec[Abstract_GOALModule gl]: (hd=declarationOrCallWithTerms
	(STOP {$gl.addBel((Abstract_Predicate) hd);} |
	PROLOGARROW body=no_bracket_literals STOP {$gl.addRule(new Abstract_Rule((Abstract_Predicate) hd, body));}))+;


goals [Abstract_GOALModule gl]
	: GOALS CURLYOPEN le=goal_list {gl.addGoal(le);} CURLYCLOSE;
	
atom returns [Abstract_LogicalFormula l]
	: NOT OPEN ( p=declarationOrCallWithTerms{$l = new Abstract_LogExpr(Abstract_LogExpr.not, p);} 
		| e=equation {$l= new Abstract_LogExpr(Abstract_LogExpr.not, e);} ) CLOSE
	| p=notnot_declarationOrCallWithTerms {$l=p;}
	| e=equation {$l = e;}
	;


program[Abstract_GOALModule gl]
	: PROGRAM (SQOPEN i=ruleEvaluationOrder {$gl.setOptionOrder(i);} SQCLOSE)? 
	CURLYOPEN macroDef* (rule = programRule {gl.addPlan(rule);})* CURLYCLOSE
	;


ruleEvaluationOrder returns [int i] 
	: ORDER EQUALS ( LINEAR {$i=Abstract_GOALModule.linear;} |
	LINEARALL {$i=Abstract_GOALModule.linearall;}|
	RANDOM {$i=Abstract_GOALModule.random;}|
	RANDOMALL {$i=Abstract_GOALModule.randomall;} |
	ADAPTIVE {$i = Abstract_GOALModule.adaptive;})
	;

macroDef
	: HASH DEFINE p=declarationOrCallWithTerms
	msc=mentalstatecond {PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize()); macros.put(pi, msc);
	macro_subs.put(pi, p);} 
	STOP;


programRule returns [Abstract_ActionRule rule]
	:{rule = new Abstract_ActionRule();}
	(IF lf=mentalstatecond {rule.setMentalStateCond(lf);} THEN ( dl=actions {rule.setBody(dl);} STOP | nestedRules[rule]  )
	| FORALL {rule.setType(ActionRule.foralldo);} lf=mentalstatecond {rule.setMentalStateCond(lf);} DO (dl=actions {rule.setBody(dl);} STOP | nestedRules[rule] )
	| 'listall' {rule.setType(ActionRule.listalldo);} v=var '<-' ms=mentalstatecond {rule.setMentalStateCond(new Abstract_MentalState(v, ms));} 
		DO (dl=actions  {rule.setBody(dl);} STOP | nestedRules[rule]  )
	| 'listall' mentalstatecond '->' var DO (actions STOP | nestedRules[rule]  ))
	;

nestedRules[Abstract_ActionRule rule]
	: CURLYOPEN {ArrayList<Abstract_ActionRule> rules = new ArrayList<Abstract_ActionRule>();} (r=programRule {rules.add(r);})+ {rule.merge(rules);}CURLYCLOSE
	;


mentalstatecond returns [Abstract_MentalState lf]
	: ma=basicCondition {Abstract_MentalState ms =  ma;}
	(COMMA ms2=basicCondition {ms = new Abstract_MentalState(ms, Abstract_Guard.and, ms2);})*
	{$lf = ms;};
	
mentalstate returns [Abstract_MentalState ms]
	: ma=mentalatom {$ms = new Abstract_MentalState(ma);}
	| NOT OPEN nma=mentalatom {nma.negate(); $ms = new Abstract_MentalState(nma);} CLOSE
	| TRUE {$ms = new Abstract_MentalState();}
		;

basicCondition returns [Abstract_MentalState ms]
	: ms1=mentalstate {$ms = ms1;}
	| p=declarationOrCallWithTerms {PredicateIndicator pi = new PredicateIndicator(p.getFunctor(), p.getTermSize());
		Abstract_MentalState macro=macros.get(pi);
		Abstract_Term sub=macro_subs.get(pi);
		Abstract_MentalState k = new Abstract_MentalState(macro, sub, p); $ms = k;
	}// macro
	;

mentalatom returns [Abstract_MentalState ms]
	: 
	(selector STOP)? b=mentalOperator tl=atom_parameters
	{ if (b == Abstract_MentalAtom.agoal) {
	      Abstract_MentalAtom g = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILGoal);
	      Abstract_MentalAtom bl = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILBel);
	      $ms = new Abstract_MentalState(new Abstract_MentalState(g), Abstract_Guard.and, new Abstract_MentalState(Abstract_Guard.not, bl));
	   } else if (b == Abstract_MentalAtom.goala) {
	      Abstract_MentalAtom g = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILGoal);
	      Abstract_MentalAtom bl = new Abstract_MentalAtom(tl, Abstract_BaseAILStructure.AILBel);
	      $ms = new Abstract_MentalState(new Abstract_MentalState(g), Abstract_Guard.and, new Abstract_MentalState(bl));
	   } else {$ms= new Abstract_MentalState(new Abstract_MentalAtom(tl, b));}
	 } 
	;

atom_parameters returns [Abstract_LogExpr ts] 
	: OPEN ( 
	 t=atom {Abstract_LogExpr tl = new Abstract_LogExpr(Abstract_LogExpr.none, t);}
	(COMMA  ( t1=atom {tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  t1);}
		| ap=atom_parameters {tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  ap);})
	| SEMI  (t1 = atom {tl = new Abstract_LogExpr(tl, Abstract_LogExpr.or,  t1);}
		| ap=atom_parameters {tl = new Abstract_LogExpr(tl, Abstract_LogExpr.and,  ap);})
	)*  { $ts = tl;}
	|  ap=atom_parameters {$ts = ap;}  )
	CLOSE
	;
	

mentalOperator returns [byte b]
	: op = BEL {b = Abstract_BaseAILStructure.AILBel;}
	| op = GOAL {b = Abstract_BaseAILStructure.AILGoal;}
	| op = AGOAL {b = Abstract_MentalAtom.agoal;}
	| op = GOALA {b = Abstract_MentalAtom.goala;}
	;

actions returns [ArrayList<Abstract_Deed> dl]
	: {$dl = new ArrayList<Abstract_Deed>();} 
	a=action {$dl.add(a);} 
	(PLUS a1=action {$dl.add(a1);})*
	;

action returns [Abstract_Deed d]
	: {boolean receiver = false; Abstract_Term r= new Abstract_StringTermImpl(); ArrayList<Abstract_Term> l = new ArrayList<Abstract_Term>();} (sel=selector STOP {receiver=true; r=sel;})? 
	                   d1=actionOperator tl=parameters 
	                   {if (receiver) {l.add(r);}; l.addAll(tl); d1.addParams(l); $d=d1;}

	| op = 'exit-module'
	| op = 'log'
	| op = INIT
	| op = MAIN
	| op = EVENT
	| p=not_action_opdeclarationOrCallWithTerms {d = new Abstract_Deed(new Abstract_UserSpecOrModuleCall(p));}
	;

actionOperator returns [Abstract_Deed d]
	: op = 'adopt' {d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILGoal);}
	| op = DROP {d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILGoal);}
	| op = INSERT {d = new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, Abstract_BaseAILStructure.AILBel);}
	| op = 'delete'  {d = new Abstract_Deed(Abstract_BaseAILStructure.AILDeletion, Abstract_BaseAILStructure.AILBel);}
	| op = 'send' {d = new Abstract_Deed(new Abstract_GOALSendAction(GOALSendAction.SEND));}
	| op = 'sendonce' {d = new Abstract_Deed(new Abstract_GOALSendAction(GOALSendAction.SENDONCE));}
	| op = 'print' {d = new Abstract_Deed(new Abstract_PrintAction());}
	| op = 'log'
	;


selector returns [Abstract_Term s]
	: v = var  {s = v;}
	| CONST {s = new Abstract_StringTermImpl($CONST.getText());}
	| op = 'all' {s = new Abstract_NumberTermImpl(0);}
	| op = 'allother' {s = new Abstract_NumberTermImpl(1);}
	| op = 'self' {s = new Abstract_NumberTermImpl(2);}
	| op = 'some' {s = new Abstract_NumberTermImpl(3);}
	| op = 'someother' {s = new Abstract_NumberTermImpl(4);}
	| op = 'this' {s = new Abstract_NumberTermImpl(5);}
	;

actionSpecs returns [ArrayList<Abstract_ActionSpec> as] 
	: {as = new ArrayList<Abstract_ActionSpec>();}
	ACTIONSPEC CURLYOPEN (a=actionSpec {as.add(a);})+ CURLYCLOSE
	;

actionSpec returns [Abstract_ActionSpec as]
	: {boolean internal=false;} cap=declarationOrCallWithTerms (INTERNAL {internal = true;} | EXTERNAL)? 
	CURLYOPEN pre=precondition post=postcondition CURLYCLOSE
	{as = new Abstract_ActionSpec(cap, pre, post, internal);}
	;

precondition returns [Abstract_LogicalFormula f]
	: PRE CURLYOPEN  (TRUE  {f = new Abstract_LogExpr();}
	| tl=no_bracket_literals {f = new Abstract_LogExpr(tl);}
	| fe = forall_expr {f = new Abstract_LogExpr(fe);}
	| ap = atom_parameters {f = ap;} ) CURLYCLOSE
	;

postcondition returns [Abstract_LogicalFormula f]
	: POST  CURLYOPEN
	(TRUE  {f = new Abstract_LogExpr();}
	| tl=no_bracket_literals {
		f = new Abstract_LogExpr(tl);}
		)
	CURLYCLOSE
	;

declaration returns [Abstract_Predicate p]
	: f=id {p= new Abstract_Predicate(f);} (tl=parameters {p.setTerms(tl);})?
	;

declarationOrCallWithTerms returns [Abstract_Predicate p]
	: f=nested_function_term {p = (Abstract_Predicate) f;}
	;
	
notnot_declarationOrCallWithTerms returns [Abstract_Predicate p]
	: f=notnot_function_term {p = (Abstract_Predicate) f;}
	;
	
not_action_opdeclarationOrCallWithTerms returns [Abstract_Predicate p]
	: f=not_action_opfunction_term {p = (Abstract_Predicate) f;}
	;

id returns [String s] 
	: (CONST {$s = $CONST.getText();}
	| VAR {$s = $VAR.getText();})
	; 
	
	
not_action_opparameters returns [ArrayList<Abstract_Term>ts] 
	: OPEN {boolean negated=false;} ( NOT {negated = true;} OPEN t=not_action_opterm CLOSE |
	t=toplevelterm )
		{ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); 
		if (negated) {Abstract_Literal l = new Abstract_Literal((Abstract_Predicate) t);
		l.setNegated(negated); 
		t=l;}
		tl.add(t);}
	(COMMA {negated = false;} ( NOT {negated = true;} OPEN t1=not_action_opterm CLOSE |
	t1 = toplevelterm) {
	if (negated) {Abstract_Literal l1 = new Abstract_Literal((Abstract_Predicate) t1); l1.setNegated(negated); t1=l1;}
	 tl.add(t1);})* 
	CLOSE { $ts = tl;}
	;

parameters returns [ArrayList<Abstract_Term>ts] 
	: OPEN  {ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); } (i=ilf {tl.add(new Abstract_NumberTermImpl(i));})? t=term 
		{tl.add(t);}
	(COMMA t1=term  {tl.add(t1);})* 
	CLOSE { $ts = tl;}
	;
	
no_bracket_parameters returns [ArrayList<Abstract_Term>ts] 
	:  t=term {ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);}
	(COMMA t1=term {tl.add(t1);})* 
	{ $ts = tl;}
	;

no_bracket_literals returns [ArrayList<Abstract_LogicalFormula>ts] 
	:  {ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();}
	 t=atom { tl.add(t);}
	(COMMA  t1 = atom {tl.add(t1);})* 
	{ $ts = tl;}
	;



goal_list returns [ArrayList<ArrayList<Abstract_Term>>ts] 
	: {ArrayList<ArrayList<Abstract_Term>> tll = new ArrayList<ArrayList<Abstract_Term>>();}
	(t=term  {ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);}
	(COMMA t1=term {tl.add(t1);})*  STOP {tll.add(tl);})+
	 { $ts = tll;}
	;


// GOAL keywords
MAIN	: 'main';
MODULEFILE :  '.mod2g';
KNOWLEDGE	: 'knowledge';
BELIEFS	: 'beliefs';
GOALS 	: 'goals';
EVENT 	: 'event';
INIT 	: 'init';
ACTIONSPEC
	: 'actionspec';
MODULE 	: 'module';
PROGRAM	: 'program';
PROLOGARROW
	: ':-';
NOT	 : 'not';
ORDER 	:'order';
EQUALS 	: '=';
LINEAR 	: 'linear';
LINEARALL
	: 'linearall';
RANDOM 		: 'random';
RANDOMALL
	: 'randomall';
ADAPTIVE	: 'adaptive';
DEFINE 	: 'define';
IF 	: 'if';
DO 	: 'do' ; 
THEN 	: 'then';
TRUE 	: 'true';
BEL 	: 'bel' ;
GOAL 	: 'goal';
AGOAL 	: 'a-goal';
GOALA 	: 'goal-a';
PRE 	: 'pre';
POST 	: 'post';
PLUS 	: '+';
INTERNAL 	: '@int';
EXTERNAL  : '@ext';
DROP	: 'drop';
INSERT	: 'insert';
FORALL	: 'forall';

// term syntax
term returns [Abstract_Term t] 
	: (st=stringterm {$t = st;} 
	| ft=nested_function_term {$t=ft;} 
	| at=arithexpr {$t=at;}
	| lt=listterm {$t=lt;});
	
ilf returns [int i]	:'?' {$i = 1;} | '!' {$i = 2;} | ':' {$i = 3;};
	
toplevelterm returns [Abstract_Term t] 
	: (st=stringterm {$t = st;} 
	| ft=function_term {$t=ft;} 
	| at=arithexpr {$t=at;}
	| lt=listterm {$t=lt;});


notnotterm returns [Abstract_Term t]
	: (st=stringterm {$t = st;} 
	| ft=notnot_function_term {$t=ft;} 
	| at=arithexpr {$t=at;}
	| lt=listterm {$t=lt;});
	
not_action_opterm returns [Abstract_Term t]
	: (st=stringterm {$t = st;} 
	| ft=not_action_opfunction_term {$t=ft;} 
	| at=arithexpr {$t=at;}
	| lt=listterm {$t=lt;});

function_term returns [Abstract_Predicate t] : 
	 c=CONST {t=new Abstract_Predicate(c.getText());}
	(OPEN (  t1=term {((Abstract_Predicate) t).addTerm($t1.t);} )
	(COMMA (  t2=term  {((Abstract_Predicate) t).addTerm($t2.t);}))* CLOSE)?
	;
	
notnot_function_term returns [Abstract_Predicate t] : 
		( c=CONST {t=new Abstract_Predicate(c.getText());} 
		| s=notnot_goalkeywordsappearinginprolog {t=new Abstract_Predicate(s);}
		)
	(OPEN (  t1=term {((Abstract_Predicate) t).addTerm($t1.t);}) 
	(COMMA (   t2=term {((Abstract_Predicate) t).addTerm($t2.t);}))* CLOSE)?
	;

not_action_opfunction_term returns [Abstract_Term t] 
	: (c=CONST {t=new Abstract_Predicate(c.getText());} | s=not_action_opgoalkeywordsappearinginprolog {t=new Abstract_Predicate(s);})
	(OPEN ( t1=term {((Abstract_Predicate) t).addTerm($t1.t);} )
	(COMMA(  t2=term {((Abstract_Predicate) t).addTerm($t2.t);}))* CLOSE)?
	;

	

nested_function_term returns [Abstract_Term t] 
	: (c=CONST {t=new Abstract_Predicate(c.getText());} | s=goalkeywordsappearinginprolog {t=new Abstract_Predicate(s);})
	(OPEN (  t1=term {((Abstract_Predicate) t).addTerm($t1.t);} )
	(COMMA (  t2=term {((Abstract_Predicate) t).addTerm($t2.t);}))* CLOSE)?
	;

goalkeywordsappearinginprolog returns [String s]
	:	(NOT {s = "not";} | DROP {s="drop";}| INSERT {s = "insert";});

notnot_goalkeywordsappearinginprolog returns [String s]
	:	(DROP {s="drop";}| INSERT {s = "insert";});
	
not_action_opgoalkeywordsappearinginprolog returns [String s]
	:	(NOT {s = "not";});


var returns [Abstract_VarTerm v] 
	: (VAR {if (variables.containsKey($VAR.getText())) {
		$v = variables.get($VAR.getText());
	            } else {
		$v = new Abstract_VarTerm($VAR.getText());
                                                     variables.put($VAR.getText(), $v);
	           }
	} | UNNAMEDVAR {$v=new Abstract_UnnamedVar();});

stringLiteral returns [Abstract_StringTerm s]
	: st=stringterm {$s = st;};
singleQuotedStringLiteral returns [Abstract_StringTerm s]
	: SINGLEQUOTE w=word SINGLEQUOTE {s = new Abstract_StringTermImpl($w.s);}
	;	
stringterm returns [Abstract_StringTerm s]
	: STRING  {String str = $STRING.getText();s=new Abstract_StringTermImpl(str.substring(1,str.length()-1));};


word returns [String s] : (CONST {$s=$CONST.getText();} | VAR {$s=$VAR.getText();});

listterm returns [Abstract_ListTermImpl l]
 	: {$l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = $l;}
 	SQOPEN (h=term {$l.addHead($h.t); $l.addTail(new Abstract_ListTermImpl());}
 	(COMMA t=term {Abstract_ListTerm l2 = new Abstract_ListTermImpl(); l2.addHead($t.t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;})*
 	(BAR v=var {lrunning.addTail($v.v);})? )? 
 	SQCLOSE
 	;

equation returns [Abstract_Equation e]
	: ( a1=arithexprg i=eqoper a2=arithexpr {e = new Abstract_Equation(a1, i, a2);} ) |
	   (v=var ( EQUALS | IS)  (a2=arithexpr {e = new Abstract_Equation(v, 2, a2);} | 
	   	(ft=notnot_function_term {e = new Abstract_Equation(v, 3, ft);} 
	   	| st=stringterm {e = new Abstract_Equation(v, 3, st);}
	   	| lt = listterm {e = new Abstract_Equation(v, 3, lt);})))
	;
forall_expr returns [ArrayList<Abstract_LogicalFormula> ts]
	:	 {ArrayList<Abstract_LogicalFormula> tl = new ArrayList<Abstract_LogicalFormula>();}
	FORALL OPEN t1=atom COMMA t2=atom {Abstract_LogExpr l = new Abstract_LogExpr(t1, Abstract_LogExpr.forall, t2); tl.add(l);} CLOSE
	{ $ts = tl;}
	;
	

numberstring returns [String s]
	: {$s = "";} (MINUS {$s += "-";})? 
	(n1=NUMBER {$s += $n1.getText();}
	(STOP {$s += ".";} n2=NUMBER {$s += $n2.getText();})?);

arithexpr returns [Abstract_NumberTerm ae]
	: a1=multexpr {$ae = a1;} (i=addoper a2=multexpr {$ae = new Abstract_ArithExpr($ae, $i.i, a2);})?;
multexpr returns [Abstract_NumberTerm ae]
	: a1=atom_term{$ae = a1;} (i=multoper a2=atom_term {ae = new Abstract_ArithExpr($ae, $i.i, a2);})?;

atom_term returns [Abstract_NumberTerm t]
	: (n = numberstring {$t = new Abstract_NumberTermImpl($n.s);} | v=var {$t = $v.v;})
	;
	
arithexprg returns [Abstract_NumberTerm ae]
	: a1=multexprg {$ae = a1;} (i=addoper a2=multexpr {$ae = new Abstract_ArithExpr($ae, $i.i, a2);})?;
multexprg returns [Abstract_NumberTerm ae]
	: a1=atom_termg{$ae = a1;} (i=multoper a2=atom_term {ae = new Abstract_ArithExpr($ae, $i.i, a2);})?;

atom_termg returns [Abstract_NumberTerm t]
	: n = numberstring {$t = new Abstract_NumberTermImpl($n.s);} 
	;


addoper returns [int i]
	: (PLUS {$i = 1;} | MINUS {$i = 2;} );
multoper returns [int i]
	: (MULT {$i = 3;} | DIV {$i = 4;} );
eqoper returns [int i] : (LESS {$i = 1;} | (IS | EQUALS) {$i = 2;});

// Lexer Misc Syntax
COLON 	: ':';
CURLYOPEN	: '{';
CURLYCLOSE
	:'}';
STOP 	: '.' ;
COMMA 	: ',';
SEMI	:';';
OPEN 	: '(';
CLOSE 	: ')';
SQOPEN 	: '[';
SQCLOSE 	: ']';
HASH	: '#';
SINGLEQUOTE
	: '\'';
BAR 	: '|';

IS	:	 'is';
CONST : 'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR : 'A'..'Z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
UNNAMEDVAR
	:	'_';
STRING	:	('"')('a'..'z'|'A'..'Z'|','|' '|'!'|'0'..'9'|'-'|'.'|':'|';'|'?'|'\'')+('"');
NUMBER : '0'..'9' ('0'..'9')*;

MINUS : '-';
MULT : '*';
DIV : '/';
LESS : '<';

COMMENT
: '/*' .* '*/' {$channel=HIDDEN;}
;
LINE_COMMENT
: ('//'|'%') ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
;
NEWLINE:'\r'? '\n' {skip();} ;
WS : (' '|'\t')+ {skip();} ;
