package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * MovableObject
 */
public abstract class MovableObject extends JPanel implements ActionListener {
    protected final int STEP = 1;
    protected int dx;
    protected int dy;
    protected int x = 50;
    protected int y = 50;
    protected int objSize = 30;
    protected Timer timer;

    public MovableObject() {
        super();
        // Calls the actionPerformed() function every 1ms
        timer = new Timer(1, this);
        timer.start();
        this.setPreferredSize(new Dimension(objSize, objSize));
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        x += this.dx;
        y += this.dy;
        // Erases the object from its current position and calls paintComponent() function
        repaint();
    }

    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, objSize, objSize);
    }
}