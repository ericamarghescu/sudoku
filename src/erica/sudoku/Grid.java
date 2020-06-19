package erica.sudoku;

import com.google.common.base.Preconditions;

/**
 * Class that implements a grid representing a Sudoku game.
 */
public class Grid {
    int[][] grid;

    public Grid() {
        grid = new int[9][9];
    }

    /**
     * Constructs a grid from a 2-dimensional array
     * @param grid 2-d array
     */
    public Grid(int[][] grid) {
        this.grid = new int[9][9];
        Preconditions.checkArgument(grid.length == 9, "Invalid grid size: %s", grid.length);
        for (int i = 0; i < 9; i++) {
            Preconditions.checkArgument(grid[i].length == 9, "Invalid grid size: %s", grid[i].length);
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    /**
     * Retrieve the content of a cell in the grid
     * @param i the row
     * @param j the column
     * @return the content of the (i,j) cell
     */
    public int get(int i, int j) {
        Preconditions.checkPositionIndex(i, grid.length, "Index out of bounds");
        Preconditions.checkPositionIndex(j, grid[i].length, "Index out of bounds");
        return grid[i][j];
    }

    /**
     * Enters a number into an empty cell in the grid
     * @param num number
     * @param i the row
     * @param j the column
     */
    public void set(int num, int i, int j) {
        Preconditions.checkPositionIndex(i, grid.length, "Index out of bounds");
        Preconditions.checkPositionIndex(j, grid[i].length, "Index out of bounds");
        grid[i][j] = num;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(j == 8) {
                    str.append(grid[i][j]);
                } else {
                    str.append(grid[i][j]).append("  ");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Checks if number could possibly go into given cell in grid
     * @param num number
     * @param i the row
     * @param j the column
     */
    public boolean valid(int num, int i, int j) {
        if(grid[i][j] != 0) {
            return false;
        }
        for(int a = 0; a < 9; a++) {
            if(num == grid[a][j]) {
                return false;
            }
        }
        for(int b = 0; b < 9; b++) {
            if(num == grid[i][b]) {
                return false;
            }
        }
        int si = (i/3)*3;
        int sj = (j/3)*3;
        for(int x = si; x < si + 3; x++ ) {
            for(int y = sj; y < sj + 3; y++) {
                if(num == grid[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}