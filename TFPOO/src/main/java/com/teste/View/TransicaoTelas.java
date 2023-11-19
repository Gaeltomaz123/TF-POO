package com.teste.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransicaoTelas extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;

    public TransicaoTelas() {
        ImageIcon icon = new ImageIcon("TestesPOO\\teste\\src\\main\\java\\com\\teste\\Images\\TremBase.png");
        setIconImage(icon.getImage());

        setTitle("Gerenciador de Trens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        // Crie um JPanel para conter os diferentes painéis
        cards = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        // Instancie os objetos das classes de painel
        CriarTrem criarTrem = new CriarTrem();
        EditarTrem editarTrem = new EditarTrem();
        ListarTrem listarTrem = new ListarTrem();

        // Adicione os painéis ao CardLayout com nomes de identificação
        cards.add(criarTrem, "CriarTrem");
        cards.add(editarTrem, "EditarTrem");
        cards.add(listarTrem, "ListarTrem");

        getContentPane().add(cards, BorderLayout.CENTER);

        // Crie um JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Defina a cor RGB para os itens do menu usando UIManager
        Color menuTextColor = Color.WHITE;
        UIManager.put("Menu.foreground", menuTextColor);
        UIManager.put("Menu.selectionForeground", Color.WHITE);
        UIManager.put("MenuItem.background", new Color(74, 73, 73));
        UIManager.put("MenuItem.foreground", menuTextColor);
        UIManager.put("MenuItem.selectionBackground", Color.LIGHT_GRAY);
        UIManager.put("MenuItem.selectionForeground", Color.WHITE);

        // Defina a cor RGB para a tela de fundo do menu
        menuBar.setBackground(new Color(74, 73, 73));

        // Defina o tamanho do JMenuBar
        menuBar.setPreferredSize(new Dimension(100, 40)); // Ajuste a largura e a altura conforme necessário

        // Crie os itens de menu para trocar entre as telas
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

        // Adicione os itens de menu à barra de menu
        menuBar.add(Box.createHorizontalStrut(110));
        menuBar.add(criarTremMenuItem);
        menuBar.add(Box.createHorizontalStrut(110));
        menuBar.add(editarTremMenuItem);
        menuBar.add(Box.createHorizontalStrut(110));
        menuBar.add(listarTremMenuItem);

        // Defina a barra de menu para a janela
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
