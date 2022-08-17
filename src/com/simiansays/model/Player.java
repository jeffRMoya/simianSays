package com.simiansays.model;

import java.io.Serializable;

class Player implements Serializable {
    // Fields
    private Board board;
    private String initials;
    private int wins;

    // CTORs
    public Player(String initials, Board board) {
        setInitials(initials);
        this.board = board;
    }

    // Business Methods
    public void win() {
        wins++;
        board.update(getInitials());
    }

    // Accessor Methods

    public int getWins() {
        return wins;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public String toString() {
        return String.format("%s: %s; Wins: %s",
                getClass().getSimpleName(), getInitials(), getWins());
    }
}