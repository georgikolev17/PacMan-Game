package Movement;

import java.util.ArrayList;

import Common.GlobalConstants;

import java.lang.Math;

import Objects.MovableObject;
import Objects.Pacman;
import Objects.Wall;
import Objects.Coin;
import Objects.Ghost;
import Game.Game;
import Game.GameState;


public class CollisionDetection {
    private ArrayList<Wall> walls;
    private ArrayList<Coin> coins;
    private ArrayList<Ghost> ghosts;
    private int objSize;
    private Pacman pacman;
    private GameState gameState;

    public CollisionDetection(GameState gameState) {
        this.walls = gameState.getMap().getWalls();
        this.pacman = gameState.getPacman();
        this.coins = gameState.getMap().getCoins();
        this.ghosts = gameState.getGhosts();
        this.gameState = gameState;
        this.objSize = this.pacman.getObjectSize();
    }

    public void checkCollision() {

        // Goes through each wall to see if the pacman has collision with one
        // for (Wall wall : walls) {
        //     // Each if check if distance between pacman and wall is less than their size, the pacmans direction,
        //     // and if the wall is on the same row as the pacman 
        //     if ((-objSize < (wall.getX() - pacmanX)) && ((wall.getX() - pacmanX) < 0) && (Math.abs(wall.getY() - pacmanY) < 30) && (pacmanDx < 0)) {
        //         pacman.wallCollision("LEFT");
        //     } if ((objSize > (wall.getX() - pacmanX)) && ((wall.getX() - pacmanX) > 0) && (Math.abs(wall.getY() - pacmanY) < 30) && (pacmanDx > 0)) {
        //         pacman.wallCollision("RIGHT");
        //     } if ((-objSize < (wall.getY() - pacmanY)) && ((wall.getY() - pacmanY) < 0) && (Math.abs(wall.getX() - pacmanX) < 30) && (pacmanDy < 0)) {
        //         pacman.wallCollision("UP");
        //     } if ((objSize > (wall.getY() - pacmanY)) && ((wall.getY() - pacmanY) > 0) && (Math.abs(wall.getX() - pacmanX) < 30) && (pacmanDy > 0)) {
        //         pacman.wallCollision("DOWN");
        //     }
        // }
        
        // Goes through each coin to see if the pacman has collision with one.
        // If there is a collision, the coin gets removed and the points increase by one.
        // for (Coin coin : coins) {
        //     if (!coin.getIsEaten() && (-coin.getObjectSize() < (coin.getX() - this.pacman.getX())) 
        //         && ((coin.getX() - this.pacman.getX()) < 0) && (Math.abs(coin.getY() - this.pacman.getY()) == 10) 
        //         && (this.pacman.getDx() < 0)) {
        //         coinCollision(coin);
        //     } 
        //     if (!coin.getIsEaten() && (this.pacman.getObjectSize() > (coin.getX() - this.pacman.getX()))
        //         && ((coin.getX() - this.pacman.getX()) > 0) && (Math.abs(coin.getY() - this.pacman.getY()) == 10) 
        //         && (this.pacman.getDx() > 0)) {
        //         coinCollision(coin);
        //     } 
        //     if (!coin.getIsEaten() && (-coin.getObjectSize() < (coin.getY() - this.pacman.getY())) 
        //         && ((coin.getY() - this.pacman.getY()) < 0) && (Math.abs(coin.getX() - this.pacman.getX()) == 10) 
        //         && (this.pacman.getDy() < 0)) {
        //         coinCollision(coin);
        //     } 
        //     if (!coin.getIsEaten() && (this.pacman.getObjectSize() > (coin.getY() - this.pacman.getY())) 
        //         && ((coin.getY() - this.pacman.getY()) > 0) && (Math.abs(coin.getX() - this.pacman.getX()) == 10) 
        //         && (this.pacman.getDy() > 0)) {
        //         coinCollision(coin);
        //     }
        // }
    }

    public Coin checkCoinCollision() {
        for (Coin coin : coins) {
            if (!coin.getIsEaten() && (-coin.getObjectSize() < (coin.getX() - this.pacman.getX())) 
                && ((coin.getX() - this.pacman.getX()) < 0) && (Math.abs(coin.getY() - this.pacman.getY()) == 10) 
                && (this.pacman.getDx() < 0)) {
                return coin;
            } 
            if (!coin.getIsEaten() && (this.objSize > (coin.getX() - this.pacman.getX()))
                && ((coin.getX() - this.pacman.getX()) > 0) && (Math.abs(coin.getY() - this.pacman.getY()) == 10) 
                && (this.pacman.getDx() > 0)) {
                return coin;
            } 
            if (!coin.getIsEaten() && (-coin.getObjectSize() < (coin.getY() - this.pacman.getY())) 
                && ((coin.getY() - this.pacman.getY()) < 0) && (Math.abs(coin.getX() - this.pacman.getX()) == 10) 
                && (this.pacman.getDy() < 0)) {
                return coin;
            } 
            if (!coin.getIsEaten() && (this.objSize > (coin.getY() - this.pacman.getY())) 
                && ((coin.getY() - this.pacman.getY()) > 0) && (Math.abs(coin.getX() - this.pacman.getX()) == 10) 
                && (this.pacman.getDy() > 0)) {
                return coin;
            }
        }
        return null;
    }

    public void coinCollision(Coin coin) {
        // Game.panel.remove(coin); // Removes coin from the panel
        // coin.setIsEaten(true); // Sets the coin as eaten
        // score++;
        // gameState.getText().setScore(score);
    }

    /**
     * Checks if there are walls around the object in all its directions.
     * @return an array with a boolean (true if there is wall and false if there isnt) 
     *         for every direction (0 is left, 1 is right, 2 is up and 3 is down).
     */
    // public boolean[] whereAreWalls() {

    //     boolean[] whereAreWalls = new boolean[4]; 
    //     for (Wall wall : walls) {
    //         if (-objSize == (wall.getX() - this.pacman.getX()) && Math.abs(wall.getY() - this.pacman.getY()) < 30) {
    //             whereAreWalls[0] = true;
    //         } if (objSize == (wall.getX() - this.pacman.getX()) && Math.abs(wall.getY() - this.pacman.getY()) < 30) {
    //             whereAreWalls[1] = true;
    //         } if (-objSize == (wall.getY() - this.pacman.getY()) && Math.abs(wall.getX() - this.pacman.getX()) < 30) {
    //             whereAreWalls[2] = true;
    //         } if (objSize == (wall.getY() - this.pacman.getY()) && Math.abs(wall.getX() - this.pacman.getX()) < 30) {
    //             whereAreWalls[3] = true;
    //         }
    //     }
    //     return whereAreWalls;
    // }

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

    public boolean pacmanCollidesWithGhost(int pacmanX, int pacmanY) {
        for (Ghost ghost : this.ghosts) {
            int ghostX = ghost.getX();
            int ghostY = ghost.getY();

            if (Math.abs(pacmanX - ghostX) < GlobalConstants.MovableObjectSize 
                && Math.abs(pacmanY - ghostY) < GlobalConstants.MovableObjectSize) {
                return true;
            }
        }
        return false;
    }
}