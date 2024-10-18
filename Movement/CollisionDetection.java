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
            if ((-objSize < (wall.getX() - pacmanX)) && ((wall.getX() - pacmanX) < 0) && (Math.abs(wall.getY() - pacmanY) < 30) && (pacmanDx < 0)) {
                pacman.wallCollision("LEFT");
            } if ((objSize > (wall.getX() - pacmanX)) && ((wall.getX() - pacmanX) > 0) && (Math.abs(wall.getY() - pacmanY) < 30) && (pacmanDx > 0)) {
                pacman.wallCollision("RIGHT");
            } if ((-objSize < (wall.getY() - pacmanY)) && ((wall.getY() - pacmanY) < 0) && (Math.abs(wall.getX() - pacmanX) < 30) && (pacmanDy < 0)) {
                pacman.wallCollision("UP");
            } if ((objSize > (wall.getY() - pacmanY)) && ((wall.getY() - pacmanY) > 0) && (Math.abs(wall.getX() - pacmanX) < 30) && (pacmanDy > 0)) {
                pacman.wallCollision("DOWN");
            }

        }
    }

    public boolean[] whereAreWalls(MovableObject pacman) {
        this.pacmanX = pacman.getXPosition();
        this.pacmanY = pacman.getYPosition();
        this.objSize = pacman.getObjectSize();

        boolean[] whereAreWalls = new boolean[4]; 
        for (Wall wall : walls) {
            if (-objSize == (wall.getX() - pacmanX) && Math.abs(wall.getY() - pacmanY) < 30) {
                whereAreWalls[0] = true;
            } if (objSize == (wall.getX() - pacmanX) && Math.abs(wall.getY() - pacmanY) < 30) {
                whereAreWalls[1] = true;
            } if (-objSize == (wall.getY() - pacmanY) && Math.abs(wall.getX() - pacmanX) < 30) {
                whereAreWalls[2] = true;
            } if (objSize == (wall.getY() - pacmanY) && Math.abs(wall.getX() - pacmanX) < 30) {
                whereAreWalls[3] = true;
            }
        }
        return whereAreWalls;
    }
}