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
public class FeaturePathTemplateBody extends PcPatrBase {

	FeaturePathUnit featurePathUnit;
	AtomicValueDisjunction atomicValueDisjunction;
	FeatureTemplateValue featureTemplateValue;
	FeaturePathTemplateBody featurePathTemplateBody;
	FeatureTemplateDisjunction featureTemplateDisjunction;
	String featureTemplateAbbreviation;

	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public FeaturePathTemplateBody(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
	}

	/**
	 * @return the atomicValueDisjunction
	 */
	public AtomicValueDisjunction getAtomicValueDisjunction() {
		return atomicValueDisjunction;
	}

	/**
	 * @param atomicValueDisjunction the atomicValueDisjunction to set
	 */
	public void setAtomicValueDisjunction(AtomicValueDisjunction atomicValueDisjunction) {
		this.atomicValueDisjunction = atomicValueDisjunction;
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

	/**
	 * @return the featureTemplateAbbreviation
	 */
	public String getFeatureTemplateAbbreviation() {
		return featureTemplateAbbreviation;
	}

	/**
	 * @param featureTemplateAbbreviation the featureTemplateAbbreviation to set
	 */
	public void setFeatureTemplateAbbreviation(String featureTemplateAbbreviation) {
		this.featureTemplateAbbreviation = featureTemplateAbbreviation;
	}

	/**
	 * @return the featurePathTemplateBody
	 */
	public FeaturePathTemplateBody getFeaturePathTemplateBody() {
		return featurePathTemplateBody;
	}

	/**
	 * @param featurePathTemplateBody the featurePathTemplateBody to set
	 */
	public void setFeaturePathTemplateBody(FeaturePathTemplateBody featurePathTemplateBody) {
		this.featurePathTemplateBody = featurePathTemplateBody;
	}

	/**
	 * @return the featureTemplateDisjunction
	 */
	public FeatureTemplateDisjunction getFeatureTemplateDisjunction() {
		return featureTemplateDisjunction;
	}

	/**
	 * @param featureTemplateDisjunction the featureTemplateDisjunction to set
	 */
	public void setFeatureTemplateDisjunction(FeatureTemplateDisjunction featureTemplateDisjunction) {
		this.featureTemplateDisjunction = featureTemplateDisjunction;
	}

}
