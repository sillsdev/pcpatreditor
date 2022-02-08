// Copyright (c) 2021-2022 SIL International
// This software is licensed under the LGPL, version 2.1 or later
// (http://www.gnu.org/licenses/lgpl-2.1.html)
package org.sil.pcpatreditor;

import java.io.File;
import java.util.prefs.Preferences;

import org.sil.pcpatreditor.service.ExtractorAction;
import org.sil.utility.*;

import javafx.stage.Stage;

public class ApplicationPreferences extends ApplicationPreferencesUtilities {

	static final String LAST_OPENED_FILE_PATH = "lastOpenedFilePath";
	static final String LAST_OPENED_DIRECTORY_PATH = "lastOpenedDirectoryPath";
	static final String LAST_LOCALE_LANGUAGE = "lastLocaleLanguage";
	static final String DRAW_AS_TYPE = "drawastype";
	static final String SHOW_MATCHING_ITEM_DELAY = "showmatchingitemdelay";
	static final String SHOW_MATCHING_ITEM_WITH_ARROW_KEYS = "showmatchingitemwitharrowkeys";
	static final String GRAMMAR_FONT_SIZE = "grammarfontsize";
	static final String LAST_CARET_POSITION = "lastCaretPosition";
	static final String LAST_EXTRACTOR_ACTION = "lastExtractorAction";
	// Not trying to be anglo-centric, but we have to start with something...
	static final String DEFAULT_LOCALE_LANGUAGE = "en";

	public static final String FIND_REPLACE_LAST_FORWARD = "lastFindReplaceForward";
	public static final String FIND_REPLACE_LAST_ALL = "lastFindReplaceAll";
	public static final String FIND_REPLACE_LAST_CASE_SENSITIVE = "lastFindReplaceCaseSensitive";
	public static final String FIND_REPLACE_LAST_WHOLE_WORD = "lastFindReplaceWholeWord";
	public static final String FIND_REPLACE_LAST_REGULAR_EXPRESSION = "lastFindReplaceRegularExpression";
	public static final String FIND_REPLACE_LAST_WRAP_SEARCH = "lastFindReplaceWrapSearch";
	public static final String FIND_REPLACE_LAST_INCREMENTAL = "lastFindReplaceIncremental";
	public static final String FIND_REPLACE_LAST_FIND = "lastFindReplaceFind";
	public static final String FIND_REPLACE_LAST_REPLACE = "lastFindReplaceReplace";

	// Controller table column widths and splitter position
	public static final String RULE_EXTRACTOR_CHOOSER = "RULE_EXTRACTOR_CHOOSER_";

	// Window parameters to remember
	static final String POSITION_X = "PositionX";
	static final String POSITION_Y = "PositionY";
	static final String WIDTH = "Width";
	static final String HEIGHT = "Height";
	static final String MAXIMIZED = "Maximized";
	// Window parameters for main window and various dialogs
	public static final String LAST_WINDOW = "lastWindow";
	public static final String LAST_SPLIT_PANE_POSITION = "lastSplitPanePosition";
	public static final String LAST_FIND_REPLACE_DIALOG = "lastFindReplaceDialog";
	public static final String LAST_RULE_EXTRACTOR_DIALOG = "lastRuleExtractorDialog";
	public static final String LAST_CONSTITUENTS_DIALOG = "lastConstituentsDialog";
	public static final String LAST_CONSTITUENTS_DIALOG_SPLITTER_POSITION = "lastConstituentsDialogSplitterPosition";
	public static final String LAST_FEATURE_SYSTEM_DIALOG="lastFeatureSystemDialog";

	Preferences prefs;

	public ApplicationPreferences(Object app) {
		prefs = Preferences.userNodeForPackage(app.getClass());
	}

	public String getLastOpenedFilePath() {
		return prefs.get(LAST_OPENED_FILE_PATH, null);
	}

	public void setLastOpenedFilePath(String lastOpenedFile) {
		setPreferencesKey(LAST_OPENED_FILE_PATH, lastOpenedFile);
	}

	public String getLastLocaleLanguage() {
		return prefs.get(LAST_LOCALE_LANGUAGE, DEFAULT_LOCALE_LANGUAGE);
	}

	public void setLastLocaleLanguage(String lastLocaleLanguage) {
		setPreferencesKey(LAST_LOCALE_LANGUAGE, lastLocaleLanguage);
	}

	public String getLastExtractorAction() {
		return prefs.get(LAST_EXTRACTOR_ACTION, ExtractorAction.NO_ACTION.name());
	}

	public void setLastExtractorAction(String lastExtractorAction) {
		prefs.put(LAST_EXTRACTOR_ACTION, lastExtractorAction);
	}

	public int getLastCaretPosition() {
		return prefs.getInt(LAST_CARET_POSITION, 0);
	}

	public void setLastCaretPosition(int lastCaretPosition) {
		prefs.putInt(LAST_CARET_POSITION, lastCaretPosition);
	}

	public File getLastOpenedFile() {
		String filePath = prefs.get(LAST_OPENED_FILE_PATH, null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	public void setLastOpenedFilePath(File file) {
		if (file != null) {
			setPreferencesKey(LAST_OPENED_FILE_PATH, file.getPath());
		} else {
			prefs.remove(LAST_OPENED_FILE_PATH);
		}
	}

	@Override
	public String getLastOpenedDirectoryPath() {
		return prefs.get(LAST_OPENED_DIRECTORY_PATH, "");
	}

	@Override
	public void setLastOpenedDirectoryPath(String directoryPath) {
		setPreferencesKey(LAST_OPENED_DIRECTORY_PATH, directoryPath);
	}

	public double getShowMatchingItemDelay() {
		return prefs.getDouble(SHOW_MATCHING_ITEM_DELAY, 750.0);
	}

	public void setShowMatchingItemDelay(double dSize) {
		setPreferencesKey(SHOW_MATCHING_ITEM_DELAY, dSize);
	}

	public boolean getShowMatchingItemWithArrowKeys() {
		return prefs.getBoolean(SHOW_MATCHING_ITEM_WITH_ARROW_KEYS, false);
	}

	public void setShowMatchingItemWithArrowKeys(boolean fShowMatchingItemWithArrowKeys) {
		setPreferencesKey(SHOW_MATCHING_ITEM_WITH_ARROW_KEYS, fShowMatchingItemWithArrowKeys);
	}

	public double getGrammarFontSize() {
		return prefs.getDouble(GRAMMAR_FONT_SIZE, 12.0);
	}

	public void setGrammarFontSize(double dSize) {
		setPreferencesKey(GRAMMAR_FONT_SIZE, dSize);
	}

	public Stage getLastWindowParameters(String sWindow, Stage stage, Double defaultHeight,
			Double defaultWidth) {
		Double value = prefs.getDouble(sWindow + HEIGHT, defaultHeight);
		stage.setHeight(value);
		value = prefs.getDouble(sWindow + WIDTH, defaultWidth);
		stage.setWidth(value);
		value = prefs.getDouble(sWindow + POSITION_X, 10);
		stage.setX(value);
		value = prefs.getDouble(sWindow + POSITION_Y, 10);
		stage.setY(value);
		boolean fValue = prefs.getBoolean(sWindow + MAXIMIZED, false);
		stage.setMaximized(fValue);
		return stage;
	}

	public void setLastWindowParameters(String sWindow, Stage stage) {
		boolean isMaximized = stage.isMaximized();
		if (!isMaximized) {
			setPreferencesKey(sWindow + HEIGHT, stage.getHeight());
			setPreferencesKey(sWindow + WIDTH, stage.getWidth());
			setPreferencesKey(sWindow + POSITION_X, stage.getX());
			setPreferencesKey(sWindow + POSITION_Y, stage.getY());
		}
		setPreferencesKey(sWindow + MAXIMIZED, stage.isMaximized());
	}

	public boolean getBooleanValue(String sKey, boolean defaultValue) {
		return prefs.getBoolean(sKey, defaultValue);
	}

	public String getStringValue(String sKey, String defaultValue) {
		return prefs.get(sKey, defaultValue);
	}

	public Double getDoubleValue(String sKey, Double defaultValue) {
		return prefs.getDouble(sKey, defaultValue);
	}

	public void setPreferencesKey(String key, boolean value) {
		if (!StringUtilities.isNullOrEmpty(key)) {
			if (key != null) {
				prefs.putBoolean(key, value);
			} else {
				prefs.remove(key);
			}
		}
	}

//	private void setPreferencesKey(String key, Color color) throws Exception {
//		if (!StringUtilities.isNullOrEmpty(key)) {
//			if (key != null) {
//				String value = adaptor.marshal(color);
//				prefs.put(key, value);
//
//			} else {
//				prefs.remove(key);
//			}
//		}
//	}
//
	public void setPreferencesKey(String key, Double value) {
		if (!StringUtilities.isNullOrEmpty(key)) {
			if (key != null && value != null) {
				prefs.putDouble(key, value);
			} else {
				prefs.remove(key);
			}
		}
	}

	public void setPreferencesKey(String key, String value) {
		if (!StringUtilities.isNullOrEmpty(key) && !StringUtilities.isNullOrEmpty(value)) {
			prefs.put(key, value);
		} else {
			prefs.remove(key);
		}
	}
}
