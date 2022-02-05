/**
 * Copyright (c) 2021-2022 SIL International
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
public class DisjunctiveUnificationConstraints extends Constraint {

	List<UnificationConstraint> unificationConstraints = new ArrayList<>();
	List<DisjunctionUnificationConstraints> disjunctionUnificationConstraints = new ArrayList<>();
	
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public DisjunctiveUnificationConstraints(boolean enabled, boolean useWhenDebugging) {
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

	/**
	 * @return the disjunctionUnificationConstraints
	 */
	public List<DisjunctionUnificationConstraints> getDisjunctionUnificationConstraints() {
		return disjunctionUnificationConstraints;
	}

	/**
	 * @param disjunctionUnificationConstraints the disjunctionUnificationConstraints to set
	 */
	public void setDisjunctionUnificationConstraints(
			List<DisjunctionUnificationConstraints> disjunctionUnificationConstraints) {
		this.disjunctionUnificationConstraints = disjunctionUnificationConstraints;
	}

}
