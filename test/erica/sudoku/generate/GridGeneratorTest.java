package erica.sudoku.generate;

import erica.sudoku.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridGeneratorTest {

    @Test
    void doGenerate() {
        Generator generator = new GridGenerator();
        Grid grid = generator.generate();
        Assertions.assertTrue(grid.isValid(), "Couldn't generate grid");
        System.out.println(grid.toString());
    }
}