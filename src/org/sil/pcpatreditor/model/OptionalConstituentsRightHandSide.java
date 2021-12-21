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
public class OptionalConstituentsRightHandSide extends PhraseStructureRuleRightHandSide {

	protected List<OptionalConstituents> optionalConstituents = new ArrayList<>();

	public OptionalConstituentsRightHandSide() {
		super();
	}

	/**
	 * @return the optionalConstituents
	 */
	public List<OptionalConstituents> getOptionalConstituents() {
		return optionalConstituents;
	}

	/**
	 * @param optionalConstituents the optionalConstituents to set
	 */
	public void setOptionalConstituents(List<OptionalConstituents> optionalConstituents) {
		this.optionalConstituents = optionalConstituents;
	}

	
}
