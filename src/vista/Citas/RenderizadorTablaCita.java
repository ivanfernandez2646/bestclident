/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Citas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author IVÁN-PC
 */
public class RenderizadorTablaCita extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == 5 || column == 6) {
            this.setBackground(new Color(255, 0, 0, 65));
            this.setEnabled(false);
            this.setFocusable(false);
            this.setVisible(false);
            this.setBorder(noFocusBorder);
        } else if ( table.getValueAt(row, column) == null ) {
            this.setBackground(new Color(255, 0, 0, 65));
            this.setEnabled(false);
            this.setFocusable(false);
            this.setVisible(false);
            this.setBorder(noFocusBorder);
        } else {
            if (isSelected) {
                this.setBackground(new Color(255, 255, 153));
            } else {
                this.setBackground(Color.white);
            }
            this.setVisible(true);
            this.setEnabled(true);
            this.setFocusable(true);
        }
        this.setBorder(new BevelBorder(CENTER));
        return this;
    }
}
