package Objects;

import java.awt.*;
import javax.swing.*;

public class Text {
    private static JLabel scoreTextArea;
    private static JLabel levelTextArea;

    public Text() {
        scoreTextArea = new JLabel("Score: 0");
        levelTextArea = new JLabel("Level: 1");

        scoreTextArea.setBounds(0, 0, 100, 30);
        scoreTextArea.setForeground(Color.WHITE);
        levelTextArea.setBounds(70, 0, 50, 30);
        levelTextArea.setForeground(Color.WHITE);
    }

    /**
     * Changes the score displayed in the text.
     */
    public void setScore(int newScore) {
        scoreTextArea.setText("Score: " + newScore);
    }

    public JLabel getScore() {
        return scoreTextArea;
    }

    /**
     * Changes the level displayed in the text.
     */
    public void setLevel(int newLevel) {
        levelTextArea.setText("Level: " + newLevel);
    }

    public JLabel getLevel() {
        return levelTextArea;
    }
}
