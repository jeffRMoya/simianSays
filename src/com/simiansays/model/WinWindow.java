package com.simiansays.model;

import com.simiansays.model.app.SimianSaysApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WinWindow {
    //INSTANCE VARIABLE of JFRAME- FIELDS
    private JFrame window;
    private JPanel panel;
    private JButton playAgainButton;
    private JLabel label;
    private JPanel mainPanel;

    // JFRAME WINDOW CONSTRUCTOR
    public WinWindow() {
        window = new JFrame();
        window.setTitle("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        // within window PANEL SPECS
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.setBackground(Color.BLACK);
        // within window PANEL LOCATION
        window.add(panel, BorderLayout.CENTER);

        // art
        label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        panel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        ImageIcon printIcon = new ImageIcon("BF.png");
        label.setIcon(printIcon);

        //You Won message
        label = new JLabel("Congratulations");
        panel.add(label);
        label.setForeground(Color.PINK);
        label.setFont(new Font("Arial", Font.BOLD, 80));
        label = new JLabel("       You Won !!     ");
        panel.add(label);
        label.setForeground(Color.PINK);
        label.setFont(new Font("Arial", Font.BOLD, 80));

        // PlayAgain BUTTON
        playAgainButton = new JButton("PLAY AGAIN");
        playAgainButton.setFont(new Font("Arial", Font.PLAIN, 35));
        playAgainButton.setPreferredSize(new Dimension(300, 100));
        panel.add(playAgainButton);

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("PLAY AGAIN BUTTON HAS BEEN CLICKED");
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