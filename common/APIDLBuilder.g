tree grammar APIDLBuilder;

options {
  language = Java;
  tokenVocab = APIDL;
  ASTLabelType = CommonTree;
}

@header {
  package org.apidl.antlr;
  import org.apidl.model.*;
  import org.apidl.model.DeclaredInterface.AccessType;
  import org.apidl.model.DeclaredMethodParameter.ParameterType;
}
 
@members {
  DeclaredInterface inter = new DeclaredInterface();
}

declaration returns [DeclaredInterface e]
        :
        {e = inter;}
        ^(DEC (namespace {inter.addNamespace($namespace.e);})* (requires {inter.addRequire($requires.e);})* interface_definition) 
        ;

namespace returns [DeclaredNamespace e]
        :
        ^('namespace' STRING {e = new DeclaredNamespace($STRING.text);} (for_restriction {e.addRestrictions($for_restriction.e);})?)
        ;
        
requires returns [DeclaredRequire e]
        :
        ^('requires' STRING {e = new DeclaredRequire($STRING.text);} (for_restriction {e.addRestrictions($for_restriction.e);})?)
        ;
        
interface_definition
        :
        ^(INTERFACE access name=STRING ext=STRING?  
        {
        if ($access.e != null) {
          inter.setType(AccessType.valueOf($access.e.toUpperCase()));
        }
        inter.setName($name.text);
        inter.setExtend($ext.text);
        }
        (for_restriction {inter.addRestrictions($for_restriction.e);})?
        (method_statement {inter.addMethod($method_statement.e);})+)
        ;
        
access returns [String e]
        :
        'public' {e = "public";} | 'private' {e = "private";}
        ;        
        
method_statement returns [DeclaredMethod e]
        :
        ^('method' STRING {e = new DeclaredMethod($STRING.text);} 
          (parameter {e.addParameter($parameter.e);})* 
          (type {e.setReturnType($type.e);})? 
          (for_restriction {e.addRestrictions($for_restriction.e);})?)
        ;
        
parameter returns [DeclaredMethodParameter e]
        :
        {e = new DeclaredMethodParameter();}
        ^(PARAM (param_oper {e.setParameterType(ParameterType.valueOf($param_oper.e.toUpperCase()));})? 
        type {e.setType($type.e);} 
        STRING {e.setName($STRING.text);}
        (for_restriction {e.addRestrictions($for_restriction.e);})?)
        ;
        
param_oper returns [String e]
  :
  'output' {e = "output";}
  | 'readonly' {e = "readonly";}
  ;
        
type returns [Type e]
        :
        ^(TYPE STRING {e = new Type($STRING.text);} (generic_type {e.setGenericType($generic_type.e);})?)
        ;
        
generic_type returns [String e]
        :
        ^(GENERIC STRING) {e = $STRING.text;}
        ;
        
for_restriction returns [List<Restriction> e]
        :
        {e = new ArrayList<Restriction>();}
        ^('for' (for_type_restriction {e.add($for_type_restriction.e);})+)
        ;
        
for_type_restriction returns [Restriction e]
        :
        ^(FORRES platform=STRING {e = new Restriction($platform.text);} ((restrictions {e.setOperator($restrictions.e);})? version=STRING {e.setVersion($version.text);})?)
        ;

restrictions returns [String e]
        :
    RESTRICTION_OPERATORS {e = $RESTRICTION_OPERATORS.text;} 
    | GENERIC_START {e = $GENERIC_START.text;}
    | GENERIC_END {e = $GENERIC_END.text;}
    ;
