/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.Locale;

import org.fxmisc.richtext.CodeArea;

/**
 * @author Andy Black
 *
 *         Singleton pattern for handling Find/Replace operations
 */
public class FindReplaceOperator {

	private static FindReplaceOperator instance;
	private String content;
	private boolean directionForward = true;
	private boolean scopeAll = true;
	private boolean caseSensitive = false;
	private boolean wholeWord = false;
	private boolean regularExpression = false;
	private boolean wrapSearch = true;
	private boolean incrementalSearch = false;
	private String find;
	private String replace;
	private Locale locale;
	
	/**
	 * @return the instance
	 */
	public static FindReplaceOperator getInstance() {
		if (instance == null) {
			instance = new FindReplaceOperator();
		}
		return instance;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the directionForward
	 */
	public boolean isDirectionForward() {
		return directionForward;
	}

	/**
	 * @param directionForward the directionForward to set
	 */
	public void setDirectionForward(boolean directionForward) {
		this.directionForward = directionForward;
	}

	/**
	 * @return the scopeAll
	 */
	public boolean isScopeAll() {
		return scopeAll;
	}

	/**
	 * @param scopeAll the scopeAll to set
	 */
	public void setScopeAll(boolean scopeAll) {
		this.scopeAll = scopeAll;
	}

	/**
	 * @return the caseSensitive
	 */
	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	/**
	 * @param caseSensitive the caseSensitive to set
	 */
	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	/**
	 * @return the wholeWord
	 */
	public boolean isWholeWord() {
		return wholeWord;
	}

	/**
	 * @param wholeWord the wholeWord to set
	 */
	public void setWholeWord(boolean wholeWord) {
		this.wholeWord = wholeWord;
	}

	/**
	 * @return the regularExpression
	 */
	public boolean isRegularExpression() {
		return regularExpression;
	}

	/**
	 * @param regularExpression the regularExpression to set
	 */
	public void setRegularExpression(boolean regularExpression) {
		this.regularExpression = regularExpression;
	}

	/**
	 * @return the wrapSearch
	 */
	public boolean isWrapSearch() {
		return wrapSearch;
	}

	/**
	 * @param wrapSearch the wrapSearch to set
	 */
	public void setWrapSearch(boolean wrapSearch) {
		this.wrapSearch = wrapSearch;
	}

	/**
	 * @return the incrementalSearch
	 */
	public boolean isIncrementalSearch() {
		return incrementalSearch;
	}

	/**
	 * @param incrementalSearch the incrementalSearch to set
	 */
	public void setIncrementalSearch(boolean incrementalSearch) {
		this.incrementalSearch = incrementalSearch;
	}

	/**
	 * @return the find
	 */
	public String getFind() {
		return find;
	}

	/**
	 * @param find the find to set
	 */
	public void setFind(String find) {
		this.find = find;
	}

	/**
	 * @return the replace
	 */
	public String getReplace() {
		return replace;
	}

	/**
	 * @param replace the replace to set
	 */
	public void setReplace(String replace) {
		this.replace = replace;
	}
	
	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void initializeParameters(boolean directionForward, boolean scopeAll, boolean caseSensitive,
			boolean wholeWord, boolean regularExpression, boolean wrapSearch, boolean incrementalSearch) {
		this.directionForward = directionForward;
		this.scopeAll = scopeAll;
		this.caseSensitive = caseSensitive;
		this.wholeWord = wholeWord;
		this.regularExpression = regularExpression;
		this.wrapSearch = wrapSearch;
		this.incrementalSearch = incrementalSearch;
	}

	public int find(String findMe) {
		int index = -1;
		if (caseSensitive) {
			index = getIndexOf(content, findMe);
		} else {
			if (locale == null) {
				locale = new Locale("en");
			}
			index = getIndexOf(content.toLowerCase(locale), findMe.toLowerCase(locale));
		}
		if (index >= 0 && wholeWord) {
			int begin = Math.max(index - 1, index);
			int end = Math.min(index + findMe.length() + 1, content.length());
			String portion = content.substring(begin, end);
			if (!caseSensitive) {
				portion = portion.toLowerCase(locale);
				findMe = findMe.toLowerCase(locale);
			}
			if (!portion.matches(".*\\b" + findMe + "\\b.*")) {
				index = -1;
			}
		}
		return index;
	}
	
	private int getIndexOf(String source, String toFind) {
		int index = -1;
		if (directionForward) {
			index = source.indexOf(toFind);
		} else {
			index = source.lastIndexOf(toFind);
		}
		return index;
	}
}
