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
public class FeaturePathUnit {

	FeaturePath featurePath;
	
	public FeaturePathUnit() {
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

	public String contentsRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append(featurePath.contentsRepresentation());
		return sb.toString();
	}
}
