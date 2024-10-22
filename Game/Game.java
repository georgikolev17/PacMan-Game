package Game;

import Movement.CollisionDetection;
import Objects.MovableObject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Summary: d.
 */
public class Game implements ActionListener {
    private Timer timer;
    public static GameThread gameThread;
    public GameState gameState;
    public static Renderer renderer;
    public CollisionDetection collisionDetection;

    public static int ROWS = 20;
    public static int COLUMNS = 30;
    public static JFrame frame;
    public static JPanel panel; // Main panel

    /**
     * Summary: d.
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

        collisionDetection = new CollisionDetection(map.getWalls(), map.getCoins(), this.gameState.getPacman(), this.gameState);

        frame.add(panel);

        panel.add(pacman);

        // Adds every wall in the map to the panel
        for (var wall : map.getWalls()) {
            panel.add(wall);
        }

        // Adds every coin in the map to the panel
        for (var coin : map.getCoins()) {
            panel.add(coin);
        }

        // Puts label for score in the panel to the front
        JLabel scoreLabel = this.gameState.getText().getScore();
        panel.add(scoreLabel);
        panel.setComponentZOrder(scoreLabel, 0);  // Puts the label in front

        // Puts label for level in the panel to the front
        JLabel levelLabel = this.gameState.getText().getLevel();
        panel.add(levelLabel);
        panel.setComponentZOrder(levelLabel, 0);  // Puts the label in front

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
        // System.out.println(this.gameState.getPacman().getX() + " " + this.gameState.getPacman().getY());
        // System.out.println(this.gameState.getPacman().getSize());

        this.gameState.getPacman().step(this.collisionDetection);
        this.gameState.getPacman().nextChangeDirection(this.gameState.getPacman().getNextDirection());

        var ghosts = this.gameState.getGhosts();
        for (var ghost : ghosts) {
            ghost.changeDirection(this.gameState.getPacman().getX(), this.gameState.getPacman().getY());
            ghost.step(this.collisionDetection);
        }

        collisionDetection.checkCollision();
    }
}
