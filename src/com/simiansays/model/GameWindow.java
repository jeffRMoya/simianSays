package com.simiansays.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;


public class GameWindow implements MouseListener {


    // GAME WINDOW CONSTRUCTOR
    public JFrame window;
    public JPanel redPanel, bluePanel, orangePanel, greenPanel,
            blackLineBetweenButtons, board;
    public JButton startButton;
    public JLabel timeLabel, roundLabel, dealerLabel;
    public Timer timer;
    boolean timerOn;
    public int second = 0;
    Collection<Integer> machineChoice = new ArrayList<>();
    Collection<Integer> playerChoice = new ArrayList<>();

    public GameWindow() {
        // BOARD
        board = new JPanel();
        board.setBackground(Color.BLACK);
        board.setBounds(0, 0, 1000, 40);

        // BOARD START BUTTON
        startButton = new JButton("START");
        board.add(startButton);
        startButton.addActionListener(e -> {
            System.out.println("START BUTTON HAS BEEN CLICKED");
            timer.start();
            machineNextTurn();
            startButton.setEnabled(false);
            turn();
        });

        // BOARD TIMER DISPLAY
        // time label
        timeLabel = new JLabel("TIME: ");
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        board.add(timeLabel);
        simpleTimer();
        // round label
        roundLabel = new JLabel("ROUND: "+ playerChoice.size()+1 +", ");
        roundLabel.setForeground(Color.WHITE);
        roundLabel.setFont(new Font("Arial", Font.BOLD, 24));
        board.add(roundLabel);
        // dealer label
        dealerLabel = new JLabel("TURN: ");
        dealerLabel.setForeground(Color.WHITE);
        dealerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        board.add(dealerLabel);

        // GREEN PANEL (top left)
        greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN.darker());
        greenPanel.setBounds(0, 45, 495, 450);

        // RED PANEL (top right)
        redPanel = new JPanel();
        redPanel.setBackground(Color.RED.darker());
        redPanel.setBounds(500, 45, 500, 450);

        // ORANGE PANEL (bottom left)
        orangePanel = new JPanel();
        orangePanel.setBackground(Color.ORANGE.darker());
        orangePanel.setBounds(0, 500, 495, 495);

        // BLUE PANEL (bottom right)
        bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE.darker());
        bluePanel.setBounds(500, 500, 500, 495);

        // BLACK LINES (BLACK BACKGROUND TO BE SUPERIMPOSED ON)
        blackLineBetweenButtons = new JPanel();
        blackLineBetweenButtons.setBackground(Color.BLACK);
        blackLineBetweenButtons.setBounds(0, 0, 1000, 1000);

        window = new JFrame("Simian Says");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setSize(1000, 1000);
        window.addMouseListener(this);
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
    public void simpleTimer() {
        timer = new Timer(1000, e -> {
            second++;
            timeLabel.setText("TIME: " + second + ", ");
            timerOn = true;
        });
    }

    // TURN METHOD
    public void turn() {
        int i = machineChoice.size(), j = playerChoice.size();
        if (machineChoice.isEmpty() && playerChoice.isEmpty()) {
            machineNextTurn();
            dealerLabel.setText(", TURN: Simians Turn!");
        } else if (i>j) {
            resetBoard();
            dealerLabel.setText(", TURN: Your turn!");
        } else if (i==j) {
            machineNextTurn();
        }
    }

    // MACHINE CHOICES
    public void machineNextTurn() {
        Random ran = new Random();
        int randomValue = ran.nextInt(5);
        System.out.println("RANDOM VALUE=" +randomValue);
        if (randomValue == 1) {
            greenPanelBright();
            machineChoice.add(1);
            System.out.println("MACHINE CLICKED GREEN SQUARE. \n 1 added to machineChoice. \n" + machineChoice);
        } else if (randomValue == 2) {
            redPanelBright();
            machineChoice.add(2);
            System.out.println("MACHINE CLICKED RED SQUARE. \n 2 added to machineChoice. \n" + machineChoice);
        } else if (randomValue == 3) {
            orangePanelBright();
            machineChoice.add(3);
            System.out.println("MACHINE CLICKED ORANGE SQUARE. \n 3 added to machineChoice. \n" + machineChoice);
        } else if (randomValue >= 4) {
            bluePanelBright();
            machineChoice.add(4);
            System.out.println("MACHINE CLICKED BLUE SQUARE. \n 4 added to machineChoice. \n" + machineChoice);
        }
    }

    // PANELS SELECTED
    public void greenPanelBright() {
        bluePanel.setBackground(Color.BLUE.darker());
        redPanel.setBackground(Color.RED.darker());
        orangePanel.setBackground(Color.ORANGE.darker());
        greenPanel.setBackground(Color.GREEN.brighter());
    }

    public void redPanelBright() {
        greenPanel.setBackground(Color.GREEN.darker());
        bluePanel.setBackground(Color.BLUE.darker());
        orangePanel.setBackground(Color.ORANGE.darker());
        redPanel.setBackground(Color.RED.brighter());
    }

    public void orangePanelBright() {
        greenPanel.setBackground(Color.GREEN.darker());
        bluePanel.setBackground(Color.BLUE.darker());
        redPanel.setBackground(Color.RED.darker());
        orangePanel.setBackground(Color.ORANGE.brighter());
    }

    public void bluePanelBright() {
        greenPanel.setBackground(Color.GREEN.darker());
        bluePanel.setBackground(Color.BLUE.brighter());
        redPanel.setBackground(Color.RED.darker());
        orangePanel.setBackground(Color.ORANGE.darker());
    }

    public void resetBoard() {
        bluePanel.setBackground(Color.BLUE.darker());
        redPanel.setBackground(Color.RED.darker());
        orangePanel.setBackground(Color.ORANGE.darker());
        greenPanel.setBackground(Color.GREEN.darker());
    }

    // MOUSE LISTENER CONTRACT METHODS
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX(), y = e.getY();

        if (x > 0 && x < 500 && y > 0 && y < 500) {
            greenPanelBright();
            playerChoice.add(1);
            System.out.println("GREEN SQUARE CLICKED. playerChoice=" + playerChoice);

        } else if (x > 500 && x < 1000 && y > 0 && y < 500) {
            redPanelBright();
            playerChoice.add(2);
            System.out.println("RED SQUARE CLICKED. playerChoice=" + playerChoice);
        } else if (x > 0 && x < 500 && y > 500 && y < 1000) {
            orangePanelBright();
            playerChoice.add(3);
            System.out.println("YELLOW SQUARE CLICKED. playerChoice=" + playerChoice);
        } else if (x > 500 && x < 1000 && y > 500 && y < 1000) {
            bluePanelBright();
            playerChoice.add(4);
            System.out.println("BLUE SQUARE CLICKED. playerChoice=" + playerChoice);
        }
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