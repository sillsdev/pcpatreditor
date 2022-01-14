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
public class FeatureTemplate extends PcPatrBase {

	String name;
	FeaturePathTemplateBody featurePathTemplateBody;
	
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public FeatureTemplate(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
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

}
