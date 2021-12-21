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
public class OptionalConstituents extends PhraseStructureRuleRightHandSide {

	List<DisjunctiveConstituents> disjunctiveConstituents = new ArrayList<>();

	public OptionalConstituents() {
		super();
	}
	/**
	 * @param constituents
	 */
	public OptionalConstituents(List<Constituent> constituents) {
		super(constituents);
	}

	/**
	 * @return the disjunctiveConstituents
	 */
	public List<DisjunctiveConstituents> getDisjunctiveConstituents() {
		return disjunctiveConstituents;
	}

	/**
	 * @param disjunctiveConstituents the disjunctiveConstituents to set
	 */
	public void setDisjunctiveConstituents(List<DisjunctiveConstituents> disjunctiveConstituents) {
		this.disjunctiveConstituents = disjunctiveConstituents;
	}

}
