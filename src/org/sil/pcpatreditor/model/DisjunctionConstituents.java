/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import org.sil.pcpatreditor.Constants;

/**
 * @author Andy Black
 *
 */
public class DisjunctionConstituents extends SequencedConstituents {

	public DisjunctionConstituents() {
		super();
	}

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append("/ ");
		sb.append(super.psrRepresentation());
		return sb.toString();
	}
}
