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
public class DisjunctiveOptionalConstituents extends PhraseStructureRuleRightHandSide {

	List<Constituent> constituents = new ArrayList<>();
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
	 * @return the constituents
	 */
	public List<Constituent> getConstituents() {
		return constituents;
	}
	/**
	 * @param constituents the constituents to set
	 */
	public void setConstituents(List<Constituent> constituents) {
		this.constituents = constituents;
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
	
	
}
