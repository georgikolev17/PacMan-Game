package Objects;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Pacman
 */
public class Pacman extends MovableObject {

    public Pacman() {
        super();
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.BLACK);
        this.dx = STEP;
        this.dy = 0;

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "moveUp");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "moveDown");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");

        getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDirection(0, -STEP);  // Move up
            }
        });

        getActionMap().put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDirection(0, STEP);  // Move down
            }
        });

        getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDirection(-STEP, 0);  // Move left
            }
        });

        getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDirection(STEP, 0);  // Move right
            }
        });
    }

    public void changeDirection(int newDx, int newDy) {
        this.dx = newDx;
        this.dy = newDy;
    }

    
    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // deletes everything added before
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, objSize, objSize);  // Draw a yellow circle (Pacman)
    }
}
