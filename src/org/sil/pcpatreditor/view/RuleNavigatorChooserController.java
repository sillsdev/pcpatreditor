/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.model.RuleChooserRule;
import org.sil.pcpatreditor.service.RuleLocationInfo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class RuleNavigatorChooserController extends TableViewController {

	protected final class WrappingTableCell extends TableCell<RuleChooserRule, String> {
		private Text text;

		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			processTableCell(this, text, item, empty);
		}
	}

	@FXML
	private TableView<RuleChooserRule> ruleNavigatorTable;
	@FXML
	private TableColumn<RuleChooserRule, String> rulePSRColumn;
	@FXML
	private TableColumn<RuleChooserRule, String> ruleIdColumn;
	Stage dialogStage;
	private boolean okClicked = false;
	private ApplicationPreferences preferences;
	private MainApp mainApp;
	private RootLayoutController rootLayoutController;

	private ObservableList<RuleChooserRule> rules = FXCollections.observableArrayList();
	RuleChooserRule ruleChosen;
	int currentSelectedIndex = 0;

	/**
	 * @return the ruleChosen
	 */
	public RuleChooserRule getRuleChosen() {
		return ruleChosen;
	}

	/**
	 * @param ruleChosen the ruleChosen to set
	 */
	public void setRuleChosen(RuleChooserRule ruleChosen) {
		this.ruleChosen = ruleChosen;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		super.setChoser(ApplicationPreferences.RULE_NAVIGATOR_CHOOSER);
		super.setTableView(ruleNavigatorTable);
		super.initialize(location, resources);

		// Initialize the table with the columns.
		rulePSRColumn.setCellValueFactory(cellData -> {
			return cellData.getValue().rulePhraseStructureRuleProperty();
		});
		// Custom rendering of the table cell.
		rulePSRColumn.setCellFactory(column -> {
			return new WrappingTableCell();
		});
		ruleIdColumn.setCellValueFactory(cellData -> {
			return cellData.getValue().ruleIDProperty();
		});
		// Custom rendering of the table cell.
		ruleIdColumn.setCellFactory(column -> {
			return new WrappingTableCell();
		});

		ruleNavigatorTable.setEditable(false);
		ruleNavigatorTable.setOnMouseClicked(mouseEvent -> {
			rememberSelection();
		});
		ruleNavigatorTable.setOnKeyPressed(keyEvent -> {
			switch (keyEvent.getCode()) {
			case SPACE: {
				keyEvent.consume();
				rememberSelection();
				break;
			}
			default:
				break;
			}
		});

		ruleNavigatorTable.focusedProperty().addListener((observable, oldValue, newValue) -> {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					if (newValue) {
						setData(rootLayoutController.calculateCurrentRuleLocationInfo());
						int max = ruleNavigatorTable.getItems().size();
						currentSelectedIndex = adjustIndexValue(currentSelectedIndex, max);
						ruleNavigatorTable.requestFocus();
						ruleNavigatorTable.getSelectionModel().select(currentSelectedIndex);
						ruleNavigatorTable.getFocusModel().focus(currentSelectedIndex);
						ruleNavigatorTable.scrollTo(currentSelectedIndex);
					}
				}
			});
		});

	}

	protected int adjustIndexValue(int value, int max) {
		if (value >= max) {
			value = max-1;
		} else if (value < 0) {
			value = 0;
		}
		return value;
	}

	public void rememberSelection() {
		ruleChosen = ruleNavigatorTable.getSelectionModel().getSelectedItem();
		currentSelectedIndex = ruleNavigatorTable.getSelectionModel().getSelectedIndex();
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
		this.dialogStage.setOnCloseRequest(event -> {
			handleCancel();
		});
	}

	public void setData(List<RuleLocationInfo> ruleLocations) {
		generateRulesToShow(ruleLocations);
		// Add observable list data to the table
		ruleNavigatorTable.setItems(rules);
		if (ruleNavigatorTable.getItems().size() > 0) {
			// select one
			ruleNavigatorTable.requestFocus();
			ruleNavigatorTable.getSelectionModel().select(0);
			ruleNavigatorTable.getFocusModel().focus(0);
		}
	}

	public void generateRulesToShow(List<RuleLocationInfo> ruleLocations) {
		rules.clear();
		for (RuleLocationInfo ruleInfo : ruleLocations) {
			RuleChooserRule ruleInfoWithCheckBox = new RuleChooserRule(ruleInfo);
			rules.add(ruleInfoWithCheckBox);
		}
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
		okClicked = true;
		mainApp.getPrimaryStage().requestFocus();
		CodeArea grammar = rootLayoutController.getGrammar();
		grammar.moveTo(ruleChosen.getRuleLocationInfo().lineNumber(), 0);
		grammar.requestFollowCaret();

	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		preferences.setLastWindowParameters(ApplicationPreferences.LAST_RULE_NAVIGATOR_DIALOG, dialogStage);
		dialogStage.close();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(ApplicationPreferences.LAST_RULE_NAVIGATOR_DIALOG, dialogStage, 400.,
				400.);
	}

	/**
	 * @param rootLayoutController the rootLayoutController to set
	 */
	public void setRootLayoutController(RootLayoutController rootLayoutController) {
		this.rootLayoutController = rootLayoutController;
	}

}
