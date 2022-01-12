// --------------------------------------------------------------------------------------------
// Copyright (c) 2021-2022 SIL International
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

featureTemplate: featureTemplateDefinition featurePathTemplateBody '.'? comment*
               | featureTemplateDefinition featureTemplateValue '.'? comment*
               ;

featureTemplateDefinition: 'Let' featureTemplateName 'be'
                        ;
featurePathTemplateBody: featurePathUnit '=' featureTemplateValue featurePathTemplateBody*
                       | featureTemplateAbbreviation featurePathTemplateBody*
                       ;

featureTemplateName: atomicValue;

featureTemplateAbbreviation: '[' featureTemplateName ']' comment*;
                   
featureTemplateValue: featureTemplateDisjunction
                    | featurePathUnit '.'? comment*
                    | atomicValue '.'? comment*
                    ;

featureTemplateDisjunction: openingBrace featurePathOrStructure featurePathOrStructure+ closingBrace
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

phraseStructureRule: constituent ruleDef rightHandSide
                   ;
ruleDef: '='
       | '->'
       ;

constituent: TEXT;

rightHandSide: (constituent
             | disjunctiveConstituents
             | optionalConstituents
             | disjunctiveOptionalConstituents
             | disjunctionConstituents
              )+
             ;

disjunctiveConstituents: '{' constituent+ disjunctionConstituents+ '}' comment?;
disjunctionConstituents: '/' (constituent | disjunctiveConstituents)+ comment?;
optionalConstituents: '(' (constituent | disjunctiveConstituents | optionalConstituents | disjunctionOptionalConstituents)+ ')' comment?;
disjunctiveOptionalConstituents: '(' constituent+ disjunctionOptionalConstituents+ ')' comment?;
disjunctionOptionalConstituents: '/' constituent+ comment?;

constraints: constraint+;

constraint: unificationConstraint
		  | priorityUnionConstraint
		  | logicalConstraint
		  | comment
		  ;
unificationConstraint: uniConstraintLeftHandSide '=' uniConstraintRightHandSide comment?
                     | disjunctiveUnificationConstraint 
                     ;
uniConstraintLeftHandSide: openingWedge constituent featurePath closingWedge;
uniConstraintRightHandSide: openingWedge constituent featurePath? closingWedge comment?
                          | atomicValue comment?
                          ;
disjunctiveUnificationConstraint: '{' unificationConstraint+ disjunctionUnificationConstraint+ '}' comment?;
disjunctionUnificationConstraint: '/' unificationConstraint+ comment?;

featurePath: ruleKW
           | atomicValue featurePath
           | atomicValue
           ;

atomicValue : TEXT;

priorityUnionConstraint: priorityUnionLeftHandSide '<=' priorityUnionRightHandSide comment?;
priorityUnionLeftHandSide: openingWedge constituent featurePath closingWedge;
priorityUnionRightHandSide: openingWedge constituent featurePath closingWedge
                          | atomicValue
                          ;

logicalConstraint: logConstraintLeftHandSide '==' logConstraintExpression;
logConstraintLeftHandSide: openingWedge constituent featurePath? closingWedge
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

binop: '&'   comment*
     | '/'   comment*
     | '->'  comment*
     | '<->' comment*
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

// The lexer is a greedy parser and will always
// match the longest sequence.
TEXT : (
	   [,.;^!?@#$%&'"_a-zA-Z0-9\u0080-\uFFFF+-]
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
     )+  ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
