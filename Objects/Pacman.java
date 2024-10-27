package Objects;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import Common.GlobalConstants;
import Game.GameState;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import Movement.CollisionDetection;

import java.util.ArrayList;

/**
 * Pacman
 */
public class Pacman extends MovableObject {
    private String nextDirection;
    
    
    private GameState gameState;
    
    public Pacman(ArrayList<Wall> walls, ArrayList<Coin> coins, GameState gameState) {
        super();
        this.gameState = gameState;
        this.nextDirection = "";
        
        this.setLocation(90, 30);
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
        var wall = this.colidesWithWall(this.getX() + newDx, this.getY() + newDy);
        if (wall == null) {
            this.dx = newDx;
            this.dy = newDy;
            this.nextDirection = "";
        } else if (newDx > 0) {
            this.nextDirection = "RIGHT";
        } else if (newDx < 0) {
            this.nextDirection = "LEFT";
        } else if (newDy > 0) {
            this.nextDirection = "DOWN";
        } else if (newDy < 0) {
            this.nextDirection = "UP";
        }
    }
    
    public void setNextDirection(String nextDirection) {
        this.nextDirection = nextDirection;
    }

    public String getNextDirection() {
        return this.nextDirection;
    }
    
    public void nextChangeDirection(String direction) {
        if (direction.equals("LEFT")) {
            changeDirection(-STEP, 0);
        } 
        if (direction.equals("RIGHT")) {
            changeDirection(STEP, 0);
            
        } 
        if (direction.equals("UP")) {
            changeDirection(0, -STEP);
            
        } 
        if (direction.equals("DOWN")) {
            changeDirection(0, STEP);
        }
    }

    
    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // deletes everything added before
        g.setColor(Color.YELLOW);
        g.fillOval(0, 0, objSize, objSize);  // Draw a yellow circle (Pacman)
    }

    private Wall colidesWithWall(int x, int y) {
        for (Wall wall : this.gameState.getMap().getWalls()) {
            int wallX = wall.getX();
            int wallY = wall.getY();

            if (Math.abs(x - wallX) < GlobalConstants.TileSize 
                && Math.abs(y - wallY) < GlobalConstants.TileSize) {
                return wall;
            }
        }
        return null;
    }
}
