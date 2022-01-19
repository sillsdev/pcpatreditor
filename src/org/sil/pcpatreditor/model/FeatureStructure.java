/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Black
 *
 */
public class FeatureStructure {

	String name;
	FeatureStructureValue value;
	List<EmbeddedFeatureStructure> embeddedFeatureStructures = new ArrayList<>();

	public FeatureStructure( ) {
	}

	/**
	 * @param name
	 * @param value
	 * @param embeddedFeatureStructures
	 */
	public FeatureStructure(String name, FeatureStructureValue value,
			List<EmbeddedFeatureStructure> embeddedFeatureStructures) {
		super();
		this.name = name;
		this.value = value;
		this.embeddedFeatureStructures = embeddedFeatureStructures;
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
	/**
	 * @return the embeddedFeatureStructures
	 */
	public List<EmbeddedFeatureStructure> getEmbeddedFeatureStructures() {
		return embeddedFeatureStructures;
	}
	/**
	 * @param embeddedFeatureStructures the embeddedFeatureStructures to set
	 */
	public void setEmbeddedFeatureStructures(List<EmbeddedFeatureStructure> embeddedFeatureStructures) {
		this.embeddedFeatureStructures = embeddedFeatureStructures;
	}

}
