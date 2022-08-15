package com.simiansays.model.app;

import com.simiansays.model.GameWindow;
import com.simiansays.model.HomeWindow;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SimianSaysApp {

    public void executeHomeWindow() {
        /*
         * Swing method 'invokeLater' requires as a parameter an instance of runnable. InvokeLater will ensure all swing related
         * code will run on the same thread. This thread is called, "Event Dispatch Thread (EDT)". Swing is not thread safe, so all
         * swing code should run through this thread.
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomeWindow homeWindow = new HomeWindow();
                homeWindow.show();
            }
        });
    }


    public void executeGameWindow() {
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


}