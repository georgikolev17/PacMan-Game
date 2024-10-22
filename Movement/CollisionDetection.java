package Movement;

import java.util.ArrayList;

import Common.GlobalConstants;

import java.lang.Math;

import Objects.MovableObject;
import Objects.Pacman;
import Objects.Wall;
import Objects.Coin;
import Game.Game;
import Game.GameState;


public class CollisionDetection {
    private ArrayList<Wall> walls;
    private ArrayList<Coin> coins;
    private int pacmanX;
    private int pacmanY;
    private int pacmanDx;
    private int pacmanDy;
    private int objSize;
    private Pacman pacman;
    private int score;
    private GameState gameState;

    public CollisionDetection(ArrayList<Wall> walls, ArrayList<Coin> coins, Pacman pacman, GameState gameState) {
        this.walls = walls;
        this.pacman = pacman;
        this.coins = coins;
        this.gameState = gameState;
        this.score = 0;
    }

    public void checkCollision() {
        this.pacmanX = pacman.getX();
        this.pacmanY = pacman.getY();
        this.pacmanDx = pacman.getDx();
        this.pacmanDy = pacman.getDy();
        this.objSize = pacman.getObjectSize();

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
        
        // Goes through each coin to see if the pacman has collision with one.
        // If there is a collision, the coin gets removed and the points increase by one.
        for (Coin coin : coins) {
            if (!coin.getIsEaten() && (-coin.getObjectSize() < (coin.getX() - pacmanX)) && ((coin.getX() - pacmanX) < 0) && (Math.abs(coin.getY() - pacmanY) == 10) && (pacmanDx < 0)) {
                coinCollision(coin);

            } if (!coin.getIsEaten() && (objSize > (coin.getX() - pacmanX)) && ((coin.getX() - pacmanX) > 0) && (Math.abs(coin.getY() - pacmanY) == 10) && (pacmanDx > 0)) {
                coinCollision(coin);

            } if (!coin.getIsEaten() && (-coin.getObjectSize() < (coin.getY() - pacmanY)) && ((coin.getY() - pacmanY) < 0) && (Math.abs(coin.getX() - pacmanX) == 10) && (pacmanDy < 0)) {
                coinCollision(coin);

            } if (!coin.getIsEaten() && (objSize > (coin.getY() - pacmanY)) && ((coin.getY() - pacmanY) > 0) && (Math.abs(coin.getX() - pacmanX) == 10) && (pacmanDy > 0)) {
                coinCollision(coin);
                
            }
        }
    }

    public void coinCollision(Coin coin) {
        Game.panel.remove(coin); // Removes coin from the panel
        coin.setIsEaten(true); // Sets the coin as eaten
        score++;
        gameState.getText().setScore(score);
    }

    /**
     * Checks if there are walls around the object in all its directions.
     * @return an array with a boolean (true if there is wall and false if there isnt) 
     *         for every direction (0 is left, 1 is right, 2 is up and 3 is down).
     */
    public boolean[] whereAreWalls() {
        this.pacmanX = pacman.getX();
        this.pacmanY = pacman.getY();
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

    public Wall colidesWithWall(int x, int y) {
        for (Wall wall : walls) {
            int wallX = wall.getX();
            int wallY = wall.getY();

            if (Math.abs(x - wallX) < GlobalConstants.TileSize 
                && Math.abs(y - wallY) < GlobalConstants.TileSize) {
                return wall;
            }
        }
        return null;
    }
}