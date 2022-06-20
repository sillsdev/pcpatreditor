/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.LogicalConstraint;
import org.sil.pcpatreditor.model.LogicalConstraintFactor;
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.LogicalConstraintExpression;
import org.sil.pcpatreditor.model.BinaryOperation;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.Constraint;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
import org.sil.pcpatreditor.model.FeaturePath;
import org.sil.pcpatreditor.model.FeaturePathTemplateBody;
import org.sil.pcpatreditor.model.FeaturePathUnit;
import org.sil.pcpatreditor.model.FeatureStructure;
import org.sil.pcpatreditor.model.FeatureTemplateDisjunction;
import org.sil.pcpatreditor.model.FeatureTemplateValue;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PriorityUnionConstraint;
import org.sil.pcpatreditor.model.UnificationConstraint;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarLexer;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;
/**
 * @author Andy Black
 *
 */
public class BuildGrammarFromPcPatrGrammarListenerTest extends BuildGrammarTestBase {

	@Test
	public void buildFeatureTemplateTest() {
		checkFeatureTemplate("Let poss_first be [poss_exclusive]", "poss_first");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		assertEquals("poss_exclusive", featurePathTemplateBody.getFeatureTemplateAbbreviation());

		checkFeatureTemplate("Let copular_suffix be <head type copular_suffix> = +\r\n"
				+ "[copular]"
				, "copular_suffix");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		checkFeaturePathUnit(featurePathTemplateBody.getFeaturePathUnit(), "head type copular_suffix");
		checkFeatureTemplateAtomicValue(featurePathTemplateBody, "+");
		embeddedFeaturePathTemplateBody = featurePathTemplateBody.getFeaturePathTemplateBody();
		assertEquals("copular", embeddedFeaturePathTemplateBody.getFeatureTemplateAbbreviation());

		checkFeatureTemplate("Let Cop be <cat> = !V\r\n"
				+ "[V]\r\n"
				+ "[copular]"
				, "Cop");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		checkFeaturePathUnit(featurePathTemplateBody.getFeaturePathUnit(), "cat");
		checkFeatureTemplateAtomicValue(featurePathTemplateBody, "!V");
		embeddedFeaturePathTemplateBody = featurePathTemplateBody.getFeaturePathTemplateBody();
		assertEquals("V", embeddedFeaturePathTemplateBody.getFeatureTemplateAbbreviation());
		embeddedFeaturePathTemplateBody = embeddedFeaturePathTemplateBody.getFeaturePathTemplateBody();
		assertEquals("copular", embeddedFeaturePathTemplateBody.getFeatureTemplateAbbreviation());

		checkFeatureTemplate("Let direct be <head case> = direct", "direct");
		checkFeaturePathUnit(featureTemplate.getFeaturePathTemplateBody().getFeaturePathUnit(), "head case");
		checkFeatureTemplateAtomicValue(featureTemplate.getFeaturePathTemplateBody(), "direct");

		checkFeatureTemplate("Let generic be <head type generic> = +", "generic");
		checkFeaturePathUnit(featureTemplate.getFeaturePathTemplateBody().getFeaturePathUnit(), "head type generic");
		checkFeatureTemplateAtomicValue(featureTemplate.getFeaturePathTemplateBody(), "+");

		checkFeatureTemplate("Let generic be <head type generic> = !+", "generic");
		checkFeaturePathUnit(featureTemplate.getFeaturePathTemplateBody().getFeaturePathUnit(), "head type generic");
		checkFeatureTemplateAtomicValue(featureTemplate.getFeaturePathTemplateBody(), "!+");

		checkFeatureTemplate("Let first_object be <head object head agr person first> = +\r\n"
				+ "<head object head agr person second> = -\r\n"
				+ "<head object head agr person third> = -\r\n"
				+ "<head type object_agr_suffix> = +", "first_object");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		checkFeaturePathUnit(featureTemplate.getFeaturePathTemplateBody().getFeaturePathUnit(), "head object head agr person first");
		checkFeatureTemplateAtomicValue(featurePathTemplateBody, "+");
		embeddedFeaturePathTemplateBody = featurePathTemplateBody.getFeaturePathTemplateBody();
		checkFeaturePathUnit(embeddedFeaturePathTemplateBody.getFeaturePathUnit(), "head object head agr person second");
		checkFeatureTemplateAtomicValue(embeddedFeaturePathTemplateBody, "-");
		embeddedFeaturePathTemplateBody = embeddedFeaturePathTemplateBody.getFeaturePathTemplateBody();
		checkFeaturePathUnit(embeddedFeaturePathTemplateBody.getFeaturePathUnit(), "head object head agr person third");
		checkFeatureTemplateAtomicValue(embeddedFeaturePathTemplateBody, "-");
		embeddedFeaturePathTemplateBody = embeddedFeaturePathTemplateBody.getFeaturePathTemplateBody();
		checkFeaturePathUnit(embeddedFeaturePathTemplateBody.getFeaturePathUnit(), "head type object_agr_suffix");
		checkFeatureTemplateAtomicValue(embeddedFeaturePathTemplateBody, "+");

		checkFeatureTemplate("Let compounds_with_آوردن،داشتن be <head type compounds_with1> = آوردن\r\n"
				+ "<head type compounds_with2> = داشتن\r\n"
				+ "<head type compound> = +", "compounds_with_آوردن،داشتن");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		checkFeaturePathUnit(featureTemplate.getFeaturePathTemplateBody().getFeaturePathUnit(), "head type compounds_with1");
		checkFeatureTemplateAtomicValue(featurePathTemplateBody, "آوردن");
		embeddedFeaturePathTemplateBody = featurePathTemplateBody.getFeaturePathTemplateBody();
		checkFeaturePathUnit(embeddedFeaturePathTemplateBody.getFeaturePathUnit(), "head type compounds_with2");
		checkFeatureTemplateAtomicValue(embeddedFeaturePathTemplateBody, "داشتن");
		embeddedFeaturePathTemplateBody = embeddedFeaturePathTemplateBody.getFeaturePathTemplateBody();
		checkFeaturePathUnit(embeddedFeaturePathTemplateBody.getFeaturePathUnit(), "head type compound");
		checkFeatureTemplateAtomicValue(embeddedFeaturePathTemplateBody, "+");

		checkFeatureTemplate("Let -accusative be <head case> = {nominative genitive dative}", "-accusative");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		checkFeaturePathUnit(featurePathTemplateBody.getFeaturePathUnit(), "head case");
		atomicValueDisjunction = featurePathTemplateBody.getAtomicValueDisjunction();
		assertEquals(3, atomicValueDisjunction.getAtomicValues().size());
		assertEquals("nominative", atomicValueDisjunction.getAtomicValues().get(0));
		assertEquals("genitive", atomicValueDisjunction.getAtomicValues().get(1));
		assertEquals("dative", atomicValueDisjunction.getAtomicValues().get(2));

		checkFeatureTemplate("Let causative_syntax be { [head:[infl:[valence:[causative:+]]\r\n"
				+ "type:[causative_syntax:+]\r\n"
				+ "embedded:[cat:IP]]]\r\n"
				+ "[head:[type:[causative_syntax:+\r\n"
				+ "transitive:+]\r\n"
				+ "embedded:[cat:none]]] }"
				, "causative_syntax");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		featureTemplateDisjunction = featurePathTemplateBody.getFeatureTemplateDisjunction();
		assertEquals(2, featureTemplateDisjunction.getContents().size());
		featurePathOrStructure = featureTemplateDisjunction.getContents().get(0);
		assertNotNull(featurePathOrStructure);
		featureStructure = featurePathOrStructure.getFeatureStructure();
		assertEquals("head", featureStructure.getName());
		nestedFeatureStructure = checkNestedFeatureStructure("infl", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("valence", featureStructureValue.getFeatureStructure());
		nestedFeatureStructure = checkNestedFeatureStructure("causative", featureStructureValue.getFeatureStructure());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		nestedFeatureStructure = featureStructure.getValue().getFeatureStructure();
		assertEquals(2, nestedFeatureStructure.getEmbeddedFeatureStructures().size());
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(0);
		assertEquals("type", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		nestedFeatureStructure = featureStructureValue.getFeatureStructure();
		assertEquals("causative_syntax", nestedFeatureStructure.getName());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		nestedFeatureStructure = featureStructure.getValue().getFeatureStructure();
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(1);
		assertEquals("embedded", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		nestedFeatureStructure = featureStructureValue.getFeatureStructure();
		assertEquals("cat", nestedFeatureStructure.getName());
		assertEquals("IP", nestedFeatureStructure.getValue().getAtomicValue());

		featurePathOrStructure = featureTemplateDisjunction.getContents().get(1);
		assertNotNull(featurePathOrStructure);
		featureStructure = featurePathOrStructure.getFeatureStructure();
		assertEquals("head", featureStructure.getName());
		nestedFeatureStructure = checkNestedFeatureStructure("type", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("causative_syntax", featureStructureValue.getFeatureStructure());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(0);
		assertEquals("transitive", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());

		nestedFeatureStructure = featureStructure.getValue().getFeatureStructure();
		assertEquals(1, nestedFeatureStructure.getEmbeddedFeatureStructures().size());
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(0);
		assertEquals("embedded", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		nestedFeatureStructure = featureStructureValue.getFeatureStructure();
		assertEquals("cat", nestedFeatureStructure.getName());
		assertEquals("none", nestedFeatureStructure.getValue().getAtomicValue());

	}

	protected FeatureStructure checkNestedFeatureStructure(String name, FeatureStructure fs) {
		featureStructureValue = fs.getValue();
		assertNull(featureStructureValue.getAtomicValue());
		nestedFeatureStructure = featureStructureValue.getFeatureStructure();
		assertNotNull(nestedFeatureStructure);
		assertEquals(name, nestedFeatureStructure.getName());
		return nestedFeatureStructure;
	}

	protected void checkFeatureTemplateDisjunctiveValue(String sDisjunction) {
		featureTemplateValue = featureTemplate.getFeaturePathTemplateBody().getFeatureTemplateValue();
		FeatureTemplateDisjunction ftdisj = featureTemplateValue.getFeatureTemplateDisjunction();
		assertNotNull(ftdisj);
		assertEquals(sDisjunction, ftdisj.pathRepresentation());
		assertEquals(null, featureTemplateValue.getAtomicValue());
		assertEquals(null, featureTemplateValue.getFeaturePath());
	}

	protected void checkFeatureTemplateAtomicValue(FeaturePathTemplateBody fptb, String value) {
		FeatureTemplateValue featureTemplateValue = fptb.getFeatureTemplateValue();
		assertEquals(value, featureTemplateValue.getAtomicValue());
		assertEquals(null, featureTemplateValue.getFeaturePath());
		assertEquals(null, featureTemplateValue.getFeatureTemplateDisjunction());
	}

	protected void checkFeaturePath(FeaturePath fp, String sPath) {
		assertEquals(sPath, fp.pathRepresentation());
	}

	protected void checkFeaturePathUnit(FeaturePathUnit featurePathUnit, String sPath) {
		assertEquals(sPath, featurePathUnit.pathRepresentation());
	}

	@Test
	public void buildPhraseStructureRuleTest() {
		psr = checkPhraseStuctureRule(1, "testing 1, 2, 3", "S = NP VP", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(2, rhs.size());
		constituent = (Constituent)rhs.get(0);
		checkConstituentSymbol(constituent, "NP");
		constituent = (Constituent)rhs.get(1);
		checkConstituentSymbol(constituent, "VP");

		psr = checkPhraseStuctureRule(1, "testing", "S = AdvP / DP", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(2, rhs.size());
		constituent = (Constituent)rhs.get(0);
		checkConstituentSymbol(constituent, "AdvP");
		disjion = (DisjunctionConstituents)rhs.get(1);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "DP");

		psr = checkPhraseStuctureRule(1,
				"S option startInitPP symbol with PP initial elements and final ya na & Quote allowed",
				"S = InitP {IP / CP} (Conj Deg) (Quote)", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(4, rhs.size());
//		// testing for the PSR combination so we won't look further here
//
		psr = checkPhraseStuctureRule(1, "", "S = NP_1 V NP_2", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(3, rhs.size());
		constituent = (Constituent)rhs.get(0);
		checkConstituentSymbol(constituent, "NP_1");
		constituent = (Constituent)rhs.get(1);
		checkConstituentSymbol(constituent, "V");
		constituent = (Constituent)rhs.get(2);
		checkConstituentSymbol(constituent, "NP_2");

		psr = checkPhraseStuctureRule(1, "", "S = NP_1 V (NP_2 ({Adv / Adj (P)}))", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(3, rhs.size());
		constituent = (Constituent)rhs.get(0);
		checkConstituentSymbol(constituent, "NP_1");
		constituent = (Constituent)rhs.get(1);
		checkConstituentSymbol(constituent, "V");
		optionalConstituents = (OptionalConstituents)rhs.get(2);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "NP_2");
		optionalConstituents2 = (OptionalConstituents)optionalConstituents.getContents().get(1);
		assertNotNull(optionalConstituents2);
		assertEquals(1, optionalConstituents2.getContents().size());
		disjive = (DisjunctiveConstituents)optionalConstituents2.getContents().get(0);
		constituent = (Constituent)disjive.getContents().get(0);
		checkConstituentSymbol(constituent, "Adv");
		disjion = (DisjunctionConstituents)disjive.getContents().get(1);
		assertNotNull(disjion);
		assertEquals(2, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "Adj");
		optionalConstituents3 = (OptionalConstituents)disjion.getContents().get(1);
		assertNotNull(optionalConstituents3);
		assertEquals(1, optionalConstituents3.getContents().size());
		constituent = (Constituent)optionalConstituents3.getContents().get(0);
		checkConstituentSymbol(constituent, "P");

		psr = checkPhraseStuctureRule(1, "S option start symbol - final ya na & Quote allowed", "S = {IP / CP} (Conj Deg) (Quote)", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(3, rhs.size());
		disjive = (DisjunctiveConstituents) rhs.get(0);
		assertNotNull(disjive);
		assertEquals(2, disjive.getContents().size());
		constituent = (Constituent)disjive.getContents().get(0);
		checkConstituentSymbol(constituent, "IP");
		disjion = (DisjunctionConstituents)disjive.getContents().get(1);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "CP");
		optionalConstituents = (OptionalConstituents)rhs.get(1);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "Conj");
		constituent = (Constituent)optionalConstituents.getContents().get(1);
		checkConstituentSymbol(constituent, "Deg");
		optionalConstituents = (OptionalConstituents)rhs.get(2);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "Quote");

		psr = checkPhraseStuctureRule(1, "S option start symbol - final ya na & Quote allowed", "S = {IP DP / CP Conj Det} (Conj) (Det Quote)", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(3, rhs.size());
		disjive = (DisjunctiveConstituents) rhs.get(0);
		assertNotNull(disjive);
		assertEquals(3, disjive.getContents().size());
		constituent = (Constituent)disjive.getContents().get(0);
		checkConstituentSymbol(constituent, "IP");
		constituent = (Constituent)disjive.getContents().get(1);
		checkConstituentSymbol(constituent, "DP");
		disjion = (DisjunctionConstituents)disjive.getContents().get(2);
		assertNotNull(disjion);
		assertEquals(3, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "CP");
		constituent = (Constituent)disjion.getContents().get(1);
		checkConstituentSymbol(constituent, "Conj");
		constituent = (Constituent)disjion.getContents().get(2);
		checkConstituentSymbol(constituent, "Det");
		optionalConstituents = (OptionalConstituents)rhs.get(1);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "Conj");
		optionalConstituents = (OptionalConstituents)rhs.get(2);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "Det");
		constituent = (Constituent)optionalConstituents.getContents().get(1);
		checkConstituentSymbol(constituent, "Quote");

		psr = checkPhraseStuctureRule(1, "VP option 5cPastNew - V final, transitive",
				"VP = DP ({PP / {DP_1 / AdvP} / PP_1 {DP_1 / AdvP} / {DP_2 / AdvP} PP / PP_1 {DP_2 / AdvP} PP}) V (CP)",
				"VP");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(4, rhs.size());
		// DP
		constituent = (Constituent) rhs.get(0);
		checkConstituentSymbol(constituent, "DP");
		// ({PP / {DP_1 / AdvP} / PP_1 {DP_1 / AdvP} / {DP_2 / AdvP} PP / PP_1 {DP_2 / AdvP} PP})
		optionalConstituents = (OptionalConstituents)rhs.get(1);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		disjive = (DisjunctiveConstituents) optionalConstituents.getContents().get(0);
		assertNotNull(disjive);
		// {PP / {DP_1 / AdvP} / PP_1 {DP_1 / AdvP} / {DP_2 / AdvP} PP / PP_1 {DP_2 / AdvP} PP}
		assertEquals(5, disjive.getContents().size());
		constituent = (Constituent)disjive.getContents().get(0);
		checkConstituentSymbol(constituent, "PP");
		// {DP_1 / AdvP}
		disjion = (DisjunctionConstituents)disjive.getContents().get(1);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		disjive2 = (DisjunctiveConstituents) disjion.getContents().get(0);
		assertNotNull(disjive2);
		assertEquals(2, disjive2.getContents().size());
		constituent = (Constituent)disjive2.getContents().get(0);
		checkConstituentSymbol(constituent, "DP_1");
		disjion2 = (DisjunctionConstituents)disjive2.getContents().get(1);
		assertNotNull(disjion2);
		assertEquals(1, disjion2.getContents().size());
		constituent = (Constituent)disjion2.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		// PP_1 {DP_1 / AdvP}
		disjion = (DisjunctionConstituents) disjive.getContents().get(2);
		assertNotNull(disjion);
		assertEquals(2, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_1");
		disjive2 = (DisjunctiveConstituents) disjion.getContents().get(1);
		assertNotNull(disjive2);
		assertEquals(2, disjive2.getContents().size());
		constituent = (Constituent)disjive2.getContents().get(0);
		checkConstituentSymbol(constituent, "DP_1");
		disjion2 = (DisjunctionConstituents)disjive2.getContents().get(1);
		assertNotNull(disjion2);
		assertEquals(1, disjion2.getContents().size());
		constituent = (Constituent)disjion2.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		// {DP_2 / AdvP} PP
		disjion = (DisjunctionConstituents) disjive.getContents().get(3);
		assertNotNull(disjion);
		assertEquals(2, disjion.getContents().size());
		disjive2 = (DisjunctiveConstituents) disjion.getContents().get(0);
		assertNotNull(disjive2);
		assertEquals(2, disjive2.getContents().size());
		constituent = (Constituent)disjive2.getContents().get(0);
		checkConstituentSymbol(constituent, "DP_2");
		disjion2 = (DisjunctionConstituents)disjive2.getContents().get(1);
		assertNotNull(disjion2);
		assertEquals(1, disjion2.getContents().size());
		constituent = (Constituent)disjion2.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		constituent = (Constituent)disjion.getContents().get(1);
		checkConstituentSymbol(constituent, "PP");
		// PP_1 {DP_2 / AdvP} PP
		disjion = (DisjunctionConstituents) disjive.getContents().get(4);
		assertNotNull(disjion);
		assertEquals(3, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_1");
		disjive2 = (DisjunctiveConstituents) disjion.getContents().get(1);
		assertNotNull(disjive2);
		assertEquals(2, disjive2.getContents().size());
		constituent = (Constituent)disjive2.getContents().get(0);
		checkConstituentSymbol(constituent, "DP_2");
		disjion2 = (DisjunctionConstituents)disjive2.getContents().get(1);
		assertNotNull(disjion2);
		assertEquals(1, disjion2.getContents().size());
		constituent = (Constituent)disjion2.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		constituent = (Constituent)disjion.getContents().get(2);
		checkConstituentSymbol(constituent, "PP");
		// V
		constituent = (Constituent) rhs.get(2);
		checkConstituentSymbol(constituent, "V");
		// (CP)
		optionalConstituents = (OptionalConstituents)rhs.get(3);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "CP");

		psr = checkPhraseStuctureRule(1, "VP option 6cIpastNew - V final, DP initial or final or medial ( 2 ) and ditransitive with PP, past only",
		"VP = {DP (AdvP) {(PP_1) PP / PP PP_1} / {(PP_3) PP_2 / PP_2 PP_3} (AdvP) DP / {PP_2 / PP_2 PP_3} DP (AdvP) PP_1} V", "VP");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(2, rhs.size());
		disjive = (DisjunctiveConstituents)rhs.get(0);
		assertNotNull(disjive);
		assertEquals(5, disjive.getContents().size());
		constituent = (Constituent)disjive.getContents().get(0);
		checkConstituentSymbol(constituent, "DP");
		optionalConstituents = (OptionalConstituents)disjive.getContents().get(1);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		disjive2 = (DisjunctiveConstituents) disjive.getContents().get(2);
		assertNotNull(disjive2);
		assertEquals(3, disjive2.getContents().size());
		optionalConstituents = (OptionalConstituents)disjive2.getContents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_1");
		constituent = (Constituent)disjive2.getContents().get(1);
		checkConstituentSymbol(constituent, "PP");
		disjion = (DisjunctionConstituents)disjive2.getContents().get(2);
		assertNotNull(disjion);
		assertEquals(2, disjion.getContents().size());
		constituent = (Constituent)disjion.getContents().get(0);
		checkConstituentSymbol(constituent, "PP");
		constituent = (Constituent)disjion.getContents().get(1);
		checkConstituentSymbol(constituent, "PP_1");
		disjion = (DisjunctionConstituents) disjive.getContents().get(3);
		assertNotNull(disjion);
		assertEquals(3, disjion.getContents().size());
		disjive2 = (DisjunctiveConstituents) disjion.getContents().get(0);
		assertNotNull(disjive2);
		assertEquals(3, disjive2.getContents().size());
		optionalConstituents = (OptionalConstituents)disjive2.getContents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_3");
		constituent = (Constituent)disjive2.getContents().get(1);
		checkConstituentSymbol(constituent, "PP_2");
		disjion2 = (DisjunctionConstituents)disjive2.getContents().get(2);
		assertNotNull(disjion2);
		assertEquals(2, disjion2.getContents().size());
		constituent = (Constituent)disjion2.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_2");
		constituent = (Constituent)disjion2.getContents().get(1);
		checkConstituentSymbol(constituent, "PP_3");
		optionalConstituents = (OptionalConstituents)disjion.getContents().get(1);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		constituent = (Constituent)disjion.getContents().get(2);
		checkConstituentSymbol(constituent, "DP");
		disjion = (DisjunctionConstituents) disjive.getContents().get(4);
		assertNotNull(disjion);
		assertEquals(4, disjion.getContents().size());
		disjive2 = (DisjunctiveConstituents) disjion.getContents().get(0);
		assertNotNull(disjive2);
		assertEquals(2, disjive2.getContents().size());
		constituent = (Constituent)disjive2.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_2");
		disjion2 = (DisjunctionConstituents)disjive2.getContents().get(1);
		assertNotNull(disjion2);
		assertEquals(2, disjion2.getContents().size());
		constituent = (Constituent)disjion2.getContents().get(0);
		checkConstituentSymbol(constituent, "PP_2");
		constituent = (Constituent)disjion2.getContents().get(1);
		checkConstituentSymbol(constituent, "PP_3");
		constituent = (Constituent)disjion.getContents().get(1);
		checkConstituentSymbol(constituent, "DP");
		optionalConstituents = (OptionalConstituents)disjion.getContents().get(2);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		constituent = (Constituent)optionalConstituents.getContents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		constituent = (Constituent)disjion.getContents().get(3);
		checkConstituentSymbol(constituent, "PP_1");
	}

	protected PhraseStructureRule checkPhraseStuctureRule(int numberOfRules, String sId, String sPsr, String sLhs) {
		rhs.clear();
		Grammar grammar = new Grammar();
		grammar = GrammarBuilder.parseAString("rule {" + sId + "}\n " + sPsr, grammar);
		List<PatrRule> rules = grammar.getRules();
		assertEquals(numberOfRules, rules.size());
		PatrRule rule = rules.get(0);
		assertEquals(sId, rule.getIdentifier());
		PhraseStructureRule psr = rule.getPhraseStructureRule();
		checkConstituentSymbol(psr.getLeftHandSide(), sLhs);
		assertEquals(sPsr, psr.psrRepresentation());
		return psr;
	}

	protected void checkConstituentSymbol(Constituent nt, String sExpected) {
		String ntSymbol = nt.getNode();
		if (nt.getIndex() > -1) {
			ntSymbol += "_" + nt.getIndex();
		}
		assertEquals(sExpected, ntSymbol);
	}

	@Test
	public void buildConstraintsTest() {

		// Unification
		constraints = checkConstraints("<S head> = <IP head>\r\n"
				+ "<IP head type root> = +\r\n"
				+ "<IP head type conj_suffix> = -     | 16Jul03 CB\r\n"
				+ "<S rule> = start"
				+ "<I' head subject> = <DP>\r\n"
				, 5);
		unificationConstraint = (UnificationConstraint) constraints.get(0);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "S");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head");
		constraintRhs = unificationConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "IP");
		checkFeaturePath(constraintRhs.getFeaturePath(), "head");
		unificationConstraint = (UnificationConstraint) constraints.get(1);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "IP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type root");
		constraintRhs = unificationConstraint.getRightHandSide();
		assertEquals("+", constraintRhs.getAtomicValue());
		unificationConstraint = (UnificationConstraint) constraints.get(2);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "IP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type conj_suffix");
		constraintRhs = unificationConstraint.getRightHandSide();
		assertEquals("-", constraintRhs.getAtomicValue());
		unificationConstraint = (UnificationConstraint) constraints.get(3);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "S");
		checkFeaturePath(constraintLhs.getFeaturePath(), "rule");
		constraintRhs = unificationConstraint.getRightHandSide();
		assertEquals("start", constraintRhs.getAtomicValue());
		unificationConstraint = (UnificationConstraint) constraints.get(4);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "I'");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head subject");
		constraintRhs = unificationConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "DP");
		assertNull(constraintRhs.getFeaturePath());

		// Disjunctive unification
		constraints = checkConstraints("{<InitP head type relcl> = -  | 03Apr03 CB\r\n"
				+ "/<InitP head type relcl> = +  |  relcl in InitP only with overt subject\r\n"
				+ "<IP head type pro-drop> = -\r\n"
				+ "}", 1);
		unificationConstraint = (UnificationConstraint)constraints.get(0);
		disjunctiveUnificationConstraints = unificationConstraint.getDisjunctiveUnificationConstraint();
		assertEquals(1, disjunctiveUnificationConstraints.getUnificationConstraints().size());
		unificationConstraint = disjunctiveUnificationConstraints.getUnificationConstraints().get(0);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "InitP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type relcl");
		constraintRhs = unificationConstraint.getRightHandSide();
		assertEquals("-", constraintRhs.getAtomicValue());
		assertNull(constraintRhs.getFeaturePath());
		assertEquals(1, disjunctiveUnificationConstraints.getDisjunctionUnificationConstraints().size());
		disjunctionUnificationConstraints = disjunctiveUnificationConstraints.getDisjunctionUnificationConstraints().get(0);
		assertEquals(2, disjunctionUnificationConstraints.getUnificationConstraints().size());
		unificationConstraint = disjunctionUnificationConstraints.getUnificationConstraints().get(0);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "InitP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type relcl");
		constraintRhs = unificationConstraint.getRightHandSide();
		assertEquals("+", constraintRhs.getAtomicValue());
		assertNull(constraintRhs.getFeaturePath());
		unificationConstraint = disjunctionUnificationConstraints.getUnificationConstraints().get(1);
		constraintLhs = unificationConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "IP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type pro-drop");
		constraintRhs = unificationConstraint.getRightHandSide();
		assertEquals("-", constraintRhs.getAtomicValue());
		assertNull(constraintRhs.getFeaturePath());

		// Priority union
		constraints = checkConstraints("<InitP head type comma> <= <Conj_2 head type comma>\r\n"
				+ "<IP head type conjoined> <= +   | mark for checking compounding constraints (special case with relcl2+kh and 5c) 20Oct03 CB\r\n"
				+ "<VP head rootgloss> <= <V rootgloss>\r\n"
				+ "<VP head adjoined> <= <DP_1>\r\n"
				+ "<VP head adjoinedPP> <= <PP>\r\n"
				+ "<VP head adjoined> <= <AdvP>"
				, 6);
		priorityUnionConstraint = (PriorityUnionConstraint) constraints.get(0);
		constraintLhs = priorityUnionConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "InitP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type comma");
		constraintRhs = priorityUnionConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "Conj_2");
		checkFeaturePath(constraintRhs.getFeaturePath(), "head type comma");
		priorityUnionConstraint = (PriorityUnionConstraint) constraints.get(1);
		constraintLhs = priorityUnionConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "IP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type conjoined");
		constraintRhs = priorityUnionConstraint.getRightHandSide();
		assertEquals("+", constraintRhs.getAtomicValue());
		priorityUnionConstraint = (PriorityUnionConstraint) constraints.get(2);
		constraintLhs = priorityUnionConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "VP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head rootgloss");
		constraintRhs = priorityUnionConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "V");
		checkFeaturePath(constraintRhs.getFeaturePath(), "rootgloss");
		priorityUnionConstraint = (PriorityUnionConstraint) constraints.get(3);
		constraintLhs = priorityUnionConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "VP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head adjoined");
		constraintRhs = priorityUnionConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "DP_1");
		assertNull(constraintRhs.getFeaturePath());
		priorityUnionConstraint = (PriorityUnionConstraint) constraints.get(4);
		constraintLhs = priorityUnionConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "VP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head adjoinedPP");
		constraintRhs = priorityUnionConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "PP");
		assertNull(constraintRhs.getFeaturePath());
		priorityUnionConstraint = (PriorityUnionConstraint) constraints.get(5);
		constraintLhs = priorityUnionConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "VP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head adjoined");
		constraintRhs = priorityUnionConstraint.getRightHandSide();
		checkConstituentSymbol(constraintRhs.getConstituent(), "AdvP");
		assertNull(constraintRhs.getFeaturePath());

		// Logical Constraints
		// negation, existence, conditional, biconditional, logical and, logical or; combinations of negation
		constraints = checkConstraints("<DP> == ~[mother_node:-]     | if coordination, must be allowed initially\r\n"
				+ "<D> == [mother_node:+]\r\n"
				+ "<DP head type> == [mother_node:+] -> [head:[type:[coordination:+]]] |and be complete\r\n"
				+ "<DP head type> == ~[mother_node:+] <-> [head:[type:[coordination:+]]]\r\n"
				+ "<DP head type> == [mother_node:+] & ~[head:[type:[coordination:+]]]\r\n"
				+ "<DP head type> == ~[mother_node:+] / ~[head:[type:[coordination:+]]]\r\n"
				, 6);
		logicalConstraint = (LogicalConstraint) constraints.get(0);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "DP");
		assertNull(constraintLhs.getFeaturePath());
		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(true, factor1.isNegated());
		featureStructure = factor1.getFeatureStructure();
		assertEquals("mother_node", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		assertEquals("-", featureStructureValue.getAtomicValue());
		assertNull(lcExpression.getFactor2());

		logicalConstraint = (LogicalConstraint) constraints.get(1);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "D");
		assertNull(constraintLhs.getFeaturePath());
		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(false, factor1.isNegated());
		featureStructure = factor1.getFeatureStructure();
		assertEquals("mother_node", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());
		assertNull(lcExpression.getFactor2());

		logicalConstraint = (LogicalConstraint) constraints.get(2);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "DP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type");
		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(false, factor1.isNegated());
		featureStructure = factor1.getFeatureStructure();
		assertEquals("mother_node", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());
		assertEquals(BinaryOperation.CONDITIONAL, lcExpression.getBinop());
		factor2 = lcExpression.getFactor2();
		assertEquals(false, factor2.isNegated());
		featureStructure = factor2.getFeatureStructure();
		assertEquals("head", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("type", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("coordination", featureStructureValue.getFeatureStructure());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		logicalConstraint = (LogicalConstraint) constraints.get(3);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "DP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type");
		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(true, factor1.isNegated());
		featureStructure = factor1.getFeatureStructure();
		assertEquals("mother_node", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());
		assertEquals(BinaryOperation.BICONDITIONAL, lcExpression.getBinop());
		factor2 = lcExpression.getFactor2();
		assertEquals(false, factor2.isNegated());
		featureStructure = factor2.getFeatureStructure();
		assertEquals("head", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("type", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("coordination", featureStructureValue.getFeatureStructure());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		logicalConstraint = (LogicalConstraint) constraints.get(4);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "DP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type");
		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(false, factor1.isNegated());
		featureStructure = factor1.getFeatureStructure();
		assertEquals("mother_node", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());
		assertEquals(BinaryOperation.AND, lcExpression.getBinop());
		factor2 = lcExpression.getFactor2();
		assertEquals(true, factor2.isNegated());
		featureStructure = factor2.getFeatureStructure();
		assertEquals("head", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("type", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("coordination", featureStructureValue.getFeatureStructure());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		logicalConstraint = (LogicalConstraint) constraints.get(5);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "DP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head type");
		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(true, factor1.isNegated());
		featureStructure = factor1.getFeatureStructure();
		assertEquals("mother_node", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());
		assertEquals(BinaryOperation.OR, lcExpression.getBinop());
		factor2 = lcExpression.getFactor2();
		assertEquals(true, factor2.isNegated());
		featureStructure = factor2.getFeatureStructure();
		assertEquals("head", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("type", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("coordination", featureStructureValue.getFeatureStructure());
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		// key word in feature structure value position
		constraints = checkConstraints("<P'> == [gloss: in] -> ~[head:[object:[head:[rootgloss: out]]]]"
				+ "<P'> == [prep:[gloss: be]] -> ~[head:[object:[head:[rootgloss: is]]]]"
				+ "<P'> == [prep:[gloss: constraint]] -> ~[head:[object:[head:[rootgloss: define]]]]"
				+ "<P'> == [prep:[gloss: parameter]] -> ~[head:[object:[head:[rootgloss: Start symbol]]]]"
				+ "<P'> == [prep:[gloss: Category feature]] -> ~[head:[object:[head:[rootgloss: Lexical feature]]]]"
				+ "<P'> == [prep:[gloss: Gloss feature]] -> ~[head:[object:[head:[rootgloss: RootGloss feature]]]]"
				+ "<P'> == [prep:[gloss: rule]] -> ~[head:[object:[head:[rootgloss: Rule]]]]"
				, 7);

		// nesting
		constraints = checkConstraints("<IP head> == ((([subject:[head:[participle:[cat:V]]]] / [subject:[head:[possessor:[head:[participle:[cat:V]]]]]]))\r\n"
				+ "& ([type:[no_intervening:+]])) <-> \r\n"
				+ "(([type:[auxiliary:-\r\n"
				+ "copular:-\r\n"
				+ "passive:-]] \r\n"
				+ "/ [type:[auxiliary:+\r\n"
				+ "participle:+]])        \r\n"
				+ "/ [type:[participle_passive:+]])  | to force participle to be w/ V or Aux 12-APR-04"
				, 1);
		logicalConstraint = (LogicalConstraint) constraints.get(0);
		constraintLhs = logicalConstraint.getLeftHandSide();
		checkConstituentSymbol(constraintLhs.getConstituent(), "IP");
		checkFeaturePath(constraintLhs.getFeaturePath(), "head");

		lcExpression = logicalConstraint.getExpression();
		factor1 = lcExpression.getFactor1();
		assertEquals(false, factor1.isNegated());
		assertNull(factor1.getFeatureStructure());
		LogicalConstraintExpression lce2 = factor1.getExpression();
		assertNotNull(lce2);
		LogicalConstraintFactor factor21 =lce2.getFactor1();
		assertEquals(false, factor21.isNegated());
		assertNull(factor21.getFeatureStructure());
		LogicalConstraintExpression lce3 = factor21.getExpression();
		assertNotNull(lce3);
		assertNull(lce3.getBinop());
		assertNull(lce3.getFactor2());
		LogicalConstraintFactor factor31 =lce3.getFactor1();
		assertEquals(false, factor31.isNegated());
		assertNull(factor31.getFeatureStructure());
		LogicalConstraintExpression lce4 = factor31.getExpression();
		assertNotNull(lce4);
		LogicalConstraintFactor factor41 =lce4.getFactor1();
		assertEquals(false, factor41.isNegated());
		assertNotNull(factor41.getFeatureStructure());
		featureStructure = factor41.getFeatureStructure();
		assertEquals("subject", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("head", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("participle", featureStructureValue.getFeatureStructure());
		nestedFeatureStructure = checkNestedFeatureStructure("cat", featureStructureValue.getFeatureStructure());
		assertEquals("V", nestedFeatureStructure.getValue().getAtomicValue());
		assertEquals(BinaryOperation.OR, lce4.getBinop());
		LogicalConstraintFactor factor42 =lce4.getFactor2();
		assertEquals(false, factor42.isNegated());
		assertNotNull(factor42.getFeatureStructure());
		featureStructure = factor42.getFeatureStructure();
		assertEquals("subject", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("head", featureStructure);
		nestedFeatureStructure = checkNestedFeatureStructure("possessor", featureStructureValue.getFeatureStructure());
		nestedFeatureStructure = checkNestedFeatureStructure("head", featureStructureValue.getFeatureStructure());
		nestedFeatureStructure = checkNestedFeatureStructure("participle", featureStructureValue.getFeatureStructure());
		nestedFeatureStructure = checkNestedFeatureStructure("cat", featureStructureValue.getFeatureStructure());
		assertEquals("V", nestedFeatureStructure.getValue().getAtomicValue());

		assertEquals(BinaryOperation.AND, lce2.getBinop());
		LogicalConstraintFactor factor22 =lce2.getFactor2();
		assertNotNull(factor22);
		assertEquals(false, factor22.isNegated());
		assertNull(factor22.getFeatureStructure());
		assertNotNull(factor22.getExpression());
		lce3 = factor22.getExpression();
		factor31 = lce3.getFactor1();
		assertNotNull(factor31);
		assertEquals(false, factor31.isNegated());
		assertNotNull(factor31.getFeatureStructure());
		featureStructure = factor31.getFeatureStructure();
		assertEquals("type", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("no_intervening", featureStructure);
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

		assertEquals(BinaryOperation.BICONDITIONAL, lcExpression.getBinop());
		factor2 =lcExpression.getFactor2();
		assertNotNull(factor2);
		assertEquals(false, factor2.isNegated());
		assertNull(factor2.getFeatureStructure());
		assertNotNull(factor2.getExpression());
		lce2 = factor2.getExpression();
		factor21 = lce2.getFactor1();
		assertNotNull(factor21);
		assertEquals(false, factor21.isNegated());
		lce3 = factor21.getExpression();
		assertNotNull(lce3);
		factor31 = lce3.getFactor1();
		assertNotNull(factor31.getFeatureStructure());
		featureStructure = factor31.getFeatureStructure();
		assertEquals("type", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("auxiliary", featureStructure);
		assertEquals("-", nestedFeatureStructure.getValue().getAtomicValue());
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(0);
		assertEquals("copular", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		assertEquals("-", featureStructureValue.getAtomicValue());
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(1);
		assertEquals("passive", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		assertEquals("-", featureStructureValue.getAtomicValue());

		assertEquals(BinaryOperation.OR, lce3.getBinop());
		factor2 =lce3.getFactor2();
		assertNotNull(factor2);
		assertEquals(false, factor2.isNegated());
		featureStructure = factor2.getFeatureStructure();
		assertEquals("type", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("auxiliary", featureStructure);
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());
		embeddedFeatureStructure = nestedFeatureStructure.getEmbeddedFeatureStructures().get(0);
		assertEquals("participle", embeddedFeatureStructure.getName());
		featureStructureValue = embeddedFeatureStructure.getValue();
		assertEquals("+", featureStructureValue.getAtomicValue());

		assertEquals(BinaryOperation.OR, lce2.getBinop());
		factor2 =lce2.getFactor2();
		assertNotNull(factor2);
		assertEquals(false, factor2.isNegated());
		featureStructure = factor2.getFeatureStructure();
		assertEquals("type", featureStructure.getName());
		featureStructureValue = featureStructure.getValue();
		nestedFeatureStructure = checkNestedFeatureStructure("participle_passive", featureStructure);
		assertEquals("+", nestedFeatureStructure.getValue().getAtomicValue());

	}

	protected List<Constraint> checkConstraints(String sConstraint, int size) {
		Grammar grammar = new Grammar();
		grammar = GrammarBuilder.parseAString("\nrule S = V\n" + sConstraint, grammar);
		PatrRule rule = grammar.getRules().get(0);
		constraints = rule.getConstraints();
		assertEquals(size, constraints.size());
		return constraints;
	}

	@Test
	public void buildGrammarFailuresTest() {
		// TODO: when get there
		// following is here for debugging other tests when needed
		String sInput = "rule S = V\n"
				+ "<IP head> == ((([subject:[head:[participle:[cat:V]]]] / [subject:[head:[possessor:[head:[participle:[cat:V]]]]]]))\r\n"
				+ "& ([type:[no_intervening:+]])) <-> \r\n"
				+ "(([type:[auxiliary:-\r\n"
				+ "copular:-\r\n"
				+ "passive:-]] \r\n"
				+ "/ [type:[auxiliary:+\r\n"
				+ "participle:+]])        \r\n"
				+ "/ [type:[participle_passive:+]])  | to force participle to be w/ V or Aux 12-APR-04";
		CharStream input = CharStreams.fromString(sInput);
		PcPatrGrammarLexer lexer = new PcPatrGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
//		System.out.println(tokens.getTokenSource().getInputStream().toString());
//		for (Token t : lexer.getAllTokens())
//		{
//			System.out.println("type=" + t.getType() + "; content='" + t.getText() +"'");
//		}
		PcPatrGrammarParser parser = new PcPatrGrammarParser(tokens);
		ParseTree tree = parser.patrgrammar();
		System.out.println(tree.toStringTree(parser));

	}

}
