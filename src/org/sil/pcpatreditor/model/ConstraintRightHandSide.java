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
public class ConstraintRightHandSide extends ConstraintLeftHandSide {

	String atomicValue = "";
	/**
	 * @param atomicValue
	 */
	public ConstraintRightHandSide(String atomicValue) {
		super(null, null);
		this.atomicValue = atomicValue;
	}
	/**
	 * @param constituent
	 * @param featurePath
	 */
	public ConstraintRightHandSide(Constituent constituent, FeaturePath featurePath) {
		super(constituent, featurePath);
	}
	/**
	 * @return the atomicValue
	 */
	public String getAtomicValue() {
		return atomicValue;
	}
	/**
	 * @param atomicValue the atomicValue to set
	 */
	public void setAtomicValue(String atomicValue) {
		this.atomicValue = atomicValue;
	}

	public String representation() {
		StringBuilder sb = new StringBuilder();
		if (atomicValue.length() > 0) {
			sb.append(atomicValue);
		} else {
			sb.append("<");
			if (constituent != null) {
				sb.append(constituent.nodeRepresentation());
				if (featurePath != null) {
					sb.append(" ");
					sb.append(featurePath.pathRepresentation());
				}
			}
			sb.append(">");
		}
		return sb.toString();
	}

}
