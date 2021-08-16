// Copyright (c) 2021 SIL International 
// This software is licensed under the LGPL, version 2.1 or later 
// (http://www.gnu.org/licenses/lgpl-2.1.html) 
/**
 * @author Andy Black
 * 
 */
package org.sil.pcpatreditor.pcpatrgrammar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class PcPatrGrammarErrorListener {
	
	public static class VerboseListener extends BaseErrorListener {
		PcPatrGrammarErrorListener listener = new PcPatrGrammarErrorListener();
	    LinkedList<PcPatrGrammarErrorInfo> errorMessages = new LinkedList<PcPatrGrammarErrorInfo>(
				Arrays.asList(new PcPatrGrammarErrorInfo()));
		
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer,
	                            Object offendingSymbol,
	                            int line, int charPositionInLine,
	                            String msg,
	                            RecognitionException e)
	    {
	        PcPatrGrammarErrorInfo info = new PcPatrGrammarErrorInfo(offendingSymbol, line, charPositionInLine, msg, e);
	        errorMessages.add(info);
	    }

		public List<PcPatrGrammarErrorInfo> getErrorMessages() {
			return errorMessages;
		}
		
		public void clearErrorMessageList() {
			errorMessages.clear();
		}

	}

}
