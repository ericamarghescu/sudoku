package erica.sudoku.solve;

import erica.sudoku.Grid;

import java.util.List;

/**
 * A Sudoku solver interface
 */
public interface Solver {
    /**
     * Solve a Sudoku game and return a list of solutions
     * @param game grid to solve
     * @return solutions
     */
    public List<Grid> solve(Grid game);
}
