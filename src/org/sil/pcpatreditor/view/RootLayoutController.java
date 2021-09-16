/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;
import org.sil.utility.view.ObservableResourceFactory;
import org.sil.utility.ClipboardUtilities;
import org.sil.utility.StringUtilities;
import org.sil.utility.view.ControllerUtilities;
import org.sil.utility.view.FilteringEventDispatcher;
import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.pcpatrgrammar.antlr4generated.PcPatrGrammarLexer;
import org.reactfx.Subscription;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootLayoutController implements Initializable {
	
	MainApp mainApp;
	ResourceBundle bundle;
	private Locale currentLocale;
	ApplicationPreferences applicationPreferences;
	private String sAboutHeader;
	private String sAboutContent;
	private String sFileFilterDescription;
	private String pcPatrEditorFilterDescription;
	private List<KeyEvent> itemsKeyedDuringPause = new ArrayList<KeyEvent>();
	boolean fIsDirty;
	boolean fOpenBracketJustTyped = false;
	boolean fCloseBracketJustTyped = false;
	boolean fOpenBraceJustTyped = false;
	boolean fCloseBraceJustTyped = false;
	boolean fOpenParenJustTyped = false;
	boolean fCloseParenJustTyped = false;
	boolean fOpenWedgeJustTyped = false;
	boolean fCloseWedgeJustTyped = false;
	protected Clipboard systemClipboard = Clipboard.getSystemClipboard();
    private ExecutorService executor;
    private Subscription cleanupWhenDone;
	private final String kPressedStyle = "buttonpressed";
	private final String kUnPressedStyle = "buttonunpressed";

	@FXML
	BorderPane mainPane;
	@FXML
	CodeArea grammar;
	@FXML
	private Button buttonToolbarFileOpen;
	@FXML
	private Button buttonToolbarFileNew;
	@FXML
	private Button buttonToolbarFileSave;
	@FXML
	private Button buttonToolbarEditCut;
	@FXML
	private Button buttonToolbarEditCopy;
	@FXML
	private Button buttonToolbarEditPaste;
	@FXML
	private Button buttonToolbarEditFindReplace;
	@FXML
	private Button buttonToolbarEditUndo;
	@FXML
	private Button buttonToolbarEditRedo;
	@FXML
	private ToggleButton toggleButtonShowMatchingItemWithArrowKeys;

	@FXML
	private MenuBar menuBar;
	@FXML
	private Menu menuFile;
	@FXML
	private MenuItem menuItemFileNew;
	@FXML
	private MenuItem menuItemFileOpen;
	@FXML
	private MenuItem menuItemFileSaveAs;
	@FXML
	private MenuItem menuItemFileSave;
	@FXML
	private MenuItem menuItemFileExit;
	@FXML
	private Menu menuEdit;
	@FXML
	private MenuItem menuItemEditUndo;
	@FXML
	private MenuItem menuItemEditRedo;
	@FXML
	private MenuItem menuItemEditCut;
	@FXML
	private MenuItem menuItemEditCopy;
	@FXML
	private MenuItem menuItemEditPaste;
	@FXML
	private MenuItem menuItemEditFindReplace;
	@FXML
	private MenuItem menuItemEditGoToLine;
	@FXML
	private Menu menuSettings;
	@FXML
	private CheckMenuItem menuItemShowMatchingItemWithArrowKeys;
	@FXML
	private MenuItem menuItemShowMatchingItemDelay;
	@FXML
	private MenuItem menuItemFontSize;
	@FXML
	private Menu menuHelp;
	@FXML
	private MenuItem menuItemUserDocumentation;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private Tooltip tooltipToolbarFileOpen;
	@FXML
	private Tooltip tooltipToolbarFileNew;
	@FXML
	private Tooltip tooltipToolbarFileSave;
	@FXML
	private Tooltip tooltipToolbarEditCut;
	@FXML
	private Tooltip tooltipToolbarEditCopy;
	@FXML
	private Tooltip tooltipToolbarEditPaste;
	@FXML
	private Tooltip tooltipToolbarEditUndo;
	@FXML
	private Tooltip tooltipToolbarEditRedo;
	@FXML
	private Tooltip tooltipToolbarEditFindReplace;
	@FXML
	private Tooltip tooltipToolbarShowMatchingItemWithArrowKeys;

	@FXML
	private VBox centerVBox;
	@FXML
	private Text statusBar;
	
	// following lines from
	// https://stackoverflow.com/questions/32464974/javafx-change-application-language-on-the-run
	private static final ObservableResourceFactory RESOURCE_FACTORY = ObservableResourceFactory
			.getInstance();
	static {
		RESOURCE_FACTORY.setResources(ResourceBundle.getBundle(Constants.RESOURCE_LOCATION,
				new Locale("en")));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bundle = resources;
		sFileFilterDescription = RESOURCE_FACTORY.getStringBinding("file.filterdescription").get();
		createToolbarButtons(bundle);
		initMenuItemsForLocalization();
		statusBar.textProperty().bind(RESOURCE_FACTORY.getStringBinding("label.key"));

        executor = Executors.newSingleThreadExecutor();
        grammar = new CodeArea();
        grammar.setPrefHeight(1200.0);
        grammar.setPrefWidth(1000.0);
        VirtualizedScrollPane<CodeArea> vsPane = new VirtualizedScrollPane<CodeArea>(grammar);
        centerVBox.getChildren().add(0, vsPane);
        grammar.setParagraphGraphicFactory(LineNumberFactory.get(grammar));
		grammar.setWrapText(false);
        cleanupWhenDone = grammar.multiPlainChanges()
                .successionEnds(Duration.ofMillis(500))
                .supplyTask(this::computeHighlightingAsync)
                .awaitLatest(grammar.multiPlainChanges())
                .filterMap(t -> {
                    if(t.isSuccess()) {
                        return Optional.of(t.get());
                    } else {
                        t.getFailure().printStackTrace();
                        return Optional.empty();
                    }
                })
                .subscribe(this::applyHighlighting);

		grammar.multiPlainChanges().subscribe(event -> {
			// is invoked by find/replace changes, too
			markAsDirty();
		});

		grammar.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				String sCharacter = event.getCharacter();
				if (!grammar.isEditable()) {
					itemsKeyedDuringPause.add(event);
				}
				switch (sCharacter) {
				case "(":
					if (grammar.isEditable()) {
						fOpenParenJustTyped = true;
					}
					markAsDirty();
					break;
				case ")":
					if (grammar.isEditable()) {
						fCloseParenJustTyped = true;
					}
					markAsDirty();
					break;
				case "[":
					if (grammar.isEditable()) {
						fOpenBracketJustTyped = true;
					}
					markAsDirty();
					break;
				case "]":
					if (grammar.isEditable()) {
						fCloseBracketJustTyped = true;
					}
					markAsDirty();
					break;
				case "{":
					if (grammar.isEditable()) {
						fOpenBraceJustTyped = true;
					}
					markAsDirty();
					break;
				case "}":
					if (grammar.isEditable()) {
						fCloseBraceJustTyped = true;
					}
					markAsDirty();
					break;
				case "<":
					if (grammar.isEditable()) {
						fOpenWedgeJustTyped = true;
					}
					markAsDirty();
					break;
				case ">":
					if (grammar.isEditable()) {
						fCloseWedgeJustTyped = true;
					}
					markAsDirty();
					break;
				default:
					if (event.isControlDown()) {
						switch (sCharacter.codePointAt(0)) {
						case 22: // Control-V (paste)
						case 24: // Control-X (cut)
						case 25: // Control-Y (redo)
						case 26: // Control-Z (undo)
							// mark as dirty since they change content
							markAsDirty();
							break;
						default:
							// do not mark as dirty for other control codes
							break;
						}
					} else {
						// some other character was typed so consider it dirty
						markAsDirty();
					}
					break;
				}
				enableDisableRedoUndoButtons();
			}
		});

		// We use OnKeyReleased for arrow keys and to process open and
		// closed parentheses. See above.
		grammar.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (!grammar.isEditable()) {
					itemsKeyedDuringPause.add(event);
					return;
				}
				int index;
				Image mainIcon = mainApp.getNewMainIconImage();
				if (fCloseParenJustTyped) {
					fCloseParenJustTyped = false;
					GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
					// we use caret position - 1 because the caret is after
					// the inserted ')'
					GrammarUIService.processRightItem(grammar,
							grammar.getCaretPosition() - 1, true,
							applicationPreferences.getShowMatchingItemDelay(), '(', ')', bundle, mainIcon);
				} else if (fOpenParenJustTyped) {
					fOpenParenJustTyped = false;
					insertMatchingClosingItem(")");
					GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
					GrammarUIService.processLeftItem(grammar, false,
							'(', ')', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
				} else if (fOpenBracketJustTyped) {
					fOpenBracketJustTyped = false;
					insertMatchingClosingItem("]");
					GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
					GrammarUIService.processLeftItem(grammar, false,
							'[', ']', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
				} else if (fOpenWedgeJustTyped) {
					fOpenWedgeJustTyped = false;
					insertMatchingClosingItem(">");
					GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
					GrammarUIService.processLeftItem(grammar, false,
							'<', '>', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
				} else if (fOpenBraceJustTyped) {
					fOpenBraceJustTyped = false;
					insertMatchingClosingItem("}");
					GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
					GrammarUIService.processLeftItem(grammar, false,
							'{', '}', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
				}
				switch (event.getCode()) {
				// ignore these for redisplaying the tree
				case ALT:
				case ALT_GRAPH:
				case CAPS:
				case CONTROL:
				case DOWN:
				case END:
				case ENTER:
				case ESCAPE:
				case F1:
				case F2:
				case F3:
				case F4:
				case F5:
				case F6:
				case F7:
				case F8:
				case F9:
				case F10:
				case F11:
				case F12:
				case HOME:
				case INSERT:
				case KP_DOWN:
				case KP_UP:
				case PAGE_DOWN:
				case PAGE_UP:
				case PRINTSCREEN:
				case SHIFT:
				case UP:
					break;
				case LEFT:
				case KP_LEFT:
					if (menuItemShowMatchingItemWithArrowKeys.isSelected()) {
						index = grammar.getCaretPosition();
						String item = grammar.getText(index, index + 1);
						switch (item) {
						case ")":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index, false,
									applicationPreferences.getShowMatchingItemDelay(), '(', ')', bundle, mainIcon);
							break;
						case "(":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, false,
									'(', ')', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
							break;
						case "}":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index, false,
									applicationPreferences.getShowMatchingItemDelay(), '{', '}', bundle, mainIcon);
							break;
						case "{":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, false,
									'{', '}', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
							break;
						case "]":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index, false,
									applicationPreferences.getShowMatchingItemDelay(), '[', ']', bundle, mainIcon);
							break;
						case "[":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, false,
									'[', ']', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
							break;
						case ">":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index, false,
									applicationPreferences.getShowMatchingItemDelay(), '<', '>', bundle, mainIcon);
							break;
						case "<":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, false,
									'<', '>', applicationPreferences.getShowMatchingItemDelay(), false, bundle, mainIcon);
							break;
						}
					}
					break;
				case KP_RIGHT:
				case RIGHT:
					if (menuItemShowMatchingItemWithArrowKeys.isSelected()) {
						index = grammar.getCaretPosition();
						String item = grammar.getText(Math.max(0, index - 1), index);
						switch (item) {
						case ")":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index - 1, true,
									applicationPreferences.getShowMatchingItemDelay(), '(', ')', bundle, mainIcon);
							break;
						case "(":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, true, '(', ')',
									applicationPreferences.getShowMatchingItemDelay(), true, bundle, mainIcon);
							break;
						case "}":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index - 1, true,
									applicationPreferences.getShowMatchingItemDelay(), '{', '}', bundle, mainIcon);
							break;
						case "{":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, true, '{', '}',
									applicationPreferences.getShowMatchingItemDelay(), true, bundle, mainIcon);
							break;
						case "]":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index - 1, true,
									applicationPreferences.getShowMatchingItemDelay(), '[', ']', bundle, mainIcon);
							break;
						case "[":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, true, '[', ']',
									applicationPreferences.getShowMatchingItemDelay(), true, bundle, mainIcon);
							break;
						case ">":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processRightItem(grammar, index - 1, true,
									applicationPreferences.getShowMatchingItemDelay(), '<', '>', bundle, mainIcon);
							break;
						case "<":
							GrammarUIService.setItemsKeyedDuringPause(itemsKeyedDuringPause);
							GrammarUIService.processLeftItem(grammar, true, '<', '>',
									applicationPreferences.getShowMatchingItemDelay(), true, bundle, mainIcon);
							break;
						}
					}
					break;
				default:
					break;
				}
			}
		});

		// catch control-V for fixing nulls in clipboard
		// This comes from https://stackoverflow.com/questions/61072150/how-to-overwrite-system-default-keyboard-shortcuts-like-ctrlc-ctrlv-by-using
		// accessed on 23 September 2020.
		// It explains that the TextArea catches the control-V event and prevents it from bubbling up to the scene where
		// we have our menu item catch it.  This custom filter blocks the TextArea from seeing the control-V event.
		grammar.setEventDispatcher(
		        new FilteringEventDispatcher(grammar.getEventDispatcher(), menuItemEditPaste.getAccelerator()));

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				grammar.requestFocus();
			}
		});

		enableDisableRedoUndoButtons();
	}

	private void initializeGrammarFontSize() {
		double size = applicationPreferences.getGrammarFontSize();
		grammar.setStyle("-fx-font-size: " + Double.toString(size) + "pt;");
	}

    private Task<StyleSpans<Collection<String>>> computeHighlightingAsync() {
        String text = grammar.getText();
        Task<StyleSpans<Collection<String>>> task = new Task<StyleSpans<Collection<String>>>() {
            @Override
            protected StyleSpans<Collection<String>> call() throws Exception {
                return computeHighlighting(text);
            }
        };
        executor.execute(task);
        return task;
    }
    private static final String[] KEYWORDS = new String[] {
			"BE", "Be", "be", "CONSTRAINT", "Constraint", "constraint", "DEFINE", "Define", "define", "LET", "Let",
			"let", "LEXICON", "Lexicon", "lexicon", "PARAMETER", "Parameter", "parameter", "RULE", "Rule", "rule"
			};

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SLASH_PATTERN = "/";
    private static final String EQUALS_PATTERN = "=";
    private static final String WEDGE_PATTERN = "\\<|\\>";
//    private static final String SEMICOLON_PATTERN = "\\;";
//    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "\\|[^\n]*";// + "|" + "/\\*(.|\\R)*?\\*/";

    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
            + "|(?<PAREN>" + PAREN_PATTERN + ")"
            + "|(?<BRACE>" + BRACE_PATTERN + ")"
            + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
            + "|(?<WEDGE>" + WEDGE_PATTERN + ")"
            + "|(?<SLASH>" + SLASH_PATTERN + ")"
            + "|(?<EQUALS>" + EQUALS_PATTERN + ")"
//            + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
//            + "|(?<STRING>" + STRING_PATTERN + ")"
            + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                    matcher.group("PAREN") != null ? "paren" :
                    matcher.group("BRACE") != null ? "brace" :
                    matcher.group("BRACKET") != null ? "bracket" :
                    matcher.group("EQUALS") != null ? "equals" :
                    matcher.group("SLASH") != null ? "slash" :
                    matcher.group("WEDGE") != null ? "wedge" :
//                    matcher.group("SEMICOLON") != null ? "semicolon" :
//                    matcher.group("STRING") != null ? "string" :
                    matcher.group("COMMENT") != null ? "comment" :
                    null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

    private void applyHighlighting(StyleSpans<Collection<String>> highlighting) {
        grammar.setStyleSpans(0, highlighting);
    }


	private void initMenuItemsForLocalization() {
		menuFile.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.file"));
		menuItemFileNew.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.new"));
		menuItemFileOpen.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.open"));
		menuItemFileSave.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.save"));
//		menuItemFileSaveAs.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.saveas"));
		menuItemFileExit.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.exit"));
		menuEdit.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.edit"));
		menuItemEditUndo.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.undo"));
		menuItemEditRedo.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.redo"));
		menuItemEditCut.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.cut"));
		menuItemEditCopy.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.copy"));
		menuItemEditPaste.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.paste"));
		menuItemEditFindReplace.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.findreplace"));
		menuItemEditGoToLine.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.gotoline"));
//		menuTree.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.tree"));
//		menuItemDrawTree.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.drawtree"));
//		menuFormat.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.format"));
//		menuItemUseFlatTree.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.useflattree"));
//		menuItemUseRightToLeftOrientation.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.userighttoleftorientation"));
//		menuItemNonTerminalFont.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.nonterminalfont"));
//		menuItemLexicalFont.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.lexicalfont"));
//		menuItemGlossFont.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.glossfont"));
//		menuItemEmptyElementFont.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.emptyelementfont"));
//		menuItemTreeSpacingParameter.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.treespacingparameters"));
//		menuItemBackgroundAndLineParameters.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.backgroundandlineparameters"));
//		menuItemSaveTreeParameters.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.savetreeparameters"));
//		menuSettings.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.settings"));
//		menuItemDescriptionFontSize.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.descriptionfontsize"));
//		menuItemDrawAsType.textProperty()
//				.bind(RESOURCE_FACTORY.getStringBinding("menu.drawastype"));
		menuItemShowMatchingItemWithArrowKeys.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("menu.showmatchingitemwitharrowkeys"));
		menuItemShowMatchingItemDelay.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("menu.showmatchingitemdelay"));
		menuItemFontSize.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("menu.fontsize"));
//		menuItemChangeInterfaceLanguage.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.changeinterfacelanguage"));
//		menuHelp.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.help"));
//		menuItemQuickReferenceGuide.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.quickreferenceguide"));
//		menuItemUserDocumentation.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("menu.userdocumentation"));
//		menuItemAbout.textProperty().bind(RESOURCE_FACTORY.getStringBinding("menu.about"));
	}

	public List<KeyEvent> getItemsKeyedDuringPause() {
		return itemsKeyedDuringPause;
	}

	public boolean isDirty() {
		return fIsDirty;
	}

	private void markAsClean() {
		fIsDirty = false;
		Stage primaryStage = mainApp.getPrimaryStage();
		String sStageTitle = primaryStage.getTitle();
		sStageTitle = sStageTitle.replaceAll("\\*", "");
		primaryStage.setTitle(sStageTitle);
	}

	private void markAsDirty() {
		fIsDirty = true;
		Stage primaryStage = mainApp.getPrimaryStage();
		String sStageTitle = primaryStage.getTitle();
		if (!sStageTitle.endsWith("*")) {
			primaryStage.setTitle(sStageTitle + "*");
		}
	}


	protected void createToolbarButtons(ResourceBundle bundle) {
		tooltipToolbarFileNew = ControllerUtilities.createToolbarButtonWithImage("newAction.png",
				buttonToolbarFileNew, tooltipToolbarFileNew, bundle.getString("tooltip.new"),
				Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarFileNew.textProperty().bind(RESOURCE_FACTORY.getStringBinding("tooltip.new"));
		tooltipToolbarFileOpen = ControllerUtilities.createToolbarButtonWithImage("openAction.png",
				buttonToolbarFileOpen, tooltipToolbarFileOpen, bundle.getString("tooltip.open"),
				Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarFileOpen.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.open"));
		tooltipToolbarFileSave = ControllerUtilities.createToolbarButtonWithImage("saveAction.png",
				buttonToolbarFileSave, tooltipToolbarFileSave, bundle.getString("tooltip.save"),
				Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarFileSave.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.save"));
		tooltipToolbarEditCut = ControllerUtilities.createToolbarButtonWithImage("cutAction.png",
				buttonToolbarEditCut, tooltipToolbarEditCut, bundle.getString("tooltip.cut"),
				Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarEditCut.textProperty().bind(RESOURCE_FACTORY.getStringBinding("tooltip.cut"));
		tooltipToolbarEditCopy = ControllerUtilities.createToolbarButtonWithImage("copyAction.png",
				buttonToolbarEditCopy, tooltipToolbarEditCopy, bundle.getString("tooltip.copy"),
				Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarEditCopy.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.copy"));
		tooltipToolbarEditPaste = ControllerUtilities.createToolbarButtonWithImage(
				"pasteAction.png", buttonToolbarEditPaste, tooltipToolbarEditPaste,
				bundle.getString("tooltip.paste"), Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarEditPaste.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.paste"));
		tooltipToolbarEditFindReplace = ControllerUtilities.createToolbarButtonWithImage("findReplaceAction.png",
				buttonToolbarEditFindReplace, tooltipToolbarEditFindReplace, bundle.getString("tooltip.findreplace"),
				Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarEditFindReplace.textProperty().bind(RESOURCE_FACTORY.getStringBinding("tooltip.findreplace"));
		tooltipToolbarEditUndo = ControllerUtilities.createToolbarButtonWithImage(
				"undoAction.png", buttonToolbarEditUndo, tooltipToolbarEditUndo,
				bundle.getString("tooltip.undo"), Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarEditUndo.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.undo"));
		tooltipToolbarEditRedo = ControllerUtilities.createToolbarButtonWithImage(
				"redoAction.png", buttonToolbarEditRedo, tooltipToolbarEditRedo,
				bundle.getString("tooltip.redo"), Constants.RESOURCE_SOURCE_LOCATION);
		tooltipToolbarEditRedo.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.redo"));

		toggleButtonShowMatchingItemWithArrowKeys.getStyleClass().add(kUnPressedStyle);
		tooltipToolbarShowMatchingItemWithArrowKeys = new Tooltip(RESOURCE_FACTORY
				.getStringBinding("tooltip.showmatchingitemwitharrowkeys").get());
		tooltipToolbarShowMatchingItemWithArrowKeys.textProperty().bind(
				RESOURCE_FACTORY.getStringBinding("tooltip.showmatchingitemwitharrowkeys"));
		toggleButtonShowMatchingItemWithArrowKeys
				.setTooltip(tooltipToolbarShowMatchingItemWithArrowKeys);

//		tooltipToolbarDrawTree = ControllerUtilities.createToolbarButtonWithImage("drawTree.png",
//				buttonToolbarDrawTree, tooltipToolbarDrawTree,
//				bundle.getString("tooltip.drawtree"), Constants.RESOURCE_SOURCE_LOCATION);
//		tooltipToolbarDrawTree.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("tooltip.drawtree"));
//
//		toggleButtonUseFlatTree.getStyleClass().add(kUnPressedStyle);
//		tooltipToolbarUseFlatTree = new Tooltip(bundle.getString("tooltip.useflattree"));
//		toggleButtonUseFlatTree.setTooltip(tooltipToolbarUseFlatTree);
//		tooltipToolbarUseFlatTree.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("tooltip.useflattree"));
//		toggleButtonUseFlatTree.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("label.useflattree"));
//
//		toggleButtonShowMatchingParenWithArrowKeys.getStyleClass().add(kUnPressedStyle);
//		tooltipToolbarShowMatchingParenWithArrowKeys = new Tooltip(RESOURCE_FACTORY
//				.getStringBinding("tooltip.showmatchingparenwitharrowkeys").get());
//		tooltipToolbarShowMatchingParenWithArrowKeys.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("tooltip.showmatchingparenwitharrowkeys"));
//		toggleButtonShowMatchingParenWithArrowKeys
//				.setTooltip(tooltipToolbarShowMatchingParenWithArrowKeys);
//
//		toggleButtonSaveAsPng.getStyleClass().add(kUnPressedStyle);
//		tooltipToolbarSaveAsPng = new Tooltip(RESOURCE_FACTORY
//				.getStringBinding("tooltip.saveaspng").get());
//		tooltipToolbarSaveAsPng.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("tooltip.saveaspng"));
//		toggleButtonSaveAsPng.setTooltip(tooltipToolbarSaveAsPng);
//
//		toggleButtonSaveAsSVG.getStyleClass().add(kUnPressedStyle);
//		tooltipToolbarSaveAsSVG = new Tooltip(RESOURCE_FACTORY
//				.getStringBinding("tooltip.saveassvg").get());
//		tooltipToolbarSaveAsSVG.textProperty().bind(
//				RESOURCE_FACTORY.getStringBinding("tooltip.saveassvg"));
//		toggleButtonSaveAsSVG.setTooltip(tooltipToolbarSaveAsSVG);
//
	}

	public void setLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
		pcPatrEditorFilterDescription = sFileFilterDescription + " ("
				+ Constants.PCPATR_EDITOR_DATA_FILE_EXTENSIONS + ")";
		RESOURCE_FACTORY.setResources(ResourceBundle.getBundle(Constants.RESOURCE_LOCATION,
				currentLocale));
	}

	@FXML
	private void handleShowMatchingItemWithArrowKeys() {
		menuItemShowMatchingItemWithArrowKeys.setSelected(!menuItemShowMatchingItemWithArrowKeys
				.isSelected());
		toggleButtonShowMatchingItemWithArrowKeys = setToggleButtonStyle(
				menuItemShowMatchingItemWithArrowKeys, toggleButtonShowMatchingItemWithArrowKeys);
		applicationPreferences
				.setShowMatchingItemWithArrowKeys(menuItemShowMatchingItemWithArrowKeys
						.isSelected());
		grammar.requestFocus();
	}

	/**
	 * Closes the application.
	 */
	@FXML
	public void handleExit() {
		if (fIsDirty) {
			askAboutSaving();
		}
		cleanupWhenDone.unsubscribe();
		executor.shutdown();
		applicationPreferences.setLastCaretPosition(grammar.getCaretPosition());
		System.exit(0);
	}


	@FXML
	public void handleNewDocument() {
		if (fIsDirty) {
			askAboutSaving();
		}
		String sDirectoryPath = applicationPreferences.getLastOpenedDirectoryPath();
		if (sDirectoryPath == "") {
			// probably creating a new file the first time the program is run;
			// set the directory to the closest we can to a reasonable default
			sDirectoryPath = tryToGetDefaultDirectoryPath();
		}
		applicationPreferences.setLastOpenedDirectoryPath(sDirectoryPath);
		File fileCreated = ControllerUtilities.doFileSaveAs(mainApp, currentLocale, false,
				pcPatrEditorFilterDescription, RESOURCE_FACTORY.getStringBinding("file.new").get(),
				Constants.PCPATR_EDITOR_DATA_FILE_EXTENSION, Constants.PCPATR_EDITOR_DATA_FILE_EXTENSIONS,
				Constants.RESOURCE_LOCATION);
		if (fileCreated != null) {
			grammar.replaceText("");
			grammar.moveTo(0);
			grammar.requestFollowCaret();
			mainApp.updateStageTitle(fileCreated);
			try {
				handleSaveDocument();
			} catch (IOException e) {
				e.printStackTrace();
				MainApp.reportException(e, null);
			}
		} else {
			grammar = null;
		}
		initGrammar();
	}

	protected String tryToGetDefaultDirectoryPath() {
		String sDirectoryPath = System.getProperty("user.home") + File.separator;
		File dir = new File(sDirectoryPath);
		if (dir.exists()) {
			// See if there is a "Documents" directory as Windows, Linux, and
			// Mac OS X tend to have
			String sDocumentsDirectoryPath = sDirectoryPath + "Documents" + File.separator;
			dir = new File(sDocumentsDirectoryPath);
			if (dir.exists()) {
				// Try and find or make the "My LingTree" subdirectory of
				// Documents
				String sMyLingTreeDirectoryPath = sDocumentsDirectoryPath
						+ Constants.DEFAULT_DIRECTORY_NAME + File.separator;
				dir = new File(sMyLingTreeDirectoryPath);
				if (dir.exists()) {
					sDirectoryPath = sMyLingTreeDirectoryPath;
				} else {
					boolean success = (dir.mkdir());
					if (success) {
						sDirectoryPath = sMyLingTreeDirectoryPath;
					} else {
						sDirectoryPath = sDocumentsDirectoryPath;
					}
				}
			}
		} else { // give up; let user set it
			sDirectoryPath = "";
		}
		return sDirectoryPath;
	}

	/**
	 * Opens a FileChooser to let the user select a tree to load.
	 */
	@FXML
	public void handleOpenDocument() {
		if (fIsDirty) {
			askAboutSaving();
		}
		doFileOpen(false);
		initGrammar();
		grammar.moveTo(0);
		grammar.requestFocus();
	}


	public void initGrammar() {
		grammar.getUndoManager().forgetHistory();
		grammar.requestFollowCaret();

		int caret = applicationPreferences.getLastCaretPosition();
		caret = (caret > grammar.getText().length()) ? 0 : caret;
		grammar.moveTo(caret);
		grammar.requestFocus();
		markAsClean();
	}

	public File doFileOpen(Boolean fCloseIfCanceled) {
		File file = ControllerUtilities.getFileToOpen(mainApp, pcPatrEditorFilterDescription,
				Constants.PCPATR_EDITOR_DATA_FILE_EXTENSIONS);
		if (file != null) {
			try {
				mainApp.loadDocument(file);
				String content = new String(Files.readAllBytes(file.toPath()),
						StandardCharsets.UTF_8);
		        grammar.replaceText(content);

			} catch (IOException e) {
				e.printStackTrace();
				MainApp.reportException(e, null);
			}

			String sDirectoryPath = file.getParent();
			applicationPreferences.setLastOpenedDirectoryPath(sDirectoryPath);
		} else if (fCloseIfCanceled) {
			// probably first time running and user chose to open a file
			// but then canceled. We quit.
			System.exit(0);
		}
		return file;
	}

	public void askAboutSaving() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "");
		alert.setTitle(MainApp.kApplicationTitle);
		alert.setHeaderText(RESOURCE_FACTORY.getStringBinding("file.asktosaveheader").get());
		alert.setContentText(RESOURCE_FACTORY.getStringBinding("file.asktosavecontent").get());
		ButtonType buttonYes = new ButtonType(bundle.getString("label.yes"), ButtonData.YES);
		ButtonType buttonNo = new ButtonType(bundle.getString("label.no"), ButtonData.NO);
		alert.getButtonTypes().setAll(buttonYes, buttonNo);

		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(mainApp.getNewMainIconImage());

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.YES) {
			try {
				handleSaveDocument();
			} catch (IOException e) {
				e.printStackTrace();
				MainApp.reportException(e, null);
			}
		}
	}

	/**
	 * Saves the file to the tree file that is currently open. If there is no
	 * open file, the "save as" dialog is shown.
	 *
	 * @throws IOException
	 */
	@FXML
	public void handleSaveDocument() throws IOException {
		File file = mainApp.getDocumentFile();
		if (file != null) {
			writeGrammarToFile(file);
		} else {
			handleSaveDocumentAs();
		}
		grammar.requestFocus();
	}


	/**
	 * @param file
	 * @throws IOException
	 */
	private void writeGrammarToFile(File file) throws IOException {
		if (Files.exists(file.toPath())) {
			Files.write(file.toPath(), grammar.getText().getBytes(), StandardOpenOption.WRITE);
		} else {
			Files.write(file.toPath(), grammar.getText().getBytes(), StandardOpenOption.CREATE);
		}
		markAsClean();
	}

	@FXML
	private void handleSaveDocumentAs() throws IOException {
		File file = ControllerUtilities.doFileSaveAs(mainApp, currentLocale, false, pcPatrEditorFilterDescription,
				null, Constants.PCPATR_EDITOR_DATA_FILE_EXTENSION,
				Constants.PCPATR_EDITOR_DATA_FILE_EXTENSIONS, Constants.RESOURCE_LOCATION);
		if (file != null) {
			writeGrammarToFile(file);
		}
		markAsClean();
	}

	@FXML
	private void handleAbout() {
		sAboutHeader = RESOURCE_FACTORY.getStringBinding("about.header").get();
		Object[] args = { Constants.VERSION_NUMBER };
		MessageFormat msgFormatter = new MessageFormat("");
		msgFormatter.setLocale(currentLocale);
		msgFormatter.applyPattern(RESOURCE_FACTORY.getStringBinding("about.content").get());
		sAboutContent = msgFormatter.format(args);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(sAboutHeader);
		alert.setHeaderText(null);
		alert.setContentText(sAboutContent);
		Image silLogo = ControllerUtilities.getIconImageFromURL(
				"file:resources/images/SILLogo.png", Constants.RESOURCE_SOURCE_LOCATION);
		alert.setGraphic(new ImageView(silLogo));
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(mainApp.getNewMainIconImage());
		alert.showAndWait();
	}

	@FXML
	private void handleUserDocumentation() {
		showFileToUser("doc/UserDocumentation.pdf");
	}

	protected void showFileToUser(String sFileToShow) {
		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File(sFileToShow);
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				// no application registered for PDFs
				MainApp.reportException(ex, null);
			}
		}
	}

	@FXML
	protected void handleCopy() {
		grammar.copy();
		grammar.requestFocus();
	}

	@FXML
	protected void handleCut() {
		grammar.cut();
	}

	@FXML
	protected void handlePaste() {
		ClipboardUtilities.removeAnyFinalNullFromStringOnClipboard();
		// now our possibly adjusted string is on the clipboard; do a paste
		grammar.paste();
		grammar.requestFocus();
	}

	@FXML
	protected void handleUndo() {
		grammar.undo();
		enableDisableRedoUndoButtons();
	}

	@FXML
	protected void handleRedo() {
		grammar.redo();
		enableDisableRedoUndoButtons();
	}

	private void enableDisableRedoUndoButtons() {
		if (grammar.isRedoAvailable()) {
			buttonToolbarEditRedo.setDisable(false);
		} else {
			buttonToolbarEditRedo.setDisable(true);
		}
		if (grammar.isUndoAvailable()) {
			buttonToolbarEditUndo.setDisable(false);
		} else {
			buttonToolbarEditUndo.setDisable(true);
			if (mainApp != null) {
				markAsClean();
			}
		}
	}

	@FXML
	protected void handleFindReplace() {
		try {
			// Load the fxml file and create a new stage for the popup.
			Stage dialogStage = new Stage();
			String resource = "fxml/FindReplaceDialog.fxml";
			String title = RESOURCE_FACTORY.getStringBinding("findreplace.title").get();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootLayoutController.class.getResource(resource));
			loader.setResources(ResourceBundle.getBundle(Constants.RESOURCE_LOCATION, currentLocale));

			BorderPane page = loader.load();
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(mainApp.getPrimaryStage());
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			// set the icon
			dialogStage.getIcons().add(mainApp.getNewMainIconImage());
			dialogStage.setTitle(title);

			FindReplaceDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setMainApp(mainApp);
			controller.setData(grammar);
			dialogStage.initModality(Modality.NONE);
			dialogStage.show();
//			if (controller.isOkClicked()) {
//				markAsDirty();
//			}
		} catch (IOException e) {
			e.printStackTrace();
			MainApp.reportException(e, null);
		}
	}

	@FXML
	protected void handleGoToLine() {
		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle(bundle.getString("label.gotoline"));
		dialog.setHeaderText(null);
		dialog.setContentText(bundle.getString("label.entergotoline"));
		dialog.initOwner(mainApp.getPrimaryStage());
		final UnaryOperator<TextFormatter.Change> filter;
		filter = new UnaryOperator<TextFormatter.Change>() {
			@Override
			public TextFormatter.Change apply(TextFormatter.Change change) {
				String text = change.getText();
				for (int i = 0; i < text.length(); i++) {
					if (!Character.isDigit(text.charAt(i)) && text.charAt(i) != '.' && text.charAt(i) != '-')
						return null;
				}
				return change;
			}
		};
		dialog.getEditor().setTextFormatter(new TextFormatter<String>(filter));

		Optional<String> result = dialog.showAndWait();
		result.ifPresent(lineNo -> {
			int line = Integer.valueOf(lineNo) - 1;
			line = Math.min(line, grammar.getParagraphs().size());
			line = Math.max(line, 0);
			grammar.moveTo(line, 0);
			grammar.requestFollowCaret();
		});
	}

	@FXML
	private void handleMenuShowMatchingParenDelay() {
		final Double[] delayValues = new Double[] { 125d, 250d, 375d, 500d, 625d, 750d, 875d, 1000d,
				1125d, 1250d, 1375d, 1500d, 1625d, 1750d, 1875d, 2000d, 2125d, 2250d, 2375d, 2500d,
				2625d, 2750d, 2875d, 3000d, 3125d, 3250d, 3375d, 3500d, 3625d, 3750d, 3875d, 4000d };
		ChoiceDialog<Double> dialog = new ChoiceDialog<>(750d, delayValues);
		dialog.setTitle(RESOURCE_FACTORY.getStringBinding("showmatchingparendelay.header").get());
		dialog.setHeaderText(RESOURCE_FACTORY.getStringBinding("showmatchingparendelay.content")
				.get());
		dialog.setContentText(RESOURCE_FACTORY.getStringBinding("showmatchingparendelay.choose")
				.get());
		dialog.setSelectedItem(applicationPreferences.getShowMatchingItemDelay());
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(mainApp.getNewMainIconImage());
		Optional<Double> result = dialog.showAndWait();
		if (result.isPresent()) {
			applicationPreferences.setShowMatchingItemDelay(result.get());
		}
	}

	@FXML
	private void handleFontSize() {
		final Double[] fontSizes = new Double[] { 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d, 11d, 12d, 13d,
				14d, 15d, 16d, 17d, 18d, 19d, 20d, 21d, 22d, 23d, 24d, 25d, 26d, 27d, 28d, 29d,
				30d, 31d, 32d, 33d, 34d, 35d, 36d, 37d, 38d, 39d, 40d, 41d, 42d, 43d, 44d, 45d,
				46d, 47d, 48d, 49d, 50d, 51d, 52d, 53d, 54d, 55d, 56d, 57d, 58d, 59d, 60d, 61d,
				62d, 63d, 64d, 65d, 66d, 67d, 68d, 69d, 70d, 71d, 72d };
		ChoiceDialog<Double> dialog = new ChoiceDialog<>(12d, fontSizes);
		dialog.setTitle(RESOURCE_FACTORY.getStringBinding("grammarfontsize.header").get());
		dialog.setHeaderText(RESOURCE_FACTORY.getStringBinding("grammarfontsize.content").get());
		dialog.setContentText(RESOURCE_FACTORY.getStringBinding("grammarfontsize.choose").get());
		dialog.setSelectedItem(applicationPreferences.getGrammarFontSize());
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(mainApp.getNewMainIconImage());
		Optional<Double> result = dialog.showAndWait();
		if (result.isPresent()) {
			applicationPreferences.setGrammarFontSize(result.get());
		}
		initializeGrammarFontSize();
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	/**
	 * @return the bundle
	 */
	public ResourceBundle getBundle() {
		return bundle;
	}

	private String getCurrentLocaleCode() {
		return "_" + currentLocale.getLanguage();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		this.applicationPreferences = mainApp.getApplicationPreferences();
		menuItemShowMatchingItemWithArrowKeys.setSelected(applicationPreferences
				.getShowMatchingItemWithArrowKeys());
		toggleButtonShowMatchingItemWithArrowKeys = setToggleButtonStyle(
				menuItemShowMatchingItemWithArrowKeys, toggleButtonShowMatchingItemWithArrowKeys);
		initializeGrammarFontSize();
		grammar.replaceText(mainApp.getContent());
		initGrammar();
//		grammar.requestFollowCaret();
//		int caret = applicationPreferences.getLastCaretPosition();
//		caret = (caret > grammar.getText().length()) ? 0 : caret;
//		grammar.moveTo(caret);
//		defaultFont = new Font(applicationPreferences.getTreeDescriptionFontSize());
	}

	public void setGrammarContents(String contents) {
		grammar.replaceText(contents);
	}

	/**
	 * @param closingItem
	 */
	private void insertMatchingClosingItem(String closingItem) {
		int i = grammar.getCaretPosition();
		String contents = grammar.getText();
		contents = contents.substring(0, i) + closingItem + contents.substring(i);
		grammar.replaceText(contents);
		grammar.moveTo(i);
	}

	private ToggleButton setToggleButtonStyle(CheckMenuItem menuItem, ToggleButton toggleButton) {
		if (menuItem.isSelected()) {
			int i = toggleButton.getStyleClass().indexOf(kUnPressedStyle);
			if (i >= 0) {
				toggleButton.getStyleClass().remove(i);
			}
			toggleButton.getStyleClass().add(kPressedStyle);
		} else {
			int i = toggleButton.getStyleClass().indexOf(kPressedStyle);
			if (i >= 0) {
				toggleButton.getStyleClass().remove(i);
			}
			toggleButton.getStyleClass().add(kUnPressedStyle);
		}
		return toggleButton;
	}

	@FXML
	private void handleMenuShowMatchingItemDelay() {
		final Double[] fontSizes = new Double[] { 125d, 250d, 375d, 500d, 625d, 750d, 875d, 1000d,
				1125d, 1250d, 1375d, 1500d, 1625d, 1750d, 1875d, 2000d, 2125d, 2250d, 2375d, 2500d,
				2625d, 2750d, 2875d, 3000d, 3125d, 3250d, 3375d, 3500d, 3625d, 3750d, 3875d, 4000d };
		ChoiceDialog<Double> dialog = new ChoiceDialog<>(750d, fontSizes);
		dialog.setTitle(RESOURCE_FACTORY.getStringBinding("showmatchingitemdelay.header").get());
		dialog.setHeaderText(RESOURCE_FACTORY.getStringBinding("showmatchingitemdelay.content")
				.get());
		dialog.setContentText(RESOURCE_FACTORY.getStringBinding("showmatchingitemdelay.choose")
				.get());
		dialog.setSelectedItem(applicationPreferences.getShowMatchingItemDelay());
		Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
		stage.getIcons().add(mainApp.getNewMainIconImage());
		Optional<Double> result = dialog.showAndWait();
		if (result.isPresent()) {
			applicationPreferences.setShowMatchingItemDelay(result.get());
		}
	}

	@FXML
	private void handleMenuShowMatchingItemWithArrowKeys() {
		toggleButtonShowMatchingItemWithArrowKeys = setToggleButtonStyle(
				menuItemShowMatchingItemWithArrowKeys, toggleButtonShowMatchingItemWithArrowKeys);
		applicationPreferences
				.setShowMatchingItemWithArrowKeys(menuItemShowMatchingItemWithArrowKeys
						.isSelected());
	}

	// code taken from
	// http://bekwam.blogspot.com/2014/10/cut-copy-and-paste-from-javafx-menubar.html
	@FXML
	public void handleShowingEditMenu() {
		if (systemClipboard == null) {
			systemClipboard = Clipboard.getSystemClipboard();
		}

		if (systemClipboard.hasString()) {
			adjustForClipboardContents();
		} else {
			adjustForEmptyClipboard();
		}

		if (anythingSelected()) {
			adjustForSelection();

		} else {
			adjustForDeselection();
		}
		if (grammar.isUndoAvailable()) {
			menuItemEditUndo.setDisable(false);
		} else {
			menuItemEditUndo.setDisable(true);
		}
		if (grammar.isRedoAvailable()) {
			menuItemEditRedo.setDisable(false);
		} else {
			menuItemEditRedo.setDisable(true);
		}
	}


	// **************************************************
	// code taken from
	// http://bekwam.blogspot.com/2014/10/cut-copy-and-paste-from-javafx-menubar.html
	public void adjustForEmptyClipboard() {
		menuItemEditPaste.setDisable(true); // nothing to paste
	}

	// code taken from
	// http://bekwam.blogspot.com/2014/10/cut-copy-and-paste-from-javafx-menubar.html
	private void adjustForClipboardContents() {
		menuItemEditPaste.setDisable(false); // something to paste
	}

	// code taken from
	// http://bekwam.blogspot.com/2014/10/cut-copy-and-paste-from-javafx-menubar.html
	private void adjustForSelection() {
		menuItemEditCut.setDisable(false);
		menuItemEditCopy.setDisable(false);
	}

	// code taken from
	// http://bekwam.blogspot.com/2014/10/cut-copy-and-paste-from-javafx-menubar.html
	private void adjustForDeselection() {
		menuItemEditCut.setDisable(true);
		menuItemEditCopy.setDisable(true);
	}

	public void setViewItemUsed(int value) {
		// default is to do nothing
	}

	boolean anythingSelected() {
		String sSelected = grammar.getSelectedText();
		if (!StringUtilities.isNullOrEmpty(sSelected)) {
			return true;
		}
		return false;
	}
}
