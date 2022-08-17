package com.simiansays.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWindow {
    // INSTANCE VARIABLES OF JFRAME
    private JFrame window;
    private JPanel titlePanel, instPanel, buttonPanel, scorePanel;
    private JButton playButton;
    private JLabel label;

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
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLUE);
        titlePanel.setBounds(0, 0, 1000, 300);
        window.add(titlePanel);

        // art
        label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        titlePanel.add(label);
        label.setForeground(Color.WHITE);

        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("data/BF.png");

        label.setIcon(printIcon);

        // INSTRUCTIONS Panel
        instPanel = new JPanel();
        instPanel.setBackground(Color.BLUE);
        instPanel.setBounds(0, 400, 1000, 250);
        window.add(instPanel);

        label = new JLabel("How To Play:");
        instPanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 35));

        label = new JLabel("<html>1. Watch Simian as colors lights up randomly.<br>" +
                "<html>2. Then Click on the colors in same order to progress to next round.<br>" +
                "<html>3. With each round, number of flashes increases.<br>" +
                "<html>4. Total of 10 successful rounds to Win the game.");
        instPanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 30));

        // SCORE Panel to show high-scores
        scorePanel = new JPanel();
        scorePanel.setBackground(Color.BLUE);
        scorePanel.setBounds(0, 650, 1000, 350);
        window.add(scorePanel);

        // Add score panel here



        // PLAY Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setBounds(0, 300, 1000, 100);
        window.add(buttonPanel);

        // PLAY BUTTON
        playButton = new JButton("PLAY");
        playButton.setFont(new Font("Arial", Font.PLAIN, 35));
        playButton.setPreferredSize(new Dimension(250, 75));
        buttonPanel.add(playButton);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("PLAY BUTTON HAS BEEN CLICKED");

                /*
                 * Swing method 'invokeLater' requires as a parameter an instance of runnable. InvokeLater will ensure all swing related
                 * code will run on the same thread. This thread is called, "Event Dispatch Thread (EDT)". Swing is not thread safe, so all
                 * swing code should run through this thread.
                 */
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        GameWindow gameWindow = new GameWindow();
                        gameWindow.show();
                    }
                });
            }
        });
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }
}