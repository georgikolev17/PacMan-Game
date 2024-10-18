package Objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class MovableObject extends JPanel {
    protected final int STEP = 5;
    protected int dx = STEP;
    protected int dy = 0;
    protected int x;
    protected int y;
    protected int objSize = 30;  // Size of Pacman
    protected Timer timer;

    public MovableObject() {
        super();
        setOpaque(false);  // Make the Pacman panel transparent
        this.setBounds(0, 0,910, 630);  // Set the position and size explicitly

        
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


    public int getXPosition() {
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

}
