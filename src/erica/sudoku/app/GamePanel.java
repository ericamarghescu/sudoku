package erica.sudoku.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel for displaying buttons and grid
 */
public class GamePanel extends JPanel implements ActionListener {
    private JTable table;


    public GamePanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.GRAY);

        GridTableModel dataModel = new GridTableModel();
        table = new JTable(dataModel);
        table.setGridColor(Color.GRAY);
        Font tableFont = new Font("Roboto", Font.BOLD, 20);
        table.setFont(tableFont);
        int size = tableFont.getSize() + 5;
        table.setRowHeight(size);
        GridTableCellRenderer renderer = new GridTableCellRenderer();
        for(int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(size);
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        add(table, c);

        JButton resetButton = new JButton("Reset");
        resetButton.setActionCommand("Reset");
        resetButton.addActionListener(this);
        resetButton.setToolTipText("Reset the game to a predefined grid");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(resetButton, c);

        JButton fullButton = new JButton("Full");
        fullButton.setActionCommand("Full");
        fullButton.addActionListener(this);
        fullButton.setToolTipText("Displays a fully filled game");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        add(fullButton, c);

        JButton generateButton = new JButton("Generate");
        generateButton.setActionCommand("Generate");
        generateButton.addActionListener(this);
        generateButton.setToolTipText("Generates a new Sudoku game");
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        add(generateButton, c);

        JButton solveButton = new JButton("Solve");
        solveButton.setActionCommand("Solve");
        solveButton.addActionListener(this);
        solveButton.setToolTipText("Solves the current game");
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        add(solveButton, c);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("Reset")) {
            ((GridTableModel)table.getModel()).reset();
        } else if (actionEvent.getActionCommand().equals("Full")) {
            ((GridTableModel)table.getModel()).full();
        } else if (actionEvent.getActionCommand().equals("Generate")) {
            ((GridTableModel)table.getModel()).generate();
        } else if (actionEvent.getActionCommand().equals("Solve")) {
            ((GridTableModel)table.getModel()).solve();
        }
    }
}
