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
public class DisjunctiveConstituents extends PhraseStructureRuleRightHandSide {

	List<DisjunctionConstituents> disjunctionConstituents = new ArrayList<>();
	
	public DisjunctiveConstituents() {
		super();
	}

	/**
	 * @param constituents
	 * @param disjunctionConstituents
	 */
	public DisjunctiveConstituents(List<Constituent> constituents,
			List<DisjunctionConstituents> disjunctionConstituents) {
		super(constituents);
		this.disjunctionConstituents = disjunctionConstituents;
	}
	/**
	 * @return the disjunctionConstituents
	 */
	public List<DisjunctionConstituents> getDisjunctionConstituents() {
		return disjunctionConstituents;
	}
	/**
	 * @param disjunctionConstituents the disjunctionConstituents to set
	 */
	public void setDisjunctionConstituents(List<DisjunctionConstituents> disjunctionConstituents) {
		this.disjunctionConstituents = disjunctionConstituents;
	}
	
	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Constituent c : constituents) {
			sb.append(c.nodeRepresentation());
			sb.append(Constants.PSR_SEPARATOR);
		}
		for (int i = 0; i < disjunctionConstituents.size(); i++) {
			sb.append("/ ");
			DisjunctionConstituents dc = disjunctionConstituents.get(i);
			sb.append(dc.psrRepresentation());
			if (i < disjunctionConstituents.size() - 1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
