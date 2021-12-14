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
public abstract class PcPatrBase {

	boolean enabled = true;
	boolean useWhenDebugging = true;

	/**
	 * @param enabled
	 * @param useWhenDebugging
	 */
	public PcPatrBase(boolean enabled, boolean useWhenDebugging) {
		super();
		this.enabled = enabled;
		this.useWhenDebugging = useWhenDebugging;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the useWhenDebugging
	 */
	public boolean isUseWhenDebugging() {
		return useWhenDebugging;
	}

	/**
	 * @param useWhenDebugging the useWhenDebugging to set
	 */
	public void setUseWhenDebugging(boolean useWhenDebugging) {
		this.useWhenDebugging = useWhenDebugging;
	}

}
