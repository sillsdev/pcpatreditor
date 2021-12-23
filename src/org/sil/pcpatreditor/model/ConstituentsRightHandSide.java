/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.List;

import org.sil.pcpatreditor.Constants;

/**
 * @author Andy Black
 *
 */
public class ConstituentsRightHandSide extends PhraseStructureRuleRightHandSide {

	public ConstituentsRightHandSide() {
		super();
	}

	/**
	 * @param constituents
	 */
	public ConstituentsRightHandSide(List<Constituent> constituents) {
		super(constituents);
	}

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < constituents.size(); i++) {
			Constituent c = constituents.get(i);
			sb.append(c.nodeRepresentation());
			if (i < constituents.size()-1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		return sb.toString();
	}
}
