/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sil.pcpatreditor.service.BuildGrammarTestBase;

/**
 * @author Andy Black
 *
 */
public class FeatureStructureTest extends BuildGrammarTestBase {

	String path = "";
	List<String> paths = new ArrayList<>();
	
	@Test
	public void pathRepresentationsTest() {
		checkFeatureTemplate("Let causative_syntax be { [head:[infl:[valence:[causative:+]]\r\n"
				+ "type:[causative_syntax:+]\r\n"
				+ "embedded:[cat:IP]]]\r\n"
				+ "[head:[type:[causative_syntax:+\r\n"
				+ "transitive:+]\r\n"
				+ "embedded:[cat:none]]\r\n"
				+ "base:stiff] }"
				, "causative_syntax");
		featurePathTemplateBody = featureTemplate.getFeaturePathTemplateBody();
		featureTemplateDisjunction = featurePathTemplateBody.getFeatureTemplateDisjunction();
		assertEquals(2, featureTemplateDisjunction.getContents().size());
		featurePathOrStructure = featureTemplateDisjunction.getContents().get(0);
		assertNotNull(featurePathOrStructure);
		featureStructure = featurePathOrStructure.getFeatureStructure();
		paths = featureStructure.pathRepresentations("", paths);
		assertEquals(3, paths.size());
		path = paths.get(0);
		assertEquals("head infl valence causative +", path);
		path = paths.get(1);
		assertEquals("head type causative_syntax +", path);
		path = paths.get(2);
		assertEquals("head embedded cat IP", path);
		featurePathOrStructure = featureTemplateDisjunction.getContents().get(1);
		assertNotNull(featurePathOrStructure);
		featureStructure = featurePathOrStructure.getFeatureStructure();
		paths.clear();
		paths = featureStructure.pathRepresentations("", paths);
		assertEquals(4, paths.size());
		path = paths.get(0);
		assertEquals("head type causative_syntax +", path);
		path = paths.get(1);
		assertEquals("head type transitive +", path);
		path = paths.get(2);
		assertEquals("head embedded cat none", path);
		path = paths.get(3);
		assertEquals("base stiff", path);
	}
}
