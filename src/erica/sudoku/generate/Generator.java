package erica.sudoku.generate;

import erica.sudoku.Grid;

/**
 * A Sudoku generator interface
 */
public interface Generator {
    /**
     * Generate a Sudoku game
     */
    public Grid generate();
}