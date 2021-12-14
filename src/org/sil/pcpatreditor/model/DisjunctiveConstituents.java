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
	
	
}
