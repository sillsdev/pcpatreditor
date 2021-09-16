/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */
package org.sil.pcpatreditor.view;

import static org.junit.Assert.*;

import org.fxmisc.richtext.CodeArea;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sil.utility.view.JavaFXThreadingRule;

public class GrammarUIServiceTest {
	@Rule
	public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	CodeArea grammar;
	char leftItem = '(';
	char rightItem = ')';
	
	@Before
	public void setUp() throws Exception {
		grammar = new CodeArea("()");
		leftItem = '(';
		rightItem = ')';
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void processRightParenthesisTest() {
		grammar.replaceText("(S (NP (N (beans))) (VP (V (grow))))");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(2, 0);
		checkMatchingLeft(6, 3);
		checkMatchingLeft(9, 7);
		checkMatchingLeft(12, 10);
		checkMatchingLeft(16, 10);
		checkMatchingLeft(17, 7);
		checkMatchingLeft(18, 3);
		checkMatchingLeft(32, 27);
		checkMatchingLeft(33, 24);
		checkMatchingLeft(35, 0);
		checkMatchingLeft(36, -1);
	}

	private void checkMatchingLeft(int iRightPos, int iLeftExpected) {
		grammar.moveTo(iRightPos);
		GrammarUIService.processRightItem(grammar, iRightPos, true, 750.0, leftItem, rightItem, null, null);
		int iLeftPos = GrammarUIService.findMatchingLeftItemAndHighlightIt(iRightPos, leftItem, rightItem);
		assertEquals(iLeftExpected, iLeftPos);
	}

	@Test
	public void processLeftParenthesisTest() {
		grammar.replaceText("(S (NP (N (beans))) (VP (V (grow))))");
		checkMatchingRight(0, -1);
		checkMatchingRight(1, 35);
		checkMatchingRight(4, 18);
		checkMatchingRight(8, 17);
		checkMatchingRight(12, 16);
		checkMatchingRight(20, 35);
		checkMatchingRight(21, 34);
		checkMatchingRight(25, 33);
		checkMatchingRight(28, 32);
		checkMatchingRight(36, -1);
	}

	private void checkMatchingRight(int iLeftPos, int iRightExpected) {
		grammar.moveTo(iLeftPos);
		GrammarUIService.processLeftItem(grammar, false, leftItem, rightItem, 125.0, false, null, null);
		int iRightPos = GrammarUIService.findMatchingRightItemAndHighlightIt(iLeftPos, false, leftItem, rightItem);
		assertEquals(iRightExpected, iRightPos);
	}

	@Test
	public void processWedgesWhenPriorityUnionTest() {
		leftItem = '<';
		rightItem = '>';

		grammar.replaceText("<InitP head type comma> <= <Conj_2 head type comma>");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(22, 0);
		checkMatchingLeft(50, 27);

		checkMatchingRight(0,-1);
		checkMatchingRight(1,22);
		checkMatchingRight(28,50);
		checkMatchingRight(25,25);

		grammar.replaceText("<<InitP head type comma> <= <Conj_2 head type comma>>");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(23, 1);
		checkMatchingLeft(51, 28);
		checkMatchingLeft(52, 0);

		checkMatchingRight(0,-1);
		checkMatchingRight(2,23);
		checkMatchingRight(29,51);
		checkMatchingRight(26,26);
	}

	@Test
	public void processWedgesWhenConditionalLogicalConstraintTest() {
		leftItem = '<';
		rightItem = '>';

		grammar.replaceText("<DP head type> == [relative:+] -> [relcl:+]");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(13, 0);
		checkMatchingLeft(32, 32);

		checkMatchingRight(0,-1);
		checkMatchingRight(1,13);
		checkMatchingRight(32,-1);

		grammar.replaceText("<<DP head type> == [relative:+] -> [relcl:+]>");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(14, 1);
		checkMatchingLeft(43, 0);
		checkMatchingLeft(33, 33);

		checkMatchingRight(1,44);
		checkMatchingRight(2,14);
	}

	@Test
	public void processWedgesWhenBiconditionalLogicalConstraintTest() {
		leftItem = '<';
		rightItem = '>';

		grammar.replaceText("<DP head type> == [relative:+] <-> [relcl:+]");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(13, 0);
		checkMatchingLeft(32, 31);

		checkMatchingRight(0,-1);
		checkMatchingRight(1,13);
		checkMatchingRight(32,33);

		grammar.replaceText("<<DP head type> == [relative:+] <-> [relcl:+]>");
		checkMatchingLeft(0, -1);
		checkMatchingLeft(14, 1);
		checkMatchingLeft(43, 0);
		checkMatchingLeft(33, 32);

		checkMatchingRight(1,45);
		checkMatchingRight(2,14);
	}
}
