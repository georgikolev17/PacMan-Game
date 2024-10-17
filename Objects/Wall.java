package Objects;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Wall extends JPanel {
    private int side = 30; //pixels
    private int x;
    private int y;

    public Wall(int xCord, int yCord) {
        this.x = xCord;
        this.y = yCord;
    }

    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(x, y, side, side);
    }
}
