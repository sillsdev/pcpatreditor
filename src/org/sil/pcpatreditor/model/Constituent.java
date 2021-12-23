/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 * Can be used for either a non-terminal or a terminal constituent.
 */
public class Constituent {

	String node;
	int index = -1;

	/**
	 * @param node
	 * @param index node's index; if < 0, then there is no index 
	 */
	public Constituent(String node, int index) {
		super();
		this.node = node;
		this.index = index;
	}

	public Constituent(String symbol) {
		int underscore = symbol.indexOf("_");
		if (underscore > 0 && symbol.length() > underscore) {
			node = symbol.substring(0, underscore);
			index = Integer.parseInt(symbol.substring(underscore+1));
		} else {
			node = symbol;
			index = -1;
		}
	}

	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	public String nodeRepresentation() {
		String sIndex = "";
		if (index > -1) {
			sIndex = "_" + Integer.toString(index);
		}
		return node + sIndex;
	}

	public String psrRepresentation() {
		return nodeRepresentation();
	}
}
