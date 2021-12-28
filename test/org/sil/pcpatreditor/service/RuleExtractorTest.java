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
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;

/**
 * @author Andy Black
 *
 */
public class RuleExtractorTest {

	RuleExtractor extractor;
	int firstRuleLocation = 70895;
	List<RuleLocationInfo> ruleLocations = new ArrayList<>();
	List<Integer> ruleIndexesToExtract = new ArrayList<>();
	RuleLocator locator;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		extractor = RuleExtractor.getInstance();
		ruleLocations.clear();
		ruleIndexesToExtract.clear();
		locator = RuleLocator.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void extractorTest() {
		File largeGrammarFile = new File(Constants.UNIT_TEST_DATA_FILE);
		try {
			String largeFileContent = new String(Files.readAllBytes(largeGrammarFile.toPath()),
					StandardCharsets.UTF_8);
			// no rules selected
			ruleLocations.clear();
			ruleIndexesToExtract.clear();
			extractor.setRuleLocations(ruleLocations);
			String result = extractor.extractRules(ruleIndexesToExtract, largeFileContent);
			assertEquals(412907, result.length());
			locator.findRuleLocations(largeFileContent);
			ruleLocations = locator.getRuleLocations();
			// no rules selected
			ruleIndexesToExtract.clear();
			extractor.setRuleLocations(ruleLocations);
			result = extractor.extractRules(ruleIndexesToExtract, largeFileContent);
			assertEquals(412907, result.length());
			
			// first rule, some mid rule, and some later rule
			ruleIndexesToExtract.add(0);
			ruleIndexesToExtract.add(30);
			ruleIndexesToExtract.add(180);
			result = extractor.extractRules(ruleIndexesToExtract, largeFileContent);
			assertEquals(74696, result.length());
			assertEquals("rule {testing}\r\n"
					+ "S = AdvP / DP    |/ VP / PP \r\n"
					+ "    <S head> = <AdvP head>\r\n"
					+ "    <S head> = <DP head>\r\n"
					+ "|    <S head> = <VP head>\r\n"
					+ "|    <S head> = <PP head>\r\n"
					+ "\r\n"
					+ "rule {IP option 2cINon-ImpersonalV-PastIntransitive - subject initial, required, root clause}  \r\n"
					+ "IP = DP I'\r\n"
					+ "    <IP head> = <I' head>\r\n"
					+ "    <IP head type root> = +\r\n"
					+ "    <IP head type pro-drop> = -\r\n"
					+ "    {<DP head type comma> = -\r\n"
					+ "     <DP head type apposition> = -\r\n"
					+ "    /<DP head type apposition> = +    | 17Jan03  CB\r\n"
					+ "    /<DP head type apposition> = namely    | 21Nov03  CB\r\n"
					+ "    /<DP head type relcl> = +        | can have comma if relcl 27Jan03 CB\r\n"
					+ "     <DP head type comma> = +\r\n"
					+ "     <DP head type apposition> = -\r\n"
					+ "    }\r\n"
					+ "     <I' head type impersonal> = -\r\n"
					+ "     <I' head infl tense past> = +\r\n"
					+ "     <I' head infl tense future> = -   | Not future Apr2020\r\n"
					+ "     <I' head type transitive> = -\r\n"
					+ "    {<I' head subject> = <DP>\r\n"
					+ "    /<DP head type human> = -\r\n"
					+ "     <DP head agr person third> = +\r\n"
					+ "     <DP head agr number plural> = +\r\n"
					+ "     <I' head subject head agr number singular> = +\r\n"
					+ "     <I' head subject head agr number plural> = -\r\n"
					+ "     <I' head subject head agr person second> = -       | RL 2Feb02 allow 1st and 3rd person, but not 2nd.\r\n"
					+ "    }\r\n"
					+ "    <IP head subject head type> = <DP head type>  | pass DP type features for compounding, regardless of agreement 17Apr03 CB\r\n"
					+ "    <IP head subject head possessor> = <DP head possessor> | pass DP possessor info for compounding, regardless of agreement 17Apr03 CB\r\n"
					+ "    <DP head case_for_position> = direct  | to know normal case for conjoined DPs\r\n"
					+ "    <DP head case> = direct\r\n"
					+ "    <DP head type DO_contraction> = -   | 17Feb03 CB\r\n"
					+ "    <DP head type case-marked> = -\r\n"
					+ "    <DP head type nonfinalcoordination> = -\r\n"
					+ "    <DP> == ~[mother_node:-]     | if coordination, must be allowed initially\r\n"
					+ "    <DP> == [mother_node:+] -> [head:[type:[coordination:+]]] |and be complete\r\n"
					+ "    <DP head type> == [relative:+] -> [relcl:+]      | require rel suffix to only occur when relative clause present\r\n"
					+ "    <IP head> == [type:[reciprocal:+]] -> \r\n"
					+ "                 [subject:[head:[agr:[number:[plural:+]]]]]\r\n"
					+ "    <IP head> == [subject:[head:[infl:[polarity:-]]]] ->   |if the subject is negative, the verb must be negative\r\n"
					+ "                 [infl:[polarity:-]]\r\n"
					+ "||    <IP head> == [subject:[head:[type:[coordination:+]]]] ->\r\n"
					+ "||                ~[type:[initialP:+]]\r\n"
					+ "    <IP head> == ((([subject:[head:[participle:[cat:V]]]] / [subject:[head:[possessor:[head:[participle:[cat:V]]]]]]))\r\n"
					+ "                   & ([type:[no_intervening:+]])) -> \r\n"
					+ "                 (([type:[auxiliary:-\r\n"
					+ "                         copular:-\r\n"
					+ "                         passive:-]] \r\n"
					+ "                 / [type:[auxiliary:+\r\n"
					+ "                          participle:+]])        \r\n"
					+ "                 / [type:[participle_passive:+]])  | to force participle to be w/ V or Aux 12-APR-04\r\n"
					+ "    <IP head> == [rootgloss:^1] ->\r\n"
					+ "                 ~ ( [type:[no_intervening:+]] &    \r\n"
					+ "                   (( [subject:[head:[type:[compounds_with1:^1]]]]\r\n"
					+ "                    / [subject:[head:[type:[compounds_with2:^1]]]])\r\n"
					+ "                    / ([subject:[head:[type:[compounds_with3:^1]]]]\r\n"
					+ "                    / [subject:[head:[type:[compounds_with4:^1]]]]) ) )\r\n"
					+ "    <IP head> == [rootgloss:^1] ->\r\n"
					+ "                 ~ ( [type:[no_intervening:+]] & \r\n"
					+ "                  (( [subject:[head:[possessor:[head:[type:[compounds_with1:^1]]]]]]\r\n"
					+ "                   / [subject:[head:[possessor:[head:[type:[compounds_with2:^1]]]]]]) \r\n"
					+ "                   / ([subject:[head:[possessor:[head:[type:[compounds_with3:^1]]]]]] \r\n"
					+ "                   / [subject:[head:[possessor:[head:[type:[compounds_with4:^1]]]]]]) ))\r\n"
					+ "    <IP rule> = 2cNon-ImpersonalV-PastIntransitive\r\n"
					+ "\r\n"
					+ "rule {AdvP option 1 - no modifiers}\r\n"
					+ "AdvP = Adv\r\n"
					+ "    <AdvP head> = <Adv head>\r\n"
					+ "    <AdvP rule> = 1\r\n"
					+ "\r\n"
					, result.substring(firstRuleLocation));

			// second rule and last rule
			ruleIndexesToExtract.clear();
			ruleIndexesToExtract.add(1);
			ruleIndexesToExtract.add(181);
			result = extractor.extractRules(ruleIndexesToExtract, largeFileContent);
			assertEquals(72163, result.length());
			assertEquals("rule {S option start symbol -  final ya na & Quote allowed}\r\n"
					+ "S = {IP / CP} (Conj Deg) (Quote)\r\n"
					+ "    <S head> = <IP head>\r\n"
					+ "    <S head> = <CP head>\r\n"
					+ "    <IP head type root> = +\r\n"
					+ "    <IP head type conj_suffix> = -     | 16Jul03 CB\r\n"
					+ "    <CP head type root> = +\r\n"
					+ "    <CP head type conj_suffix> = -     | 16Jul03 CB\r\n"
					+ "    <CP head type relcl> = -          | 21Nov03 CB\r\n"
					+ "    <Conj gloss> = or\r\n"
					+ "    <Conj head type CP-final> = +\r\n"
					+ "    <Deg head type CP-final> = +\r\n"
					+ "    <Deg head infl polarity> = -\r\n"
					+ "    <S head type initialP> = - \r\n"
					+ "    <IP head type relcl> = -            | not a rel clause 21Nov03 CB\r\n"
					+ "    <CP head type relcl> = -            | not a rel clause 21Nov03 CB\r\n"
					+ "    <S rule> = start\r\n"
					+ "\r\n"
					+ "rule {AdvP option 2 - modifiers initial}\r\n"
					+ "AdvP = Deg Adv\r\n"
					+ "    <AdvP head> = <Adv head>\r\n"
					+ "    <Deg head type comma> = -\r\n"
					+ "|    <Deg head type modifies_Adv> = <Adv head type>  |replace this with the following Apr2020\r\n"
					+ "    <AdvP head modifier head> = <Deg head>\r\n"
					+ "          <AdvP head> == [type:[manner:+]] -> [modifier:[head:[type:[modifies_Adv:[manner:+]]]]]\r\n"
					+ "          <AdvP head> == [type:[temporal:+]] -> [modifier:[head:[type:[modifies_Adv:[temporal:+]]]]]\r\n"
					+ "          <AdvP head> == [type:[locative:+]] -> [modifier:[head:[type:[modifies_Adv:[locative:+]]]]]\r\n"
					+ "   <AdvP rule> = 2\r\n"
					, result.substring(firstRuleLocation));

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	protected void checkInfo(RuleLocationInfo info, int line, String sId, String sPsr) {
		assertEquals(line, info.lineNumber());
		assertEquals(sId, info.id());
		assertEquals(sPsr, info.psrRepresentation());
	}

}
