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
        for (int i = 0; i < grid.length; i++) {
            Preconditions.checkArgument(grid[i].length == 9, "Invalid grid size: %s", grid[i].length);
            for (int j = 0; j < grid[i].length; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public Grid(Grid grid) {
        this(grid.grid);
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

    /**
     * Returns ratio of filled cells in the grid
     */
    public double fillRatio() {
        double fill = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!isEmpty(i, j)) {
                    fill++;
                }
            }
        }
        return fill/81;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
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
        for(int a = 0; a < grid.length; a++) {
            if(num == grid[a][j]) {
                return false;
            }
        }
        for(int b = 0; b < grid[i].length; b++) {
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

    /**
     * Checks if entire grid is empty
     */
    public boolean isEmpty() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!isEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if cell is empty
     * @param i the row
     * @param j the column
     */
    public boolean isEmpty(int i, int j) {
        Preconditions.checkPositionIndex(i, grid.length, "Index out of bounds");
        Preconditions.checkPositionIndex(j, grid[i].length, "Index out of bounds");

        return grid[i][j] == 0;
    }

    /**
     * Clears content of a cell
     * @param i the row
     * @param j the column
     */
    public void setEmpty(int i, int j) {
        set(0, i, j);
    }

    /**
     * Checks if an entire grid is full
     */
    public boolean isFull() {
        for(int i = 0; i < grid.length ; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(isEmpty(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if solution is valid
     */
    public boolean isValid() {
        for(int i = 0; i < grid.length ; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(!(isEmpty(i, j))) {
                    int temp = get(i, j);
                    setEmpty(i, j);
                    if(!(valid(temp, i, j))) {
                        return false;
                    }
                    set(temp, i, j);
                }
            }
        }
        return true;
    }
}