package erica.sudoku.generate;

import erica.sudoku.Grid;

public class SolverFullGridGenerator extends BaseGenerator {

    private boolean solve(Grid game) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(game.isEmpty(i, j)) {
                    int[] shuffle = getShuffle();
                    for(int x : shuffle) {
                        if(game.valid(x, i, j)) {
                            game.set(x, i, j);
                            if (solve(game)) {
                                return true;
                            }
                            game.setEmpty(i, j);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getShuffle() {
        int[] random = new int[9];
        for(int i = 0; i < 9; i++) {
            boolean found = true;
            while(found) {
                int num = (int) (Math.random() * 9) + 1;
                found = false;
                for (int j = 0; j < i; j++) {
                    if (random[j] == num) {
                        found = true;
                    }
                }
                if (!found) {
                    random[i] = num;
                }
            }
        }
        return random;
    }

    @Override
    public Grid doGenerate() {
        Grid grid = new Grid();
        solve(grid);
        return grid;
    }
}
