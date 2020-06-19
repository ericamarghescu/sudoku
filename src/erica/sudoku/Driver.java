package erica.sudoku;

import erica.sudoku.solve.BacktrackSolver;
import erica.sudoku.solve.Solver;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        int[][] seed = {
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

        Grid sudoku = new Grid(seed);
        Solver solver = new BacktrackSolver();
        List<Grid> results = solver.solve(sudoku);
        for (Grid solution : results) {
            System.out.println(solution);
            System.out.println(solution.isValid());
        }
    }
}
