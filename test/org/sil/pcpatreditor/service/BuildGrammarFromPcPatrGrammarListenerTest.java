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
		psr = extracted(1, "testing 1, 2, 3", "S = NP VP", "S");
		rhs = psr.getRightHandSide();
		assertNotNull(rhs);
		assertEquals(1, rhs.size());
		constituentRhs = (ConstituentsRightHandSide) rhs.get(0);
		assertEquals(2, constituentRhs.getConstituents().size());
		constituent = constituentRhs.getConstituents().get(0);
		checkConstituentSymbol(constituent, "NP");
		constituent = constituentRhs.getConstituents().get(1);
		checkConstituentSymbol(constituent, "VP");

		psr = extracted(1, "", "S = NP_1 V NP_2", "S");
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

		psr = extracted(1, "S option start symbol - final ya na & Quote allowed", "S = {IP / CP} (Conj Deg) (Quote)", "S");
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
		DisjunctionConstituents disjConstituents1 = disjunctionConstituents.get(0);
		assertNotNull(disjConstituents1);
		assertEquals(1, disjConstituents1.getConstituents().size());
		constituent = disjConstituents1.getConstituents().get(0);
		checkConstituentSymbol(constituent, "CP");

		optionalConstituents = (OptionalConstituents) rhs.get(1);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getConstituents().size());
		constituent = optionalConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Conj");
		constituent = optionalConstituents.getConstituents().get(1);
		checkConstituentSymbol(constituent, "Deg");

		optionalConstituents = (OptionalConstituents) rhs.get(2);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getConstituents().size());
		constituent = optionalConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Quote");

		psr = extracted(1, "S option start symbol - final ya na & Quote allowed", "S = {IP DP / CP Conj Det} (Conj) (Det Quote)", "S");
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
		disjConstituents1 = disjunctionConstituents.get(0);
		assertNotNull(disjConstituents1);
		assertEquals(3, disjConstituents1.getConstituents().size());
		constituent = disjConstituents1.getConstituents().get(0);
		checkConstituentSymbol(constituent, "CP");
		constituent = disjConstituents1.getConstituents().get(1);
		checkConstituentSymbol(constituent, "Conj");
		constituent = disjConstituents1.getConstituents().get(2);
		checkConstituentSymbol(constituent, "Det");

		optionalConstituents = (OptionalConstituents) rhs.get(1);
		assertNotNull(optionalConstituents);
		assertEquals(1, optionalConstituents.getConstituents().size());
		constituent = optionalConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Conj");

		optionalConstituents = (OptionalConstituents) rhs.get(2);
		assertNotNull(optionalConstituents);
		assertEquals(2, optionalConstituents.getConstituents().size());
		constituent = optionalConstituents.getConstituents().get(0);
		checkConstituentSymbol(constituent, "Det");
		constituent = optionalConstituents.getConstituents().get(1);
		checkConstituentSymbol(constituent, "Quote");

		// TODO: test for templates
	}

	protected PhraseStructureRule extracted(int numberOfRules, String sId, String sPsr, String sLhs) {
		rhs.clear();
		Grammar grammar = new Grammar();
		grammar = GrammarBuilder.parseAString("rule {" + sId + "}\n " + sPsr, grammar);
		List<PatrRule> rules = grammar.getRules();
		assertEquals(numberOfRules, rules.size());
		PatrRule rule = rules.get(0);
		assertEquals(sId, rule.getIdentifier());
		PhraseStructureRule psr = rule.getPhraseStructureRule();
		checkConstituentSymbol(psr.getLeftHandSide(), sLhs);
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
