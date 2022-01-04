/**
 * Copyright (c) 2021-2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */
package org.sil.pcpatreditor;
	
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import org.sil.utility.MainAppUtilities;
import org.sil.utility.StringUtilities;
import org.sil.utility.view.ControllerUtilities;
import org.sil.pcpatreditor.view.RootLayoutController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.fxml.FXMLLoader;

public class MainApp extends Application  implements MainAppUtilities {
	private static final String kApplicationIconResource = "file:resources/images/PcPatrEditor256x256.png";

	private Stage primaryStage;
	private BorderPane rootLayout;
	private Locale locale;
	private ResourceBundle bundle;
	public static String kApplicationTitle = "PcPatr Editor";
	private RootLayoutController controller;
	private ApplicationPreferences applicationPreferences;
	private final String sOperatingSystem = System.getProperty("os.name");
	static String[] userArgs;
	File documentFile;
	String content;
	
	/**
	 * @param userArgs the userArgs to set
	 */
	public static void setUserArgs(String[] userArgs) {
		MainApp.userArgs = userArgs;
	}

	/**
	 * @return the sOperatingSystem
	 */
	public String getOperatingSystem() {
		return sOperatingSystem;
	}

	/**
	 * @return the documentFile
	 */
	public File getDocumentFile() {
		String filePath = applicationPreferences.getLastOpenedFilePath();
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	/**
	 * @param documentFile the documentFile to set
	 */
	public void setDocumentFile(File documentFile) {
		this.documentFile = documentFile;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the bundle
	 */
	public ResourceBundle getBundle() {
		return bundle;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			applicationPreferences = new ApplicationPreferences(this);
			locale = new Locale(applicationPreferences.getLastLocaleLanguage());
			
			String docPath = applicationPreferences.getLastOpenedFilePath();
			if (!StringUtilities.isNullOrEmpty(docPath)) {
				File file = new File(docPath);
				if (file.exists() && !file.isDirectory()) {
					content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
				} else {
					content = "";
				}

			} else {
				content = "";
			}
			
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle(kApplicationTitle);
			this.primaryStage.getIcons().add(getNewMainIconImage());
			restoreWindowSettings();

			initRootLayout();

		} catch(Exception e) {
			e.printStackTrace();
			MainApp.reportException(e, null);
		}
	}
	
	@Override
	public void stop() throws IOException {
		applicationPreferences.setLastWindowParameters(ApplicationPreferences.LAST_WINDOW,
				primaryStage);
		applicationPreferences.setLastLocaleLanguage(locale.getLanguage());
		controller.handleExit();
	}

	public static void main(String[] args) {
		userArgs = args;
		launch(args);
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/fxml/RootLayout.fxml"));
			bundle = ResourceBundle.getBundle(Constants.RESOURCE_LOCATION, locale);
			loader.setResources(bundle);
			rootLayout = (BorderPane) loader.load();
			ControllerUtilities.adjustMenusIfNeeded(sOperatingSystem, rootLayout);

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			scene.getStylesheets().add(getClass().getResource("view/fxml/PcPatrEditor.css").toExternalForm());

			primaryStage.setScene(scene);
			controller = loader.getController();
			controller.setMainApp(this);
			controller.setLocale(locale);

			File file;
			if (userArgs != null && userArgs.length > 0) {
				// User double-clicked on file name
				// userArgs[0] is the file path
				file = new File(userArgs[0]);
			} else {
				// Try to load last opened file.
				file = applicationPreferences.getLastOpenedFile();
			}
			if (file != null && file.exists()) {
				loadDocument(file);
				controller.setGrammarContents(content);
				controller.initGrammar();
			} else {
				boolean fSucceeded = askUserForNewOrToOpenExistingFile(bundle, controller);
				if (!fSucceeded) {
					System.exit(0);
				}
			}

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			MainApp.reportException(e, null);
		} catch (Exception e) {
			e.printStackTrace();
			MainApp.reportException(e, null);
		}
	}

	protected boolean askUserForNewOrToOpenExistingFile(ResourceBundle bundle,
			RootLayoutController controller) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(bundle.getString("program.name"));
		alert.setHeaderText(bundle.getString("file.initiallynotfound"));
		alert.setContentText(bundle.getString("file.chooseanoption"));
		alert.setResizable(true);
		// Following comes from
		// https://stackoverflow.com/questions/28937392/javafx-alerts-and-their-size
		// It's an attempt to get the buttons' text to show completely
		alert.getDialogPane().getChildren().stream().filter(node -> node instanceof Label)
				.forEach(node -> ((Label) node).setMinHeight(Region.USE_PREF_SIZE));
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(getNewMainIconImage());

		ButtonType buttonCreateNewDoc = new ButtonType(bundle.getString("label.createnewdocument"),
				ButtonData.OK_DONE);
		ButtonType buttonOpenExistingDoc = new ButtonType(
				bundle.getString("label.openexistingdocument"));
		ButtonType buttonCancel = new ButtonType(bundle.getString("label.cancel"),
				ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonCreateNewDoc, buttonOpenExistingDoc, buttonCancel);
		((Button) alert.getDialogPane().lookupButton(buttonCreateNewDoc)).setPrefWidth(250);
		((Button) alert.getDialogPane().lookupButton(buttonOpenExistingDoc)).setPrefWidth(250);
		((Button) alert.getDialogPane().lookupButton(buttonCancel))
				.setPrefWidth(Region.USE_PREF_SIZE);

		boolean fSucceeded = true;
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == buttonCreateNewDoc) {
			controller.handleNewDocument();
			if (controller.getGrammar() == null) {
				// The user canceled creating a new project
				fSucceeded = false;
			}
		} else if (result.get() == buttonOpenExistingDoc) {
			File file = controller.doFileOpen(true);
			try {
				loadDocument(file);
			} catch (IOException e) {
				e.printStackTrace();
				reportException(e, null);
			}

		} else {
			// ... user chose CANCEL or closed the dialog
			System.exit(0);
		}
		return fSucceeded;
	}

	public void loadDocument(File file) throws IOException {
		documentFile = file;
		applicationPreferences.setLastOpenedFilePath(file);
		applicationPreferences.setLastOpenedDirectoryPath(file.getParent());
		updateStageTitle(file);

		String content = new String(Files.readAllBytes(file.toPath()),
				StandardCharsets.UTF_8);
        setContent(content);
        controller.setGrammarContents(content);
	}

	private void restoreWindowSettings() {
		primaryStage = applicationPreferences.getLastWindowParameters(
				ApplicationPreferences.LAST_WINDOW, primaryStage, 660.0, 1000.);
	}

	@Override
	public ApplicationPreferences getApplicationPreferences() {
		return applicationPreferences;
	}

	@Override
	public Image getNewMainIconImage() {
		Image img = ControllerUtilities.getIconImageFromURL(kApplicationIconResource,
				Constants.RESOURCE_SOURCE_LOCATION);
		return img;
	}

	@Override
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	@Override
	public void saveFile(File file) {
		saveDocument(file);
	}

	public void saveDocument(File file) {
//		xmlBackEndProvider.saveDocumentToFile(file);
		documentFile = file;
		applicationPreferences.setLastOpenedFilePath(file);
		applicationPreferences.setLastOpenedDirectoryPath(file.getParent());
	}
	
	@Override
	public void updateStageTitle(File file) {
		if (file != null) {
			String sFileNameToUse = file.getAbsolutePath();
			if (controller.isDirty()) {
				sFileNameToUse += "*";
			}
			primaryStage.setTitle(kApplicationTitle + " - " + sFileNameToUse);
		} else {
			primaryStage.setTitle(kApplicationTitle);
		}
	}

	public static void reportException(Exception ex, ResourceBundle bundle) {
		String sTitle = "Error Found!";
		String sHeader = "A serious error happened.";
		String sContent = "Please copy the exception information below, email it to blackhandrew@gmail.com along with a description of what you were doing.";
		String sLabel = "The exception stacktrace was:";
		if (bundle != null) {
			sTitle = bundle.getString("exception.title");
			sHeader = bundle.getString("exception.header");
			sContent = bundle.getString("exception.content");
			sLabel = bundle.getString("exception.label");
		}
		ControllerUtilities.showExceptionInErrorDialog(ex, sTitle, sHeader, sContent, sLabel);
		System.exit(1);
	}

	public static void playBeep() {
		Toolkit.getDefaultToolkit().beep();
	}
}
