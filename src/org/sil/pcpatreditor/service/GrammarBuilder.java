/**
 * Copyright (c) 2021-2026 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.service;

import java.text.MessageFormat;
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
 */
public class GrammarBuilder {

	public static GrammarParseResult parseAString(String sInput, Grammar origGrammar) {
		CharStream input = CharStreams.fromString(sInput);
		PcPatrGrammarLexer lexer = new PcPatrGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PcPatrGrammarParser parser = new PcPatrGrammarParser(tokens);

		// Try with simpler/faster SLL(*)
		parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
		parser.removeErrorListeners();
		VerboseListener errListener = new PcPatrGrammarErrorListener.VerboseListener();
		errListener.clearErrorMessageList();
		parser.addErrorListener(errListener);
		parser.setErrorHandler(new BailErrorStrategy());

		ParseTree parseTree = null;
		try {
			parseTree = parser.patrgrammar();
		} catch (ParseCancellationException ex) {
			tokens.seek(0); // rewind input stream
			parser.reset();
			parser.removeErrorListeners();
			errListener = new PcPatrGrammarErrorListener.VerboseListener();
			errListener.clearErrorMessageList();
			parser.addErrorListener(errListener);
			// Fall back to full LL(*)
			parser.getInterpreter().setPredictionMode(PredictionMode.LL);
			try {
				parseTree = parser.patrgrammar();
			} catch (ParseCancellationException | NoViableAltException ex2) {
				// do nothing
			}
		}

		if (parseTree == null) {
			System.out.println("GB no tree");
			errListener = (VerboseListener) parser.getErrorListeners().get(0);
			String errCode = "";
			int lineNum = 0;
			int charPos = 0;
			if (errListener != null && !errListener.getErrorMessages().isEmpty()) {
				PcPatrGrammarErrorInfo info = errListener.getErrorMessages().get(0);
				errCode = info.getMsg();
				lineNum = info.getLine();
				charPos = info.getCharPositionInLine();
			}
			return new GrammarParseResult(origGrammar, 1, lineNum, charPos, errCode, sInput);
		}

		int numberOfErrors = parser.getNumberOfSyntaxErrors();
		if (numberOfErrors > 0) {
			System.out.println("GB errors=" + numberOfErrors);
			errListener = (VerboseListener) parser.getErrorListeners().get(0);
			PcPatrGrammarErrorInfo info = errListener.getErrorMessages().get(0);
			return new GrammarParseResult(
				origGrammar,
				numberOfErrors,
				info.getLine(),
				info.getCharPositionInLine(),
				info.getMsg(),
				sInput
			);
		}

		ParseTreeWalker walker = new ParseTreeWalker();
		BuildGrammarFromPcPatrGrammarListener validator = new BuildGrammarFromPcPatrGrammarListener(parser);
		walker.walk(validator, parseTree);
		Grammar newGrammar = validator.getGrammar();

		return new GrammarParseResult(newGrammar != null ? newGrammar : origGrammar, 0, 0, 0, "", sInput);
	}

	public static String buildErrorMessage(GrammarParseResult result, ResourceBundle bundle) {
		String sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.unknown");

		switch (result.getErrorMessage()) {
			case PcPatrGrammarConstants.MISSING_BINOP:
				sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_binop");
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
			case PcPatrGrammarConstants.MISSING_DISJUNCTION_OR_FEATURE_TEMPLATE_VALUE:
				sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.disjunction_or_feature_template_value");
				break;
			case PcPatrGrammarConstants.MISSING_EQUALS_SIGN:
				sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_equals_sign");
				break;
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
			case PcPatrGrammarConstants.MISSING_TEMPLATE_BODY:
				sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_template_body");
				break;
			case PcPatrGrammarConstants.MISSING_TEMPLATE_NAME_OR_BE:
				sSyntaxErrorMessage = bundle.getString("grammarsyntaxerror.missing_template_name_or_be");
				break;
			default:
				System.out.println("error was: " + result.getErrorMessage());
				System.out.println("number of errors was: " + result.getNumberOfErrors());
				System.out.println("line number was: " + result.getLineNumberOfError());
				System.out.println("character position was: " + result.getCharacterPositionInLineOfError());
				break;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(sSyntaxErrorMessage);
		Object[] args = { result.getLineNumberOfError(), (result.getCharacterPositionInLineOfError() + 1) };
		MessageFormat msgFormatter = new MessageFormat("");
		msgFormatter.setLocale(bundle.getLocale());
		msgFormatter.applyPattern(bundle.getString("grammarsyntaxerror.location"));
		sb.append(msgFormatter.format(args));
		return sb.toString();
	}
}