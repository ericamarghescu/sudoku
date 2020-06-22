package erica.sudoku.generate;

import erica.sudoku.Grid;

/**
 * Generator of a fully filled grid
 */
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
        int[] random = new int[] {1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < 9; i++) {
            int temp = random[i];
            int num = i + (int) (Math.random() * (9-i) );
            random[i] = random[num];
            random[num] = temp;
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
