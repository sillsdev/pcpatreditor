/**
 * Copyright (c) 2022 SIL International
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
public class AtomicValueDisjunction {

	List<String> atomicValues = new ArrayList<>();
	
	public AtomicValueDisjunction() {
	}

	/**
	 * @return the atomicValues
	 */
	public List<String> getAtomicValues() {
		return atomicValues;
	}

	/**
	 * @param atomicValues the atomicValues to set
	 */
	public void setAtomicValues(List<String> atomicValues) {
		this.atomicValues = atomicValues;
	}

}
