package Game;

import java.awt.Color;
import java.util.*;
import Objects.*;

public class Map {
    private int[][] grid;
    private final int ROWS = Game.ROWS;
    private final int COLUMNS = Game.COLUMNS;
    private ArrayList<Wall> walls;

    public Map() {
        grid = new int[ROWS][COLUMNS];
        walls = new ArrayList<Wall>();
        createGrid();
        this.generateWalls();
    }

    /**
     * Creates the grid(map).
     */
    private void createGrid() {
        String gridString = "111111111111111111111111111111" // a string of the grid
                          + "100000000011000000000000000001"
                          + "101011111011111011111101101101"
                          + "100011100000000010000101100001"
                          + "101010101111111010110101110101"
                          + "101010000000011000000000000101"
                          + "101010111011000011111111011101"
                          + "100000111000022011111111010001"
                          + "110110001011022000000011010111"
                          + "110111100011000011101011000111"
                          + "110000101011101000001011010111"
                          + "111110101011101011111011010111"
                          + "100000001000001000111011010001"
                          + "101011111110001101110011011101"
                          + "101010000000111101100111011101"
                          + "101010110110111101001111011101"
                          + "100000110110000000011100011101"
                          + "101010010111111111000001000001"
                          + "100011000111111111110111011111" 
                          + "111111111111111111111111111111";
        
        int i = 0; // To go through the String "gridString".
        int j = 0; // To go through every cell in each row.
        for (int[] row : grid) {
            j = 0;
            for (int cell : row) {
                String cellChar = gridString.substring(i, i + 1); // Cell as string.
                cell = Integer.parseInt(cellChar); // Sets cell to cellChar converted as an int.
                row[j] = cell;
                i++;
                j++;
            }
        }
    }

    private void generateWalls() {
        int i = 0;
        int j = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    Wall wall = new Wall(i * 30, j * 30);
                    this.walls.add(wall);
                }
                
                j++;
            }
            i++;
        }
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }
}
