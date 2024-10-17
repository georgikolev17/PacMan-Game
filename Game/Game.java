package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Objects.MovableObject;
import Objects.Pacman;

import Game.Renderer;

public class Game implements ActionListener {
    private Timer timer;
    public static GameThread gameThread;
    public GameState gameState;
    public static Renderer renderer;

    public static int ROWS = 20;
    public static int COLUMNS = 30;
    public static JFrame frame;
    public static JPanel panel;

    public void NewGame() {
        this.gameState = new GameState();

        this.timer = new Timer(1, this); // fires the timer every 1ms (calls actionPer)
        timer.start();

        frame = new JFrame("Pac-Man Movement");
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        panel.setSize(910, 630);
        panel.setBackground(Color.BLACK);

        Map map = new Map();
        for (var wall : map.getWalls()) {
            panel.add(wall);
        }
        MovableObject pacman = new Pacman();
        panel.add(pacman);
        // pacman.requestFocusInWindow();
        
        frame.setPreferredSize(new Dimension(910, 630));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        
    }
}
