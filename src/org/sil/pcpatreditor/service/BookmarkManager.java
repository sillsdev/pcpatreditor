/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.model.BookmarkFactory;
import org.sil.utility.view.ControllerUtilities;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/**
 * @author Andy Black
 *
 *         Singleton pattern for managing bookmarks
 */
public class BookmarkManager {

	private static BookmarkManager instance;
	CodeArea grammar;
	Image bookmarkImage;
	IntFunction<? extends Node> numberFactory;
	BookmarkFactory bookmarkFactory = null;
	IntFunction<Node> graphicFactory = null;
	HashSet<Integer> bookmarks = new HashSet<Integer>();
	List<Integer> toRemove = new ArrayList<Integer>();
	List<Integer> toAdd = new ArrayList<Integer>();

	public static BookmarkManager getInstance() {
		if (instance == null) {
			instance = new BookmarkManager();
		}
		return instance;
	}

	public BookmarkManager() {
		super();
		bookmarkImage = ControllerUtilities.getIconImageFromURL(
				"file:resources/images/bookmark.png", Constants.RESOURCE_SOURCE_LOCATION);
        numberFactory = null;
	}

	/**
	 * @return the grammar
	 */
	public CodeArea getGrammar() {
		return grammar;
	}

	/**
	 * @param grammar the grammar to set
	 */
	public void setGrammar(CodeArea grammar) {
		this.grammar = grammar;
	}

	/**
	 * @return the bookmarks
	 */
	public HashSet<Integer> getBookmarks() {
		return bookmarks;
	}

	public void toggleBookmark() {
		if (numberFactory == null) {
            numberFactory = grammar.getParagraphGraphicFactory();
        }
        int line = grammar.getCurrentParagraph();
        toggleLine(line);
		updateBookmarkIcons();
	}

	public void toggleLine(int line) {
		if (bookmarkFactory == null) {
			bookmarkFactory = new BookmarkFactory();
		}
		bookmarkFactory.setBookmarks(bookmarks);
		if (bookmarks.contains(line)) {
			bookmarks.remove(line);
		} else {
			bookmarks.add(line);
		}
	}


	public void adjustBookmarkLineNumbers(int lineAdded, int lineRemoved) {
		System.out.println("\tadjust added =" + lineAdded + "; removed =" + lineRemoved);
		adjustBookmarkLines(lineAdded, lineRemoved);
		updateBookmarkIcons();
	}

	public void adjustBookmarkLines(int lineAdded, int lineRemoved) {
		toRemove.clear();
		toAdd.clear();
		if (lineAdded > -1) {
			createChangesLists(lineAdded, toRemove, toAdd, 1);
		}
		if (lineRemoved > -1) {
			createChangesLists(lineRemoved, toRemove, toAdd, -1);
		}
		for (Integer i : toRemove) {
			bookmarks.remove(i);
		}
		for (Integer i : toAdd) {
			bookmarks.add(i);
		}
	}

	public void createChangesLists(int lineChanged, List<Integer> toRemove, List<Integer> toAdd, int offset) {
		System.out.println("\t\tchange lists: lineChanged =" + lineChanged + "; offset=" + offset);
		bookmarks.stream().filter(l -> l >= lineChanged).forEach(l -> {
			toRemove.add(l);
			toAdd.add((l+offset));
			});
	}

	public void updateBookmarkIcons() {
		if (bookmarkFactory != null) {
			bookmarkFactory.setBookmarks(bookmarks);
			if (bookmarks.size() == 0) {
				grammar.setParagraphGraphicFactory(numberFactory);
			} else {
				graphicFactory = line -> {
					HBox hbox = new HBox(bookmarkFactory.apply(line), numberFactory.apply(line));
					hbox.setAlignment(Pos.CENTER_LEFT);
					hbox.setStyle("-fx-background-color:#dcdcdc");
					return hbox;
				};
				grammar.setParagraphGraphicFactory(graphicFactory);
			}
		}
	}

	public int nextBookmark() {
		int line = grammar.getCurrentParagraph();
		return nextBookmarkFromLine(line);
	}

	public int nextBookmarkFromLine(int line) {
		Optional<Integer> next = bookmarks.stream().sorted().filter(l -> l > line).findFirst();
		if (next.isPresent()) {
			return next.get();
		}
		return -1;
	}

	public int previoustBookmark() {
		int line = grammar.getCurrentParagraph();
		return previousBookmarkFromLine(line);
	}

	public int previousBookmarkFromLine(int line) {
		Optional<Integer> next = bookmarks.stream().sorted(Comparator.reverseOrder()).filter(l -> l < line).findFirst();
		if (next.isPresent()) {
			return next.get();
		}
		return -1;
	}

}
