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
import javafx.scene.input.KeyEvent;
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
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		cbIncremental.setDisable(true);
		reportResult.setVisible(false);
		tfFind.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				enableDisableActionButtons();
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
					btnFind.requestFocus();
				}
			}
		});
		cbIncremental.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("i")) {
					cbIncremental.setSelected(cbIncremental.isSelected() ? false : true);
					btnFind.requestFocus();
				}
			}
		});
		cbRegularExpression.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("x")) {
					cbRegularExpression.setSelected(cbRegularExpression.isSelected() ? false : true);
					btnFind.requestFocus();
				}
			}
		});
		cbWholeWord.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("w")) {
					cbWholeWord.setSelected(cbWholeWord.isSelected() ? false : true);
					btnFind.requestFocus();
				}
			}
		});
		cbWrap.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.isAltDown() && ke.getText().equals("p")) {
					cbWrap.setSelected(cbWrap.isSelected() ? false : true);
					btnFind.requestFocus();
				}
			}
		});
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
		btnFind.requestFocus();
	}
	
	@FXML
	public void handleForward() {
		rbForward.setSelected(true);
		btnFind.requestFocus();
	}
	
	@FXML
	public void handleAll() {
		rbAll.setSelected(true);
		btnFind.requestFocus();
	}
	
	@FXML
	public void handleSelection() {
		rbSelection.setSelected(true);
		btnFind.requestFocus();
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
			index = findReplaceOperator.find(0, tfFind.getText());
			index += grammar.getSelection().getStart();
		} else {
			findReplaceOperator.setContent(grammar.getText());
			index = findReplaceOperator.find(grammar.getCaretPosition(), tfFind.getText());
		}
		if (index > -1) {
			grammar.displaceCaret(index);
			grammar.selectRange(index, index + tfFind.getText().length());
			reportResult.setVisible(false);
		} else {
			reportResult.setVisible(true);
			reportResult.setText(bundle.getString("findreplace.report.notfound"));
		}
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
