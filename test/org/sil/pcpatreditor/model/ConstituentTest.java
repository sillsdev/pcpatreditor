/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andy Black
 *
 */
public class ConstituentTest {

	Constituent constituent;
	
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
	public void constructorTest() {
		constituent = new Constituent("S");
		checkSymbolAndIndex("S", -1, "S");
		constituent = new Constituent("S1");
		checkSymbolAndIndex("S1", -1, "S1");
		constituent = new Constituent("S_0");
		checkSymbolAndIndex("S", 0, "S_0");
		constituent = new Constituent("NP_1");
		checkSymbolAndIndex("NP", 1, "NP_1");
		constituent = new Constituent("_0");
		checkSymbolAndIndex("_0", -1, "_0");
		constituent = new Constituent("1S");
		checkSymbolAndIndex("1S", -1, "1S");
	}

	protected void checkSymbolAndIndex(String symbol, int index, String representation) {
		assertEquals(symbol, constituent.getNode());
		assertEquals(index, constituent.getIndex());
		assertEquals(representation, constituent.nodeRepresentation());
	}

}
