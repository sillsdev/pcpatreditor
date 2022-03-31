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
import org.sil.pcpatreditor.model.AtomicValueDisjunction;
import org.sil.pcpatreditor.model.BinaryOperation;
import org.sil.pcpatreditor.model.DisjunctiveUnificationConstraints;
import org.sil.pcpatreditor.model.EmbeddedFeatureStructure;
import org.sil.pcpatreditor.model.FeaturePath;
import org.sil.pcpatreditor.model.FeaturePathOrStructure;
import org.sil.pcpatreditor.model.FeaturePathTemplateBody;
import org.sil.pcpatreditor.model.FeaturePathUnit;
import org.sil.pcpatreditor.model.FeatureStructure;
import org.sil.pcpatreditor.model.FeatureStructureValue;
import org.sil.pcpatreditor.model.FeatureTemplate;
import org.sil.pcpatreditor.model.FeatureTemplateDisjunction;
import org.sil.pcpatreditor.model.FeatureTemplateValue;
import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.LogicalConstraint;
import org.sil.pcpatreditor.model.LogicalConstraintExpression;
import org.sil.pcpatreditor.model.LogicalConstraintFactor;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.ConstraintLeftHandSide;
import org.sil.pcpatreditor.model.ConstraintRightHandSide;
import org.sil.pcpatreditor.model.ConstraintWithLeftRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.DisjunctionUnificationConstraints;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PriorityUnionConstraint;
import org.sil.pcpatreditor.model.SequencedOrSingleConstituent;
import org.sil.pcpatreditor.model.UnificationConstraint;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarBaseListener;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.AtomicValueDisjunctionContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.ConstituentContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.DisjunctionConstituentsContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.DisjunctionUnificationConstraintContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.DisjunctiveUnificationConstraintContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeaturePathOrStructureContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeaturePathUnitContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeatureTemplateAbbreviationContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeatureTemplateDisjunctionContext;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser.FeatureTemplateValueContext;

/**
 * @author Andy Black
 *
 */
public class BuildGrammarFromPcPatrGrammarListener extends PcPatrGrammarBaseListener {

	PcPatrGrammarParser parser;
	Grammar grammar;
	
	private HashMap<Integer, AtomicValueDisjunction> atomicValueDisjunctionMap = new HashMap<>();
	private HashMap<Integer, DisjunctionConstituents> disjunctionConstituentsMap = new HashMap<>();
	private HashMap<Integer, DisjunctiveConstituents> disjunctiveConstituentsMap = new HashMap<>();
	private HashMap<Integer, DisjunctionUnificationConstraints> disjunctionUnificationConstraintsMap = new HashMap<>();
	private HashMap<Integer, DisjunctiveUnificationConstraints> disjunctiveUnificationConstraintsMap = new HashMap<>();
	private HashMap<Integer, Constituent> constituentMap = new HashMap<>();
	private HashMap<Integer, EmbeddedFeatureStructure> embeddedFeatureStuctureMap = new HashMap<>();
	private HashMap<Integer, FeaturePath> featurePathMap = new HashMap<>();
	private HashMap<Integer, FeaturePathUnit> featurePathUnitMap = new HashMap<>();
	private HashMap<Integer, FeaturePathOrStructure> featurePathOrStructureMap = new HashMap<>();
	private HashMap<Integer, FeaturePathTemplateBody> featurePathTemplateBodyMap = new HashMap<>();
	private HashMap<Integer, FeatureStructure> featureStructureMap = new HashMap<>();
	private HashMap<Integer, FeatureStructureValue> featureStructureValueMap = new HashMap<>();
	private HashMap<Integer, FeatureTemplateDisjunction> featureTemplateDisjunctionMap = new HashMap<>();
	private HashMap<Integer, FeatureTemplateValue> featureTemplateValueMap = new HashMap<>();
	private HashMap<Integer, LogicalConstraint> logicalConstraintMap = new HashMap<>();
	private HashMap<Integer, LogicalConstraintExpression> logicalConstraintEpressionMap = new HashMap<>();
	private HashMap<Integer, LogicalConstraintFactor> logicalConstraintFactorMap = new HashMap<>();
	private HashMap<Integer, OptionalConstituents> optionalConstituentsMap = new HashMap<>();
	private HashMap<Integer, PriorityUnionConstraint> priorityUnionConstraintMap = new HashMap<>();
	private HashMap<Integer, UnificationConstraint> unificationConstraintMap = new HashMap<>();

	ConstituentContext constituentCtx = new ConstituentContext(null, 0);
	DisjunctionConstituentsContext disjunctionConstituentCtx = new DisjunctionConstituentsContext(null, 0);
	PhraseStructureRule psr;
	List<SequencedOrSingleConstituent> rhs = new ArrayList<>();
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
	public void enterAtomicValueDisjunction(PcPatrGrammarParser.AtomicValueDisjunctionContext ctx) {
		AtomicValueDisjunction avdisjunction = new AtomicValueDisjunction();
		atomicValueDisjunctionMap.put(ctx.hashCode(), avdisjunction);
	}

	@Override
	public void enterDisjunctionUnificationConstraint(PcPatrGrammarParser.DisjunctionUnificationConstraintContext ctx) {
		DisjunctionUnificationConstraints ducs = new DisjunctionUnificationConstraints(true, false);
		disjunctionUnificationConstraintsMap.put(ctx.hashCode(), ducs);
	}

	@Override
	public void enterDisjunctiveUnificationConstraint(PcPatrGrammarParser.DisjunctiveUnificationConstraintContext ctx) {
		DisjunctiveUnificationConstraints ducs = new DisjunctiveUnificationConstraints(true, false);
		disjunctiveUnificationConstraintsMap.put(ctx.hashCode(), ducs);
	}

	@Override
	public void enterEmbeddedFeatureStructure(PcPatrGrammarParser.EmbeddedFeatureStructureContext ctx) {
		EmbeddedFeatureStructure efs = new EmbeddedFeatureStructure(null, null);
		embeddedFeatureStuctureMap.put(ctx.hashCode(), efs);
	}

	@Override
	public void enterFeaturePath(PcPatrGrammarParser.FeaturePathContext ctx) {
		FeaturePath featurePath = new FeaturePath();
		featurePathMap.put(ctx.hashCode(), featurePath);
	}

	@Override
	public void enterFeaturePathTemplateBody(PcPatrGrammarParser.FeaturePathTemplateBodyContext ctx) {
		FeaturePathTemplateBody fptb = new FeaturePathTemplateBody(true, false);
		featurePathTemplateBodyMap.put(ctx.hashCode(), fptb);
	}

	@Override
	public void enterFeaturePathUnit(PcPatrGrammarParser.FeaturePathUnitContext ctx) {
		featurePathMap.clear();
		FeaturePathUnit featurePathUnit = new FeaturePathUnit();
		featurePathUnitMap.put(ctx.hashCode(), featurePathUnit);
	}

	@Override
	public void enterFeatureStructure(PcPatrGrammarParser.FeatureStructureContext ctx) {
		FeatureStructure featureStructure = new FeatureStructure();
		featureStructureMap.put(ctx.hashCode(), featureStructure);
	}

	@Override
	public void enterFeatureStructureValue(PcPatrGrammarParser.FeatureStructureValueContext ctx) {
		FeatureStructureValue fsValue = new FeatureStructureValue();
		featureStructureValueMap.put(ctx.hashCode(), fsValue);
	}

	@Override
	public void enterFeatureTemplate(PcPatrGrammarParser.FeatureTemplateContext ctx) {
		featureTemplateDisjunctionMap.clear();
		featureTemplateValueMap.clear();
		clearFeatureOrientedMaps();
		featureTemplate = new FeatureTemplate(true, false);
	}

	@Override
	public void enterFeatureTemplateDisjunction(PcPatrGrammarParser.FeatureTemplateDisjunctionContext ctx) {
		FeatureTemplateDisjunction ftdisj = new FeatureTemplateDisjunction();
		featureTemplateDisjunctionMap.put(ctx.hashCode(), ftdisj);
	}

	@Override
	public void enterFeatureTemplateValue(PcPatrGrammarParser.FeatureTemplateValueContext ctx) {
		FeatureTemplateValue ftv = new FeatureTemplateValue();
		featureTemplateValueMap.put(ctx.hashCode(), ftv);
	}

	@Override
	public void enterLogConstraintExpression(PcPatrGrammarParser.LogConstraintExpressionContext ctx) {
		LogicalConstraintExpression lce = new LogicalConstraintExpression(null, null, null);
		logicalConstraintEpressionMap.put(ctx.hashCode(), lce);
	}

	@Override
	public void enterLogConstraintFactor(PcPatrGrammarParser.LogConstraintFactorContext ctx) {
		LogicalConstraintFactor factor = new LogicalConstraintFactor(false, null, null);
		logicalConstraintFactorMap.put(ctx.hashCode(), factor);
	}

	@Override
	public void enterLogicalConstraint(PcPatrGrammarParser.LogicalConstraintContext ctx) {
		LogicalConstraint lc = new LogicalConstraint(true, false, null, null);
		logicalConstraintMap.put(ctx.hashCode(), lc);
	}

	@Override
	public void enterPatrgrammar(PcPatrGrammarParser.PatrgrammarContext ctx) {
		grammar = new Grammar();
	}
	
	@Override
	public void enterPatrRule(PcPatrGrammarParser.PatrRuleContext ctx) {
		clearConstituentOrientedMaps();
		clearFeatureOrientedMaps();
		clearLogicalConstraintOrientedMaps();
		rule = new PatrRule(true, false);
		rule.setLineNumber(ctx.start.getLine());
		rule.setCharacterIndex(ctx.start.getStartIndex());
	}

	@Override
	public void enterPriorityUnionConstraint(PcPatrGrammarParser.PriorityUnionConstraintContext ctx) {
		PriorityUnionConstraint pc = new PriorityUnionConstraint(true, false, null, null);
		priorityUnionConstraintMap.put(ctx.hashCode(), pc);
	}

	@Override
	public void enterRightHandSide(PcPatrGrammarParser.RightHandSideContext ctx) {
		disjunctionConstituentsMap.clear();
		disjunctiveConstituentsMap.clear();
		optionalConstituentsMap.clear();
	}

	@Override
	public void enterUnificationConstraint(PcPatrGrammarParser.UnificationConstraintContext ctx) {
		UnificationConstraint uc = new UnificationConstraint(true, false, null);
		unificationConstraintMap.put(ctx.hashCode(), uc);
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
			case "DisjunctionConstituentsContext":
				DisjunctionConstituents dc = disjunctionConstituentsMap.get(prCtx.hashCode());
				disjunctionConstituents.getContents().add(dc);
				break;
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents dcv = disjunctiveConstituentsMap.get(prCtx.hashCode());
				disjunctionConstituents.getContents().add(dcv);
				break;
			case "OptionalConstituentsContext":
				OptionalConstituents optionalConstituents = optionalConstituentsMap.get(prCtx.hashCode());
				disjunctionConstituents.getContents().add(optionalConstituents);
				break;
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				disjunctionConstituents.getContents().add(constituent);
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
				disjunctiveConstituents.getContents().add(dc);
				break;
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents dcv = disjunctiveConstituentsMap.get(prCtx.hashCode());
				disjunctiveConstituents.getContents().add(dcv);
				break;
			case "OptionalConstituentsContext":
				OptionalConstituents optionalConstituents = optionalConstituentsMap.get(prCtx.hashCode());
				disjunctiveConstituents.getContents().add(optionalConstituents);
				break;
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				disjunctiveConstituents.getContents().add(constituent);
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
		} else if (parentCtx instanceof AtomicValueDisjunctionContext) {
			AtomicValueDisjunction avd = atomicValueDisjunctionMap.get(parentCtx.hashCode());
			avd.getAtomicValues().add(ctx.getText());
		}
	}

	@Override
	public void exitConstituent(PcPatrGrammarParser.ConstituentContext ctx) {
		Constituent constituent = new Constituent(ctx.getText());
		constituentMap.put(ctx.hashCode(), constituent);
	}

	@Override
	public void exitDisjunctionUnificationConstraint(PcPatrGrammarParser.DisjunctionUnificationConstraintContext ctx) {
		ParserRuleContext parentCtx = ctx.getParent();
		DisjunctiveUnificationConstraints duc = disjunctiveUnificationConstraintsMap.get(parentCtx.hashCode());
		duc.getDisjunctionUnificationConstraints().add(disjunctionUnificationConstraintsMap.get(ctx.hashCode()));
	}

	@Override
	public void exitDisjunctiveUnificationConstraint(PcPatrGrammarParser.DisjunctiveUnificationConstraintContext ctx) {
		ParserRuleContext parentCtx = ctx.getParent();
		UnificationConstraint uc = unificationConstraintMap.get(parentCtx.hashCode());
		DisjunctiveUnificationConstraints duc = disjunctiveUnificationConstraintsMap.get(ctx.hashCode());
		uc.setDisjunctiveUnificationConstraint(duc);
	}

	@Override
	public void exitEmbeddedFeatureStructure(PcPatrGrammarParser.EmbeddedFeatureStructureContext ctx) {
		EmbeddedFeatureStructure efs = embeddedFeatureStuctureMap.get(ctx.hashCode());
		ParseTree childCtx = ctx.getChild(0);
		efs.setName(childCtx.getText());
		childCtx = ctx.getChild(2);
		if (childCtx instanceof PcPatrGrammarParser.FeatureStructureValueContext fsvCtx) {
			FeatureStructureValue fsv = featureStructureValueMap.get(fsvCtx.hashCode());
			efs.setValue(fsv);
		}
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
			fpos.setFeatureStructure(featureStructureMap.get(childCtx.hashCode()));
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
	public void exitFeatureStructure(PcPatrGrammarParser.FeatureStructureContext ctx) {
		FeatureStructure fs = featureStructureMap.get(ctx.hashCode());
		ParseTree childCtx = ctx.getChild(1);
		fs.setName(childCtx.getText());
		childCtx = ctx.getChild(3);
		fs.setValue(featureStructureValueMap.get(childCtx.hashCode()));
		for (int i = 4; i < ctx.getChildCount(); i++) {
			childCtx = ctx.getChild(i);
			if (childCtx instanceof PcPatrGrammarParser.EmbeddedFeatureStructureContext efsCtx) {
				EmbeddedFeatureStructure efs = embeddedFeatureStuctureMap.get(efsCtx.hashCode());
				fs.getEmbeddedFeatureStructures().add(efs);
			}
		}
	}

	@Override
	public void exitFeatureStructureValue(PcPatrGrammarParser.FeatureStructureValueContext ctx) {
		FeatureStructureValue fsValue = featureStructureValueMap.get(ctx.hashCode());
		ParseTree childCtx = ctx.getChild(0);
		if (childCtx instanceof PcPatrGrammarParser.AtomicValueContext) {
			fsValue.setAtomicValue(childCtx.getText());
		} else {
			FeatureStructure fs = featureStructureMap.get(childCtx.hashCode());
			fsValue.setFeatureStructure(fs);
		}
	}

	@Override
	public void exitFeatureTemplate(PcPatrGrammarParser.FeatureTemplateContext ctx) {
		grammar.getFeatureTemplates().add(featureTemplate);
	}

	@Override
	public void exitFeaturePathTemplateBody(PcPatrGrammarParser.FeaturePathTemplateBodyContext ctx) {
		FeaturePathTemplateBody fptb = featurePathTemplateBodyMap.get(ctx.hashCode());
		ParseTree childCtx = ctx.getChild(0);
		if (childCtx instanceof FeaturePathUnitContext fpuCtx) {
			FeaturePathUnit featurePathUnit = featurePathUnitMap.get(fpuCtx.hashCode());
			fptb.setFeaturePathUnit(featurePathUnit);
			ParserRuleContext parentCtx = ctx.getParent();
			String sParentClass = parentCtx.getClass().getSimpleName();
			if (sParentClass.equals("FeatureTemplateContext")) {
				featureTemplate.setFeaturePathTemplateBody(fptb);
			} else if (sParentClass.equals("FeaturePathTemplateBodyContext")) {
				FeaturePathTemplateBody fptbParent = featurePathTemplateBodyMap.get(parentCtx.hashCode());
				fptbParent.setFeaturePathTemplateBody(fptb);
			}
			childCtx = ctx.getChild(2);
			if (childCtx instanceof FeatureTemplateValueContext ftvCtx) {
				FeatureTemplateValue ftv = featureTemplateValueMap.get(ftvCtx.hashCode());
				fptb.setFeatureTemplateValue(ftv);
			} else if (childCtx instanceof AtomicValueDisjunctionContext) {
				AtomicValueDisjunction avd = atomicValueDisjunctionMap.get(childCtx.hashCode());
				fptb.setAtomicValueDisjunction(avd);
			}
		} else if (childCtx instanceof FeatureTemplateAbbreviationContext abbrCtx) {
			setParentOfFeaturePathTemplateBody(ctx, fptb);
		} else if (childCtx instanceof FeatureTemplateDisjunctionContext disjCtx) {
			FeatureTemplateDisjunction disj = featureTemplateDisjunctionMap.get(disjCtx.hashCode());
			fptb.setFeatureTemplateDisjunction(disj);
			setParentOfFeaturePathTemplateBody(ctx, fptb);
		} else {
			System.out.println("\tchild not fpu " + childCtx);
		}
	}

	protected void setParentOfFeaturePathTemplateBody(PcPatrGrammarParser.FeaturePathTemplateBodyContext ctx,
			FeaturePathTemplateBody fptb) {
		ParserRuleContext parentCtx = ctx.getParent();
		String sParentClass = parentCtx.getClass().getSimpleName();
		if (sParentClass.equals("FeatureTemplateContext")) {
			featureTemplate.setFeaturePathTemplateBody(fptb);
		} else if (sParentClass.equals("FeaturePathTemplateBodyContext")) {
			FeaturePathTemplateBody fptbParent = featurePathTemplateBodyMap.get(parentCtx.hashCode());
			fptbParent.setFeaturePathTemplateBody(fptb);
		}
	}

	@Override
	public void exitFeatureTemplateAbbreviation(PcPatrGrammarParser.FeatureTemplateAbbreviationContext ctx) {
		ParseTree childCtx = ctx.getChild(1);
		ParserRuleContext parentCtx = ctx.getParent();
		FeaturePathTemplateBody fptb = featurePathTemplateBodyMap.get(parentCtx.hashCode());
		fptb.setFeatureTemplateAbbreviation(childCtx.getText());
	}

	@Override
	public void exitFeatureTemplateName(PcPatrGrammarParser.FeatureTemplateNameContext ctx) {
		ParserRuleContext parentCtx = ctx.getParent();
		if (parentCtx instanceof PcPatrGrammarParser.FeatureTemplateDefinitionContext) {
			featureTemplate.setName(ctx.getText());
		}
	}

	@Override
	public void exitFeatureTemplateValue(PcPatrGrammarParser.FeatureTemplateValueContext ctx) {
		FeatureTemplateValue ftv = featureTemplateValueMap.get(ctx.hashCode());
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
		String sParentClass = getParentClass(ctx);
		if (sParentClass.equals("FeaturePathTemplateBodyContext")) {
			FeaturePathTemplateBody fptb = featurePathTemplateBodyMap.get(ctx.getParent().hashCode());
			fptb.setFeatureTemplateValue(ftv);
		}
	}

	@Override
	public void exitLogConstraintExpression(PcPatrGrammarParser.LogConstraintExpressionContext ctx) {
		LogicalConstraintExpression lce = logicalConstraintEpressionMap.get(ctx.hashCode());
		LogicalConstraintFactor lcf1;
		LogicalConstraintFactor lcf2;
		BinaryOperation bo;
		int childCount = ctx.getChildCount();
		switch (childCount) {
		case 1:
			lcf1 = processFactor(ctx.getChild(0), false);
			lce.setFactor1(lcf1);
			break;
		case 2:
			lcf1 = processFactor(ctx.getChild(1), true);
			lce.setFactor1(lcf1);
			break;
		case 3:
			lcf1 = processFactor(ctx.getChild(0), false);
			lce.setFactor1(lcf1);
			bo = processBinaryOperation(ctx.getChild(1));
			lce.setBinop(bo);
			lcf2 = processFactor(ctx.getChild(2), false);
			lce.setFactor2(lcf2);
			break;
		case 4:
			if (ctx.getChild(0).getText().equals("~")) {
				lcf1 = processFactor(ctx.getChild(1), true);
				lce.setFactor1(lcf1);
				bo = processBinaryOperation(ctx.getChild(2));
				lce.setBinop(bo);
				lcf2 = processFactor(ctx.getChild(3), false);
				lce.setFactor2(lcf2);
			} else {
				lcf1 = processFactor(ctx.getChild(0), false);
				lce.setFactor1(lcf1);
				bo = processBinaryOperation(ctx.getChild(1));
				lce.setBinop(bo);
				lcf2 = processFactor(ctx.getChild(3), true);
				lce.setFactor2(lcf2);
			}
			break;
		case 5:
			lcf1 = processFactor(ctx.getChild(1), true);
			lce.setFactor1(lcf1);
			bo = processBinaryOperation(ctx.getChild(2));
			lce.setBinop(bo);
			lcf2 = processFactor(ctx.getChild(4), true);
			lce.setFactor2(lcf2);
			break;
		default:
			System.out.println("exitLogConstraintExpression: unknown child count=" + childCount);
		}
	}

	@Override
	public void exitLogConstraintFactor(PcPatrGrammarParser.LogConstraintFactorContext ctx) {
		LogicalConstraintFactor lcf = logicalConstraintFactorMap.get(ctx.hashCode());
		if (ctx.getChildCount() == 1) {
			ParseTree childCtx = ctx.getChild(0);
			FeatureStructure fs = featureStructureMap.get(childCtx.hashCode());
			lcf.setFeatureStructure(fs);
		} else {
			LogicalConstraintExpression lce = logicalConstraintEpressionMap.get(ctx.getChild(1).hashCode());
			lcf.setExpression(lce);
		}
	}

	@Override
	public void exitLogConstraintLeftHandSide(PcPatrGrammarParser.LogConstraintLeftHandSideContext ctx) {
		ConstraintLeftHandSide lhs = new ConstraintLeftHandSide(null, null);
		ParseTree childCtx = ctx.getChild(1);
		lhs.setConstituent(constituentMap.get(childCtx.hashCode()));
		if (ctx.getChildCount() > 1) {
			childCtx = ctx.getChild(2);
			lhs.setFeaturePath(featurePathMap.get(childCtx.hashCode()));
		}
		LogicalConstraint lc = logicalConstraintMap.get(ctx.getParent().hashCode());
		lc.setLeftHandSide(lhs);
	}

	@Override
	public void exitLogicalConstraint(PcPatrGrammarParser.LogicalConstraintContext ctx) {
		LogicalConstraintExpression lce = logicalConstraintEpressionMap.get(ctx.getChild(2).hashCode());
		LogicalConstraint lc = logicalConstraintMap.get(ctx.hashCode());
		lc.setExpression(lce);
		rule.getConstraints().add(lc);
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
			case "DisjunctionConstituentsContext":
				DisjunctionConstituents dc = disjunctionConstituentsMap.get(prCtx.hashCode());
				optionalConstituents.getContents().add(dc);
				break;
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents dcv = disjunctiveConstituentsMap.get(prCtx.hashCode());
				optionalConstituents.getContents().add(dcv);
				break;
			case "OptionalConstituentsContext":
				OptionalConstituents oc = optionalConstituentsMap.get(prCtx.hashCode());
				optionalConstituents.getContents().add(oc);
				break;
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				optionalConstituents.getContents().add(constituent);
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
	public void exitPatrRule(PcPatrGrammarParser.PatrRuleContext ctx) {
		rule.setPhraseStructureRule(psr);
		grammar.getRules().add(rule);
	}

	@Override 
	public void exitPhraseStructureRule(PcPatrGrammarParser.PhraseStructureRuleContext ctx) {
		constituentCtx = (ConstituentContext)ctx.getChild(0);
		Constituent nt = constituentMap.get(constituentCtx.hashCode());
		psr = new PhraseStructureRule(nt, rhs);
	}

	@Override
	public void exitPriorityUnionConstraint(PcPatrGrammarParser.PriorityUnionConstraintContext ctx) {
		rule.getConstraints().add(priorityUnionConstraintMap.get(ctx.hashCode()));
	}
	@Override
	public void exitPriorityUnionLeftHandSide(PcPatrGrammarParser.PriorityUnionLeftHandSideContext ctx) {
		ConstraintLeftHandSide lhs = new ConstraintLeftHandSide(null, null);
		ParseTree childCtx = ctx.getChild(1);
		lhs.setConstituent(constituentMap.get(childCtx.hashCode()));
		childCtx = ctx.getChild(2);
		lhs.setFeaturePath(featurePathMap.get(childCtx.hashCode()));
		PriorityUnionConstraint puc = priorityUnionConstraintMap.get(ctx.getParent().hashCode());
		puc.setLeftHandSide(lhs);
	}

	@Override
	public void exitPriorityUnionRightHandSide(PcPatrGrammarParser.PriorityUnionRightHandSideContext ctx) {
		ConstraintRightHandSide rhs = new ConstraintRightHandSide(null, null);
		ParseTree childCtx = ctx.getChild(0);
		if (childCtx instanceof PcPatrGrammarParser.AtomicValueContext) {
			rhs.setAtomicValue(childCtx.getText());
		} else {
			childCtx = ctx.getChild(1);
			rhs.setConstituent(constituentMap.get(childCtx.hashCode()));
			childCtx = ctx.getChild(2);
			rhs.setFeaturePath(featurePathMap.get(childCtx.hashCode()));
		}
		PriorityUnionConstraint puc = priorityUnionConstraintMap.get(ctx.getParent().hashCode());
		puc.setRightHandSide(rhs);
	}

	@Override
	public void exitRightHandSide(PcPatrGrammarParser.RightHandSideContext ctx) {
		rhs = new ArrayList<>();
		int numChildren = ctx.getChildCount();
		for (int i = 0; i < numChildren; i++) {
			ParserRuleContext prCtx = (ParserRuleContext) ctx.getChild(i);
			String sClass = prCtx.getClass().getSimpleName();
			switch (sClass) {
			case "ConstituentContext":
				Constituent constituent = constituentMap.get(prCtx.hashCode());
				rhs.add(constituent);
				break;
			case "DisjunctiveConstituentsContext":
				DisjunctiveConstituents disjunctiveConstituents = disjunctiveConstituentsMap.get(prCtx.hashCode());
				rhs.add(disjunctiveConstituents);
			break;
			case "OptionalConstituentsContext":
				OptionalConstituents optionalConstituents = optionalConstituentsMap.get(prCtx.hashCode());
				rhs.add(optionalConstituents);
			break;
			case "DisjunctionConstituentsContext":
				DisjunctionConstituents dc = disjunctionConstituentsMap.get(prCtx.hashCode());
				rhs.add(dc);
				break;
			}
		}
	}

	@Override
	public void exitUniConstraintLeftHandSide(PcPatrGrammarParser.UniConstraintLeftHandSideContext ctx) {
		ConstraintLeftHandSide lhs = new ConstraintLeftHandSide(null, null);
		ParseTree childCtx = ctx.getChild(1);
		lhs.setConstituent(constituentMap.get(childCtx.hashCode()));
		childCtx = ctx.getChild(2);
		lhs.setFeaturePath(featurePathMap.get(childCtx.hashCode()));
		ConstraintWithLeftRightHandSide uc = unificationConstraintMap.get(ctx.getParent().hashCode());
		uc.setLeftHandSide(lhs);
	}

	@Override
	public void exitUniConstraintRightHandSide(PcPatrGrammarParser.UniConstraintRightHandSideContext ctx) {
		ConstraintRightHandSide rhs = new ConstraintRightHandSide(null, null);
		ParseTree childCtx = ctx.getChild(0);
		if (childCtx instanceof PcPatrGrammarParser.AtomicValueContext) {
			rhs.setAtomicValue(childCtx.getText());
		} else {
			childCtx = ctx.getChild(1);
			rhs.setConstituent(constituentMap.get(childCtx.hashCode()));
			if (ctx.getChildCount() > 2) {
				childCtx = ctx.getChild(2);
				if (childCtx instanceof PcPatrGrammarParser.FeaturePathContext) {
					rhs.setFeaturePath(featurePathMap.get(childCtx.hashCode()));
				}
			}
		}
		ConstraintWithLeftRightHandSide uc = unificationConstraintMap.get(ctx.getParent().hashCode());
		uc.setRightHandSide(rhs);
	}

	@Override
	public void exitUnificationConstraint(PcPatrGrammarParser.UnificationConstraintContext ctx) {
		UnificationConstraint uc = unificationConstraintMap.get(ctx.hashCode());
		ParserRuleContext parentCtx = ctx.getParent();
		if (parentCtx instanceof DisjunctionUnificationConstraintContext) {
			DisjunctionUnificationConstraints duc = disjunctionUnificationConstraintsMap.get(parentCtx.hashCode());
			duc.getUnificationConstraints().add(uc);
		} else if (parentCtx instanceof DisjunctiveUnificationConstraintContext) {
			DisjunctiveUnificationConstraints duc = disjunctiveUnificationConstraintsMap.get(parentCtx.hashCode());
			duc.getUnificationConstraints().add(uc);
		} else {
			rule.getConstraints().add(uc);
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

	protected BinaryOperation processBinaryOperation(ParseTree child) {
		switch (child.getText()) {
		case "&":
			return BinaryOperation.AND;
		case "/":
			return BinaryOperation.OR;
		case "->":
			return BinaryOperation.CONDITIONAL;
		case "<->":
			return BinaryOperation.BICONDITIONAL;
		}
		return BinaryOperation.AND;
	}

	protected void clearConstituentOrientedMaps() {
		constituentMap.clear();
		disjunctionConstituentsMap.clear();
		disjunctiveConstituentsMap.clear();
	}

	protected void clearFeatureOrientedMaps() {
		embeddedFeatureStuctureMap.clear();
		featurePathMap.clear();
		featurePathOrStructureMap.clear();
		featurePathTemplateBodyMap.clear();
		featurePathUnitMap.clear();
		featureStructureMap.clear();
		featureStructureValueMap.clear();
	}

	protected void clearLogicalConstraintOrientedMaps() {
		logicalConstraintMap.clear();
		logicalConstraintEpressionMap.clear();
		logicalConstraintFactorMap.clear();
	}

	protected LogicalConstraintFactor processFactor(ParseTree child, boolean negated) {
		LogicalConstraintFactor lcf = logicalConstraintFactorMap.get(child.hashCode());
		lcf.setNegated(negated);
		return lcf;
	}
}
