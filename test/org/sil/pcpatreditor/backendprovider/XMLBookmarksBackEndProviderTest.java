/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.backendprovider;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.model.BookmarkDocument;
import org.sil.pcpatreditor.model.Bookmarks;
import org.sil.utility.view.JavaFXThreadingRule;

/**
 * @author Andy Black
 *
 */
public class XMLBookmarksBackEndProviderTest {

	XMLBookmarksBackEndProvider xmlBookmarksBackEndProvider;
	Bookmarks bookmarks;

	@Rule
	public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bookmarks = new Bookmarks();
		Locale locale = new Locale("en");
		xmlBookmarksBackEndProvider = new XMLBookmarksBackEndProvider(bookmarks, locale);
		File file = new File(Constants.UNIT_TEST_BOOKMARKS_DATA_FILE);
		xmlBookmarksBackEndProvider.loadBookmarkDataFromFile(file);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void loadBookmarkDataFromFileTest() {
		checkLoadedData();
	}

	public void checkLoadedData() {
		bookmarks = xmlBookmarksBackEndProvider.getBookmarks();
		assertNotNull(bookmarks);
		assertEquals(2, bookmarks.getDocuments().size());
		BookmarkDocument doc = bookmarks.getDocuments().get(0);
		assertEquals("/user/document/myGrammar.grm", doc.getPath());
		List<Integer> lines = doc.getLines();
		assertEquals(2, lines.size());
		Integer line = lines.get(0);
		assertEquals(100, line.intValue());
		line = lines.get(1);
		assertEquals(200, line.intValue());
		doc = bookmarks.getDocuments().get(1);
		assertEquals("/user/document/KimsGrammar.grm", doc.getPath());
		lines = doc.getLines();
		assertEquals(3, lines.size());
		line = lines.get(0);
		assertEquals(1020, line.intValue());
		line = lines.get(1);
		assertEquals(4150, line.intValue());
		line = lines.get(2);
		assertEquals(6799, line.intValue());
	}

	@Test
	public void saveLanguageDataToFileTest() {
		File tempSaveFile = null;
		try {
			tempSaveFile = File.createTempFile("PcPtrEditorBookmarksTestSave", ".xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tempSaveFile != null) {
			tempSaveFile.deleteOnExit();
		}
		
		xmlBookmarksBackEndProvider.saveBookmarkDataToFile(tempSaveFile);
		xmlBookmarksBackEndProvider.loadBookmarkDataFromFile(tempSaveFile);
		checkLoadedData();
	}

}
