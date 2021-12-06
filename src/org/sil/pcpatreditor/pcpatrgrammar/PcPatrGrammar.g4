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

patrgrammar : comment* featureTemplates? constraintTemplates? patrRules parameters? lexicalRules? comment* EOF;

comment: LINECOMMENT;

featureTemplates: featureTemplate+;

featureTemplate: featureTemplateDefinition featurePathUnit '=' featureTemplateValue '.'? comment*
               | featureTemplateDefinition featureTemplateValue '.'? comment*
               ;

featureTemplateDefinition: 'Let' featureTemplateName 'be'
                        ;

featureTemplateName: atomicValue
                   ;
                   
featureTemplateValue: featureTemplateDisjunction
                    | featurePathUnit '.'? comment*
                    | atomicValue '.'? comment*
                    ;

featureTemplateDisjunction: openingBrace featurePath featurePathOrStructure+ closingBrace
                          | openingBrace featureStructure featurePathOrStructure+ closingBrace
                          | openingBrace atomicValue atomicValue+ closingBrace
                          | openingBrace atomicValue featurePathOrStructure+ closingBrace
                          ;

featurePathOrStructure: featurePath comment*
                      | featureStructure comment*
                      | atomicValue comment*
                      ;

featureStructure: openingBracket featureStructureName ':' featureStructureValue embeddedFeatureStructure* closingBracket comment*
                ;

featureStructureName: atomicValue
                    ;

featureStructureValue: featureStructure
                     | atomicValue
                     ;
embeddedFeatureStructure: featureStructureName ':' featureStructureValue comment*
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

nonTerminal: PSRSYMBOL nonTerminalIndex
           | PSRSYMBOL
           ;

nonTerminalIndex: INDEX;


rightHandSide: (nonTerminal+
             | disjunctiveTerminals+
             | optionalTerminals+
             | disjunctiveOptionalNonTerminal+
              )+
             ;

disjunctiveTerminals: '{' nonTerminal+ disjunctionNonTerminal+ '}' comment?;
disjunctionNonTerminal: '/' nonTerminal+ comment?;
optionalTerminals: '(' nonTerminal+ ')' comment?; 
disjunctiveOptionalNonTerminal: '(' nonTerminal+ disjunctionOptionalNonTerminal+ ')' comment?;
disjunctionOptionalNonTerminal: '/' nonTerminal+ comment?;

constraints: constraint+;

constraint: unificationConstraint
		  | priorityUnionConstraint
		  | logicalConstraint
		  | comment
		  ;
unificationConstraint: uniConstraintLeftHandSide '=' uniConstraintRightHandSide comment?
                     | disjunctiveUnificationConstraint 
                     ;
uniConstraintLeftHandSide: openingWedge nonTerminal featurePath closingWedge;
uniConstraintRightHandSide: openingWedge nonTerminal featurePath closingWedge comment?
                          | atomicValue comment?
                          ;
disjunctiveUnificationConstraint: '{' unificationConstraint+ disjunctionUnificationConstraint+ '}' comment?;
disjunctionUnificationConstraint: '/' unificationConstraint+ comment?;

featurePath: ruleKW
           | atomicValue featurePath
           | atomicValue
           ;

atomicValue : TEXT 
            | PSRSYMBOL
            | TEXTWITHUNDERSCORE
            | RULEID
            ;

priorityUnionConstraint: priorityUnionLeftHandSide '<=' priorityUnionRightHandSide comment?;
priorityUnionLeftHandSide: openingWedge nonTerminal featurePath closingWedge;
priorityUnionRightHandSide: openingWedge nonTerminal featurePath closingWedge
                          | atomicValue
                          ;

logicalConstraint: logConstraintLeftHandSide '==' logConstraintExpression;
logConstraintLeftHandSide: openingWedge nonTerminal featurePath closingWedge
                         | openingWedge nonTerminal closingWedge
                         ;
logConstraintExpression: logConstraintFactor
                       |'~' logConstraintFactor
					   |     logConstraintFactor binop     logConstraintFactor
					   | '~' logConstraintFactor binop     logConstraintFactor
					   |     logConstraintFactor binop '~' logConstraintFactor
					   | '~' logConstraintFactor binop '~' logConstraintFactor
                       ;
logConstraintFactor: featureStructure
                   | '(' logConstraintExpression ')'
                   ;

binop: '&'
     | '/'
     | '->'
     | '<->'
     ;

openingBrace   : '{';
closingBrace   : '}';
openingBracket : '[';
closingBracket : ']';
openingParen   : '(';
closingParen   : ')';
openingWedge   : '<';
closingWedge   : '>';



parameters: 'Parameter';

lexicalRules: 'Define';

LINECOMMENT : '|' .*? '\r'? '\n'
            | '|' .*? EOF
            ;

PSRSYMBOL : [A-Z][a-zA-Z0-9\u0080-\uFFFF]*;

INDEX : '_' [0-9];

RULEID: [0-9]*[a-zA-Z]*[-.]*[a-zA-Z]+[-.]*[a-zA-Z]*
      | [a-zA-Z]*[0-9][a-zA-Z]*
//      | [0-9]
      ;

TEXTWITHUNDERSCORE: TEXT '_' TEXT
                  | TEXT '_' TEXTWITHUNDERSCORE
                  ;
// The lexer is a greedy parser and will always
// match the longest sequence.
TEXT : (
	   [,.;^!?@#$%&'"a-zA-Z\u0080-\uFFFF+-]
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
//     | [0-9]
//     | '|' 
     )+  ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
