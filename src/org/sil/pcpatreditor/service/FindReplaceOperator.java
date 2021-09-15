/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.Locale;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author Andy Black
 *
 *         Singleton pattern for handling Find/Replace operations
 */
public class FindReplaceOperator {

	private static FindReplaceOperator instance;
	private String content;
	private boolean directionForward = true;
	private boolean caseSensitive = false;
	private boolean wholeWord = false;
	private boolean regularExpression = false;
	private boolean wrapSearch = true;
	private String find;
	private String replace;
	private Locale locale;
	private int regExEnd = -1;
	private Pattern rePattern;
	private Matcher matcher;
	private String rePatternErrorMessage = "";
	private boolean rePatternParsed = true;
	
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

	/**
	 * @return the rePattern
	 */
	public Pattern getRePattern() {
		return rePattern;
	}

	/**
	 * @param rePattern the rePattern to set
	 */
	public void setRePattern(Pattern rePattern) {
		this.rePattern = rePattern;
	}

	/**
	 * @return the rePatternParsed
	 */
	public boolean isRePatternParsed() {
		return rePatternParsed;
	}

	/**
	 * @return the rePatternErrorMessage
	 */
	public String getRePatternErrorMessage() {
		return rePatternErrorMessage;
	}

	/**
	 * @return the matcher
	 */
	public Matcher getMatcher() {
		return matcher;
	}

	/**
	 * @param matcher the matcher to set
	 */
	public void setMatcher(Matcher matcher) {
		this.matcher = matcher;
	}

	/**
	 * @return the regExEnd
	 */
	public int getRegExEnd() {
		return regExEnd;
	}

	public void initializeParameters(boolean directionForward, boolean caseSensitive, boolean wholeWord,
			boolean regularExpression, boolean wrapSearch) {
		this.directionForward = directionForward;
		this.caseSensitive = caseSensitive;
		this.wholeWord = wholeWord;
		this.regularExpression = regularExpression;
		this.wrapSearch = wrapSearch;
	}

	public int find(int startIndex, String findMe) {
		if (startIndex < 0 || startIndex >= content.length()) {
			return -1;
		}
		int index = -1;
		if (wholeWord) {
			index = findRegularExpression(startIndex, "\\b" + findMe + "\\b");
			return index;
		}
		String source = getStringToSearch(startIndex);
		if (!caseSensitive) {
			findMe = findMe.toLowerCase();
		}
		index = getIndexOf(source, findMe);
		if (index == -1 && wrapSearch) {
			int newStart = directionForward ? 0 : Math.max(0, content.length() - 1);
			index = getIndexOf(getStringToSearch(newStart), findMe);
		} else {
			if (index >= 0) {
				index = adjustIndex(index, startIndex);
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

	private int adjustIndex(int index, int startIndex) {
		if (directionForward) {
			index += startIndex;
		}return index;
	}
	private String getStringToSearch(int startIndex) {
		String search = content.substring(startIndex);
		if (!directionForward && startIndex >= 0) {
			search = content.substring(0, Math.max(0, startIndex - 1));
		}
		if (!caseSensitive) {
			if (locale == null) {
				locale = new Locale("en");
			}
			search = search.toLowerCase(locale);
		}
		return search;
	}

	public int findRegularExpression(int startIndex, String pattern) {
		if (startIndex < 0 || startIndex >= content.length()) {
			return -1;
		}
		if (pattern.length() == 0) {
			return -1;
		}
		int index = -1;
		try {
			rePatternErrorMessage = "";
			rePatternParsed = true;
			if (caseSensitive) {
				rePattern = Pattern.compile(pattern);
			} else {
				rePattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
			}
		} catch (PatternSyntaxException rePatternException) {
			rePatternParsed = false;
			rePatternErrorMessage = rePatternException.getMessage();
			return startIndex;
		}
		matcher = rePattern.matcher(getStringToSearch(startIndex));
		if (directionForward) {
			index = regularExpressionSearchForward(startIndex, matcher, rePattern);
		} else {
			index = regularExpressionSearchBackward(startIndex, matcher, rePattern);
		}
		return index;
	}

	private int regularExpressionSearchForward(int startIndex, Matcher matcher, Pattern rePattern) {
		int index = -1;
		if (matcher.find()) {
			index = reMatchIndexes(startIndex, matcher);
		} else {
			if (wrapSearch) {
				int newStart = 0;
				matcher = rePattern.matcher(getStringToSearch(newStart));
				if (matcher.find()) {
					index = reMatchIndexes(newStart, matcher);
				}
			}
		}
		return index;
	}

	private int reMatchIndexes(int startIndex, Matcher matcher) {
		int index;
		index = matcher.start();
		index = adjustIndex(index, startIndex);
		regExEnd = matcher.end();
		regExEnd = adjustIndex(regExEnd, startIndex);
		return index;
	}

	private int regularExpressionSearchBackward(int startIndex, Matcher matcher, Pattern rePattern) {
		int index = findLastMatch(startIndex, matcher);
		if (index == -1) {
			if (wrapSearch) {
				int newStart = Math.max(0, content.length() - 1);
				matcher = rePattern.matcher(getStringToSearch(newStart));
				index = findLastMatch(startIndex, matcher);
			}
		}
		return index;
	}

	private int findLastMatch(int startIndex, Matcher matcher) {
		Stack<Integer> matchesStart = new Stack<Integer>();
		Stack<Integer> matchesEnd = new Stack<Integer>();
		int index = -1;
		while (matcher.find()) {
			int start = matcher.start();
			index = adjustIndex(start, startIndex);
			matchesStart.push(index);
			regExEnd = matcher.end();
			regExEnd = adjustIndex(regExEnd, startIndex);
			matchesEnd.push(regExEnd);
		}
		if (matchesStart.size() > 0 && matchesEnd.size() > 0) {
			index = matchesStart.lastElement();
			regExEnd = matchesEnd.lastElement();
		}
		return index;
	}
}
