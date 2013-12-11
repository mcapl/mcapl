// ----------------------------------------------------------------------------
// Copyright (C) 2013 Louise A. Dennis, and  Michael Fisher 
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
import goal.syntax.ast.*;
import ail.syntax.PredicateIndicator;
import java.util.HashMap;
}

@lexer::header {
package goal.parser;
}

@members {
	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
	private static HashMap<PredicateIndicator,Abstract_LogicalFormula> macros = new HashMap<PredicateIndicator, Abstract_LogicalFormula>();
	private static HashMap<PredicateIndicator,Abstract_Term> macro_subs = new HashMap<PredicateIndicator, Abstract_Term>();
	private String name = "";
}

@lexer::members {
}

// GOAL Grammar from Programming Rational Agents in GOAL by Koen Hindriks.
program returns [Abstract_MAS mas]	:  {$mas = new Abstract_MAS(); ArrayList<Abstract_GOALAgent> agents = new ArrayList<Abstract_GOALAgent>();}   
	                 MAIN COLON i=id CURLYOPEN 
		{ Abstract_GOALAgent gl = new Abstract_GOALAgent($i.s); agents.add(gl);}
  	                (KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE)?
                                        (BELIEFS CURLYOPEN brspec[gl] CURLYCLOSE)?
                                        (GOALS CURLYOPEN poslitconj[gl]* CURLYCLOSE)?
                                         MAIN MODULE CURLYOPEN module[gl] CURLYCLOSE
                                         (EVENT MODULE CURLYOPEN module[gl] CURLYCLOSE)?
                                         (ACTIONSPEC CURLYOPEN actionspec[gl]+ CURLYCLOSE)?
                                              
                                         CURLYCLOSE
                                              {mas.setAgs(agents);};
                                   
module[Abstract_GOALAgent gl]	: (KNOWLEDGE CURLYOPEN krspec[gl] CURLYCLOSE)?
                             (GOALS CURLYOPEN poslitconj[gl]* CURLYCLOSE)?
                             PROGRAM (optionorder)? CURLYOPEN
                                 macro*
                                 actionrule[gl]+
                             CURLYCLOSE
                             (ACTIONSPEC CURLYOPEN actionspec[gl]+ CURLYCLOSE)?;
                             
krspec[Abstract_GOALAgent gl]:  (hd=atom {hd.setCategory(Abstract_BaseAILStructure.AILBel);} 
	(STOP {$gl.addFact(hd);} | 
	PROLOGARROW body=litconj STOP {$gl.addKRule(new Abstract_Rule(hd, body));}))+;
    
brspec[Abstract_GOALAgent gl]:  (hd=atom {hd.setCategory(Abstract_BaseAILStructure.AILBel);}  
	(STOP {$gl.addBel(hd);} | 
	PROLOGARROW body=litconj STOP {$gl.addRule(new Abstract_Rule(hd, body));}))+;
                                     
poslitconj[Abstract_GOALAgent gl]	: g=atom {$gl.addGoal(g.getContent());} (COMMA g1=atom{$gl.addGoal(g1.getContent());})* STOP;

litconj returns [Abstract_LogicalFormula f]: l=literal {$f = l;} (COMMA l1=literal {$f = new Abstract_LogExpr(l, Abstract_LogExpr.and, l1);})* ;

literal returns[Abstract_LogicalFormula l] : a=atom {l=a;} | (NOT OPEN a1=atom {l=new Abstract_LogExpr(Abstract_LogExpr.not, a1);} CLOSE);

atom returns [Abstract_GBelief t] : (s=id {Abstract_Predicate p =new Abstract_Predicate(s);}( tl=parameters {p.setTerms(tl); $t = new Abstract_GBelief(p);})? | e=equation {$t=e;});

parameters returns [Abstract_Term[\] ts]	: OPEN t=term {ArrayList<Abstract_Term> tl = new ArrayList<Abstract_Term>(); tl.add(t);} 
	(COMMA t1=term {tl.add(t1);})* CLOSE { $ts = (Abstract_Term[]) tl.toArray(new Abstract_Term[0]);};	

optionorder	: SQOPEN ORDER EQUALS ( LINEAR | LINEARALL | RANDOM | RANDOMALL ) SQCLOSE;

macro	: HASH DEFINE f=id pl=parameters msc=mentalstatecond {PredicateIndicator pi = new PredicateIndicator(f, pl.length); macros.put(pi, msc); 
                                  Abstract_Predicate p = new Abstract_Predicate(f); p.setTerms(pl); macro_subs.put(pi, p);} STOP;

actionrule[Abstract_GOALAgent gl]   	: {Abstract_ActionRule rule = new Abstract_ActionRule();} 
	IF (lf=mentalstatecond {rule.setMentalStateCond(lf);}|
		 f=id pl=parameters {PredicateIndicator pi = new PredicateIndicator(f, pl.length); Abstract_LogicalFormula macro=macros.get(pi); Abstract_Term sub=macro_subs.get(pi); Abstract_Unifier u=rule.getUnifier(f, pl, sub); Abstract_LogicalFormula k = macro.apply(u); rule.setMentalStateCond(k);} ) 
	THEN dl=actioncombo[gl] {rule.setBody(dl);} STOP {gl.addPlan(rule);};	

mentalstatecond returns [Abstract_LogicalFormula lf]
	: ml=mentalliteral {$lf = ml;} (COMMA ml2=mentalliteral {ml = new Abstract_LogExpr(ml, Abstract_LogExpr.and, ml2); $lf = ml;})*;	
	
mentalliteral returns [Abstract_LogicalFormula lf]
	: TRUE | ma=mentalatom {$lf = ma;} | NOT OPEN nma=mentalatom {$lf = new Abstract_LogExpr(Abstract_LogExpr.not, nma);} CLOSE;
	
mentalatom returns [Abstract_LogicalFormula lf]
	: BEL OPEN b=litconj  {b.setCategory(Abstract_BaseAILStructure.AILBel); $lf = b;} CLOSE | GOAL OPEN g=litconj {Abstract_Goal gl = new Abstract_Goal(g); $lf = gl;}CLOSE;
	

actionspec[Abstract_GOALAgent gl]: deed=action[gl] {Abstract_Goal goal = (Abstract_Goal) deed.getContent();} 
	CURLYOPEN PRE CURLYOPEN lf1=litconj CURLYCLOSE {Abstract_Guard guard = null;
		if (lf1 instanceof Abstract_GuardAtom) {
			guard = new Abstract_Guard((Abstract_GuardAtom) lf1);
		} else if (lf1 instanceof Abstract_LogExpr) {
			guard = new Abstract_Guard((Abstract_LogExpr) lf1, false);
		};
	}
	POST CURLYOPEN lf2=litconj CURLYCLOSE CURLYCLOSE {$gl.addPlan(new Abstract_ActionSpec(goal, guard, lf2));};

actioncombo[Abstract_GOALAgent gl] returns [ArrayList<Abstract_Deed> dl]
	: {$dl = new ArrayList<Abstract_Deed>();} a=action[gl] {$dl.add(a);} (PLUS a1=action[gl] {$dl.add(a1);})*;
	
action[Abstract_GOALAgent gl] returns [Abstract_Deed d]	: (deed=userdefaction {$d=deed;}| builtinaction {$d = new Abstract_Deed(Abstract_Deed.DNull);} | communication[gl] {$d = new Abstract_Deed(Abstract_Deed.DNull);}) ;

userdefaction returns [Abstract_Deed d]
	: f=id {Abstract_Predicate p = new Abstract_Predicate(f);} (pl=parameters {p.setTerms(pl);})+ {d=new Abstract_Deed(Abstract_BaseAILStructure.AILAddition, new Abstract_Goal(p, Abstract_Goal.performGoal));} ;
	
builtinaction
	: INSERT OPEN litconj CLOSE |
	 DELETE OPEN litconj CLOSE |
	  ADOPT OPEN litconj CLOSE |
	  DROP OPEN litconj CLOSE;
	  
communication[Abstract_GOALAgent gl] returns [Abstract_Deed d]
	: SEND OPEN id COMMA poslitconj[gl] CLOSE;
                                         
id returns [String s]	: (CONST {$s = $CONST.getText();}| VAR {$s = $VAR.getText();}); //| '_' | '$') (CONST | VAR | '_' | NUMBER | '$')*;	
                                                 
// GOAL keywords
MAIN: 'main';	
 KNOWLEDGE:	 'knowledge';   
 BELIEFS:	'beliefs';
 GOALS	:	'goals';
 EVENT	: 'event';
 ACTIONSPEC
 	: 'actionspec';
 MODULE	:	'module';
 PROGRAM: 'program';
 PROLOGARROW
 	:	':-';
 NOT	:	'not';
 ORDER	:'order';
 EQUALS	:	'=';
 LINEAR	:	'linear';
 LINEARALL
 	:	'linearall';
 RANDOM	:	'random';
 RANDOMALL
 	:	'randomall';
 DEFINE	:	'define';
 IF	:	'if';
 THEN	:	'then';
 TRUE	:	'true';
 BEL	:	'bel';
 GOAL	:	'a-goal';
 PRE	:	'pre';
 POST	:	'post';
 PLUS	:	'+';
 INSERT	:	'insert';
 DELETE	:	'delete';
 ADOPT	:	'adopt';
 DROP	:	'drop';
 SEND	:	'send';
 
 // term syntax
 equation returns [Abstract_Equation e]
 	: a1=arithexpr i=eqoper a2=arithexpr {e = new Abstract_Equation(a1, i, a2);};
 term returns [Abstract_Term t]	: (st=stringterm {$t = st;} | ft=function_term {$t=ft;} | at=arithexpr {$t=at;}| lt=listterm {$t=lt;});
 function_term  returns [Abstract_Term t]
 	:	c=CONST {t=new Abstract_Predicate(c.getText());} (OPEN t1=term {((Abstract_Predicate) t).addTerm($t1.t);} (COMMA t2=term {((Abstract_Predicate) t).addTerm($t2.t);})* CLOSE)?;
 atom_term  returns [Abstract_NumberTerm t]: (n = numberstring {$t = new Abstract_NumberTermImpl($n.s);} | v=var {$t = $v.v;});
 stringterm returns [Abstract_StringTerm s]
 	: DOUBLEQUOTE w=word DOUBLEQUOTE {s=new Abstract_StringTermImpl($w.s);};
 var returns [Abstract_VarTerm v]	:	VAR {
	if (variables.containsKey($VAR.getText())) {
		$v = variables.get($VAR.getText());
		} else {
		$v = new Abstract_VarTerm($VAR.getText());
		variables.put($VAR.getText(), $v);
		}
	};

 numberstring returns [String s]
 	:	{$s = "";} (MINUS {$s += "-";})? (n1=NUMBER {$s += $n1.getText();}
 	                                  (STOP {$s += ".";} n2=NUMBER {$s += $n2.getText();})?);
 	                             	
arithexpr returns [Abstract_NumberTerm ae]
 	:  a1=multexpr {$ae = a1;} (i=addoper a2=multexpr {$ae = new Abstract_ArithExpr($ae, $i.i, a2);})?;
multexpr returns [Abstract_NumberTerm ae]:	a1=atom_term{$ae = a1;} (i=multoper a2=atom_term {ae = new Abstract_ArithExpr($ae, $i.i, a2);})?;

word returns [String s] : (CONST {$s=$CONST.getText();} | VAR {$s=$VAR.getText();});                                                                                     

 
 listterm returns [Abstract_ListTermImpl l]
 	: {$l = new Abstract_ListTermImpl(); Abstract_ListTerm lrunning = $l;} 
 	SQOPEN (h=term {$l.addHead($h.t); $l.addTail(new Abstract_ListTermImpl());} 
 	(COMMA t=term {Abstract_ListTerm l2 = new Abstract_ListTermImpl();  l2.addHead($t.t); l2.addTail(new Abstract_ListTermImpl()); lrunning.addTail(l2); lrunning=l2;})* 
 	(BAR v=VAR {lrunning.addTail(new Abstract_VarTerm($v.getText()));})? )? SQCLOSE;
 	
 addoper returns [int i]:	(PLUS {$i = 1;} | MINUS {$i = 2;} );
 multoper returns [int i]
 	:	(MULT {$i = 3;} | DIV {$i = 4;} );
 eqoper returns [int i]	: (LESS {$i = 1;} | EQUALS {$i = 2;});
 	                                              
// Lexer Misc Syntax
COLON	: ':';
CURLYOPEN: '{';
CURLYCLOSE
	:'}';
STOP	: '.';
COMMA	: ',';
OPEN	: '(';
CLOSE	: ')';
SQOPEN	: '[';
SQCLOSE	: ']';
HASH: '#';
DOUBLEQUOTE
	: '"';
BAR	: '|';

CONST 	: 	'a'..'z' ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
VAR	:	('A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
NUMBER	:	'0'..'9' ('0'..'9')*;

MINUS	:	'-';
MULT	:	'*';
DIV	:	'/';
LESS	:	'<';

COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;}
    ;
LINE_COMMENT
    : ('//'|'%') ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;
NEWLINE:'\r'? '\n' {skip();} ;
WS  :   (' '|'\t')+ {skip();} ;
