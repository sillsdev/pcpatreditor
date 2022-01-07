/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.List;

import org.sil.pcpatreditor.Constants;

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

	public String psrRepresentation() {
		StringBuilder sb = new StringBuilder();
		sb.append(leftHandSide.nodeRepresentation());
		sb.append(" = ");
		for (int i = 0; i < rightHandSide.size(); i++) {
			PhraseStructureRuleRightHandSide rhs = rightHandSide.get(i);
			if (i > 0) {
				sb.append(Constants.PSR_SEPARATOR);
			}
			sb.append(rhs.psrRepresentation());
		}
		return sb.toString();
	}

	public String getNonTerminalSymbol() {
		return getLeftHandSide().getNode();
	}

	public List<String> getTerminalSymbols() {
		List<String> terminals = new ArrayList<>();
		for (PhraseStructureRuleRightHandSide rhs : getRightHandSide()) {
			for (Constituent c : rhs.getConstituents()) {
				terminals.add(c.getNode());
			}
		}
		return terminals;
	}
}
