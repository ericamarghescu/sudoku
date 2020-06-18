package erica.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
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

    @BeforeEach
    void setUp() {
    }

    @Test
    void defaultConstructor() {
        Grid grid = new Grid();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                Assertions.assertEquals(grid.get(i, j), 0);
            }
        }
    }

    @Test
    void mainConstructor() {
        Grid grid = new Grid(seed);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                Assertions.assertEquals(grid.get(i, j), seed[i][j]);
            }
        }
    }

    @Test
    void get() {
        Grid grid = new Grid(seed);
        Assertions.assertEquals(grid.get(5,4), seed[5][4]);
        Assertions.assertEquals(grid.get(7,1), seed[7][1]);
        Assertions.assertEquals(grid.get(2,8), seed[2][8]);
    }

    @Test
    void getThrows() {
        Grid grid = new Grid(seed);
        Assertions.assertThrows(IllegalArgumentException.class, () -> { grid.get(2, 12); });
    }

    @Test
    void set() {
        Grid grid = new Grid();
        grid.set(5,6,1);
        Assertions.assertEquals(grid.get(6, 1), 5);
    }

    @Test
    void setThrows() {
        Grid grid = new Grid();
        Assertions.assertThrows(IllegalArgumentException.class, () -> { grid.set(5, 2, 12); });
    }

    @Test
    void testToStringDefault() {
        Grid grid = new Grid();
        Assertions.assertTrue(grid.toString().equals("0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n0  0  0  0  0  0  0  0  0\n"));
    }

    @Test
    void testToString() {
        Grid grid = new Grid(seed);
        Assertions.assertTrue(grid.toString().equals("5  3  0  0  7  0  0  0  0\n6  0  0  1  9  5  0  0  0\n0  9  8  0  0  0  0  6  0\n8  0  0  0  6  0  0  0  3\n4  0  0  8  0  3  0  0  1\n7  0  0  0  2  0  0  0  6\n0  6  0  0  0  0  2  8  0\n0  0  0  4  1  9  0  0  5\n0  0  0  0  8  0  0  7  9\n"));
    }

    @Test
    void valid() {
        Grid grid = new Grid(seed);
        Assertions.assertTrue(grid.valid(6, 0, 3));
        Assertions.assertTrue(grid.valid(4, 1, 1));
        Assertions.assertFalse(grid.valid(7, 0, 0));
        Assertions.assertFalse(grid.valid(9,1,8));
        Assertions.assertFalse(grid.valid(3,7,1));
        Assertions.assertFalse(grid.valid(6,4,6));
    }
}