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
public class EmbeddedFeatureStructure {

	String name;
	FeatureStructureValue value;
	/**
	 * @param name
	 * @param value
	 */
	public EmbeddedFeatureStructure(String name, FeatureStructureValue value) {
		super();
		this.name = name;
		this.value = value;
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
	 * @return the value
	 */
	public FeatureStructureValue getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(FeatureStructureValue value) {
		this.value = value;
	}
	
}
