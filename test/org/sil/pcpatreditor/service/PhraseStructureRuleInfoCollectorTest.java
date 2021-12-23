/**
 * Copyright (c) 2021 SIL International
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.model.Grammar;

/**
 * @author Andy Black
 *
 */
public class PhraseStructureRuleInfoCollectorTest {

	PhraseStructureRuleInfoCollector collector; 
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		collector = PhraseStructureRuleInfoCollector.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void collectorTest() {
		File largeGrammarFile = new File(Constants.UNIT_TEST_DATA_FILE);
		try {
			String largeFileContent = new String(Files.readAllBytes(largeGrammarFile.toPath()),
					StandardCharsets.UTF_8);
			collector.collectRuleInfo(largeFileContent);
			List<PhraseStructureRuleInfo> rulesInfo = collector.getRulesInfo();
			assertNotNull(rulesInfo);
			assertEquals(182, rulesInfo.size());
			checkInfo(rulesInfo.get(0), 1027, "testing", "S = AdvP / DP");
			checkInfo(rulesInfo.get(2), 1052,
					"S option startInitPP symbol with PP initial elements and final ya na & Quote allowed",
					"S = InitP {IP / CP} (Conj Deg) (Quote)");
			checkInfo(rulesInfo.get(27), 1463, "IP option 0b - 2 IPs, initial IP in participle form", "IP = IP_1 IP_2");
			checkInfo(rulesInfo.get(180), 7450, "AdvP option 1 - no modifiers", "AdvP = Adv");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	protected void checkInfo(PhraseStructureRuleInfo info, int line, String sId, String sPsr) {
		assertEquals(line, info.lineNumber());
		assertEquals(sId, info.id());
		assertEquals(sPsr, info.psrRepresentation());
	}

}
