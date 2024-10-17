package Objects;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Wall extends JPanel {
    private int side = 30; //pixels
    public int x;
    public int y;

    public Wall(int xCord, int yCord) {
        this.x = xCord;
        this.y = yCord;

        this.setBounds(x, y, side, side);
    }

    // Draws the object at coordinates x and y
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, side, side);
    }
}
