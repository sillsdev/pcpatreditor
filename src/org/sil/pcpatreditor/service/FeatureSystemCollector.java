/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.sil.pcpatreditor.model.AtomicValueDisjunction;
import org.sil.pcpatreditor.model.Constraint;
import org.sil.pcpatreditor.model.ConstraintLeftHandSide;
import org.sil.pcpatreditor.model.ConstraintRightHandSide;
import org.sil.pcpatreditor.model.ConstraintWithLeftRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionUnificationConstraints;
import org.sil.pcpatreditor.model.FeaturePathOrStructure;
import org.sil.pcpatreditor.model.FeaturePathTemplateBody;
import org.sil.pcpatreditor.model.FeaturePathUnit;
import org.sil.pcpatreditor.model.FeatureStructure;
import org.sil.pcpatreditor.model.FeatureTemplate;
import org.sil.pcpatreditor.model.FeatureTemplateDisjunction;
import org.sil.pcpatreditor.model.FeatureTemplateValue;
import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.model.LogicalConstraint;
import org.sil.pcpatreditor.model.LogicalConstraintExpression;
import org.sil.pcpatreditor.model.LogicalConstraintFactor;
import org.sil.pcpatreditor.model.PatrRule;
import org.sil.pcpatreditor.model.PriorityUnionConstraint;
import org.sil.pcpatreditor.model.UnificationConstraint;
import org.sil.utility.StringUtilities;

/**
 * @author Andy Black
 *
 */
public class FeatureSystemCollector {

	SortedSet<String> collectionFeatures = new TreeSet<>(); // collection features unify with (or priority unionize with) a constituent
	SortedSet<String> featurePaths = new TreeSet<>();
	SortedSet<String> featureSystem = new TreeSet<>();
	List<FeaturePathTemplateBody> templateBodies = new ArrayList<>();
	List<UnificationConstraint> unificationConstraints = new ArrayList<>();
	List<PriorityUnionConstraint> priorityUnionConstraints = new ArrayList<>();
	List<LogicalConstraint> logicalConstraints = new ArrayList<>();
	List<PatrRule> rules = new ArrayList<>();
	String grammar = "";

	/**
	 * @param grammar
	 */
	public FeatureSystemCollector(String grammar) {
		super();
		this.grammar = grammar;
	}

	/**
	 * @return the Collection Features
	 */
	public SortedSet<String> getCollectionFeatures() {
		return collectionFeatures;
	}

	/**
	 * @param collectionFeatures the collection features to set
	 */
	public void setCollectionFeatures(SortedSet<String> collectionFeatures) {
		this.collectionFeatures = collectionFeatures;
	}

	/**
	 * @return the featurePaths
	 */
	public SortedSet<String> getFeaturePaths() {
		return featurePaths;
	}

	/**
	 * @param featurePaths the featurePaths to set
	 */
	public void setFeaturePaths(SortedSet<String> featurePaths) {
		this.featurePaths = featurePaths;
	}

	/**
	 * @return the grammar
	 */
	public String getGrammar() {
		return grammar;
	}

	/**
	 * @param grammar the grammar to set
	 */
	public void setGrammar(String grammar) {
		this.grammar = grammar;
	}

	/**
	 * @return the feature system
	 */
	public SortedSet<String> getFeatureSystem() {
		return featureSystem;
	}

	public List<String> getFeatureSystemAsList() {
		return featureSystem.stream().toList();
	}
	/**
	 * @param featureSystem the terminals to set
	 */
	public void setFeatureSystem(SortedSet<String> featureSystem) {
		this.featureSystem = featureSystem;
	}
	
	/**
	 * @return the unificationConstraints
	 */
	public List<UnificationConstraint> getUnificationConstraints() {
		return unificationConstraints;
	}

	/**
	 * @param unificationConstraints the unificationConstraints to set
	 */
	public void setUnificationConstraints(List<UnificationConstraint> unificationConstraints) {
		this.unificationConstraints = unificationConstraints;
	}

	/**
	 * @return the priorityUnionConstraints
	 */
	public List<PriorityUnionConstraint> getPriorityUnionConstraints() {
		return priorityUnionConstraints;
	}

	/**
	 * @param priorityUnionConstraints the priorityUnionConstraints to set
	 */
	public void setPriorityUnionConstraints(List<PriorityUnionConstraint> priorityUnionConstraints) {
		this.priorityUnionConstraints = priorityUnionConstraints;
	}

	/**
	 * @return the logicalConstraints
	 */
	public List<LogicalConstraint> getLogicalConstraints() {
		return logicalConstraints;
	}

	/**
	 * @param logicalConstraints the logicalConstraints to set
	 */
	public void setLogicalConstraints(List<LogicalConstraint> logicalConstraints) {
		this.logicalConstraints = logicalConstraints;
	}

	public void parseGrammar() {
		Grammar pcpatrGrammar = new Grammar();
		pcpatrGrammar = GrammarBuilder.parseAString(grammar, pcpatrGrammar);
		rules = pcpatrGrammar.getRules();
		collectTemplateBodies(pcpatrGrammar);
	}

	public void collectTemplateBodies(Grammar pcpatrGrammar) {
		List<FeaturePathTemplateBody> featureTemplateTemplateBodies = new ArrayList<>();
		featureTemplateTemplateBodies = pcpatrGrammar.getFeatureTemplates().stream().map(FeatureTemplate::getFeaturePathTemplateBody).toList();
		for (FeaturePathTemplateBody fptb : featureTemplateTemplateBodies) {
			templateBodies.add(fptb);
			collectEmbeddedFeaturePathTemplateBodies(fptb);
		}
	}

	public void collectEmbeddedFeaturePathTemplateBodies(FeaturePathTemplateBody fptb) {
		FeaturePathTemplateBody embeddedFtpb = fptb.getFeaturePathTemplateBody();
		if (embeddedFtpb != null) {
			templateBodies.add(embeddedFtpb);
			collectEmbeddedFeaturePathTemplateBodies(embeddedFtpb);
		}
	}

	public void collect() {
		collectConstraints();
		collectionFeatures.clear();
		for (UnificationConstraint uc : unificationConstraints) {
			ConstraintRightHandSide rhs = uc.getRightHandSide();
			if (rhs != null && rhs.getConstituent() != null && rhs.getFeaturePath() == null) {
				String[] items = uc.getLeftHandSide().getFeaturePath().pathRepresentation().split(" ");
				collectionFeatures.add(items[items.length-1]);
			}
		}
		for (PriorityUnionConstraint puc : priorityUnionConstraints) {
			ConstraintRightHandSide rhs = puc.getRightHandSide();
			if (rhs != null && rhs.getConstituent() != null && rhs.getFeaturePath() == null) {
				String[] items = puc.getLeftHandSide().getFeaturePath().pathRepresentation().split(" ");
				collectionFeatures.add(items[items.length-1]);
			}
		}
		featureSystem.clear();
		addTemplatesToFeatureSystem(templateBodies);
		addConstraintsToFeatureSystem(unificationConstraints);
		addConstraintsToFeatureSystem(priorityUnionConstraints);
		addLogicalConstraintsToFeatureSystem();
	}

	public void addLogicalConstraintsToFeatureSystem() {
		for (LogicalConstraint lc : logicalConstraints) {
			String path = "";
			ConstraintLeftHandSide lhs = lc.getLeftHandSide();
			if (lhs != null && lhs.getFeaturePath() != null) {
				path = lhs.getFeaturePath().pathRepresentation();
				addPathToFeatureSystem(path);
				path += " ";
			}
			List<FeatureStructure> featureStructures = new ArrayList<>();
			featureStructures = collectFeatureStructuresFromExpression(lc.getExpression(), featureStructures);
			for (FeatureStructure featureStructure : featureStructures) {
				List<String> paths = new ArrayList<>();
				paths = featureStructure.pathRepresentations(path, paths);
				for (String fsPath : paths) {
					addPathToFeatureSystem(fsPath);
				}
			}
		}
	}

	protected List<FeatureStructure> collectFeatureStructuresFromExpression(LogicalConstraintExpression lce, List<FeatureStructure> featureStructures) {
		if (lce != null) {
			featureStructures = collectFeatureStructuresFromFactor(lce.getFactor1(), featureStructures);
			featureStructures = collectFeatureStructuresFromFactor(lce.getFactor2(), featureStructures);
		}
		return featureStructures;
	}

	protected List<FeatureStructure> collectFeatureStructuresFromFactor(LogicalConstraintFactor factor, List<FeatureStructure> featureStructures) {
		if (factor != null) {
			if (factor.getFeatureStructure() != null) {
				featureStructures.add(factor.getFeatureStructure());
			} else {
				featureStructures = collectFeatureStructuresFromExpression(factor.getExpression(), featureStructures);
			}
		}
		return featureStructures;
	}

	protected void addTemplatesToFeatureSystem(List<FeaturePathTemplateBody> fptbs) {
		for (FeaturePathTemplateBody fptb : fptbs) {
			FeaturePathUnit fpu = fptb.getFeaturePathUnit();
			if (fpu != null) {
				FeatureTemplateValue ftv = fptb.getFeatureTemplateValue();
				if (ftv != null) {
					if (!StringUtilities.isNullOrEmpty(ftv.getAtomicValue())) {
						addPathToFeatureSystem(fpu.pathRepresentation() + " " + ftv.getNormalizedAtomicValue());
					} else {
						addFeatureTemplateDisjunctionToFeatureSystem(ftv.getFeatureTemplateDisjunction());
					}
				} else {
					AtomicValueDisjunction avd = fptb.getAtomicValueDisjunction();
					if (avd != null) {
						String fpuPath = fpu.pathRepresentation();
						for (String av : avd.getAtomicValues()) {
							addPathToFeatureSystem(fpuPath + " " + av);
						}
					}
				}
			}
			addFeatureTemplateDisjunctionToFeatureSystem(fptb.getFeatureTemplateDisjunction());
		}
	}

	public void addFeatureTemplateDisjunctionToFeatureSystem(FeatureTemplateDisjunction ftDisj) {
		if (ftDisj != null) {
			for (FeaturePathOrStructure fpos : ftDisj.getContents()) {
				if (fpos.getFeatureStructure() != null) {
					List<String> paths = new ArrayList<>();
					paths = fpos.getFeatureStructure().pathRepresentations("", paths);
					for (String path : paths) {
						addPathToFeatureSystem(path);
					}
				} else {
					addPathToFeatureSystem(fpos.pathRepresentation());
				}
			}
		}
	}

	public void addPathToFeatureSystem(String path) {
		if (!StringUtilities.isNullOrEmpty(path) && !collectionFeatures.contains(path)) {
			featureSystem.add(path);
		}
	}

	protected void addConstraintsToFeatureSystem(List<?extends ConstraintWithLeftRightHandSide> constraints) {
		for (ConstraintWithLeftRightHandSide uc : constraints) {
			ConstraintLeftHandSide lhs = uc.getLeftHandSide();
			if (lhs != null && lhs.getFeaturePath() != null) {
				addPathToFeatureSystem(lhs.getFeaturePath().pathRepresentation());
			}
			ConstraintRightHandSide rhs = uc.getRightHandSide();
			if (rhs != null && rhs.getFeaturePath() != null) {
				addPathToFeatureSystem(rhs.getFeaturePath().pathRepresentation());
			}
			if (!StringUtilities.isNullOrEmpty(rhs.getAtomicValue())) {
				addPathToFeatureSystem(lhs.getFeaturePath().pathRepresentation() + " " + rhs.getAtomicValue());
			}
		}
	}

	public void collectConstraints() {
		unificationConstraints.clear();
		priorityUnionConstraints.clear();
		logicalConstraints.clear();
		for (PatrRule rule : rules) {
			List<Constraint> constraints = rule.getConstraints();
			for (Constraint c : constraints) {
				if (c instanceof UnificationConstraint uc) {
					collectUnificationConstraints(uc, unificationConstraints);
				} else if (c instanceof PriorityUnionConstraint puc) {
					priorityUnionConstraints.add(puc);
					PriorityUnionConstraint puc1 = puc;
				} else if (c instanceof LogicalConstraint lc) {
					logicalConstraints.add(lc);
				}
			}
		}
	}

	protected void collectUnificationConstraints(UnificationConstraint uc, List<UnificationConstraint> unificationConstraints) {
		if (uc.getDisjunctiveUnificationConstraint() != null) {
			for (UnificationConstraint uc1 : uc.getDisjunctiveUnificationConstraint().getUnificationConstraints()) {
				collectUnificationConstraints(uc1, unificationConstraints);
			}
			for (DisjunctionUnificationConstraints duc : uc.getDisjunctiveUnificationConstraint().getDisjunctionUnificationConstraints()) {
				for (UnificationConstraint uc2 : duc.getUnificationConstraints()) {
					collectUnificationConstraints(uc2, unificationConstraints);
				}
			}
		} else {
			unificationConstraints.add(uc);
		}
	}
}
