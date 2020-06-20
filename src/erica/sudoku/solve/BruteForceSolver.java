package erica.sudoku.solve;

import erica.sudoku.Grid;

import java.util.LinkedList;
import java.util.List;

public class BruteForceSolver implements Solver {

    private void bruteForce(List<Grid> solutions, Grid game) {

    }

    @Override
    public List<Grid> solve(Grid game) {
        List<Grid> solutions = new LinkedList<Grid>();
        bruteForce(solutions, game);
        return solutions;
    }
}
