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
public class PatrRule extends PcPatrBase {

	String identifier = "";
	PhraseStructureRule phraseStructureRule;
	List<Constraint> constraints = new ArrayList<Constraint>();

	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public PatrRule(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the phraseStructureRule
	 */
	public PhraseStructureRule getPhraseStructureRule() {
		return phraseStructureRule;
	}

	/**
	 * @param phraseStructureRule the phraseStructureRule to set
	 */
	public void setPhraseStructureRule(PhraseStructureRule phraseStructureRule) {
		this.phraseStructureRule = phraseStructureRule;
	}

	/**
	 * @return the constraints
	 */
	public List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * @param constraints the constraints to set
	 */
	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}

}
