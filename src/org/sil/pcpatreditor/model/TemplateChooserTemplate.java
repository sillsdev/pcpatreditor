/**
 * Copyright (c) 2026 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import org.sil.pcpatreditor.service.TemplateLocationInfo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Andy Black
 *
 */
public class TemplateChooserTemplate {

	String sDescription = "";
	protected StringProperty templateName;
	protected TemplateLocationInfo templateLocationInfo;

	public TemplateChooserTemplate(TemplateLocationInfo templateLocationInfo) {
		this.templateLocationInfo = templateLocationInfo;
		this.templateName = new SimpleStringProperty(templateLocationInfo.name());
	}

	public TemplateLocationInfo getTemplateLocationInfo() {
		return templateLocationInfo;
	}

	public void setRuleLocationInfo(TemplateLocationInfo templateLocationInfo) {
		this.templateLocationInfo = templateLocationInfo;
	}

	public String getTemplateName() {
		return templateName.get().trim();
	}

	public StringProperty templateNameProperty() {
		return templateName;
	}

	public void setTempolateName(String value) {
		this.templateName.set(value);
	}
}
