/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.PatrRule;

/**
 * @author Andy Black
 *
 */
public class ConstituentsCollector {

	SortedSet<String> nonTerminals = new TreeSet<>();
	SortedSet<String> terminals = new TreeSet<>();
	
	String grammar = "";

	/**
	 * @param grammar
	 */
	public ConstituentsCollector(String grammar) {
		super();
		this.grammar = grammar;
	}

	/**
	 * @return the nonTerminals
	 */
	public SortedSet<String> getNonTerminals() {
		return nonTerminals;
	}

	/**
	 * @param nonTerminals the nonTerminals to set
	 */
	public void setNonTerminals(SortedSet<String> nonTerminals) {
		this.nonTerminals = nonTerminals;
	}

	/**
	 * @return the terminals
	 */
	public SortedSet<String> getTerminals() {
		return terminals;
	}

	/**
	 * @param terminals the terminals to set
	 */
	public void setTerminals(SortedSet<String> terminals) {
		this.terminals = terminals;
	}
	
	public void collect() {
		Grammar pcpatrGrammar = new Grammar();
		pcpatrGrammar = GrammarBuilder.parseAString(grammar, pcpatrGrammar);
		List<PatrRule> rules = pcpatrGrammar.getRules();
		nonTerminals.clear();
		rules.stream().forEach(r -> nonTerminals.add(r.getNonTerminalSymbol()));
		terminals.clear();
		rules.stream().forEach(r -> {
			for (String node : r.getTerminalSymbols()) {
				if (!nonTerminals.contains(node)) {
					terminals.add(node);
				}
			}
		});
	}
}
