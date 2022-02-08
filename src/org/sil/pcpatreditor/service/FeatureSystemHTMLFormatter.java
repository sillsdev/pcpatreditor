/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy Black
 *
 */
public class FeatureSystemHTMLFormatter {

	String html = "";
	String nbsp = "&nbsp;";
	
	public FeatureSystemHTMLFormatter() {
		
	}

	/**
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * @param html the html to set
	 */
	public void setHtml(String html) {
		this.html = html;
	}
	
	public String format(List<String> featureSystem, String reportTitle) {
		StringBuilder sb = new StringBuilder();
		formatHTMLBeginning(sb, reportTitle);
		sb.append("<table border=\"1\">\n");
		List<String[]> pathItems = new ArrayList<>();
		int maxColumns = calculateMaxColumns(featureSystem, pathItems);		
		formatRows(sb, pathItems, maxColumns);		
		sb.append("</table>\n");
		formatHTMLEnding(sb);
		return(sb.toString());
	}

	protected void formatRows(StringBuilder sb, List<String[]> pathItems, int maxColumns) {
		String[] previous = new String[maxColumns];
		for (int i = 0; i < pathItems.size(); i++) {
			String[] item = pathItems.get(i);
			for (int col = 0; col < maxColumns; col++) {
				if (previous[col] == null || col >= item.length) {
					formatRow(sb, item, maxColumns, col);
					resetPrevious(maxColumns, previous, item);
					break;
				}
				if (!previous[col].equals(item[col])) {
					formatRow(sb, item, maxColumns, col);
					resetPrevious(maxColumns, previous, item);
					break;
				}
			}
		}
	}

	protected int calculateMaxColumns(List<String> featureSystem, List<String[]> pathItems) {
		int maxColumns = 0;
		for (String path: featureSystem) {
			String[] items = path.split(" ");
			pathItems.add(items);
			maxColumns = Math.max(maxColumns, items.length);
		}
		return maxColumns;
	}

	protected void resetPrevious(int maxColumns, String[] previous, String[] item) {
		for (int j = 0; j < maxColumns; j++) {
			if (j < item.length) {
				previous[j] = item[j];
			} else {
				previous[j] = null;
			}
		}
	}

	protected void formatRow(StringBuilder sb, String[] items, int maxColumns, int startColumn) {
		sb.append("<tr>\n");
		for (int col = 0; col < maxColumns; col++) {
			sb.append("<td valign=\"top\">");
			if (col < startColumn || col >= items.length) {
				sb.append(nbsp);
			} else {
				sb.append(items[col]);
			}
			sb.append("</td>\n");
		}		
		sb.append("</tr>\n");
	}

	protected void formatHTMLBeginning(StringBuilder sb, String reportTitle) {
		sb.append("<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n<title>");
		sb.append(reportTitle);
		sb.append("</title>\n</head>\n<body>\n");
	}

	protected void formatHTMLEnding(StringBuilder sb) {
		sb.append("</body>\n</html>\n");
	}
}
