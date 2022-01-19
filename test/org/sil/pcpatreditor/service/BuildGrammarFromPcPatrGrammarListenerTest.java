/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.OptionalConstituentsRightHandSide;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.ConstituentsRightHandSide;
import org.sil.pcpatreditor.model.Constraint;
import org.sil.pcpatreditor.model.ConstraintLeftHandSide;
import org.sil.pcpatreditor.model.ConstraintRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.DisjunctionConstituentsRightHandSide;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
import org.sil.pcpatreditor.model.EmbeddedFeatureStructure;
import org.sil.pcpatreditor.model.FeaturePath;
import org.sil.pcpatreditor.model.FeaturePathOrStructure;
import org.sil.pcpatreditor.model.FeaturePathTemplateBody;
import org.sil.pcpatreditor.model.FeaturePathUnit;
import org.sil.pcpatreditor.model.FeatureStructure;
import org.sil.pcpatreditor.model.FeatureStructureValue;
import org.sil.pcpatreditor.model.FeatureTemplate;
import org.sil.pcpatreditor.model.FeatureTemplateDisjunction;
import org.sil.pcpatreditor.model.FeatureTemplateValue;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PhraseStructureRuleRightHandSide;
import org.sil.pcpatreditor.model.PriorityUnionConstraint;
import org.sil.pcpatreditor.model.UnificationConstraint;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarLexer;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;
/**
 * @author Andy Black
 *
 */
public class BuildGrammarFromPcPatrGrammarListenerTest {

	Constituent constituent;
	ConstituentsRightHandSide constituentRhs;
	DisjunctiveConstituents disjunctiveConstituents;
	OptionalConstituents optionalConstituents;
	PhraseStructureRule psr;
	List<PhraseStructureRuleRightHandSide> rhs = new ArrayList<>();
	List<Constraint> constraints = new ArrayList<>();
	FeatureTemplate featureTemplate;
	FeaturePath featurePath;
	FeaturePathOrStructure featurePathOrStructure;
	FeaturePathTemplateBody featurePathTemplateBody;
	FeaturePathTemplateBody embeddedFeaturePathTemplateBody;
	FeaturePathUnit featurePathUnit;
	FeatureStructure featureStructure;
	EmbeddedFeatureStructure embeddedFeatureStructure;
	FeatureStructure nestedFeatureStructure;
	FeatureStructureValue featureStructureValue;
	FeatureTemplateDisjunction featureTemplateDisjunction;
	FeatureTemplateValue featureTemplateValue;
	UnificationConstraint unificationConstraint;
	ConstraintLeftHandSide constraintLhs;
	ConstraintRightHandSide constraintRhs;
	PriorityUnionConstraint priorityUnionConstraint;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

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

		checkFeatureTemplate("Let -absolutive be <head case> = {ergative genitive dative}", "-absolutive");
		checkFeaturePathUnit(featureTemplate.getFeaturePathTemplateBody().getFeaturePathUnit(), "head case");
		checkFeatureTemplateDisjunctiveValue("{ergative genitive dative}");

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
		assertEquals(sDisjunction, ftdisj.contentsRepresentation());
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
		assertEquals(sPath, fp.contentsRepresentation());
	}

	protected void checkFeaturePathUnit(FeaturePathUnit featurePathUnit, String sPath) {
		assertEquals(sPath, featurePathUnit.contentsRepresentation());
	}

	protected void checkFeatureTemplate(String sTemplate, String sName) {
		Grammar grammar = new Grammar();
		grammar = GrammarBuilder.parseAString(sTemplate + "\nrule S = V\n", grammar);
		List<FeatureTemplate> featureTemplates = grammar.getFeatureTemplates();
		assertEquals(1, featureTemplates.size());
		featureTemplate = featureTemplates.get(0);
		assertEquals(sName, featureTemplate.getName());
	}

	@Test
	public void buildPhraseStructureRuleTest() {
		psr = checkPhraseStuctureRule(1, "testing 1, 2, 3", "S = NP VP", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(1, rhs.size());
		constituentRhs = (ConstituentsRightHandSide) rhs.get(0);
		assertEquals(2, constituentRhs.getConstituents().size());
		constituent = constituentRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "NP");
		constituent = constituentRhs.getConstituents().get(1);
		checkConstituentSymbol(constituent, "VP");

		psr = checkPhraseStuctureRule(1, "testing", "S = AdvP / DP", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(2, rhs.size());
		constituentRhs = (ConstituentsRightHandSide) rhs.get(0);
		assertEquals(1, constituentRhs.getConstituents().size());
		constituent = constituentRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		DisjunctionConstituentsRightHandSide dcRhs = (DisjunctionConstituentsRightHandSide) rhs.get(1);
		DisjunctionConstituents disjion = dcRhs.getDisjunctionConstituents().get(0);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		ConstituentsRightHandSide cRhs = (ConstituentsRightHandSide) disjion.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "DP");

		psr = checkPhraseStuctureRule(1,
				"S option startInitPP symbol with PP initial elements and final ya na & Quote allowed",
				"S = InitP {IP / CP} (Conj Deg) (Quote)", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(4, rhs.size());
		// testing for the PSR combination so we won't look further here

		psr = checkPhraseStuctureRule(1, "", "S = NP_1 V NP_2", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(1, rhs.size());
		constituentRhs = (ConstituentsRightHandSide) rhs.get(0);
		assertEquals(3, constituentRhs.getConstituents().size());
		constituent = constituentRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "NP_1");
		constituent = constituentRhs.getConstituents().get(1);
		checkConstituentSymbol(constituent, "V");
		constituent = constituentRhs.getConstituents().get(2);
		checkConstituentSymbol(constituent, "NP_2");

		psr = checkPhraseStuctureRule(1, "S option start symbol - final ya na & Quote allowed", "S = {IP / CP} (Conj Deg) (Quote)", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(3, rhs.size());
		disjunctiveConstituents = (DisjunctiveConstituents) rhs.get(0);
		assertNotNull(disjunctiveConstituents);
		assertEquals(1, disjunctiveConstituents.getConstituents().size());
		constituent = disjunctiveConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "IP");
		List<DisjunctionConstituents> disjunctionConstituents = disjunctiveConstituents.getDisjunctionConstituents();
		assertNotNull(disjunctionConstituents);
		assertEquals(1, disjunctionConstituents.size());
		disjion = disjunctionConstituents.get(0);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "CP");

		OptionalConstituentsRightHandSide ocRhs = (OptionalConstituentsRightHandSide) rhs.get(1);
		optionalConstituents = ocRhs.getOptionalConstituents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getContents().size());
		cRhs = (ConstituentsRightHandSide)optionalConstituents.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Conj");
		cRhs = (ConstituentsRightHandSide)optionalConstituents.getContents().get(1);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Deg");

		ocRhs = (OptionalConstituentsRightHandSide) rhs.get(2);
		optionalConstituents = ocRhs.getOptionalConstituents().get(0);
		assertNotNull(optionalConstituents);
		cRhs = (ConstituentsRightHandSide)optionalConstituents.getContents().get(0);
		assertEquals(1, cRhs.getConstituents().size());
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Quote");

		psr = checkPhraseStuctureRule(1, "S option start symbol - final ya na & Quote allowed", "S = {IP DP / CP Conj Det} (Conj) (Det Quote)", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(3, rhs.size());
		disjunctiveConstituents = (DisjunctiveConstituents) rhs.get(0);
		assertNotNull(disjunctiveConstituents);
		assertEquals(2, disjunctiveConstituents.getConstituents().size());
		constituent = disjunctiveConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "IP");
		constituent = disjunctiveConstituents.getConstituents().get(1);
		checkConstituentSymbol(constituent, "DP");
		disjunctionConstituents = disjunctiveConstituents.getDisjunctionConstituents();
		assertNotNull(disjunctionConstituents);
		assertEquals(1, disjunctionConstituents.size());
		disjion = disjunctionConstituents.get(0);
		assertNotNull(disjion);
		assertEquals(3, disjion.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "CP");
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(1);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Conj");
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(2);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Det");

		ocRhs = (OptionalConstituentsRightHandSide) rhs.get(1);
		optionalConstituents = ocRhs.getOptionalConstituents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		cRhs = (ConstituentsRightHandSide)optionalConstituents.getContents().get(0);
		assertEquals(1, cRhs.getConstituents().size());
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Conj");

		ocRhs = (OptionalConstituentsRightHandSide) rhs.get(2);
		optionalConstituents = ocRhs.getOptionalConstituents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getContents().size());
		cRhs = (ConstituentsRightHandSide) optionalConstituents.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Det");
		cRhs = (ConstituentsRightHandSide) optionalConstituents.getContents().get(1);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Quote");

		psr = checkPhraseStuctureRule(1, "VP option 5cPastNew - V final, transitive",
				"VP = DP ({PP / {DP_1 / AdvP} / PP_1 {DP_1 / AdvP} / {DP_2 / AdvP} PP / PP_1 {DP_2 / AdvP} PP}) V (CP)",
				"VP");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(4, rhs.size());
		// DP
		constituentRhs = (ConstituentsRightHandSide) rhs.get(0);
		assertEquals(1, constituentRhs.getConstituents().size());
		constituent = constituentRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "DP");
		// ({PP / {DP_1 / AdvP} / PP_1 {DP_1 / AdvP} / {DP_2 / AdvP} PP / PP_1 {DP_2 / AdvP} PP})
		ocRhs = (OptionalConstituentsRightHandSide) rhs.get(1);
		optionalConstituents = ocRhs.getOptionalConstituents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		disjunctiveConstituents = (DisjunctiveConstituents) optionalConstituents.getContents().get(0);
		assertNotNull(disjunctiveConstituents);
		// {PP / {DP_1 / AdvP} / PP_1 {DP_1 / AdvP} / {DP_2 / AdvP} PP / PP_1 {DP_2 / AdvP} PP}
		assertNotNull(disjunctiveConstituents.getConstituents());
		assertEquals(1, disjunctiveConstituents.getConstituents().size());
		constituent = disjunctiveConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "PP");
		disjunctionConstituents = disjunctiveConstituents.getDisjunctionConstituents();
		assertNotNull(disjunctionConstituents);
		assertEquals(4, disjunctionConstituents.size());
		// {DP_1 / AdvP}
		disjion = disjunctionConstituents.get(0);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		DisjunctiveConstituents disjive = (DisjunctiveConstituents) disjion.getContents().get(0);
		assertNotNull(disjive);
		assertEquals(1, disjive.getConstituents().size());
		constituent = disjive.getConstituents().get(0);
		checkConstituentSymbol(constituent, "DP_1");
		DisjunctionConstituents disjion2 = disjive.getDisjunctionConstituents().get(0);
		assertNotNull(disjion2.getContents());
		assertEquals(1, disjion2.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion2.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		// PP_1 {DP_1 / AdvP}
		disjion = disjunctionConstituents.get(1);
		assertNotNull(disjion);
		assertEquals(2, disjion.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "PP_1");
		disjive = (DisjunctiveConstituents) disjion.getContents().get(1);
		assertNotNull(disjive);
		assertEquals(1, disjive.getConstituents().size());
		constituent = disjive.getConstituents().get(0);
		checkConstituentSymbol(constituent, "DP_1");
		disjion2 = disjive.getDisjunctionConstituents().get(0);
		assertEquals(1, disjion2.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion2.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		// {DP_2 / AdvP} PP
		disjion = disjunctionConstituents.get(2);
		assertNotNull(disjion);
		assertEquals(2, disjion.getContents().size());
		disjive = (DisjunctiveConstituents) disjion.getContents().get(0);
		assertNotNull(disjive);
		assertEquals(1, disjive.getConstituents().size());
		constituent = disjive.getConstituents().get(0);
		checkConstituentSymbol(constituent, "DP_2");
		disjion2 = disjive.getDisjunctionConstituents().get(0);
		assertNotNull(disjion2.getContents());
		assertEquals(1, disjion2.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion2.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(1);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "PP");
		// PP_1 {DP_2 / AdvP} PP
		disjion = disjunctionConstituents.get(3);
		assertNotNull(disjion);
		assertEquals(3, disjion.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "PP_1");
		disjive = (DisjunctiveConstituents) disjion.getContents().get(1);
		assertNotNull(disjive);
		assertEquals(1, disjive.getConstituents().size());
		constituent = disjive.getConstituents().get(0);
		checkConstituentSymbol(constituent, "DP_2");
		disjion2 = disjive.getDisjunctionConstituents().get(0);
		assertNotNull(disjion2.getContents());
		assertEquals(1, disjion2.getContents().size());
		cRhs = (ConstituentsRightHandSide) disjion2.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "AdvP");
		cRhs = (ConstituentsRightHandSide) disjion.getContents().get(2);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "PP");
		// V
		constituentRhs = (ConstituentsRightHandSide) rhs.get(2);
		assertEquals(1, constituentRhs.getConstituents().size());
		constituent = constituentRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "V");
		// (CP)
		ocRhs = (OptionalConstituentsRightHandSide) rhs.get(3);
		optionalConstituents = ocRhs.getOptionalConstituents().get(0);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getContents().size());
		cRhs = (ConstituentsRightHandSide)optionalConstituents.getContents().get(0);
		constituent = cRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "CP");
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
		// Priority union
		constraints = checkConstraints("<InitP head type comma> <= <Conj_2 head type comma>\r\n"
				+ "<IP head type conjoined> <= +   | mark for checking compounding constraints (special case with relcl2+kh and 5c) 20Oct03 CB\r\n"
				, 2);
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
//		String sInput = "Let first_object be <head object head agr person first> = +\n"
//				+ "<head object head agr person second> = -\n"
//				+ "<head object head agr person third> = -\n"
//				+ "<head type object_agr_suffix> = +\nrule S = V\n";
//		CharStream input = CharStreams.fromString(sInput);
//		PcPatrGrammarLexer lexer = new PcPatrGrammarLexer(input);
//		CommonTokenStream tokens = new CommonTokenStream(lexer);
////		System.out.println(tokens.getTokenSource().getInputStream().toString());
////		for (Token t : lexer.getAllTokens())
////		{
////			System.out.println("type=" + t.getType() + "; content='" + t.getText() +"'");
////		}
//		PcPatrGrammarParser parser = new PcPatrGrammarParser(tokens);
//		ParseTree tree = parser.patrgrammar();
//		System.out.println(tree.toStringTree(parser));


		// TODO: when get there
	}

}
