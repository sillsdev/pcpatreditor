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
public class FeaturePath {

	String atomicValue;
	FeaturePath embeddedFeaturePath;
	
	/**
	 * @param atomicValue
	 * @param embeddedFeaturePath
	 */
	public FeaturePath(String atomicValue, FeaturePath embeddedFeaturePath) {
		super();
		this.atomicValue = atomicValue;
		this.embeddedFeaturePath = embeddedFeaturePath;
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
	 * @return the embeddedFeaturePath
	 */
	public FeaturePath getEmbeddedFeaturePath() {
		return embeddedFeaturePath;
	}

	/**
	 * @param embeddedFeaturePath the embeddedFeaturePath to set
	 */
	public void setEmbeddedFeaturePath(FeaturePath embeddedFeaturePath) {
		this.embeddedFeaturePath = embeddedFeaturePath;
	}
	
	
}
