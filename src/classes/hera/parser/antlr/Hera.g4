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

