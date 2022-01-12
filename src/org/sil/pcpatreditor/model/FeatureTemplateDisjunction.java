/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andy Black
 *
 */
public class FeatureTemplateDisjunction {

	List<FeaturePathOrStructure> contents = new ArrayList<>();

	public FeatureTemplateDisjunction() {
	}

	/**
	 * @return the contents
	 */
	public List<FeaturePathOrStructure> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<FeaturePathOrStructure> contents) {
		this.contents = contents;
	}

	public String contentsRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		String sContents = contents.stream().map(FeaturePathOrStructure::contentsRepresentation).collect(Collectors.joining(" "));
		sb.append(sContents);
		sb.append("}");
		return sb.toString();
	}
}
