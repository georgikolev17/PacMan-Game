package Game;

import Objects.*;
import java.util.ArrayList;

/**
 * Summary: GameState keeps the state of the game at any time. 
 * It includes ghosts, the Pac-Man, the map, and the coins 
 */
public class GameState {
    private int score = 0;
    private int level = 1;
    private ArrayList<Ghost> ghosts;
    private Pacman pacman;
    private Map map;
    private Text text;
    
    public GameState() {
        this.ghosts = new ArrayList<Ghost>();
        this.map = new Map();
    
        this.pacman = new Pacman(this.map.getWalls(), this.map.getCoins(), this);
        this.text = new Text();
      
        this.ghosts.add(new SmartGhost(this.map.getGrid(), 1, 1));
        this.ghosts.add(new StupidGhost(this.map.getGrid(), 1, 1));
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public ArrayList<Coin> getCoins() {
        return this.getMap().getCoins();
    }

    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

    public Map getMap() {
        return this.map;
    }
    
    public Text getText() {
        return this.text;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(int increment) {
        this.score += increment;
        this.text.setScore(this.score);
    }

    public void levelUp() {
        this.level++;
        this.text.setLevel(this.level);
    }
}