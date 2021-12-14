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
public class LogicalConstraintFactor {

	boolean negated = false;
	FeatureStructure featureStructure;
	LogicalContraintExpression expression;
	/**
	 * @param negated
	 * @param featureStructure
	 * @param expression
	 */
	public LogicalConstraintFactor(boolean negated, FeatureStructure featureStructure,
			LogicalContraintExpression expression) {
		super();
		this.negated = negated;
		this.featureStructure = featureStructure;
		this.expression = expression;
	}
	/**
	 * @return the negated
	 */
	public boolean isNegated() {
		return negated;
	}
	/**
	 * @param negated the negated to set
	 */
	public void setNegated(boolean negated) {
		this.negated = negated;
	}
	/**
	 * @return the featureStructure
	 */
	public FeatureStructure getFeatureStructure() {
		return featureStructure;
	}
	/**
	 * @param featureStructure the featureStructure to set
	 */
	public void setFeatureStructure(FeatureStructure featureStructure) {
		this.featureStructure = featureStructure;
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
