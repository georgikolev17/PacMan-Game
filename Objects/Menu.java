package Objects;

import Game.Game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Summary: The menu that is diaplayed when the game is over.
 */
public class Menu extends JPanel {
    private JButton newGameButton;
    private JButton quitButton;
    private JLabel scoreText;
    private JLabel levelText;
    private Game game; // the object that runs the game

    public Menu(Game game) {
        this.game = game;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);
        
        // Creates new game and quit button
        this.newGameButton = new JButton("New Game");
        this.quitButton = new JButton("Quit");

        // Creates text displaying level and score
        int score = this.game.gameState.getScore();
        int level = this.game.gameState.getLevel();
        
        this.scoreText = new JLabel("Score: " + score);
        this.levelText = new JLabel("Level: " + level);

        // Sets color of buttons and text
        this.newGameButton.setBackground(Color.WHITE);
        this.quitButton.setBackground(Color.WHITE);

        this.scoreText.setForeground(Color.WHITE);
        this.levelText.setForeground(Color.WHITE);

        // Sets size of buttons and text
        this.newGameButton.setPreferredSize(new Dimension(300, 50));
        this.quitButton.setPreferredSize(new Dimension(300, 50));

        this.scoreText.setPreferredSize(new Dimension(300, 50));
        this.levelText.setPreferredSize(new Dimension(300, 50));

        // Changes font of text
        scoreText.setFont(new Font("Arial", Font.PLAIN, 24)); // Font size set to 24
        levelText.setFont(new Font("Arial", Font.PLAIN, 24)); // Font size set to 24

        // Centers the buttons and text
        this.newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.levelText.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Starts new game when "new game" button is clicked
        this.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.frame.dispose();
                game.NewGame();
            }
        });

        // Quits game when "quit" button is clicked
        this.quitButton.addActionListener(e -> System.exit(0));

        // Adds buttons and text to this panel and adds space above, bellow and between
        this.add(Box.createVerticalGlue()); // Space above buttons
        this.add(this.scoreText);
        this.add(Box.createVerticalStrut(30)); // The space between the text
        this.add(this.levelText);
        this.add(Box.createVerticalStrut(50)); // The space between the buttons and text
        this.add(this.newGameButton);
        this.add(Box.createVerticalStrut(30)); // The space between the buttons
        this.add(this.quitButton);
        this.add(Box.createVerticalGlue()); // Space bellow buttons
    }
}
