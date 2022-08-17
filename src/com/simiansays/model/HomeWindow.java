package com.simiansays.model;

import javax.swing.*;
import java.awt.*;



public class HomeWindow {
    // INSTANCE VARIABLE OF J FRAME
    private final JFrame window;

    // J FRAME WINDOW CONSTRUCTOR
    public HomeWindow() {
        // window specs
        window = new JFrame();
        window.setTitle("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        // within window PANEL SPECS
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.BLUE);
        // within window PANEL LOCATION
        window.add(panel, BorderLayout.CENTER);

        // art
        JLabel label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        panel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("BF.png");
        label.setIcon(printIcon);


        // BUTTONS
        //play
        JButton playButton = new JButton("PLAY");
        panel.add(playButton);
        playButton.addActionListener(e -> {
            System.out.println("PLAY BUTTON HAS BEEN CLICKED");
                SwingUtilities.invokeLater(() -> {
                    GameWindow gameWindow = new GameWindow();
                    gameWindow.show();
                });
        });
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }
}