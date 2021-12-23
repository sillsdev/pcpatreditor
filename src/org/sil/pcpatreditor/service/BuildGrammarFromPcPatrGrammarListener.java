/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.ConstituentsRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.DisjunctionConstituentsRightHandSide;
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.OptionalConstituentsRightHandSide;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PhraseStructureRuleRightHandSide;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarBaseListener;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.ConstituentContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.DisjunctionConstituentsContext;

/**
 * @author Andy Black
 *
 */
public class BuildGrammarFromPcPatrGrammarListener extends PcPatrGrammarBaseListener {

	PcPatrGrammarParser parser;
	Grammar grammar;
	
	private HashMap<Integer, DisjunctionConstituents> disjunctionConstituentsMap = new HashMap<>();
	private HashMap<Integer, DisjunctiveConstituents> disjunctiveConstituentsMap = new HashMap<>();
	private HashMap<Integer, OptionalConstituents> optionalConstituentsMap = new HashMap<>();
	private HashMap<Integer, Constituent> constituentMap = new HashMap<>();
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
		rule.setLineNumber(ctx.start.getLine());
	}
	
	@Override
	public void enterRightHandSide(PcPatrGrammarParser.RightHandSideContext ctx) {
		disjunctionConstituentsMap.clear();
		disjunctiveConstituentsMap.clear();
		optionalConstituentsMap.clear();
	}

	@Override
	public void exitDisjunctionConstituents(PcPatrGrammarParser.DisjunctionConstituentsContext ctx) {
		DisjunctionConstituents disjunctionConstituents = new DisjunctionConstituents();
		int numChildren = ctx.getChildCount();
		for (int i = 1; i < numChildren; i++) {
			// first one is always the '{' terminal, so skip it
			// we may have comments so we do not know for sure where the '}' terminal is
			ParseTree prCtx = ctx.getChild(i);
			String sChildClass = prCtx.getClass().getSimpleName();
			switch (sChildClass) {
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents dc = disjunctiveConstituentsMap.get(prCtx.hashCode());
				disjunctionConstituents.getContents().add(dc);
				break;
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				ConstituentsRightHandSide cRhs = new ConstituentsRightHandSide();
				cRhs.getConstituents().add(constituent);
				disjunctionConstituents.getContents().add(cRhs);
				break;
			case "CommentContext":
				// do nothing right now
				break;
			}
		}
		disjunctionConstituentsMap.put(ctx.hashCode(), disjunctionConstituents);
	}

	@Override
	public void exitDisjunctiveConstituents(PcPatrGrammarParser.DisjunctiveConstituentsContext ctx) {
		DisjunctiveConstituents disjunctiveConstituents = new DisjunctiveConstituents();
		int numChildren = ctx.getChildCount();
		for (int i = 1; i < numChildren; i++) {
			// first one is always the '{' terminal, so skip it
			// we may have comments so we do not know for sure where the '}' terminal is
			ParseTree prCtx = ctx.getChild(i);
			String sChildClass = prCtx.getClass().getSimpleName();
			switch (sChildClass) {
			case "DisjunctionConstituentsContext":
				DisjunctionConstituents dc = disjunctionConstituentsMap.get(prCtx.hashCode());
				disjunctiveConstituents.getDisjunctionConstituents().add(dc);
				break;
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				disjunctiveConstituents.getConstituents().add(constituent);
				break;
			case "CommentContext":
				// do nothing right now
				break;
			}
		}
		disjunctiveConstituentsMap.put(ctx.hashCode(), disjunctiveConstituents);
	}

	@Override
	public void exitConstituent(PcPatrGrammarParser.ConstituentContext ctx) {
		Constituent constituent = new Constituent(ctx.getText());
		constituentMap.put(ctx.hashCode(), constituent);
	}
	
	@Override
	public void exitOptionalConstituents(PcPatrGrammarParser.OptionalConstituentsContext ctx) {
		OptionalConstituents optionalConstituents = new OptionalConstituents();
		int numChildren = ctx.getChildCount();
		for (int i = 1; i < numChildren; i++) {
			// first one is always the '(' terminal, so skip it
			// we may have comments so we do not know for sure where the ')' terminal is
			ParseTree prCtx = ctx.getChild(i);
			String sChildClass = prCtx.getClass().getSimpleName();
			switch (sChildClass) {
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents dc = disjunctiveConstituentsMap.get(prCtx.hashCode());
				optionalConstituents.getContents().add(dc);
				break;
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				ConstituentsRightHandSide cRhs = new ConstituentsRightHandSide();
				cRhs.getConstituents().add(constituent);
				optionalConstituents.getContents().add(cRhs);
				break;
			case "CommentContext":
				// do nothing right now
				break;
			}
		}
		optionalConstituentsMap.put(ctx.hashCode(), optionalConstituents);
	}

	protected String getParentClass(ParserRuleContext ctx) {
		ParserRuleContext parent = ctx.getParent();
		String sParentClass = parent.getClass().getSimpleName();
		int iStart = sParentClass.indexOf("$");
		sParentClass = sParentClass.substring(iStart +1);
		return sParentClass;
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
	}

	@Override
	public void exitRightHandSide(PcPatrGrammarParser.RightHandSideContext ctx) {
		rhs = new ArrayList<>();
		String lastClass = "";
		String nextClass = "";
		int numChildren = ctx.getChildCount();
		ConstituentsRightHandSide cRhs = new ConstituentsRightHandSide();
		for (int i = 0; i < numChildren; i++) {
			ParserRuleContext prCtx = (ParserRuleContext) ctx.getChild(i);
			ParserRuleContext prCtxNext = null;
			if (i < numChildren-1) {
				prCtxNext = (ParserRuleContext) ctx.getChild(i+1);
				nextClass = prCtxNext.getClass().getSimpleName();
			}
			String sClass = prCtx.getClass().getSimpleName();
			switch (sClass) {
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				if (!lastClass.equals(sClass)) {
					cRhs = new ConstituentsRightHandSide();
				}
				cRhs.getConstituents().add(constituent);
				if (i == numChildren-1 || !nextClass.equals(sClass)) {
					rhs.add(cRhs);
				}
				break;
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents disjunctiveConstituents = disjunctiveConstituentsMap.get(prCtx.hashCode());
				rhs.add(disjunctiveConstituents);
			break;
			case "OptionalConstituentsContext":
				OptionalConstituents optionalConstituents = optionalConstituentsMap.get(prCtx.hashCode());
				OptionalConstituentsRightHandSide ocRhs = new OptionalConstituentsRightHandSide();
				ocRhs.getOptionalConstituents().add(optionalConstituents);
				rhs.add(ocRhs);
			break;
			case "DisjunctionConstituentsContext":
				DisjunctionConstituents dc = disjunctionConstituentsMap.get(prCtx.hashCode());
				DisjunctionConstituentsRightHandSide dcRhs = new DisjunctionConstituentsRightHandSide();
				dcRhs.getDisjunctionConstituents().add(dc);
				rhs.add(dcRhs);
				break;
			}
			lastClass = sClass;
		}
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
	}
}
