/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.IntFunction;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.Constants;
import org.sil.utility.view.ControllerUtilities;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

/**
 * @author Andy Black
 *
 */
public class PcPatrGrammar extends CodeArea {

	Image bookmarkImage;
	IntFunction<? extends Node> numberFactory;
	BookmarkFactory bookmarkFactory = null;
	IntFunction<Node> graphicFactory = null;
	HashSet<Integer> bookmarks = new HashSet<Integer>();
	List<Integer> toRemove = new ArrayList<Integer>();
	List<Integer> toAdd = new ArrayList<Integer>();

    /**
	 * @param imagePath
	 */
	public PcPatrGrammar() {
		super();
		bookmarkImage = ControllerUtilities.getIconImageFromURL(
				"file:resources/images/bookmark.png", Constants.RESOURCE_SOURCE_LOCATION);
//		alert.setGraphic(new ImageView(silLogo));
        numberFactory = null;
	}

	public void toggleBookmark() {
        int p = getCurrentParagraph();
        if (numberFactory == null) {
            numberFactory = this.getParagraphGraphicFactory();
        }
		if (bookmarkFactory == null) {
			bookmarkFactory = new BookmarkFactory();
		}
		bookmarkFactory.setBookmarks(bookmarks);
		if (bookmarks.contains(p)) {
			bookmarks.remove(p);
			updateBookmarkIcons();
		} else {
			bookmarks.add(p);
			updateBookmarkIcons();
		}
	}


	public void adjustBookmarkLineNumbers(int lineAdded, int lineRemoved) {
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
		updateBookmarkIcons();

	}

	public void createChangesLists(int lineChanged, List<Integer> toRemove, List<Integer> toAdd, int offset) {
		bookmarks.stream().filter(l -> l >= lineChanged).forEach(l -> {
			toRemove.add(l);
			toAdd.add((l+offset));
			});
	}

	public void updateBookmarkIcons() {
		if (bookmarkFactory != null) {
			bookmarkFactory.setBookmarks(bookmarks);
			if (bookmarks.size() == 0) {
				setParagraphGraphicFactory(numberFactory);
			} else {
				graphicFactory = line -> {
					HBox hbox = new HBox(bookmarkFactory.apply(line), numberFactory.apply(line));
					hbox.setAlignment(Pos.CENTER_LEFT);
					hbox.setStyle("-fx-background-color:#dcdcdc");
					return hbox;
				};
				setParagraphGraphicFactory(graphicFactory);
			}
		}
	}

	public int nextBookmark() {
		return -1;
	}

	public int previoustBookmark() {
		return -1;
	}
}
