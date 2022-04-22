/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.util.ResourceBundle;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.sil.pcpatreditor.model.Grammar;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarConstants;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarErrorInfo;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarErrorListener;
import org.sil.pcpatreditor.pcpatrgrammar.PcPatrGrammarErrorListener.VerboseListener;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarLexer;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarParser;

/**
 * @author Andy Black
 *
 */
public class GrammarBuilder {
	static int numberOfErrors;
	static int characterPositionInLineOfError;
	static int lineNumberOfError;
	static String errorMessage = "";
	static String sDescription;

	public static int getNumberOfErrors() {
		return numberOfErrors;
	}

	public static int getLineNumberOfError() {
		return lineNumberOfError;
	}

	public static int getCharacterPositionInLineOfError() {
		return characterPositionInLineOfError;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static String getMarkedDescription(String sMark) {
		StringBuilder sb = new StringBuilder();
		int iCharPosOfMark = getPositionOfMark();
		sb.append(sDescription.substring(0, iCharPosOfMark));
		sb.append(sMark);
		sb.append(sDescription.substring(iCharPosOfMark));
		return sb.toString();
	}

	public static String getDescriptionBeforeMark() {
		int iCharPosOfMark = getPositionOfMark();
		//System.out.println("Before: iCharPosOfMark=" + iCharPosOfMark);
		return sDescription.substring(0, iCharPosOfMark);
	}

	public static String getDescriptionAfterMark() {
		int iCharPosOfMark = getPositionOfMark();
		//System.out.println("After:  iCharPosOfMark=" + iCharPosOfMark);
		return sDescription.substring(iCharPosOfMark);
	}

	private static int getPositionOfMark() {
		int iCharPosOfMark = 0;
		if (lineNumberOfError == 1) {
			iCharPosOfMark = characterPositionInLineOfError;
		} else {
			int iCurrentLineNum = 2;
			int iCharPosOfNL = sDescription.indexOf("\n");
			while (iCharPosOfNL > -1 && iCurrentLineNum <= lineNumberOfError) {
				//System.out.println("iCharPosOfMark=" + iCharPosOfMark + " iCharPosOfNL=" + iCharPosOfNL);
				iCharPosOfMark += (iCharPosOfNL + 1);
				String sRest = sDescription.substring(iCharPosOfMark);
				//System.out.println("\tiCharPosOfMark=" + iCharPosOfMark + " sRest='" + sRest + "'");
				iCharPosOfNL = sRest.indexOf("\n");
				iCurrentLineNum++;
			}
			iCharPosOfMark = iCharPosOfMark + characterPositionInLineOfError;
		}
		return iCharPosOfMark;
	}

	public static Grammar parseAString(String sInput, Grammar origGrammar) {

		sDescription = sInput;
		CharStream input = CharStreams.fromString(sInput);
		PcPatrGrammarLexer lexer = new PcPatrGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PcPatrGrammarParser parser = new PcPatrGrammarParser(tokens);

		// try with simpler/faster SLL(*)
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
		// add error listener
		parser.removeErrorListeners();
		VerboseListener errListener = new PcPatrGrammarErrorListener.VerboseListener();
		errListener.clearErrorMessageList();
		parser.addErrorListener(errListener);
		parser.setErrorHandler(new BailErrorStrategy());

		ParseTree parseTree = null;
		try {
		// begin parsing at rule 'description'
		parseTree = parser.patrgrammar();
		// if we get here, there was no syntax error and SLL(*) was enough;
		// there is no need to try full LL(*)
		}
		catch (ParseCancellationException ex) {// thrown by BailErrorStrategy
			tokens.seek(0); // rewind input stream
			parser.reset();
			parser.removeErrorListeners();
			errListener = new PcPatrGrammarErrorListener.VerboseListener();
			errListener.clearErrorMessageList();
			parser.addErrorListener(errListener);
			// full now with full LL(*)
			parser.getInterpreter().setPredictionMode(PredictionMode.LL);
			try {
			parseTree = parser.patrgrammar();
			}
			catch (ParseCancellationException | NoViableAltException ex2) {
				// do nothing
			}
		}
		if (parseTree == null) {
			numberOfErrors = 1;
			System.out.println("GB no tree");
			return origGrammar;
		}
		numberOfErrors = parser.getNumberOfSyntaxErrors();
		if (numberOfErrors > 0) {
			System.out.println("GB errors=" + numberOfErrors);
			errListener = (VerboseListener) parser.getErrorListeners().get(0);
			PcPatrGrammarErrorInfo info = errListener.getErrorMessages().get(0);
			errorMessage = info.getMsg();
			lineNumberOfError = info.getLine();
			characterPositionInLineOfError = info.getCharPositionInLine();
			return origGrammar;
		}
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard
														// walker
		BuildGrammarFromPcPatrGrammarListener validator = new BuildGrammarFromPcPatrGrammarListener(parser);
		walker.walk(validator, parseTree); // initiate walk of tree with
											// listener
		Grammar newGrammar = validator.getGrammar();
		return newGrammar;
	}

	public static String buildErrorMessage(ResourceBundle bundle) {
		String sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.unknown");

		switch (GrammarBuilder.getErrorMessage()) {
		case PcPatrGrammarConstants.MISSING_DISJUNCTION_OR_FEATURE_TEMPLATE_VALUE:
			sSyntaxErrorMessage = bundle
			.getString("grammarsyntaxerror.disjunction_or_feature_template_value");
			break;
		case PcPatrGrammarConstants.MISSING_EQUALS_SIGN:
			sSyntaxErrorMessage = bundle
			.getString("grammarsyntaxerror.missing_equals_sign");
			break;
		case PcPatrGrammarConstants.MISSING_TEMPLATE_BODY:
			sSyntaxErrorMessage = bundle
					.getString("grammarsyntaxerror.missing_template_body");
			break;
		case PcPatrGrammarConstants.MISSING_TEMPLATE_NAME_OR_BE:
			sSyntaxErrorMessage = bundle
					.getString("grammarsyntaxerror.missing_template_name_or_be");
			break;

		case PcPatrGrammarConstants.MISSING_CLOSING_BRACE:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_closing_brace");
			break;

		case PcPatrGrammarConstants.MISSING_CLOSING_BRACKET:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_closing_bracket");
			break;

		case PcPatrGrammarConstants.MISSING_CLOSING_PAREN:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_closing_paren");
			break;

		case PcPatrGrammarConstants.MISSING_CLOSING_WEDGE:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_closing_wedge");
			break;

		case PcPatrGrammarConstants.MISSING_COLON:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_colon");
			break;

//		case DescriptionConstants.MISSING_CONSTITUENT:
//			sSyntaxErrorMessage = bundle
//					.getString("grammarsyntaxerror.missing_constituent");
//			break;
//
//		case DescriptionConstants.MISSING_CONTENT:
//			sSyntaxErrorMessage = bundle
//					.getString("grammarsyntaxerror.missing_content");
//			break;
//
//		case DescriptionConstants.MISSING_CONTENT_AND_CLOSING_PAREN:
//			sSyntaxErrorMessage = bundle
//					.getString("grammarsyntaxerror.missing_content_and_closing_paren");
//			break;
//
		case PcPatrGrammarConstants.MISSING_OPENING_BRACE:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_opening_brace");
			break;

		case PcPatrGrammarConstants.MISSING_OPENING_BRACKET:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_opening_bracket");
			break;

		case PcPatrGrammarConstants.MISSING_OPENING_PAREN:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_opening_paren");
			break;

		case PcPatrGrammarConstants.MISSING_OPENING_WEDGE:
			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_opening_wedge");
			break;

//		case DescriptionConstants.MISSING_RIGHT_BRANCH:
//			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_right_branch");
//			break;
//
//		case DescriptionConstants.TOO_MANY_CLOSING_PARENS:
//			sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.too_many_close_parens");
//			break;
//
		default:
			System.out.println("error was: " + GrammarBuilder.getErrorMessage());
			System.out.println("number of errors was: " + GrammarBuilder.getNumberOfErrors());
			System.out.println("line number was: " + GrammarBuilder.getLineNumberOfError());
			System.out.println("character position was: "
					+ GrammarBuilder.getCharacterPositionInLineOfError());
			break;
		}
		return sSyntaxErrorMessage;
	}

}
