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

patrgrammar : comment* (featureTemplates | constraintTemplates | patrRules | parameters | lexicalRules)* comment* EOF;

comment: LINECOMMENT;

featureTemplates: featureTemplate+;

featureTemplate: featureTemplateDefinition (featurePathTemplateBody | featureStructureTemplateBody) '.'? comment*
               | featureTemplateDefinition {notifyErrorListeners("missingTemplateBody");}
               ;

featureTemplateDefinition: 'Let' featureTemplateName 'be'
                         | 'Let' {notifyErrorListeners("missingTemplateNameOrBe");}
                         ;
featurePathTemplateBody: featurePathUnit '=' atomicValueDisjunction featurePathTemplateBody?
                       | featurePathUnit '=' featureTemplateValue featurePathTemplateBody?
                       | featureTemplateAbbreviation featurePathTemplateBody?
                       | featureTemplateDisjunction featurePathTemplateBody?
                       | featurePathUnit '=' {notifyErrorListeners("missingDisjunctionOrFeatureTemplateValue");}
                       | featurePathUnit {notifyErrorListeners("missingEqualsSign");}
                       ;
featureStructureTemplateBody: featureStructure
                            ;
featureTemplateName: atomicValue
                   | atomicValue '/' atomicValue
                   ;

featureTemplateAbbreviation: '[' featureTemplateName ']' comment*
                           | featureTemplateName comment*
                           ;
                   
featureTemplateValue: featureTemplateDisjunction
                    | featurePathUnit '.'? comment*
                    | atomicValue '.'? comment*
                    ;

atomicValueDisjunction: openingBrace atomicValue atomicValue+ closingBrace;

featureTemplateDisjunction: openingBrace featurePathOrStructure featurePathOrStructure+ closingBrace
                          ;

featurePathOrStructure: featurePath comment*
                      | featureStructure comment*
                      | atomicValue comment*
                      | featureTemplateAbbreviation comment*
                      ;

featureStructure: openingBracket featureStructureName ':' featureStructureValue embeddedFeatureStructure* closingBracket comment*
                | emptyFeatureStructure comment*
                ;

featureStructureName: ruleKW
                    | atomicValue
                    ;

featureStructureValue: featureStructure
                     | atomicValue
                     | 'be'
                     ;
embeddedFeatureStructure: featureStructureName ':' featureStructureValue comment*
                        ;
emptyFeatureStructure: '[]';

featurePathUnit: openingWedge featurePath closingWedge;

patrRules: patrRule+;

patrRule: comment* ruleKW ruleIdentifier? comment* phraseStructureRule comment* constraints? comment* '.'?;

ruleKW: 'rule'
      | 'Rule'
      | 'RULE'
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

disjunctiveConstituents: '{' (constituent | optionalConstituents | disjunctiveConstituents)+ disjunctionConstituents+ '}' comment?;
disjunctionConstituents: '/' comment* (constituent | disjunctiveConstituents | optionalConstituents)+ comment?;
optionalConstituents: '(' (constituent | disjunctiveConstituents | optionalConstituents | disjunctionOptionalConstituents)+ ')' comment?;
disjunctiveOptionalConstituents: '(' constituent+ disjunctionOptionalConstituents+ ')' comment?;
disjunctionOptionalConstituents: '/' comment* constituent+ comment?;

constraints: (unificationConstraint | priorityUnionConstraint | logicalConstraint | comment)+;

unificationConstraint: uniConstraintLeftHandSide '=' uniConstraintRightHandSide comment?
                     | disjunctiveUnificationConstraint 
                     ;
uniConstraintLeftHandSide: openingWedge constituent featurePath closingWedge;
uniConstraintRightHandSide: openingWedge constituent featurePath? closingWedge comment?
                          | atomicValue comment?
                          ;
disjunctiveUnificationConstraint: '{' unificationConstraint+ disjunctionUnificationConstraint+ '}' comment?;
disjunctionUnificationConstraint: '/' comment* unificationConstraint+ comment?;

featurePath: ruleKW
           | atomicValue featurePath
           | atomicValue
           ;

atomicValue : TEXT;

priorityUnionConstraint: priorityUnionLeftHandSide '<=' priorityUnionRightHandSide comment?;
priorityUnionLeftHandSide: openingWedge constituent featurePath closingWedge;
priorityUnionRightHandSide: openingWedge constituent featurePath? closingWedge
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


parameters: parameter+ comment*;
parameter: parameterKW ':'? parameterName 'is' parameterValue '.'? comment*
         | parameterKW ':'? 'Attribute order' 'is' parameterValue+ '.'? comment*
         ;
parameterKW: 'parameter'
           | 'Parameter'
           | 'PARAMETER'
           ;
parameterName: 'Start symbol'
         | 'Category feature'
         | 'Lexical feature'
         | 'Gloss feature'
         | 'RootGloss feature'
         // not implemented in PcPatr: | 'Restrictor'
         ;
parameterValue: TEXT comment*;

lexicalRules: lexicalRule+ comment*;
lexicalRule: lexicalRuleKW lexicalRuleName 'as' lexicalRuleDefinition '.'? comment*
           ;
lexicalRuleKW: 'define'
             | 'Define'
             | 'DEFINE'
             ;
lexicalRuleName: TEXT;
lexicalRuleDefinition: lexicalRuleMapping+ comment*
                     ;
lexicalRuleMapping: lexicalRuleOutput lexicalRuleAssignment lexicalRuleInput comment*
                  ;
lexicalRuleAssignment: '='
                     | '=>'
                     ;
lexicalRuleOutput: '<' 'out' featurePath '>' comment*;
lexicalRuleInput: '<' 'in' featurePath '>' comment*;

constraintTemplates: constraintTemplate+;

constraintTemplate: constraintTemplateKW constraintTemplateName 'is' logConstraintExpression '.'? comment*;
constraintTemplateKW: 'constraint'
                    | 'Constraint'
                    | 'CONSTRAINT'
                    ;
constraintTemplateName: TEXT;

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
//     | '/'
     | '~'
     | '`'
     | '\\'
     )+  ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
