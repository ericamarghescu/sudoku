package erica.sudoku;


public class Grid {
    int[][] grid;

    public Grid() {
        grid = new int[9][9];
    }

    public Grid(int[][] grid) {
        this.grid = new int[9][9];

        if(grid.length != 9) {
            throw new IllegalArgumentException("Invalid Grid");
        }

        for (int i = 0; i < 9; i++) {
            if(grid[i].length != 9) {
                throw new IllegalArgumentException("Invalid Grid");
            }
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    private void validate(int i, int j) {
        if(!(i >= 0 && i < 9 && j >= 0 && j < 9)) {
            throw new IllegalArgumentException("Invalid Indexes");
        }
    }

    public int get(int i, int j) {
        validate(i, j);
        return grid[i][j];

    }

    public void set(int num, int i, int j) {
        validate(i, j);
        grid[i][j] = num;
    }

    public String toString() {
        String string = "";
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(j == 8) {
                    string = string + grid[i][j];
                } else {
                    string = string + grid[i][j] + "  ";
                }
            }
            string = string + "\n";
        }
        return string;
    }

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