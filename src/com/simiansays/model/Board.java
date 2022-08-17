package com.simiansays.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Board implements Serializable {
    private static final String dataFilePath = "data/board.dat";

    public static Board getInstance() {
        Board board = null;

        if(Files.exists(Path.of(dataFilePath))) {
            try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFilePath))) {
                board = (Board) in.readObject();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            board = new Board();
        }
        return board;
    }

    // Fields
    private final Map<String, Player> winsMap = new TreeMap<>();

    // CTORs
    private Board() {
    }

    // Methods
    public void show() {
        System.out.println("S C O R E B O A R D");
        if(winsMap.isEmpty()) {
            System.out.println("No one has played the coolest game ever yet.");
        }
        else {
            Collection<Player> players = winsMap.values();

            for(Player player : players) {
                System.out.println(player);
            }
        }

    }

    public void update(String initials) {
        Player player = null;
        if(winsMap.containsKey(initials)) {
            player = winsMap.get(initials);
        }
        else {
            player = new Player(initials, this);
            winsMap.put(initials, player);
        }

        saveBoard();
    }

    private void saveBoard() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            out.writeObject(this);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}