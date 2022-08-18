package com.simiansays.model;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private Player player;
    private Map<String,Player> winsMap;

    @Before
    public void setUp() {
        board = Board.getInstance();
        player = new Player("jrm", board);
        winsMap = new TreeMap<>();
    }

    @Test
    public void update_shouldBeTrue_whenMapIsEmpty() {
        assertTrue(winsMap.isEmpty());
    }

    @Test
    public void update_shouldBeTrue_whenMapIsPopulated() {
        winsMap.put(player.getInitials(), player);
        assertEquals(1, winsMap.size());
    }
}