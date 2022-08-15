package com.simiansays.model.client;

import com.simiansays.model.HomeWindow;
import com.simiansays.model.app.SimianSaysApp;

import javax.swing.*;

class Main {
    public static void main(String[] args) {

        // INSTANTIATES SimianSaysApp (CONTROLLER)
        SimianSaysApp game1 = new SimianSaysApp();
        game1.executeHomeWindow();
    }
}