package Objects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class MovableObject extends JPanel implements ActionListener {
    protected final int STEP = 5;
    protected int dx = STEP;
    protected int dy = 0;
    protected int x = 50;
    protected int y = 50;
    protected int objSize = 30;  // Size of Pacman
    protected Timer timer;

    public MovableObject() {
        super();
        setOpaque(false);  // Make the Pacman panel transparent
        this.setBounds(0, 0,910, 630);  // Set the position and size explicitly

        // Calls the actionPerformed() function every 30ms
        timer = new Timer(30, this);  // Slower timer for smoother movement
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += this.dx;
        y += this.dy;

        // Ensure the object stays within panel bounds
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x + objSize > getWidth()) x = getWidth() - objSize;
        if (y + objSize > getHeight()) y = getHeight() - objSize;

        // Repaint the object
        repaint();
    }

}
