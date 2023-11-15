package com.tfpoo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Font;
import java.awt.GridLayout;

public class Add {
    String[] labels = {"Name: ", "Fax: ", "Email: ", "Address: "};
    int numPairs = labels.length;
    JButton clean = new JButton("Limpar");
    JButton save  = new JButton("Salvar");
    JPanel real = new JPanel();
    JPanel buttons = new JPanel();
    JPanel p = new JPanel(new SpringLayout());
    JLabel title = new JLabel("Criar Trem");

    public Add() {
        //Create and populate the panel.
        
        for (int i = 0; i < numPairs; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            JTextField textField = new JTextField(10);
            l.setLabelFor(textField);
            p.add(textField);
        }
        

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(p,
                                        4, 2, //rows, cols
                                        6, 6,        //initX, initY
                                        50, 15);       //xPad, yPad

        buttons.add(save);
        buttons.add(clean);
        real.setLayout(new GridLayout(3, 1));
        real.add(title);
        real.add(p);
        real.add(buttons);
    }


}
