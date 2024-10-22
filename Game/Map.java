package Game;

import java.awt.Color;
import java.util.*;

import Common.GlobalConstants;
import Objects.*;

public class Map {
    private int[][] grid;
    private final int ROWS = Game.ROWS;
    private final int COLUMNS = Game.COLUMNS;
    private ArrayList<Wall> walls;
    private ArrayList<Coin> coins;

    public Map() {
        grid = new int[ROWS][COLUMNS];
        walls = new ArrayList<Wall>();
        coins = new ArrayList<Coin>();
        this.createGrid();
        this.generateWalls();
        this.generateCoins();
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public ArrayList<Wall> getWalls() {
        return this.walls;
    }

    public ArrayList<Coin> getCoins() {
        return this.coins;
    }

    public boolean areAnyCoinsLeft() {
        return this.coins.stream().anyMatch(c -> !c.getIsEaten());
    }

    /**
     * Creates the grid(map).
     */
    private void createGrid() {
        String gridString = "111111111111111111111111111111" // a string of the grid
                          + "100000000000000000000000000001"
                          + "101011111011111011111101101101"
                          + "100010000000000010000101100001"
                          + "101010101111111010110101110101"
                          + "101010000000011000000000000101"
                          + "101010111011011011110111011101"
                          + "100000111000000011110111010001"
                          + "110110001011011000000011010101"
                          + "110111100011000011101011000101"
                          + "110000101011101000001000010101"
                          + "111110101011101011111011010101"
                          + "100000001000101001111011010001"
                          + "101011111110001101110011011101"
                          + "101010000000111101100111011101"
                          + "101010110110111101001111011101"
                          + "100000110110000000011100011101"
                          + "101010010111111111011001000001"
                          + "100011000000000000000011111111" 
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
            j = 0;
            for (int cell : row) {
                if (cell == 1) {
                    Wall wall = new Wall(j * 30, i * 30);
                    this.walls.add(wall);
                }
                
                j++;
            }
            i++;
        }
    }

    public void generateCoins() {
        int i = 0;
        int j = 0;
        this.coins.clear();
        for (int[] row : grid) {
            j = 0;
            for (int cell : row) {
                // TODO: !!!! i == 1 IS JUST FOR TESTING THE LEVELS FUNCTIONALITY, REMOVE LATER!!!
                if (cell == 0 && i == 1) {
                    Coin coin = new Coin(j * GlobalConstants.TileSize + 10, 
                                         i * GlobalConstants.TileSize + 10, 1);
                    this.coins.add(coin);
                }
                
                j++;
            }
            i++;
        }
    }
}
