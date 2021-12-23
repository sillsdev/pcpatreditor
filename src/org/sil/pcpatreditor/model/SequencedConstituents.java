/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.List;

import org.sil.pcpatreditor.Constants;

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

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < contents.size(); i++) {
			PhraseStructureRuleRightHandSide c = contents.get(i);
			sb.append(c.psrRepresentation());
			if (i < contents.size() - 1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		return sb.toString();
	}

}
