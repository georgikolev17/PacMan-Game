package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Objects.Ghost;
import Objects.MovableObject;
import Objects.Pacman;

import Game.Renderer;
import Movement.CollisionDetection;

public class Game implements ActionListener {
    private Timer timer;
    public static GameThread gameThread;
    public GameState gameState;
    public static Renderer renderer;
    public CollisionDetection collisionDetection;

    public static int ROWS = 20;
    public static int COLUMNS = 30;
    public static JFrame frame;
    public static JPanel panel;

    public void NewGame() {
        

        this.gameState = new GameState(); // object with all objects in game.

        this.timer = new Timer(30, this); // fires the timer every 1ms (calls actionPer)
        timer.start();


        frame = new JFrame("Pac-Man Movement");
        panel = new JPanel(); // Main panel with all objects

        frame.add(panel);
        panel.setLayout(null); // Removes layout manager so we can use coordinates.
        frame.setPreferredSize(new Dimension(910, 630)); //Sets size of frame
        panel.setSize(910, 630); // Sets size of panel same as frame.
        panel.setBackground(Color.BLACK);

        // Gets all objects from gameState object.
        Map map = gameState.getMap();
        MovableObject pacman = gameState.getPacman();

        collisionDetection = new CollisionDetection(map.getWalls());

        // Adds every wall in the map to the panel
        for (var wall : map.getWalls()) {
            panel.add(wall);
        }

        panel.add(pacman);

        //panel.revalidate(); 
        //panel.repaint();
        
        frame.pack(); // Fits the frame to the prefered size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Puts window in middle of screen
        frame.setResizable(false); // Makes it so you cant resize window.
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameState.getPacman().step();

        var ghosts = this.gameState.getGhosts();
        for (var ghost : ghosts) {
            ghost.step();
        }

        collisionDetection.checkCollision(this.gameState.getPacman());

    }
}
