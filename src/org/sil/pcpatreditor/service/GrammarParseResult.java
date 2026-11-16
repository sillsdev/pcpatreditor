/**
 * Copyright (c) 2026 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import org.sil.pcpatreditor.model.Grammar;

public class GrammarParseResult {
    private final Grammar grammar;
    private final int numberOfErrors;
    private final int lineNumberOfError;
    private final int characterPositionInLineOfError;
    private final String errorMessage;
    private final String description;

    public GrammarParseResult(Grammar grammar, int numberOfErrors, int lineNumberOfError, 
                              int characterPositionInLineOfError, String errorMessage, String description) {
        this.grammar = grammar;
        this.numberOfErrors = numberOfErrors;
        this.lineNumberOfError = lineNumberOfError;
        this.characterPositionInLineOfError = characterPositionInLineOfError;
        this.errorMessage = errorMessage;
        this.description = description != null ? description : "";
    }

    public boolean hasErrors() {
        return numberOfErrors > 0;
    }

    public Grammar getGrammar() { return grammar; }
    public int getNumberOfErrors() { return numberOfErrors; }
    public int getLineNumberOfError() { return lineNumberOfError; }
    public int getCharacterPositionInLineOfError() { return characterPositionInLineOfError; }
    public String getErrorMessage() { return errorMessage; }
    public String getDescription() { return description; }

    public int getPositionOfMark() {
        int iCharPosOfMark = 0;
        if (lineNumberOfError <= 1) {
            iCharPosOfMark = characterPositionInLineOfError;
        } else {
            int iCurrentLineNum = 2;
            int iCharPosOfNL = description.indexOf("\n");
            while (iCharPosOfNL > -1 && iCurrentLineNum <= lineNumberOfError) {
                iCharPosOfMark += (iCharPosOfNL + 1);
                String sRest = description.substring(iCharPosOfMark);
                iCharPosOfNL = sRest.indexOf("\n");
                iCurrentLineNum++;
            }
            iCharPosOfMark = iCharPosOfMark + characterPositionInLineOfError;
        }
        return Math.min(iCharPosOfMark, description.length());
    }

    public String getMarkedDescription(String sMark) {
        StringBuilder sb = new StringBuilder();
        int iCharPosOfMark = getPositionOfMark();
        sb.append(description.substring(0, iCharPosOfMark));
        sb.append(sMark);
        sb.append(description.substring(iCharPosOfMark));
        return sb.toString();
    }

    public String getDescriptionBeforeMark() {
        int iCharPosOfMark = getPositionOfMark();
        return description.substring(0, iCharPosOfMark);
    }

    public String getDescriptionAfterMark() {
        int iCharPosOfMark = getPositionOfMark();
        return description.substring(iCharPosOfMark);
    }
}