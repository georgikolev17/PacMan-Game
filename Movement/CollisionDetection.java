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