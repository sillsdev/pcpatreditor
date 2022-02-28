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
public class RuleLocator {

	private static RuleLocator instance;
	List<RuleLocationInfo> ruleLocations = new ArrayList<>();

	public static RuleLocator getInstance() {
		if (instance == null) {
			instance = new RuleLocator();
		}
		return instance;
	}

	public RuleLocator() {
		super();
	}

	public void findRuleLocations(String grammarText) {
		Grammar pcpatrGrammar = new Grammar();
		pcpatrGrammar = GrammarBuilder.parseAString(grammarText, pcpatrGrammar);
		List<PatrRule> rules = pcpatrGrammar.getRules();
		findRuleLocationsFromRules(rules);
	}

	public void findRuleLocationsFromRules(List<PatrRule> rules) {
		ruleLocations.clear();
		rules.stream().forEach(r -> {
			RuleLocationInfo info = new RuleLocationInfo(r.getLineNumber(), r.getCharacterIndex(), r.getIdentifier(),
					r.psrRepresentation());
			ruleLocations.add(info);
			});
	}

	/**
	 * @return the ruleLocations
	 */
	public List<RuleLocationInfo> getRuleLocations() {
		return ruleLocations;
	}

	/**
	 * @param ruleLocations the ruleLocations to set
	 */
	public void setRuleLocations(List<RuleLocationInfo> ruleLocations) {
		this.ruleLocations = ruleLocations;
	}

}
