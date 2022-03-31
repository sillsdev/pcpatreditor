/**
 * Copyright (c) 2021-2020 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public class OptionalConstituents extends SequencedOrSingleConstituent {

	public OptionalConstituents() {
		super();
	}

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(super.psrRepresentation());
		sb.append(")");
		return sb.toString();
	}

}
