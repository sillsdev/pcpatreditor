/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.model.RuleExtractorRule;
import org.sil.pcpatreditor.service.RuleLocationInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class RuleExtractorChooserController extends TableViewWithCheckBoxColumnController {

	protected final class WrappingTableCell extends TableCell<RuleExtractorRule, String> {
		private Text text;

		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			processTableCell(this, text, item, empty);
		}
	}

	@FXML
	private TableView<RuleExtractorRule> ruleExtractorTable;
	@FXML
	private TableColumn<RuleExtractorRule, Boolean> checkBoxColumn;
	@FXML
	private TableColumn<RuleExtractorRule, String> rulePSRColumn;
	@FXML
	private TableColumn<RuleExtractorRule, String> ruleIdColumn;
	Stage dialogStage;
	private boolean okClicked = false;
	private MainApp mainApp;
	private ApplicationPreferences preferences;

	private ObservableList<RuleExtractorRule> rules = FXCollections.observableArrayList();
//	List<RuleLocationInfo> rulesToExtract = new ArrayList<>();
	List<Integer> rulesToExtract = new ArrayList<>();

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {
		super.setChoser(ApplicationPreferences.RULE_EXTRACTOR_CHOOSER);
		super.setTableView(ruleExtractorTable);
		super.initialize(location, resources);

		// Initialize the table with the columns.
		checkBoxColumn.setCellValueFactory(cellData -> cellData.getValue().checkedProperty());
		checkBoxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkBoxColumn));
		checkBoxColumn.setEditable(true);
		checkBoxColumnHead.setOnAction((event) -> {
			handleCheckBoxColumnHead();
		});
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

		initializeCheckBoxContextMenu(resources);

		ruleExtractorTable.setEditable(false);
		ruleExtractorTable.setOnMouseClicked(mouseEvent -> {
			RuleExtractorRule rule = ruleExtractorTable.getSelectionModel().getSelectedItem();
			if (rule != null) {
				rule.setChecked(!rule.isChecked());
			}
		});
		ruleExtractorTable.setOnKeyPressed(keyEvent -> {
			switch (keyEvent.getCode()) {
			case SPACE: {
				keyEvent.consume();
				RuleExtractorRule rule = ruleExtractorTable.getSelectionModel().getSelectedItem();
				if (rule != null) {
					rule.setChecked(!rule.isChecked());
				}
				break;
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
			handleCancel();
		});
	}

	public void setData(List<RuleLocationInfo> ruleLocations) {
		generateSegments(ruleLocations);
		// Add observable list data to the table
		ruleExtractorTable.setItems(rules);
		if (ruleExtractorTable.getItems().size() > 0) {
			// select one
			ruleExtractorTable.requestFocus();
			ruleExtractorTable.getSelectionModel().select(0);
			ruleExtractorTable.getFocusModel().focus(0);
		}
	}

	public void generateSegments(List<RuleLocationInfo> ruleLocations) {
		rules.clear();
		for (RuleLocationInfo ruleInfo : ruleLocations) {
//			if (segment.isActive()) {
			RuleExtractorRule ruleInfoWithCheckBox = new RuleExtractorRule(ruleInfo);
			// TODO: should we remember which rules have been selected previously?
			// Yes - how do we do it?
			ruleInfoWithCheckBox.setChecked(false);
//			ruleInfoWithCheckBox.setRuleDescription(ruleInfo.psrRepresentation());
			rules.add(ruleInfoWithCheckBox);
//			}
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
		rulesToExtract.clear();
		int i = 0;
		for (RuleExtractorRule ruleLocation : rules) {
			if (ruleLocation.isChecked()) {
//				rulesToExtract.add(ruleLocation.getRuleLocationInfo());
				rulesToExtract.add(i);
			}
			i++;
		}

		okClicked = true;
		handleCancel();
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		preferences.setLastWindowParameters(ApplicationPreferences.LAST_RULE_EXTRACTOR_DIALOG, dialogStage);
		dialogStage.close();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(ApplicationPreferences.LAST_RULE_EXTRACTOR_DIALOG, dialogStage, 400.,
				400.);
	}

	/**
	 * @return the rulesToExtract
	 */
	public List<Integer> getRulesToExtract() {
		return rulesToExtract;
	}

	/**
	 * @param rulesToExtract the rulesToExtract to set
	 */
	public void setRulesToExtract(List<Integer> rulesToExtract) {
		this.rulesToExtract = rulesToExtract;
	}

	protected void handleCheckBoxSelectAll() {
		for (RuleExtractorRule rule : rules) {
			rule.setChecked(true);
		}
	}

	protected void handleCheckBoxClearAll() {
		for (RuleExtractorRule rule : rules) {
			rule.setChecked(false);
		}
	}

	protected void handleCheckBoxToggle() {
		for (RuleExtractorRule rule : rules) {
			if (rule.isChecked()) {
				rule.setChecked(false);
			} else {
				rule.setChecked(true);
			}
		}
	}

}
