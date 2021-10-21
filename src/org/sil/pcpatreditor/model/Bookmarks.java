/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Andy Black
 *
 */
@XmlRootElement(name = "bookmarks")
public class Bookmarks {

	private List<BookmarkDocument> documents = new ArrayList<BookmarkDocument>();

	public Bookmarks() {

	}

	/**
	 * @param documents
	 */
	public Bookmarks(List<BookmarkDocument> documents) {
		super();
		this.documents = documents;
	}

	/**
	 * @return the documents
	 */
	@XmlElementWrapper(name = "documents")
	@XmlElement(name = "document")
	public List<BookmarkDocument> getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<BookmarkDocument> documents) {
		this.documents = documents;
	}

	public void clear() {
		documents.clear();
	}

	public void load(Bookmarks bookmarks) {
		this.documents = bookmarks.getDocuments();
	}

}
