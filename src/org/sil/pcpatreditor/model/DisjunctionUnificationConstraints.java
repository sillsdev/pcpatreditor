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
public class DisjunctionUnificationConstraints extends Constraint {

	List<UnificationConstraint> unificationConstraints = new ArrayList<>();
	
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public DisjunctionUnificationConstraints(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
	}

	/**
	 * @return the unificationConstraints
	 */
	public List<UnificationConstraint> getUnificationConstraints() {
		return unificationConstraints;
	}

	/**
	 * @param unificationConstraints the unificationConstraints to set
	 */
	public void setUnificationConstraints(List<UnificationConstraint> unificationConstraints) {
		this.unificationConstraints = unificationConstraints;
	}
}
