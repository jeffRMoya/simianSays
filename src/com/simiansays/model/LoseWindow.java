package com.simiansays.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseWindow {
    // INSTANCE VARIABLE OF JFRAME
    private JFrame window;
    private JPanel titlePanel, msgPanel, buttonPanel, scorePanel;
    private JButton replayButton;
    private JLabel label;

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
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.setBounds(0,0,1000,250);
        window.add(titlePanel);

        // art
        label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        titlePanel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("data/BF.png");
        label.setIcon(printIcon);

        //GameOver Message Panel
        msgPanel = new JPanel();
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
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.RED);
        buttonPanel.setBounds(0,500,1000,125);
        window.add(buttonPanel);

        //REPLY button
        replayButton = new JButton("REPLAY");
        replayButton.setFont(new Font("Arial", Font.PLAIN, 35));
        replayButton.setPreferredSize(new Dimension(300,100));

        buttonPanel.add(replayButton);

        // SCORE Panel
        scorePanel = new JPanel();
        scorePanel.setBackground(Color.RED);
        scorePanel.setBounds(0, 625, 1000, 375);
        window.add(scorePanel);

        replayButton.addActionListener(new ActionListener() {
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