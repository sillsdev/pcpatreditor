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
public class LogicalConstraint extends Constraint {

	ConstraintLeftHandSide leftHandSide;
	LogicalContraintExpression expression;
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 * @param leftHandSide
	 * @param expression
	 */
	public LogicalConstraint(boolean enabled, boolean useWhenDebugging, ConstraintLeftHandSide leftHandSide,
			LogicalContraintExpression expression) {
		super(enabled, useWhenDebugging);
		this.leftHandSide = leftHandSide;
		this.expression = expression;
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
	 * @return the expression
	 */
	public LogicalContraintExpression getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(LogicalContraintExpression expression) {
		this.expression = expression;
	}

}
