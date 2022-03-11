/**
 * Copyright (c) 2022 SIL International
 * This software is licensed under the LGPL, version 2.1 or later
 * (http://www.gnu.org/licenses/lgpl-2.1.html)
 */

package org.sil.pcpatreditor.view;

import org.sil.pcpatreditor.model.RuleChooserRule;

import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Andy Black
 *
 */
public class TableViewBaseController {

	protected void processTableCell(TableCell<? extends RuleChooserRule, String> cell, Text text, String item, boolean empty) {
		processCell(cell, item, empty, null, null);
	}

	protected void processCell(TableCell<? extends RuleChooserRule, String> cell, String item, boolean empty, Color textColor, Font fontToUse) {
			Text text;
			if (item == null || empty) {
				cell.setText(null);
				cell.setStyle("");
			} else {
				cell.setStyle("");
				text = new Text(item.toString());
				// Get it to wrap.
				text.wrappingWidthProperty().bind(cell.getTableColumn().widthProperty());
				RuleChooserRule obj = (RuleChooserRule) cell.getTableRow().getItem();
				if (fontToUse != null) {
					text.setFont(fontToUse);
				}
				cell.setGraphic(text);
			}
		}

}
