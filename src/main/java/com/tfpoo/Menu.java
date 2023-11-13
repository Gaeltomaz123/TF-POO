package com.tfpoo;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {
    public Menu() {
        super();
        JPanel jpanel = new JPanel();
        this.setSize(900, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(jpanel);
        this.setLocationRelativeTo(null);
    }
}
