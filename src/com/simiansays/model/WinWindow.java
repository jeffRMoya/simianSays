package com.simiansays.model;

import javax.swing.*;
import java.awt.*;

class WinWindow {
    //INSTANCE VARIABLE of JFRAME- FIELDS
    private final JFrame window;

    // JFRAME WINDOW CONSTRUCTOR
    public WinWindow() {
        // window specs
        window = new JFrame("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setSize(1000, 1000);
        window.setLocationRelativeTo(null);

        // within window TITLE PANEL Specs
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setBounds(0, 0, 1000, 300);
        window.add(titlePanel);

        // art
        JLabel label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        titlePanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("data/BF.png");
        label.setIcon(printIcon);

        // Won message Panel
        JPanel msgPanel = new JPanel();
        msgPanel.setBackground(Color.BLACK);
        msgPanel.setBounds(0, 300, 1000, 300);
        window.add(msgPanel);

        label = new JLabel("Congratulations");
        msgPanel.add(label);
        label.setForeground(Color.YELLOW);
        label.setFont(new Font("Arial", Font.BOLD, 90));
        label = new JLabel("You Won !!");
        msgPanel.add(label);
        label.setForeground(Color.YELLOW);
        label.setFont(new Font("Arial", Font.BOLD, 90));

        //PLAY AGAIN Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBounds(0, 600, 1000, 400);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        window.add(buttonPanel);

        // PlayAgain BUTTON
        JButton playAgainButton = new JButton("PLAY AGAIN");
        playAgainButton.setFont(new Font("Arial", Font.PLAIN, 35));
        playAgainButton.setPreferredSize(new Dimension(300, 100));
        playAgainButton.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 100));
        buttonPanel.add(playAgainButton);

        playAgainButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            GameWindow gameWindow = new GameWindow();
            gameWindow.show();
        }));
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }
}