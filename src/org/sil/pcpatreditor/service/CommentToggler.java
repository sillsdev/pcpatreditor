/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import org.sil.pcpatreditor.Constants;

/**
 * @author Andy Black
 *
 */
public class CommentToggler {

	static final String NEW_LINE = "\n";
	
	static public String insertComments(String content) {
		if (content.length() == 0) {
			return content;
		}
		String[] result = content.split("\\R", -1);
		int length = result.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if (i > 0) {
				sb.append(NEW_LINE);
			}
			if (result[i].length() > 0 || i < (length - 1) ) {
				sb.append(Constants.COMMENT_CHARACTER);
			}
			sb.append(result[i]);
		}
		return sb.toString();
	}

	static public String removeComments(String content) {
		if (content.length() == 0) {
			return content;
		}
		String[] result = content.split("\\R", -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			if (i > 0) {
				sb.append(NEW_LINE);
			}
			if (result[i].length() > 0) {
				if (result[i].startsWith(Constants.COMMENT_CHARACTER)) {
					sb.append(result[i].substring(1));
				} else {
					sb.append(result[i]);
				}
			}
		}
		return sb.toString();
	}
}
