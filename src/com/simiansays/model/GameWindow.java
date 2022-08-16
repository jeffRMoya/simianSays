package com.simiansays.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow {


    // GAME WINDOW CONSTRUCTOR
    public JFrame window;
    public JPanel redPanel, bluePanel, orangePanel, greenPanel,
             blackLineBetweenButtons, board;
    public JButton startButton;
    public JTextField timeCount, levelCount;



    public GameWindow() {
        // BOARD
        board = new JPanel();
        board.setBackground(Color.BLACK);
        board.setBounds(350,350,300,300);
        board.setLayout(new FlowLayout(FlowLayout.CENTER,150,100));

        // BOARD START BUTTON
        startButton = new JButton("START");
        board.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("START BUTTON HAS BEEN CLICKED");
            }
        });

        // BOARD TIME COUNT
        timeCount = new JTextField();
        timeCount.setFont(new Font("Arial", Font.BOLD, 24));
        timeCount.setBackground(Color.WHITE);
        timeCount.setForeground(Color.BLACK);
        timeCount.setMargin(new Insets(100,100,100,100));
        board.add(timeCount);


        // ORANGE PANEL
        orangePanel = new JPanel();
        orangePanel.setBackground(Color.ORANGE.darker());
        orangePanel.setBounds(0,500,495,495);

        // GREEN PANEL
        greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN.darker());
        greenPanel.setBounds(0,0,495,495);

        // RED PANEL
        redPanel = new JPanel();
        redPanel.setBackground(Color.RED.darker());
        redPanel.setBounds(500,0,500,495);

        // BLUE PANEL
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE.darker());
        bluePanel.setBounds(500,500,500,495);

        // BLACK LINES (BLACK BACKGROUND TO BE SUPERIMPOSED ON)
        blackLineBetweenButtons = new JPanel();
        blackLineBetweenButtons.setBackground(Color.BLACK);
        blackLineBetweenButtons.setBounds(0,0,1000,1000);


        window = new JFrame("Simian Says");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setSize(1000,1000);
       // window.setVisible(true);

        window.add(board);
        window.add(timeCount);

        window.add(redPanel);
        window.add(bluePanel);
        window.add(greenPanel);
        window.add(orangePanel);

        window.add(blackLineBetweenButtons);
        }



    // show() METHOD CALLS FOR WINDOW IN main().
    public void show(){

        window.setVisible(true);
    }


}