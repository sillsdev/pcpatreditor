/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.sil.pcpatreditor.model.AtomicValueDisjunction;
import org.sil.pcpatreditor.model.BinaryOperation;
import org.sil.pcpatreditor.model.Constituent;
import org.sil.pcpatreditor.model.Constraint;
import org.sil.pcpatreditor.model.ConstraintLeftHandSide;
import org.sil.pcpatreditor.model.ConstraintRightHandSide;
import org.sil.pcpatreditor.model.DisjunctionConstituents;
import org.sil.pcpatreditor.model.DisjunctionUnificationConstraints;
import org.sil.pcpatreditor.model.DisjunctiveConstituents;
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
import org.sil.pcpatreditor.model.OptionalConstituents;
import org.sil.pcpatreditor.model.PhraseStructureRule;
import org.sil.pcpatreditor.model.PriorityUnionConstraint;
import org.sil.pcpatreditor.model.SequencedOrSingleConstituent;
import org.sil.pcpatreditor.model.UnificationConstraint;

/**
 * @author Andy Black
 *
 */
public abstract class BuildGrammarTestBase {

	protected AtomicValueDisjunction atomicValueDisjunction;
	protected BinaryOperation binop;
	protected Constituent constituent;
	protected ConstraintLeftHandSide constraintLhs;
	protected ConstraintRightHandSide constraintRhs;
	protected DisjunctionConstituents disjion;
	protected DisjunctionConstituents disjion2;
	protected DisjunctionUnificationConstraints disjunctionUnificationConstraints;
	protected DisjunctiveConstituents disjive;
	protected DisjunctiveConstituents disjive2;
	protected DisjunctiveUnificationConstraints disjunctiveUnificationConstraints;
	protected EmbeddedFeatureStructure embeddedFeatureStructure;
	protected FeaturePath featurePath;
	protected FeaturePathOrStructure featurePathOrStructure;
	protected FeaturePathTemplateBody embeddedFeaturePathTemplateBody;
	protected FeaturePathTemplateBody featurePathTemplateBody;
	protected FeaturePathUnit featurePathUnit;
	protected FeatureStructure featureStructure;
	protected FeatureStructure nestedFeatureStructure;
	protected FeatureStructureValue featureStructureValue;
	protected FeatureTemplate featureTemplate;
	protected FeatureTemplateDisjunction featureTemplateDisjunction;
	protected FeatureTemplateValue featureTemplateValue;
	protected List<Constraint> constraints = new ArrayList<>();
	protected List<SequencedOrSingleConstituent> rhs = new ArrayList<>();
	protected LogicalConstraint logicalConstraint;
	protected LogicalConstraintExpression lcExpression;
	protected LogicalConstraintFactor factor1;
	protected LogicalConstraintFactor factor2;
	protected OptionalConstituents optionalConstituents2;
	protected OptionalConstituents optionalConstituents3;
	protected OptionalConstituents optionalConstituents;
	protected PhraseStructureRule psr;
	protected PriorityUnionConstraint priorityUnionConstraint;
	protected UnificationConstraint unificationConstraint;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	protected void checkFeatureTemplate(String sTemplate, String sName) {
		Grammar grammar = new Grammar();
		grammar = GrammarBuilder.parseAString(sTemplate + "\nrule S = V\n", grammar);
		List<FeatureTemplate> featureTemplates = grammar.getFeatureTemplates();
		assertEquals(1, featureTemplates.size());
		featureTemplate = featureTemplates.get(0);
		assertEquals(sName, featureTemplate.getName());
	}

}
