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
import org.sil.pcpatreditor.model.LogicalConstraint;
import org.sil.pcpatreditor.model.PriorityUnionConstraint;
import org.sil.pcpatreditor.model.UnificationConstraint;

/**
 * @author Andy Black
 *
 */
public class FeatureSystemCollectorTest {
	
	FeatureSystemCollector collector;
	SortedSet<String> collectionFeatures = new TreeSet<>();
	SortedSet<String> featureSystem = new TreeSet<>();
	String item = "";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		File largeGrammarFile = new File(Constants.UNIT_TEST_DATA_FILE_EXTRAS);
		try {
			String largeFileContent = new String(Files.readAllBytes(largeGrammarFile.toPath()), StandardCharsets.UTF_8);
			collector = new FeatureSystemCollector(largeFileContent);
			collector.parseGrammar();
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
	public void featureSystemTest() {
		collector.collectConstraints();
		List<UnificationConstraint> unificationConstraints = collector.getUnificationConstraints();
		assertEquals(4358, unificationConstraints.size());
		List<PriorityUnionConstraint> priorityUnionConstraints = collector.getPriorityUnionConstraints();
		assertEquals(335, priorityUnionConstraints.size());
		List<LogicalConstraint> logicalConstraints = collector.getLogicalConstraints();
		assertEquals(362, logicalConstraints.size());
		
		collector.collect();
		collectionFeatures = collector.getCollectionFeatures();
		assertNotNull(collectionFeatures);
		collectionFeatures.stream().forEach(c -> System.out.println("uc=" + c));
		assertEquals(8, collectionFeatures.size());
		List<String> cfList = collectionFeatures.stream().collect(Collectors.toList());
		assertEquals("adjoined", cfList.get(0));
		assertEquals("adjoinedPP", cfList.get(1));
		assertEquals("apposed", cfList.get(2));
		assertEquals("indirectobject", cfList.get(3));
		assertEquals("location", cfList.get(4));
		assertEquals("object", cfList.get(5));
		assertEquals("possessor", cfList.get(6));
		assertEquals("subject", cfList.get(7));
		
		featureSystem = collector.getFeatureSystem();
		assertNotNull(featureSystem);
		assertEquals(15, featureSystem.size());
		List<String> fsList = featureSystem.stream().collect(Collectors.toList());
		assertEquals("Adj", fsList.get(0));
		assertEquals("Adv", fsList.get(1));
		assertEquals("Aux", fsList.get(2));
		assertEquals("C", fsList.get(3));
		assertEquals("Case", fsList.get(4));
		assertEquals("Conj", fsList.get(5));
		assertEquals("Deg", fsList.get(6));
		assertEquals("Dem", fsList.get(7));
		assertEquals("Excl", fsList.get(8));
		assertEquals("N", fsList.get(9));
		assertEquals("Num", fsList.get(10));
		assertEquals("NumCl", fsList.get(11));
		assertEquals("P", fsList.get(12));
		assertEquals("Pron", fsList.get(13));
		assertEquals("Q", fsList.get(14));
	}

}
