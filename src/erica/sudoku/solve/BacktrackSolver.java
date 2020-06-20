package erica.sudoku.solve;

import erica.sudoku.Grid;

import java.util.LinkedList;
import java.util.List;

public class BacktrackSolver implements Solver {
    private void backtrack(List<Grid> solutions, Grid game) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(game.isEmpty(i, j)) {
                    for(int x = 1; x <= 9; x++) {
                        if(game.valid(x, i, j)) {
                            game.set(x, i, j);
                            //System.out.println("i: " + i + ", j: " + j + "\n" + game);
                            //try { System.in.read(); } catch(Exception e) {}
                            backtrack(solutions, game);
                            game.setEmpty(i, j);
                        }
                    }
                    //System.out.println("Fail!");
                    return;
                }
            }
        }
        solutions.add(new Grid(game));
    }

    @Override
    public List<Grid> solve(Grid game) {
        List<Grid> solutions = new LinkedList<Grid>();
        backtrack(solutions, game);
        return solutions;
    }
}
