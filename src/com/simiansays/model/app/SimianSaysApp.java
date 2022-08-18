package com.simiansays.model.app;

import com.simiansays.model.Board;
import com.simiansays.model.HomeWindow;
import javax.swing.*;
import java.util.Scanner;

public class SimianSaysApp {
    private final Board board = Board.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        welcome();
        showBoard();
        String initials = promptForInitials();
        updateBoard(initials);
        showBoard();

        SwingUtilities.invokeLater(() -> {
            HomeWindow homeWindow = new HomeWindow();
            homeWindow.show();
        });
    }

    private void updateBoard(String initials) {
        board.update(initials);
    }

    private String promptForInitials() {
        String initials = null;
        boolean validInput = false;
        while(!validInput) {
            System.out.println("Please enter your initials: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if(input.matches("^[A-Z]{2,3}$")) {
                initials = input;
                validInput = true;
            }
        }
        return initials;
    }

    private void showBoard() {
        System.out.println();
        board.show();
        System.out.println();
    }

    private void welcome() {
        System.out.println();
        System.out.println("W E L C O M E  T O  S I M I A N  S A Y S");
        System.out.println();
    }
}