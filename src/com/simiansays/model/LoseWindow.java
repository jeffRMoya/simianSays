package com.simiansays.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseWindow implements ActionListener {
    // INSTANCE VARIABLE OF JFRAME
    private JFrame window;
    private JPanel panel;
    private JButton playButton;
    private JLabel label;

    // JFRAME WINDOW CONSTRUCTOR
    public LoseWindow() {
        // window specs
        window = new JFrame();
        window.setTitle("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        // within window PANEL SPECS
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.RED);
        // within window PANEL LOCATION
        window.add(panel, BorderLayout.CENTER);

        // art
        label = new JLabel("G A M E  O V E R.  Try Again?");
        panel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("BF.png");
        label.setIcon(printIcon);


        // BUTTONS
        //play
        playButton = new JButton("RePlay");
        panel.add(playButton);
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}