package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Customize coloring scheme
 */
public class MyColorRenderer extends DefaultTableCellRenderer {
    private int[] rowsToColor; // Store the row indices to be colored
    private Color color; // Color for the specified rows

    /**
     * Color specific rows by index
     * @param rowsToColor
     * @param color 
     */
    public MyColorRenderer(int[] rowsToColor, Color color) {
        this.rowsToColor = rowsToColor;
        this.color = color;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Check if the current row should be colored
        for (int rowToColor : rowsToColor) {
            if (row == rowToColor) {
                c.setBackground(color);
                break;
            } else {
                c.setBackground(table.getBackground());
            }
        }

        return c;
    }
}