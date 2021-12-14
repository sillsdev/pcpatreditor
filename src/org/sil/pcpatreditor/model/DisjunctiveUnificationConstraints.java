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
public class DisjunctiveUnificationConstraints extends Constraint {

	List<UnificationConstraint> unificationConstraints = new ArrayList<>();
	List<DisjunctiveUnificationConstraints> disjunctiveUnificationConstraints = new ArrayList<>();
	
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 * @param unificationConstraints
	 * @param disjunctiveUnificationConstraints
	 */
	public DisjunctiveUnificationConstraints(boolean enabled, boolean useWhenDebugging,
			List<UnificationConstraint> unificationConstraints,
			List<DisjunctiveUnificationConstraints> disjunctiveUnificationConstraints) {
		super(enabled, useWhenDebugging);
		this.unificationConstraints = unificationConstraints;
		this.disjunctiveUnificationConstraints = disjunctiveUnificationConstraints;
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
	 * @return the disjunctiveUnificationConstraints
	 */
	public List<DisjunctiveUnificationConstraints> getDisjunctiveUnificationConstraints() {
		return disjunctiveUnificationConstraints;
	}

	/**
	 * @param disjunctiveUnificationConstraints the disjunctiveUnificationConstraints to set
	 */
	public void setDisjunctiveUnificationConstraints(
			List<DisjunctiveUnificationConstraints> disjunctiveUnificationConstraints) {
		this.disjunctiveUnificationConstraints = disjunctiveUnificationConstraints;
	}

}
