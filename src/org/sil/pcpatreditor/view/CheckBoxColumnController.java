/**
 * Copyright (c) 2021 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.sil.pcpatreditor.MainApp;
import org.sil.pcpatreditor.model.ChooserBase;

import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Andy Black
 *
 */
public abstract class CheckBoxColumnController {

	protected MainApp mainApp;
	protected ResourceBundle bundle;
	protected Locale locale;
	protected RootLayoutController rootController;
	
	@FXML
	protected CheckBox checkBoxColumnHead;
	protected ContextMenu checkBoxContextMenu = new ContextMenu();
	protected MenuItem selectAll = new MenuItem("Select All");
	protected MenuItem clearAll = new MenuItem("Clear All");
	protected MenuItem toggle = new MenuItem("Toggle");
	
	/**
	 * @return the mainApp
	 */
	public MainApp getMainApp() {
		return mainApp;
	}

	public void setRootLayout(RootLayoutController controller) {
		rootController = controller;
	}

	/**
	 * @param mainApp
	 *            the mainApp to set
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	abstract protected void handleCheckBoxSelectAll();

	abstract protected void handleCheckBoxClearAll();

	abstract protected void handleCheckBoxToggle();

	

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	protected void initializeCheckBoxContextMenu(ResourceBundle bundle) {
		// set up context menu
		selectAll.setOnAction((event) -> {
			handleCheckBoxSelectAll();
		});
		clearAll.setOnAction((event) -> {
			handleCheckBoxClearAll();
		});
		toggle.setOnAction((event) -> {
			handleCheckBoxToggle();
		});
		selectAll.setText(bundle.getString("checkbox.context.menu.selectall"));
		clearAll.setText(bundle.getString("checkbox.context.menu.clearall"));
		toggle.setText(bundle.getString("checkbox.context.menu.toggle"));
		checkBoxContextMenu.getItems().addAll(selectAll, clearAll, toggle);
		checkBoxColumnHead.setContextMenu(checkBoxContextMenu);
	}

	/**
	 * Called when the user clicks on the check box column header
	 */
	@FXML
	protected void handleCheckBoxColumnHead() {
		// make sure the check box stays checked
		checkBoxColumnHead.setSelected(true);
		// show the check box context menu
		checkBoxColumnHead.contextMenuProperty().get()
				.show(checkBoxColumnHead, Side.BOTTOM, 0.0, 0.0);
	}
	protected void processTableCell(TableCell<? extends ChooserBase, String> cell, Text text, String item, boolean empty) {
		processCell(cell, item, empty, null, null);
	}

	protected void processCell(TableCell<? extends ChooserBase, String> cell, String item,
			boolean empty, Color textColor, Font fontToUse) {
		Text text;
		if (item == null || empty) {
			cell.setText(null);
			cell.setStyle("");
		} else {
			cell.setStyle("");
			text = new Text(item.toString());
			// Get it to wrap.
			text.wrappingWidthProperty().bind(cell.getTableColumn().widthProperty());
			ChooserBase obj = (ChooserBase) cell.getTableRow().getItem();
//			if (obj != null && obj.isActive()) {
//				if (textColor != null) {
//					text.setFill(textColor);
//				} else {
//					text.setFill(Constants.ACTIVE);
//				}
//			} else {
//				text.setFill(Constants.INACTIVE);
//			}
			if (fontToUse != null) {
				text.setFont(fontToUse);
			}
			cell.setGraphic(text);
		}
	}


}
