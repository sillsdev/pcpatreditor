/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import org.sil.pcpatreditor.service.RuleLocationInfo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

/**
 * @author Andy Black
 *
 */
public class RuleExtractorRule extends RuleChooserRule {

	boolean fChecked;
	BooleanProperty checked;
	/**
	 * @param checked
	 * @param ruleLocationInfo
	 */
	public RuleExtractorRule(RuleLocationInfo ruleLocationInfo) {
		super(ruleLocationInfo);
		this.checked = new SimpleBooleanProperty(false);
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
	 * @return
	 */
	public ObservableValue<Boolean> checkedProperty() {
		return checked;
	}
	
}
