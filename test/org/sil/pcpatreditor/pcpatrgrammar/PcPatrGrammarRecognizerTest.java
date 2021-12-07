// Copyright (c) 2021 SIL International 
// This software is licensed under the LGPL, version 2.1 or later 
// (http://www.gnu.org/licenses/lgpl-2.1.html) 
/**
 * 
 */
package org.sil.pcpatreditor.pcpatrgrammar;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarConstants;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarErrorInfo;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarErrorListener;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarErrorListener.VerboseListener;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarLexer;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;

public class PcPatrGrammarRecognizerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validDescriptionsTest() {
		checkValidDescription(
				"rule\n S = NP VP",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"rule | comment after 'rule'\n S = NP VP",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (comment | comment after 'rule'\\n) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"rule {basic rule test}\nS = NP VP\n",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (ruleIdentifier { basic rule test }) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				" | This is a comment\nrule {basic with just NP}\nS=NP ",
				"(patrgrammar (comment | This is a comment\\n) (patrRules (patrRule (ruleKW rule) (ruleIdentifier { basic with just NP }) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP))))) <EOF>)");
		checkValidDescription(
				" | This is a comment\nrule {basic with just NP} | comment after id\nS=NP ",
				"(patrgrammar (comment | This is a comment\\n) (patrRules (patrRule (ruleKW rule) (ruleIdentifier { basic with just NP }) (comment | comment after id\\n) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP))))) <EOF>)");
		checkValidDescription(
				"rule S = NP VP | comment after psr\n",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))) (comment | comment after psr\\n))) <EOF>)");
		// Following gets out of bound exception while processing nonTerminal
		checkValidDescription(
				"rule S = NP VP | comment after psr",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))) (comment | comment after psr))) <EOF>)");
		checkValidDescription(
				"rule\n S = NP_1 V NP_2",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP_1) (nonTerminal V) (nonTerminal NP_2))))) <EOF>)");
		checkValidDescription(
				"rule\n S = NP VP\n<S head cat> = <VP head cat>",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))) (constraints (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head) (featurePath (atomicValue cat))) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal VP) (featurePath (atomicValue head) (featurePath (atomicValue cat))) (closingWedge >))))))) <EOF>)");
		checkValidDescription(
				"Let absolutive be <head case> = absolutive\nrule\n S = NP VP\n",
				"(patrgrammar (featureTemplates (featureTemplate (featureTemplateDefinition Let (featureTemplateName (atomicValue absolutive)) be) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue case))) (closingWedge >)) = (featureTemplateValue (atomicValue absolutive))))) (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"Let transitive.optional be  <head type transitive> = {+ -}\nrule S = NP VP\n",
				"(patrgrammar (featureTemplates (featureTemplate (featureTemplateDefinition Let (featureTemplateName (atomicValue transitive.optional)) be) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue transitive)))) (closingWedge >)) = (featureTemplateValue (featureTemplateDisjunction (openingBrace {) (featurePath (atomicValue +)) (featurePathOrStructure (featurePath (atomicValue -))) (closingBrace })))))) (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription("Let AdjP-final              be  <head type AdjP-final>                      = +\r\n"
				+ "                                <head type AdjP-initial>                    = -\r\n"
				+ "rule\n S = NP VP\r\n",
				"(patrgrammar (featureTemplates (featureTemplate (featureTemplateDefinition Let (featureTemplateName (atomicValue AdjP-final)) be) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue AdjP-final)))) (closingWedge >)) = (featureTemplateValue (atomicValue +)) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue AdjP-initial)))) (closingWedge >)) = (featureTemplateValue (atomicValue -)))))) (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"Let copular_suffix          be  <head type copular_suffix>                  = +\r\n"
				+ "                                    [copular]\r\n"
				+ ""
				+ "rule\n S = NP VP\r\n"
				,
				"(patrgrammar (featureTemplates (featureTemplate (featureTemplateDefinition Let (featureTemplateName (atomicValue copular_suffix)) be) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue copular_suffix)))) (closingWedge >)) = (featureTemplateValue (atomicValue +)) (featurePathTemplateBody (featureTemplateAbbreviation [ (featureTemplateName (atomicValue copular)) ]))))) (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"Let RefPn                   be  [Pron]  | 31Jan03 RL\r\n"
				+ "                                <head type reflexivity>           = +\r\n"
				+ "                                <head type locative>            = !-\r\n"
				+ "				<head type NPrep>		= !-  |22Jul06CB\r\n"
				+ ""
				+ "rule\n S = NP VP\r\n"
				,
				"(patrgrammar (featureTemplates (featureTemplate (featureTemplateDefinition Let (featureTemplateName (atomicValue RefPn)) be) (featurePathTemplateBody (featureTemplateAbbreviation [ (featureTemplateName (atomicValue Pron)) ] (comment | 31Jan03 RL\\r\\n)) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue reflexivity)))) (closingWedge >)) = (featureTemplateValue (atomicValue +)) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue locative)))) (closingWedge >)) = (featureTemplateValue (atomicValue !-)) (featurePathTemplateBody (featurePathUnit (openingWedge <) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue NPrep)))) (closingWedge >)) = (featureTemplateValue (atomicValue !-) (comment |22Jul06CB\\r\\n)))))))) (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"Let causative_syntax                     be   { [head:[infl:[valence:[causative:+]]\r\n"
				+ "                                                       type:[causative_syntax:+]\r\n"
				+ "                                                       embedded:[cat:IP]]]\r\n"
				+ "                                                 [head:[type:[causative_syntax:+\r\n"
				+ "                                                              transitive:+]\r\n"
				+ "                                                        embedded:[cat:none]]] }\r\nrule S = NP VP\r\n",
				"(patrgrammar (featureTemplates (featureTemplate (featureTemplateDefinition Let (featureTemplateName (atomicValue causative_syntax)) "
				+ "be) (featureTemplateValue (featureTemplateDisjunction (openingBrace {) (featureStructure (openingBracket [) (featureStructureName"
			    + " (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue infl)) : "
				+ "(featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue valence)) : (featureStructureValue "
			    + "(featureStructure (openingBracket [) (featureStructureName (atomicValue causative)) : (featureStructureValue (atomicValue +)) "
				+ "(closingBracket ]))) (closingBracket ]))) (embeddedFeatureStructure (featureStructureName (atomicValue type)) : "
			    + "(featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue causative_syntax)) : "
				+ "(featureStructureValue (atomicValue +)) (closingBracket ])))) (embeddedFeatureStructure (featureStructureName (atomicValue "
			    + "embedded)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue cat)) : "
				+ "(featureStructureValue (atomicValue IP)) (closingBracket ])))) (closingBracket ]))) (closingBracket ])) (featurePathOrStructure "
			    + "(featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure "
				+ "(openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) "
			    + "(featureStructureName (atomicValue causative_syntax)) : (featureStructureValue (atomicValue +)) (embeddedFeatureStructure "
				+ "(featureStructureName (atomicValue transitive)) : (featureStructureValue (atomicValue +))) (closingBracket ]))) "
			    + "(embeddedFeatureStructure (featureStructureName (atomicValue embedded)) : (featureStructureValue (featureStructure "
				+ "(openingBracket [) (featureStructureName (atomicValue cat)) : (featureStructureValue (atomicValue none)) (closingBracket ])))) "
			    + "(closingBracket ]))) (closingBracket ]))) (closingBrace }))))) (patrRules (patrRule (ruleKW rule) (phraseStructureRule "
				+ "(nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))))) <EOF>)");
		checkValidDescription(
				"rule {S option start symbol -  final ya na & Quote allowed}\r\n"
				+ "S = {IP / CP} (Conj Deg) (Quote)\r\n"
				+ "    <S head> = <IP head>\r\n"
				+ "    <S head> = <CP head>\r\n"
				+ "    <IP head type root> = +\r\n"
				+ "    <IP head type conj_suffix> = -     | 16Jul03 CB\r\n"
				+ "    <CP head type root> = +\r\n"
				+ "    <CP head type conj_suffix> = -     | 16Jul03 CB\r\n"
				+ "    <CP head type relcl> = -          | 21Nov03 CB\r\n"
				+ "    <Conj gloss> = or\r\n"
				+ "    <Conj head type CP-final> = +\r\n"
				+ "    <Deg head type CP-final> = +\r\n"
				+ "    <Deg head infl polarity> = -\r\n"
				+ "    <S head type initialP> = - \r\n"
				+ "    <IP head type relcl> = -            | not a rel clause 21Nov03 CB\r\n"
				+ "    <CP head type relcl> = -            | not a rel clause 21Nov03 CB\r\n"
				+ "    <S rule> = start\n",
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (ruleIdentifier { S option start symbol - final ya na & Quote allowed }) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (disjunctiveTerminals { (nonTerminal IP) (disjunctionNonTerminal / (nonTerminal CP)) }) (optionalTerminals ( (nonTerminal Conj) (nonTerminal Deg) )) (optionalTerminals ( (nonTerminal Quote) )))) (constraints (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head)) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head)) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal CP) (featurePath (atomicValue head)) (closingWedge >)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue root)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue conj_suffix)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 16Jul03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal CP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue root)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal CP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue conj_suffix)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 16Jul03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal CP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 21Nov03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Conj) (featurePath (atomicValue gloss)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue or)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Conj) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue CP-final)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Deg) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue CP-final)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Deg) (featurePath (atomicValue head) (featurePath (atomicValue infl) (featurePath (atomicValue polarity)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue initialP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | not a rel clause 21Nov03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal CP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | not a rel clause 21Nov03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue start))))))) <EOF>)");
		checkValidDescription(
				"rule {S option startInitDP with DP initial elements and final ya na & Quote allowed}\r\n"
				+ "S = InitP IP (Conj Deg) (Quote)\r\n"
				+ "    <S head> = <IP head>\r\n"
				+ "    <IP head subject> = <InitP head subject> | pass reflexive info\r\n"
				+ "    <IP head type root> = +\r\n"
				+ "    <IP head type pro-drop> = -     | 28May19 \r\n"
				+ "    <IP head type conj_suffix> = -     | 16Jul03 CB\r\n"
				+ "    <InitP head type root> = + \r\n"
				+ "    <Conj gloss> = or\r\n"
				+ "    <Conj head type CP-final> = +\r\n"
				+ "    <Deg head type CP-final> = +\r\n"
				+ "    <Deg head infl polarity> = -\r\n"
				+ "    <S head type initialP> = + \r\n"
				+ "    {<InitP head type relcl> = -  | 03Apr03 CB\r\n"
				+ "    /<InitP head type relcl> = +  |  relcl in InitP only with overt subject\r\n"
				+ "     <IP head type pro-drop> = -\r\n"
				+ "    }\r\n"
				+ "    <InitP head type DP> = +              | 17Feb03 CB for generic/reflex\r\n"
				+ "    <InitP head type PP> = -              | 17Feb03 CB for generic/reflex\r\n"
				+ "    <IP head type relcl> = -            | not a rel clause 21Nov03 CB\r\n"
				+ "    <S rule> = startInitDP\r\n"
				,
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (ruleIdentifier { S option startInitDP with DP initial elements and final ya na & Quote allowed }) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal InitP) (nonTerminal IP) (optionalTerminals ( (nonTerminal Conj) (nonTerminal Deg) )) (optionalTerminals ( (nonTerminal Quote) )))) (constraints (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head)) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue subject))) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue subject))) (closingWedge >) (comment | pass reflexive info\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue root)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue pro-drop)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 28May19 \\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue conj_suffix)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 16Jul03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue root)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Conj) (featurePath (atomicValue gloss)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue or)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Conj) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue CP-final)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Deg) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue CP-final)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Deg) (featurePath (atomicValue head) (featurePath (atomicValue infl) (featurePath (atomicValue polarity)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue initialP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (disjunctiveUnificationConstraint { (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 03Apr03 CB\\r\\n))) (disjunctionUnificationConstraint / (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +) (comment |  relcl in InitP only with overt subject\\r\\n))) (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue pro-drop)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) }))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue DP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +) (comment | 17Feb03 CB for generic/reflex\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue PP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 17Feb03 CB for generic/reflex\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | not a rel clause 21Nov03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue startInitDP))))))) <EOF>)");
		checkValidDescription(
				"rule {S option startInitDP with DP initial elements and final ya na & Quote allowed}\r\n"
				+ "S = InitP IP (Conj Deg) (Quote)\r\n"
				+ "    <S head> = <IP head>\r\n"
                  // skipping unification constraints to test logical constraint
				+ "| don't split coordination - these replace logical constraints in subject rules that incorrectly eliminated even adverbial InitPs 17Apr03 CB\r\n"
				+ "    <IP head> == ~([subject:[head:[type:[coordination:+]]]] \r\n"
				+ "                   & [type:[pro-drop:-]])\r\n"
				+ "    <IP head> == ~([object:[head:[type:[coordination:+]]]] \r\n"
				+ "                   & [type:[pro-drop:+]])\r\n"
				+ "    <IP head type relcl> = -            | not a rel clause 21Nov03 CB\r\n"
				+ "    <S rule> = startInitDP\r\n"
				,
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (ruleIdentifier { S option startInitDP with DP initial elements and final ya na & Quote allowed }) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal InitP) (nonTerminal IP) (optionalTerminals ( (nonTerminal Conj) (nonTerminal Deg) )) (optionalTerminals ( (nonTerminal Quote) )))) (constraints (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (atomicValue head)) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >) (comment | don't split coordination - these replace logical constraints in subject rules that incorrectly eliminated even adverbial InitPs 17Apr03 CB\\r\\n)))) (constraint (logicalConstraint (logConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >)) == (logConstraintExpression ~ (logConstraintFactor ( (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue subject)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue coordination)) : (featureStructureValue (atomicValue +)) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (binop &) (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue pro-drop)) : (featureStructureValue (atomicValue -)) (closingBracket ]))) (closingBracket ])))) ))))) (constraint (logicalConstraint (logConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >)) == (logConstraintExpression ~ (logConstraintFactor ( (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue object)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue coordination)) : (featureStructureValue (atomicValue +)) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (binop &) (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue pro-drop)) : (featureStructureValue (atomicValue +)) (closingBracket ]))) (closingBracket ])))) ))))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue relcl)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | not a rel clause 21Nov03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal S) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue startInitDP))))))) <EOF>)");
		checkValidDescription(
				"rule {InitP option address - DP address or focus/topic - root or nonroot}\r\n"
				+ "InitP = (Conj / Excl) DP\r\n"
				+ "    <InitP head> = <DP head>\r\n"
				+ "    <InitP head type initialP> = +     | restrict conjunctions here and in DP \r\n"
				+ "    <InitP head type comma> = +        | must have comma\r\n"
				+ "    <InitP head subject> = <DP head reflexive> | pass reflexive info\r\n"
				+ "    <Conj head type CP-initial> = +\r\n"
				+ "    <DP head type coordination> = -       | not a DP coordination construction\r\n"
				+ "    <DP head type nonfinalcoordination> = -\r\n"
				+ "    <DP head type DO_contraction> = -   | 17Feb03 CB\r\n"
				+ "    <DP head type case-marked> = -\r\n"
				+ "    <DP head case> = nominative\r\n"
				+ "    <DP head case_for_position> = direct  | for apposition \r\n"
				+ "    <DP head case_for_position_front> = direct  | for apposition \r\n"
				+ "    <DP head case_for_position_front_and> = direct  | for apposition \r\n"
				+ "    <DP head case_for_position_front_and_center> = direct  | for apposition \r\n"
				+ "    <InitP head type PP> = -          | 17Feb03 CB\r\n"
				+ "    <InitP head type DP> = +          | 17Feb03 CB\r\n"
				+ "    <DP head type> == [relative:+] -> [relcl:+]      | require rel suffix to only occur when relative clause present\r\n"
				+ "    <InitP rule> = address\r\n"
				,
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (ruleIdentifier { InitP option address - DP address or focus/topic - root or nonroot }) (phraseStructureRule (nonTerminal InitP) (ruleDef =) (rightHandSide (disjunctiveOptionalNonTerminal ( (nonTerminal Conj) (disjunctionOptionalNonTerminal / (nonTerminal Excl)) )) (nonTerminal DP))) (constraints (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head)) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head)) (closingWedge >)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue initialP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +) (comment | restrict conjunctions here and in DP \\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue comma)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +) (comment | must have comma\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue subject))) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue reflexive))) (closingWedge >) (comment | pass reflexive info\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal Conj) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue CP-initial)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue coordination)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | not a DP coordination construction\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue nonfinalcoordination)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue DO_contraction)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 17Feb03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue case-marked)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue nominative)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case_for_position))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue direct) (comment | for apposition \\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case_for_position_front))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue direct) (comment | for apposition \\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case_for_position_front_and))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue direct) (comment | for apposition \\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case_for_position_front_and_center))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue direct) (comment | for apposition \\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue PP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -) (comment | 17Feb03 CB\\r\\n)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue DP)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +) (comment | 17Feb03 CB\\r\\n)))) (constraint (logicalConstraint (logConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type))) (closingWedge >)) == (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue relative)) : (featureStructureValue (atomicValue +)) (closingBracket ]))) (binop ->) (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue relcl)) : (featureStructureValue (atomicValue +)) (closingBracket ]) (comment | require rel suffix to only occur when relative clause present\\r\\n)))))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal InitP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue address))))))) <EOF>)");
		checkValidDescription(
				"rule {IP option 0a-DP - missing final verb IPs}\r\n"
				+ "IP = IP_1 Conj DP\r\n"
				+ "    <IP head> = <IP_1 head>\r\n"
				+ "    <IP head subject> = <DP head reflexive> | pass reflexive info\r\n"
				+ "    {<DP head case> = direct\r\n"
				+ "     <DP head type case-marked> = -\r\n"
				+ "    /<DP head case> = objective\r\n"
				+ "     <DP head type case-marked> = +\r\n"
				+ "    }\r\n"
				+ "    <DP head type coordination> = -\r\n"
				+ "    <IP head type conjoined> <= +   | mark for checking compounding constraints (special case with relcl2+kh and 5c) 20Oct03 CB\r\n"
				+ "|?|    <IP head type final-conjunct compounds_with1> = <DP head type compounds_with1>\r\n"
				+ "|?|    <IP head type final-conjunct compounds_with2> = <DP head type compounds_with2>\r\n"
				+ "|?|    <IP head type final-conjunct compounds_with3> = <DP head type compounds_with3>\r\n"
				+ "|?|    <IP head type final-conjunct compounds_with4> = <DP head type compounds_with4>\r\n"
				+ "    <IP head type comma> <= <DP head type comma>  | comma placement for InitP\r\n"
				+ "    <DP head type> == [relative:+] -> [relcl:+]      | require rel suffix to only occur when relative clause present\r\n"
				+ "    <Conj> == ~[gloss:namely]\r\n"
				+ "    <IP rule> = 0a-DP\r\n"
				+ "    <IP rule> = start\r\n"
				+ "    <IP rule> = 1\r\n"
				+ "    <IP rule> = address2\r\n"
				+ "    <IP rule> = 2cNon-ImpersonalV-PastIntransitive\r\n"
				+ "    <IP rule> = F.able\r\n"
				+ "    <IP rule> = DPCopSuf\r\n"
				+ "    <IP rule> = object_relcl\r\n"
				+ "    <IP rule> = double-temporal\r\n"
				,
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (ruleIdentifier { IP option 0a-DP - missing final verb IPs }) (phraseStructureRule (nonTerminal IP) (ruleDef =) (rightHandSide (nonTerminal IP_1) (nonTerminal Conj) (nonTerminal DP))) (constraints (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal IP_1) (featurePath (atomicValue head)) (closingWedge >)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue subject))) (closingWedge >)) = (uniConstraintRightHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue reflexive))) (closingWedge >) (comment | pass reflexive info\\r\\n)))) (constraint (unificationConstraint (disjunctiveUnificationConstraint { (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue direct))) (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue case-marked)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -))) (disjunctionUnificationConstraint / (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue case))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue objective))) (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue case-marked)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue +)))) }))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue coordination)))) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue -)))) (constraint (priorityUnionConstraint (priorityUnionLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue conjoined)))) (closingWedge >)) <= (priorityUnionRightHandSide (atomicValue +)) (comment | mark for checking compounding constraints (special case with relcl2+kh and 5c) 20Oct03 CB\\r\\n))) (constraint (comment |?|    <IP head type final-conjunct compounds_with1> = <DP head type compounds_with1>\\r\\n)) (constraint (comment |?|    <IP head type final-conjunct compounds_with2> = <DP head type compounds_with2>\\r\\n)) (constraint (comment |?|    <IP head type final-conjunct compounds_with3> = <DP head type compounds_with3>\\r\\n)) (constraint (comment |?|    <IP head type final-conjunct compounds_with4> = <DP head type compounds_with4>\\r\\n)) (constraint (priorityUnionConstraint (priorityUnionLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue comma)))) (closingWedge >)) <= (priorityUnionRightHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type) (featurePath (atomicValue comma)))) (closingWedge >)) (comment | comma placement for InitP\\r\\n))) (constraint (logicalConstraint (logConstraintLeftHandSide (openingWedge <) (nonTerminal DP) (featurePath (atomicValue head) (featurePath (atomicValue type))) (closingWedge >)) == (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue relative)) : (featureStructureValue (atomicValue +)) (closingBracket ]))) (binop ->) (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue relcl)) : (featureStructureValue (atomicValue +)) (closingBracket ]) (comment | require rel suffix to only occur when relative clause present\\r\\n)))))) (constraint (logicalConstraint (logConstraintLeftHandSide (openingWedge <) (nonTerminal Conj) (closingWedge >)) == (logConstraintExpression ~ (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue gloss)) : (featureStructureValue (atomicValue namely)) (closingBracket ])))))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue 0a-DP)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue start)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue 1)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue address2)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue 2cNon-ImpersonalV-PastIntransitive)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue F.able)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue DPCopSuf)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue object_relcl)))) (constraint (unificationConstraint (uniConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (ruleKW rule)) (closingWedge >)) = (uniConstraintRightHandSide (atomicValue double-temporal))))))) <EOF>)");
		checkValidDescription(
				"rule\n S = NP VP\r\n"
				+ "    <IP head> == [rootgloss:^1] ->\r\n"
				+ "                 ~ ( [type:[no_intervening:+]] &    \r\n"
				+ "                   (( [subject:[head:[type:[compounds_with1:^1]]]]\r\n"
				+ "                    / [subject:[head:[type:[compounds_with2:^1]]]])\r\n"
				+ "                    / ([subject:[head:[type:[compounds_with3:^1]]]]\r\n"
				+ "                    / [subject:[head:[type:[compounds_with4:^1]]]]) ) )\r\n"
				,
				"(patrgrammar (patrRules (patrRule (ruleKW rule) (phraseStructureRule (nonTerminal S) (ruleDef =) (rightHandSide (nonTerminal NP) (nonTerminal VP))) (constraints (constraint (logicalConstraint (logConstraintLeftHandSide (openingWedge <) (nonTerminal IP) (featurePath (atomicValue head)) (closingWedge >)) == (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue rootgloss)) : (featureStructureValue (atomicValue ^1)) (closingBracket ]))) (binop ->) ~ (logConstraintFactor ( (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue no_intervening)) : (featureStructureValue (atomicValue +)) (closingBracket ]))) (closingBracket ]))) (binop &) (logConstraintFactor ( (logConstraintExpression (logConstraintFactor ( (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue subject)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue compounds_with1)) : (featureStructureValue (atomicValue ^1)) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (binop /) (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue subject)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue compounds_with2)) : (featureStructureValue (atomicValue ^1)) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (closingBracket ])))) )) (binop /) (logConstraintFactor ( (logConstraintExpression (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue subject)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue compounds_with3)) : (featureStructureValue (atomicValue ^1)) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (binop /) (logConstraintFactor (featureStructure (openingBracket [) (featureStructureName (atomicValue subject)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue head)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue type)) : (featureStructureValue (featureStructure (openingBracket [) (featureStructureName (atomicValue compounds_with4)) : (featureStructureValue (atomicValue ^1)) (closingBracket ]))) (closingBracket ]))) (closingBracket ]))) (closingBracket ])))) ))) ))) )))))))) <EOF>)");
		// Recognize a large grammar
		File largeGrammarFile = new File(Constants.UNIT_TEST_DATA_FILE);
		File largeGrammarExpectedResultsFile = new File(Constants.UNIT_TEST_LARGE_GRAMMAR_RECOGNIZER_EXPECTED_RESULTS_FILE);
		try {
			String largeFileContent = new String(Files.readAllBytes(largeGrammarFile.toPath()),
					StandardCharsets.UTF_8);
			String largeFileExpectedResults = new String(Files.readAllBytes(largeGrammarExpectedResultsFile.toPath()),
					StandardCharsets.UTF_8);
			checkValidDescription(largeFileContent, largeFileExpectedResults);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void checkValidDescription(String sDescription, String sANTLRTree) {
		PcPatrGrammarParser parser = parseAString(sDescription);
		int numErrors = parser.getNumberOfSyntaxErrors();
		assertEquals(0, numErrors);
		ParseTree tree = parser.patrgrammar();
		assertEquals(sANTLRTree, tree.toStringTree(parser));
	}

	private PcPatrGrammarParser parseAString(String sInput) {
		CharStream input = CharStreams.fromString(sInput);
		PcPatrGrammarLexer lexer = new PcPatrGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		System.out.println(tokens.getTokenSource().getInputStream().toString());
//		for (Token t : lexer.getAllTokens())
//		{
//			System.out.println("type=" + t.getType() + "; content='" + t.getText() +"'");
//		}
		PcPatrGrammarParser parser = new PcPatrGrammarParser(tokens);
		return parser;
	}

	private PcPatrGrammarParser parseAStringExpectFailure(String sInput) {
		CharStream input = CharStreams.fromString(sInput);
		PcPatrGrammarLexer lexer = new PcPatrGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PcPatrGrammarParser parser = new PcPatrGrammarParser(tokens);
		parser.removeErrorListeners();
		VerboseListener errListener = new PcPatrGrammarErrorListener.VerboseListener();
		errListener.clearErrorMessageList();
		parser.addErrorListener(errListener);
		// begin parsing at rule 'description'
		ParseTree tree = parser.patrgrammar();
		// uncomment the next two lines to see what parsed
//		String sTree = tree.toStringTree(parser);
//		System.out.println(sTree);
		return parser;
	}

	@Test
	public void invalidDescriptionsTest() {
		checkInvalidDescription("(S NP) (VP))", PcPatrGrammarConstants.CONTENT_AFTER_COMPLETED_TREE, 7, 1);
		checkInvalidDescription("S (NP (VP))", PcPatrGrammarConstants.MISSING_OPENING_PAREN, 0, 1);
		checkInvalidDescription("\\O (NP (VP))", PcPatrGrammarConstants.MISSING_OPENING_PAREN, 0, 1);
		checkInvalidDescription("\\L (NP (VP))", PcPatrGrammarConstants.MISSING_OPENING_PAREN, 0, 1);
		checkInvalidDescription("(S \\O (NP (VP))", PcPatrGrammarConstants.MISSING_OPENING_PAREN, 6, 2);
		checkInvalidDescription("(S \\L (NP (VP))", PcPatrGrammarConstants.MISSING_OPENING_PAREN, 6, 2);
		checkInvalidDescription("(S (NP (VP))", PcPatrGrammarConstants.MISSING_CLOSING_PAREN, 10, 1);
		checkInvalidDescription("(S (NP (VP)", PcPatrGrammarConstants.MISSING_CLOSING_PAREN, 10, 2);
		checkInvalidDescription("(\\O\\TS (NP) (VP))", PcPatrGrammarConstants.TOO_MANY_lINE_TYPES, 5,
				1);
		checkInvalidDescription("(\\T\\OS (NP) (VP))", PcPatrGrammarConstants.TOO_MANY_lINE_TYPES, 5,
				1);
		checkInvalidDescription("(NP (\\L\\Gnoun))", PcPatrGrammarConstants.TOO_MANY_NODE_TYPES, 9, 1);
		checkInvalidDescription("(NP (\\E\\Gnoun))", PcPatrGrammarConstants.TOO_MANY_NODE_TYPES, 9, 1);
		checkInvalidDescription("(NP (\\L\\Enoun))", PcPatrGrammarConstants.TOO_MANY_NODE_TYPES, 9, 1);
		checkInvalidDescription("(NP/s)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUBSCRIPT, 5, 1);
		checkInvalidDescription("(NP/_)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUBSCRIPT, 5, 1);
		checkInvalidDescription("(NP/s/Sb)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUBSCRIPT, 5, 1);
		checkInvalidDescription("(NP/_/^a)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUBSCRIPT, 5, 1);
		checkInvalidDescription("(NP/S)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUPERSCRIPT, 5, 1);
		checkInvalidDescription("(NP/^)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUPERSCRIPT, 5, 1);
		checkInvalidDescription("(NP/S/sb)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUPERSCRIPT, 5, 1);
		checkInvalidDescription("(NP/^/_a)", PcPatrGrammarConstants.MISSING_CONTENT_AFTER_SUPERSCRIPT, 5, 1);
	}

	private void checkInvalidDescription(String sDescription, String sFailedPortion, int iPos,
			int iNumErrors) {
		PcPatrGrammarParser parser = parseAStringExpectFailure(sDescription);
		assertEquals(iNumErrors, parser.getNumberOfSyntaxErrors());
		VerboseListener errListener = (VerboseListener) parser.getErrorListeners().get(0);
		assertNotNull(errListener);
		PcPatrGrammarErrorInfo info = errListener.getErrorMessages().get(0);
		assertNotNull(info);
		assertEquals(sFailedPortion, info.getMsg());
		assertEquals(iPos, info.getCharPositionInLine());
	}

}
