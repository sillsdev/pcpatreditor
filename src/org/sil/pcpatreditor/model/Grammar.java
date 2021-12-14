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
public class Grammar {

	List<PatrRule> rules = new ArrayList<PatrRule>();

	public Grammar() {
	}
	
	/**
	 * @param rules
	 */
	public Grammar(List<PatrRule> rules) {
		super();
		this.rules = rules;
	}

	/**
	 * @return the rules
	 */
	public List<PatrRule> getRules() {
		return rules;
	}

	/**
	 * @param rules the rules to set
	 */
	public void setRules(List<PatrRule> rules) {
		this.rules = rules;
	}
}
