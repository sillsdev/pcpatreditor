/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sil.pcpatreditor.Constants;
import org.sil.utility.view.JavaFXThreadingRule;

/**
 * @author Andy Black
 *
 */
public class BookmarkManagerTest {
	@Rule
	public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	String content;
	BookmarkManager manager;
	HashSet<Integer> bookmarks;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		File file = new File(Constants.UNIT_TEST_DATA_FILE);
		try {
			content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		manager = new BookmarkManager();
		manager.getBookmarks().clear();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void toggleTest() {
		bookmarks = manager.getBookmarks();
		assertEquals(0, bookmarks.size());

		addBookmarks();

		// toggle a line previously toggled
		manager.toggleLine(15);
		assertEquals(2, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(150));

		manager.toggleLine(150);
		assertEquals(1, bookmarks.size());
		assertTrue(bookmarks.contains(100));

		manager.toggleLine(100);
		assertEquals(0, bookmarks.size());
	}

	@Test
	public void addRemoveTest() {
		bookmarks = manager.getBookmarks();
		assertEquals(0, bookmarks.size());

		addBookmarks();

		// insert a line at various locations
		manager.adjustBookmarkLinesAfterAddition(200, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(150));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterAddition(20, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(101));
		assertTrue(bookmarks.contains(151));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterAddition(2, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(102));
		assertTrue(bookmarks.contains(152));
		assertTrue(bookmarks.contains(16));

		manager.adjustBookmarkLinesAfterAddition(124, 5);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(102));
		assertTrue(bookmarks.contains(157));
		assertTrue(bookmarks.contains(16));

		// delete a line at various locations
		manager.adjustBookmarkLinesAfterRemoval(177, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(102));
		assertTrue(bookmarks.contains(157));
		assertTrue(bookmarks.contains(16));

		manager.adjustBookmarkLinesAfterRemoval(3, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(101));
		assertTrue(bookmarks.contains(156));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterRemoval(73, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(155));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterRemoval(136, 1);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(154));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterRemoval(95, 4);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(96));
		assertTrue(bookmarks.contains(150));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterAddition(95, 4);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(154));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterRemoval(99, 4);
		assertEquals(2, bookmarks.size());
		assertTrue(bookmarks.contains(150));
		assertTrue(bookmarks.contains(15));

		manager.adjustBookmarkLinesAfterRemoval(15, 4);
		assertEquals(1, bookmarks.size());
		assertTrue(bookmarks.contains(146));

		manager.adjustBookmarkLinesAfterRemoval(141, 4);
		assertEquals(1, bookmarks.size());
		assertTrue(bookmarks.contains(142));

		manager.adjustBookmarkLinesAfterRemoval(139, 4);
		assertEquals(0, bookmarks.size());
	}

	public void addBookmarks() {
		manager.toggleLine(100);
		bookmarks = manager.getBookmarks();
		assertEquals(1, bookmarks.size());
		assertTrue(bookmarks.contains(100));

		manager.toggleLine(150);
		assertEquals(2, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(150));

		manager.toggleLine(15);
		assertEquals(3, bookmarks.size());
		assertTrue(bookmarks.contains(100));
		assertTrue(bookmarks.contains(150));
		assertTrue(bookmarks.contains(15));
	}

	@Test
	public void nextTest() {
		bookmarks = manager.getBookmarks();
		assertEquals(0, bookmarks.size());
		assertEquals(-1, manager.nextBookmarkFromLine(0));

		addBookmarks();

		// look for next bookmark
		assertEquals(15, manager.nextBookmarkFromLine(0));
		assertEquals(100, manager.nextBookmarkFromLine(70));
		assertEquals(150, manager.nextBookmarkFromLine(117));
		assertEquals(-1, manager.nextBookmarkFromLine(702));
	}

	@Test
	public void previousTest() {
		bookmarks = manager.getBookmarks();
		assertEquals(0, bookmarks.size());
		assertEquals(-1, manager.previousBookmarkFromLine(0));

		addBookmarks();

		// look for next bookmark
		assertEquals(150, manager.previousBookmarkFromLine(702));
		assertEquals(100, manager.previousBookmarkFromLine(130));
		assertEquals(15, manager.previousBookmarkFromLine(100));
		assertEquals(-1, manager.previousBookmarkFromLine(7));
	}
}
