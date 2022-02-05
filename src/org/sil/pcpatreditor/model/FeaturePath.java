/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public class FeaturePath {

	String atomicValue;
	FeaturePath featurePath;
	
	public FeaturePath() {
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

	public String pathRepresentation() {
		StringBuilder sb = new StringBuilder();
		if (atomicValue != null) {
			sb.append(atomicValue);
		}
		if (featurePath != null) {
			sb.append(" ");
			sb.append(featurePath.pathRepresentation());
		}
		return sb.toString();
	}
}
