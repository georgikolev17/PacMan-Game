package Objects;

import Common.GlobalConstants;
import java.awt.*;
import javax.swing.*;

/**
 * Summary: The coin has a position on the map and points that it gives to the player.
 */
public class Coin extends JPanel{
    private int objSize;
    private boolean isEaten;
    private final int value;

    /**
     * Summary: Initializes a new Coin class with the given x and y coordinates and points.
     * @param xCord x-coordinate
     * @param yCord y-coordinate
     * @param value value of the coin.
     */
    public Coin(int xCord, int yCord, int value) {
        this.value = value;
        this.setLocation(xCord, yCord);
        this.objSize = GlobalConstants.CoinSize;
        this.isEaten = false;
        this.setBounds(this.getX(), this.getY(), objSize, objSize);
        setOpaque(false);
    }

    public int getObjectSize() {
        return this.objSize;
    }
    
    public boolean getIsEaten() {
        return this.isEaten;
    }

    public void setIsEaten(boolean isEaten) {
        this.isEaten = isEaten;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, objSize, objSize);  // Draw a small white circle (coin)
    }
}
