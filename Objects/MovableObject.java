package Objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


import Common.GlobalConstants;
import Movement.CollisionDetection;

public abstract class MovableObject extends JPanel {
    protected static final int STEP = GlobalConstants.PacmanStep;
    protected int dx = STEP;
    protected int dy = 0;

    protected int objSize = GlobalConstants.MovableObjectSize;  // Size of Pacman
    protected Timer timer;

    public MovableObject() {
        super();
        setOpaque(false);  // Make the Pacman panel transparent
        this.setBounds(0, 0, 910, 630);  // Set the position and size explicitly
        this.setLocation(30, 30);
    }

    public void step(CollisionDetection collisionDetection) {
        var wall = collisionDetection.colidesWithWall(this.getX() + this.dx, this.getY() + this.dy);
        // System.out.println(wall);
        if (wall == null) {
            this.setLocation(this.getX() + this.dx, this.getY() + this.dy);
        } else {
            if (this.dx > 0) {
                this.setLocation(wall.getX() - GlobalConstants.TileSize, this.getY());
            } else if (this.dx < 0) {
                this.setLocation(wall.getX() + GlobalConstants.TileSize, this.getY());
            } else if (this.dy > 0) {
                this.setLocation(this.getX(), wall.getY() - GlobalConstants.TileSize);
            } else if (this.dy < 0) {
                this.setLocation(this.getX(), wall.getY() + GlobalConstants.TileSize);
            }
        }

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
        // System.out.println(this.getX() + " " + this.getX());
        return this.getX() % GlobalConstants.TileSize == 0 && this.getY() % GlobalConstants.TileSize == 0;
    }

    /**
     * Stops the pacman from moving if there is a collision between it and a wall.
     * @param collisionLocation where the collition is (left, right, up or down)
    //  */
    // public void wallCollision(String collisionLocation) {
    //     if (collisionLocation.equals("LEFT")) {
    //         this.dx = 0;
    //         this.setLocation(this.getX() + STEP, this.getY());
    //     } 
    //     if (collisionLocation.equals("RIGHT")) {
    //         this.dx = 0;
    //         this.setLocation(this.getX() - STEP, this.getY());
    //     } 
    //     if (collisionLocation.equals("UP")) {
    //         this.dy = 0;
    //         this.setLocation(this.getX(), this.getY() + STEP);
    //     } 
    //     if (collisionLocation.equals("DOWN")) {
    //         this.dy = 0;
    //         this.setLocation(this.getX(), this.getY() - STEP);
    //     }
    // }   

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
