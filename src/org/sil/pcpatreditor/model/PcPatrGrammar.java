/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.model.Paragraph;
import org.fxmisc.richtext.model.ReadOnlyStyledDocument;
import org.fxmisc.richtext.model.SegmentOps;
import org.fxmisc.richtext.model.StyleSpan;
import org.fxmisc.richtext.model.StyledSegment;
import org.fxmisc.richtext.model.TextOps;
import org.fxmisc.richtext.model.TextOpsBase;
import org.reactfx.collection.LiveList;
import org.reactfx.util.Either;
import org.sil.pcpatreditor.Constants;
import org.sil.utility.view.ControllerUtilities;

import javafx.collections.FXCollections;
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
    private LiveList<Paragraph<Collection<String>, String, Collection<String>>> myParagraphs;

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
        myParagraphs = this.getParagraphs();
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
//        System.out.println("BEFORE: bookmarks size=" + bookmarks.size() + "; par size=" + pBookmarks.size());
//        for (Integer iLine : bookmarks) {
//        	System.out.println("\tline=" + iLine);
//        }
//        for (Paragraph para : pBookmarks) {
//        	System.out.println("\tpara=" + para);
//        }
		if (bookmarks.contains(p)) {
			bookmarks.remove(p);
//			System.out.println("\tremoved " + p);
			if (pBookmarks.contains(par)) {
				pBookmarks.remove(par);
			}
			updateBookmarkIcons();
		} else {
			bookmarks.add(p);
			pBookmarks.add(par);
			updateBookmarkIcons();
		}
//        System.out.println("AFTER:  bookmarks size=" + bookmarks.size() + "; par size=" + pBookmarks.size());
//        for (Integer iLine : bookmarks) {
//        	System.out.println("\tline=" + iLine);
//        }
//        for (Paragraph para : pBookmarks) {
//        	System.out.println("\tpara=" + para);
//        }
        var paras = this.getParagraphs();
        System.out.println("paras size=" + paras.size());
        for (Paragraph par1 : paras) {
        	System.out.println("\tpar1=" + par1);
        }
        Collection<String> cs = new ArrayList<String>();
        cs.add("bookmark");
        StyledSegment ss = new StyledSegment<>("xyz", cs);
//        Paragraph newP = new Paragraph<StyledSegment, String, String>(ss, null, "", "");
        System.out.println("get styled segments: " + par.getStyledSegments().size() + "; " + par.getStyledSegments().getClass());
        if (par.getStyledSegments().size() == 1) {
        	TextOps<String, Collection<String>> styledTextOps = SegmentOps.styledTextOps();
        	System.out.println("styledTextOps=" + styledTextOps);
        	styledTextOps.joinSeg("a","b");
        	Paragraph newP = new Paragraph<Collection<String>, String, Collection<String>>(new ArrayList<String>(), styledTextOps, "1", cs);
        	System.out.println("newP=" + newP + "; class=" + newP.getStyledSegments().getClass());
        	
        	myParagraphs.remove(p);
        	myParagraphs.add(p, newP);
//        	par = par.concat(newP);
//        	newP = newP.concat(par);
//        	System.out.println("newP=" + newP);
//        	par.restyle(cs);
//        	par.getStyledSegments().add(ss);
        } else {
            par.getStyledSegments().add(0, ss);
        }
        System.out.println("par now=" + par);
        var spans = getStyleSpans(p);
        StyleSpan sspan = new StyleSpan<StyledSegment>(ss, 3);
        spans.prepend(sspan);
        
        bookmarks.clear();
        int iCount = 0;
		for (var para : getParagraphs()) {
			System.out.println("para=" + para);
			var y = para.getStyledSegments().get(0);
			System.out.println("\ty=" + y + "; size=" + y.getStyle());
			if (y.getStyle().toString().equals("[bookmark]")) {
				bookmarks.add(iCount);
			}
			iCount++;
//        	for (var x : para.getStyledSegments()) {
////        			pans().getStyleSpan(0).getStyle()) {
//        		System.out.println("\tx=" + x);
//        		if (x.getStyle().contains("bookmark")) {
//        			System.out.println("FOUND!");
//        		}
//        	}
//        	if (para.getStyleSpans().getStyleSpan(0).getStyle())
        }
		bookmarkFactory.setBookmarks(bookmarks);
		graphicFactory = line -> {
			HBox hbox = new HBox(bookmarkFactory.apply(line), numberFactory.apply(line));
			hbox.setAlignment(Pos.CENTER_LEFT);
			hbox.setStyle("-fx-background-color:#dcdcdc");
			return hbox;
		};
		setParagraphGraphicFactory(graphicFactory);
		System.out.println("AFTER:  bookmarks size=" + bookmarks.size() + "; par size=" + pBookmarks.size());
		for (Integer iLine : bookmarks) {
			System.out.println("\tline=" + iLine);
		}

	}

	public void updateBookmarkIcons() {
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

	public int nextBookmark() {
		return -1;
	}

	public int previoustBookmark() {
		return -1;
	}
}
