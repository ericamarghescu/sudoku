package erica.sudoku.app;

import erica.sudoku.Grid;
import erica.sudoku.generate.Generator;
import erica.sudoku.generate.GridGenerator;
import erica.sudoku.generate.SolverFullGridGenerator;
import erica.sudoku.solve.BacktrackSolver;
import erica.sudoku.solve.Solver;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Table data model based on a Sudoku grid
 */
public class GridTableModel extends AbstractTableModel {
    private Grid grid;
    private final static int[][] seed = {
            {5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}
    };

    public GridTableModel() {
        grid = new Grid(seed);
    }

    public void reset() {
        grid = new Grid(seed);
        fireTableDataChanged();
    }

    public void full() {
        Generator generator = new SolverFullGridGenerator();
        grid = generator.generate();
        fireTableDataChanged();
    }

    public void generate() {
        Generator generator = new GridGenerator(0.4);
        grid = generator.generate();
        fireTableDataChanged();
    }

    public void solve() {
        Solver solver = new BacktrackSolver();
        List<Grid> solutions = solver.solve(grid);
        if(solutions.size() == 1) {
            grid = solutions.get(0);
        } else if (solutions.size() == 0) {
            JOptionPane.showMessageDialog(null, "No solutions were found");
        } else {
            JOptionPane.showMessageDialog(null, "" + solutions.size() + " solutions were found");
        }
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return 9;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int i, int j) {
        if(grid.isEmpty(i, j)) {
            return "";
        } else {
            return grid.get(i, j);
        }

    }
}
