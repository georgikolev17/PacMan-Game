package Objects;

import java.awt.Color;
import java.awt.Graphics;

import Common.GlobalConstants;

public class SmartGhost extends Ghost {

    public SmartGhost(int[][] grid, int spawnRow, int spawnCol) {
        super(grid, spawnRow, spawnCol);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void changeDirection(int pacmanX, int pacmanY) {
        if (!this.canChangeDirection()) {
            return;
        }
        int pacmanRow = pacmanY / GlobalConstants.TileSize;
        int pacmanCol = pacmanX / GlobalConstants.TileSize;

        int ghostRow = this.getY() / GlobalConstants.TileSize;
        int ghostCol = this.getX() / GlobalConstants.TileSize;

        System.out.println(ghostRow);
        System.out.println(ghostCol);
        // smartStep returns the next row and column that the ghost must go to 
        // based on the Pacman position.
        var nextCoordinates = movement.smartStep(ghostRow, ghostCol, pacmanRow, pacmanCol);
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
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, objSize, objSize);  // Draw a green circle (smart ghost)
    }
}
