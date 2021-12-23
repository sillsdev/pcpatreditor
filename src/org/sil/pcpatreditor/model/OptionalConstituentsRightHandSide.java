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

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (int i = 0; i < optionalConstituents.size(); i++) {
			OptionalConstituents oc = optionalConstituents.get(i);
			sb.append(oc.psrRepresentation());
			if (i < optionalConstituents.size() - 1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
}
