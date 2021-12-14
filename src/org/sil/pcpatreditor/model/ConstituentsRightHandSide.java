/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.List;

/**
 * @author Andy Black
 *
 */
public class ConstituentsRightHandSide extends PhraseStructureRuleRightHandSide {

	/**
	 * @param constituents
	 */
	public ConstituentsRightHandSide(List<Constituent> constituents) {
		super(constituents);
	}
	
}