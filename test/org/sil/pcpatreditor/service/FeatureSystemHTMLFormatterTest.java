/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andy Black
 *
 */
public class FeatureSystemHTMLFormatterTest {

	FeatureSystemHTMLFormatter formatter;
	List<String> featureSystem = new ArrayList<>();
	String title = "Feature System";
	String html = "";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		formatter = new FeatureSystemHTMLFormatter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void featureSystemHTMLFormatterTest() {
		// empty feature system
		featureSystem.clear();
		formatter.setDateTime("testing date and time");
		formatter.setReportPerformedOn("Performed on ");
		formatter.setTitle(title);
		formatter.setGrammarFile("nothing in feature system");
		html = formatter.format(featureSystem);
		assertEquals(
				"<html>\n" + "<head>\n" + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n"
						+ "<title>Feature System</title>\n" + "</head>\n" + "<body>\n"
						+ "<h2>Feature System</h2>\n"
						+ "<div>nothing in feature system</div>\n"
						+ "<p>Performed on testing date and time</p>\n"
						+ "<table border=\"1\">\n" + "</table>\n" + "</body>\n" + "</html>\n" + "",
				html);
		// full feature system
		try {
			File fileInput = new File("test/org/sil/pcpatreditor/testdata/FeatureSystemInputStringList.txt");
			featureSystem = Files.readAllLines(fileInput.toPath());
			formatter.setGrammarFile("test file 1");
			html = formatter.format(featureSystem);
			File file = new File("test/org/sil/pcpatreditor/testdata/FeatureSystemHTMLResult.html");
			Stream<String> contents = Files.lines(file.toPath());
			String scontents = contents.collect(Collectors.joining("\n"));
			contents.close();
			assertEquals(scontents, html);

			fileInput = new File("test/org/sil/pcpatreditor/testdata/FeatureSystemInputStringList2.txt");
			featureSystem.clear();
			featureSystem = Files.readAllLines(fileInput.toPath());
			formatter.setGrammarFile("test file 2");
			html = formatter.format(featureSystem);
			file = new File("test/org/sil/pcpatreditor/testdata/FeatureSystemHTMLResult2.html");
			contents = Files.lines(file.toPath());
			scontents = contents.collect(Collectors.joining("\n"));
			contents.close();
			assertEquals(scontents, html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
