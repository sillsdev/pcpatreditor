/**
 * Copyright (c) 2022-2026 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.SortedSet;

import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.MainApp;
import org.sil.utility.view.ControllerUtilities;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class FeatureSystemDialogController  {

	@FXML
	private WebView browser;
	@FXML
	private Button btnSave;
	MainApp mainApp;
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
		mainApp.getDocumentFile();
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

	@FXML
	private void handleSave() {
		try {
			String webPage = mainApp.getBundle().getString("file.report.webpage");
			String allFiles = mainApp.getBundle().getString("file.report.allfiles");
			FileChooser fileChooser = ControllerUtilities.initFileChooser(mainApp, webPage, "*.html");
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(allFiles, "*.*"));
			File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
			if (file != null) {
				Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath()), "UTF-8"));
				try {
					out.write(htmlContent);
				} finally {
					out.close();
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(ApplicationPreferences.LAST_FEATURE_SYSTEM_DIALOG, dialogStage, 400.,
				400.);
	}
}
