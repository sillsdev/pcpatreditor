/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public abstract class ConstraintWithLeftRightHandSide extends Constraint {

	protected ConstraintLeftHandSide leftHandSide;
	protected ConstraintRightHandSide rightHandSide;

	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public ConstraintWithLeftRightHandSide(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
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
