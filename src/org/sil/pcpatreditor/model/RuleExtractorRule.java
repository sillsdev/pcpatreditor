/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import org.sil.pcpatreditor.service.RuleLocationInfo;

import javafx.beans.InvalidationListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;

/**
 * @author Andy Black
 *
 */
public class RuleExtractorRule extends ChooserBase {

	boolean fChecked;
	String sDescription = "";
	BooleanProperty checked;
	StringProperty rulePhraseStructureRule;
	StringProperty ruleID;
	RuleLocationInfo ruleLocationInfo;
	/**
	 * @param checked
	 * @param ruleLocationInfo
	 */
	public RuleExtractorRule(RuleLocationInfo ruleLocationInfo) {
		super();
		this.ruleLocationInfo = ruleLocationInfo;
		this.checked = new SimpleBooleanProperty(false);
		this.rulePhraseStructureRule = new SimpleStringProperty(ruleLocationInfo.psrRepresentation());
		this.ruleID = new SimpleStringProperty(ruleLocationInfo.id());
	}
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked.get();
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked.set(checked);
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
	/**
	 * @return
	 */
	public ObservableValue<Boolean> checkedProperty() {
		return checked;
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
