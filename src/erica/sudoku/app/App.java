package erica.sudoku.app;

import javax.swing.*;

/**
 * Swing app for interactive Sudoku games
 */
public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePanel panel = new GamePanel();
        frame.add(panel);
        frame.setBounds(100, 100, 400, 400);
        frame.setTitle("Sudoku");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
