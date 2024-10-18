package Objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class Wall extends JPanel {
    private int side = 30; //pixels

    public Wall(int xCord, int yCord) {
        this.setLocation(xCord, yCord);

        this.setBounds(this.getX(), this.getY(), side, side);
        System.out.println("Wall created at: (" + this.getX() + ", " + this.getY() + "), size: " + side);
    }

    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, side, side);
    }
}
