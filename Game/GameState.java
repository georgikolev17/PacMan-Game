package Game;

import Objects.*;
import java.util.ArrayList;

/**
 * Summary: GameState keeps the state of the game at any time. 
 * It includes ghosts, the Pac-Man, the map, and the coins 
 */
public class GameState {
    private ArrayList<Ghost> ghosts;
    private ArrayList<Coin> coins;
    private Pacman pacman;
    private Map map;
    
    public GameState() {
        this.ghosts = new ArrayList<Ghost>();
        this.coins = new ArrayList<Coin>();
        this.pacman = new Pacman();
        this.map = new Map();
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public ArrayList<Coin> getCoins() {
        return this.coins;
    }

    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

    public Map getMap() {
        return this.map;
    }
}