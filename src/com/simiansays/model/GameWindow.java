package com.simiansays.model;

import javax.swing.*;

public class GameWindow {

    // GAME WINDOW CONSTRUCTOR
    private JFrame window;

    public GameWindow() {
        // window specs
        window = new JFrame();
        window.setTitle("Simian Says");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1000, 1000);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }

}