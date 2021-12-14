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
public class LogicalContraintExpression {

	LogicalConstraintFactor factor1;
	LogicalConstraintFactor factor2;
	BinaryOperation binop;
	/**
	 * @param factor1
	 * @param factor2
	 * @param binop
	 */
	public LogicalContraintExpression(LogicalConstraintFactor factor1, LogicalConstraintFactor factor2,
			BinaryOperation binop) {
		super();
		this.factor1 = factor1;
		this.factor2 = factor2;
		this.binop = binop;
	}
	/**
	 * @return the factor1
	 */
	public LogicalConstraintFactor getFactor1() {
		return factor1;
	}
	/**
	 * @param factor1 the factor1 to set
	 */
	public void setFactor1(LogicalConstraintFactor factor1) {
		this.factor1 = factor1;
	}
	/**
	 * @return the factor2
	 */
	public LogicalConstraintFactor getFactor2() {
		return factor2;
	}
	/**
	 * @param factor2 the factor2 to set
	 */
	public void setFactor2(LogicalConstraintFactor factor2) {
		this.factor2 = factor2;
	}
	/**
	 * @return the binop
	 */
	public BinaryOperation getBinop() {
		return binop;
	}
	/**
	 * @param binop the binop to set
	 */
	public void setBinop(BinaryOperation binop) {
		this.binop = binop;
	}
	
}
