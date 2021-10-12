/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.reactfx.value.Val;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author Andy Black
 *
 * Given the line number, return a node (graphic) to display to the left of a line.
 * (Taken from ArrowFactory.java in the org.fxmisc.richtext.demo.lineindicator package.)
 * 
 */

public class BookmarkFactory implements IntFunction<Node> {
    private final ObservableValue<Integer> shownLine;
    private HashSet<Integer> bookmarks = new HashSet<Integer>();

    BookmarkFactory(ObservableValue<Integer> shownLine) {
        this.shownLine = shownLine;
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
		Polygon triangle = new Polygon(0.0, 0.0, 10.0, 5.0, 0.0, 10.0);
		triangle.setFill(Color.GREEN);

//        ObservableValue<Boolean> visible = Val.map(shownLine, sl -> sl == lineNumber);
//        triangle.visibleProperty().bind(
//                Val.flatMap(triangle.sceneProperty(), scene -> {
//                    return scene != null ? visible : Val.constant(false);
//            }));

		triangle.visibleProperty().bind(Val.flatMap(triangle.sceneProperty(), scene -> {
			if (scene != null) {
				if (bookmarks.contains(lineNumber)) {
					System.out.println("line " + lineNumber + " returns true");
					return Val.constant(true);
				}
			}
			System.out.println("line " + lineNumber + " returns false");
			return Val.constant(false);
		}));

		return triangle;
	}
}