package Objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Common.GlobalConstants;

public abstract class MovableObject extends JPanel {
    protected static final int STEP = 3;
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
}
