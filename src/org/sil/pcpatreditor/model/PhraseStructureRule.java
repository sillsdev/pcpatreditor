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
public class PhraseStructureRule {

	Constituent leftHandSide;
	List<PhraseStructureRuleRightHandSide> rightHandSide = new ArrayList<PhraseStructureRuleRightHandSide>();
	/**
	 * @param leftHandSide
	 * @param rightHandSide
	 */
	public PhraseStructureRule(Constituent leftHandSide, List<PhraseStructureRuleRightHandSide> rightHandSide) {
		super();
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}
	/**
	 * @return the leftHandSide
	 */
	public Constituent getLeftHandSide() {
		return leftHandSide;
	}
	/**
	 * @param leftHandSide the leftHandSide to set
	 */
	public void setLeftHandSide(Constituent leftHandSide) {
		this.leftHandSide = leftHandSide;
	}
	/**
	 * @return the rightHandSide
	 */
	public List<PhraseStructureRuleRightHandSide> getRightHandSide() {
		return rightHandSide;
	}
	/**
	 * @param rightHandSide the rightHandSide to set
	 */
	public void setRightHandSide(List<PhraseStructureRuleRightHandSide> rightHandSide) {
		this.rightHandSide = rightHandSide;
	}
	
}
