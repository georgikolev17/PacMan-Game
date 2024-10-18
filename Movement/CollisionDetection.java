package Movement;

import java.util.ArrayList;
import java.lang.Math;

import Objects.MovableObject;
import Objects.Wall;


public class CollisionDetection {
    ArrayList<Wall> walls;
    int pacmanX;
    int pacmanY;
    int pacmanDx;
    int pacmanDy;
    int objSize;
    MovableObject pacman;

    public CollisionDetection(ArrayList<Wall> walls) {
        this.walls = walls;
        
    }

    public void checkCollision(MovableObject pacman) {
        this.pacmanX = pacman.getXPosition();
        this.pacmanY = pacman.getYPosition();
        this.pacmanDx = pacman.getDx();
        this.pacmanDy = pacman.getDy();
        this.objSize = pacman.getObjectSize();
        this.pacman = pacman;

        // Goes through each wall to see if the pacman has collision with one
        for (Wall wall : walls) {
            // Each if check if distance between pacman and wall is less than their size, the pacmans direction,
            // and if the wall is on the same row as the pacman 
            if ((-objSize < (wall.getX() - pacmanX)) && ((wall.getX() - pacmanX) < 0) && (Math.abs(wall.getY() - pacmanY) == 0) && (pacmanDx < 0)) {
                pacman.wallCollision("LEFT");
            } if ((objSize > (wall.getX() - pacmanX)) && ((wall.getX() - pacmanX) > 0) && (Math.abs(wall.getY() - pacmanY) == 0) && (pacmanDx > 0)) {
                pacman.wallCollision("RIGHT");
            } if ((-objSize < (wall.getY() - pacmanY)) && ((wall.getY() - pacmanY) < 0) && (Math.abs(wall.getX() - pacmanX) == 0) && (pacmanDy < 0)) {
                pacman.wallCollision("UP");
            } if ((objSize > (wall.getY() - pacmanY)) && ((wall.getY() - pacmanY) > 0) && (Math.abs(wall.getX() - pacmanX) == 0) && (pacmanDy > 0)) {
                pacman.wallCollision("DOWN");
            }

        }
    }
}