/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;

/**
 * @author Andy Black
 *
 */
public class ConstituentsCollectorTest {
	
	ConstituentsCollector collector;
	SortedSet<String> nonTerminals = new TreeSet<>();
	SortedSet<String> terminals = new TreeSet<>();
	String item = "";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		File largeGrammarFile = new File(Constants.UNIT_TEST_DATA_FILE);
		try {
			String largeFileContent = new String(Files.readAllBytes(largeGrammarFile.toPath()), StandardCharsets.UTF_8);
			collector = new ConstituentsCollector(largeFileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constitentsTest() {
		collector.collect();
		nonTerminals = collector.getNonTerminals();
		assertNotNull(nonTerminals);
		assertEquals(19, nonTerminals.size());
		List<String> ntList = nonTerminals.stream().collect(Collectors.toList());
		assertEquals("AdjP", ntList.get(0));
		assertEquals("AdvP", ntList.get(1));
		assertEquals("C'", ntList.get(2));
		assertEquals("CP", ntList.get(3));
		assertEquals("D'", ntList.get(4));
		assertEquals("DP", ntList.get(5));
		assertEquals("I'", ntList.get(6));
		assertEquals("IP", ntList.get(7));
		assertEquals("InitP", ntList.get(8));
		assertEquals("N'", ntList.get(9));
		assertEquals("N''", ntList.get(10));
		assertEquals("NP", ntList.get(11));
		assertEquals("NumP", ntList.get(12));
		assertEquals("P'", ntList.get(13));
		assertEquals("PP", ntList.get(14));
		assertEquals("QP", ntList.get(15));
		assertEquals("S", ntList.get(16));
		assertEquals("V", ntList.get(17));
		assertEquals("VP", ntList.get(18));
		
		terminals = collector.getTerminals();
		assertNotNull(terminals);
		assertEquals(15, terminals.size());
		List<String> tList = terminals.stream().collect(Collectors.toList());
		assertEquals("Adj", tList.get(0));
		assertEquals("Adv", tList.get(1));
		assertEquals("Aux", tList.get(2));
		assertEquals("C", tList.get(3));
		assertEquals("Case", tList.get(4));
		assertEquals("Conj", tList.get(5));
		assertEquals("Deg", tList.get(6));
		assertEquals("Dem", tList.get(7));
		assertEquals("Excl", tList.get(8));
		assertEquals("N", tList.get(9));
		assertEquals("Num", tList.get(10));
		assertEquals("NumCl", tList.get(11));
		assertEquals("P", tList.get(12));
		assertEquals("Pron", tList.get(13));
		assertEquals("Q", tList.get(14));
	}

}
