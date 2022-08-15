package com.simiansays.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWindow implements ActionListener, MouseListener {
    // INSTANCE VARIABLE OF JFRAME
    private JFrame window;

    // JFRAME WINDOW INSTANCE FIELDS
    public GameWindow() {
        window = new JFrame();
        window.setTitle("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000,1000);
        window.setLocationRelativeTo(null);

    }

    // show() METHOD CALLS FOR WINDOW.
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