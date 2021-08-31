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
	 * @param iRightItem
	 *            = position of right item to use when searching for
	 *            matching left item
	 * @param fCaretAfterItem
	 *            = whether the current caret is before the item (left-arrow was
	 *            keyed) or after the item (a closing item was keyed)
	 * @param pause
	 *            = number of milliseconds to sleep while showing matching item
	 * @param leftItem TODO
	 * @param rightItem TODO
	 * @param resource
	 *            = resources used in message
	 * @param image
	 *            = image used in message
	 */
	public static void processRightItem(CodeArea grammar,
			int iRightItem, boolean fCaretAfterItem, double pause, char leftItem,
			char rightItem, ResourceBundle resource, Image image) {
		grammarArea = grammar;
		bundle = resource;
		mainIcon = image;
		grammarArea.setEditable(false);
		int iLeftItem = findMatchingLeftItemAndHighlightIt(iRightItem, leftItem, rightItem);
		if (iLeftItem > -1) {
			// sleep and then reset the caret
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(pause), event -> {
				removeMatchingLeftItemHighlightAndRestoreCaret(iLeftItem,
						iRightItem + (fCaretAfterItem ? 1 : 0));
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
			int iLeftItem, int iRightItem) {
		grammarArea.requestFollowCaret();
		grammarArea.moveTo(iRightItem);
		return null;
	}

	// TODO: when we get rtf working, highlight some other way and we may not
	// need to return an integer here...
	// is public for unit testing
	public static int findMatchingLeftItemAndHighlightIt(int iRightItem, char leftItem, char rightItem) {
		String sDescription = grammarArea.getText();
		int iMax = sDescription.length() - 1;
		int iIndex = iRightItem - 1;
		if (iIndex > iMax) {
			return -1;
		}
		int iClosingItem = 0;
		while (iIndex >= 0) {
			if (sDescription.charAt(iIndex) == rightItem) {
				iClosingItem++;
			} else if (sDescription.charAt(iIndex) == leftItem) {
				if (iClosingItem == 0) {
					break;
				} else {
					iClosingItem--;
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
				String noMatching = "";
				String missing = "";
				switch (leftItem) {
				case '{':
					noMatching = bundle.getString("error.nomatchingopeningbrace");
					missing = bundle.getString("error.missingopeningbrace");
					break;
				case '[':
					noMatching = bundle.getString("error.nomatchingopeningbracket");
					missing = bundle.getString("error.missingopeningbracket");
					break;
				case '(':
					noMatching = bundle.getString("error.nomatchingopeningparenthesis");
					missing = bundle.getString("error.missingopeningparenthesis");
					break;
				case '<':
					noMatching = bundle.getString("error.nomatchingopeningwedge");
					missing = bundle.getString("error.missingopeningwedge");
					break;
				default:
					System.out.println("default:" + leftItem);
					break;
				}
				alert.setHeaderText(noMatching);
				alert.setContentText(missing);
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
	 * @param fCaretAfterItem TODO
	 * @param leftItem TODO
	 * @param rightItem TODO
	 * @param pause
	 *            = number of milliseconds to sleep while showing matching item
	 * @param fShowMsg
	 *            = whether to show message about missing matching right
	 *            item or not
	 * @param resource
	 *            = resources used in message
	 * @param image
	 *            = image used in message
	 */
	public static void processLeftItem(CodeArea grammar, boolean fCaretAfterItem,
			char leftItem, char rightItem, double pause, boolean fShowMsg, ResourceBundle resource, Image image) {
		grammarArea = grammar;
		bundle = resource;
		mainIcon = image;
		int iLeftItem = grammarArea.getCaretPosition();
		grammarArea.setEditable(false);
		int iRightItem = findMatchingRightItemAndHighlightIt(iLeftItem + (fCaretAfterItem? 0 : 1),
				fShowMsg, leftItem, rightItem);
		if (iRightItem > -1) {
			// sleep and then reset the caret
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(pause), event -> {
				removeMatchingRightItemHighlightAndRestoreCaret(iLeftItem,
						iRightItem);
				grammarArea.setEditable(true);
				processAnyItemsKeyedDuringPause();
			}));
			timeline.play();
		} else {
			grammarArea.setEditable(true);
		}
	}

	private static Object removeMatchingRightItemHighlightAndRestoreCaret(
			int iLeftItem, int iRightItem) {
		grammarArea.requestFollowCaret();
		grammarArea.moveTo(iLeftItem);
		return null;
	}

	// TODO: when we get rtf working, highlight some other way and we may not
	// need to return an integer here...
	// is public for unit testing
	/**
	 * @param iLeftItem
	 *            = position of left item to match
	 * @param fShowMsg
	 *            = whether to show message about missing matching right
	 *            item
	 * @param leftItem TODO
	 * @param rightItem TODO
	 * @return
	 */
	public static int findMatchingRightItemAndHighlightIt(int iLeftItem,
			boolean fShowMsg, char leftItem, char rightItem) {
		int iIndex;
		String sDescription = grammarArea.getText();
		int iEnd = sDescription.length();
		int iOpeningItem = 0;
		iIndex = iLeftItem;
		while (iIndex < iEnd) {
			if (sDescription.charAt(iIndex) == leftItem) {
				iOpeningItem++;
			} else if (sDescription.charAt(iIndex) == rightItem) {
				if (iOpeningItem == 0) {
					break;
				} else {
					iOpeningItem--;
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
				String noMatching = "";
				String missing = "";
				switch (leftItem) {
				case '{':
					noMatching = bundle.getString("error.nomatchingclosingbrace");
					missing = bundle.getString("error.missingclosingbrace");
					break;
				case '[':
					noMatching = bundle.getString("error.nomatchingclosingbracket");
					missing = bundle.getString("error.missingclosingbracket");
					break;
				case '(':
					noMatching = bundle.getString("error.nomatchingclosingparenthesis");
					missing = bundle.getString("error.missingclosingparenthesis");
					break;
				case '<':
					noMatching = bundle.getString("error.nomatchingclosingwedge");
					missing = bundle.getString("error.missingclosingwedge");
					break;
				default:
					System.out.println("default:" + leftItem);
					break;
				}
				alert.setHeaderText(noMatching);
				alert.setContentText(missing);
				Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
				stage.getIcons().add(mainIcon);
				alert.showAndWait();
			}
		}
		return -1;
	}

}
