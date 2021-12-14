/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public class ConstraintLeftHandSide {

	Constituent constituent;
	FeaturePath featurePath;
	
	/**
	 * @param constituent
	 * @param featurePath
	 */
	public ConstraintLeftHandSide(Constituent constituent, FeaturePath featurePath) {
		super();
		this.constituent = constituent;
		this.featurePath = featurePath;
	}

	/**
	 * @return the constituent
	 */
	public Constituent getConstituent() {
		return constituent;
	}

	/**
	 * @param constituent the constituent to set
	 */
	public void setConstituent(Constituent constituent) {
		this.constituent = constituent;
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
	
}
