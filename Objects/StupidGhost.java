package Objects;

import java.awt.Color;
import java.awt.Graphics;

import Common.GlobalConstants;


/**
 * Summary: Implements logic for the Stupid ghost.
 */
public class StupidGhost extends Ghost {

    public StupidGhost(int[][] grid, int spawnRow, int spawnCol) {
        super(grid, spawnRow, spawnCol);
    }

    @Override
    public void changeDirection(int pacmanX, int pacmanY) {
        if (!this.canChangeDirection()) {
            return;
        }

        int ghostRow = this.getY() / GlobalConstants.TileSize;
        int ghostCol = this.getX() / GlobalConstants.TileSize;

        // randomStep returns randomly next row and column that the ghost must go to.
        var nextCoordinates = movement.randomStep(ghostRow, ghostCol);
        int nextRow = nextCoordinates.getRow();
        int nextCol = nextCoordinates.getCol();
        if (nextRow > ghostRow) {
            this.dx = 0;
            this.dy = GHOST_STEP;
        } else if (nextRow < ghostRow) {
            this.dx = 0;
            this.dy = -GHOST_STEP;
        }

        if (nextCol > ghostCol) {
            this.dx = GHOST_STEP;
            this.dy = 0;
        } else if (nextCol < ghostCol) {
            this.dx = -GHOST_STEP;
            this.dy = 0;
        }
    }
    
    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // deletes everything added before
        g.setColor(Color.RED);
        g.fillOval(0, 0, objSize, objSize);  // Draw a red circle (stupid ghost)
    }
}
