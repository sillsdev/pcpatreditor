/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import org.reactfx.value.Val;
import org.sil.pcpatreditor.Constants;
import org.sil.utility.view.ControllerUtilities;

import java.util.HashSet;
import java.util.function.IntFunction;

/**
 * @author Andy Black
 *
 *         Given the line number, return a node (graphic) to display to the left
 *         of a line. (Taken from ArrowFactory.java in the
 *         org.fxmisc.richtext.demo.lineindicator package.)
 * 
 */

public class BookmarkFactory implements IntFunction<Node> {
	Image bookmarkImage;
	private HashSet<Integer> bookmarks = new HashSet<Integer>();

	public BookmarkFactory() {
		bookmarkImage = ControllerUtilities.getIconImageFromURL("file:resources/images/bookmark.png",
				Constants.RESOURCE_SOURCE_LOCATION);
	}

	/**
	 * @return the bookmarks
	 */
	public HashSet<Integer> getBookmarks() {
		return bookmarks;
	}

	/**
	 * @param bookmarks the bookmarks to set
	 */
	public void setBookmarks(HashSet<Integer> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public Node apply(int lineNumber) {
		ImageView imageView = new ImageView(bookmarkImage);
		imageView.setFitWidth(10);
		imageView.setPreserveRatio(true);
		imageView.setSmooth(true);
		imageView.setCache(true);
		imageView.visibleProperty().bind(Val.flatMap(imageView.sceneProperty(), scene -> {
			if (scene != null) {
				if (bookmarks.contains(lineNumber)) {
					return Val.constant(true);
				}
			}
			return Val.constant(false);
		}));
		return imageView;
	}
}
