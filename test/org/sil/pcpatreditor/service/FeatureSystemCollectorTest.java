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
			List<String> list = Files.readAllLines(largeGrammarFile.toPath(), StandardCharsets.UTF_8);
			String largeFileContent = Files.readString(largeGrammarFile.toPath(), StandardCharsets.UTF_8);
//			String largeFileContent = new String(Files.readAllBytes(largeGrammarFile.toPath()), StandardCharsets.UTF_8);
//			System.out.print(largeFileContent.substring(3000, 67777));
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
//		assertEquals(8, collectionFeatures.size());
//		List<String> cfList = collectionFeatures.stream().collect(Collectors.toList());
//		assertEquals("adjoined", cfList.get(0));
//		assertEquals("adjoinedPP", cfList.get(1));
//		assertEquals("apposed", cfList.get(2));
//		assertEquals("indirectobject", cfList.get(3));
//		assertEquals("location", cfList.get(4));
//		assertEquals("object", cfList.get(5));
//		assertEquals("possessor", cfList.get(6));
//		assertEquals("subject", cfList.get(7));
		
		featureSystem = collector.getFeatureSystem();
		assertNotNull(featureSystem);
//		featureSystem.stream().forEach(c -> System.out.println(c));
		assertEquals(778, featureSystem.size());
		List<String> fsList = collector.getFeatureSystemAsList();
//		System.out.println("\n\nlist is below\n\n");
//		fsList.stream().forEach(c -> System.out.println(c));
		assertEquals(778, fsList.size());
		assertEquals("cat Adj", fsList.get(0));
		assertEquals("cat VP", fsList.get(18));
		assertEquals("gloss whether", fsList.get(40));
		assertEquals("head auxiliary rootgloss be.able", fsList.get(72));
		assertEquals("head object head case", fsList.get(175));
		assertEquals("head subject head agr number singular -", fsList.get(250));
		assertEquals("head type compounds_with2 bring.pst", fsList.get(380));
		assertEquals("head type initialP +", fsList.get(470));
		assertEquals("head type partitive +", fsList.get(540));
		assertEquals("rule 1creason", fsList.get(640));
		assertEquals("rule tempPP", fsList.get(777));
	}

}
