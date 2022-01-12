/**
 * Copyright (c) 2021-2022 SIL International
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
import org.sil.pcpatreditor.model.FeaturePath;
import org.sil.pcpatreditor.model.FeaturePathOrStructure;
import org.sil.pcpatreditor.model.FeaturePathUnit;
import org.sil.pcpatreditor.model.FeatureTemplate;
import org.sil.pcpatreditor.model.FeatureTemplateDisjunction;
import org.sil.pcpatreditor.model.FeatureTemplateValue;
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
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeaturePathOrStructureContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeaturePathUnitContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeatureTemplateDisjunctionContext;

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
	private HashMap<Integer, FeaturePath> featurePathMap = new HashMap<>();
	private HashMap<Integer, FeaturePathUnit> featurePathUnitMap = new HashMap<>();
	private HashMap<Integer, FeaturePathOrStructure> featurePathOrStructureMap = new HashMap<>();
	private HashMap<Integer, FeatureTemplateDisjunction> featureTemplateDisjunctionMap = new HashMap<>();

	ConstituentContext constituentCtx = new ConstituentContext(null, 0);
	DisjunctionConstituentsContext disjunctionConstituentCtx = new DisjunctionConstituentsContext(null, 0);
	PhraseStructureRule psr;
	List<PhraseStructureRuleRightHandSide> rhs = new ArrayList<>();
	PatrRule rule;
	FeatureTemplate featureTemplate;
	
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
	public void enterFeaturePath(PcPatrGrammarParser.FeaturePathContext ctx) {
		FeaturePath featurePath = new FeaturePath();
		featurePathMap.put(ctx.hashCode(), featurePath);
	}

	@Override
	public void enterFeaturePathUnit(PcPatrGrammarParser.FeaturePathUnitContext ctx) {
		featurePathMap.clear();
		FeaturePathUnit featurePathUnit = new FeaturePathUnit();
		featurePathUnitMap.put(ctx.hashCode(), featurePathUnit);
	}

	@Override
	public void enterFeatureTemplate(PcPatrGrammarParser.FeatureTemplateContext ctx) {
		featureTemplate = new FeatureTemplate(true, false);
	}

	@Override
	public void enterFeatureTemplateDisjunction(PcPatrGrammarParser.FeatureTemplateDisjunctionContext ctx) {
		featurePathOrStructureMap.clear();
		FeatureTemplateDisjunction ftdisj = new FeatureTemplateDisjunction();
		featureTemplateDisjunctionMap.put(ctx.hashCode(), ftdisj);
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
		rule.setCharacterIndex(ctx.start.getStartIndex());
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

	@Override public void exitAtomicValue(PcPatrGrammarParser.AtomicValueContext ctx) {
		ParserRuleContext parentCtx = ctx.getParent();
		if (parentCtx instanceof FeaturePathOrStructureContext fposCtx) {
			FeaturePathOrStructure fpos = featurePathOrStructureMap.get(parentCtx.hashCode());
			fpos.setAtomicValue(ctx.getText());
		}
	}

	@Override
	public void exitConstituent(PcPatrGrammarParser.ConstituentContext ctx) {
		Constituent constituent = new Constituent(ctx.getText());
		constituentMap.put(ctx.hashCode(), constituent);
	}

	@Override
	public void exitFeaturePath(PcPatrGrammarParser.FeaturePathContext ctx) {
		FeaturePath featurePath = featurePathMap.get(ctx.hashCode());
		if (ctx.getChildCount() == 1) {
			featurePath.setAtomicValue(ctx.getText());
		} else if (ctx.getChildCount() == 2) {
			featurePath.setAtomicValue(ctx.getChild(0).getText());
			FeaturePath embeddedFeaturePath = featurePathMap.get(ctx.getChild(1).hashCode());
			featurePath.setFeaturePath(embeddedFeaturePath);
		}
	}

	@Override
	public void exitFeaturePathOrStructure(PcPatrGrammarParser.FeaturePathOrStructureContext ctx) {
		FeaturePathOrStructure fpos = new FeaturePathOrStructure();
		ParseTree childCtx = ctx.getChild(0);
		String sClass = childCtx.getClass().getSimpleName();
		switch (sClass) {
		case "AtomicValueContext":
			fpos.setAtomicValue(childCtx.getText());
			break;
		case "FeaturePathContext":
			fpos.setFeaturePath(featurePathMap.get(childCtx.hashCode()));
			break;
		case "FeatureStructureContext":
			break;
		default:
			System.out.println("exitFeatureTemplateValue: Unhandled child class: " + sClass);
			break;
		}
		ParserRuleContext parentCtx = ctx.getParent();
		if (parentCtx instanceof FeatureTemplateDisjunctionContext ftdisjCtx) {
			FeatureTemplateDisjunction ftdisj = featureTemplateDisjunctionMap.get(parentCtx.hashCode());
			ftdisj.getContents().add(fpos);
		} else {
			System.out.println("exitFeaturePathOrStructure: unknown parent: " + parentCtx);
		}
	}

	@Override
	public void exitFeaturePathUnit(PcPatrGrammarParser.FeaturePathUnitContext ctx) {
		FeaturePathUnit featurePathUnit = featurePathUnitMap.get(ctx.hashCode());
		FeaturePath featurePath = featurePathMap.get(ctx.getChild(1).hashCode());
		featurePathUnit.setFeaturePath(featurePath);
	}

	@Override
	public void exitFeatureTemplate(PcPatrGrammarParser.FeatureTemplateContext ctx) {
		grammar.getFeatureTemplates().add(featureTemplate);
	}

	@Override
	public void exitFeaturePathTemplateBody(PcPatrGrammarParser.FeaturePathTemplateBodyContext ctx) {
		ParseTree childCtx = ctx.getChild(0);
		if (childCtx instanceof FeaturePathUnitContext fpuCtx) {
			FeaturePathUnit featurePathUnit = featurePathUnitMap.get(fpuCtx.hashCode());
			featureTemplate.setFeaturePathUnit(featurePathUnit);
		}
	}

	@Override
	public void exitFeatureTemplateName(PcPatrGrammarParser.FeatureTemplateNameContext ctx) {
		featureTemplate.setName(ctx.getText());
	}

	@Override
	public void exitFeatureTemplateValue(PcPatrGrammarParser.FeatureTemplateValueContext ctx) {
		FeatureTemplateValue ftv = new FeatureTemplateValue();
		ParseTree childCtx = ctx.getChild(0);
		String sClass = childCtx.getClass().getSimpleName();
		switch (sClass) {
		case "AtomicValueContext":
			ftv.setAtomicValue(childCtx.getText());
			break;
		case "FeatureTemplateDisjunctionContext":
			ftv.setFeatureTemplateDisjunction(featureTemplateDisjunctionMap.get(childCtx.hashCode()));
			break;
		default:
			System.out.println("exitFeatureTemplateValue: Unhandled child class: " + sClass);
			break;
		}
		featureTemplate.setFeatureTemplateValue(ftv);
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
