// Copyright (c) 2021 SIL International 
// This software is licensed under the LGPL, version 2.1 or later 
// (http://www.gnu.org/licenses/lgpl-2.1.html) 
/**
 * 
 */
package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.Constants;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.service.FindReplaceOperator;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	private boolean okClicked = false;
	private MainApp mainApp;
	private ResourceBundle bundle;
	private CodeArea grammar;
	private FindReplaceOperator findReplaceOperator;
	private AudioClip beep;
//	private AudioClip beep = new AudioClip("file:/Users/Andy%20Black/Documents/eclipse-workspace/org.sil.pcpatreditor/src/org/sil/pcpatreditor/resources/audio/bell-ring-01.mp3");
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		beep = new AudioClip("file:" + Constants.RESOURCE_SOURCE_LOCATION + "resources/audio/bell-ring-01-short.mp3");
//		cbIncremental.setDisable(true);
		reportResult.setVisible(false);
		tfFind.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				enableDisableActionButtons();
				if (cbIncremental.isSelected() && tfFind.getText().length() > 0) {
					KeyCode code = event.getCode();
					switch (code) {
					case ENTER:
						int adjust = rbForward.isSelected() ? -1 : tfFind.getLength();
						grammar.displaceCaret(Math.max(0, grammar.getCaretPosition() + adjust));
						handleFind();
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
						handleFind();
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
			if (tfReplace.getText().trim().length() > 0) {
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

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setData(CodeArea grammar) {
		this.grammar = grammar;
	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks OK.
	 */
	@FXML
	private void handleOk() {
//		if (initialXCoordinate.getText().length() > 0) {
//			ltTree.setInitialXCoordinate(Double.valueOf(initialXCoordinate.getText()));
//		}
//		if (initialYCoordinate.getText().length() > 0) {
//			ltTree.setInitialYCoordinate(Double.valueOf(initialYCoordinate.getText()));
//		}
//		if (horizontalGap.getText().length() > 0) {
//			ltTree.setHorizontalGap(Double.valueOf(horizontalGap.getText()));
//		}
//		if (verticalGap.getText().length() > 0) {
//			ltTree.setVerticalGap(Double.valueOf(verticalGap.getText()));
//		}
//		if (lexGlossGapAdjustment.getText().length() > 0) {
//			ltTree.setLexGlossGapAdjustment(Double.valueOf(lexGlossGapAdjustment.getText()));
//		}
		okClicked = true;
		dialogStage.close();
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
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
		findReplaceOperator = FindReplaceOperator.getInstance();
		findReplaceOperator.initializeParameters(rbForward.isSelected(), rbAll.isSelected(), cbCase.isSelected(),
				cbWholeWord.isSelected(), cbRegularExpression.isSelected(), cbWrap.isSelected(),
				cbIncremental.isSelected());
		int index = -1;
		if (!rbAll.isSelected()) {
			findReplaceOperator.setContent(grammar.getSelectedText());
			index = performFindOperation(0, tfFind.getText());
			index += grammar.getSelection().getStart();
		} else {
			findReplaceOperator.setContent(grammar.getText());
			int caret = grammar.getCaretPosition();
			if (cbIncremental.isSelected()) {
				caret -= tfFind.getText().length()-1;
			}
			index = performFindOperation(caret, tfFind.getText());
		}
		if (index > -1) {
			grammar.displaceCaret(index);
			int indexEnd = index + tfFind.getText().length();
			if (cbRegularExpression.isSelected()) {
				indexEnd = findReplaceOperator.getRegExEnd();
			}
			grammar.selectRange(index, indexEnd);
			reportResult.setVisible(false);
		} else {
			reportResult.setVisible(true);
			reportResult.setText(bundle.getString("findreplace.report.notfound"));
			beep.play();
		}
	}

	private int performFindOperation(int indexStart, String findMe) {
		int index = -1;
		if (cbRegularExpression.isSelected()) {
			index = findReplaceOperator.findRegularExpression(indexStart, findMe);
		} else {
			index = findReplaceOperator.find(indexStart, findMe);
		}
		return index;
	}
	
	@FXML
	public void handleReplace() {
		System.out.println("replace");
	}

	@FXML
	public void handleReplaceAll() {
		System.out.println("replace all");
	}

	@FXML
	public void handleReplaceFind() {
		System.out.println("replacefind");
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		bundle = mainApp.getBundle();
	}

	/**
	 * Called when the user clicks help.
	 */
	@FXML
	private void handleHelp() {
		// TODO: write custom (English) documentation for this, showing examples
		//mainApp.showNotImplementedYet();
	}

}
