/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.model;

/**
 * @author Andy Black
 *
 */
public abstract class Constraint extends PcPatrBase {

	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public Constraint(boolean enabled, boolean useWhenDebugging) {
		super(enabled, useWhenDebugging);
	}
	
	

}
