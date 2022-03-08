/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.service.FeaturePathSearchAction;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class FeaturePathAutoCompleteDialogController  {

	@FXML
	private ComboBox<String> comboBox;

	FeaturePathSearchAction featurePathSearchAction = FeaturePathSearchAction.FROM_THE_START;
	Stage dialogStage;
	String featurePathResult = "";

	/**
	 * @return the featurePathSearchAction
	 */
	public FeaturePathSearchAction getFeaturePathSearchAction() {
		return featurePathSearchAction;
	}

	/**
	 * @param featurePathSearchAction the featurePathSearchAction to set
	 */
	public void setFeaturePathSearchAction(FeaturePathSearchAction featurePathSearchAction) {
		this.featurePathSearchAction = featurePathSearchAction;
	}

	/**
	 * @return the featurePathResult
	 */
	public String getFeaturePathResult() {
		return featurePathResult;
	}

	/**
	 * @param featurePathResult the featurePathResult to set
	 */
	public void setFeaturePathResult(String featurePathResult) {
		this.featurePathResult = featurePathResult;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		comboBox.setEditable(true);
		comboBox.setPrefWidth(300.0);
		comboBox.setVisibleRowCount(20);

		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
				comboBox.getEditor().setText(featurePathResult);
				comboBox.requestFocus();
				comboBox.getEditor().positionCaret(featurePathResult.length());
				if (featurePathSearchAction == FeaturePathSearchAction.ANYWHERE) {
					AutoCompleteUtility.autoCompleteComboBoxPlus(comboBox, (typedText, itemToCompare) -> itemToCompare.contains(typedText));
				} else {
					AutoCompleteUtility.autoCompleteComboBoxPlus(comboBox, (typedText, itemToCompare) -> itemToCompare.startsWith(typedText));
				}
		    }
		});
		
		comboBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					handleOK();
					return;
				} else if (event.getCode() == KeyCode.ESCAPE) {
					handleCancel();
				}
			}
		});
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
		this.dialogStage.setOnCloseRequest(event -> {
			handleOK();
		});
	}

	public void setData(ObservableList<String> fsList) {
		comboBox.setItems(fsList);
	}

	@FXML
	private void handleCancel() {
		featurePathResult = "";
		dialogStage.close();
	}
	
	@FXML
	private void handleOK() {
		featurePathResult = AutoCompleteUtility.getComboBoxValue(comboBox);
		dialogStage.close();
	}

	public void setMainApp(MainApp mainApp) {
	}
}
