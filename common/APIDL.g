grammar APIDL;

options {
  language = Java;
  output = AST;
}

tokens {
  DEC;
  INTERFACE;
  FORRES;
  TYPE;
  PARAM;
  GENERIC;
}

@lexer::header { package org.apidl.antlr; }
@parser::header { package org.apidl.antlr; }

declaration : namespace* requires* interface_definition EOF -> ^(DEC namespace* requires* interface_definition);

namespace : 'namespace'^ STRING for_restriction? ';'!;

requires : 'requires'^ STRING for_restriction? ';'!;

interface_definition 
  : 
  access n=STRING ('extends' ex=STRING)? for_restriction? '{' (method_statement)+ '}' -> ^(INTERFACE access $n $ex? for_restriction? method_statement+)
  ;
  
access
  :
  'public' | 'private'
  ;

method_statement 
  : 
  'method' STRING ('(' (parameter (',' parameter)*)? ')')? ('returns' type)? for_restriction? ';'
      -> ^('method' STRING type? parameter* for_restriction?)
  ;

parameter 
  : 
  param_oper? type STRING for_restriction? -> ^(PARAM param_oper? type STRING for_restriction?)
  ;
  
param_oper
  :
  'output'
  | 'readonly'
  ;

type : STRING generics? -> ^(TYPE STRING generics?);

generics
     : 
     GENERIC_START STRING GENERIC_END -> ^(GENERIC STRING)
     ;

for_type_statement : STRING (restrictions? STRING)? -> ^(FORRES STRING (restrictions? STRING)?);

restrictions
    :
    RESTRICTION_OPERATORS 
    | GENERIC_START
    | GENERIC_END 
    ;

for_restriction : 'for' for_type_statement ('or' for_type_statement)* -> ^('for' for_type_statement+) ;

STRING        : ('a'..'z'|'A'..'Z'| '0'..'9' | '.')+;   
RESTRICTION_OPERATORS   : ('=' | '>=' | '<=' | '!=');
GENERIC_START : '<';
GENERIC_END : '>';

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;