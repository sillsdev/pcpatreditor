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

/**
 * @author Andy Black
 *
 */
public class BookmarkDocument {
	
	private String path;
	private List<Integer> lines = new ArrayList<Integer>();

	public BookmarkDocument() {
		
	}

	/**
	 * @param path
	 * @param lines
	 */
	public BookmarkDocument(String path, List<Integer> lines) {
		super();
		this.path = path;
		this.lines = lines;
	}

	/**
	 * @return the path
	 */
	@XmlElement(name = "path")
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the lines
	 */
	@XmlElementWrapper(name = "lines")
	@XmlElement(name = "line")
	public List<Integer> getLines() {
		return lines;
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(List<Integer> lines) {
		this.lines = lines;
	}

	@Override
	public int hashCode() {
		String sCombo = path + lines.stream().hashCode();
		return sCombo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		boolean result = true;
		BookmarkDocument seg = (BookmarkDocument) obj;
		if (!getPath().equals(seg.getPath())) {
			result = false;
		}
		return result;
	}

}
