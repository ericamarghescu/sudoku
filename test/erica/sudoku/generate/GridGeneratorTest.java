package erica.sudoku.generate;

import erica.sudoku.Grid;
import erica.sudoku.solve.BacktrackSolver;
import erica.sudoku.solve.Solver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class GridGeneratorTest {

    @Test
    void doGenerate() {
        Generator generator = new GridGenerator(0.4);
        Grid grid = generator.generate();
        Assertions.assertTrue(grid.isValid(), "Couldn't generate grid");
    }

    @Test
    void doGenerateReturnsCorrectGame() {
        Generator generator = new GridGenerator(0.4);
        Grid grid = generator.generate();
        Solver solver = new BacktrackSolver();
        List<Grid> solutions = solver.solve(grid);
        Assertions.assertEquals(solutions.size(), 1);
    }
}