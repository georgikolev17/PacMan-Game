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

    /**
     * Makes a step in certain direction if possible.
     * @param collisionDetection collisionDetection.
     */
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

    /**
     * Summary: Checks if change of direction is possible.
     * @return true or false.
     */
    protected boolean canChangeDirection() {
        return this.getX() % GlobalConstants.TileSize == 0 
            && this.getY() % GlobalConstants.TileSize == 0;
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
