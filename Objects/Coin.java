package Objects;

import java.awt.*;
import javax.swing.*;

/**
 * Summary: The coin has a position on the map and points that it gives to the player.
 */
public class Coin extends JPanel{
    private int objSize;
    /**
     * Summary: Initializes a new Coin class with the given x and y coordinates and points.
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Coin(int xCord, int yCord) {
        this.setLocation(xCord, yCord);
        this.objSize = 10;
        this.setBounds(this.getX(), this.getY(), objSize, objSize);
        setOpaque(false);
    }

    public int getObjectSize() {
        return this.objSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, objSize, objSize);  // Draw a small white circle (coin)
    }
}
