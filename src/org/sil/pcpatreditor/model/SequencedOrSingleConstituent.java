/**
 * Copyright (c) 2022 SIL International
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
public class SequencedOrSingleConstituent {

	List<SequencedOrSingleConstituent> contents = new ArrayList<>();
	
	public SequencedOrSingleConstituent() {
	}

	public SequencedOrSingleConstituent(SequencedOrSingleConstituent contentItem) {
		contents.add(contentItem);
	}

	public List<SequencedOrSingleConstituent> getContents() {
		return contents;
	}

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < contents.size(); i++) {
			sb.append(contents.get(i).psrRepresentation());
			if (i < contents.size()-1) {
				sb.append(Constants.PSR_SEPARATOR);
			}
		}
		return sb.toString();
	}
}
