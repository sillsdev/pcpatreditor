/**
 * Copyright (c) 2026 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.fxmisc.richtext.CodeArea;
import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.model.TemplateChooserTemplate;
import org.sil.pcpatreditor.service.TemplateLocationInfo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Andy Black
 *
 */
public class TemplateNavigatorChooserController {

	protected final class WrappingTableCell extends TableCell<TemplateChooserTemplate, String> {
		private Text text;

		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			processTableCell(this, text, item, empty);
		}
	}
	
	protected void processTableCell(TableCell<TemplateChooserTemplate, String> cell, Text text, String item, boolean empty) {
		processCell(cell, item, empty, null, null);
	}

	protected void processCell(TableCell<? extends TemplateChooserTemplate, String> cell, String item, boolean empty, Color textColor, Font fontToUse) {
		Text text;
		if (item == null || empty) {
			cell.setText(null);
			cell.setStyle("");
		} else {
			cell.setStyle("");
			text = new Text(item.toString());
			// Get it to wrap.
			text.wrappingWidthProperty().bind(cell.getTableColumn().widthProperty());
			TemplateChooserTemplate obj = (TemplateChooserTemplate) cell.getTableRow().getItem();
			if (fontToUse != null) {
				text.setFont(fontToUse);
			}
			cell.setGraphic(text);
		}
	}

	@FXML
	private TableView<TemplateChooserTemplate> templateNavigatorTable;
	@FXML
	private TableColumn<TemplateChooserTemplate, String> templateColumn;
	@FXML
	private Label filterLabel;
	@FXML
	private TextField filterText;

	Stage dialogStage;
	private boolean okClicked = false;
	private ApplicationPreferences preferences;
	private MainApp mainApp;
	private RootLayoutController rootLayoutController;

	private List<TemplateLocationInfo> templateLocations = new ArrayList<TemplateLocationInfo>();
	private List<TemplateLocationInfo> filteredTemplateLocations = new ArrayList<TemplateLocationInfo>();
	private ObservableList<TemplateChooserTemplate> templates = FXCollections.observableArrayList();
	TemplateChooserTemplate templateChosen;
	int currentSelectedIndex = 0;

	public TemplateChooserTemplate getTemplateChosen() {
		return templateChosen;
	}

	public void setTemplateChosen(TemplateChooserTemplate templateChosen) {
		this.templateChosen = templateChosen;
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	public void initialize(URL location, ResourceBundle resources) {

		// Initialize the table with the column
		templateColumn.setCellValueFactory(cellData -> {
			return cellData.getValue().templateNameProperty();
		});
		// Custom rendering of the table cell.
		templateColumn.setCellFactory(column -> {
			return new WrappingTableCell();
		});

		templateNavigatorTable.setEditable(false);
		templateNavigatorTable.setOnMouseClicked(mouseEvent -> {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				rememberSelection();
				if (mouseEvent.getClickCount() == 2) {
					handleOk();
				}
			}
		});
		templateNavigatorTable.setOnKeyPressed(keyEvent -> {
			switch (keyEvent.getCode()) {
			case DOWN: {
				keyEvent.consume();
				rememberSelection();
				break;
			}
			case UP: {
				keyEvent.consume();
				rememberSelection();
				break;
			}
			default:
				break;
			}
		});

		templateNavigatorTable.focusedProperty().addListener((observable, oldValue, newValue) -> {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					if (newValue) {
						if (filteredTemplateLocations.size() == 0) {
							setData(rootLayoutController.calculateCurrentTemplateLocationInfo());
							int max = templateNavigatorTable.getItems().size();
							currentSelectedIndex = adjustIndexValue(currentSelectedIndex, max);
							templateNavigatorTable.requestFocus();
							templateNavigatorTable.getSelectionModel().select(currentSelectedIndex);
							templateNavigatorTable.getFocusModel().focus(currentSelectedIndex);
							templateNavigatorTable.scrollTo(currentSelectedIndex);
						}
					}
				}
			});
		});

		filterLabel.setText(resources.getString("label.filtertemplatesbyname"));
		filterText.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 0) {
				filteredTemplateLocations = templateLocations.stream()
						.filter(rl -> (rl.name().startsWith(newValue )))
						.toList();
				generateTemplatesToShow(filteredTemplateLocations);
				// Add observable list data to the table
				templateNavigatorTable.setItems(templates);
				templateNavigatorTable.refresh();
			} else {
				setData(templateLocations);
				filterText.requestFocus();
			}
		});
		Platform.runLater(filterText::requestFocus);
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
		templateChosen = templateNavigatorTable.getSelectionModel().getSelectedItem();
		currentSelectedIndex = templateNavigatorTable.getSelectionModel().getSelectedIndex();
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

	public void setData(List<TemplateLocationInfo> templateLocations) {
		this.templateLocations = templateLocations;
		generateTemplatesToShow(templateLocations);
		// Add observable list data to the table
		templateNavigatorTable.setItems(templates);
		if (templateNavigatorTable.getItems().size() > 0) {
			// select one
			templateNavigatorTable.requestFocus();
			templateNavigatorTable.getSelectionModel().select(0);
			templateNavigatorTable.getFocusModel().focus(0);
		}
	}

	public void generateTemplatesToShow(List<TemplateLocationInfo> templateLocations) {
		templates.clear();
		for (TemplateLocationInfo templateInfo : templateLocations) {
			TemplateChooserTemplate templateChooserTemplate = new TemplateChooserTemplate(templateInfo);
			templates.add(templateChooserTemplate);
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
		Platform.runLater(() -> {
			mainApp.getPrimaryStage().requestFocus();
			CodeArea grammar = rootLayoutController.getGrammar();
			if (templateChosen != null) {
				grammar.moveTo(templateChosen.getTemplateLocationInfo().lineNumber()-1, 0);
				grammar.requestFollowCaret();
				rootLayoutController.tryToShowLineInMiddleOfWindow();
			}
		});
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		preferences.setLastWindowParameters(ApplicationPreferences.LAST_TEMPLATE_NAVIGATOR_DIALOG, dialogStage);
		dialogStage.close();
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		preferences = mainApp.getApplicationPreferences();
		dialogStage = preferences.getLastWindowParameters(ApplicationPreferences.LAST_TEMPLATE_NAVIGATOR_DIALOG, dialogStage, 400.,
				400.);
	}

	/**
	 * @param rootLayoutController the rootLayoutController to set
	 */
	public void setRootLayoutController(RootLayoutController rootLayoutController) {
		this.rootLayoutController = rootLayoutController;
	}

}
