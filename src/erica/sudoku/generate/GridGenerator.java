package erica.sudoku.generate;

import erica.sudoku.Grid;
import erica.sudoku.solve.BacktrackSolver;
import erica.sudoku.solve.Solver;

import java.util.List;

public class GridGenerator extends BaseGenerator {
    @Override
    public Grid doGenerate() {
        Generator generator = new SolverFullGridGenerator();
        Grid grid = generator.generate();
        Solver solver = new BacktrackSolver();
        while(true) {
            if(grid.isEmpty()) {
                grid = generator.generate();
            }
            int i = (int) (Math.random() * 9);
            int j = (int) (Math.random() * 9);
            int x = grid.get(i, j);
            if(!grid.isEmpty(i, j)) {
                grid.setEmpty(i, j);
                List<Grid> solutions = solver.solve(grid);
                if(solutions.size() > 1) {
                    grid.set(x, i, j);
                    break;
                }
            }
        }
        return grid;
    }
}
