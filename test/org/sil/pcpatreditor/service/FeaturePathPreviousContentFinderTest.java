/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andy Black
 *
 */
public class FeaturePathPreviousContentFinderTest {

	FeaturePathPreviousContentFinder finder;
	String result = "";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		finder = FeaturePathPreviousContentFinder.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void simpleFeaturePathTest() {
		finder.setSkipConstituent(false);
		result = finder.findPreviousPath("");
		assertEquals("", result);
		result = finder.findPreviousPath(" ");
		assertEquals("", result);
		result = finder.findPreviousPath("<");
		assertEquals("", result);
		result = finder.findPreviousPath(" <");
		assertEquals("", result);
		result = finder.findPreviousPath("< ");
		assertEquals("", result);
		result = finder.findPreviousPath(" < ");
		assertEquals("", result);
		result = finder.findPreviousPath(" <head");
		assertEquals("head", result);
		result = finder.findPreviousPath(" <head ");
		assertEquals("head ", result);
		result = finder.findPreviousPath(" <head type");
		assertEquals("head type", result);
		result = finder.findPreviousPath(" <head type> = <head ");
		assertEquals("head ", result);
		result = finder.findPreviousPath(" <head type> = <head> ");
		assertEquals("head> ", result);
	}

	@Test
	public void ruleFeaturePathTest() {
		finder.setSkipConstituent(true);
		result = finder.findPreviousPath("");
		assertEquals("", result);
		result = finder.findPreviousPath(" ");
		assertEquals("", result);
		result = finder.findPreviousPath("<");
		assertEquals("", result);
		result = finder.findPreviousPath(" <");
		assertEquals("", result);
		result = finder.findPreviousPath("< ");
		assertEquals("", result);
		result = finder.findPreviousPath(" < ");
		assertEquals("", result);
		result = finder.findPreviousPath(" <CP head");
		assertEquals("head", result);
		result = finder.findPreviousPath(" <AdjP head ");
		assertEquals("head ", result);
		result = finder.findPreviousPath(" <NP head type");
		assertEquals("head type", result);
		result = finder.findPreviousPath(" <VP head type> = <V head ");
		assertEquals("head ", result);
		result = finder.findPreviousPath(" <CP");
		assertEquals("", result);
	}

}
