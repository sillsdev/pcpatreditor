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
public class FeaturePathOrStructure {

	String atomicValue;
	FeaturePath featurePath;
	FeatureStructure featureStructure;
	/**
	 * 
	 */
	public FeaturePathOrStructure() {
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
	 * @return the featureStructure
	 */
	public FeatureStructure getFeatureStructure() {
		return featureStructure;
	}
	/**
	 * @param featureStructure the featureStructure to set
	 */
	public void setFeatureStructure(FeatureStructure featureStructure) {
		this.featureStructure = featureStructure;
	}

	public String contentsRepresentation() {
		StringBuilder sb = new StringBuilder();
		if (atomicValue != null) {
			sb.append(atomicValue);
		}
		if (featurePath != null) {
			sb.append(featurePath.contentsRepresentation());
		}
		return sb.toString();
	}
}
