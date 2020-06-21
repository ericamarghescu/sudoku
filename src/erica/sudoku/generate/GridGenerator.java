package erica.sudoku.generate;

import com.google.common.base.Preconditions;
import erica.sudoku.Grid;
import erica.sudoku.solve.BacktrackSolver;
import erica.sudoku.solve.Solver;

import java.util.List;

public class GridGenerator extends BaseGenerator {
    private double ratio;

    public GridGenerator(double ratio) {
        Preconditions.checkArgument(ratio <= 1 && ratio >= ((double)17)/81, "Invalid ratio");
        this.ratio = ratio;
    }

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
                    if(grid.fillRatio() > ratio) {
                        grid = generator.generate();
                    } else {
                        break;
                    }
                }
            }
        }
        return grid;
    }
}
