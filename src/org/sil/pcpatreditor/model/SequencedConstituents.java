/**
 * Copyright (c) 2021 SIL International
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
public abstract class SequencedConstituents {

	List<PhraseStructureRuleRightHandSide> contents = new ArrayList<>();

	public SequencedConstituents() {
		
	}

	/**
	 * @return the contents
	 */
	public List<PhraseStructureRuleRightHandSide> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<PhraseStructureRuleRightHandSide> contents) {
		this.contents = contents;
	}

}
