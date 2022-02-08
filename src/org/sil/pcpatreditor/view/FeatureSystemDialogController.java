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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class FeatureSystemDialogController  {

	@FXML
	private WebView browser;

	private WebEngine webEngine;
	private String htmlContent = "";
	
	Stage dialogStage;
	private ApplicationPreferences preferences;

	/**
	 * @return the htmlContent
	 */
	public String getHtmlContent() {
		return htmlContent;
	}

	/**
	 * @param htmlContent the htmlContent to set
	 */
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		webEngine = browser.getEngine();
		webEngine.loadContent(htmlContent);
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
	}

	@FXML
	private void handleOK() {
		preferences.setLastWindowParameters(ApplicationPreferences.LAST_FEATURE_SYSTEM_DIALOG, dialogStage);
		dialogStage.close();
	}

	public void setMainApp(MainApp mainApp) {
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(ApplicationPreferences.LAST_FEATURE_SYSTEM_DIALOG, dialogStage, 400.,
				400.);
	}
}
