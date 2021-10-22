/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.backendprovider;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.model.BookmarksInDocuments;
import org.sil.utility.HandleExceptionMessage;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * @author Andy Black
 *
 */
public class XMLBookmarksBackEndProvider extends BookmarksBackEndProvider {
	BookmarksInDocuments bookmarks;
	String sFileError;
	String sFileErrorLoadHeader;
	String sFileErrorLoadContent;
	String sFileErrorSaveHeader;
	String sFileErrorSaveContent;

	/**
	 * @param bookmarks
	 */
	public XMLBookmarksBackEndProvider(BookmarksInDocuments bookmarks, Locale locale) {
		this.bookmarks = bookmarks;
		setResourceStrings(locale);
	}

	private void setResourceStrings(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(Constants.RESOURCE_LOCATION, locale);
		sFileError = bundle.getString("file.error");
		sFileErrorLoadHeader = bundle.getString("file.error.load.header");
		sFileErrorLoadContent = bundle.getString("file.error.load.content");
		sFileErrorSaveHeader = bundle.getString("file.error.save.header");
		sFileErrorSaveContent = bundle.getString("file.error.save.content");
	}

	public BookmarksInDocuments getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(BookmarksInDocuments bookmarks) {
		this.bookmarks = bookmarks;
	}

	final boolean useXMLClasses = false;

	/**
	 * Loads tree data from the specified file. The current tree data
	 * will be replaced.
	 * 
	 * @param file
	 */
	@Override
	public void loadBookmarkDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(BookmarksInDocuments.class);
			Unmarshaller um = context.createUnmarshaller();
			// Reading XML from the file and unmarshalling.
			bookmarks = (BookmarksInDocuments) um.unmarshal(file);
//			bookmarks.clear();
			bookmarks.load(bookmarks);
		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();
			HandleExceptionMessage.show(sFileError, sFileErrorLoadHeader, sFileErrorLoadContent
					+ file.getPath(), true);
		}
	}

	/**
	 * Saves the current tree data to the specified file.
	 * 
	 * @param file
	 */
	@Override
	public void saveBookmarkDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(BookmarksInDocuments.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			// Marshalling and saving XML to the file.
			m.marshal(bookmarks, file);
		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();
			HandleExceptionMessage.show(sFileError, sFileErrorSaveHeader, sFileErrorSaveContent
					+ file.getPath(), true);
		}
	}

}
