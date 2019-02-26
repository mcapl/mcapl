grammar Juno;

options { tokenVocab = JunoLexer; }

junoAgent: json_file (bs=belief_rule)* (as=action_rule)*;

json_file: CURLYOPEN FILE_BLOCK CURLYCLOSE;

belief_rule: (b=belief_modifier) CURLYOPEN (bs1=fof_expr) (COMMA bs2=fof_expr)* CURLYCLOSE;

action_rule: (a=fof_expr) CURLYOPEN (b=belief_modifier) (COMMA (bs2=belief_modifier))* CURLYCLOSE;

belief_modifier: (ADD | DEL) (b=fof_expr);

// fof_expr: (CONST | IDPUNCT | OPEN fof_expr CLOSE)+;
fof_expr: CONST (OPEN fof_expr (COMMA fof_expr)* CLOSE)? ;
