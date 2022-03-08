/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

/**
 * @author Andy Black
 *
 * Singleton pattern for finding what is before the current point in a feature path
 */
public class FeaturePathPreviousContentFinder {
	
	private static FeaturePathPreviousContentFinder instance;
	boolean skipConstituent = false;
	final String openingWedge = "<";
	final String closingWedge = ">";

	public static FeaturePathPreviousContentFinder getInstance() {
		if (instance == null) {
			instance = new FeaturePathPreviousContentFinder();
		}
		return instance;
	}

	/**
	 * @return the skipConstituent
	 */
	public boolean isSkipConstituent() {
		return skipConstituent;
	}

	/**
	 * @param skipConstituent the skipConstituent to set
	 */
	public void setSkipConstituent(boolean skipConstituent) {
		this.skipConstituent = skipConstituent;
	}

	public String findPreviousPath(String content) {
		String foundContent = "";
		int iOpeningWedge = content.indexOf(openingWedge);
		int iClosingWedge = content.indexOf(closingWedge);
		if (iClosingWedge > -1) {
			iOpeningWedge = iClosingWedge + content.substring(iClosingWedge).indexOf(openingWedge);
		}
		if (iOpeningWedge > -1) {
			if (++iOpeningWedge < content.length()) {
				if (skipConstituent) {
					if (content.substring(iOpeningWedge).indexOf(" ") > -1) {
						int iStart = Math.max(iOpeningWedge,
								content.substring(iOpeningWedge).indexOf(" ") + iOpeningWedge);
						foundContent = content.substring(iStart);
					}
				} else {
					foundContent = content.substring(iOpeningWedge);
				}
			}
		}
		return foundContent.stripLeading();
	}
}
