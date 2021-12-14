/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.ConstituentsRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PhraseStructureRuleRightHandSide;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarBaseListener;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarLexer;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.ConstituentContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.DisjunctionConstituentsContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.DisjunctiveConstituentsContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.PatrRuleContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.PhraseStructureRuleContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.RuleIdentifierContext;

/**
 * @author Andy Black
 *
 */
public class BuildGrammarFromPcPatrGrammarListener extends PcPatrGrammarBaseListener {

	PcPatrGrammarParser parser;
	Grammar grammar;
	
	private HashMap<Integer, DisjunctionConstituents> disjunctionConstituentsMap = new HashMap<>();
	private HashMap<Integer, OptionalConstituents> optionalConstituentsMap = new HashMap<>();
	private HashMap<Integer, Constituent> constituentMap = new HashMap<>();
	private HashMap<Integer, PhraseStructureRuleRightHandSide> psrRhsMap = new HashMap<>();
	ConstituentContext constituentCtx = new ConstituentContext(null, 0);
	DisjunctionConstituentsContext disjunctionConstituentCtx = new DisjunctionConstituentsContext(null, 0);
	PhraseStructureRule psr;
	List<PhraseStructureRuleRightHandSide> rhs = new ArrayList<>();
	PatrRule rule;
	
	public BuildGrammarFromPcPatrGrammarListener(PcPatrGrammarParser parser) {
		this.parser = parser;
	}

	/**
	 * @return the grammar
	 */
	public Grammar getGrammar() {
		return grammar;
	}

	/**
	 * @param grammar the grammar to set
	 */
	public void setGrammar(Grammar grammar) {
		this.grammar = grammar;
	}
	
	@Override
	public void enterPatrgrammar(PcPatrGrammarParser.PatrgrammarContext ctx) {
		grammar = new Grammar();
	}
	
	@Override
	public void enterPatrRule(PcPatrGrammarParser.PatrRuleContext ctx) {
		constituentMap.clear();
		rule = new PatrRule(true, false);
		System.out.println("enter rule: " + ctx);
	}
	
	@Override
	public void enterRightHandSide(PcPatrGrammarParser.RightHandSideContext ctx) {
		psrRhsMap.clear();
		rhs.clear();
		disjunctionConstituentsMap.clear();
		optionalConstituentsMap.clear();
	}

	@Override
	public void exitDisjunctionConstituents(PcPatrGrammarParser.DisjunctionConstituentsContext ctx) {
		List<ConstituentContext> constituentsCtxs = ctx.getRuleContexts(constituentCtx.getClass());
		List<Constituent> constituentList = addConstituentsToList(constituentsCtxs, 0, constituentsCtxs.size());
		DisjunctionConstituents disjunctionConstituents = new DisjunctionConstituents(constituentList);
		disjunctionConstituentsMap.put(ctx.hashCode(), disjunctionConstituents);
		System.out.println("exit disjunction: constiCtxs: " + constituentsCtxs.size());
	}

	@Override
	public void exitDisjunctiveConstituents(PcPatrGrammarParser.DisjunctiveConstituentsContext ctx) {
		List<ConstituentContext> constituentsCtxs = ctx.getRuleContexts(constituentCtx.getClass());
		List<Constituent> constituentList = addConstituentsToList(constituentsCtxs, 0, constituentsCtxs.size());
		List<DisjunctionConstituentsContext> disjunctionConstituentsCtxs = ctx
				.getRuleContexts(disjunctionConstituentCtx.getClass());
		List<DisjunctionConstituents> dcList = addDisjunctionConstituentsToList(disjunctionConstituentsCtxs, 0,
				disjunctionConstituentsCtxs.size());
		DisjunctiveConstituents disjunctiveConstituents = new DisjunctiveConstituents(constituentList, dcList);
		rhs.add(disjunctiveConstituents);
		System.out.println("exit disjunctive: constiCtxs: " + constituentsCtxs.size() + "; disj=" + disjunctionConstituentsCtxs.size());
	}

	@Override
	public void exitConstituent(PcPatrGrammarParser.ConstituentContext ctx) {
		Constituent nt = new Constituent(ctx.getText());
		constituentMap.put(ctx.hashCode(), nt);
		System.out.println("exit constituent: " + ctx);
	}
	
	@Override
	public void exitRuleIdentifier(PcPatrGrammarParser.RuleIdentifierContext ctx) {
		// Note: tried to use lexer channel per ANLTR documentation but could not find
		// the hidden material.  So, we're just manually adding spaces between ctx children
		// and hoping for the best.
		StringBuilder sb = new StringBuilder();
		// We skip the initial '{' and final '}'
		int iMax = ctx.getChildCount() - 1;
		for (int i = 1; i < iMax; i++) {
			sb.append(ctx.getChild(i).getText());
			if (i < (iMax-1) ) {
				sb.append(" ");
			}
		}
		rule.setIdentifier(sb.toString());
	}

	@Override 
	public void exitPhraseStructureRule(PcPatrGrammarParser.PhraseStructureRuleContext ctx) {
		constituentCtx = (ConstituentContext)ctx.getChild(0);
		Constituent nt = constituentMap.get(constituentCtx.hashCode());
		psr = new PhraseStructureRule(nt, rhs);
		System.out.println("exit psr: " + ctx);
	}

	@Override
	public void exitRightHandSide(PcPatrGrammarParser.RightHandSideContext ctx) {
		System.out.println("exit rhs: " + ctx);
		List<ConstituentContext> constituentCtxs = ctx.getRuleContexts(constituentCtx.getClass());
		List<Constituent> constituentList = addConstituentsToList(constituentCtxs, 0, constituentCtxs.size());
		ConstituentsRightHandSide constituentsRhs = new ConstituentsRightHandSide(constituentList);
		rhs.add(constituentsRhs);
	}

	protected List<Constituent> addConstituentsToList(List<ConstituentContext> constituentCtxs, int iStart, int iEnd) {
		List<Constituent> constituentList = new ArrayList<>();
		for (int i = iStart; i < iEnd; i++) {
			Constituent constituent = constituentMap.get(constituentCtxs.get(i).hashCode());
			constituentList.add(constituent);
		}
		return constituentList;
	}

	protected List<DisjunctionConstituents> addDisjunctionConstituentsToList(
			List<DisjunctionConstituentsContext> disjunctionConstituentCtxs, int iStart, int iEnd) {
		List<DisjunctionConstituents> disjunctionConstituentList = new ArrayList<>();
		for (int i = iStart; i < iEnd; i++) {
			DisjunctionConstituents disjunctionConstituent = disjunctionConstituentsMap
					.get(disjunctionConstituentCtxs.get(i).hashCode());
			disjunctionConstituentList.add(disjunctionConstituent);
		}
		return disjunctionConstituentList;
	}

	@Override
	public void exitPatrRule(PcPatrGrammarParser.PatrRuleContext ctx) {
		rule.setPhraseStructureRule(psr);
		grammar.getRules().add(rule);
		System.out.println("exit rule: " + ctx);

	}
}
