// ----------------------------------------------------------------------------
// Copyright (C) 2018 Louise A. Dennis, Felix Lindner, Martin Moze Bentzen, Michael Fisher
//
// This file is part of Juno
//
// Juno is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Juno is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

grammar Hera;

options { tokenVocab = HeraLexer; }

formula: atomfmla | notfmla | andfmla | orfmla | notfmla | implfmla | affectsfmla | affectsposfmla | affectsnegfmla | ifmla | goalfmla | meansfmla | 
	causesfmla | pcausesfmla | scausesfmla | explainsfmla | preventsfmla | interventionfmla | existsfmla | forallfmla | gtfmla |
	geqfmla | mustfmla | mayfmla | kfmla | consequencefmla | stringfmla;
	
atomfmla: ATOM OPEN formula CLOSE;
notfmla : NOT OPEN formula CLOSE;
andfmla : AND OPEN formula COMMA formula CLOSE;
orfmla: OR OPEN formula COMMA formula CLOSE;
implfmla: IMPL OPEN formula COMMA formula CLOSE;
affectsfmla: AFFECTS formula COMMA formula CLOSE;
affectsnegfmla: AFFECTSNEG OPEN formula COMMA formula CLOSE;
affectsposfmla: AFFECTSPOS OPEN formula COMMA formula CLOSE;
ifmla: I OPEN formula CLOSE;
goalfmla: GOAL OPEN formula CLOSE;
meansfmla: MEANS OPEN formula COMMA formula CLOSE;
causesfmla: CAUSES OPEN formula COMMA formula CLOSE;
pcausesfmla: PCAUSES OPEN formula COMMA formula CLOSE;
scausesfmla: SCAUSES OPEN formula COMMA formula CLOSE;
explainsfmla: EXPLAINS OPEN formula COMMA formula CLOSE;
preventsfmla: PREVENTS OPEN formula COMMA formula CLOSE;
interventionfmla: INTERVENTION OPEN formula COMMA formula CLOSE;
existsfmla: EXISTS OPEN formula COMMA formula CLOSE;
forallfmla: FORALL OPEN formula COMMA formula CLOSE;
gtfmla: GT OPEN term COMMA term CLOSE;
geqfmla: GEQ OPEN term COMMA term CLOSE;
mustfmla: MUST OPEN formula CLOSE;
mayfmla: MAY OPEN formula CLOSE;
kfmla: K OPEN formula CLOSE;
consequencefmla: CONSEQUENCE OPEN formula CLOSE;
stringfmla: QUOTE w=WORD QUOTE;

term: uterm | drterm | dbterm | minusterm | subterm | addterm | intterm;

uterm: U OPEN formula CLOSE;
drterm: DR OPEN formula COMMA formula CLOSE;
dbterm: DB OPEN formula COMMA formula CLOSE;
minusterm: MINUS OPEN term CLOSE;
subterm: SUB OPEN term COMMA term CLOSE;
addterm: ADD OPEN term COMMA term CLOSE;
intterm: INT;

