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
	LogicalConstraintExpression expression;
	/**
	 * @param enabled
	 * @param useWhenDebugging
	 * @param leftHandSide
	 * @param expression
	 */
	public LogicalConstraint(boolean enabled, boolean useWhenDebugging, ConstraintLeftHandSide leftHandSide,
			LogicalConstraintExpression expression) {
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
	public LogicalConstraintExpression getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(LogicalConstraintExpression expression) {
		this.expression = expression;
	}

}
