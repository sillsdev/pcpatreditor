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
	String dateTime = "";
	String grammarFile = "";
	String reportPerformedOn = "";
	String title = "";
	
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
	
	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the grammarFile
	 */
	public String getGrammarFile() {
		return grammarFile;
	}

	/**
	 * @param grammarFile the grammarFile to set
	 */
	public void setGrammarFile(String grammarFile) {
		this.grammarFile = grammarFile;
	}

	/**
	 * @return the reportPerformedOn
	 */
	public String getReportPerformedOn() {
		return reportPerformedOn;
	}

	/**
	 * @param reportPerformedOn the reportPerformedOn to set
	 */
	public void setReportPerformedOn(String reportPerformedOn) {
		this.reportPerformedOn = reportPerformedOn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String format(List<String> featureSystem) {
		StringBuilder sb = new StringBuilder();
		formatHTMLBeginning(sb);
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
		for (int row = 0; row < pathItems.size(); row++) {
			String[] item = pathItems.get(row);
			for (int col = 0; col < maxColumns; col++) {
				int rowSpan = calculateRowSpan(pathItems, row, item, col);
				boolean nextContinuesAndHasMoreColumns = nextContinuesAndHasMoreColumns(pathItems, row, item, rowSpan);
				if (previous[col] == null || col >= item.length) {
					formatRow(sb, item, maxColumns, col, rowSpan, nextContinuesAndHasMoreColumns, pathItems, row);
					resetPrevious(maxColumns, previous, item);
					break;
				}
				if (!previous[col].equals(item[col])) {
					formatRow(sb, item, maxColumns, col, rowSpan, nextContinuesAndHasMoreColumns, pathItems, row);
					resetPrevious(maxColumns, previous, item);
					break;
				}
			}
		}
	}

	protected void formatRow(StringBuilder sb, String[] items, int maxColumns, int startColumn, int rowSpan, boolean nextContinuesAndHasMoreColumns, List<String[]> pathItems, int row) {
//		String sItems = "";
//		for (int i = 0; i < items.length; i++) {
//			sItems += items[i] + " ";
//		}
//		System.out.println("formatRow: rowSpan=" + rowSpan + "; startColumn=" + startColumn + "; next=" + nextContinuesAndHasMoreColumns + "; items=" + sItems);
		int numItems = items.length;
		sb.append("<tr>\n");
		for (int col = startColumn; col < maxColumns && col < numItems; col++) {
			sb.append("<td valign=\"top\"");
			if (rowSpan > 1 && col <= (numItems-1)) {
				if (nextContinuesAndHasMoreColumns) {
					sb.append(" rowspan=\"");
					sb.append(rowSpan);
					sb.append("\"");
				} else if (col < (numItems-1)) {
					sb.append(" rowspan=\"");
					sb.append(rowSpan);
					sb.append("\"");
				}
				if (col < (numItems-1)) {
					rowSpan = calculateRowSpan(pathItems, row, items, col+1);
				} else {
					rowSpan = 0;
				}
			}
//			if (col < startColumn) {
//				sb.append(">");
//				sb.append(nbsp);
//			} else {
				if (!nextContinuesAndHasMoreColumns && col == (numItems-1)) {
					sb.append(" colspan=\"");
					sb.append(maxColumns - col);
					sb.append("\">");
					sb.append(items[col]);
					sb.append("</td>\n");
					break;
				} else {
					sb.append(">");
					sb.append(items[col]);
				}
//			}
			sb.append("</td>\n");
		}
		// when the next item has more columns this than one, we need to add the following
		if (nextContinuesAndHasMoreColumns) {
			sb.append("<td  valign=\"top\" colspan=\"");
			sb.append(maxColumns-numItems);
			sb.append("\">");
			sb.append(nbsp);
			sb.append("</td>\n");
		}
		sb.append("</tr>\n");
	}

	public boolean nextContinuesAndHasMoreColumns(List<String[]> pathItems, int i, String[] item, int rowSpan) {
		boolean nextContinuesAndHasMoreColumns = false;
		if (rowSpan > 1 && i < pathItems.size()-1) {
			String[] nextItem = pathItems.get(i+1);
			if (item.length < nextItem.length) {
				nextContinuesAndHasMoreColumns = true;
			}
		}
		return nextContinuesAndHasMoreColumns;
	}

	public int calculateRowSpan(List<String[]> pathItems, int row, String[] item, int col) {
		int rowSpan = 0;
		while ((row + rowSpan) < pathItems.size() && col < item.length) {
			String[] nextItem = pathItems.get(row + rowSpan);
			// ensure preceding columns also match
			for (int i = 0; i < col; i++) {
				if (i < nextItem.length && !item[i].equals(nextItem[i])) {
					return rowSpan;
				}
			}
			if (col < nextItem.length && item[col].equals(nextItem[col])) {
				rowSpan++;
			} else {
				break;
			}
		}
		return rowSpan;
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

	protected void formatHTMLBeginning(StringBuilder sb) {
		sb.append("<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n<title>");
		sb.append(title);
		sb.append("</title>\n</head>\n<body>\n");		
		sb.append("<h2>");
		sb.append(title);
		sb.append("</h2>\n");
		sb.append("<div>");
		sb.append(grammarFile);
		sb.append("</div>\n");
		sb.append("<p>");
		sb.append(reportPerformedOn);
		sb.append(dateTime);
		sb.append("</p>\n");
	}

	protected void formatHTMLEnding(StringBuilder sb) {
		sb.append("</body>\n</html>\n");
	}
}
