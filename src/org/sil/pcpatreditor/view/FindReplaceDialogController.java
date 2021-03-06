// Copyright (c) 2021 SIL International 
// This software is licensed under the LGPL, version 2.1 or later 
// (http://www.gnu.org/licenses/lgpl-2.1.html) 
/**
 * 
 */
package org.sil.pcpatreditor.view;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.service.FindReplaceOperator;
import org.sil.utility.view.ObservableResourceFactory;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Andy Black
 *
 */
public class FindReplaceDialogController implements Initializable {

	@FXML
	private Label prompt;
	@FXML
	private Text reportResult;
	@FXML
	private TextField tfFind;
	@FXML
	private TextField tfReplace;
	@FXML
	ToggleGroup tgDirection;
	@FXML
	ToggleGroup tgScope;
	@FXML
	private RadioButton rbBackward;
	@FXML
	private RadioButton rbForward;
	@FXML
	private RadioButton rbAll;
	@FXML
	private RadioButton rbSelection;
	@FXML
	private CheckBox cbCase;
	@FXML
	private CheckBox cbIncremental;
	@FXML
	private CheckBox cbRegularExpression;
	@FXML
	private CheckBox cbWholeWord;
	@FXML
	private CheckBox cbWrap;
	@FXML
	private Button btnFind;
	@FXML
	private Button btnReplace;
	@FXML
	private Button btnReplaceFind;
	@FXML
	private Button btnReplaceAll;

	Stage dialogStage;
	private ApplicationPreferences preferences;
	private ResourceBundle bundle;
	private CodeArea grammar;
	private FindReplaceOperator findReplaceOperator;
	private boolean initializing = true;

	// following lines from
	// https://stackoverflow.com/questions/32464974/javafx-change-application-language-on-the-run
	private static final ObservableResourceFactory RESOURCE_FACTORY = ObservableResourceFactory
			.getInstance();
	static {
		RESOURCE_FACTORY.setResources(ResourceBundle.getBundle(Constants.RESOURCE_LOCATION,
				new Locale("en")));
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		reportResult.setVisible(false);
		tfFind.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (grammar != null && tfFind.getText().length() == 0) {
						int caret = Math.max(0,grammar.getCaretPosition()-1);
						grammar.selectRange(caret, caret);
					}
				});
		tfFind.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				enableDisableActionButtons();
				if (cbIncremental.isSelected() && tfFind.getText().length() > 0) {
					KeyCode code = event.getCode();
					switch (code) {
					case ENTER:
						int adjust = rbForward.isSelected() ? -1 : tfFind.getLength();
						grammar.moveTo(Math.max(0, grammar.getCaretPosition() + adjust));
						processInitializing();
						break;
					case BACK_SPACE:
						adjust = rbForward.isSelected() ? -(tfFind.getLength() + 1) : tfFind.getLength();
						grammar.moveTo(Math.max(0, grammar.getCaretPosition() + adjust));
						processInitializing();
						break;
					// ignore all of these
					case ALT:
					case ALT_GRAPH:
					case CAPS:
					case CONTROL:
					case DOWN:
					case END:
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
					default:
						processInitializing();
						break;
					}
				}
			}
		});
		tfReplace.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				enableDisableActionButtons();
			}
		});
		enableDisableActionButtons();
		cbCase.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("c")) {
					cbCase.setSelected(cbCase.isSelected() ? false : true);
					resetFocusToFindTextField();
				}
			}
		});
		cbCase.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				resetFocusToFindTextField();
			}
		});
		cbIncremental.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("i")) {
					cbIncremental.setSelected(cbIncremental.isSelected() ? false : true);
					if (cbIncremental.isSelected()) {
						cbRegularExpression.setSelected(false);
					}
					resetFocusToFindTextField();
				}
			}
		});
		cbIncremental.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				if (cbIncremental.isSelected()) {
					cbRegularExpression.setSelected(false);
					resetFocusToFindTextField();
				}
			}
		});
		cbRegularExpression.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("x")) {
					cbRegularExpression.setSelected(cbRegularExpression.isSelected() ? false : true);
					if (cbRegularExpression.isSelected()) {
						cbIncremental.setSelected(false);
					}
					resetFocusToFindTextField();
				}
			}
		});
		cbRegularExpression.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				if (cbRegularExpression.isSelected()) {
					cbIncremental.setSelected(false);
					resetFocusToFindTextField();
				}
			}
		});
		cbWholeWord.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("w")) {
					cbWholeWord.setSelected(cbWholeWord.isSelected() ? false : true);
					resetFocusToFindTextField();
				}
			}
		});
		cbWholeWord.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				resetFocusToFindTextField();
			}
		});
		cbWrap.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("p")) {
					cbWrap.setSelected(cbWrap.isSelected() ? false : true);
					resetFocusToFindTextField();
				}
			}
		});
		cbWrap.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				resetFocusToFindTextField();
			}
		});
	}

	private void resetFocusToFindTextField() {
		tfFind.requestFocus();
		tfFind.positionCaret(tfFind.getLength());
	}

	private void enableDisableActionButtons() {
		if (tfFind.getText().trim().length() > 0) {
			btnFind.setDisable(false);
			if (tfReplace.getText().length() > 0 && textSelected()) {
				btnReplace.setDisable(false);
				btnReplaceFind.setDisable(false);
				btnReplaceAll.setDisable(false);
			} else {
				btnReplace.setDisable(true);
				btnReplaceFind.setDisable(true);
				btnReplaceAll.setDisable(true);
			}
		} else {
			btnFind.setDisable(true);
			btnReplace.setDisable(true);
			btnReplaceFind.setDisable(true);
			btnReplaceAll.setDisable(true);
		}
	}

	private boolean textSelected() {
		return grammar.getSelectedText().length() > 0;
	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
		dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				rememberPreferences();
			}
		});
	}

	private void rememberPreferences() {
		preferences.setLastWindowParameters(ApplicationPreferences.LAST_FIND_REPLACE_DIALOG,
				dialogStage);
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_FORWARD, rbForward.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_ALL, rbAll.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_CASE_SENSITIVE, cbCase.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_WHOLE_WORD, cbWholeWord.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_REGULAR_EXPRESSION, cbRegularExpression.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_WRAP_SEARCH, cbWrap.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_INCREMENTAL, cbIncremental.isSelected());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_FIND, tfFind.getText());
		preferences.setPreferencesKey(ApplicationPreferences.FIND_REPLACE_LAST_REPLACE, tfReplace.getText());
	}

	public void setData(CodeArea grammar) {
		this.grammar = grammar;
		if (grammar.getSelectedText().length() > 0) {
			tfFind.setText(grammar.getSelectedText());
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		rememberPreferences();
		dialogStage.close();
	}

	@FXML
	public void handleBackward() {
		rbBackward.setSelected(true);
		resetFocusToFindTextField();
	}
	
	@FXML
	public void handleForward() {
		rbForward.setSelected(true);
		resetFocusToFindTextField();
	}
	
	@FXML
	public void handleAll() {
		rbAll.setSelected(true);
		resetFocusToFindTextField();
	}
	
	@FXML
	public void handleSelection() {
		rbSelection.setSelected(true);
		resetFocusToFindTextField();
	}

	@FXML
	public void handleFind() {
		findPerformed();
		enableDisableActionButtons();
	}

	private boolean findPerformed() {
		boolean findDone = false;
		findReplaceOperator = FindReplaceOperator.getInstance();
		findReplaceOperator.initializeParameters(rbForward.isSelected(), cbCase.isSelected(), cbWholeWord.isSelected(),
				cbRegularExpression.isSelected(), cbWrap.isSelected());
		int index = -1;
		if (rbSelection.isSelected()) {
			findReplaceOperator.setContent(grammar.getSelectedText());
			index = performFindOperation(0, tfFind.getText());
			if (index > -1) {
				index += grammar.getSelection().getStart();
			}
		} else {
			findReplaceOperator.setContent(grammar.getText());
			int caret = grammar.getCaretPosition();
			if (cbIncremental.isSelected()) {
				caret -= tfFind.getText().length()-1;
				caret = Math.max(0, caret);
			}
			index = performFindOperation(caret, tfFind.getText());
		}
		if (index > -1) {
			grammar.requestFollowCaret();
			grammar.moveTo(index);
			int indexEnd = index + tfFind.getText().length();
			boolean resultVisible = false;
			if (cbRegularExpression.isSelected()) {
				indexEnd = Math.max(index, findReplaceOperator.getRegExEnd());
				if (!findReplaceOperator.isRePatternParsed()) {
					resultVisible = true;
				}
			}
			grammar.selectRange(index, indexEnd);
			reportResult.setVisible(resultVisible);
			findDone = true;
		} else {
			reportResult.setVisible(true);
			reportResult.setFill(Color.BLACK);
			reportResult.setText(bundle.getString("findreplace.report.notfound"));
			MainApp.playBeep();
		}
		return findDone;
	}

	private int performFindOperation(int indexStart, String findMe) {
		int index = -1;
		if (cbRegularExpression.isSelected()) {
			index = findReplaceOperator.findRegularExpression(indexStart, findMe);
			if (!findReplaceOperator.isRePatternParsed()) {
				reportResult.setVisible(true);
				reportResult.setFill(Color.RED);
				String patternError = findReplaceOperator.getRePatternErrorMessage();
				reportResult.setText(patternError);
				MainApp.playBeep();
				index = indexStart;
			}
		} else {
			index = findReplaceOperator.find(indexStart, findMe);
		}
		return index;
	}
	
	@FXML
	public void handleReplace() {
		replacePerformed();
		enableDisableActionButtons();
	}

	private boolean replacePerformed() {
		boolean replaceDone = false;
		if (textSelected()) {
			String replacement = "";
			if (!cbRegularExpression.isSelected()) {
				replacement = tfReplace.getText();
			} else {
				Matcher matcher = findReplaceOperator.getMatcher();
				Pattern rePattern = findReplaceOperator.getRePattern();
				int reEnd = findReplaceOperator.getRegExEnd();
				matcher = rePattern.matcher(grammar.getSelectedText());
				matcher.find();
				try {
					replacement = matcher.replaceFirst(tfReplace.getText());
				} catch (IndexOutOfBoundsException e) {
					reportResult.setVisible(true);
					reportResult.setFill(Color.RED);
					String patternError = e.getMessage();
					reportResult.setText(patternError);
					MainApp.playBeep();
					return false;
				} catch (Exception e) {
					e.printStackTrace();
					MainApp.reportException(e, null);
					return false;
				}
			}
			grammar.replaceSelection(replacement);
			replaceDone = true;
		}
		return replaceDone;
	}

	@FXML
	public void handleReplaceAll() {
		if (rbSelection.isSelected()) {
			// won't work; tell user
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(bundle.getString("findreplace.alert.sorry"));
			alert.setHeaderText(null);
			alert.setContentText(bundle.getString("findreplace.alert.replaceallnotworkwithselection"));
			alert.initOwner(dialogStage);
			alert.showAndWait();
			return;
		}
		int count = 0;
		int caretOriginal = grammar.getCaretPosition();
		int caretNow = caretOriginal;
		int caretFinal = -1;
		while (replacePerformed()) {
			count++;
			if (cbWrap.isSelected()) {
				// avoid infinite loop
				caretNow = grammar.getCaretPosition();
				if (rbForward.isSelected()) {
					if (caretNow <= caretOriginal && count > 1) {
						grammar.moveTo(caretFinal);
						reportCountOfReplacments(--count);
						break;
					}
				} else {
					if (caretNow >= caretOriginal && count > 1) {
						grammar.moveTo(caretFinal);
						reportCountOfReplacments(--count);
						break;
					}
				}
				caretFinal = caretNow;
			}
			if (!findPerformed()) {
				reportCountOfReplacments(count);
				break;
			}
		}
	}

	/**
	 * @param count
	 */
	private void reportCountOfReplacments(int count) {
		reportResult.setVisible(true);
		reportResult.setFill(Color.BLACK);
		Object[] args = { count };
		MessageFormat msgFormatter = new MessageFormat("");
		msgFormatter.setLocale(bundle.getLocale());
		msgFormatter
				.applyPattern(RESOURCE_FACTORY.getStringBinding("findreplace.report.replacementsmade").get());
		String sMessage = msgFormatter.format(args);
		reportResult.setText(sMessage);
		MainApp.playBeep();
	}

	@FXML
	public void handleReplaceFind() {
		handleReplace();
		handleFind();
	}
	
	public void setMainApp(MainApp mainApp) {
		bundle = mainApp.getBundle();
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(
				ApplicationPreferences.LAST_FIND_REPLACE_DIALOG, dialogStage, 450., 381.);
		rbForward.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_FORWARD, true));
		rbBackward.setSelected(!rbForward.isSelected());
		rbAll.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_ALL, true));
		rbSelection.setSelected(!rbAll.isSelected());
		cbCase.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_CASE_SENSITIVE, false));
		cbWholeWord.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_WHOLE_WORD, false));
		cbRegularExpression.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_REGULAR_EXPRESSION, false));
		cbWrap.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_WRAP_SEARCH, false));
		cbIncremental.setSelected(preferences.getBooleanValue(ApplicationPreferences.FIND_REPLACE_LAST_INCREMENTAL, false));
		tfFind.setText(preferences.getStringValue(ApplicationPreferences.FIND_REPLACE_LAST_FIND, ""));
		tfFind.selectAll();
		tfReplace.setText(preferences.getStringValue(ApplicationPreferences.FIND_REPLACE_LAST_REPLACE, ""));
		tfReplace.selectAll();
		enableDisableActionButtons();
	}

	private void processInitializing() {
		if (initializing) {
			initializing = false;
		} else {
			handleFind();
		}
	}

}
