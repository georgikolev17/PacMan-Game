package Objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


import Common.GlobalConstants;

public abstract class MovableObject extends JPanel {
    protected static final int STEP = 5;
    protected int dx = STEP;
    protected int dy = 0;

    protected int objSize = 30;  // Size of Pacman
    protected Timer timer;

    public MovableObject() {
        super();
        setOpaque(false);  // Make the Pacman panel transparent
        this.setBounds(0, 0, 910, 630);  // Set the position and size explicitly
        this.setLocation(30, 30);
    }

    public void step() {
        this.setLocation(this.getX() + this.dx, this.getY() + this.dy);

        // Ensure the object stays within panel bounds
        if (this.getX() < 0) {
            this.setLocation(0, this.getY());
        }
        if (this.getY() < 0) {
            this.setLocation(this.getX(), 0);
        }
        if (this.getX() + objSize > getWidth()) {
            this.setLocation(getWidth() - objSize, this.getY());
        }
        if (this.getY() + objSize > getHeight()) {
            this.setLocation(this.getX(), getHeight() - objSize);
        }
        // Repaint the object
        repaint();
    }
    protected boolean canChangeDirection() {
        System.out.println(this.getX() + " " + this.getX());
        return this.getX() % GlobalConstants.TileSize == 0 && this.getY() % GlobalConstants.TileSize == 0;
    }

    /**
     * Summary: The step every movable object makes on every period of time (for now 30ms).
     */
    public void step() {
        x += this.dx;
        y += this.dy;
        // System.out.println(y / 30 + " " + x / 30);
        
        // Repaint the object
        repaint();
    }

    /**
     * Stops the pacman from moving if there is a collision between it and a wall.
     * @param collisionLocation where the collition is (left, right, up or down)
     */
    public void wallCollision(String collisionLocation) {
        if (collisionLocation.equals("LEFT")) {
            this.dx = 0;
            this.x += STEP;
        } if (collisionLocation.equals("RIGHT")) {
            this.dx = 0;
            this.x -= STEP;
        } if (collisionLocation.equals("UP")) {
            this.dy = 0;
            this.y += STEP;
        } if (collisionLocation.equals("DOWN")) {
            this.dy = 0;
            this.y -= STEP;
        }
    }

    public boolean canChangeDirection() {
        return (this.x % 30 == 0) && (this.y % 30 == 0);
    }

    public int getDx() {
        return this.dx;
    }

    public int getDy() {
        return this.dy;
    }

    public int getObjectSize() {
        return this.objSize;
    }
}
