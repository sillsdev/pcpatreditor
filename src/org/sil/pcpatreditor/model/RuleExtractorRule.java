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
	StringProperty ruleDescription;
	RuleLocationInfo ruleLocationInfo;
	/**
	 * @param checked
	 * @param ruleLocationInfo
	 */
	public RuleExtractorRule(RuleLocationInfo ruleLocationInfo) {
		super();
		this.ruleLocationInfo = ruleLocationInfo;
		this.checked = new SimpleBooleanProperty(false);
		this.ruleDescription = new SimpleStringProperty(ruleLocationInfo.id() + "\n" + ruleLocationInfo.psrRepresentation());
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
	public String getRuleDescription() {
		return ruleDescription.get().trim();
	}

	public StringProperty ruleDescriptionProperty() {
		return ruleDescription;
	}

	public void setRuleDescription(String description) {
		this.ruleDescription.set(description);
	}

	
}
