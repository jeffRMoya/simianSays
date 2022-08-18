package com.simiansays.model;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;


public class GameWindow {

    // GAME WINDOW CONSTRUCTOR
    private final JFrame window;
    private final JButton startButton;
    private final JLabel timeLabel;
    private final JLabel dealerLabel;
    private Timer timer;
    boolean timerOn;
    private int second = 0;
    //private Collection<Integer> machineChoice = new ArrayList<>();
    private final Collection<Integer> simianChoice = new ArrayList<>();
    private final Collection<Integer> playerChoice = new ArrayList<>();

    public GameWindow() {
        // BOARD
        JPanel board = new JPanel();
        board.setBackground(Color.BLACK);
        board.setBounds(0, 0, 1000, 40);

        // BOARD START BUTTON
        startButton = new JButton("START");
        board.add(startButton);
        startButton.addActionListener(e -> {
            timer.start();
            //firstMove();
            startButton.setEnabled(false);
        });

        // BOARD TIMER DISPLAY
        // time label
        timeLabel = new JLabel("TIME: ");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        board.add(timeLabel);
        simpleTimer();

        // dealer label
        dealerLabel = new JLabel("TURN: Simian's Turn ");
        dealerLabel.setForeground(Color.WHITE);
        dealerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        board.add(dealerLabel);

        // GREEN PANEL (top left)
        ColorPanel greenPanel = new ColorPanel(Color.GREEN,0,45,495,450);
        greenPanel.addMouseListener(new ColorPanelListener());
        Map<Integer, ColorPanel> colorPanelMap = new HashMap<>();
        colorPanelMap.put(0,greenPanel);

        // RED PANEL (top right)
        ColorPanel redPanel = new ColorPanel(Color.RED,500, 45, 500, 450);
        redPanel.addMouseListener(new ColorPanelListener());
        colorPanelMap.put(1,redPanel);

        // ORANGE PANEL (bottom left)
        ColorPanel orangePanel = new ColorPanel(Color.ORANGE,0, 500, 495, 495);
        orangePanel.addMouseListener(new ColorPanelListener());
        colorPanelMap.put(2,orangePanel);

        // BLUE PANEL (bottom right)
        ColorPanel bluePanel = new ColorPanel(Color.BLUE,500, 500, 500, 495);
        bluePanel.addMouseListener(new ColorPanelListener());
        colorPanelMap.put(3,bluePanel);

        // BLACK LINES (BLACK BACKGROUND TO BE SUPERIMPOSED ON)
        JPanel blackLineBetweenButtons = new JPanel();
        blackLineBetweenButtons.setBackground(Color.BLACK);
        blackLineBetweenButtons.setBounds(0, 0, 1000, 1000);

        window = new JFrame("Simian Says");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setSize(1000, 1000);
        window.setLocationRelativeTo(null);
        window.add(board);
        window.add(redPanel);
        window.add(bluePanel);
        window.add(greenPanel);
        window.add(orangePanel);
        window.add(blackLineBetweenButtons);
    }

    // show() METHOD CALLS FOR WINDOW IN main().
    public void show() {
        window.setVisible(true);
    }

    // TIMER
    private void simpleTimer() {
        timer = new Timer(1000, e -> {
            second++;
            timeLabel.setText("TIME: " + second + ", ");
            timerOn = true;
        });
    }

//    private void firstMove() {
//        board.setOpaque(false);
//        greenPanelBright();
//        machineChoice.add(0);
//        bluePanelBright();
//        machineChoice.add(3);
//        orangePanelBright();
//        machineChoice.add(2);
//        redPanelBright();
//        machineChoice.add(1);
//        resetBoard();
//        System.out.println(machineChoice);
//    }

    private void turn() {
        if (simianChoice.size() == 4) {
            dealerLabel.setText(" TURN: Your Turn");
        }
    }

    private void smallWins() {
        if (playerChoice.size() == 4) {
            if (simianChoice.equals(playerChoice)) {
                SwingUtilities.invokeLater(() -> {
                    WinWindow winWindow = new WinWindow();
                    winWindow.show();
                });
            } else {
                SwingUtilities.invokeLater(() -> {
                    LoseWindow loseWindow = new LoseWindow();
                    loseWindow.show();
                });
            }
        }
    }

//    // PANELS SELECTED
//    private void greenPanelBright() {
//        colorPanelMap.get(3).setBackground(Color.BLUE.darker());
//        colorPanelMap.get(1).setBackground(Color.RED.darker());
//        colorPanelMap.get(2).setBackground(Color.ORANGE.darker());
//        colorPanelMap.get(0).setBackground(Color.GREEN.brighter());
//    }
//
//    private void redPanelBright() {
//        colorPanelMap.get(0).setBackground(Color.GREEN.darker());
//        colorPanelMap.get(3).setBackground(Color.BLUE.darker());
//        colorPanelMap.get(2).setBackground(Color.ORANGE.darker());
//        colorPanelMap.get(1).setBackground(Color.RED.brighter());
//    }
//
//    private void orangePanelBright() {
//        colorPanelMap.get(0).setBackground(Color.GREEN.darker());
//        colorPanelMap.get(3).setBackground(Color.BLUE.darker());
//        colorPanelMap.get(1).setBackground(Color.RED.darker());
//        colorPanelMap.get(2).setBackground(Color.ORANGE.brighter());
//    }
//
//    private void bluePanelBright() {
//        colorPanelMap.get(0).setBackground(Color.GREEN.darker());
//        colorPanelMap.get(3).setBackground(Color.BLUE.brighter());
//        colorPanelMap.get(1).setBackground(Color.RED.darker());
//        colorPanelMap.get(2).setBackground(Color.ORANGE.darker());
//    }
//
//    private void resetBoard() {
//        colorPanelMap.get(3).setBackground(Color.BLUE.darker());
//        colorPanelMap.get(1).setBackground(Color.RED.darker());
//        colorPanelMap.get(2).setBackground(Color.ORANGE.darker());
//        colorPanelMap.get(0).setBackground(Color.GREEN.darker());
//    }

    private class ColorPanelListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent evt) {
            ColorPanel colorPanel = (ColorPanel) evt.getSource();
            colorPanel.brighter();
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            ColorPanel colorPanel = (ColorPanel) evt.getSource();
            colorPanel.restore();
            int colorPanelId = colorPanel.getColorId();
            if (simianChoice.size() < 4) {
                simianChoice.add(colorPanelId);
                turn();
            }
            else {
                playerChoice.add(colorPanelId);
            }
            smallWins();
        }
    }
}