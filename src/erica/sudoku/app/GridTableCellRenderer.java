package erica.sudoku.app;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Custom table cell renderer that delegates to a default renderer
 */
public class GridTableCellRenderer implements TableCellRenderer {
    private DefaultTableCellRenderer renderer;

    public GridTableCellRenderer() {
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object o, boolean b, boolean b1, int i, int i1) {
        return renderer.getTableCellRendererComponent(jTable, o, b, b1, i, i1);
    }
}
