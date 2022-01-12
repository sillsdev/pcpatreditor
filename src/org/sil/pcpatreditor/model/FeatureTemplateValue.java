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
public class FeatureTemplateValue {
	
	String atomicValue;
	FeaturePath featurePath;
	FeatureTemplateDisjunction featureTemplateDisjunction;
	/**
	 * 
	 */
	public FeatureTemplateValue() {
		super();
	}
	/**
	 * @return the atomicValue
	 */
	public String getAtomicValue() {
		return atomicValue;
	}
	/**
	 * @param atomicValue the atomicValue to set
	 */
	public void setAtomicValue(String atomicValue) {
		this.atomicValue = atomicValue;
	}
	/**
	 * @return the featurePath
	 */
	public FeaturePath getFeaturePath() {
		return featurePath;
	}
	/**
	 * @param featurePath the featurePath to set
	 */
	public void setFeaturePath(FeaturePath featurePath) {
		this.featurePath = featurePath;
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
