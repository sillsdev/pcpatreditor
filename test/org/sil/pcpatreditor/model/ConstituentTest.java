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

	Constituent nt;
	
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
		nt = new Constituent("S");
		checkSymbolAndIndex("S", -1);
		nt = new Constituent("S1");
		checkSymbolAndIndex("S1", -1);
		nt = new Constituent("S_0");
		checkSymbolAndIndex("S", 0);
		nt = new Constituent("NP_1");
		checkSymbolAndIndex("NP", 1);
		nt = new Constituent("_0");
		checkSymbolAndIndex("_0", -1);
		nt = new Constituent("1S");
		checkSymbolAndIndex("1S", -1);
	}

	protected void checkSymbolAndIndex(String symbol, int index) {
		assertEquals(symbol, nt.getNode());
		assertEquals(index, nt.getIndex());
	}

}
