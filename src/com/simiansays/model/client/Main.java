package com.simiansays.model.client;

import com.simiansays.model.GameWindow;

import javax.swing.*;

class Main {
    public static void main(String[] args) {

        /*
         * Swing method 'invokeLater' requires as a parameter an instance of runnable. InvokeLater will ensure all swing related
         * code will run on the same thread. This thread is called, "event dispatch thread". Swing is not thread safe, so all
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