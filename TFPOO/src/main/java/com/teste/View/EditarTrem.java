package com.teste.View;

import javax.swing.*;
import java.awt.*;

public class EditarTrem extends JPanel {
    public EditarTrem() {
        setBackground(new Color(63, 55, 55));
        setPreferredSize(new Dimension(400, 575));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy++;

        JLabel labelID = new JLabel("Pesquise um ID:");
        labelID.setForeground(Color.white);
        add(labelID, gbc);

        gbc.gridy++;
        JTextField textFieldID = new JTextField(18);
        textFieldID.setPreferredSize(new Dimension(200, 25));
        textFieldID.setForeground(Color.BLACK);
        add(textFieldID, gbc);

        gbc.gridy++;

        JButton button1 = new JButton("Pesquisar");

        textFieldID.setPreferredSize(new Dimension(200, 25));
        button1.setPreferredSize(new Dimension(200, 25));

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);

        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setFont(font);
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(38, 105, 21));
        gbc.gridy++;
        add(button1, gbc);

        JButton button2 = new JButton("Adicionar locomotiva");
        button2.setPreferredSize(new Dimension(200, 35));
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.setFont(font);
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color(99, 98, 98));
        gbc.gridy++;
        add(button2, gbc);

        JButton button3 = new JButton("Adicionar vagão");
        button3.setPreferredSize(new Dimension(200, 35));
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.setFont(font);
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color(99, 98, 98));
        gbc.gridy++;
        add(button3, gbc);

        gbc.gridy++;
        JLabel labelDis = new JLabel("Disposição:");
        labelDis.setForeground(Color.white);
        add(labelDis, gbc);

        gbc.gridy++;
        JTextArea textAreaDis = new JTextArea(5, 90); // 5 linhas, 20 colunas inicialmente
        textAreaDis.setLineWrap(true);
        textAreaDis.setWrapStyleWord(true);
        textAreaDis.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaDis);
        scrollPane.setPreferredSize(new Dimension(200, 100)); // Tamanho do scroll
        add(scrollPane, gbc);
    }
}