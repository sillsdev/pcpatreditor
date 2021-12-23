/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.List;

import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.PatrRule;

/**
 * @author Andy Black
 *
 *         Singleton pattern for collecting psr information
 */
public class PhraseStructureRuleInfoCollector {

	private static PhraseStructureRuleInfoCollector instance;
	List<PhraseStructureRuleInfo> rulesInfo = new ArrayList<>();

	public static PhraseStructureRuleInfoCollector getInstance() {
		if (instance == null) {
			instance = new PhraseStructureRuleInfoCollector();
		}
		return instance;
	}

	public PhraseStructureRuleInfoCollector() {
		super();
	}

	public void collectRuleInfo(String grammarText) {
		Grammar pcpatrGrammar = new Grammar();
		pcpatrGrammar = GrammarBuilder.parseAString(grammarText, pcpatrGrammar);
		List<PatrRule> rules = pcpatrGrammar.getRules();
		System.out.println("rules size =" + rules.size());
		rules.stream().forEach(r -> System.out.println("\tline=" + r.getLineNumber() + "; id=" + r.getIdentifier() + "\n\t" + r.psrRepresentation()));
		rulesInfo.clear();
//		for (PatrRule r : rules) {
//			PhraseStructureRuleInfo info = new PhraseStructureRuleInfo(r.getLineNumber(), r.getIdentifier(),
//					r.psrRepresentation());
//			rulesInfo.add(info);
//		}
		rules.stream().forEach(r -> {
			PhraseStructureRuleInfo info = new PhraseStructureRuleInfo(r.getLineNumber(), r.getIdentifier(),
					r.psrRepresentation());
			rulesInfo.add(info);
			});
	}

	/**
	 * @return the rulesInfo
	 */
	public List<PhraseStructureRuleInfo> getRulesInfo() {
		return rulesInfo;
	}

	/**
	 * @param rulesInfo the rulesInfo to set
	 */
	public void setRulesInfo(List<PhraseStructureRuleInfo> rulesInfo) {
		this.rulesInfo = rulesInfo;
	}

}
