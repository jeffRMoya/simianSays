package com.simiansays.model;

import javax.swing.*;
import java.awt.*;

class LoseWindow {
    // INSTANCE VARIABLE OF JFRAME
    private final JFrame window;

    // JFRAME WINDOW CONSTRUCTOR
    public LoseWindow() {
        // window specs
        window = new JFrame("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setSize(1000, 1000);
        window.setLocationRelativeTo(null);

        // within window PANEL SPECS
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.setBounds(0,0,1000,250);
        window.add(titlePanel);

        // art
        JLabel label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        titlePanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("data/BF.png");
        label.setIcon(printIcon);

        //GameOver Message Panel
        JPanel msgPanel = new JPanel();
        msgPanel.setBackground(Color.RED);
        msgPanel.setBounds(0,250,1000,250);
        window.add(msgPanel);

        label = new JLabel("G A M E    O V E R");
        msgPanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 90));
        label = new JLabel("Try Again....");
        msgPanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 90));

        // REPLAY button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.RED);
        buttonPanel.setBounds(0,500,1000,125);
        window.add(buttonPanel);

        //REPLY button
        JButton replayButton = new JButton("REPLAY");
        replayButton.setFont(new Font("Arial", Font.PLAIN, 35));
        replayButton.setPreferredSize(new Dimension(300,100));
        buttonPanel.add(replayButton);

        // SCORE Panel
        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(Color.RED);
        scorePanel.setBounds(0, 625, 1000, 375);
        window.add(scorePanel);

        replayButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            GameWindow gameWindow = new GameWindow();
            gameWindow.show();
        }));
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }
}