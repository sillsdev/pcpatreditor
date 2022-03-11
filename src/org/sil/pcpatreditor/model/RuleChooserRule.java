/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import org.sil.pcpatreditor.service.RuleLocationInfo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Andy Black
 *
 */
public class RuleChooserRule {

	String sDescription = "";
	protected StringProperty rulePhraseStructureRule;
	protected StringProperty ruleID;
	protected RuleLocationInfo ruleLocationInfo;

	/**
	 * @param ruleInfo
	 */
	public RuleChooserRule(RuleLocationInfo ruleLocationInfo) {
		this.ruleLocationInfo = ruleLocationInfo;
		this.rulePhraseStructureRule = new SimpleStringProperty(ruleLocationInfo.psrRepresentation());
		this.ruleID = new SimpleStringProperty(ruleLocationInfo.id());
	}

	/**
	 * @return the ruleLocationInfo
	 */
	public RuleLocationInfo getRuleLocationInfo() {
		return ruleLocationInfo;
	}

	/**
	 * @param ruleLocationInfo the ruleLocationInfo to set
	 */
	public void setRuleLocationInfo(RuleLocationInfo ruleLocationInfo) {
		this.ruleLocationInfo = ruleLocationInfo;
	}

	public String getPhraseStructureRule() {
		return rulePhraseStructureRule.get().trim();
	}

	public StringProperty rulePhraseStructureRuleProperty() {
		return rulePhraseStructureRule;
	}

	public void setRulePhraseStructureRule(String psr) {
		this.rulePhraseStructureRule.set(psr);
	}

	public String getID() {
		return ruleID.get().trim();
	}

	public StringProperty ruleIDProperty() {
		return ruleID;
	}

	public void setRuleID(String id) {
		this.rulePhraseStructureRule.set(id);
	}

}
