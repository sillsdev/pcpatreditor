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


// NOTE: Commented off all notify error listener items because they make the parser run much too slowly
// (on the order of 10 seconds instead of less than a second).
//  We're going with a generic "syntax error found" message, instead.

patrgrammar : comment* (featureTemplates | constraintTemplates | patrRules | parameters | lexicalRules)* comment* EOF;

comment: LINECOMMENT;

featureTemplates: featureTemplate+;

featureTemplate: featureTemplateDefinition (featurePathTemplateBody | featureStructureTemplateBody) '.'? comment*
//               | featureTemplateDefinition {notifyErrorListeners("missingTemplateBody");}
               ;

featureTemplateDefinition: 'Let' featureTemplateName 'be'
//                         | 'Let' {notifyErrorListeners("missingTemplateNameOrBe");}
                         ;
featurePathTemplateBody: featurePathUnit '=' atomicValueDisjunction featurePathTemplateBody?
                       | featurePathUnit '=' featureTemplateValue featurePathTemplateBody?
                       | featureTemplateAbbreviation featurePathTemplateBody?
                       | featureTemplateDisjunction featurePathTemplateBody?
//                       | featurePathUnit '=' {notifyErrorListeners("missingDisjunctionOrFeatureTemplateValue");}
//                       | featurePathUnit {notifyErrorListeners("missingEqualsSign");}
                       ;
featureStructureTemplateBody: featureStructure
                            ;
featureTemplateName: atomicValue
                   | atomicValue '/' atomicValue
                   ;

featureTemplateAbbreviation: '[' featureTemplateName ']' comment*
                           | featureTemplateName comment*
//                           |  {notifyErrorListeners("missingOpeningBracket");} featureTemplateName ']' comment*
//                           |  '[' featureTemplateName {notifyErrorListeners("missingClosingBracket");} comment*
                           ;
                   
featureTemplateValue: featureTemplateDisjunction
                    | featurePathUnit '.'? comment*
                    | atomicValue '.'? comment*
                    ;

atomicValueDisjunction: openingBrace atomicValue atomicValue+ closingBrace
//                      | {notifyErrorListeners("missingOpeningBrace");} atomicValue atomicValue+ closingBrace
//                      | openingBrace atomicValue atomicValue+ {notifyErrorListeners("missingClosingBrace");}
                      ;

featureTemplateDisjunction: openingBrace featurePathOrStructure featurePathOrStructure+ closingBrace
//                          | {notifyErrorListeners("missingOpeningBrace");} featurePathOrStructure featurePathOrStructure+ closingBrace
//                          | openingBrace featurePathOrStructure featurePathOrStructure+ {notifyErrorListeners("missingClosingBrace");}
                          ;

featurePathOrStructure: featurePath comment*
                      | featureStructure comment*
                      | atomicValue comment*
                      | featureTemplateAbbreviation comment*
                      ;

featureStructure: openingBracket featureStructureName ':' featureStructureValue embeddedFeatureStructure* closingBracket comment*
                | emptyFeatureStructure comment*
//                | {notifyErrorListeners("missingOpeningBracket");} featureStructureName ':' featureStructureValue embeddedFeatureStructure* closingBracket comment*
//                | openingBracket featureStructureName ':' featureStructureValue embeddedFeatureStructure* {notifyErrorListeners("missingClosingBracket");}
//                | openingBracket featureStructureName {notifyErrorListeners("missingColon");}  featureStructureValue embeddedFeatureStructure* closingBracket comment*
                ;

featureStructureName: ruleKW
                    | atomicValue
                    ;

featureStructureValue: featureStructure
                     | atomicValue
                     | 'be'
                     ;
embeddedFeatureStructure: featureStructureName ':' featureStructureValue comment*
//                        | featureStructureName {notifyErrorListeners("missingColon");} featureStructureValue comment*
                        ;
emptyFeatureStructure: '[]';

featurePathUnit: openingWedge featurePath closingWedge
//               | {notifyErrorListeners("missingOpeningWedge");} featurePath closingWedge
//               | openingWedge featurePath {notifyErrorListeners("missingClosingWedge");}
               ;

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

disjunctiveConstituents: '{' (constituent | optionalConstituents | disjunctiveConstituents)+ disjunctionConstituents+ '}' comment?
//                       | '{' (constituent | optionalConstituents | disjunctiveConstituents)+ disjunctionConstituents+ {notifyErrorListeners("missingClosingBrace");} comment?
                       ;
disjunctionConstituents: '/' comment* (constituent | disjunctiveConstituents | optionalConstituents)+ comment?;
optionalConstituents: '(' (constituent | disjunctiveConstituents | optionalConstituents | disjunctionOptionalConstituents)+ ')' comment?
//                    | {notifyErrorListeners("missingOpeningParen");} (constituent | disjunctiveConstituents | disjunctionOptionalConstituents)+ ')' comment?
// Note: including optionalConstituents creates left-recursion and the grammar will not parse
//                    | {notifyErrorListeners("missingOpeningParen");} (constituent | disjunctiveConstituents | optionalConstituents | disjunctionOptionalConstituents)+ ')' comment?
// Note: following goes down a bad path and reports two errors sometime when it still parses.
//                    | '(' (constituent | disjunctiveConstituents | optionalConstituents | disjunctionOptionalConstituents)+ {notifyErrorListeners("missingClosingParen");}
                    ;
disjunctiveOptionalConstituents: '(' constituent+ disjunctionOptionalConstituents+ ')' comment?
//                               | {notifyErrorListeners("missingOpeningParen");} constituent+ disjunctionOptionalConstituents+ ')' comment?
//                               | '(' constituent+ disjunctionOptionalConstituents+ {notifyErrorListeners("missingClosingParen");} comment?
                               ;
disjunctionOptionalConstituents: '/' comment* constituent+ comment?;

constraints: (unificationConstraint | priorityUnionConstraint | logicalConstraint | comment)+;

unificationConstraint: uniConstraintLeftHandSide '=' uniConstraintRightHandSide comment?
                     | disjunctiveUnificationConstraint 
                     ;
uniConstraintLeftHandSide: openingWedge constituent featurePath closingWedge
//                         | {notifyErrorListeners("missingOpeningWedge");} constituent featurePath closingWedge
//                         | openingWedge constituent featurePath {notifyErrorListeners("missingClosingWedge");}
                         ;
uniConstraintRightHandSide: openingWedge constituent featurePath? closingWedge comment?
                          | atomicValue comment?
//                          | {notifyErrorListeners("missingOpeningWedge");} constituent featurePath closingWedge
//                          | openingWedge constituent featurePath {notifyErrorListeners("missingClosingWedge");}
                          ;
disjunctiveUnificationConstraint: '{' unificationConstraint+ disjunctionUnificationConstraint+ '}' comment?;
disjunctionUnificationConstraint: '/' comment* unificationConstraint+ comment?;

featurePath: ruleKW
           | atomicValue featurePath
           | atomicValue
           ;

atomicValue : TEXT;

priorityUnionConstraint: priorityUnionLeftHandSide '<=' priorityUnionRightHandSide comment?;
priorityUnionLeftHandSide: openingWedge constituent featurePath closingWedge
//                         | {notifyErrorListeners("missingOpeningWedge");} constituent featurePath closingWedge
//                         | openingWedge constituent featurePath {notifyErrorListeners("missingClosingWedge");}
                         ;
priorityUnionRightHandSide: openingWedge constituent featurePath? closingWedge
                          | atomicValue
//                          | {notifyErrorListeners("missingOpeningWedge");} constituent featurePath? closingWedge
//                          | openingWedge constituent featurePath? {notifyErrorListeners("missingClosingWedge");}
                          ;

logicalConstraint: logConstraintLeftHandSide '==' logConstraintExpression;
logConstraintLeftHandSide: openingWedge constituent featurePath? closingWedge
//                         | {notifyErrorListeners("missingOpeningWedge");} constituent featurePath? closingWedge
//                         | openingWedge constituent featurePath? {notifyErrorListeners("missingClosingWedge");}
                         ;
logConstraintExpression: logConstraintFactor
                       |'~' logConstraintFactor
					   |     logConstraintFactor binop     logConstraintFactor
					   | '~' logConstraintFactor binop     logConstraintFactor
					   |     logConstraintFactor binop '~' logConstraintFactor
					   | '~' logConstraintFactor binop '~' logConstraintFactor
//					   |     logConstraintFactor {notifyErrorListeners("missingBinop");}     logConstraintFactor
//					   | '~' logConstraintFactor {notifyErrorListeners("missingBinop");}     logConstraintFactor
//					   |     logConstraintFactor {notifyErrorListeners("missingBinop");} '~' logConstraintFactor
//					   | '~' logConstraintFactor {notifyErrorListeners("missingBinop");} '~' logConstraintFactor
                       ;
logConstraintFactor: featureStructure
                   | '(' logConstraintExpression ')'
                   // following causes left recursion problem
//                   | {notifyErrorListeners("missingOpeningParen");} logConstraintExpression ')'
//                   | '(' logConstraintExpression {notifyErrorListeners("missingClosingParen");}
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
