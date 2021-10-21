/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.backendprovider;

import java.io.File;

/**
 * @author Andy Black
 *
 */
public abstract class BookmarksBackEndProvider {

    /**
     * Loads bookmark data from the backend storage. The current bookmark data will
     * be replaced.
     * 
     * @param file
     */
    public abstract void loadBookmarkDataFromFile(File file);

    /**
     * Saves the current bookmark data to the backend storage.
     * 
     * @param file
     */
    public abstract void saveBookmarkDataToFile(File file);
}

