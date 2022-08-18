package com.simiansays.model;

import javax.swing.*;
import java.awt.*;

public class HomeWindow {
    // INSTANCE VARIABLES OF JFRAME
    private final JFrame window;

    // JFRAME WINDOW CONSTRUCTOR
    public HomeWindow() {
        // window specs
        window = new JFrame("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setSize(1000, 1000);
        window.setLocationRelativeTo(null);

        // within window TITLE PANEL Specs
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLUE);
        titlePanel.setBounds(0, 0, 1000, 300);
        window.add(titlePanel);

        // art
        JLabel label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        titlePanel.add(label);
        label.setForeground(Color.WHITE);

        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("data/BF.png");
        label.setIcon(printIcon);

        // INSTRUCTIONS Panel
        JPanel instPanel = new JPanel();
        instPanel.setBackground(Color.BLUE);
        instPanel.setBounds(0, 500, 1000, 250);
        window.add(instPanel);

        // How To Play - label
        label = new JLabel("How To Play:");
        instPanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 35));
        label = new JLabel("<html>1. Simian will click on 4 colors.<br>" +
                "<html>2. Player 2 should click on the colors in same order to win.");
        instPanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));

        // SCORE Panel to show high-scores
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.BLUE);
        scorePanel.setBounds(0, 750, 1000, 250);
        window.add(scorePanel);

        // PLAY Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setBounds(0, 300, 1000, 200);
        window.add(buttonPanel);

        // PLAY BUTTON
        JButton playButton = new JButton("PLAY");
        playButton.setFont(new Font("Arial", Font.PLAIN, 35));
        playButton.setPreferredSize(new Dimension(250, 75));
        buttonPanel.add(playButton);

        playButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            GameWindow gameWindow = new GameWindow();
            gameWindow.show();
        }));
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }
}