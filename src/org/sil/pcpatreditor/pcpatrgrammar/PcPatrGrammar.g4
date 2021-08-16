// --------------------------------------------------------------------------------------------
// Copyright (c) 2021 SIL International
// This software is licensed under the LGPL, version 2.1 or later
// (http://www.gnu.org/licenses/lgpl-2.1.html)
//
// File: PatrGrammar.g4
// Responsibility: Andy Black
// Last reviewed:
//
// <remarks>
// ANTLR v.4 grammar for PcPatr grammars
// </remarks>
// --------------------------------------------------------------------------------------------
grammar PcPatrGrammar;

@header {
	package org.sil.pcpatreditor.pcpatrgrammar.antlr4generated;
}

patrgrammar : comment* featureTemplates? constraintTemplates? patrRules parameters? lexicalRules? EOF;

comment: LINECOMMENT;

featureTemplates: featureTemplate+;

featureTemplate: featureTemplateDefinition featurePathUnit '=' featurePathUnit '.'? comment*
               | featureTemplateDefinition featurePathUnit '=' featurePathAtom '.'? comment*
               ;

featureTemplateDefinition: 'Let' featureTemplateName 'be'
                        ;

featureTemplateName: TEXT
                   | PSR_SYMBOL
                   ;
                   
featurePathUnit: openingWedge featurePath closingWedge;

constraintTemplates: constraintTemplate+;

constraintTemplate: 'Constraint' '.'?
                  ;

patrRules: patrRule+;

patrRule: comment* ruleKW ruleIdentifier? comment* phraseStructureRule comment* constraints* comment* '.'?;

ruleKW: 'Rule'
      | 'rule'
      ;
    
ruleIdentifier: '{' .*? '}';

phraseStructureRule: nonTerminal ruleDef rightHandSide
                   ;
ruleDef: '='
       | '->'
       ;

nonTerminal: PSR_SYMBOL nonTerminalIndex
           | PSR_SYMBOL
           ;

nonTerminalIndex: INDEX;


rightHandSide: nonTerminal+
             ;


constraints: constraint+;

constraint: unificationConstraint
		  | priorityUnionConstraint
		  | logicalConstraint
		  ;
unificationConstraint: openingWedge nonTerminal featurePath closingWedge '=' openingWedge nonTerminal featurePath closingWedge comment?;

featurePath: featurePathAtom featurePath
           | featurePathAtom
           ;

featurePathAtom : TEXT
                | PSR_SYMBOL
                ;

priorityUnionConstraint: openingWedge;

logicalConstraint: openingWedge;

openingWedge : '<';
closingWedge : '>';



parameters: 'Parameter';

lexicalRules: 'Define';

LINECOMMENT : '|' .*? '\r'? '\n'
            | '|' .*? EOF
            ;

PSR_SYMBOL : [a-zA-Z0-9\u0080-\uFFFF]+;

INDEX : '_' [0-9];

// The lexer is a greedy parser and will always
// match the longest sequence.
TEXT : (
	   [,.;:^!?@#$%&'"a-zA-Z\u0080-\uFFFF+-]
//     | [_*=<>]
//     | '['
//     | ']'
//     | '{'
//     | '}'
//     | '\\('
//     | '\\)'
     | '/'
     | '~'
     | '`'
     | '\\'
//     | '|' 
     )+  ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
