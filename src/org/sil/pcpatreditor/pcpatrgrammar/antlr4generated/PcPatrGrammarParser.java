// Generated from PcPatrGrammar.g4 by ANTLR 4.7

	package org.sil.pcpatreditor.pcpatrgrammar.antlr4generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PcPatrGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, LINECOMMENT=45, 
		TEXT=46, WS=47;
	public static final int
		RULE_patrgrammar = 0, RULE_comment = 1, RULE_featureTemplates = 2, RULE_featureTemplate = 3, 
		RULE_featureTemplateDefinition = 4, RULE_featurePathTemplateBody = 5, 
		RULE_featureStructureTemplateBody = 6, RULE_featureTemplateName = 7, RULE_featureTemplateAbbreviation = 8, 
		RULE_featureTemplateValue = 9, RULE_atomicValueDisjunction = 10, RULE_featureTemplateDisjunction = 11, 
		RULE_featurePathOrStructure = 12, RULE_featureStructure = 13, RULE_featureStructureName = 14, 
		RULE_featureStructureValue = 15, RULE_embeddedFeatureStructure = 16, RULE_emptyFeatureStructure = 17, 
		RULE_featurePathUnit = 18, RULE_patrRules = 19, RULE_patrRule = 20, RULE_ruleKW = 21, 
		RULE_ruleIdentifier = 22, RULE_phraseStructureRule = 23, RULE_ruleDef = 24, 
		RULE_constituent = 25, RULE_rightHandSide = 26, RULE_disjunctiveConstituents = 27, 
		RULE_disjunctionConstituents = 28, RULE_optionalConstituents = 29, RULE_disjunctiveOptionalConstituents = 30, 
		RULE_disjunctionOptionalConstituents = 31, RULE_constraints = 32, RULE_unificationConstraint = 33, 
		RULE_uniConstraintLeftHandSide = 34, RULE_uniConstraintRightHandSide = 35, 
		RULE_disjunctiveUnificationConstraint = 36, RULE_disjunctionUnificationConstraint = 37, 
		RULE_featurePath = 38, RULE_atomicValue = 39, RULE_priorityUnionConstraint = 40, 
		RULE_priorityUnionLeftHandSide = 41, RULE_priorityUnionRightHandSide = 42, 
		RULE_logicalConstraint = 43, RULE_logConstraintLeftHandSide = 44, RULE_logConstraintExpression = 45, 
		RULE_logConstraintFactor = 46, RULE_binop = 47, RULE_openingBrace = 48, 
		RULE_closingBrace = 49, RULE_openingBracket = 50, RULE_closingBracket = 51, 
		RULE_openingParen = 52, RULE_closingParen = 53, RULE_openingWedge = 54, 
		RULE_closingWedge = 55, RULE_parameters = 56, RULE_parameter = 57, RULE_parameterKW = 58, 
		RULE_parameterName = 59, RULE_parameterValue = 60, RULE_lexicalRules = 61, 
		RULE_lexicalRule = 62, RULE_lexicalRuleKW = 63, RULE_lexicalRuleName = 64, 
		RULE_lexicalRuleDefinition = 65, RULE_lexicalRuleMapping = 66, RULE_lexicalRuleAssignment = 67, 
		RULE_lexicalRuleOutput = 68, RULE_lexicalRuleInput = 69, RULE_constraintTemplates = 70, 
		RULE_constraintTemplate = 71, RULE_constraintTemplateKW = 72, RULE_constraintTemplateName = 73;
	public static final String[] ruleNames = {
		"patrgrammar", "comment", "featureTemplates", "featureTemplate", "featureTemplateDefinition", 
		"featurePathTemplateBody", "featureStructureTemplateBody", "featureTemplateName", 
		"featureTemplateAbbreviation", "featureTemplateValue", "atomicValueDisjunction", 
		"featureTemplateDisjunction", "featurePathOrStructure", "featureStructure", 
		"featureStructureName", "featureStructureValue", "embeddedFeatureStructure", 
		"emptyFeatureStructure", "featurePathUnit", "patrRules", "patrRule", "ruleKW", 
		"ruleIdentifier", "phraseStructureRule", "ruleDef", "constituent", "rightHandSide", 
		"disjunctiveConstituents", "disjunctionConstituents", "optionalConstituents", 
		"disjunctiveOptionalConstituents", "disjunctionOptionalConstituents", 
		"constraints", "unificationConstraint", "uniConstraintLeftHandSide", "uniConstraintRightHandSide", 
		"disjunctiveUnificationConstraint", "disjunctionUnificationConstraint", 
		"featurePath", "atomicValue", "priorityUnionConstraint", "priorityUnionLeftHandSide", 
		"priorityUnionRightHandSide", "logicalConstraint", "logConstraintLeftHandSide", 
		"logConstraintExpression", "logConstraintFactor", "binop", "openingBrace", 
		"closingBrace", "openingBracket", "closingBracket", "openingParen", "closingParen", 
		"openingWedge", "closingWedge", "parameters", "parameter", "parameterKW", 
		"parameterName", "parameterValue", "lexicalRules", "lexicalRule", "lexicalRuleKW", 
		"lexicalRuleName", "lexicalRuleDefinition", "lexicalRuleMapping", "lexicalRuleAssignment", 
		"lexicalRuleOutput", "lexicalRuleInput", "constraintTemplates", "constraintTemplate", 
		"constraintTemplateKW", "constraintTemplateName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'Let'", "'be'", "'='", "'/'", "'['", "']'", "':'", "'Attribute order'", 
		"'in'", "'is'", "'out'", "'[]'", "'rule'", "'Rule'", "'RULE'", "'{'", 
		"'}'", "'->'", "'('", "')'", "'<='", "'=='", "'~'", "'&'", "'<->'", "'<'", 
		"'>'", "'parameter'", "'Parameter'", "'PARAMETER'", "'Start symbol'", 
		"'Category feature'", "'Lexical feature'", "'Gloss feature'", "'RootGloss feature'", 
		"'as'", "'define'", "'Define'", "'DEFINE'", "'=>'", "'constraint'", "'Constraint'", 
		"'CONSTRAINT'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "LINECOMMENT", "TEXT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PcPatrGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PcPatrGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PatrgrammarContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PcPatrGrammarParser.EOF, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<FeatureTemplatesContext> featureTemplates() {
			return getRuleContexts(FeatureTemplatesContext.class);
		}
		public FeatureTemplatesContext featureTemplates(int i) {
			return getRuleContext(FeatureTemplatesContext.class,i);
		}
		public List<ConstraintTemplatesContext> constraintTemplates() {
			return getRuleContexts(ConstraintTemplatesContext.class);
		}
		public ConstraintTemplatesContext constraintTemplates(int i) {
			return getRuleContext(ConstraintTemplatesContext.class,i);
		}
		public List<PatrRulesContext> patrRules() {
			return getRuleContexts(PatrRulesContext.class);
		}
		public PatrRulesContext patrRules(int i) {
			return getRuleContext(PatrRulesContext.class,i);
		}
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
		public List<LexicalRulesContext> lexicalRules() {
			return getRuleContexts(LexicalRulesContext.class);
		}
		public LexicalRulesContext lexicalRules(int i) {
			return getRuleContext(LexicalRulesContext.class,i);
		}
		public PatrgrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patrgrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPatrgrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPatrgrammar(this);
		}
	}

	public final PatrgrammarContext patrgrammar() throws RecognitionException {
		PatrgrammarContext _localctx = new PatrgrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_patrgrammar);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					comment();
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(159);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__1:
						{
						setState(154);
						featureTemplates();
						}
						break;
					case T__41:
					case T__42:
					case T__43:
						{
						setState(155);
						constraintTemplates();
						}
						break;
					case T__13:
					case T__14:
					case T__15:
					case LINECOMMENT:
						{
						setState(156);
						patrRules();
						}
						break;
					case T__28:
					case T__29:
					case T__30:
						{
						setState(157);
						parameters();
						}
						break;
					case T__37:
					case T__38:
					case T__39:
						{
						setState(158);
						lexicalRules();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(164);
				comment();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LINECOMMENT() { return getToken(PcPatrGrammarParser.LINECOMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(LINECOMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplatesContext extends ParserRuleContext {
		public List<FeatureTemplateContext> featureTemplate() {
			return getRuleContexts(FeatureTemplateContext.class);
		}
		public FeatureTemplateContext featureTemplate(int i) {
			return getRuleContext(FeatureTemplateContext.class,i);
		}
		public FeatureTemplatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplates(this);
		}
	}

	public final FeatureTemplatesContext featureTemplates() throws RecognitionException {
		FeatureTemplatesContext _localctx = new FeatureTemplatesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_featureTemplates);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(174);
					featureTemplate();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(177); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplateContext extends ParserRuleContext {
		public FeatureTemplateDefinitionContext featureTemplateDefinition() {
			return getRuleContext(FeatureTemplateDefinitionContext.class,0);
		}
		public FeaturePathTemplateBodyContext featurePathTemplateBody() {
			return getRuleContext(FeaturePathTemplateBodyContext.class,0);
		}
		public FeatureStructureTemplateBodyContext featureStructureTemplateBody() {
			return getRuleContext(FeatureStructureTemplateBodyContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FeatureTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplate(this);
		}
	}

	public final FeatureTemplateContext featureTemplate() throws RecognitionException {
		FeatureTemplateContext _localctx = new FeatureTemplateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_featureTemplate);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			featureTemplateDefinition();
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(180);
				featurePathTemplateBody();
				}
				break;
			case 2:
				{
				setState(181);
				featureStructureTemplateBody();
				}
				break;
			}
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(184);
				match(T__0);
				}
			}

			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(187);
					comment();
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplateDefinitionContext extends ParserRuleContext {
		public FeatureTemplateNameContext featureTemplateName() {
			return getRuleContext(FeatureTemplateNameContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FeatureTemplateDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplateDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplateDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplateDefinition(this);
		}
	}

	public final FeatureTemplateDefinitionContext featureTemplateDefinition() throws RecognitionException {
		FeatureTemplateDefinitionContext _localctx = new FeatureTemplateDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_featureTemplateDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__1);
			setState(194);
			featureTemplateName();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINECOMMENT) {
				{
				setState(195);
				comment();
				}
			}

			setState(198);
			match(T__2);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINECOMMENT) {
				{
				setState(199);
				comment();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeaturePathTemplateBodyContext extends ParserRuleContext {
		public FeaturePathUnitContext featurePathUnit() {
			return getRuleContext(FeaturePathUnitContext.class,0);
		}
		public AtomicValueDisjunctionContext atomicValueDisjunction() {
			return getRuleContext(AtomicValueDisjunctionContext.class,0);
		}
		public FeaturePathTemplateBodyContext featurePathTemplateBody() {
			return getRuleContext(FeaturePathTemplateBodyContext.class,0);
		}
		public FeatureTemplateValueContext featureTemplateValue() {
			return getRuleContext(FeatureTemplateValueContext.class,0);
		}
		public FeatureTemplateAbbreviationContext featureTemplateAbbreviation() {
			return getRuleContext(FeatureTemplateAbbreviationContext.class,0);
		}
		public FeatureTemplateDisjunctionContext featureTemplateDisjunction() {
			return getRuleContext(FeatureTemplateDisjunctionContext.class,0);
		}
		public FeaturePathTemplateBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featurePathTemplateBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeaturePathTemplateBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeaturePathTemplateBody(this);
		}
	}

	public final FeaturePathTemplateBodyContext featurePathTemplateBody() throws RecognitionException {
		FeaturePathTemplateBodyContext _localctx = new FeaturePathTemplateBodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_featurePathTemplateBody);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				featurePathUnit();
				setState(203);
				match(T__3);
				setState(204);
				atomicValueDisjunction();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__16) | (1L << T__26) | (1L << TEXT))) != 0)) {
					{
					setState(205);
					featurePathTemplateBody();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				featurePathUnit();
				setState(209);
				match(T__3);
				setState(210);
				featureTemplateValue();
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__16) | (1L << T__26) | (1L << TEXT))) != 0)) {
					{
					setState(211);
					featurePathTemplateBody();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				featureTemplateAbbreviation();
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__16) | (1L << T__26) | (1L << TEXT))) != 0)) {
					{
					setState(215);
					featurePathTemplateBody();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				featureTemplateDisjunction();
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__16) | (1L << T__26) | (1L << TEXT))) != 0)) {
					{
					setState(219);
					featurePathTemplateBody();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureStructureTemplateBodyContext extends ParserRuleContext {
		public FeatureStructureContext featureStructure() {
			return getRuleContext(FeatureStructureContext.class,0);
		}
		public FeatureStructureTemplateBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureStructureTemplateBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureStructureTemplateBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureStructureTemplateBody(this);
		}
	}

	public final FeatureStructureTemplateBodyContext featureStructureTemplateBody() throws RecognitionException {
		FeatureStructureTemplateBodyContext _localctx = new FeatureStructureTemplateBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_featureStructureTemplateBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			featureStructure();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplateNameContext extends ParserRuleContext {
		public List<AtomicValueContext> atomicValue() {
			return getRuleContexts(AtomicValueContext.class);
		}
		public AtomicValueContext atomicValue(int i) {
			return getRuleContext(AtomicValueContext.class,i);
		}
		public FeatureTemplateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplateName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplateName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplateName(this);
		}
	}

	public final FeatureTemplateNameContext featureTemplateName() throws RecognitionException {
		FeatureTemplateNameContext _localctx = new FeatureTemplateNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_featureTemplateName);
		try {
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				atomicValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				atomicValue();
				setState(228);
				match(T__4);
				setState(229);
				atomicValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplateAbbreviationContext extends ParserRuleContext {
		public FeatureTemplateNameContext featureTemplateName() {
			return getRuleContext(FeatureTemplateNameContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FeatureTemplateAbbreviationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplateAbbreviation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplateAbbreviation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplateAbbreviation(this);
		}
	}

	public final FeatureTemplateAbbreviationContext featureTemplateAbbreviation() throws RecognitionException {
		FeatureTemplateAbbreviationContext _localctx = new FeatureTemplateAbbreviationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_featureTemplateAbbreviation);
		try {
			int _alt;
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(T__5);
				setState(234);
				featureTemplateName();
				setState(235);
				match(T__6);
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(236);
						comment();
						}
						} 
					}
					setState(241);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				featureTemplateName();
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(243);
						comment();
						}
						} 
					}
					setState(248);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplateValueContext extends ParserRuleContext {
		public FeatureTemplateDisjunctionContext featureTemplateDisjunction() {
			return getRuleContext(FeatureTemplateDisjunctionContext.class,0);
		}
		public FeaturePathUnitContext featurePathUnit() {
			return getRuleContext(FeaturePathUnitContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public FeatureTemplateValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplateValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplateValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplateValue(this);
		}
	}

	public final FeatureTemplateValueContext featureTemplateValue() throws RecognitionException {
		FeatureTemplateValueContext _localctx = new FeatureTemplateValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_featureTemplateValue);
		try {
			int _alt;
			setState(272);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				featureTemplateDisjunction();
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				featurePathUnit();
				setState(254);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(253);
					match(T__0);
					}
					break;
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(256);
						comment();
						}
						} 
					}
					setState(261);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				atomicValue();
				setState(264);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(263);
					match(T__0);
					}
					break;
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(266);
						comment();
						}
						} 
					}
					setState(271);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicValueDisjunctionContext extends ParserRuleContext {
		public OpeningBraceContext openingBrace() {
			return getRuleContext(OpeningBraceContext.class,0);
		}
		public List<AtomicValueContext> atomicValue() {
			return getRuleContexts(AtomicValueContext.class);
		}
		public AtomicValueContext atomicValue(int i) {
			return getRuleContext(AtomicValueContext.class,i);
		}
		public ClosingBraceContext closingBrace() {
			return getRuleContext(ClosingBraceContext.class,0);
		}
		public AtomicValueDisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicValueDisjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterAtomicValueDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitAtomicValueDisjunction(this);
		}
	}

	public final AtomicValueDisjunctionContext atomicValueDisjunction() throws RecognitionException {
		AtomicValueDisjunctionContext _localctx = new AtomicValueDisjunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atomicValueDisjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			openingBrace();
			setState(275);
			atomicValue();
			setState(277); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276);
				atomicValue();
				}
				}
				setState(279); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(281);
			closingBrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureTemplateDisjunctionContext extends ParserRuleContext {
		public OpeningBraceContext openingBrace() {
			return getRuleContext(OpeningBraceContext.class,0);
		}
		public List<FeaturePathOrStructureContext> featurePathOrStructure() {
			return getRuleContexts(FeaturePathOrStructureContext.class);
		}
		public FeaturePathOrStructureContext featurePathOrStructure(int i) {
			return getRuleContext(FeaturePathOrStructureContext.class,i);
		}
		public ClosingBraceContext closingBrace() {
			return getRuleContext(ClosingBraceContext.class,0);
		}
		public FeatureTemplateDisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureTemplateDisjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureTemplateDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureTemplateDisjunction(this);
		}
	}

	public final FeatureTemplateDisjunctionContext featureTemplateDisjunction() throws RecognitionException {
		FeatureTemplateDisjunctionContext _localctx = new FeatureTemplateDisjunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_featureTemplateDisjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			openingBrace();
			setState(284);
			featurePathOrStructure();
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(285);
				featurePathOrStructure();
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0) );
			setState(290);
			closingBrace();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeaturePathOrStructureContext extends ParserRuleContext {
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FeatureStructureContext featureStructure() {
			return getRuleContext(FeatureStructureContext.class,0);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public FeatureTemplateAbbreviationContext featureTemplateAbbreviation() {
			return getRuleContext(FeatureTemplateAbbreviationContext.class,0);
		}
		public FeaturePathOrStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featurePathOrStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeaturePathOrStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeaturePathOrStructure(this);
		}
	}

	public final FeaturePathOrStructureContext featurePathOrStructure() throws RecognitionException {
		FeaturePathOrStructureContext _localctx = new FeaturePathOrStructureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_featurePathOrStructure);
		int _la;
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				featurePath();
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(293);
					comment();
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				featureStructure();
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(300);
					comment();
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				atomicValue();
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(307);
					comment();
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(313);
				featureTemplateAbbreviation();
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(314);
					comment();
					}
					}
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureStructureContext extends ParserRuleContext {
		public OpeningBracketContext openingBracket() {
			return getRuleContext(OpeningBracketContext.class,0);
		}
		public FeatureStructureNameContext featureStructureName() {
			return getRuleContext(FeatureStructureNameContext.class,0);
		}
		public FeatureStructureValueContext featureStructureValue() {
			return getRuleContext(FeatureStructureValueContext.class,0);
		}
		public ClosingBracketContext closingBracket() {
			return getRuleContext(ClosingBracketContext.class,0);
		}
		public List<EmbeddedFeatureStructureContext> embeddedFeatureStructure() {
			return getRuleContexts(EmbeddedFeatureStructureContext.class);
		}
		public EmbeddedFeatureStructureContext embeddedFeatureStructure(int i) {
			return getRuleContext(EmbeddedFeatureStructureContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public EmptyFeatureStructureContext emptyFeatureStructure() {
			return getRuleContext(EmptyFeatureStructureContext.class,0);
		}
		public FeatureStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureStructure(this);
		}
	}

	public final FeatureStructureContext featureStructure() throws RecognitionException {
		FeatureStructureContext _localctx = new FeatureStructureContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_featureStructure);
		int _la;
		try {
			int _alt;
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				openingBracket();
				setState(323);
				featureStructureName();
				setState(324);
				match(T__7);
				setState(325);
				featureStructureValue();
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
					{
					{
					setState(326);
					embeddedFeatureStructure();
					}
					}
					setState(331);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(332);
				closingBracket();
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(333);
						comment();
						}
						} 
					}
					setState(338);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				emptyFeatureStructure();
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(340);
						comment();
						}
						} 
					}
					setState(345);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureStructureNameContext extends ParserRuleContext {
		public RuleKWContext ruleKW() {
			return getRuleContext(RuleKWContext.class,0);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public FeatureStructureNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureStructureName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureStructureName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureStructureName(this);
		}
	}

	public final FeatureStructureNameContext featureStructureName() throws RecognitionException {
		FeatureStructureNameContext _localctx = new FeatureStructureNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_featureStructureName);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				ruleKW();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				atomicValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureStructureValueContext extends ParserRuleContext {
		public FeatureStructureContext featureStructure() {
			return getRuleContext(FeatureStructureContext.class,0);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public ConstraintTemplateKWContext constraintTemplateKW() {
			return getRuleContext(ConstraintTemplateKWContext.class,0);
		}
		public LexicalRuleKWContext lexicalRuleKW() {
			return getRuleContext(LexicalRuleKWContext.class,0);
		}
		public ParameterKWContext parameterKW() {
			return getRuleContext(ParameterKWContext.class,0);
		}
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public RuleKWContext ruleKW() {
			return getRuleContext(RuleKWContext.class,0);
		}
		public FeatureStructureValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featureStructureValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeatureStructureValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeatureStructureValue(this);
		}
	}

	public final FeatureStructureValueContext featureStructureValue() throws RecognitionException {
		FeatureStructureValueContext _localctx = new FeatureStructureValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_featureStructureValue);
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				featureStructure();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(353);
				atomicValue();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(354);
				match(T__8);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(355);
				match(T__2);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(356);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(357);
				match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 7);
				{
				setState(358);
				match(T__11);
				}
				break;
			case T__41:
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 8);
				{
				setState(359);
				constraintTemplateKW();
				}
				break;
			case T__37:
			case T__38:
			case T__39:
				enterOuterAlt(_localctx, 9);
				{
				setState(360);
				lexicalRuleKW();
				}
				break;
			case T__28:
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 10);
				{
				setState(361);
				parameterKW();
				}
				break;
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 11);
				{
				setState(362);
				parameterName();
				}
				break;
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 12);
				{
				setState(363);
				ruleKW();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmbeddedFeatureStructureContext extends ParserRuleContext {
		public FeatureStructureNameContext featureStructureName() {
			return getRuleContext(FeatureStructureNameContext.class,0);
		}
		public FeatureStructureValueContext featureStructureValue() {
			return getRuleContext(FeatureStructureValueContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public EmbeddedFeatureStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_embeddedFeatureStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterEmbeddedFeatureStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitEmbeddedFeatureStructure(this);
		}
	}

	public final EmbeddedFeatureStructureContext embeddedFeatureStructure() throws RecognitionException {
		EmbeddedFeatureStructureContext _localctx = new EmbeddedFeatureStructureContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_embeddedFeatureStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			featureStructureName();
			setState(367);
			match(T__7);
			setState(368);
			featureStructureValue();
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(369);
				comment();
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyFeatureStructureContext extends ParserRuleContext {
		public EmptyFeatureStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyFeatureStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterEmptyFeatureStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitEmptyFeatureStructure(this);
		}
	}

	public final EmptyFeatureStructureContext emptyFeatureStructure() throws RecognitionException {
		EmptyFeatureStructureContext _localctx = new EmptyFeatureStructureContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_emptyFeatureStructure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeaturePathUnitContext extends ParserRuleContext {
		public OpeningWedgeContext openingWedge() {
			return getRuleContext(OpeningWedgeContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public ClosingWedgeContext closingWedge() {
			return getRuleContext(ClosingWedgeContext.class,0);
		}
		public FeaturePathUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featurePathUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeaturePathUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeaturePathUnit(this);
		}
	}

	public final FeaturePathUnitContext featurePathUnit() throws RecognitionException {
		FeaturePathUnitContext _localctx = new FeaturePathUnitContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_featurePathUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			openingWedge();
			setState(378);
			featurePath();
			setState(379);
			closingWedge();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatrRulesContext extends ParserRuleContext {
		public List<PatrRuleContext> patrRule() {
			return getRuleContexts(PatrRuleContext.class);
		}
		public PatrRuleContext patrRule(int i) {
			return getRuleContext(PatrRuleContext.class,i);
		}
		public PatrRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patrRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPatrRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPatrRules(this);
		}
	}

	public final PatrRulesContext patrRules() throws RecognitionException {
		PatrRulesContext _localctx = new PatrRulesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_patrRules);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(382); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(381);
					patrRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(384); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatrRuleContext extends ParserRuleContext {
		public RuleKWContext ruleKW() {
			return getRuleContext(RuleKWContext.class,0);
		}
		public PhraseStructureRuleContext phraseStructureRule() {
			return getRuleContext(PhraseStructureRuleContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public RuleIdentifierContext ruleIdentifier() {
			return getRuleContext(RuleIdentifierContext.class,0);
		}
		public ConstraintsContext constraints() {
			return getRuleContext(ConstraintsContext.class,0);
		}
		public PatrRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patrRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPatrRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPatrRule(this);
		}
	}

	public final PatrRuleContext patrRule() throws RecognitionException {
		PatrRuleContext _localctx = new PatrRuleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_patrRule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(386);
				comment();
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			ruleKW();
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(393);
				ruleIdentifier();
				}
			}

			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(396);
				comment();
				}
				}
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
			phraseStructureRule();
			setState(406);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(403);
					comment();
					}
					} 
				}
				setState(408);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(409);
				constraints();
				}
				break;
			}
			setState(415);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(412);
					comment();
					}
					} 
				}
				setState(417);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(418);
				match(T__0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleKWContext extends ParserRuleContext {
		public RuleKWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleKW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterRuleKW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitRuleKW(this);
		}
	}

	public final RuleKWContext ruleKW() throws RecognitionException {
		RuleKWContext _localctx = new RuleKWContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_ruleKW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleIdentifierContext extends ParserRuleContext {
		public RuleIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterRuleIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitRuleIdentifier(this);
		}
	}

	public final RuleIdentifierContext ruleIdentifier() throws RecognitionException {
		RuleIdentifierContext _localctx = new RuleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ruleIdentifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(T__16);
			setState(427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(424);
					matchWildcard();
					}
					} 
				}
				setState(429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			setState(430);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhraseStructureRuleContext extends ParserRuleContext {
		public ConstituentContext constituent() {
			return getRuleContext(ConstituentContext.class,0);
		}
		public RuleDefContext ruleDef() {
			return getRuleContext(RuleDefContext.class,0);
		}
		public RightHandSideContext rightHandSide() {
			return getRuleContext(RightHandSideContext.class,0);
		}
		public PhraseStructureRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseStructureRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPhraseStructureRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPhraseStructureRule(this);
		}
	}

	public final PhraseStructureRuleContext phraseStructureRule() throws RecognitionException {
		PhraseStructureRuleContext _localctx = new PhraseStructureRuleContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_phraseStructureRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			constituent();
			setState(433);
			ruleDef();
			setState(434);
			rightHandSide();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleDefContext extends ParserRuleContext {
		public RuleDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterRuleDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitRuleDef(this);
		}
	}

	public final RuleDefContext ruleDef() throws RecognitionException {
		RuleDefContext _localctx = new RuleDefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ruleDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstituentContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PcPatrGrammarParser.TEXT, 0); }
		public ConstituentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constituent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterConstituent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitConstituent(this);
		}
	}

	public final ConstituentContext constituent() throws RecognitionException {
		ConstituentContext _localctx = new ConstituentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constituent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightHandSideContext extends ParserRuleContext {
		public List<ConstituentContext> constituent() {
			return getRuleContexts(ConstituentContext.class);
		}
		public ConstituentContext constituent(int i) {
			return getRuleContext(ConstituentContext.class,i);
		}
		public List<DisjunctiveConstituentsContext> disjunctiveConstituents() {
			return getRuleContexts(DisjunctiveConstituentsContext.class);
		}
		public DisjunctiveConstituentsContext disjunctiveConstituents(int i) {
			return getRuleContext(DisjunctiveConstituentsContext.class,i);
		}
		public List<OptionalConstituentsContext> optionalConstituents() {
			return getRuleContexts(OptionalConstituentsContext.class);
		}
		public OptionalConstituentsContext optionalConstituents(int i) {
			return getRuleContext(OptionalConstituentsContext.class,i);
		}
		public List<DisjunctiveOptionalConstituentsContext> disjunctiveOptionalConstituents() {
			return getRuleContexts(DisjunctiveOptionalConstituentsContext.class);
		}
		public DisjunctiveOptionalConstituentsContext disjunctiveOptionalConstituents(int i) {
			return getRuleContext(DisjunctiveOptionalConstituentsContext.class,i);
		}
		public List<DisjunctionConstituentsContext> disjunctionConstituents() {
			return getRuleContexts(DisjunctionConstituentsContext.class);
		}
		public DisjunctionConstituentsContext disjunctionConstituents(int i) {
			return getRuleContext(DisjunctionConstituentsContext.class,i);
		}
		public RightHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterRightHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitRightHandSide(this);
		}
	}

	public final RightHandSideContext rightHandSide() throws RecognitionException {
		RightHandSideContext _localctx = new RightHandSideContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_rightHandSide);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(445); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(445);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						setState(440);
						constituent();
						}
						break;
					case 2:
						{
						setState(441);
						disjunctiveConstituents();
						}
						break;
					case 3:
						{
						setState(442);
						optionalConstituents();
						}
						break;
					case 4:
						{
						setState(443);
						disjunctiveOptionalConstituents();
						}
						break;
					case 5:
						{
						setState(444);
						disjunctionConstituents();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(447); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctiveConstituentsContext extends ParserRuleContext {
		public List<ConstituentContext> constituent() {
			return getRuleContexts(ConstituentContext.class);
		}
		public ConstituentContext constituent(int i) {
			return getRuleContext(ConstituentContext.class,i);
		}
		public List<OptionalConstituentsContext> optionalConstituents() {
			return getRuleContexts(OptionalConstituentsContext.class);
		}
		public OptionalConstituentsContext optionalConstituents(int i) {
			return getRuleContext(OptionalConstituentsContext.class,i);
		}
		public List<DisjunctiveConstituentsContext> disjunctiveConstituents() {
			return getRuleContexts(DisjunctiveConstituentsContext.class);
		}
		public DisjunctiveConstituentsContext disjunctiveConstituents(int i) {
			return getRuleContext(DisjunctiveConstituentsContext.class,i);
		}
		public List<DisjunctionConstituentsContext> disjunctionConstituents() {
			return getRuleContexts(DisjunctionConstituentsContext.class);
		}
		public DisjunctionConstituentsContext disjunctionConstituents(int i) {
			return getRuleContext(DisjunctionConstituentsContext.class,i);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public DisjunctiveConstituentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctiveConstituents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterDisjunctiveConstituents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitDisjunctiveConstituents(this);
		}
	}

	public final DisjunctiveConstituentsContext disjunctiveConstituents() throws RecognitionException {
		DisjunctiveConstituentsContext _localctx = new DisjunctiveConstituentsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_disjunctiveConstituents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(T__16);
			setState(453); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(453);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(450);
					constituent();
					}
					break;
				case T__19:
					{
					setState(451);
					optionalConstituents();
					}
					break;
				case T__16:
					{
					setState(452);
					disjunctiveConstituents();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(455); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__19) | (1L << TEXT))) != 0) );
			setState(458); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(457);
				disjunctionConstituents();
				}
				}
				setState(460); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(462);
			match(T__17);
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(463);
				comment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctionConstituentsContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<ConstituentContext> constituent() {
			return getRuleContexts(ConstituentContext.class);
		}
		public ConstituentContext constituent(int i) {
			return getRuleContext(ConstituentContext.class,i);
		}
		public List<DisjunctiveConstituentsContext> disjunctiveConstituents() {
			return getRuleContexts(DisjunctiveConstituentsContext.class);
		}
		public DisjunctiveConstituentsContext disjunctiveConstituents(int i) {
			return getRuleContext(DisjunctiveConstituentsContext.class,i);
		}
		public List<OptionalConstituentsContext> optionalConstituents() {
			return getRuleContexts(OptionalConstituentsContext.class);
		}
		public OptionalConstituentsContext optionalConstituents(int i) {
			return getRuleContext(OptionalConstituentsContext.class,i);
		}
		public DisjunctionConstituentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctionConstituents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterDisjunctionConstituents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitDisjunctionConstituents(this);
		}
	}

	public final DisjunctionConstituentsContext disjunctionConstituents() throws RecognitionException {
		DisjunctionConstituentsContext _localctx = new DisjunctionConstituentsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_disjunctionConstituents);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(T__4);
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(467);
				comment();
				}
				}
				setState(472);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(476); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(476);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TEXT:
						{
						setState(473);
						constituent();
						}
						break;
					case T__16:
						{
						setState(474);
						disjunctiveConstituents();
						}
						break;
					case T__19:
						{
						setState(475);
						optionalConstituents();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(478); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(481);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(480);
				comment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionalConstituentsContext extends ParserRuleContext {
		public List<ConstituentContext> constituent() {
			return getRuleContexts(ConstituentContext.class);
		}
		public ConstituentContext constituent(int i) {
			return getRuleContext(ConstituentContext.class,i);
		}
		public List<DisjunctiveConstituentsContext> disjunctiveConstituents() {
			return getRuleContexts(DisjunctiveConstituentsContext.class);
		}
		public DisjunctiveConstituentsContext disjunctiveConstituents(int i) {
			return getRuleContext(DisjunctiveConstituentsContext.class,i);
		}
		public List<OptionalConstituentsContext> optionalConstituents() {
			return getRuleContexts(OptionalConstituentsContext.class);
		}
		public OptionalConstituentsContext optionalConstituents(int i) {
			return getRuleContext(OptionalConstituentsContext.class,i);
		}
		public List<DisjunctionOptionalConstituentsContext> disjunctionOptionalConstituents() {
			return getRuleContexts(DisjunctionOptionalConstituentsContext.class);
		}
		public DisjunctionOptionalConstituentsContext disjunctionOptionalConstituents(int i) {
			return getRuleContext(DisjunctionOptionalConstituentsContext.class,i);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public OptionalConstituentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalConstituents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterOptionalConstituents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitOptionalConstituents(this);
		}
	}

	public final OptionalConstituentsContext optionalConstituents() throws RecognitionException {
		OptionalConstituentsContext _localctx = new OptionalConstituentsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_optionalConstituents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(T__19);
			setState(488); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(488);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(484);
					constituent();
					}
					break;
				case T__16:
					{
					setState(485);
					disjunctiveConstituents();
					}
					break;
				case T__19:
					{
					setState(486);
					optionalConstituents();
					}
					break;
				case T__4:
					{
					setState(487);
					disjunctionOptionalConstituents();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(490); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__16) | (1L << T__19) | (1L << TEXT))) != 0) );
			setState(492);
			match(T__20);
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(493);
				comment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctiveOptionalConstituentsContext extends ParserRuleContext {
		public List<ConstituentContext> constituent() {
			return getRuleContexts(ConstituentContext.class);
		}
		public ConstituentContext constituent(int i) {
			return getRuleContext(ConstituentContext.class,i);
		}
		public List<DisjunctionOptionalConstituentsContext> disjunctionOptionalConstituents() {
			return getRuleContexts(DisjunctionOptionalConstituentsContext.class);
		}
		public DisjunctionOptionalConstituentsContext disjunctionOptionalConstituents(int i) {
			return getRuleContext(DisjunctionOptionalConstituentsContext.class,i);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public DisjunctiveOptionalConstituentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctiveOptionalConstituents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterDisjunctiveOptionalConstituents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitDisjunctiveOptionalConstituents(this);
		}
	}

	public final DisjunctiveOptionalConstituentsContext disjunctiveOptionalConstituents() throws RecognitionException {
		DisjunctiveOptionalConstituentsContext _localctx = new DisjunctiveOptionalConstituentsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_disjunctiveOptionalConstituents);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(T__19);
			setState(498); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(497);
				constituent();
				}
				}
				setState(500); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(503); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(502);
				disjunctionOptionalConstituents();
				}
				}
				setState(505); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(507);
			match(T__20);
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(508);
				comment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctionOptionalConstituentsContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<ConstituentContext> constituent() {
			return getRuleContexts(ConstituentContext.class);
		}
		public ConstituentContext constituent(int i) {
			return getRuleContext(ConstituentContext.class,i);
		}
		public DisjunctionOptionalConstituentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctionOptionalConstituents; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterDisjunctionOptionalConstituents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitDisjunctionOptionalConstituents(this);
		}
	}

	public final DisjunctionOptionalConstituentsContext disjunctionOptionalConstituents() throws RecognitionException {
		DisjunctionOptionalConstituentsContext _localctx = new DisjunctionOptionalConstituentsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_disjunctionOptionalConstituents);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(T__4);
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(512);
				comment();
				}
				}
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(519); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(518);
					constituent();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(521); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINECOMMENT) {
				{
				setState(523);
				comment();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintsContext extends ParserRuleContext {
		public List<UnificationConstraintContext> unificationConstraint() {
			return getRuleContexts(UnificationConstraintContext.class);
		}
		public UnificationConstraintContext unificationConstraint(int i) {
			return getRuleContext(UnificationConstraintContext.class,i);
		}
		public List<PriorityUnionConstraintContext> priorityUnionConstraint() {
			return getRuleContexts(PriorityUnionConstraintContext.class);
		}
		public PriorityUnionConstraintContext priorityUnionConstraint(int i) {
			return getRuleContext(PriorityUnionConstraintContext.class,i);
		}
		public List<LogicalConstraintContext> logicalConstraint() {
			return getRuleContexts(LogicalConstraintContext.class);
		}
		public LogicalConstraintContext logicalConstraint(int i) {
			return getRuleContext(LogicalConstraintContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public ConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitConstraints(this);
		}
	}

	public final ConstraintsContext constraints() throws RecognitionException {
		ConstraintsContext _localctx = new ConstraintsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_constraints);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(530); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(530);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						setState(526);
						unificationConstraint();
						}
						break;
					case 2:
						{
						setState(527);
						priorityUnionConstraint();
						}
						break;
					case 3:
						{
						setState(528);
						logicalConstraint();
						}
						break;
					case 4:
						{
						setState(529);
						comment();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(532); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnificationConstraintContext extends ParserRuleContext {
		public UniConstraintLeftHandSideContext uniConstraintLeftHandSide() {
			return getRuleContext(UniConstraintLeftHandSideContext.class,0);
		}
		public UniConstraintRightHandSideContext uniConstraintRightHandSide() {
			return getRuleContext(UniConstraintRightHandSideContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public DisjunctiveUnificationConstraintContext disjunctiveUnificationConstraint() {
			return getRuleContext(DisjunctiveUnificationConstraintContext.class,0);
		}
		public UnificationConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unificationConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterUnificationConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitUnificationConstraint(this);
		}
	}

	public final UnificationConstraintContext unificationConstraint() throws RecognitionException {
		UnificationConstraintContext _localctx = new UnificationConstraintContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_unificationConstraint);
		try {
			setState(541);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				uniConstraintLeftHandSide();
				setState(535);
				match(T__3);
				setState(536);
				uniConstraintRightHandSide();
				setState(538);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(537);
					comment();
					}
					break;
				}
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				disjunctiveUnificationConstraint();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UniConstraintLeftHandSideContext extends ParserRuleContext {
		public OpeningWedgeContext openingWedge() {
			return getRuleContext(OpeningWedgeContext.class,0);
		}
		public ConstituentContext constituent() {
			return getRuleContext(ConstituentContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public ClosingWedgeContext closingWedge() {
			return getRuleContext(ClosingWedgeContext.class,0);
		}
		public UniConstraintLeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniConstraintLeftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterUniConstraintLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitUniConstraintLeftHandSide(this);
		}
	}

	public final UniConstraintLeftHandSideContext uniConstraintLeftHandSide() throws RecognitionException {
		UniConstraintLeftHandSideContext _localctx = new UniConstraintLeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_uniConstraintLeftHandSide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			openingWedge();
			setState(544);
			constituent();
			setState(545);
			featurePath();
			setState(546);
			closingWedge();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UniConstraintRightHandSideContext extends ParserRuleContext {
		public OpeningWedgeContext openingWedge() {
			return getRuleContext(OpeningWedgeContext.class,0);
		}
		public ConstituentContext constituent() {
			return getRuleContext(ConstituentContext.class,0);
		}
		public ClosingWedgeContext closingWedge() {
			return getRuleContext(ClosingWedgeContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public UniConstraintRightHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniConstraintRightHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterUniConstraintRightHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitUniConstraintRightHandSide(this);
		}
	}

	public final UniConstraintRightHandSideContext uniConstraintRightHandSide() throws RecognitionException {
		UniConstraintRightHandSideContext _localctx = new UniConstraintRightHandSideContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_uniConstraintRightHandSide);
		int _la;
		try {
			setState(561);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				openingWedge();
				setState(549);
				constituent();
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
					{
					setState(550);
					featurePath();
					}
				}

				setState(553);
				closingWedge();
				setState(555);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(554);
					comment();
					}
					break;
				}
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				atomicValue();
				setState(559);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(558);
					comment();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctiveUnificationConstraintContext extends ParserRuleContext {
		public List<UnificationConstraintContext> unificationConstraint() {
			return getRuleContexts(UnificationConstraintContext.class);
		}
		public UnificationConstraintContext unificationConstraint(int i) {
			return getRuleContext(UnificationConstraintContext.class,i);
		}
		public List<DisjunctionUnificationConstraintContext> disjunctionUnificationConstraint() {
			return getRuleContexts(DisjunctionUnificationConstraintContext.class);
		}
		public DisjunctionUnificationConstraintContext disjunctionUnificationConstraint(int i) {
			return getRuleContext(DisjunctionUnificationConstraintContext.class,i);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public DisjunctiveUnificationConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctiveUnificationConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterDisjunctiveUnificationConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitDisjunctiveUnificationConstraint(this);
		}
	}

	public final DisjunctiveUnificationConstraintContext disjunctiveUnificationConstraint() throws RecognitionException {
		DisjunctiveUnificationConstraintContext _localctx = new DisjunctiveUnificationConstraintContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_disjunctiveUnificationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(T__16);
			setState(565); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(564);
				unificationConstraint();
				}
				}
				setState(567); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__26 );
			setState(570); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(569);
				disjunctionUnificationConstraint();
				}
				}
				setState(572); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(574);
			match(T__17);
			setState(576);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				setState(575);
				comment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DisjunctionUnificationConstraintContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<UnificationConstraintContext> unificationConstraint() {
			return getRuleContexts(UnificationConstraintContext.class);
		}
		public UnificationConstraintContext unificationConstraint(int i) {
			return getRuleContext(UnificationConstraintContext.class,i);
		}
		public DisjunctionUnificationConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunctionUnificationConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterDisjunctionUnificationConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitDisjunctionUnificationConstraint(this);
		}
	}

	public final DisjunctionUnificationConstraintContext disjunctionUnificationConstraint() throws RecognitionException {
		DisjunctionUnificationConstraintContext _localctx = new DisjunctionUnificationConstraintContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_disjunctionUnificationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			match(T__4);
			setState(582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(579);
				comment();
				}
				}
				setState(584);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(586); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(585);
				unificationConstraint();
				}
				}
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__26 );
			setState(591);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINECOMMENT) {
				{
				setState(590);
				comment();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeaturePathContext extends ParserRuleContext {
		public RuleKWContext ruleKW() {
			return getRuleContext(RuleKWContext.class,0);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public FeaturePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_featurePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterFeaturePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitFeaturePath(this);
		}
	}

	public final FeaturePathContext featurePath() throws RecognitionException {
		FeaturePathContext _localctx = new FeaturePathContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_featurePath);
		try {
			setState(598);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(593);
				ruleKW();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(594);
				atomicValue();
				setState(595);
				featurePath();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(597);
				atomicValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicValueContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PcPatrGrammarParser.TEXT, 0); }
		public AtomicValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterAtomicValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitAtomicValue(this);
		}
	}

	public final AtomicValueContext atomicValue() throws RecognitionException {
		AtomicValueContext _localctx = new AtomicValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_atomicValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PriorityUnionConstraintContext extends ParserRuleContext {
		public PriorityUnionLeftHandSideContext priorityUnionLeftHandSide() {
			return getRuleContext(PriorityUnionLeftHandSideContext.class,0);
		}
		public PriorityUnionRightHandSideContext priorityUnionRightHandSide() {
			return getRuleContext(PriorityUnionRightHandSideContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public PriorityUnionConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priorityUnionConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPriorityUnionConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPriorityUnionConstraint(this);
		}
	}

	public final PriorityUnionConstraintContext priorityUnionConstraint() throws RecognitionException {
		PriorityUnionConstraintContext _localctx = new PriorityUnionConstraintContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_priorityUnionConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			priorityUnionLeftHandSide();
			setState(603);
			match(T__21);
			setState(604);
			priorityUnionRightHandSide();
			setState(606);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				{
				setState(605);
				comment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PriorityUnionLeftHandSideContext extends ParserRuleContext {
		public OpeningWedgeContext openingWedge() {
			return getRuleContext(OpeningWedgeContext.class,0);
		}
		public ConstituentContext constituent() {
			return getRuleContext(ConstituentContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public ClosingWedgeContext closingWedge() {
			return getRuleContext(ClosingWedgeContext.class,0);
		}
		public PriorityUnionLeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priorityUnionLeftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPriorityUnionLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPriorityUnionLeftHandSide(this);
		}
	}

	public final PriorityUnionLeftHandSideContext priorityUnionLeftHandSide() throws RecognitionException {
		PriorityUnionLeftHandSideContext _localctx = new PriorityUnionLeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_priorityUnionLeftHandSide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			openingWedge();
			setState(609);
			constituent();
			setState(610);
			featurePath();
			setState(611);
			closingWedge();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PriorityUnionRightHandSideContext extends ParserRuleContext {
		public OpeningWedgeContext openingWedge() {
			return getRuleContext(OpeningWedgeContext.class,0);
		}
		public ConstituentContext constituent() {
			return getRuleContext(ConstituentContext.class,0);
		}
		public ClosingWedgeContext closingWedge() {
			return getRuleContext(ClosingWedgeContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public AtomicValueContext atomicValue() {
			return getRuleContext(AtomicValueContext.class,0);
		}
		public PriorityUnionRightHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priorityUnionRightHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterPriorityUnionRightHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitPriorityUnionRightHandSide(this);
		}
	}

	public final PriorityUnionRightHandSideContext priorityUnionRightHandSide() throws RecognitionException {
		PriorityUnionRightHandSideContext _localctx = new PriorityUnionRightHandSideContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_priorityUnionRightHandSide);
		int _la;
		try {
			setState(621);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(613);
				openingWedge();
				setState(614);
				constituent();
				setState(616);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
					{
					setState(615);
					featurePath();
					}
				}

				setState(618);
				closingWedge();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(620);
				atomicValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalConstraintContext extends ParserRuleContext {
		public LogConstraintLeftHandSideContext logConstraintLeftHandSide() {
			return getRuleContext(LogConstraintLeftHandSideContext.class,0);
		}
		public LogConstraintExpressionContext logConstraintExpression() {
			return getRuleContext(LogConstraintExpressionContext.class,0);
		}
		public LogicalConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLogicalConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLogicalConstraint(this);
		}
	}

	public final LogicalConstraintContext logicalConstraint() throws RecognitionException {
		LogicalConstraintContext _localctx = new LogicalConstraintContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_logicalConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			logConstraintLeftHandSide();
			setState(624);
			match(T__22);
			setState(625);
			logConstraintExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogConstraintLeftHandSideContext extends ParserRuleContext {
		public OpeningWedgeContext openingWedge() {
			return getRuleContext(OpeningWedgeContext.class,0);
		}
		public ConstituentContext constituent() {
			return getRuleContext(ConstituentContext.class,0);
		}
		public ClosingWedgeContext closingWedge() {
			return getRuleContext(ClosingWedgeContext.class,0);
		}
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public LogConstraintLeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logConstraintLeftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLogConstraintLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLogConstraintLeftHandSide(this);
		}
	}

	public final LogConstraintLeftHandSideContext logConstraintLeftHandSide() throws RecognitionException {
		LogConstraintLeftHandSideContext _localctx = new LogConstraintLeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_logConstraintLeftHandSide);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			openingWedge();
			setState(628);
			constituent();
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
				{
				setState(629);
				featurePath();
				}
			}

			setState(632);
			closingWedge();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogConstraintExpressionContext extends ParserRuleContext {
		public List<LogConstraintFactorContext> logConstraintFactor() {
			return getRuleContexts(LogConstraintFactorContext.class);
		}
		public LogConstraintFactorContext logConstraintFactor(int i) {
			return getRuleContext(LogConstraintFactorContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public LogConstraintExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logConstraintExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLogConstraintExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLogConstraintExpression(this);
		}
	}

	public final LogConstraintExpressionContext logConstraintExpression() throws RecognitionException {
		LogConstraintExpressionContext _localctx = new LogConstraintExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_logConstraintExpression);
		try {
			setState(657);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(634);
				logConstraintFactor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(635);
				match(T__23);
				setState(636);
				logConstraintFactor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(637);
				logConstraintFactor();
				setState(638);
				binop();
				setState(639);
				logConstraintFactor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(641);
				match(T__23);
				setState(642);
				logConstraintFactor();
				setState(643);
				binop();
				setState(644);
				logConstraintFactor();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(646);
				logConstraintFactor();
				setState(647);
				binop();
				setState(648);
				match(T__23);
				setState(649);
				logConstraintFactor();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(651);
				match(T__23);
				setState(652);
				logConstraintFactor();
				setState(653);
				binop();
				setState(654);
				match(T__23);
				setState(655);
				logConstraintFactor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogConstraintFactorContext extends ParserRuleContext {
		public FeatureStructureContext featureStructure() {
			return getRuleContext(FeatureStructureContext.class,0);
		}
		public LogConstraintExpressionContext logConstraintExpression() {
			return getRuleContext(LogConstraintExpressionContext.class,0);
		}
		public LogConstraintFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logConstraintFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLogConstraintFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLogConstraintFactor(this);
		}
	}

	public final LogConstraintFactorContext logConstraintFactor() throws RecognitionException {
		LogConstraintFactorContext _localctx = new LogConstraintFactorContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_logConstraintFactor);
		try {
			setState(664);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(659);
				featureStructure();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				match(T__19);
				setState(661);
				logConstraintExpression();
				setState(662);
				match(T__20);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinopContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitBinop(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_binop);
		int _la;
		try {
			setState(694);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(666);
				match(T__24);
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(667);
					comment();
					}
					}
					setState(672);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(673);
				match(T__4);
				setState(677);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(674);
					comment();
					}
					}
					setState(679);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(680);
				match(T__18);
				setState(684);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(681);
					comment();
					}
					}
					setState(686);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(687);
				match(T__25);
				setState(691);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(688);
					comment();
					}
					}
					setState(693);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpeningBraceContext extends ParserRuleContext {
		public OpeningBraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingBrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterOpeningBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitOpeningBrace(this);
		}
	}

	public final OpeningBraceContext openingBrace() throws RecognitionException {
		OpeningBraceContext _localctx = new OpeningBraceContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_openingBrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosingBraceContext extends ParserRuleContext {
		public ClosingBraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingBrace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterClosingBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitClosingBrace(this);
		}
	}

	public final ClosingBraceContext closingBrace() throws RecognitionException {
		ClosingBraceContext _localctx = new ClosingBraceContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_closingBrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpeningBracketContext extends ParserRuleContext {
		public OpeningBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterOpeningBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitOpeningBracket(this);
		}
	}

	public final OpeningBracketContext openingBracket() throws RecognitionException {
		OpeningBracketContext _localctx = new OpeningBracketContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_openingBracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosingBracketContext extends ParserRuleContext {
		public ClosingBracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingBracket; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterClosingBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitClosingBracket(this);
		}
	}

	public final ClosingBracketContext closingBracket() throws RecognitionException {
		ClosingBracketContext _localctx = new ClosingBracketContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_closingBracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpeningParenContext extends ParserRuleContext {
		public OpeningParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterOpeningParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitOpeningParen(this);
		}
	}

	public final OpeningParenContext openingParen() throws RecognitionException {
		OpeningParenContext _localctx = new OpeningParenContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_openingParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosingParenContext extends ParserRuleContext {
		public ClosingParenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingParen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterClosingParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitClosingParen(this);
		}
	}

	public final ClosingParenContext closingParen() throws RecognitionException {
		ClosingParenContext _localctx = new ClosingParenContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_closingParen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpeningWedgeContext extends ParserRuleContext {
		public OpeningWedgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openingWedge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterOpeningWedge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitOpeningWedge(this);
		}
	}

	public final OpeningWedgeContext openingWedge() throws RecognitionException {
		OpeningWedgeContext _localctx = new OpeningWedgeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_openingWedge);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosingWedgeContext extends ParserRuleContext {
		public ClosingWedgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closingWedge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterClosingWedge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitClosingWedge(this);
		}
	}

	public final ClosingWedgeContext closingWedge() throws RecognitionException {
		ClosingWedgeContext _localctx = new ClosingWedgeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_closingWedge);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_parameters);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(713); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(712);
					parameter();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(715); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(720);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(717);
					comment();
					}
					} 
				}
				setState(722);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public ParameterKWContext parameterKW() {
			return getRuleContext(ParameterKWContext.class,0);
		}
		public ParameterNameContext parameterName() {
			return getRuleContext(ParameterNameContext.class,0);
		}
		public List<ParameterValueContext> parameterValue() {
			return getRuleContexts(ParameterValueContext.class);
		}
		public ParameterValueContext parameterValue(int i) {
			return getRuleContext(ParameterValueContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_parameter);
		int _la;
		try {
			int _alt;
			setState(759);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(723);
				parameterKW();
				setState(725);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(724);
					match(T__7);
					}
				}

				setState(727);
				parameterName();
				setState(728);
				match(T__10);
				setState(729);
				parameterValue();
				setState(731);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(730);
					match(T__0);
					}
				}

				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(733);
						comment();
						}
						} 
					}
					setState(738);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(739);
				parameterKW();
				setState(741);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(740);
					match(T__7);
					}
				}

				setState(743);
				match(T__8);
				setState(744);
				match(T__10);
				setState(746); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(745);
					parameterValue();
					}
					}
					setState(748); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TEXT );
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(750);
					match(T__0);
					}
				}

				setState(756);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(753);
						comment();
						}
						} 
					}
					setState(758);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterKWContext extends ParserRuleContext {
		public ParameterKWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterKW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterParameterKW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitParameterKW(this);
		}
	}

	public final ParameterKWContext parameterKW() throws RecognitionException {
		ParameterKWContext _localctx = new ParameterKWContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_parameterKW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterNameContext extends ParserRuleContext {
		public ParameterNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterParameterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitParameterName(this);
		}
	}

	public final ParameterNameContext parameterName() throws RecognitionException {
		ParameterNameContext _localctx = new ParameterNameContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_parameterName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterValueContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PcPatrGrammarParser.TEXT, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public ParameterValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterParameterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitParameterValue(this);
		}
	}

	public final ParameterValueContext parameterValue() throws RecognitionException {
		ParameterValueContext _localctx = new ParameterValueContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_parameterValue);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			match(TEXT);
			setState(769);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(766);
					comment();
					}
					} 
				}
				setState(771);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRulesContext extends ParserRuleContext {
		public List<LexicalRuleContext> lexicalRule() {
			return getRuleContexts(LexicalRuleContext.class);
		}
		public LexicalRuleContext lexicalRule(int i) {
			return getRuleContext(LexicalRuleContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LexicalRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRules(this);
		}
	}

	public final LexicalRulesContext lexicalRules() throws RecognitionException {
		LexicalRulesContext _localctx = new LexicalRulesContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_lexicalRules);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(773); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(772);
					lexicalRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(775); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(780);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(777);
					comment();
					}
					} 
				}
				setState(782);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleContext extends ParserRuleContext {
		public LexicalRuleKWContext lexicalRuleKW() {
			return getRuleContext(LexicalRuleKWContext.class,0);
		}
		public LexicalRuleNameContext lexicalRuleName() {
			return getRuleContext(LexicalRuleNameContext.class,0);
		}
		public LexicalRuleDefinitionContext lexicalRuleDefinition() {
			return getRuleContext(LexicalRuleDefinitionContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LexicalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRule(this);
		}
	}

	public final LexicalRuleContext lexicalRule() throws RecognitionException {
		LexicalRuleContext _localctx = new LexicalRuleContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_lexicalRule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			lexicalRuleKW();
			setState(784);
			lexicalRuleName();
			setState(785);
			match(T__36);
			setState(786);
			lexicalRuleDefinition();
			setState(788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(787);
				match(T__0);
				}
			}

			setState(793);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(790);
					comment();
					}
					} 
				}
				setState(795);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleKWContext extends ParserRuleContext {
		public LexicalRuleKWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleKW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleKW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleKW(this);
		}
	}

	public final LexicalRuleKWContext lexicalRuleKW() throws RecognitionException {
		LexicalRuleKWContext _localctx = new LexicalRuleKWContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_lexicalRuleKW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleNameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PcPatrGrammarParser.TEXT, 0); }
		public LexicalRuleNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleName(this);
		}
	}

	public final LexicalRuleNameContext lexicalRuleName() throws RecognitionException {
		LexicalRuleNameContext _localctx = new LexicalRuleNameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_lexicalRuleName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleDefinitionContext extends ParserRuleContext {
		public List<LexicalRuleMappingContext> lexicalRuleMapping() {
			return getRuleContexts(LexicalRuleMappingContext.class);
		}
		public LexicalRuleMappingContext lexicalRuleMapping(int i) {
			return getRuleContext(LexicalRuleMappingContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LexicalRuleDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleDefinition(this);
		}
	}

	public final LexicalRuleDefinitionContext lexicalRuleDefinition() throws RecognitionException {
		LexicalRuleDefinitionContext _localctx = new LexicalRuleDefinitionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_lexicalRuleDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(801); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(800);
				lexicalRuleMapping();
				}
				}
				setState(803); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__26 );
			setState(808);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(805);
					comment();
					}
					} 
				}
				setState(810);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleMappingContext extends ParserRuleContext {
		public LexicalRuleOutputContext lexicalRuleOutput() {
			return getRuleContext(LexicalRuleOutputContext.class,0);
		}
		public LexicalRuleAssignmentContext lexicalRuleAssignment() {
			return getRuleContext(LexicalRuleAssignmentContext.class,0);
		}
		public LexicalRuleInputContext lexicalRuleInput() {
			return getRuleContext(LexicalRuleInputContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LexicalRuleMappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleMapping; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleMapping(this);
		}
	}

	public final LexicalRuleMappingContext lexicalRuleMapping() throws RecognitionException {
		LexicalRuleMappingContext _localctx = new LexicalRuleMappingContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_lexicalRuleMapping);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			lexicalRuleOutput();
			setState(812);
			lexicalRuleAssignment();
			setState(813);
			lexicalRuleInput();
			setState(817);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(814);
					comment();
					}
					} 
				}
				setState(819);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleAssignmentContext extends ParserRuleContext {
		public LexicalRuleAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleAssignment(this);
		}
	}

	public final LexicalRuleAssignmentContext lexicalRuleAssignment() throws RecognitionException {
		LexicalRuleAssignmentContext _localctx = new LexicalRuleAssignmentContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_lexicalRuleAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__40) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleOutputContext extends ParserRuleContext {
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LexicalRuleOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleOutput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleOutput(this);
		}
	}

	public final LexicalRuleOutputContext lexicalRuleOutput() throws RecognitionException {
		LexicalRuleOutputContext _localctx = new LexicalRuleOutputContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_lexicalRuleOutput);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(T__26);
			setState(823);
			match(T__11);
			setState(824);
			featurePath();
			setState(825);
			match(T__27);
			setState(829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(826);
				comment();
				}
				}
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexicalRuleInputContext extends ParserRuleContext {
		public FeaturePathContext featurePath() {
			return getRuleContext(FeaturePathContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public LexicalRuleInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexicalRuleInput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterLexicalRuleInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitLexicalRuleInput(this);
		}
	}

	public final LexicalRuleInputContext lexicalRuleInput() throws RecognitionException {
		LexicalRuleInputContext _localctx = new LexicalRuleInputContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_lexicalRuleInput);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
			match(T__26);
			setState(833);
			match(T__9);
			setState(834);
			featurePath();
			setState(835);
			match(T__27);
			setState(839);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(836);
					comment();
					}
					} 
				}
				setState(841);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTemplatesContext extends ParserRuleContext {
		public List<ConstraintTemplateContext> constraintTemplate() {
			return getRuleContexts(ConstraintTemplateContext.class);
		}
		public ConstraintTemplateContext constraintTemplate(int i) {
			return getRuleContext(ConstraintTemplateContext.class,i);
		}
		public ConstraintTemplatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintTemplates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterConstraintTemplates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitConstraintTemplates(this);
		}
	}

	public final ConstraintTemplatesContext constraintTemplates() throws RecognitionException {
		ConstraintTemplatesContext _localctx = new ConstraintTemplatesContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_constraintTemplates);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(843); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(842);
					constraintTemplate();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(845); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTemplateContext extends ParserRuleContext {
		public ConstraintTemplateKWContext constraintTemplateKW() {
			return getRuleContext(ConstraintTemplateKWContext.class,0);
		}
		public ConstraintTemplateNameContext constraintTemplateName() {
			return getRuleContext(ConstraintTemplateNameContext.class,0);
		}
		public LogConstraintExpressionContext logConstraintExpression() {
			return getRuleContext(LogConstraintExpressionContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public ConstraintTemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintTemplate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterConstraintTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitConstraintTemplate(this);
		}
	}

	public final ConstraintTemplateContext constraintTemplate() throws RecognitionException {
		ConstraintTemplateContext _localctx = new ConstraintTemplateContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_constraintTemplate);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
			constraintTemplateKW();
			setState(848);
			constraintTemplateName();
			setState(849);
			match(T__10);
			setState(850);
			logConstraintExpression();
			setState(852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(851);
				match(T__0);
				}
			}

			setState(857);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(854);
					comment();
					}
					} 
				}
				setState(859);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,114,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTemplateKWContext extends ParserRuleContext {
		public ConstraintTemplateKWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintTemplateKW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterConstraintTemplateKW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitConstraintTemplateKW(this);
		}
	}

	public final ConstraintTemplateKWContext constraintTemplateKW() throws RecognitionException {
		ConstraintTemplateKWContext _localctx = new ConstraintTemplateKWContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_constraintTemplateKW);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTemplateNameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PcPatrGrammarParser.TEXT, 0); }
		public ConstraintTemplateNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintTemplateName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).enterConstraintTemplateName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PcPatrGrammarListener ) ((PcPatrGrammarListener)listener).exitConstraintTemplateName(this);
		}
	}

	public final ConstraintTemplateNameContext constraintTemplateName() throws RecognitionException {
		ConstraintTemplateNameContext _localctx = new ConstraintTemplateNameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_constraintTemplateName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0363\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\3\2\7\2\u0098\n\2\f\2\16\2\u009b\13\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\u00a2\n\2\f\2\16\2\u00a5\13\2\3\2\7\2\u00a8\n\2\f\2\16\2\u00ab"+
		"\13\2\3\2\3\2\3\3\3\3\3\4\6\4\u00b2\n\4\r\4\16\4\u00b3\3\5\3\5\3\5\5\5"+
		"\u00b9\n\5\3\5\5\5\u00bc\n\5\3\5\7\5\u00bf\n\5\f\5\16\5\u00c2\13\5\3\6"+
		"\3\6\3\6\5\6\u00c7\n\6\3\6\3\6\5\6\u00cb\n\6\3\7\3\7\3\7\3\7\5\7\u00d1"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u00d7\n\7\3\7\3\7\5\7\u00db\n\7\3\7\3\7\5\7\u00df"+
		"\n\7\5\7\u00e1\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u00ea\n\t\3\n\3\n\3"+
		"\n\3\n\7\n\u00f0\n\n\f\n\16\n\u00f3\13\n\3\n\3\n\7\n\u00f7\n\n\f\n\16"+
		"\n\u00fa\13\n\5\n\u00fc\n\n\3\13\3\13\3\13\5\13\u0101\n\13\3\13\7\13\u0104"+
		"\n\13\f\13\16\13\u0107\13\13\3\13\3\13\5\13\u010b\n\13\3\13\7\13\u010e"+
		"\n\13\f\13\16\13\u0111\13\13\5\13\u0113\n\13\3\f\3\f\3\f\6\f\u0118\n\f"+
		"\r\f\16\f\u0119\3\f\3\f\3\r\3\r\3\r\6\r\u0121\n\r\r\r\16\r\u0122\3\r\3"+
		"\r\3\16\3\16\7\16\u0129\n\16\f\16\16\16\u012c\13\16\3\16\3\16\7\16\u0130"+
		"\n\16\f\16\16\16\u0133\13\16\3\16\3\16\7\16\u0137\n\16\f\16\16\16\u013a"+
		"\13\16\3\16\3\16\7\16\u013e\n\16\f\16\16\16\u0141\13\16\5\16\u0143\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u014a\n\17\f\17\16\17\u014d\13\17\3\17"+
		"\3\17\7\17\u0151\n\17\f\17\16\17\u0154\13\17\3\17\3\17\7\17\u0158\n\17"+
		"\f\17\16\17\u015b\13\17\5\17\u015d\n\17\3\20\3\20\5\20\u0161\n\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u016f\n\21"+
		"\3\22\3\22\3\22\3\22\7\22\u0175\n\22\f\22\16\22\u0178\13\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\6\25\u0181\n\25\r\25\16\25\u0182\3\26\7\26\u0186"+
		"\n\26\f\26\16\26\u0189\13\26\3\26\3\26\5\26\u018d\n\26\3\26\7\26\u0190"+
		"\n\26\f\26\16\26\u0193\13\26\3\26\3\26\7\26\u0197\n\26\f\26\16\26\u019a"+
		"\13\26\3\26\5\26\u019d\n\26\3\26\7\26\u01a0\n\26\f\26\16\26\u01a3\13\26"+
		"\3\26\5\26\u01a6\n\26\3\27\3\27\3\30\3\30\7\30\u01ac\n\30\f\30\16\30\u01af"+
		"\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\6\34\u01c0\n\34\r\34\16\34\u01c1\3\35\3\35\3\35\3\35\6\35\u01c8"+
		"\n\35\r\35\16\35\u01c9\3\35\6\35\u01cd\n\35\r\35\16\35\u01ce\3\35\3\35"+
		"\5\35\u01d3\n\35\3\36\3\36\7\36\u01d7\n\36\f\36\16\36\u01da\13\36\3\36"+
		"\3\36\3\36\6\36\u01df\n\36\r\36\16\36\u01e0\3\36\5\36\u01e4\n\36\3\37"+
		"\3\37\3\37\3\37\3\37\6\37\u01eb\n\37\r\37\16\37\u01ec\3\37\3\37\5\37\u01f1"+
		"\n\37\3 \3 \6 \u01f5\n \r \16 \u01f6\3 \6 \u01fa\n \r \16 \u01fb\3 \3"+
		" \5 \u0200\n \3!\3!\7!\u0204\n!\f!\16!\u0207\13!\3!\6!\u020a\n!\r!\16"+
		"!\u020b\3!\5!\u020f\n!\3\"\3\"\3\"\3\"\6\"\u0215\n\"\r\"\16\"\u0216\3"+
		"#\3#\3#\3#\5#\u021d\n#\3#\5#\u0220\n#\3$\3$\3$\3$\3$\3%\3%\3%\5%\u022a"+
		"\n%\3%\3%\5%\u022e\n%\3%\3%\5%\u0232\n%\5%\u0234\n%\3&\3&\6&\u0238\n&"+
		"\r&\16&\u0239\3&\6&\u023d\n&\r&\16&\u023e\3&\3&\5&\u0243\n&\3\'\3\'\7"+
		"\'\u0247\n\'\f\'\16\'\u024a\13\'\3\'\6\'\u024d\n\'\r\'\16\'\u024e\3\'"+
		"\5\'\u0252\n\'\3(\3(\3(\3(\3(\5(\u0259\n(\3)\3)\3*\3*\3*\3*\5*\u0261\n"+
		"*\3+\3+\3+\3+\3+\3,\3,\3,\5,\u026b\n,\3,\3,\3,\5,\u0270\n,\3-\3-\3-\3"+
		"-\3.\3.\3.\5.\u0279\n.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0294\n/\3\60\3\60\3\60\3\60\3\60\5\60"+
		"\u029b\n\60\3\61\3\61\7\61\u029f\n\61\f\61\16\61\u02a2\13\61\3\61\3\61"+
		"\7\61\u02a6\n\61\f\61\16\61\u02a9\13\61\3\61\3\61\7\61\u02ad\n\61\f\61"+
		"\16\61\u02b0\13\61\3\61\3\61\7\61\u02b4\n\61\f\61\16\61\u02b7\13\61\5"+
		"\61\u02b9\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\6:\u02cc\n:\r:\16:\u02cd\3:\7:\u02d1\n:\f:\16:\u02d4"+
		"\13:\3;\3;\5;\u02d8\n;\3;\3;\3;\3;\5;\u02de\n;\3;\7;\u02e1\n;\f;\16;\u02e4"+
		"\13;\3;\3;\5;\u02e8\n;\3;\3;\3;\6;\u02ed\n;\r;\16;\u02ee\3;\5;\u02f2\n"+
		";\3;\7;\u02f5\n;\f;\16;\u02f8\13;\5;\u02fa\n;\3<\3<\3=\3=\3>\3>\7>\u0302"+
		"\n>\f>\16>\u0305\13>\3?\6?\u0308\n?\r?\16?\u0309\3?\7?\u030d\n?\f?\16"+
		"?\u0310\13?\3@\3@\3@\3@\3@\5@\u0317\n@\3@\7@\u031a\n@\f@\16@\u031d\13"+
		"@\3A\3A\3B\3B\3C\6C\u0324\nC\rC\16C\u0325\3C\7C\u0329\nC\fC\16C\u032c"+
		"\13C\3D\3D\3D\3D\7D\u0332\nD\fD\16D\u0335\13D\3E\3E\3F\3F\3F\3F\3F\7F"+
		"\u033e\nF\fF\16F\u0341\13F\3G\3G\3G\3G\3G\7G\u0348\nG\fG\16G\u034b\13"+
		"G\3H\6H\u034e\nH\rH\16H\u034f\3I\3I\3I\3I\3I\5I\u0357\nI\3I\7I\u035a\n"+
		"I\fI\16I\u035d\13I\3J\3J\3K\3K\3K\3\u01ad\2L\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|"+
		"~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\2"+
		"\t\3\2\20\22\4\2\6\6\25\25\3\2\37!\3\2\"&\3\2(*\4\2\6\6++\3\2,.\2\u03ad"+
		"\2\u0099\3\2\2\2\4\u00ae\3\2\2\2\6\u00b1\3\2\2\2\b\u00b5\3\2\2\2\n\u00c3"+
		"\3\2\2\2\f\u00e0\3\2\2\2\16\u00e2\3\2\2\2\20\u00e9\3\2\2\2\22\u00fb\3"+
		"\2\2\2\24\u0112\3\2\2\2\26\u0114\3\2\2\2\30\u011d\3\2\2\2\32\u0142\3\2"+
		"\2\2\34\u015c\3\2\2\2\36\u0160\3\2\2\2 \u016e\3\2\2\2\"\u0170\3\2\2\2"+
		"$\u0179\3\2\2\2&\u017b\3\2\2\2(\u0180\3\2\2\2*\u0187\3\2\2\2,\u01a7\3"+
		"\2\2\2.\u01a9\3\2\2\2\60\u01b2\3\2\2\2\62\u01b6\3\2\2\2\64\u01b8\3\2\2"+
		"\2\66\u01bf\3\2\2\28\u01c3\3\2\2\2:\u01d4\3\2\2\2<\u01e5\3\2\2\2>\u01f2"+
		"\3\2\2\2@\u0201\3\2\2\2B\u0214\3\2\2\2D\u021f\3\2\2\2F\u0221\3\2\2\2H"+
		"\u0233\3\2\2\2J\u0235\3\2\2\2L\u0244\3\2\2\2N\u0258\3\2\2\2P\u025a\3\2"+
		"\2\2R\u025c\3\2\2\2T\u0262\3\2\2\2V\u026f\3\2\2\2X\u0271\3\2\2\2Z\u0275"+
		"\3\2\2\2\\\u0293\3\2\2\2^\u029a\3\2\2\2`\u02b8\3\2\2\2b\u02ba\3\2\2\2"+
		"d\u02bc\3\2\2\2f\u02be\3\2\2\2h\u02c0\3\2\2\2j\u02c2\3\2\2\2l\u02c4\3"+
		"\2\2\2n\u02c6\3\2\2\2p\u02c8\3\2\2\2r\u02cb\3\2\2\2t\u02f9\3\2\2\2v\u02fb"+
		"\3\2\2\2x\u02fd\3\2\2\2z\u02ff\3\2\2\2|\u0307\3\2\2\2~\u0311\3\2\2\2\u0080"+
		"\u031e\3\2\2\2\u0082\u0320\3\2\2\2\u0084\u0323\3\2\2\2\u0086\u032d\3\2"+
		"\2\2\u0088\u0336\3\2\2\2\u008a\u0338\3\2\2\2\u008c\u0342\3\2\2\2\u008e"+
		"\u034d\3\2\2\2\u0090\u0351\3\2\2\2\u0092\u035e\3\2\2\2\u0094\u0360\3\2"+
		"\2\2\u0096\u0098\5\4\3\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a3\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009c\u00a2\5\6\4\2\u009d\u00a2\5\u008eH\2\u009e\u00a2\5(\25\2\u009f"+
		"\u00a2\5r:\2\u00a0\u00a2\5|?\2\u00a1\u009c\3\2\2\2\u00a1\u009d\3\2\2\2"+
		"\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a9\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a6\u00a8\5\4\3\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ac\u00ad\7\2\2\3\u00ad\3\3\2\2\2\u00ae\u00af\7/\2\2"+
		"\u00af\5\3\2\2\2\u00b0\u00b2\5\b\5\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\7\3\2\2\2\u00b5\u00b8"+
		"\5\n\6\2\u00b6\u00b9\5\f\7\2\u00b7\u00b9\5\16\b\2\u00b8\u00b6\3\2\2\2"+
		"\u00b8\u00b7\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00bc\7\3\2\2\u00bb\u00ba"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c0\3\2\2\2\u00bd\u00bf\5\4\3\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\t\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7\4\2\2\u00c4\u00c6"+
		"\5\20\t\2\u00c5\u00c7\5\4\3\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00ca\7\5\2\2\u00c9\u00cb\5\4\3\2\u00ca\u00c9"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\13\3\2\2\2\u00cc\u00cd\5&\24\2\u00cd"+
		"\u00ce\7\6\2\2\u00ce\u00d0\5\26\f\2\u00cf\u00d1\5\f\7\2\u00d0\u00cf\3"+
		"\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00e1\3\2\2\2\u00d2\u00d3\5&\24\2\u00d3"+
		"\u00d4\7\6\2\2\u00d4\u00d6\5\24\13\2\u00d5\u00d7\5\f\7\2\u00d6\u00d5\3"+
		"\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e1\3\2\2\2\u00d8\u00da\5\22\n\2\u00d9"+
		"\u00db\5\f\7\2\u00da\u00d9\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00e1\3\2"+
		"\2\2\u00dc\u00de\5\30\r\2\u00dd\u00df\5\f\7\2\u00de\u00dd\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00cc\3\2\2\2\u00e0\u00d2\3\2"+
		"\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\r\3\2\2\2\u00e2\u00e3"+
		"\5\34\17\2\u00e3\17\3\2\2\2\u00e4\u00ea\5P)\2\u00e5\u00e6\5P)\2\u00e6"+
		"\u00e7\7\7\2\2\u00e7\u00e8\5P)\2\u00e8\u00ea\3\2\2\2\u00e9\u00e4\3\2\2"+
		"\2\u00e9\u00e5\3\2\2\2\u00ea\21\3\2\2\2\u00eb\u00ec\7\b\2\2\u00ec\u00ed"+
		"\5\20\t\2\u00ed\u00f1\7\t\2\2\u00ee\u00f0\5\4\3\2\u00ef\u00ee\3\2\2\2"+
		"\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00fc"+
		"\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f8\5\20\t\2\u00f5\u00f7\5\4\3\2"+
		"\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00eb\3\2\2\2\u00fb"+
		"\u00f4\3\2\2\2\u00fc\23\3\2\2\2\u00fd\u0113\5\30\r\2\u00fe\u0100\5&\24"+
		"\2\u00ff\u0101\7\3\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0105"+
		"\3\2\2\2\u0102\u0104\5\4\3\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0113\3\2\2\2\u0107\u0105\3\2"+
		"\2\2\u0108\u010a\5P)\2\u0109\u010b\7\3\2\2\u010a\u0109\3\2\2\2\u010a\u010b"+
		"\3\2\2\2\u010b\u010f\3\2\2\2\u010c\u010e\5\4\3\2\u010d\u010c\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0113\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0112\u00fd\3\2\2\2\u0112\u00fe\3\2\2\2\u0112"+
		"\u0108\3\2\2\2\u0113\25\3\2\2\2\u0114\u0115\5b\62\2\u0115\u0117\5P)\2"+
		"\u0116\u0118\5P)\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117"+
		"\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\5d\63\2\u011c"+
		"\27\3\2\2\2\u011d\u011e\5b\62\2\u011e\u0120\5\32\16\2\u011f\u0121\5\32"+
		"\16\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\5d\63\2\u0125\31\3\2\2"+
		"\2\u0126\u012a\5N(\2\u0127\u0129\5\4\3\2\u0128\u0127\3\2\2\2\u0129\u012c"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0143\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u0131\5\34\17\2\u012e\u0130\5\4\3\2\u012f\u012e\3"+
		"\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0143\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0138\5P)\2\u0135\u0137\5\4\3"+
		"\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139"+
		"\3\2\2\2\u0139\u0143\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013f\5\22\n\2"+
		"\u013c\u013e\5\4\3\2\u013d\u013c\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d"+
		"\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0142"+
		"\u0126\3\2\2\2\u0142\u012d\3\2\2\2\u0142\u0134\3\2\2\2\u0142\u013b\3\2"+
		"\2\2\u0143\33\3\2\2\2\u0144\u0145\5f\64\2\u0145\u0146\5\36\20\2\u0146"+
		"\u0147\7\n\2\2\u0147\u014b\5 \21\2\u0148\u014a\5\"\22\2\u0149\u0148\3"+
		"\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0152\5h\65\2\u014f\u0151\5\4"+
		"\3\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u015d\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0159\5$"+
		"\23\2\u0156\u0158\5\4\3\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015c\u0144\3\2\2\2\u015c\u0155\3\2\2\2\u015d\35\3\2\2\2\u015e\u0161"+
		"\5,\27\2\u015f\u0161\5P)\2\u0160\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161"+
		"\37\3\2\2\2\u0162\u016f\5\34\17\2\u0163\u016f\5P)\2\u0164\u016f\7\13\2"+
		"\2\u0165\u016f\7\5\2\2\u0166\u016f\7\f\2\2\u0167\u016f\7\r\2\2\u0168\u016f"+
		"\7\16\2\2\u0169\u016f\5\u0092J\2\u016a\u016f\5\u0080A\2\u016b\u016f\5"+
		"v<\2\u016c\u016f\5x=\2\u016d\u016f\5,\27\2\u016e\u0162\3\2\2\2\u016e\u0163"+
		"\3\2\2\2\u016e\u0164\3\2\2\2\u016e\u0165\3\2\2\2\u016e\u0166\3\2\2\2\u016e"+
		"\u0167\3\2\2\2\u016e\u0168\3\2\2\2\u016e\u0169\3\2\2\2\u016e\u016a\3\2"+
		"\2\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2\2\u016f"+
		"!\3\2\2\2\u0170\u0171\5\36\20\2\u0171\u0172\7\n\2\2\u0172\u0176\5 \21"+
		"\2\u0173\u0175\5\4\3\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177#\3\2\2\2\u0178\u0176\3\2\2\2\u0179"+
		"\u017a\7\17\2\2\u017a%\3\2\2\2\u017b\u017c\5n8\2\u017c\u017d\5N(\2\u017d"+
		"\u017e\5p9\2\u017e\'\3\2\2\2\u017f\u0181\5*\26\2\u0180\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183)\3\2\2\2"+
		"\u0184\u0186\5\4\3\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185"+
		"\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a"+
		"\u018c\5,\27\2\u018b\u018d\5.\30\2\u018c\u018b\3\2\2\2\u018c\u018d\3\2"+
		"\2\2\u018d\u0191\3\2\2\2\u018e\u0190\5\4\3\2\u018f\u018e\3\2\2\2\u0190"+
		"\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0194\3\2"+
		"\2\2\u0193\u0191\3\2\2\2\u0194\u0198\5\60\31\2\u0195\u0197\5\4\3\2\u0196"+
		"\u0195\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2"+
		"\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019d\5B\"\2\u019c"+
		"\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a1\3\2\2\2\u019e\u01a0\5\4"+
		"\3\2\u019f\u019e\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a6\7\3"+
		"\2\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6+\3\2\2\2\u01a7\u01a8"+
		"\t\2\2\2\u01a8-\3\2\2\2\u01a9\u01ad\7\23\2\2\u01aa\u01ac\13\2\2\2\u01ab"+
		"\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ad\u01ab\3\2"+
		"\2\2\u01ae\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7\24\2\2\u01b1"+
		"/\3\2\2\2\u01b2\u01b3\5\64\33\2\u01b3\u01b4\5\62\32\2\u01b4\u01b5\5\66"+
		"\34\2\u01b5\61\3\2\2\2\u01b6\u01b7\t\3\2\2\u01b7\63\3\2\2\2\u01b8\u01b9"+
		"\7\60\2\2\u01b9\65\3\2\2\2\u01ba\u01c0\5\64\33\2\u01bb\u01c0\58\35\2\u01bc"+
		"\u01c0\5<\37\2\u01bd\u01c0\5> \2\u01be\u01c0\5:\36\2\u01bf\u01ba\3\2\2"+
		"\2\u01bf\u01bb\3\2\2\2\u01bf\u01bc\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01be"+
		"\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\67\3\2\2\2\u01c3\u01c7\7\23\2\2\u01c4\u01c8\5\64\33\2\u01c5\u01c8\5<"+
		"\37\2\u01c6\u01c8\58\35\2\u01c7\u01c4\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7"+
		"\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2"+
		"\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01cd\5:\36\2\u01cc\u01cb\3\2\2\2\u01cd"+
		"\u01ce\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2"+
		"\2\2\u01d0\u01d2\7\24\2\2\u01d1\u01d3\5\4\3\2\u01d2\u01d1\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d39\3\2\2\2\u01d4\u01d8\7\7\2\2\u01d5\u01d7\5\4\3\2"+
		"\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9"+
		"\3\2\2\2\u01d9\u01de\3\2\2\2\u01da\u01d8\3\2\2\2\u01db\u01df\5\64\33\2"+
		"\u01dc\u01df\58\35\2\u01dd\u01df\5<\37\2\u01de\u01db\3\2\2\2\u01de\u01dc"+
		"\3\2\2\2\u01de\u01dd\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01de\3\2\2\2\u01e0"+
		"\u01e1\3\2\2\2\u01e1\u01e3\3\2\2\2\u01e2\u01e4\5\4\3\2\u01e3\u01e2\3\2"+
		"\2\2\u01e3\u01e4\3\2\2\2\u01e4;\3\2\2\2\u01e5\u01ea\7\26\2\2\u01e6\u01eb"+
		"\5\64\33\2\u01e7\u01eb\58\35\2\u01e8\u01eb\5<\37\2\u01e9\u01eb\5@!\2\u01ea"+
		"\u01e6\3\2\2\2\u01ea\u01e7\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2"+
		"\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u01f0\7\27\2\2\u01ef\u01f1\5\4\3\2\u01f0\u01ef\3"+
		"\2\2\2\u01f0\u01f1\3\2\2\2\u01f1=\3\2\2\2\u01f2\u01f4\7\26\2\2\u01f3\u01f5"+
		"\5\64\33\2\u01f4\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f4\3\2\2\2"+
		"\u01f6\u01f7\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01fa\5@!\2\u01f9\u01f8"+
		"\3\2\2\2\u01fa\u01fb\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u01ff\7\27\2\2\u01fe\u0200\5\4\3\2\u01ff\u01fe\3"+
		"\2\2\2\u01ff\u0200\3\2\2\2\u0200?\3\2\2\2\u0201\u0205\7\7\2\2\u0202\u0204"+
		"\5\4\3\2\u0203\u0202\3\2\2\2\u0204\u0207\3\2\2\2\u0205\u0203\3\2\2\2\u0205"+
		"\u0206\3\2\2\2\u0206\u0209\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u020a\5\64"+
		"\33\2\u0209\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u0209\3\2\2\2\u020b"+
		"\u020c\3\2\2\2\u020c\u020e\3\2\2\2\u020d\u020f\5\4\3\2\u020e\u020d\3\2"+
		"\2\2\u020e\u020f\3\2\2\2\u020fA\3\2\2\2\u0210\u0215\5D#\2\u0211\u0215"+
		"\5R*\2\u0212\u0215\5X-\2\u0213\u0215\5\4\3\2\u0214\u0210\3\2\2\2\u0214"+
		"\u0211\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0213\3\2\2\2\u0215\u0216\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217C\3\2\2\2\u0218\u0219"+
		"\5F$\2\u0219\u021a\7\6\2\2\u021a\u021c\5H%\2\u021b\u021d\5\4\3\2\u021c"+
		"\u021b\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u0220\3\2\2\2\u021e\u0220\5J"+
		"&\2\u021f\u0218\3\2\2\2\u021f\u021e\3\2\2\2\u0220E\3\2\2\2\u0221\u0222"+
		"\5n8\2\u0222\u0223\5\64\33\2\u0223\u0224\5N(\2\u0224\u0225\5p9\2\u0225"+
		"G\3\2\2\2\u0226\u0227\5n8\2\u0227\u0229\5\64\33\2\u0228\u022a\5N(\2\u0229"+
		"\u0228\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022d\5p"+
		"9\2\u022c\u022e\5\4\3\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e"+
		"\u0234\3\2\2\2\u022f\u0231\5P)\2\u0230\u0232\5\4\3\2\u0231\u0230\3\2\2"+
		"\2\u0231\u0232\3\2\2\2\u0232\u0234\3\2\2\2\u0233\u0226\3\2\2\2\u0233\u022f"+
		"\3\2\2\2\u0234I\3\2\2\2\u0235\u0237\7\23\2\2\u0236\u0238\5D#\2\u0237\u0236"+
		"\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a"+
		"\u023c\3\2\2\2\u023b\u023d\5L\'\2\u023c\u023b\3\2\2\2\u023d\u023e\3\2"+
		"\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2\2\2\u023f\u0240\3\2\2\2\u0240"+
		"\u0242\7\24\2\2\u0241\u0243\5\4\3\2\u0242\u0241\3\2\2\2\u0242\u0243\3"+
		"\2\2\2\u0243K\3\2\2\2\u0244\u0248\7\7\2\2\u0245\u0247\5\4\3\2\u0246\u0245"+
		"\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u024d\5D#\2\u024c\u024b\3\2\2"+
		"\2\u024d\u024e\3\2\2\2\u024e\u024c\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0251"+
		"\3\2\2\2\u0250\u0252\5\4\3\2\u0251\u0250\3\2\2\2\u0251\u0252\3\2\2\2\u0252"+
		"M\3\2\2\2\u0253\u0259\5,\27\2\u0254\u0255\5P)\2\u0255\u0256\5N(\2\u0256"+
		"\u0259\3\2\2\2\u0257\u0259\5P)\2\u0258\u0253\3\2\2\2\u0258\u0254\3\2\2"+
		"\2\u0258\u0257\3\2\2\2\u0259O\3\2\2\2\u025a\u025b\7\60\2\2\u025bQ\3\2"+
		"\2\2\u025c\u025d\5T+\2\u025d\u025e\7\30\2\2\u025e\u0260\5V,\2\u025f\u0261"+
		"\5\4\3\2\u0260\u025f\3\2\2\2\u0260\u0261\3\2\2\2\u0261S\3\2\2\2\u0262"+
		"\u0263\5n8\2\u0263\u0264\5\64\33\2\u0264\u0265\5N(\2\u0265\u0266\5p9\2"+
		"\u0266U\3\2\2\2\u0267\u0268\5n8\2\u0268\u026a\5\64\33\2\u0269\u026b\5"+
		"N(\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2\u026b\u026c\3\2\2\2\u026c"+
		"\u026d\5p9\2\u026d\u0270\3\2\2\2\u026e\u0270\5P)\2\u026f\u0267\3\2\2\2"+
		"\u026f\u026e\3\2\2\2\u0270W\3\2\2\2\u0271\u0272\5Z.\2\u0272\u0273\7\31"+
		"\2\2\u0273\u0274\5\\/\2\u0274Y\3\2\2\2\u0275\u0276\5n8\2\u0276\u0278\5"+
		"\64\33\2\u0277\u0279\5N(\2\u0278\u0277\3\2\2\2\u0278\u0279\3\2\2\2\u0279"+
		"\u027a\3\2\2\2\u027a\u027b\5p9\2\u027b[\3\2\2\2\u027c\u0294\5^\60\2\u027d"+
		"\u027e\7\32\2\2\u027e\u0294\5^\60\2\u027f\u0280\5^\60\2\u0280\u0281\5"+
		"`\61\2\u0281\u0282\5^\60\2\u0282\u0294\3\2\2\2\u0283\u0284\7\32\2\2\u0284"+
		"\u0285\5^\60\2\u0285\u0286\5`\61\2\u0286\u0287\5^\60\2\u0287\u0294\3\2"+
		"\2\2\u0288\u0289\5^\60\2\u0289\u028a\5`\61\2\u028a\u028b\7\32\2\2\u028b"+
		"\u028c\5^\60\2\u028c\u0294\3\2\2\2\u028d\u028e\7\32\2\2\u028e\u028f\5"+
		"^\60\2\u028f\u0290\5`\61\2\u0290\u0291\7\32\2\2\u0291\u0292\5^\60\2\u0292"+
		"\u0294\3\2\2\2\u0293\u027c\3\2\2\2\u0293\u027d\3\2\2\2\u0293\u027f\3\2"+
		"\2\2\u0293\u0283\3\2\2\2\u0293\u0288\3\2\2\2\u0293\u028d\3\2\2\2\u0294"+
		"]\3\2\2\2\u0295\u029b\5\34\17\2\u0296\u0297\7\26\2\2\u0297\u0298\5\\/"+
		"\2\u0298\u0299\7\27\2\2\u0299\u029b\3\2\2\2\u029a\u0295\3\2\2\2\u029a"+
		"\u0296\3\2\2\2\u029b_\3\2\2\2\u029c\u02a0\7\33\2\2\u029d\u029f\5\4\3\2"+
		"\u029e\u029d\3\2\2\2\u029f\u02a2\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u02a1"+
		"\3\2\2\2\u02a1\u02b9\3\2\2\2\u02a2\u02a0\3\2\2\2\u02a3\u02a7\7\7\2\2\u02a4"+
		"\u02a6\5\4\3\2\u02a5\u02a4\3\2\2\2\u02a6\u02a9\3\2\2\2\u02a7\u02a5\3\2"+
		"\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02b9\3\2\2\2\u02a9\u02a7\3\2\2\2\u02aa"+
		"\u02ae\7\25\2\2\u02ab\u02ad\5\4\3\2\u02ac\u02ab\3\2\2\2\u02ad\u02b0\3"+
		"\2\2\2\u02ae\u02ac\3\2\2\2\u02ae\u02af\3\2\2\2\u02af\u02b9\3\2\2\2\u02b0"+
		"\u02ae\3\2\2\2\u02b1\u02b5\7\34\2\2\u02b2\u02b4\5\4\3\2\u02b3\u02b2\3"+
		"\2\2\2\u02b4\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6"+
		"\u02b9\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b8\u029c\3\2\2\2\u02b8\u02a3\3\2"+
		"\2\2\u02b8\u02aa\3\2\2\2\u02b8\u02b1\3\2\2\2\u02b9a\3\2\2\2\u02ba\u02bb"+
		"\7\23\2\2\u02bbc\3\2\2\2\u02bc\u02bd\7\24\2\2\u02bde\3\2\2\2\u02be\u02bf"+
		"\7\b\2\2\u02bfg\3\2\2\2\u02c0\u02c1\7\t\2\2\u02c1i\3\2\2\2\u02c2\u02c3"+
		"\7\26\2\2\u02c3k\3\2\2\2\u02c4\u02c5\7\27\2\2\u02c5m\3\2\2\2\u02c6\u02c7"+
		"\7\35\2\2\u02c7o\3\2\2\2\u02c8\u02c9\7\36\2\2\u02c9q\3\2\2\2\u02ca\u02cc"+
		"\5t;\2\u02cb\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cb\3\2\2\2\u02cd"+
		"\u02ce\3\2\2\2\u02ce\u02d2\3\2\2\2\u02cf\u02d1\5\4\3\2\u02d0\u02cf\3\2"+
		"\2\2\u02d1\u02d4\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3"+
		"s\3\2\2\2\u02d4\u02d2\3\2\2\2\u02d5\u02d7\5v<\2\u02d6\u02d8\7\n\2\2\u02d7"+
		"\u02d6\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u02da\5x"+
		"=\2\u02da\u02db\7\r\2\2\u02db\u02dd\5z>\2\u02dc\u02de\7\3\2\2\u02dd\u02dc"+
		"\3\2\2\2\u02dd\u02de\3\2\2\2\u02de\u02e2\3\2\2\2\u02df\u02e1\5\4\3\2\u02e0"+
		"\u02df\3\2\2\2\u02e1\u02e4\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2"+
		"\2\2\u02e3\u02fa\3\2\2\2\u02e4\u02e2\3\2\2\2\u02e5\u02e7\5v<\2\u02e6\u02e8"+
		"\7\n\2\2\u02e7\u02e6\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9"+
		"\u02ea\7\13\2\2\u02ea\u02ec\7\r\2\2\u02eb\u02ed\5z>\2\u02ec\u02eb\3\2"+
		"\2\2\u02ed\u02ee\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef"+
		"\u02f1\3\2\2\2\u02f0\u02f2\7\3\2\2\u02f1\u02f0\3\2\2\2\u02f1\u02f2\3\2"+
		"\2\2\u02f2\u02f6\3\2\2\2\u02f3\u02f5\5\4\3\2\u02f4\u02f3\3\2\2\2\u02f5"+
		"\u02f8\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02fa\3\2"+
		"\2\2\u02f8\u02f6\3\2\2\2\u02f9\u02d5\3\2\2\2\u02f9\u02e5\3\2\2\2\u02fa"+
		"u\3\2\2\2\u02fb\u02fc\t\4\2\2\u02fcw\3\2\2\2\u02fd\u02fe\t\5\2\2\u02fe"+
		"y\3\2\2\2\u02ff\u0303\7\60\2\2\u0300\u0302\5\4\3\2\u0301\u0300\3\2\2\2"+
		"\u0302\u0305\3\2\2\2\u0303\u0301\3\2\2\2\u0303\u0304\3\2\2\2\u0304{\3"+
		"\2\2\2\u0305\u0303\3\2\2\2\u0306\u0308\5~@\2\u0307\u0306\3\2\2\2\u0308"+
		"\u0309\3\2\2\2\u0309\u0307\3\2\2\2\u0309\u030a\3\2\2\2\u030a\u030e\3\2"+
		"\2\2\u030b\u030d\5\4\3\2\u030c\u030b\3\2\2\2\u030d\u0310\3\2\2\2\u030e"+
		"\u030c\3\2\2\2\u030e\u030f\3\2\2\2\u030f}\3\2\2\2\u0310\u030e\3\2\2\2"+
		"\u0311\u0312\5\u0080A\2\u0312\u0313\5\u0082B\2\u0313\u0314\7\'\2\2\u0314"+
		"\u0316\5\u0084C\2\u0315\u0317\7\3\2\2\u0316\u0315\3\2\2\2\u0316\u0317"+
		"\3\2\2\2\u0317\u031b\3\2\2\2\u0318\u031a\5\4\3\2\u0319\u0318\3\2\2\2\u031a"+
		"\u031d\3\2\2\2\u031b\u0319\3\2\2\2\u031b\u031c\3\2\2\2\u031c\177\3\2\2"+
		"\2\u031d\u031b\3\2\2\2\u031e\u031f\t\6\2\2\u031f\u0081\3\2\2\2\u0320\u0321"+
		"\7\60\2\2\u0321\u0083\3\2\2\2\u0322\u0324\5\u0086D\2\u0323\u0322\3\2\2"+
		"\2\u0324\u0325\3\2\2\2\u0325\u0323\3\2\2\2\u0325\u0326\3\2\2\2\u0326\u032a"+
		"\3\2\2\2\u0327\u0329\5\4\3\2\u0328\u0327\3\2\2\2\u0329\u032c\3\2\2\2\u032a"+
		"\u0328\3\2\2\2\u032a\u032b\3\2\2\2\u032b\u0085\3\2\2\2\u032c\u032a\3\2"+
		"\2\2\u032d\u032e\5\u008aF\2\u032e\u032f\5\u0088E\2\u032f\u0333\5\u008c"+
		"G\2\u0330\u0332\5\4\3\2\u0331\u0330\3\2\2\2\u0332\u0335\3\2\2\2\u0333"+
		"\u0331\3\2\2\2\u0333\u0334\3\2\2\2\u0334\u0087\3\2\2\2\u0335\u0333\3\2"+
		"\2\2\u0336\u0337\t\7\2\2\u0337\u0089\3\2\2\2\u0338\u0339\7\35\2\2\u0339"+
		"\u033a\7\16\2\2\u033a\u033b\5N(\2\u033b\u033f\7\36\2\2\u033c\u033e\5\4"+
		"\3\2\u033d\u033c\3\2\2\2\u033e\u0341\3\2\2\2\u033f\u033d\3\2\2\2\u033f"+
		"\u0340\3\2\2\2\u0340\u008b\3\2\2\2\u0341\u033f\3\2\2\2\u0342\u0343\7\35"+
		"\2\2\u0343\u0344\7\f\2\2\u0344\u0345\5N(\2\u0345\u0349\7\36\2\2\u0346"+
		"\u0348\5\4\3\2\u0347\u0346\3\2\2\2\u0348\u034b\3\2\2\2\u0349\u0347\3\2"+
		"\2\2\u0349\u034a\3\2\2\2\u034a\u008d\3\2\2\2\u034b\u0349\3\2\2\2\u034c"+
		"\u034e\5\u0090I\2\u034d\u034c\3\2\2\2\u034e\u034f\3\2\2\2\u034f\u034d"+
		"\3\2\2\2\u034f\u0350\3\2\2\2\u0350\u008f\3\2\2\2\u0351\u0352\5\u0092J"+
		"\2\u0352\u0353\5\u0094K\2\u0353\u0354\7\r\2\2\u0354\u0356\5\\/\2\u0355"+
		"\u0357\7\3\2\2\u0356\u0355\3\2\2\2\u0356\u0357\3\2\2\2\u0357\u035b\3\2"+
		"\2\2\u0358\u035a\5\4\3\2\u0359\u0358\3\2\2\2\u035a\u035d\3\2\2\2\u035b"+
		"\u0359\3\2\2\2\u035b\u035c\3\2\2\2\u035c\u0091\3\2\2\2\u035d\u035b\3\2"+
		"\2\2\u035e\u035f\t\b\2\2\u035f\u0093\3\2\2\2\u0360\u0361\7\60\2\2\u0361"+
		"\u0095\3\2\2\2u\u0099\u00a1\u00a3\u00a9\u00b3\u00b8\u00bb\u00c0\u00c6"+
		"\u00ca\u00d0\u00d6\u00da\u00de\u00e0\u00e9\u00f1\u00f8\u00fb\u0100\u0105"+
		"\u010a\u010f\u0112\u0119\u0122\u012a\u0131\u0138\u013f\u0142\u014b\u0152"+
		"\u0159\u015c\u0160\u016e\u0176\u0182\u0187\u018c\u0191\u0198\u019c\u01a1"+
		"\u01a5\u01ad\u01bf\u01c1\u01c7\u01c9\u01ce\u01d2\u01d8\u01de\u01e0\u01e3"+
		"\u01ea\u01ec\u01f0\u01f6\u01fb\u01ff\u0205\u020b\u020e\u0214\u0216\u021c"+
		"\u021f\u0229\u022d\u0231\u0233\u0239\u023e\u0242\u0248\u024e\u0251\u0258"+
		"\u0260\u026a\u026f\u0278\u0293\u029a\u02a0\u02a7\u02ae\u02b5\u02b8\u02cd"+
		"\u02d2\u02d7\u02dd\u02e2\u02e7\u02ee\u02f1\u02f6\u02f9\u0303\u0309\u030e"+
		"\u0316\u031b\u0325\u032a\u0333\u033f\u0349\u034f\u0356\u035b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}