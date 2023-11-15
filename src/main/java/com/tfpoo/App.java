package com.tfpoo;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main( String[] args ) {
        JFrame jframe = new JFrame("Trabalho Final");
        jframe.add(new Menu().jpanel);
        jframe.pack();
        jframe.setSize(900, 600);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
    }
}
