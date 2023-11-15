package com.tfpoo;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

public class Menu {
    private JPanel leftpane = new Add().real;
    private JPanel rightpane = new List().jpanel;
    JPanel jpanel = new JPanel();
    public Menu() {
        jpanel.add(leftpane);
        jpanel.add(rightpane);
    }
}
