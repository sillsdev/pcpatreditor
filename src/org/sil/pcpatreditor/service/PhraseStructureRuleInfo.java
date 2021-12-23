/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

/**
 * @author Andy Black
 *
 */
public record PhraseStructureRuleInfo(
		int lineNumber,
		String id,
		String psrRepresentation
		) {}
