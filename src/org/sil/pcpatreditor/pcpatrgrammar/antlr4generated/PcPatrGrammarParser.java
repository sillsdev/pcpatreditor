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
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
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
			setState(367);
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
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(354);
					comment();
					}
					break;
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(T__8);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				match(T__2);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(359);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(360);
				match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 7);
				{
				setState(361);
				match(T__11);
				}
				break;
			case T__41:
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 8);
				{
				setState(362);
				constraintTemplateKW();
				}
				break;
			case T__37:
			case T__38:
			case T__39:
				enterOuterAlt(_localctx, 9);
				{
				setState(363);
				lexicalRuleKW();
				}
				break;
			case T__28:
			case T__29:
			case T__30:
				enterOuterAlt(_localctx, 10);
				{
				setState(364);
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
				setState(365);
				parameterName();
				}
				break;
			case T__13:
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 12);
				{
				setState(366);
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
			setState(369);
			featureStructureName();
			setState(370);
			match(T__7);
			setState(371);
			featureStructureValue();
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(372);
				comment();
				}
				}
				setState(377);
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
			setState(378);
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
			setState(380);
			openingWedge();
			setState(381);
			featurePath();
			setState(382);
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
			setState(385); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(384);
					patrRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(387); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(389);
				comment();
				}
				}
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(395);
			ruleKW();
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(396);
				ruleIdentifier();
				}
			}

			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(399);
				comment();
				}
				}
				setState(404);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(405);
			phraseStructureRule();
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(406);
					comment();
					}
					} 
				}
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(412);
				constraints();
				}
				break;
			}
			setState(418);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(415);
					comment();
					}
					} 
				}
				setState(420);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(421);
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
			setState(424);
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
			setState(426);
			match(T__16);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(427);
					matchWildcard();
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			setState(433);
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
			setState(435);
			constituent();
			setState(436);
			ruleDef();
			setState(437);
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
			setState(439);
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
			setState(441);
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
			setState(448); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(448);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						setState(443);
						constituent();
						}
						break;
					case 2:
						{
						setState(444);
						disjunctiveConstituents();
						}
						break;
					case 3:
						{
						setState(445);
						optionalConstituents();
						}
						break;
					case 4:
						{
						setState(446);
						disjunctiveOptionalConstituents();
						}
						break;
					case 5:
						{
						setState(447);
						disjunctionConstituents();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(450); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
			setState(452);
			match(T__16);
			setState(456); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(456);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(453);
					constituent();
					}
					break;
				case T__19:
					{
					setState(454);
					optionalConstituents();
					}
					break;
				case T__16:
					{
					setState(455);
					disjunctiveConstituents();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(458); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__19) | (1L << TEXT))) != 0) );
			setState(461); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(460);
				disjunctionConstituents();
				}
				}
				setState(463); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(465);
			match(T__17);
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(466);
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
			setState(469);
			match(T__4);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(470);
				comment();
				}
				}
				setState(475);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(479); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(479);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TEXT:
						{
						setState(476);
						constituent();
						}
						break;
					case T__16:
						{
						setState(477);
						disjunctiveConstituents();
						}
						break;
					case T__19:
						{
						setState(478);
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
				setState(481); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(484);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(483);
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
			setState(486);
			match(T__19);
			setState(491); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(491);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(487);
					constituent();
					}
					break;
				case T__16:
					{
					setState(488);
					disjunctiveConstituents();
					}
					break;
				case T__19:
					{
					setState(489);
					optionalConstituents();
					}
					break;
				case T__4:
					{
					setState(490);
					disjunctionOptionalConstituents();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(493); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__16) | (1L << T__19) | (1L << TEXT))) != 0) );
			setState(495);
			match(T__20);
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(496);
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
			setState(499);
			match(T__19);
			setState(501); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(500);
				constituent();
				}
				}
				setState(503); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TEXT );
			setState(506); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(505);
				disjunctionOptionalConstituents();
				}
				}
				setState(508); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(510);
			match(T__20);
			setState(512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(511);
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
			setState(514);
			match(T__4);
			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(515);
				comment();
				}
				}
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(522); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(521);
					constituent();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(524); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINECOMMENT) {
				{
				setState(526);
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
			setState(533); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(533);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
					case 1:
						{
						setState(529);
						unificationConstraint();
						}
						break;
					case 2:
						{
						setState(530);
						priorityUnionConstraint();
						}
						break;
					case 3:
						{
						setState(531);
						logicalConstraint();
						}
						break;
					case 4:
						{
						setState(532);
						comment();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(535); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
			setState(544);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(537);
				uniConstraintLeftHandSide();
				setState(538);
				match(T__3);
				setState(539);
				uniConstraintRightHandSide();
				setState(541);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(540);
					comment();
					}
					break;
				}
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(543);
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
			setState(546);
			openingWedge();
			setState(547);
			constituent();
			setState(548);
			featurePath();
			setState(549);
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
			setState(564);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(551);
				openingWedge();
				setState(552);
				constituent();
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
					{
					setState(553);
					featurePath();
					}
				}

				setState(556);
				closingWedge();
				setState(558);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(557);
					comment();
					}
					break;
				}
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(560);
				atomicValue();
				setState(562);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
				case 1:
					{
					setState(561);
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
			setState(566);
			match(T__16);
			setState(568); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(567);
				unificationConstraint();
				}
				}
				setState(570); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__26 );
			setState(573); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(572);
				disjunctionUnificationConstraint();
				}
				}
				setState(575); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(577);
			match(T__17);
			setState(579);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(578);
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
			setState(581);
			match(T__4);
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(582);
				comment();
				}
				}
				setState(587);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(589); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(588);
				unificationConstraint();
				}
				}
				setState(591); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__16 || _la==T__26 );
			setState(594);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINECOMMENT) {
				{
				setState(593);
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
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(596);
				ruleKW();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(597);
				atomicValue();
				setState(598);
				featurePath();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(600);
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
			setState(603);
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
			setState(605);
			priorityUnionLeftHandSide();
			setState(606);
			match(T__21);
			setState(607);
			priorityUnionRightHandSide();
			setState(609);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				{
				setState(608);
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
			setState(611);
			openingWedge();
			setState(612);
			constituent();
			setState(613);
			featurePath();
			setState(614);
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
			setState(624);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(616);
				openingWedge();
				setState(617);
				constituent();
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
					{
					setState(618);
					featurePath();
					}
				}

				setState(621);
				closingWedge();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(623);
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
			setState(626);
			logConstraintLeftHandSide();
			setState(627);
			match(T__22);
			setState(628);
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
			setState(630);
			openingWedge();
			setState(631);
			constituent();
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << TEXT))) != 0)) {
				{
				setState(632);
				featurePath();
				}
			}

			setState(635);
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
			setState(660);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(637);
				logConstraintFactor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(638);
				match(T__23);
				setState(639);
				logConstraintFactor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(640);
				logConstraintFactor();
				setState(641);
				binop();
				setState(642);
				logConstraintFactor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(644);
				match(T__23);
				setState(645);
				logConstraintFactor();
				setState(646);
				binop();
				setState(647);
				logConstraintFactor();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(649);
				logConstraintFactor();
				setState(650);
				binop();
				setState(651);
				match(T__23);
				setState(652);
				logConstraintFactor();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(654);
				match(T__23);
				setState(655);
				logConstraintFactor();
				setState(656);
				binop();
				setState(657);
				match(T__23);
				setState(658);
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
			setState(667);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(662);
				featureStructure();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
				match(T__19);
				setState(664);
				logConstraintExpression();
				setState(665);
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
			setState(697);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				match(T__24);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(670);
					comment();
					}
					}
					setState(675);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				match(T__4);
				setState(680);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(677);
					comment();
					}
					}
					setState(682);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(683);
				match(T__18);
				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(684);
					comment();
					}
					}
					setState(689);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 4);
				{
				setState(690);
				match(T__25);
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LINECOMMENT) {
					{
					{
					setState(691);
					comment();
					}
					}
					setState(696);
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
			setState(699);
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
			setState(701);
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
			setState(703);
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
			setState(705);
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
			setState(707);
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
			setState(709);
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
			setState(711);
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
			setState(713);
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
			setState(716); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(715);
					parameter();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(718); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(723);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(720);
					comment();
					}
					} 
				}
				setState(725);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
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
			setState(762);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(726);
				parameterKW();
				setState(728);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(727);
					match(T__7);
					}
				}

				setState(730);
				parameterName();
				setState(731);
				match(T__10);
				setState(732);
				parameterValue();
				setState(734);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(733);
					match(T__0);
					}
				}

				setState(739);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(736);
						comment();
						}
						} 
					}
					setState(741);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(742);
				parameterKW();
				setState(744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(743);
					match(T__7);
					}
				}

				setState(746);
				match(T__8);
				setState(747);
				match(T__10);
				setState(749); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(748);
					parameterValue();
					}
					}
					setState(751); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TEXT );
				setState(754);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(753);
					match(T__0);
					}
				}

				setState(759);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(756);
						comment();
						}
						} 
					}
					setState(761);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
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
			setState(764);
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
			setState(766);
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
			setState(768);
			match(TEXT);
			setState(772);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(769);
					comment();
					}
					} 
				}
				setState(774);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,103,_ctx);
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
			setState(776); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(775);
					lexicalRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(778); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(783);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(780);
					comment();
					}
					} 
				}
				setState(785);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,105,_ctx);
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
			setState(786);
			lexicalRuleKW();
			setState(787);
			lexicalRuleName();
			setState(788);
			match(T__36);
			setState(789);
			lexicalRuleDefinition();
			setState(791);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(790);
				match(T__0);
				}
			}

			setState(796);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(793);
					comment();
					}
					} 
				}
				setState(798);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
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
			setState(799);
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
			setState(801);
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
			setState(804); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(803);
				lexicalRuleMapping();
				}
				}
				setState(806); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__26 );
			setState(811);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(808);
					comment();
					}
					} 
				}
				setState(813);
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
			setState(814);
			lexicalRuleOutput();
			setState(815);
			lexicalRuleAssignment();
			setState(816);
			lexicalRuleInput();
			setState(820);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(817);
					comment();
					}
					} 
				}
				setState(822);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,110,_ctx);
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
			setState(823);
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
			setState(825);
			match(T__26);
			setState(826);
			match(T__11);
			setState(827);
			featurePath();
			setState(828);
			match(T__27);
			setState(832);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINECOMMENT) {
				{
				{
				setState(829);
				comment();
				}
				}
				setState(834);
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
			setState(835);
			match(T__26);
			setState(836);
			match(T__9);
			setState(837);
			featurePath();
			setState(838);
			match(T__27);
			setState(842);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(839);
					comment();
					}
					} 
				}
				setState(844);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
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
			setState(846); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(845);
					constraintTemplate();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(848); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
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
			setState(850);
			constraintTemplateKW();
			setState(851);
			constraintTemplateName();
			setState(852);
			match(T__10);
			setState(853);
			logConstraintExpression();
			setState(855);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(854);
				match(T__0);
				}
			}

			setState(860);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(857);
					comment();
					}
					} 
				}
				setState(862);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,115,_ctx);
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
			setState(863);
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
			setState(865);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0366\4\2\t\2"+
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
		"\3\21\3\21\5\21\u0166\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u0172\n\21\3\22\3\22\3\22\3\22\7\22\u0178\n\22\f\22\16\22\u017b"+
		"\13\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\6\25\u0184\n\25\r\25\16\25\u0185"+
		"\3\26\7\26\u0189\n\26\f\26\16\26\u018c\13\26\3\26\3\26\5\26\u0190\n\26"+
		"\3\26\7\26\u0193\n\26\f\26\16\26\u0196\13\26\3\26\3\26\7\26\u019a\n\26"+
		"\f\26\16\26\u019d\13\26\3\26\5\26\u01a0\n\26\3\26\7\26\u01a3\n\26\f\26"+
		"\16\26\u01a6\13\26\3\26\5\26\u01a9\n\26\3\27\3\27\3\30\3\30\7\30\u01af"+
		"\n\30\f\30\16\30\u01b2\13\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\6\34\u01c3\n\34\r\34\16\34\u01c4\3\35"+
		"\3\35\3\35\3\35\6\35\u01cb\n\35\r\35\16\35\u01cc\3\35\6\35\u01d0\n\35"+
		"\r\35\16\35\u01d1\3\35\3\35\5\35\u01d6\n\35\3\36\3\36\7\36\u01da\n\36"+
		"\f\36\16\36\u01dd\13\36\3\36\3\36\3\36\6\36\u01e2\n\36\r\36\16\36\u01e3"+
		"\3\36\5\36\u01e7\n\36\3\37\3\37\3\37\3\37\3\37\6\37\u01ee\n\37\r\37\16"+
		"\37\u01ef\3\37\3\37\5\37\u01f4\n\37\3 \3 \6 \u01f8\n \r \16 \u01f9\3 "+
		"\6 \u01fd\n \r \16 \u01fe\3 \3 \5 \u0203\n \3!\3!\7!\u0207\n!\f!\16!\u020a"+
		"\13!\3!\6!\u020d\n!\r!\16!\u020e\3!\5!\u0212\n!\3\"\3\"\3\"\3\"\6\"\u0218"+
		"\n\"\r\"\16\"\u0219\3#\3#\3#\3#\5#\u0220\n#\3#\5#\u0223\n#\3$\3$\3$\3"+
		"$\3$\3%\3%\3%\5%\u022d\n%\3%\3%\5%\u0231\n%\3%\3%\5%\u0235\n%\5%\u0237"+
		"\n%\3&\3&\6&\u023b\n&\r&\16&\u023c\3&\6&\u0240\n&\r&\16&\u0241\3&\3&\5"+
		"&\u0246\n&\3\'\3\'\7\'\u024a\n\'\f\'\16\'\u024d\13\'\3\'\6\'\u0250\n\'"+
		"\r\'\16\'\u0251\3\'\5\'\u0255\n\'\3(\3(\3(\3(\3(\5(\u025c\n(\3)\3)\3*"+
		"\3*\3*\3*\5*\u0264\n*\3+\3+\3+\3+\3+\3,\3,\3,\5,\u026e\n,\3,\3,\3,\5,"+
		"\u0273\n,\3-\3-\3-\3-\3.\3.\3.\5.\u027c\n.\3.\3.\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\5/\u0297\n/\3\60\3\60"+
		"\3\60\3\60\3\60\5\60\u029e\n\60\3\61\3\61\7\61\u02a2\n\61\f\61\16\61\u02a5"+
		"\13\61\3\61\3\61\7\61\u02a9\n\61\f\61\16\61\u02ac\13\61\3\61\3\61\7\61"+
		"\u02b0\n\61\f\61\16\61\u02b3\13\61\3\61\3\61\7\61\u02b7\n\61\f\61\16\61"+
		"\u02ba\13\61\5\61\u02bc\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\66\3\66\3\67\3\67\38\38\39\39\3:\6:\u02cf\n:\r:\16:\u02d0\3:\7:\u02d4"+
		"\n:\f:\16:\u02d7\13:\3;\3;\5;\u02db\n;\3;\3;\3;\3;\5;\u02e1\n;\3;\7;\u02e4"+
		"\n;\f;\16;\u02e7\13;\3;\3;\5;\u02eb\n;\3;\3;\3;\6;\u02f0\n;\r;\16;\u02f1"+
		"\3;\5;\u02f5\n;\3;\7;\u02f8\n;\f;\16;\u02fb\13;\5;\u02fd\n;\3<\3<\3=\3"+
		"=\3>\3>\7>\u0305\n>\f>\16>\u0308\13>\3?\6?\u030b\n?\r?\16?\u030c\3?\7"+
		"?\u0310\n?\f?\16?\u0313\13?\3@\3@\3@\3@\3@\5@\u031a\n@\3@\7@\u031d\n@"+
		"\f@\16@\u0320\13@\3A\3A\3B\3B\3C\6C\u0327\nC\rC\16C\u0328\3C\7C\u032c"+
		"\nC\fC\16C\u032f\13C\3D\3D\3D\3D\7D\u0335\nD\fD\16D\u0338\13D\3E\3E\3"+
		"F\3F\3F\3F\3F\7F\u0341\nF\fF\16F\u0344\13F\3G\3G\3G\3G\3G\7G\u034b\nG"+
		"\fG\16G\u034e\13G\3H\6H\u0351\nH\rH\16H\u0352\3I\3I\3I\3I\3I\5I\u035a"+
		"\nI\3I\7I\u035d\nI\fI\16I\u0360\13I\3J\3J\3K\3K\3K\3\u01b0\2L\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\2\t\3\2\20\22\4\2\6\6\25\25\3\2\37!\3\2\"&\3\2(*\4\2\6\6"+
		"++\3\2,.\2\u03b1\2\u0099\3\2\2\2\4\u00ae\3\2\2\2\6\u00b1\3\2\2\2\b\u00b5"+
		"\3\2\2\2\n\u00c3\3\2\2\2\f\u00e0\3\2\2\2\16\u00e2\3\2\2\2\20\u00e9\3\2"+
		"\2\2\22\u00fb\3\2\2\2\24\u0112\3\2\2\2\26\u0114\3\2\2\2\30\u011d\3\2\2"+
		"\2\32\u0142\3\2\2\2\34\u015c\3\2\2\2\36\u0160\3\2\2\2 \u0171\3\2\2\2\""+
		"\u0173\3\2\2\2$\u017c\3\2\2\2&\u017e\3\2\2\2(\u0183\3\2\2\2*\u018a\3\2"+
		"\2\2,\u01aa\3\2\2\2.\u01ac\3\2\2\2\60\u01b5\3\2\2\2\62\u01b9\3\2\2\2\64"+
		"\u01bb\3\2\2\2\66\u01c2\3\2\2\28\u01c6\3\2\2\2:\u01d7\3\2\2\2<\u01e8\3"+
		"\2\2\2>\u01f5\3\2\2\2@\u0204\3\2\2\2B\u0217\3\2\2\2D\u0222\3\2\2\2F\u0224"+
		"\3\2\2\2H\u0236\3\2\2\2J\u0238\3\2\2\2L\u0247\3\2\2\2N\u025b\3\2\2\2P"+
		"\u025d\3\2\2\2R\u025f\3\2\2\2T\u0265\3\2\2\2V\u0272\3\2\2\2X\u0274\3\2"+
		"\2\2Z\u0278\3\2\2\2\\\u0296\3\2\2\2^\u029d\3\2\2\2`\u02bb\3\2\2\2b\u02bd"+
		"\3\2\2\2d\u02bf\3\2\2\2f\u02c1\3\2\2\2h\u02c3\3\2\2\2j\u02c5\3\2\2\2l"+
		"\u02c7\3\2\2\2n\u02c9\3\2\2\2p\u02cb\3\2\2\2r\u02ce\3\2\2\2t\u02fc\3\2"+
		"\2\2v\u02fe\3\2\2\2x\u0300\3\2\2\2z\u0302\3\2\2\2|\u030a\3\2\2\2~\u0314"+
		"\3\2\2\2\u0080\u0321\3\2\2\2\u0082\u0323\3\2\2\2\u0084\u0326\3\2\2\2\u0086"+
		"\u0330\3\2\2\2\u0088\u0339\3\2\2\2\u008a\u033b\3\2\2\2\u008c\u0345\3\2"+
		"\2\2\u008e\u0350\3\2\2\2\u0090\u0354\3\2\2\2\u0092\u0361\3\2\2\2\u0094"+
		"\u0363\3\2\2\2\u0096\u0098\5\4\3\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u00a3\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u00a2\5\6\4\2\u009d\u00a2\5\u008eH\2\u009e\u00a2"+
		"\5(\25\2\u009f\u00a2\5r:\2\u00a0\u00a2\5|?\2\u00a1\u009c\3\2\2\2\u00a1"+
		"\u009d\3\2\2\2\u00a1\u009e\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a9\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a8\5\4\3\2\u00a7\u00a6\3\2"+
		"\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7\2\2\3\u00ad\3\3\2\2\2"+
		"\u00ae\u00af\7/\2\2\u00af\5\3\2\2\2\u00b0\u00b2\5\b\5\2\u00b1\u00b0\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\7\3\2\2\2\u00b5\u00b8\5\n\6\2\u00b6\u00b9\5\f\7\2\u00b7\u00b9\5\16\b"+
		"\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00bc"+
		"\7\3\2\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c0\3\2\2\2\u00bd"+
		"\u00bf\5\4\3\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\t\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4"+
		"\7\4\2\2\u00c4\u00c6\5\20\t\2\u00c5\u00c7\5\4\3\2\u00c6\u00c5\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\7\5\2\2\u00c9\u00cb"+
		"\5\4\3\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\13\3\2\2\2\u00cc"+
		"\u00cd\5&\24\2\u00cd\u00ce\7\6\2\2\u00ce\u00d0\5\26\f\2\u00cf\u00d1\5"+
		"\f\7\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00e1\3\2\2\2\u00d2"+
		"\u00d3\5&\24\2\u00d3\u00d4\7\6\2\2\u00d4\u00d6\5\24\13\2\u00d5\u00d7\5"+
		"\f\7\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00e1\3\2\2\2\u00d8"+
		"\u00da\5\22\n\2\u00d9\u00db\5\f\7\2\u00da\u00d9\3\2\2\2\u00da\u00db\3"+
		"\2\2\2\u00db\u00e1\3\2\2\2\u00dc\u00de\5\30\r\2\u00dd\u00df\5\f\7\2\u00de"+
		"\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00cc\3\2"+
		"\2\2\u00e0\u00d2\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1"+
		"\r\3\2\2\2\u00e2\u00e3\5\34\17\2\u00e3\17\3\2\2\2\u00e4\u00ea\5P)\2\u00e5"+
		"\u00e6\5P)\2\u00e6\u00e7\7\7\2\2\u00e7\u00e8\5P)\2\u00e8\u00ea\3\2\2\2"+
		"\u00e9\u00e4\3\2\2\2\u00e9\u00e5\3\2\2\2\u00ea\21\3\2\2\2\u00eb\u00ec"+
		"\7\b\2\2\u00ec\u00ed\5\20\t\2\u00ed\u00f1\7\t\2\2\u00ee\u00f0\5\4\3\2"+
		"\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u00fc\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f8\5\20\t\2"+
		"\u00f5\u00f7\5\4\3\2\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		"\u00eb\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fc\23\3\2\2\2\u00fd\u0113\5\30\r"+
		"\2\u00fe\u0100\5&\24\2\u00ff\u0101\7\3\2\2\u0100\u00ff\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0105\3\2\2\2\u0102\u0104\5\4\3\2\u0103\u0102\3\2\2\2\u0104"+
		"\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0113\3\2"+
		"\2\2\u0107\u0105\3\2\2\2\u0108\u010a\5P)\2\u0109\u010b\7\3\2\2\u010a\u0109"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010f\3\2\2\2\u010c\u010e\5\4\3\2\u010d"+
		"\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u00fd\3\2\2\2\u0112"+
		"\u00fe\3\2\2\2\u0112\u0108\3\2\2\2\u0113\25\3\2\2\2\u0114\u0115\5b\62"+
		"\2\u0115\u0117\5P)\2\u0116\u0118\5P)\2\u0117\u0116\3\2\2\2\u0118\u0119"+
		"\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\5d\63\2\u011c\27\3\2\2\2\u011d\u011e\5b\62\2\u011e\u0120\5\32\16"+
		"\2\u011f\u0121\5\32\16\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\5d"+
		"\63\2\u0125\31\3\2\2\2\u0126\u012a\5N(\2\u0127\u0129\5\4\3\2\u0128\u0127"+
		"\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u0143\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0131\5\34\17\2\u012e\u0130\5"+
		"\4\3\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0143\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0138\5P"+
		")\2\u0135\u0137\5\4\3\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0143\3\2\2\2\u013a\u0138\3\2"+
		"\2\2\u013b\u013f\5\22\n\2\u013c\u013e\5\4\3\2\u013d\u013c\3\2\2\2\u013e"+
		"\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0143\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0142\u0126\3\2\2\2\u0142\u012d\3\2\2\2\u0142"+
		"\u0134\3\2\2\2\u0142\u013b\3\2\2\2\u0143\33\3\2\2\2\u0144\u0145\5f\64"+
		"\2\u0145\u0146\5\36\20\2\u0146\u0147\7\n\2\2\u0147\u014b\5 \21\2\u0148"+
		"\u014a\5\"\22\2\u0149\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3"+
		"\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014b\3\2\2\2\u014e"+
		"\u0152\5h\65\2\u014f\u0151\5\4\3\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u015d\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u0159\5$\23\2\u0156\u0158\5\4\3\2\u0157\u0156\3\2"+
		"\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0144\3\2\2\2\u015c\u0155\3\2"+
		"\2\2\u015d\35\3\2\2\2\u015e\u0161\5,\27\2\u015f\u0161\5P)\2\u0160\u015e"+
		"\3\2\2\2\u0160\u015f\3\2\2\2\u0161\37\3\2\2\2\u0162\u0172\5\34\17\2\u0163"+
		"\u0165\5P)\2\u0164\u0166\5\4\3\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2"+
		"\2\u0166\u0172\3\2\2\2\u0167\u0172\7\13\2\2\u0168\u0172\7\5\2\2\u0169"+
		"\u0172\7\f\2\2\u016a\u0172\7\r\2\2\u016b\u0172\7\16\2\2\u016c\u0172\5"+
		"\u0092J\2\u016d\u0172\5\u0080A\2\u016e\u0172\5v<\2\u016f\u0172\5x=\2\u0170"+
		"\u0172\5,\27\2\u0171\u0162\3\2\2\2\u0171\u0163\3\2\2\2\u0171\u0167\3\2"+
		"\2\2\u0171\u0168\3\2\2\2\u0171\u0169\3\2\2\2\u0171\u016a\3\2\2\2\u0171"+
		"\u016b\3\2\2\2\u0171\u016c\3\2\2\2\u0171\u016d\3\2\2\2\u0171\u016e\3\2"+
		"\2\2\u0171\u016f\3\2\2\2\u0171\u0170\3\2\2\2\u0172!\3\2\2\2\u0173\u0174"+
		"\5\36\20\2\u0174\u0175\7\n\2\2\u0175\u0179\5 \21\2\u0176\u0178\5\4\3\2"+
		"\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2\2\2\u0179\u017a"+
		"\3\2\2\2\u017a#\3\2\2\2\u017b\u0179\3\2\2\2\u017c\u017d\7\17\2\2\u017d"+
		"%\3\2\2\2\u017e\u017f\5n8\2\u017f\u0180\5N(\2\u0180\u0181\5p9\2\u0181"+
		"\'\3\2\2\2\u0182\u0184\5*\26\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2"+
		"\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186)\3\2\2\2\u0187\u0189\5"+
		"\4\3\2\u0188\u0187\3\2\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018f\5,"+
		"\27\2\u018e\u0190\5.\30\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u0194\3\2\2\2\u0191\u0193\5\4\3\2\u0192\u0191\3\2\2\2\u0193\u0196\3\2"+
		"\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0197\u019b\5\60\31\2\u0198\u019a\5\4\3\2\u0199\u0198\3"+
		"\2\2\2\u019a\u019d\3\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c"+
		"\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019e\u01a0\5B\"\2\u019f\u019e\3\2"+
		"\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a4\3\2\2\2\u01a1\u01a3\5\4\3\2\u01a2"+
		"\u01a1\3\2\2\2\u01a3\u01a6\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2"+
		"\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a7\u01a9\7\3\2\2\u01a8"+
		"\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9+\3\2\2\2\u01aa\u01ab\t\2\2\2"+
		"\u01ab-\3\2\2\2\u01ac\u01b0\7\23\2\2\u01ad\u01af\13\2\2\2\u01ae\u01ad"+
		"\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1"+
		"\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\7\24\2\2\u01b4/\3\2\2\2"+
		"\u01b5\u01b6\5\64\33\2\u01b6\u01b7\5\62\32\2\u01b7\u01b8\5\66\34\2\u01b8"+
		"\61\3\2\2\2\u01b9\u01ba\t\3\2\2\u01ba\63\3\2\2\2\u01bb\u01bc\7\60\2\2"+
		"\u01bc\65\3\2\2\2\u01bd\u01c3\5\64\33\2\u01be\u01c3\58\35\2\u01bf\u01c3"+
		"\5<\37\2\u01c0\u01c3\5> \2\u01c1\u01c3\5:\36\2\u01c2\u01bd\3\2\2\2\u01c2"+
		"\u01be\3\2\2\2\u01c2\u01bf\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2\u01c1\3\2"+
		"\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"\67\3\2\2\2\u01c6\u01ca\7\23\2\2\u01c7\u01cb\5\64\33\2\u01c8\u01cb\5<"+
		"\37\2\u01c9\u01cb\58\35\2\u01ca\u01c7\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca"+
		"\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01d0\5:\36\2\u01cf\u01ce\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3\u01d5\7\24\2\2\u01d4\u01d6\5\4\3\2\u01d5\u01d4\3\2\2\2\u01d5"+
		"\u01d6\3\2\2\2\u01d69\3\2\2\2\u01d7\u01db\7\7\2\2\u01d8\u01da\5\4\3\2"+
		"\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01e1\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01e2\5\64\33\2"+
		"\u01df\u01e2\58\35\2\u01e0\u01e2\5<\37\2\u01e1\u01de\3\2\2\2\u01e1\u01df"+
		"\3\2\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3"+
		"\u01e4\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5\u01e7\5\4\3\2\u01e6\u01e5\3\2"+
		"\2\2\u01e6\u01e7\3\2\2\2\u01e7;\3\2\2\2\u01e8\u01ed\7\26\2\2\u01e9\u01ee"+
		"\5\64\33\2\u01ea\u01ee\58\35\2\u01eb\u01ee\5<\37\2\u01ec\u01ee\5@!\2\u01ed"+
		"\u01e9\3\2\2\2\u01ed\u01ea\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ec\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0"+
		"\u01f1\3\2\2\2\u01f1\u01f3\7\27\2\2\u01f2\u01f4\5\4\3\2\u01f3\u01f2\3"+
		"\2\2\2\u01f3\u01f4\3\2\2\2\u01f4=\3\2\2\2\u01f5\u01f7\7\26\2\2\u01f6\u01f8"+
		"\5\64\33\2\u01f7\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01f7\3\2\2\2"+
		"\u01f9\u01fa\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01fd\5@!\2\u01fc\u01fb"+
		"\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u0200\3\2\2\2\u0200\u0202\7\27\2\2\u0201\u0203\5\4\3\2\u0202\u0201\3"+
		"\2\2\2\u0202\u0203\3\2\2\2\u0203?\3\2\2\2\u0204\u0208\7\7\2\2\u0205\u0207"+
		"\5\4\3\2\u0206\u0205\3\2\2\2\u0207\u020a\3\2\2\2\u0208\u0206\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020b\u020d\5\64"+
		"\33\2\u020c\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020c\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u0212\5\4\3\2\u0211\u0210\3\2"+
		"\2\2\u0211\u0212\3\2\2\2\u0212A\3\2\2\2\u0213\u0218\5D#\2\u0214\u0218"+
		"\5R*\2\u0215\u0218\5X-\2\u0216\u0218\5\4\3\2\u0217\u0213\3\2\2\2\u0217"+
		"\u0214\3\2\2\2\u0217\u0215\3\2\2\2\u0217\u0216\3\2\2\2\u0218\u0219\3\2"+
		"\2\2\u0219\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021aC\3\2\2\2\u021b\u021c"+
		"\5F$\2\u021c\u021d\7\6\2\2\u021d\u021f\5H%\2\u021e\u0220\5\4\3\2\u021f"+
		"\u021e\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u0223\5J"+
		"&\2\u0222\u021b\3\2\2\2\u0222\u0221\3\2\2\2\u0223E\3\2\2\2\u0224\u0225"+
		"\5n8\2\u0225\u0226\5\64\33\2\u0226\u0227\5N(\2\u0227\u0228\5p9\2\u0228"+
		"G\3\2\2\2\u0229\u022a\5n8\2\u022a\u022c\5\64\33\2\u022b\u022d\5N(\2\u022c"+
		"\u022b\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u0230\5p"+
		"9\2\u022f\u0231\5\4\3\2\u0230\u022f\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0237\3\2\2\2\u0232\u0234\5P)\2\u0233\u0235\5\4\3\2\u0234\u0233\3\2\2"+
		"\2\u0234\u0235\3\2\2\2\u0235\u0237\3\2\2\2\u0236\u0229\3\2\2\2\u0236\u0232"+
		"\3\2\2\2\u0237I\3\2\2\2\u0238\u023a\7\23\2\2\u0239\u023b\5D#\2\u023a\u0239"+
		"\3\2\2\2\u023b\u023c\3\2\2\2\u023c\u023a\3\2\2\2\u023c\u023d\3\2\2\2\u023d"+
		"\u023f\3\2\2\2\u023e\u0240\5L\'\2\u023f\u023e\3\2\2\2\u0240\u0241\3\2"+
		"\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243\3\2\2\2\u0243"+
		"\u0245\7\24\2\2\u0244\u0246\5\4\3\2\u0245\u0244\3\2\2\2\u0245\u0246\3"+
		"\2\2\2\u0246K\3\2\2\2\u0247\u024b\7\7\2\2\u0248\u024a\5\4\3\2\u0249\u0248"+
		"\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0250\5D#\2\u024f\u024e\3\2\2"+
		"\2\u0250\u0251\3\2\2\2\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254"+
		"\3\2\2\2\u0253\u0255\5\4\3\2\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"M\3\2\2\2\u0256\u025c\5,\27\2\u0257\u0258\5P)\2\u0258\u0259\5N(\2\u0259"+
		"\u025c\3\2\2\2\u025a\u025c\5P)\2\u025b\u0256\3\2\2\2\u025b\u0257\3\2\2"+
		"\2\u025b\u025a\3\2\2\2\u025cO\3\2\2\2\u025d\u025e\7\60\2\2\u025eQ\3\2"+
		"\2\2\u025f\u0260\5T+\2\u0260\u0261\7\30\2\2\u0261\u0263\5V,\2\u0262\u0264"+
		"\5\4\3\2\u0263\u0262\3\2\2\2\u0263\u0264\3\2\2\2\u0264S\3\2\2\2\u0265"+
		"\u0266\5n8\2\u0266\u0267\5\64\33\2\u0267\u0268\5N(\2\u0268\u0269\5p9\2"+
		"\u0269U\3\2\2\2\u026a\u026b\5n8\2\u026b\u026d\5\64\33\2\u026c\u026e\5"+
		"N(\2\u026d\u026c\3\2\2\2\u026d\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f"+
		"\u0270\5p9\2\u0270\u0273\3\2\2\2\u0271\u0273\5P)\2\u0272\u026a\3\2\2\2"+
		"\u0272\u0271\3\2\2\2\u0273W\3\2\2\2\u0274\u0275\5Z.\2\u0275\u0276\7\31"+
		"\2\2\u0276\u0277\5\\/\2\u0277Y\3\2\2\2\u0278\u0279\5n8\2\u0279\u027b\5"+
		"\64\33\2\u027a\u027c\5N(\2\u027b\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c"+
		"\u027d\3\2\2\2\u027d\u027e\5p9\2\u027e[\3\2\2\2\u027f\u0297\5^\60\2\u0280"+
		"\u0281\7\32\2\2\u0281\u0297\5^\60\2\u0282\u0283\5^\60\2\u0283\u0284\5"+
		"`\61\2\u0284\u0285\5^\60\2\u0285\u0297\3\2\2\2\u0286\u0287\7\32\2\2\u0287"+
		"\u0288\5^\60\2\u0288\u0289\5`\61\2\u0289\u028a\5^\60\2\u028a\u0297\3\2"+
		"\2\2\u028b\u028c\5^\60\2\u028c\u028d\5`\61\2\u028d\u028e\7\32\2\2\u028e"+
		"\u028f\5^\60\2\u028f\u0297\3\2\2\2\u0290\u0291\7\32\2\2\u0291\u0292\5"+
		"^\60\2\u0292\u0293\5`\61\2\u0293\u0294\7\32\2\2\u0294\u0295\5^\60\2\u0295"+
		"\u0297\3\2\2\2\u0296\u027f\3\2\2\2\u0296\u0280\3\2\2\2\u0296\u0282\3\2"+
		"\2\2\u0296\u0286\3\2\2\2\u0296\u028b\3\2\2\2\u0296\u0290\3\2\2\2\u0297"+
		"]\3\2\2\2\u0298\u029e\5\34\17\2\u0299\u029a\7\26\2\2\u029a\u029b\5\\/"+
		"\2\u029b\u029c\7\27\2\2\u029c\u029e\3\2\2\2\u029d\u0298\3\2\2\2\u029d"+
		"\u0299\3\2\2\2\u029e_\3\2\2\2\u029f\u02a3\7\33\2\2\u02a0\u02a2\5\4\3\2"+
		"\u02a1\u02a0\3\2\2\2\u02a2\u02a5\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a3\u02a4"+
		"\3\2\2\2\u02a4\u02bc\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a6\u02aa\7\7\2\2\u02a7"+
		"\u02a9\5\4\3\2\u02a8\u02a7\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3\2"+
		"\2\2\u02aa\u02ab\3\2\2\2\u02ab\u02bc\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ad"+
		"\u02b1\7\25\2\2\u02ae\u02b0\5\4\3\2\u02af\u02ae\3\2\2\2\u02b0\u02b3\3"+
		"\2\2\2\u02b1\u02af\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02bc\3\2\2\2\u02b3"+
		"\u02b1\3\2\2\2\u02b4\u02b8\7\34\2\2\u02b5\u02b7\5\4\3\2\u02b6\u02b5\3"+
		"\2\2\2\u02b7\u02ba\3\2\2\2\u02b8\u02b6\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9"+
		"\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02bb\u029f\3\2\2\2\u02bb\u02a6\3\2"+
		"\2\2\u02bb\u02ad\3\2\2\2\u02bb\u02b4\3\2\2\2\u02bca\3\2\2\2\u02bd\u02be"+
		"\7\23\2\2\u02bec\3\2\2\2\u02bf\u02c0\7\24\2\2\u02c0e\3\2\2\2\u02c1\u02c2"+
		"\7\b\2\2\u02c2g\3\2\2\2\u02c3\u02c4\7\t\2\2\u02c4i\3\2\2\2\u02c5\u02c6"+
		"\7\26\2\2\u02c6k\3\2\2\2\u02c7\u02c8\7\27\2\2\u02c8m\3\2\2\2\u02c9\u02ca"+
		"\7\35\2\2\u02cao\3\2\2\2\u02cb\u02cc\7\36\2\2\u02ccq\3\2\2\2\u02cd\u02cf"+
		"\5t;\2\u02ce\u02cd\3\2\2\2\u02cf\u02d0\3\2\2\2\u02d0\u02ce\3\2\2\2\u02d0"+
		"\u02d1\3\2\2\2\u02d1\u02d5\3\2\2\2\u02d2\u02d4\5\4\3\2\u02d3\u02d2\3\2"+
		"\2\2\u02d4\u02d7\3\2\2\2\u02d5\u02d3\3\2\2\2\u02d5\u02d6\3\2\2\2\u02d6"+
		"s\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d8\u02da\5v<\2\u02d9\u02db\7\n\2\2\u02da"+
		"\u02d9\3\2\2\2\u02da\u02db\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02dd\5x"+
		"=\2\u02dd\u02de\7\r\2\2\u02de\u02e0\5z>\2\u02df\u02e1\7\3\2\2\u02e0\u02df"+
		"\3\2\2\2\u02e0\u02e1\3\2\2\2\u02e1\u02e5\3\2\2\2\u02e2\u02e4\5\4\3\2\u02e3"+
		"\u02e2\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2"+
		"\2\2\u02e6\u02fd\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e8\u02ea\5v<\2\u02e9\u02eb"+
		"\7\n\2\2\u02ea\u02e9\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec"+
		"\u02ed\7\13\2\2\u02ed\u02ef\7\r\2\2\u02ee\u02f0\5z>\2\u02ef\u02ee\3\2"+
		"\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2"+
		"\u02f4\3\2\2\2\u02f3\u02f5\7\3\2\2\u02f4\u02f3\3\2\2\2\u02f4\u02f5\3\2"+
		"\2\2\u02f5\u02f9\3\2\2\2\u02f6\u02f8\5\4\3\2\u02f7\u02f6\3\2\2\2\u02f8"+
		"\u02fb\3\2\2\2\u02f9\u02f7\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fd\3\2"+
		"\2\2\u02fb\u02f9\3\2\2\2\u02fc\u02d8\3\2\2\2\u02fc\u02e8\3\2\2\2\u02fd"+
		"u\3\2\2\2\u02fe\u02ff\t\4\2\2\u02ffw\3\2\2\2\u0300\u0301\t\5\2\2\u0301"+
		"y\3\2\2\2\u0302\u0306\7\60\2\2\u0303\u0305\5\4\3\2\u0304\u0303\3\2\2\2"+
		"\u0305\u0308\3\2\2\2\u0306\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307{\3"+
		"\2\2\2\u0308\u0306\3\2\2\2\u0309\u030b\5~@\2\u030a\u0309\3\2\2\2\u030b"+
		"\u030c\3\2\2\2\u030c\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u0311\3\2"+
		"\2\2\u030e\u0310\5\4\3\2\u030f\u030e\3\2\2\2\u0310\u0313\3\2\2\2\u0311"+
		"\u030f\3\2\2\2\u0311\u0312\3\2\2\2\u0312}\3\2\2\2\u0313\u0311\3\2\2\2"+
		"\u0314\u0315\5\u0080A\2\u0315\u0316\5\u0082B\2\u0316\u0317\7\'\2\2\u0317"+
		"\u0319\5\u0084C\2\u0318\u031a\7\3\2\2\u0319\u0318\3\2\2\2\u0319\u031a"+
		"\3\2\2\2\u031a\u031e\3\2\2\2\u031b\u031d\5\4\3\2\u031c\u031b\3\2\2\2\u031d"+
		"\u0320\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f\3\2\2\2\u031f\177\3\2\2"+
		"\2\u0320\u031e\3\2\2\2\u0321\u0322\t\6\2\2\u0322\u0081\3\2\2\2\u0323\u0324"+
		"\7\60\2\2\u0324\u0083\3\2\2\2\u0325\u0327\5\u0086D\2\u0326\u0325\3\2\2"+
		"\2\u0327\u0328\3\2\2\2\u0328\u0326\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032d"+
		"\3\2\2\2\u032a\u032c\5\4\3\2\u032b\u032a\3\2\2\2\u032c\u032f\3\2\2\2\u032d"+
		"\u032b\3\2\2\2\u032d\u032e\3\2\2\2\u032e\u0085\3\2\2\2\u032f\u032d\3\2"+
		"\2\2\u0330\u0331\5\u008aF\2\u0331\u0332\5\u0088E\2\u0332\u0336\5\u008c"+
		"G\2\u0333\u0335\5\4\3\2\u0334\u0333\3\2\2\2\u0335\u0338\3\2\2\2\u0336"+
		"\u0334\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u0087\3\2\2\2\u0338\u0336\3\2"+
		"\2\2\u0339\u033a\t\7\2\2\u033a\u0089\3\2\2\2\u033b\u033c\7\35\2\2\u033c"+
		"\u033d\7\16\2\2\u033d\u033e\5N(\2\u033e\u0342\7\36\2\2\u033f\u0341\5\4"+
		"\3\2\u0340\u033f\3\2\2\2\u0341\u0344\3\2\2\2\u0342\u0340\3\2\2\2\u0342"+
		"\u0343\3\2\2\2\u0343\u008b\3\2\2\2\u0344\u0342\3\2\2\2\u0345\u0346\7\35"+
		"\2\2\u0346\u0347\7\f\2\2\u0347\u0348\5N(\2\u0348\u034c\7\36\2\2\u0349"+
		"\u034b\5\4\3\2\u034a\u0349\3\2\2\2\u034b\u034e\3\2\2\2\u034c\u034a\3\2"+
		"\2\2\u034c\u034d\3\2\2\2\u034d\u008d\3\2\2\2\u034e\u034c\3\2\2\2\u034f"+
		"\u0351\5\u0090I\2\u0350\u034f\3\2\2\2\u0351\u0352\3\2\2\2\u0352\u0350"+
		"\3\2\2\2\u0352\u0353\3\2\2\2\u0353\u008f\3\2\2\2\u0354\u0355\5\u0092J"+
		"\2\u0355\u0356\5\u0094K\2\u0356\u0357\7\r\2\2\u0357\u0359\5\\/\2\u0358"+
		"\u035a\7\3\2\2\u0359\u0358\3\2\2\2\u0359\u035a\3\2\2\2\u035a\u035e\3\2"+
		"\2\2\u035b\u035d\5\4\3\2\u035c\u035b\3\2\2\2\u035d\u0360\3\2\2\2\u035e"+
		"\u035c\3\2\2\2\u035e\u035f\3\2\2\2\u035f\u0091\3\2\2\2\u0360\u035e\3\2"+
		"\2\2\u0361\u0362\t\b\2\2\u0362\u0093\3\2\2\2\u0363\u0364\7\60\2\2\u0364"+
		"\u0095\3\2\2\2v\u0099\u00a1\u00a3\u00a9\u00b3\u00b8\u00bb\u00c0\u00c6"+
		"\u00ca\u00d0\u00d6\u00da\u00de\u00e0\u00e9\u00f1\u00f8\u00fb\u0100\u0105"+
		"\u010a\u010f\u0112\u0119\u0122\u012a\u0131\u0138\u013f\u0142\u014b\u0152"+
		"\u0159\u015c\u0160\u0165\u0171\u0179\u0185\u018a\u018f\u0194\u019b\u019f"+
		"\u01a4\u01a8\u01b0\u01c2\u01c4\u01ca\u01cc\u01d1\u01d5\u01db\u01e1\u01e3"+
		"\u01e6\u01ed\u01ef\u01f3\u01f9\u01fe\u0202\u0208\u020e\u0211\u0217\u0219"+
		"\u021f\u0222\u022c\u0230\u0234\u0236\u023c\u0241\u0245\u024b\u0251\u0254"+
		"\u025b\u0263\u026d\u0272\u027b\u0296\u029d\u02a3\u02aa\u02b1\u02b8\u02bb"+
		"\u02d0\u02d5\u02da\u02e0\u02e5\u02ea\u02f1\u02f4\u02f9\u02fc\u0306\u030c"+
		"\u0311\u0319\u031e\u0328\u032d\u0336\u0342\u034c\u0352\u0359\u035e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}