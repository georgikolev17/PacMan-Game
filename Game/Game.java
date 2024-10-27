package Game;

import Movement.CollisionDetection;
import Objects.Coin;
import Objects.Menu;
import Objects.MovableObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Summary: The Game class controls the operations in the whole game.
 */
public class Game implements ActionListener {
    private Timer timer;
    public GameState gameState;
    public CollisionDetection collisionDetection;

    public static int ROWS = 20;
    public static int COLUMNS = 30;
    public JFrame frame;
    public JPanel panel; // Main panel

    /**
     * Summary: Starts a new game.
     */
    public void NewGame() {
        this.gameState = new GameState(); // object with all objects in game.

        frame = new JFrame("Pac-Man Movement");
        panel = new JPanel(); // Main panel with all objects

        panel.setLayout(null); // Removes layout manager so we can use coordinates.
        frame.setPreferredSize(new Dimension(910, 630)); //Sets size of frame
        panel.setSize(910, 630); // Sets size of panel same as frame.
        panel.setBackground(Color.BLACK);
        
        // Gets all objects from gameState object.
        Map map = gameState.getMap();
        MovableObject pacman = gameState.getPacman();

        collisionDetection = new CollisionDetection(this.gameState);

        frame.add(panel);

        panel.add(pacman);

        // Adds every wall in the map to the panel
        for (var wall : map.getWalls()) {
            panel.add(wall);
        }

        // Spawns coins on the map
        this.spawnCoins(this.gameState.getCoins());

        // Puts label for score in the panel to the front
        JLabel scoreLabel = this.gameState.getText().getScore();
        panel.add(scoreLabel);
        panel.setComponentZOrder(scoreLabel, 1);  // Puts the label in front

        // Puts label for level in the panel to the front
        JLabel levelLabel = this.gameState.getText().getLevel();
        panel.add(levelLabel);
        panel.setComponentZOrder(levelLabel, 1);  // Puts the label in front

        for (var ghost : this.gameState.getGhosts()) {
            panel.add(ghost);
        }
        
        frame.pack(); // Fits the frame to the prefered size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Puts window in middle of screen
        frame.setResizable(false); // Makes it so you cant resize window.
        frame.setVisible(true);

        this.timer = new Timer(20, this); // fires the timer every 1ms (calls actionPer)
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameState.getPacman().step(this.collisionDetection);
        this.gameState.getPacman()
            .nextChangeDirection(this.gameState.getPacman().getNextDirection());

        var ghosts = this.gameState.getGhosts();
        for (var ghost : ghosts) {
            ghost.changeDirection(this.gameState.getPacman().getX(), 
                this.gameState.getPacman().getY());
            ghost.step(this.collisionDetection);
        }

        var coin = collisionDetection.checkCoinCollision();
        if (coin != null) {
            this.removeCoin(coin);
            
        }

        if (!this.gameState.getMap().areAnyCoinsLeft()) {
            this.gameState.getMap().generateCoins();
            this.spawnCoins(this.gameState.getCoins());
            this.gameState.levelUp();
            // TODO: Spawn 1 more stupid and smart ghost.
            var smart = this.gameState.spawnSmartGhost(18, 1);
            var stupid = this.gameState.spawnStupidGhost(18, 1);
            panel.add(smart);
            panel.add(stupid);
        }

        if (this.collisionDetection.pacmanCollidesWithGhost(this.gameState.getPacman().getX(),
            this.gameState.getPacman().getY())) {
            this.gameOver();
        }
    }

    private void gameOver() {
        timer.stop(); // Stops timer from running

        Menu menu = new Menu(this); // Creates a quit menu
        menu.setBounds(0, 0, panel.getWidth(), panel.getHeight()); 

        panel.add(menu);
        panel.setComponentZOrder(menu, 0); // Puts the menu infront of everything else

        panel.revalidate();
        panel.repaint();
    }

    private void removeCoin(Coin coin) {
        this.panel.remove(coin); // Removes coin from the panel
        coin.setIsEaten(true); // Sets the coin as eaten
        this.gameState.addScore(coin.getValue());
        
    }

    private void spawnCoins(ArrayList<Coin> coins) {
        // Adds every coin in the map to the panel
        for (var coin : this.gameState.getMap().getCoins()) {
            panel.add(coin);
        }
    }
}
