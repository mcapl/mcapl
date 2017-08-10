// ----------------------------------------------------------------------------
// Copyright (C) 2014-2017 Louise A. Dennis, and  Michael Fisher 
//
// This file is part of the Agent Infrastructure Layer (AIL)
// 
// The AIL is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// The AIL is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with the AIL; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//
//----------------------------------------------------------------------------

grammar ActionOnly;
import LogicalFmlas;

//@members {
//	private static HashMap<String,Abstract_VarTerm> variables = new HashMap<String,Abstract_VarTerm>();
//	private Abstract_StringTerm agentname = new Abstract_StringTermImpl("");
//	}

@lexer::header {
package actiononly.parser;
}
	
@lexer::members {
    public int plain_nesting = 0;
    public int sq_nesting = 0;
    public int curly_nesting = 0;
    public boolean stringterm = false;
    public boolean ao = true;
    public int belief_rules = 0;
}

// Mas involving ActionOnly Agents
mas  :  aoagents;

aoagents returns[ArrayList<Abstract_ActionOnlyAgent> gags]: ACTIONONLY 
	(g=aoagent {gags.add($g.g);})+;

// Agent stuff
aoagent returns [Abstract_ActionOnlyAgent g] : 
        (ACTIONONLY?) 
	NAME w=word {try {$g = new Abstract_ActionOnlyAgent($w.s);} 
		catch (Exception e) {System.err.println(e); agentname = new Abstract_StringTermImpl($w.s);}}
	BELIEFS (l=literal )* // {$g.addInitialBel($l.l);})*
	(BELIEFRULES (r=brule {$g.addRule($r.r);})*)?
	GOAL (l = literal )+ //{$g.addInitialGoal(new Abstract_Goal($l.l, Abstract_Goal.achieveGoal));})+
	ACTIONS (c = capability {$g.addCapability($c.c);})*;
	

guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE l=literal | // {$g = new Abstract_GBelief($l.l);} |
				eq = equation | // {$g = $eq.eq;} |
				TRUE {$g = new Abstract_GBelief();} );
				
brule returns [Abstract_Rule r] : head=pred (BRULEARROW f=logicalfmla {$r = new Abstract_Rule(head, $f.f);} SEMI | SEMI {$r = new Abstract_Rule(head);});

capability returns [Abstract_Capability c] : CURLYOPEN (f=clogicalfmla)? CURLYCLOSE a=action; // {$c = new Abstract_Capability($a.a); if ($f.f != null) {$c.addPre($f.f); $c.addPost(new Abstract_GBelief());}};

logicalfmla returns [Abstract_LogicalFormula f] : n=notfmla {$f = $n.f;}
               (COMMA n2=notfmla {$f = new Abstract_LogExpr($f, Abstract_LogExpr.and, $n2.f);})*?;
               // | and=subfmla {$f = new Abstract_LogExpr($n.f, Abstract_LogExpr.and, $and.f);}))?; 
notfmla returns [Abstract_LogicalFormula f] : (gb = pred {$f = gb;} | SQOPEN eq = equation {$f = eq;} SQCLOSE) | 
                                                                       NOT (gb2 = pred {$f = new Abstract_LogExpr(Abstract_LogExpr.not, gb2);} | 
                                                                       SQOPEN eq = equation SQCLOSE {$f = new Abstract_LogExpr(Abstract_LogExpr.not, eq);} |
                                                                      lf = subfmla {$f = new Abstract_LogExpr(Abstract_LogExpr.not, $lf.f);});
subfmla returns [Abstract_LogicalFormula f] : OPEN lf = logicalfmla {$f = $lf.f;} CLOSE;
	
clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*?;
cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} | 
                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} | 
                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE;

// General AIL Parsing stuff

environment returns [String env] : w=classpath {$env = $w.s;};
classpath returns [String s] : w=word {$s = $w.s;} (POINT w1=word {$s+="."; $s+=$w1.s;})+;                                                                                     
word returns [String s] : (CONST {$s=$CONST.getText();} | VAR {$s=$VAR.getText();});                                                                                     

agentnameterm returns [Abstract_StringTerm s] : CONST {$s = new Abstract_StringTermImpl($CONST.getText());} | v=var ;//{$s = $v.v;};


action  : pred; 

ACTIONONLY	:{curly_nesting == 0}? 'AO' {ao = true;};

BELIEFS	:	':Initial Beliefs:';
BELIEFRULES 
	:	':Reasoning Rules:' {belief_rules = 1;};
GOAL	:	':Initial Goal:';
NAME	:	':name:';

BELIEVE	:	{curly_nesting > 0 && plain_nesting == 0 || belief_rules==1}? ('B' | '.B') ;
BRULEARROW 
	:	':-';
ACTIONS	:	':Actions:';
// TRUE	:	{curly_nesting > 0 && plain_nesting == 0}? 'True';
