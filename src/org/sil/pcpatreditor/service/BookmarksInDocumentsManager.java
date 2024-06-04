/**
 * Copyright (c) 2021-2024 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.backendprovider.XMLBookmarksBackEndProvider;
import org.sil.pcpatreditor.model.BookmarkDocument;
import org.sil.pcpatreditor.model.BookmarksInDocuments;

/**
 * @author Andy Black
 *
 *         Singleton pattern for managing the file containing bookmarks for previously used documents
 */

public class BookmarksInDocumentsManager {

	private static BookmarksInDocumentsManager instance;
	XMLBookmarksBackEndProvider xmlBookmarksBackEndProvider;
	private BookmarksInDocuments documents;
	private String pathToFile;
	private String operatingSystem;
	private File documentsFile;
	
	public static BookmarksInDocumentsManager getInstance(String operatingSystem) {
		if (instance == null) {
			instance = new BookmarksInDocumentsManager(operatingSystem);
		}
		return instance;
	}

	/**
	 * @param documents
	 * @param operatingSystem
	 */
	public BookmarksInDocumentsManager(String operatingSystem) {
		super();
		this.documents = new BookmarksInDocuments();
		this.operatingSystem = operatingSystem;
		determinePathToFile();
		initializeBackEndProvider();
	}

	private void determinePathToFile() {
		String directory = "";
		if (operatingSystem.toLowerCase().contains("windows")) {
			String programData = System.getenv("ProgramData");
			directory = programData + "\\SIL\\PcPatrEditor\\";
			File dir = new File(directory);
			if (!dir.exists()) {
				dir.mkdirs();
			}
		} else {
			String userhome= System.getProperty("user.home");
			directory = userhome + "/.pcpatreditor/";
		}
		pathToFile = directory + Constants.BOOKMARK_DOCUMENTS_FILE_NAME;
	}

	private void initializeBackEndProvider() {
		Locale locale = new Locale("en");
		xmlBookmarksBackEndProvider = new XMLBookmarksBackEndProvider(new BookmarksInDocuments(), locale);
	}
	
	/**
	 * @return the documents
	 */
	public BookmarksInDocuments getDocuments() {
		return documents;
	}

	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(BookmarksInDocuments documents) {
		this.documents = documents;
	}

	/**
	 * @return the pathToFile
	 */
	public String getPathToFile() {
		return pathToFile;
	}

	/**
	 * @param pathToFile the pathToFile to set
	 */
	public void setPathToFile(String pathToFile) {
		this.pathToFile = pathToFile;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void loadDocumentHistory() {
		documentsFile = new File(pathToFile);
		if (documentsFile.exists()) {
			xmlBookmarksBackEndProvider.loadBookmarkDataFromFile(documentsFile);
			documents = xmlBookmarksBackEndProvider.getBookmarks();
		} else {
			try {
				documentsFile.createNewFile();
			} catch (IOException e) {
				MainApp.reportException(e, null);
				e.printStackTrace();
			}
		}
	}

	public void saveDocumentHistory() {
		xmlBookmarksBackEndProvider.saveBookmarkDataToFile(documentsFile);
	}
	
	public BookmarkDocument findDocumentInHistory(String documentPath) {
		Optional<BookmarkDocument> opt = documents.getDocuments().stream().filter(bd -> bd.getPath().equals(documentPath)).findFirst();
		if (opt.isPresent()) {
			return opt.get();
		}
		return new BookmarkDocument();
	}
	
	public void updateDocument(BookmarkDocument doc) {
		int index = documents.getDocuments().indexOf(doc);
		if (index > -1) {
			documents.getDocuments().remove(index);
		}
		documents.getDocuments().add(doc);
	}
}
