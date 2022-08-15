package com.simiansays.model;

import com.simiansays.model.app.SimianSaysApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HomeWindow implements ActionListener, MouseListener {
    // INSTANCE VARIABLE OF JFRAME
    private JFrame window;
    private JPanel panel;
    private JButton playButton;
    private JLabel label;

    // JFRAME WINDOW CONSTRUCTOR
    public HomeWindow() {
        // window specs
        window = new JFrame();
        window.setTitle("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000,1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        // within window PANEL SPECS
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10 , 5));
        panel.setBackground(Color.BLUE);
        // within window PANEL LOCATION
        window.add(panel, BorderLayout.CENTER);

        // art
        label = new JLabel("BLUE FALCON 5: SIMIAN SAYS");
        panel.add(label);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial",Font.BOLD,40));
        ImageIcon printIcon = new ImageIcon("BF.png");
        label.setIcon(printIcon);


        // BUTTONS
        //play
        playButton = new JButton("PLAY");
        panel.add(playButton);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("PLAY BUTTON HAS BEEN CLICKED");

                SimianSaysApp play = new SimianSaysApp();
                play.executeGameWindow();
            }
        });

    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show(){
        window.setVisible(true);
    }


    // ACTION LISTENER CONTRACT METHODS
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // MOUSE LISTENER CONTRACT METHODS
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}