package com.teste.View;

import javax.swing.*;
import java.awt.*;

public class CriarTrem extends JPanel {
    public CriarTrem() {
        setBackground(new Color(63, 55, 55));
        setPreferredSize(new Dimension(400, 575));
        setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon("TestesPOO\\teste\\src\\main\\java\\com\\teste\\Images\\TremIcon.png");
        JLabel labelImagem = new JLabel(icon);
        labelImagem.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        add(labelImagem, gbc);

        gbc.gridy++;

        JLabel labelID = new JLabel("Digite um ID:");
        labelID.setForeground(Color.white);
        add(labelID, gbc);

        gbc.gridy++;
        JTextField textFieldID = new JTextField(18);
        textFieldID.setPreferredSize(new Dimension(200, 25));
        textFieldID.setForeground(Color.BLACK);
        add(textFieldID, gbc);

        gbc.gridy++;

        JButton button1 = new JButton("Criar trem");

        textFieldID.setPreferredSize(new Dimension(200, 25));
        button1.setPreferredSize(new Dimension(200, 25));

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);

        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.setFont(font);
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color(99, 98, 98));
        gbc.gridy++;
        add(button1, gbc);
    }
}
