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
// import LogicalFmlas;

options { tokenVocab = ActionOnlyLexer; }

// Mas involving ActionOnly Agents
mas  :  aoagents;

aoagents: ACTIONONLY (aoagent)+;

// Agent stuff
aoagent returns [Abstract_ActionOnlyAgent g] : 
        (ACTIONONLY?) 
	NAME w=WORD  
	BELIEFS bs=PRED_BLOCK 
	(BELIEFRULES brs=FOF_BLOCK )? 
	GOAL gs=PRED_BLOCK 
	ACTIONS (c = capability)*;
	

// guard_atom returns [Abstract_GLogicalFormula g] : (BELIEVE FOF_BLOCK | // l=literal | // {$g = new Abstract_GBelief($l.l);} |
//				eq = equation | // {$g = $eq.eq;} |
//				TRUE {$g = new Abstract_GBelief();} );
				

capability returns [Abstract_Capability c] : CURLYOPEN (pres=FOF_BLOCK)? CURLYCLOSE a=PRED_BLOCK; // {$c = new Abstract_Capability($a.a); if ($f.f != null) {$c.addPre($f.f); $c.addPost(new Abstract_GBelief());}};

/* 	
clogicalfmla returns [Abstract_GLogicalFormula f] : n=cnotfmla {$f = $n.f;}
               (COMMA n2=cnotfmla {$f = new Abstract_Guard($f, Abstract_Guard.and, $n2.f);})*?;
cnotfmla returns [Abstract_GLogicalFormula f] : gb = pred {$f = new Abstract_GBelief(new Abstract_Literal(gb));} | 
                                                                              NOT (gb2 = pred {$f = new Abstract_Guard(Abstract_Guard.not, new Abstract_GBelief(new Abstract_Literal(gb2)));} | 
                                                                              lf = csubfmla {$f = new Abstract_Guard(Abstract_Guard.not, $lf.f);});
csubfmla returns [Abstract_GLogicalFormula f] : OPEN lf = clogicalfmla {$f = $lf.f;} CLOSE; */

// General AIL Parsing stuff

// environment returns [String env] : w=classpath {$env = $w.s;};
// classpath returns [String s] : w=word {$s = $w.s;} (POINT w1=word {$s+="."; $s+=$w1.s;})+;                                                                                     
// word returns [String s] : WORD;                                                                                    

// agentnameterm returns [Abstract_StringTerm s] : WORD; // CONST {$s = new Abstract_StringTermImpl($CONST.getText());} | v=var ;//{$s = $v.v;};


// action  : pred; 
