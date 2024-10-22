package Objects;

import Common.GlobalConstants;
import Movement.GhostMovement;

/**
 * Ghost
 */
public abstract class Ghost extends MovableObject {
    protected static GhostMovement movement;
    protected static final int GHOST_STEP = STEP - 2;

    public Ghost(int[][] grid, int spawnRow, int spawnCol) {
        super();
        movement = new GhostMovement(grid);
        this.dx = GHOST_STEP;
        this.dy = 0;
        this.setLocation(spawnCol * GlobalConstants.TileSize, spawnRow * GlobalConstants.TileSize);
    }

    /**
     * Summary: The method checks the ghost's and pacman's locations 
     * and changes the movement direction if necessary.
     * @param pacmanX pacmsn's x coordinate
     * @param pacmanY pacman's y coordinate
     */
    public abstract void changeDirection(int pacmanX, int pacmanY);

    
}