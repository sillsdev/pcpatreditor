/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public class FeatureTemplate extends PcPatrBase {

	String name;
	FeaturePathUnit featurePathUnit;
	FeatureTemplateValue featureTemplateValue;
	
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public FeatureTemplate(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the featurePathUnit
	 */
	public FeaturePathUnit getFeaturePathUnit() {
		return featurePathUnit;
	}

	/**
	 * @param featurePathUnit the featurePathUnit to set
	 */
	public void setFeaturePathUnit(FeaturePathUnit featurePathUnit) {
		this.featurePathUnit = featurePathUnit;
	}

	/**
	 * @return the featureTemplateValue
	 */
	public FeatureTemplateValue getFeatureTemplateValue() {
		return featureTemplateValue;
	}

	/**
	 * @param featureTemplateValue the featureTemplateValue to set
	 */
	public void setFeatureTemplateValue(FeatureTemplateValue featureTemplateValue) {
		this.featureTemplateValue = featureTemplateValue;
	}

}
