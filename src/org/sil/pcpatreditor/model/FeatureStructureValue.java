/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.List;

/**
 * @author Andy Black
 *
 */
public class FeatureStructureValue {

	String atomicValue;
	FeatureStructure featureStructure;

	public FeatureStructureValue() {
	}

	/**
	 * @param atomicValue
	 * @param featureStructure
	 */
	public FeatureStructureValue(String atomicValue, FeatureStructure featureStructure) {
		super();
		this.atomicValue = atomicValue;
		this.featureStructure = featureStructure;
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
	
	public List<String> pathRepresentations(String path, List<String> paths) {
		if (featureStructure != null) {
			return featureStructure.pathRepresentations(path, paths);
		} else {
			paths.add(path + atomicValue);
		}
		return paths;
	}
}
