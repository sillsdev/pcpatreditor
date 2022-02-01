/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor;

/**
 * @author Andy Black
 *
 */
public class Constants {
	public static final String VERSION_NUMBER = "0.7.1 Alpha";

	public static final String RESOURCE_LOCATION = "org.sil.pcpatreditor.resources.PcPatrEditor";
	public static final String RESOURCE_SOURCE_LOCATION = "src/org/sil/pcpatreditor/";
	public static final String PCPATR_EDITOR_DATA_FILE_EXTENSION = "grm";
	public static final String PCPATR_EDITOR_DATA_FILE_EXTENSIONS = "*."
			+ PCPATR_EDITOR_DATA_FILE_EXTENSION;
	public static final String DEFAULT_DIRECTORY_NAME = "My PCPatrEditor";
	public static final String BOOKMARK_DOCUMENTS_FILE_NAME = "bookmarks.xml";
	public static final String COMMENT_CHARACTER = "|";
	public static final String PSR_SEPARATOR = " ";

	// Unit Testing constants
	public static final String UNIT_TEST_DATA_FILE_NAME = "test/org/sil/pcpatreditor/testdata/TestData.";
	public static final String UNIT_TEST_DATA_FILE = "test/org/sil/pcpatreditor/testdata/LargeGrammar.grm";
	public static final String UNIT_TEST_DATA_FILE_EXTRAS = "test/org/sil/pcpatreditor/testdata/LargeGrammarExtras.grm";
	public static final String UNIT_TEST_BOOKMARKS_DATA_FILE = "test/org/sil/pcpatreditor/testdata/Bookmarks1.xml";
	public static final String UNIT_TEST_LARGE_GRAMMAR_EXTRAS_RECOGNIZER_EXPECTED_RESULTS_FILE = "test/org/sil/pcpatreditor/testdata/LargeGrammarRecognizerExpectedResults.txt";

}
