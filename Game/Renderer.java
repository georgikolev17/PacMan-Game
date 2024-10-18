package Game;

import Game.Map;
import Game.Game;
import Objects.Wall;
import Objects.GhostSpawner;

import java.awt.Graphics;

import javax.swing.*;

/**
 * Renderer
 */
public class Renderer {
    private Map map;
    private int[][] grid;

    public Renderer() {
        this.map = new Map();
        this.grid = map.getGrid();
    }

    public void RenderMap(Game game) {
        int i = 0;
        int j = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    Wall wall = new Wall(i * 30, j * 30);
                }
                
                j++;
            }
            i++;
        }
    }
}