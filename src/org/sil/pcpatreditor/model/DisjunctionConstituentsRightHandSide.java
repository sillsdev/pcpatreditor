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
public class DisjunctionConstituentsRightHandSide extends PhraseStructureRuleRightHandSide {

	protected List<DisjunctionConstituents> disjunctionConstituents = new ArrayList<>();

	public DisjunctionConstituentsRightHandSide() {
		super();
	}

	/**
	 * @return the optionalConstituents
	 */
	public List<DisjunctionConstituents> getDisjunctionConstituents() {
		return disjunctionConstituents;
	}

	/**
	 * @param optionalConstituents the optionalConstituents to set
	 */
	public void setDisjunctionConstituents(List<DisjunctionConstituents> optionalConstituents) {
		this.disjunctionConstituents = optionalConstituents;
	}

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < disjunctionConstituents.size(); i++) {
			DisjunctionConstituents dc = disjunctionConstituents.get(i);
			sb.append(dc.psrRepresentation());
			if (i < disjunctionConstituents.size() - 1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		return sb.toString();
	}
	
}
