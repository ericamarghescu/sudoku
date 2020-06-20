package erica.sudoku.generate;

import erica.sudoku.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolverFullGridGeneratorTest {

    @Test
    void doGenerate() {
        Generator generator = new SolverFullGridGenerator();
        Grid grid = generator.generate();
        Assertions.assertTrue(grid.isValid(), "Couldn't generate grid");
    }

    @Test
    void getShuffle() {
        SolverFullGridGenerator generator = new SolverFullGridGenerator();
        int[] arr = generator.getShuffle();
        Assertions.assertEquals(arr.length, 9);
        for(int i = 0; i < 9; i++) {
            Assertions.assertTrue(arr[i] <= 9 && arr[i] >= 1);
            for(int j = 0; j < i; j++) {
                Assertions.assertFalse(arr[j] == arr[i]);
            }
        }
    }
}