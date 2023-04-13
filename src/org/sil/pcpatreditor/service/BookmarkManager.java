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

	CodeArea grammar;
	Image bookmarkImage;
	IntFunction<? extends Node> numberFactory;
	BookmarkFactory bookmarkFactory = null;
	IntFunction<Node> graphicFactory = null;
	HashSet<Integer> bookmarks = new HashSet<Integer>();
	List<Integer> toRemove = new ArrayList<Integer>();
	List<Integer> toAdd = new ArrayList<Integer>();

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
//		numberFactory = this.grammar.getParagraphGraphicFactory();
	}

	/**
	 * @return the bookmarks
	 */
	public HashSet<Integer> getBookmarks() {
		return bookmarks;
	}

	public void clearBookmarks() {
		bookmarks.clear();
		updateBookmarkIcons();
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

	public void setLine(int line) {
		if (bookmarkFactory == null) {
			bookmarkFactory = new BookmarkFactory();
		}
		bookmarkFactory.setBookmarks(bookmarks);
		if (!bookmarks.contains(line)) {
			bookmarks.add(line);
		}
	}

	public void adjustBookmarkLinesAfterAddition(int lineAdded, int numberAdded) {
		toRemove.clear();
		toAdd.clear();
		if (lineAdded > -1) {
			createChangesLists(lineAdded, toRemove, toAdd, numberAdded);
		}
		for (Integer i : toRemove) {
			bookmarks.remove(i);
		}
		for (Integer i : toAdd) {
			bookmarks.add(i);
		}
	}

	public void adjustBookmarkLinesAfterRemoval(int lineRemoved, int numberRemoved) {
		toRemove.clear();
		toAdd.clear();
		if (lineRemoved > -1) {
			createChangesLists(lineRemoved, toRemove, toAdd, -numberRemoved);
		}
		for (Integer i : toRemove) {
			bookmarks.remove(i);
		}
		for (Integer i : toAdd) {
			bookmarks.add(i);
		}
	}

	public void createChangesLists(int lineChanged, List<Integer> toRemove, List<Integer> toAdd, int offset) {
		bookmarks.stream().filter(l -> l >= lineChanged).forEach(l -> {
			toRemove.add(l);
			if (offset < 0) {
				// only add it back if it was not removed
				if (offset < 0 && l >= (lineChanged - offset)) {
					toAdd.add(l + offset);
				}
			} else {
				toAdd.add(l + offset);
			}
		});
	}

	public void updateBookmarkIcons() {
		if (numberFactory == null && grammar != null) {
            numberFactory = grammar.getParagraphGraphicFactory();
        }
		if (bookmarkFactory != null && numberFactory != null) {
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

	public int previousBookmark() {
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
