/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Black
 *
 *         Singleton pattern for collecting psr information
 */
public class RuleExtractor {

	private static RuleExtractor instance;
	List<RuleLocationInfo> ruleLocations = new ArrayList<>();
	
	public static RuleExtractor getInstance() {
		if (instance == null) {
			instance = new RuleExtractor();
		}
		return instance;
	}

	public RuleExtractor() {
		super();
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

	public String extractRules(List<Integer> ruleIndexesToExtract, String grammarText) {
		if (ruleLocations.size() == 0) {
			// no rules; use everything.
			return grammarText;
		}
		int firstRuleLocation = ruleLocations.get(0).characterIndex();  
		StringBuilder sb = new StringBuilder();
		if (ruleIndexesToExtract.size() == 0) {
			// no rules selected; use everything
			sb.append(grammarText);
		} else {
			// add everything before the first rule
			sb.append(grammarText.substring(0, firstRuleLocation));
			for (int i = 0; i < ruleIndexesToExtract.size(); i++) {
				int ruleIndex = ruleIndexesToExtract.get(i);
				RuleLocationInfo rule = ruleLocations.get(ruleIndex);
				int index = ruleLocations.indexOf(rule);
				if (index < 0) {
					// error!
					return (grammarText);
				}
				if (ruleIndex + 1 >= ruleLocations.size()) {
					sb.append(grammarText.substring(rule.characterIndex()));
				} else {
					sb.append(grammarText.substring(rule.characterIndex(),
							ruleLocations.get(ruleIndex + 1).characterIndex()));
				}

			}
		}
		return sb.toString();
	}

}
