/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.SortedSet;

import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.MainApp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class ConstituentsDialogController  {

	@FXML
	private ListView<String> nonTerminalsListView;
	@FXML
	private ListView<String> terminalsListView;
	@FXML
	SplitPane splitPane;
	Stage dialogStage;
	private ApplicationPreferences preferences;

	private ObservableList<String> nonTerminals = FXCollections.observableArrayList();
	private ObservableList<String> terminals = FXCollections.observableArrayList();

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		nonTerminalsListView.setEditable(false);
		terminalsListView.setEditable(false);
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

	public void setData(SortedSet<String> sortedSet, SortedSet<String> sortedSet2) {
		this.nonTerminals.setAll(sortedSet);
		nonTerminalsListView.setItems(this.nonTerminals);
		this.terminals.setAll(sortedSet2);
		terminalsListView.setItems(this.terminals);
	}

	@FXML
	private void handleOK() {
		preferences.setLastWindowParameters(ApplicationPreferences.LAST_CONSTITUENTS_DIALOG, dialogStage);
		preferences.setPreferencesKey(ApplicationPreferences.LAST_CONSTITUENTS_DIALOG_SPLITTER_POSITION, splitPane.getDividerPositions()[0]);
		dialogStage.close();
	}

	public void setMainApp(MainApp mainApp) {
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(ApplicationPreferences.LAST_CONSTITUENTS_DIALOG, dialogStage, 400.,
				400.);
		double dp = preferences.getDoubleValue(ApplicationPreferences.LAST_CONSTITUENTS_DIALOG_SPLITTER_POSITION, 0.5);
		splitPane.setDividerPosition(0, dp);
	}
}
