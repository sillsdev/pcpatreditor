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
public abstract class PhraseStructureRuleRightHandSide {

	protected List<Constituent> constituents = new ArrayList<>();

	public PhraseStructureRuleRightHandSide() {
		
	}

	/**
	 * @param constituents
	 */
	public PhraseStructureRuleRightHandSide(List<Constituent> constituents) {
		super();
		this.constituents = constituents;
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

}
