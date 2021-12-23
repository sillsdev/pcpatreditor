/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.OptionalConstituentsRightHandSide;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.ConstituentsRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PhraseStructureRuleRightHandSide;
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
	public void buildGrammarTest() {
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
		DisjunctionConstituents disjion = disjunctionConstituents.get(0);
		assertNotNull(disjion);
		assertEquals(1, disjion.getContents().size());
		ConstituentsRightHandSide cRhs = (ConstituentsRightHandSide) disjion.getContents().get(0);
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

		// TODO: test for templates
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
	public void buildGrammarFailuresTest() {
		// TODO: when get there
	}

}
