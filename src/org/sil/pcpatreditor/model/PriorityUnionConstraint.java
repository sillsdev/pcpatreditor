/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public class PriorityUnionConstraint extends Constraint {
	ConstraintLeftHandSide leftHandSide;
	ConstraintRightHandSide rightHandSide;
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 * @param leftHandSide
	 * @param rightHandSide
	 */
	public PriorityUnionConstraint(boolean enabled, boolean useWhenDebugging, ConstraintLeftHandSide leftHandSide,
			ConstraintRightHandSide rightHandSide) {
		super(enabled, useWhenDebugging);
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}
	/**
	 * @return the leftHandSide
	 */
	public ConstraintLeftHandSide getLeftHandSide() {
		return leftHandSide;
	}
	/**
	 * @param leftHandSide the leftHandSide to set
	 */
	public void setLeftHandSide(ConstraintLeftHandSide leftHandSide) {
		this.leftHandSide = leftHandSide;
	}
	/**
	 * @return the rightHandSide
	 */
	public ConstraintRightHandSide getRightHandSide() {
		return rightHandSide;
	}
	/**
	 * @param rightHandSide the rightHandSide to set
	 */
	public void setRightHandSide(ConstraintRightHandSide rightHandSide) {
		this.rightHandSide = rightHandSide;
	}
}
