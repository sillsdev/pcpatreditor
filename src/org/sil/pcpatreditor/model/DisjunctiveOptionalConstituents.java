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
public class DisjunctiveOptionalConstituents extends PhraseStructureRuleRightHandSide {

	List<DisjunctiveOptionalConstituents> disjunctiveOptionalConstituents = new ArrayList<>();
	/**
	 * @param constituents
	 * @param disjunctiveConstituents
	 */
	public DisjunctiveOptionalConstituents(List<Constituent> constituents,
			List<DisjunctiveOptionalConstituents> disjunctiveConstituents) {
		super(constituents);
		this.disjunctiveOptionalConstituents = disjunctiveConstituents;
	}
	/**
	 * @return the disjunctiveConstituents
	 */
	public List<DisjunctiveOptionalConstituents> getDisjunctiveOptionalConstituents() {
		return disjunctiveOptionalConstituents;
	}
	/**
	 * @param disjunctiveConstituents the disjunctiveConstituents to set
	 */
	public void setDisjunctiveOptionalConstituents(List<DisjunctiveOptionalConstituents> disjunctiveConstituents) {
		this.disjunctiveOptionalConstituents = disjunctiveConstituents;
	}
	
	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < disjunctiveOptionalConstituents.size(); i++) {
			DisjunctiveOptionalConstituents dc = disjunctiveOptionalConstituents.get(i);
			if (i < disjunctiveOptionalConstituents.size() - 1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		sb.append(")");
		return sb.toString();
	}
}
