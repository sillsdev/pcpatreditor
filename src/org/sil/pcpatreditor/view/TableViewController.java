/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.sil.pcpatreditor.ApplicationPreferences;
import org.sil.pcpatreditor.model.RuleChooserRule;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * @author Andy Black
 *
 */
public class TableViewController extends TableViewBaseController {

	ObservableList<? extends RuleChooserRule> list;
	TableView<? extends RuleChooserRule> tableView;
	protected String sChooser = "";
	protected  ApplicationPreferences prefs;
	
	public void initialize(URL location, ResourceBundle resources) {
		for (TableColumn<? extends RuleChooserRule, ?> column: tableView.getColumns()) {
			  column.widthProperty().addListener(new ChangeListener<Number>() {
			    @Override
			      public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
			        prefs.setPreferencesKey(sChooser + column.getId(), newWidth.doubleValue());
			    }
			  });
			}
	}

	public void setChoser(String sChooser) {
		this.sChooser = sChooser;
	}

	public void setTableView(TableView<? extends RuleChooserRule> tableView) {
		this.tableView = tableView;
	}

	protected void initializeTableColumnWidths(ApplicationPreferences prefs) {
        this.prefs = prefs;
        if (tableView != null) {
    		for (TableColumn<? extends RuleChooserRule, ?> column : tableView.getColumns()) {
    			Double d = prefs.getDoubleValue(sChooser + column.getId(), column.getPrefWidth());
    			column.setPrefWidth(d);
    		}
        }
	}

}
