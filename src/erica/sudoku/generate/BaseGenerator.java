package erica.sudoku.generate;

import com.google.common.base.Verify;
import erica.sudoku.Grid;

public abstract class BaseGenerator implements Generator {
    public abstract Grid doGenerate();

    @Override
    public Grid generate() {
        Grid grid = doGenerate();
        Verify.verify(grid.isValid(), "Unable to generate grid.");
        return grid;
    }
}
