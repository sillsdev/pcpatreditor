/**
 * Copyright (c) 2026 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.List;

import org.sil.pcpatreditor.model.FeatureTemplate;
import org.sil.pcpatreditor.model.Grammar;

/**
 * @author Andy Black
 *
 *         Singleton pattern for collecting psr information
 */
public class TemplateLocator {

	private static TemplateLocator instance;
	List<TemplateLocationInfo> templateLocations = new ArrayList<>();

	public static TemplateLocator getInstance() {
		if (instance == null) {
			instance = new TemplateLocator();
		}
		return instance;
	}

	public TemplateLocator() {
		super();
	}

	public void findTemplateLocations(String grammarText) {
		Grammar pcpatrGrammar = new Grammar();
		pcpatrGrammar = GrammarBuilder.parseAString(grammarText, pcpatrGrammar);
		List<FeatureTemplate> templates = pcpatrGrammar.getFeatureTemplates();
		findTemplateLocationsFromTemplates(templates);
	}

	public void findTemplateLocationsFromTemplates(List<FeatureTemplate> templates) {
		templateLocations.clear();
		templates.stream().forEach(t -> {
			TemplateLocationInfo info = new TemplateLocationInfo(t.getLineNumber(), t.getCharacterIndex(), t.getName());
			templateLocations.add(info);
			});
	}

	/**
	 * @return the templateLocations
	 */
	public List<TemplateLocationInfo> getTemplateLocations() {
		return templateLocations;
	}

	/**
	 * @param templateLocations the templateLocations to set
	 */
	public void setTemplateLocations(List<TemplateLocationInfo> templateLocations) {
		this.templateLocations = templateLocations;
	}

}
