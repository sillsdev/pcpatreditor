/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */
package org.sil.pcpatreditor;
	
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.ResourceBundle;

import org.sil.utility.ApplicationPreferencesUtilities;
import org.sil.utility.MainAppUtilities;
import org.sil.utility.view.ControllerUtilities;
import org.sil.pcpatreditor.view.RootLayoutController;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
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
			File file = new File(docPath);
			if (file.exists() && !file.isDirectory()) {
				content = new String(Files.readAllBytes(file.toPath()),
						StandardCharsets.UTF_8);
			}
//			doc = new Document();
//			xmlBackEndProvider = new XMLBackEndProvider(doc, locale);
			
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle(kApplicationTitle);
			this.primaryStage.getIcons().add(getNewMainIconImage());
			restoreWindowSettings();

			initRootLayout();

//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("view/fxml/RootLayout.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("view/fxml/PcPatrEditor.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws IOException {
		System.out.println("stop in MainApp");
		applicationPreferences.setLastWindowParameters(ApplicationPreferences.LAST_WINDOW,
				primaryStage);
		applicationPreferences.setLastLocaleLanguage(locale.getLanguage());
//		if (controller.isDirty()) {
//			controller.askAboutSaving();
//		}
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

			// Because we see the ALT character in the tree description when the
			// tree description node has focus (which it normally does), we need
			// to catch the ALT and put focus on the menu bar. Otherwise, the
			// menu accelerator keys are ignored.
			scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
				public void handle(KeyEvent ke) {
					if (ke.getCode() == KeyCode.ALT) {
						controller.getMenuBar().requestFocus();
						ke.consume();
					}
				}
			});

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
				controller.initGrammar();
//				controller.setDocument(doc);
			} else {
//				boolean fSucceeded = askUserForNewOrToOpenExistingFile(bundle, controller);
//				if (!fSucceeded) {
//					System.exit(0);
//				}
			}

			// updateStatusBarNumberOfItems("");

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("non-IO Exception caught!");
			e.printStackTrace();
		}
	}

	public void loadDocument(File file) {
//		xmlBackEndProvider.loadDocumentFromFile(file);
//		doc = xmlBackEndProvider.getDocument();
		documentFile = file;
//		ltTree.setFontsAndColors();
		applicationPreferences.setLastOpenedFilePath(file);
		applicationPreferences.setLastOpenedDirectoryPath(file.getParent());
		updateStageTitle(file);
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
			String sFileNameToUse = file.getName();
			if (controller.isDirty()) {
				sFileNameToUse += "*";
			}
			primaryStage.setTitle(kApplicationTitle + " - " + sFileNameToUse);
		} else {
			primaryStage.setTitle(kApplicationTitle);
		}
	}
}
