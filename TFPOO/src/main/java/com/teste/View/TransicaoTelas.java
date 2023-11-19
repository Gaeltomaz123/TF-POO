package com.teste.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransicaoTelas extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;

    public TransicaoTelas() {
        ImageIcon icon = new ImageIcon("TFPOO\\src\\main\\java\\com\\teste\\Images\\TremBase.png");
        setIconImage(icon.getImage());

        setTitle("Gerenciador de Trens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        cards = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        CriarTrem criarTrem = new CriarTrem();
        EditarTrem editarTrem = new EditarTrem();
        ListarTrem listarTrem = new ListarTrem();

        cards.add(criarTrem, "CriarTrem");
        cards.add(editarTrem, "EditarTrem");
        cards.add(listarTrem, "ListarTrem");

        getContentPane().add(cards, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        Color menuTextColor = Color.WHITE;
        UIManager.put("Menu.foreground", menuTextColor);
        UIManager.put("Menu.selectionForeground", Color.WHITE);
        UIManager.put("MenuItem.background", new Color(74, 73, 73));
        UIManager.put("MenuItem.foreground", menuTextColor);
        UIManager.put("MenuItem.selectionBackground", Color.LIGHT_GRAY);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);

        menuBar.setBackground(new Color(74, 73, 73));

        menuBar.setPreferredSize(new Dimension(100, 40)); 

        JMenuItem criarTremMenuItem = new JMenuItem("Criar trem");
        criarTremMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "CriarTrem");
            }
        });

        JMenuItem editarTremMenuItem = new JMenuItem("Editar trens");
        editarTremMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "EditarTrem");
            }
        });

        JMenuItem listarTremMenuItem = new JMenuItem("Listar trens");
        listarTremMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "ListarTrem");
            }
        });

        menuBar.add(Box.createHorizontalStrut(110));
        menuBar.add(criarTremMenuItem);
        menuBar.add(Box.createHorizontalStrut(110));
        menuBar.add(editarTremMenuItem);
        menuBar.add(Box.createHorizontalStrut(110));
        menuBar.add(listarTremMenuItem);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TransicaoTelas();
            }
        });
    }
}
