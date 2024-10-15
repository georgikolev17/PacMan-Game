package Game;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.Timer;

import Objects.MovableObject;
import Objects.Pacman;

public class Game implements ActionListener {
    private Timer timer;
    public static GameThread gameThread;
    public GameState gameState;
    public static Renderer renderer;

    public void NewGame() {
        this.gameState = new GameState();

        this.timer = new Timer(1, this); // fires the timer every 1ms (calls actionPer)
        timer.start();

        JFrame frame = new JFrame("Pac-Man Movement");
        frame.setResizable(false);

        MovableObject pacman = this.gameState.getPacman();
        frame.add(pacman);
        // pacman.requestFocusInWindow();
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        
    }
}
