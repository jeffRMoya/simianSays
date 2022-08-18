package com.simiansays.model;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

class ColorPanel extends JPanel {
    private static final Map<Color, Integer> colorIdMap = Map.of(
            Color.GREEN.darker(), 0,
            Color.RED.darker(), 1,
            Color.ORANGE.darker(), 2,
            Color.BLUE.darker(), 3);

    private final Color color;

    public ColorPanel(Color color, int x, int y, int width, int height) {
        this.color = color.darker();
        setBackground(this.color);
        setBounds(x, y, width, height);
    }

    public void brighter() {
        setBackground(color.brighter());
        repaint();
    }

    public void restore() {
        setBackground(color);
    }

    public int getColorId() {
        return colorIdMap.get(color);
    }
}