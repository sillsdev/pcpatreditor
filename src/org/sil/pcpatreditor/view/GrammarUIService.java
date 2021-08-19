/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ResourceBundle;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.MainApp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Andy Black
 *
 */
public class GrammarUIService {

	private static CodeArea grammarArea;
	private static ResourceBundle bundle;
	private static Image mainIcon;
	private static List<KeyEvent> itemsKeyedDuringPause;

	public static void setItemsKeyedDuringPause(List<KeyEvent> itemsKeyedDuringPause) {
		GrammarUIService.itemsKeyedDuringPause = itemsKeyedDuringPause;
	}

	// TODO: is treating these as static the best way to go?
	// should we use a singleton pattern instead?
	/**
	 * @param grammar
	 *            = tree description text area
	 * @param iRightParenthesis
	 *            = position of right parenthesis to use when searching for
	 *            matching left parenthesis
	 * @param fCaretAfterParen
	 *            = whether the current cart is before the paren (left-arrow was
	 *            keyed) or after the paren (a ')' was keyed)
	 * @param pause
	 *            = number of milliseconds to sleep while showing matching paren
	 * @param resource
	 *            = resources used in message
	 * @param image
	 *            = image used in message
	 */
	public static void processRightParenthesis(CodeArea grammar,
			int iRightParenthesis, boolean fCaretAfterParen, double pause, ResourceBundle resource,
			Image image) {
		grammarArea = grammar;
		bundle = resource;
		mainIcon = image;
		grammarArea.setEditable(false);
		int iLeftParenthesis = findMatchingLeftItemAndHighlightIt(iRightParenthesis, ')', '(');
		if (iLeftParenthesis > -1) {
			// sleep and then reset the caret
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(pause), event -> {
				removeMatchingLeftItemHighlightAndRestoreCaret(iLeftParenthesis,
						iRightParenthesis + (fCaretAfterParen ? 1 : 0));
				grammarArea.setEditable(true);
				processAnyItemsKeyedDuringPause();
			}));
			timeline.play();
		} else {
			grammarArea.setEditable(true);
		}
	}

	private static void processAnyItemsKeyedDuringPause() {
		if (itemsKeyedDuringPause != null && itemsKeyedDuringPause.size() > 0) {
			try {
				for (KeyEvent keyEvent : itemsKeyedDuringPause) {
					if (keyEvent.getCharacter().equals("(")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, "(");
					} else if (keyEvent.getCharacter().equals(")")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, ")");
					} else if (keyEvent.getCharacter().equals("[")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, "[");
					} else if (keyEvent.getCharacter().equals("]")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, "]");
					} else if (keyEvent.getCharacter().equals("{")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, "[");
					} else if (keyEvent.getCharacter().equals("}")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, "]");
					} else if (keyEvent.getCharacter().equals("<")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, "<");
					} else if (keyEvent.getCharacter().equals(">")) {
						int i = grammarArea.getCaretPosition();
						grammarArea.insertText(i, ">");
					} else {
						KeyEvent newEvent = new KeyEvent(keyEvent.getSource(),
								keyEvent.getTarget(), keyEvent.getEventType(),
								keyEvent.getCharacter(), keyEvent.getText(), keyEvent.getCode(),
								keyEvent.isShiftDown(), keyEvent.isControlDown(),
								keyEvent.isAltDown(), keyEvent.isMetaDown());
						grammarArea.fireEvent(newEvent);
					}
				}
			} catch (ConcurrentModificationException e) {
				// This can happen if a user types several arrow keys
				// very quickly and does not wait for the matching to occur.
				// Currently, we do nothing but warn the user in the
				// documentation.
			}
			itemsKeyedDuringPause.clear();
		}
	}

	private static Object removeMatchingLeftItemHighlightAndRestoreCaret(
			int iLeftParenthesis, int iRightParenthesis) {
		grammarArea.requestFollowCaret();
		grammarArea.moveTo(iRightParenthesis);
		return null;
	}

	// TODO: when we get rtf working, highlight some other way and we may not
	// need to return an integer here...
	// is public for unit testing
	public static int findMatchingLeftItemAndHighlightIt(int iRightParenthesis, char rightItem, char leftItem) {
		String sDescription = grammarArea.getText();
		int iMax = sDescription.length() - 1;
		int iIndex = iRightParenthesis - 1;
		if (iIndex > iMax) {
			return -1;
		}
		int iCloseParen = 0;
		while (iIndex >= 0) {
			if (sDescription.charAt(iIndex) == rightItem) {
				iCloseParen++;
			} else if (sDescription.charAt(iIndex) == leftItem) {
				if (iCloseParen == 0) {
					break;
				} else {
					iCloseParen--;
				}
			}
			iIndex--;
		}
		if (iIndex >= 0) {
			grammarArea.requestFollowCaret();
			grammarArea.moveTo(iIndex);
			grammarArea.selectRange(iIndex, iIndex + 1);
			return iIndex;
		} else {
			if (bundle != null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle(MainApp.kApplicationTitle);
				alert.setHeaderText(bundle.getString("error.nomatchingopeningparenthesis"));
				alert.setContentText(bundle.getString("error.missingopenparenthesis"));

				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
				stage.getIcons().add(mainIcon);

				alert.showAndWait();
			}
		}
		return -1;
	}

	/**
	 * @param grammar
	 *            = tree description text area
	 * @param fShowMsg
	 *            = whether to show message about missing matching right
	 *            parenthesis or not
	 * @param pause
	 *            = number of milliseconds to sleep while showing matching paren
	 * @param resource
	 *            = resources used in message
	 * @param image
	 *            = image used in message
	 */
	public static void processLeftItem(CodeArea grammar, boolean fShowMsg,
			double pause, ResourceBundle resource, Image image) {
		grammarArea = grammar;
		bundle = resource;
		mainIcon = image;
		int iLeftParenthesis = grammarArea.getCaretPosition();
		grammarArea.setEditable(false);
		int iRightParenthesis = findMatchingRightItemAndHighlightIt(iLeftParenthesis,
				fShowMsg, '(', ')');
		if (iRightParenthesis > -1) {
			// sleep and then reset the caret
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(pause), event -> {
				removeMatchingRightItemHighlightAndRestoreCaret(iLeftParenthesis,
						iRightParenthesis);
				grammarArea.setEditable(true);
				processAnyItemsKeyedDuringPause();
			}));
			timeline.play();
		} else {
			grammarArea.setEditable(true);
		}
	}

	private static Object removeMatchingRightItemHighlightAndRestoreCaret(
			int iLeftParenthesis, int iRightParenthesis) {
		grammarArea.requestFollowCaret();
		grammarArea.moveTo(iLeftParenthesis);
		return null;
	}

	// TODO: when we get rtf working, highlight some other way and we may not
	// need to return an integer here...
	// is public for unit testing
	/**
	 * @param iLeftParenthesis
	 *            = position of left parenthesis to match
	 * @param fShowMsg
	 *            = whether to show message about missing matching right
	 *            parenthesis
	 * @param leftItem TODO
	 * @param rightItem TODO
	 * @return
	 */
	public static int findMatchingRightItemAndHighlightIt(int iLeftParenthesis,
			boolean fShowMsg, char leftItem, char rightItem) {
		int iIndex;
		String sDescription = grammarArea.getText();
		int iEnd = sDescription.length();
		int iOpenParen = 0;
		iIndex = iLeftParenthesis;
		while (iIndex < iEnd) {
			if (sDescription.charAt(iIndex) == leftItem) {
				iOpenParen++;
			} else if (sDescription.charAt(iIndex) == rightItem) {
				if (iOpenParen == 0) {
					break;
				} else {
					iOpenParen--;
				}
			}
			iIndex++;
		}
		if (iIndex < iEnd) {
			grammarArea.requestFollowCaret();
			grammarArea.moveTo(iIndex);
			grammarArea.selectRange(iIndex, iIndex + 1);
			return iIndex;
		} else {
			if (fShowMsg && bundle != null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle(MainApp.kApplicationTitle);
				alert.setHeaderText(bundle.getString("error.nomatchingclosingparenthesis"));
				alert.setContentText(bundle.getString("error.missingcloseparenthesis"));

				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
				stage.getIcons().add(mainIcon);

				alert.showAndWait();
			}
		}
		return -1;
	}

}
