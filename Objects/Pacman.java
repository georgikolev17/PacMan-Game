package Objects;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import Movement.CollisionDetection;

import java.util.ArrayList;

/**
 * Pacman
 */
public class Pacman extends MovableObject {
    private ArrayList<Wall> walls;
    private CollisionDetection collisionDetection;

    public Pacman(ArrayList<Wall> walls) {
        super();
        this.walls = walls;
        this.collisionDetection = new CollisionDetection(walls, this);

        this.setLocation(30, 30);
        // setPreferredSize(new Dimension(800, 500));
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
        // boolean[] whereAreWalls = collisionDetection.whereAreWalls();
        // boolean canChange = true;
        // if (newDx > 0) {
        //     canChange = !whereAreWalls[1];
        // }
        // if (newDx < 0) {
        //     canChange = !whereAreWalls[0];
        // }
        // if (newDy > 0) {
        //     canChange = !whereAreWalls[3];
        // }
        // if (newDy < 0) {
        //     canChange = !whereAreWalls[2];
        // }
        // if (canChange) {
        //     this.dx = newDx;
        //     this.dy = newDy;
        // }

        if (collisionDetection.colidesWithWall(this.getX() + newDx, this.getY() + newDy) == null) {
            this.dx = newDx;
            this.dy = newDy;
        }
    }

    
    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // deletes everything added before
        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, objSize, objSize);  // Draw a yellow circle (Pacman)
    }
}
