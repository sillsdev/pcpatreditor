/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public class UnificationConstraint extends ConstraintWithLeftRightHandSide {

	DisjunctiveUnificationConstraints disjunctiveUnificationConstraint;
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 * @param leftHandSide
	 * @param rightHandSide
	 */
	public UnificationConstraint(boolean enabled, boolean useWhenDebugging, ConstraintLeftHandSide leftHandSide,
			ConstraintRightHandSide rightHandSide) {
		super(enabled, useWhenDebugging);
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	/**
	 * @param enabled
	 * @param useWhenDebugging
	 * @param disjunctiveUnificationConstraint
	 */
	public UnificationConstraint(boolean enabled, boolean useWhenDebugging,
			DisjunctiveUnificationConstraints disjunctiveUnificationConstraint) {
		super(enabled, useWhenDebugging);
		this.disjunctiveUnificationConstraint = disjunctiveUnificationConstraint;
	}

	/**
	 * @return the disjunctiveUnificationConstraint
	 */
	public DisjunctiveUnificationConstraints getDisjunctiveUnificationConstraint() {
		return disjunctiveUnificationConstraint;
	}

	/**
	 * @param disjunctiveUnificationConstraint the disjunctiveUnificationConstraint to set
	 */
	public void setDisjunctiveUnificationConstraint(DisjunctiveUnificationConstraints disjunctiveUnificationConstraint) {
		this.disjunctiveUnificationConstraint = disjunctiveUnificationConstraint;
	}

}
