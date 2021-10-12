/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.HashSet;
import java.util.function.IntFunction;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.model.Paragraph;
import org.fxmisc.richtext.model.ReadOnlyStyledDocument;
import org.fxmisc.richtext.model.TextOps;
import org.reactfx.util.Either;
import org.sil.pcpatreditor.Constants;
import org.sil.utility.view.ControllerUtilities;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Andy Black
 *
 */
public class PcPatrGrammar extends CodeArea {

	Image bookmarkImage;
	IntFunction<? extends Node> numberFactory;
	BookmarkFactory bookmarkFactory = null;
	IntFunction<Node> graphicFactory = null;
    private HashSet<Integer> bookmarks = new HashSet<Integer>();
    private HashSet<Paragraph> pBookmarks = new HashSet<Paragraph>();

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
		int i = getCaretPosition();
		
        int p = getCurrentParagraph();
        var par = this.getParagraph(p);
//        System.out.println("par=" + par);
        if (numberFactory == null) {
            numberFactory = this.getParagraphGraphicFactory();
        }
		if (bookmarkFactory == null) {
			bookmarkFactory = new BookmarkFactory(currentParagraphProperty());
		}
		bookmarkFactory.setBookmarks(bookmarks);
        System.out.println("BEFORE: bookmarks size=" + bookmarks.size() + "; par size=" + pBookmarks.size());
        for (Integer iLine : bookmarks) {
        	System.out.println("\tline=" + iLine);
        }
        for (Paragraph para : pBookmarks) {
        	System.out.println("\tpara=" + para);
        }
		if (bookmarks.contains(p)) {
			bookmarks.remove(p);
			System.out.println("\tremoved " + p);
			if (pBookmarks.contains(par)) {
				pBookmarks.remove(par);
			}
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
		} else {
			bookmarks.add(p);
			pBookmarks.add(par);
			bookmarkFactory.setBookmarks(bookmarks);
			System.out.println("adding line " + p);
			graphicFactory = line -> {
				HBox hbox = new HBox(bookmarkFactory.apply(line), numberFactory.apply(line));
				hbox.setAlignment(Pos.CENTER_LEFT);
				hbox.setStyle("-fx-background-color:#dcdcdc");
				return hbox;
			};
			setParagraphGraphicFactory(graphicFactory);
		}
        System.out.println("AFTER:  bookmarks size=" + bookmarks.size() + "; par size=" + pBookmarks.size());
        for (Integer iLine : bookmarks) {
        	System.out.println("\tline=" + iLine);
        }
        for (Paragraph para : pBookmarks) {
        	System.out.println("\tpara=" + para);
        }
//        var p2 = new Paragraph(bookmarkImage, par. getSegOps(), new ArrayList<>());
//        Collection<String> ps = getParagraph(p).getParagraphStyle();
//        System.out.println("ps size=" + ps.size());
//        for (String s : ps) {
//        	System.out.println("\ts=" + s);
//        }
//        var factory = this.getParagraphGraphicFactory();
//        System.out.println("factory=" + factory);
//		if (factory.equals(numberFactory)) {
//			bookmarks.add(p);
//			System.out.println("adding line " + p);
//			setParagraphGraphicFactory(graphicFactory);
//		} else {
//			System.out.println("checking on " + p);
//			if (bookmarks.contains(p)) {
//				bookmarks.remove(p);
//				System.out.println("\tremoved " + p);
//			}
//			setParagraphGraphicFactory(numberFactory);
//		}
        
//        if (par.)
        
//        replaceText("The green arrow will only be on the line where the caret appears.\n\nTry it.");

        
//        int col = getCaretColumn();
////        TextStyle style = (TextStyle) getStyleAtPosition(p, col);
//        System.out.println("tb: p=" + p + "; col=" + col);
//        int startPar = offsetToPosition(p, TwoDimensional.Bias.Forward).getMajor();
//        int endPar = offsetToPosition(p, TwoDimensional.Bias.Backward).getMajor();
//        System.out.println("\tstaart=" + startPar + "; end=" + endPar);
//        List<Paragraph<ParStyle, Either<String, LinkedImage>, TextStyle>> pars = getParagraphs().subList(startPar, endPar + 1);

		
//		TextOps<String, Collection<String>> textOps = this.getSegOps();
//		textOps.getClass();
		
//		ReadOnlyStyledDocument<ParStyle, Either<String, LinkedImage>, TextStyle> ros =
//                ReadOnlyStyledDocument.fromSegment(Either.right(new RealLinkedImage("file:resources/images/bookmark.png")),
//                                                   ParStyle.EMPTY, TextStyle.EMPTY, getSegOps());
//        replaceSelection(ros);
    
		
	}

	public int nextBookmark() {
		return -1;
	}

	public int previoustBookmark() {
		return -1;
	}
}
