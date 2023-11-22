package com.teste.View;

import javax.swing.*;

import com.teste.Model.Carro;
import com.teste.Model.Composicao;
import com.teste.Model.Locomotiva;
import com.teste.Model.Vagao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TransicaoTelas extends JFrame {
    private JPanel cards;
    private CardLayout cardLayout;

    ArrayList<Locomotiva> arrayLocomotivas = new ArrayList<Locomotiva>();
    ArrayList<Vagao> arrayVagao = new ArrayList<Vagao>();
    ArrayList<Composicao> arrayComposicao = new ArrayList<Composicao>();

    public TransicaoTelas() {
        condicoesIniciais();

        ImageIcon icon = new ImageIcon("TFPOO/src/main/java/com/teste/Images/TremBase.png");
        setIconImage(icon.getImage());

        setTitle("Gerenciador de Trens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        cards = new JPanel(new FlowLayout(FlowLayout.CENTER));
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        ListarTrem listarTrem = new ListarTrem();
        CriarTrem criarTrem = new CriarTrem(listarTrem);
        EditarTrem editarTrem = new EditarTrem(listarTrem);

        criarTrem.setArrayComposicao(listarTrem.getArrayComposicao());
        editarTrem.setArrayComposicao(listarTrem.getArrayComposicao());
        criarTrem.setArrayLocomotivas(listarTrem.getArrayLocomotiva());
        editarTrem.setArrayLocomotivas(listarTrem.getArrayLocomotiva());

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
                // criarTrem.setArrayComposicao(arrayComposicao);
            }
        });

        JMenuItem editarTremMenuItem = new JMenuItem("Editar trens");
        editarTremMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "EditarTrem");
                // editarTrem.setArrayComposicao(arrayComposicao);
            }
        });

        JMenuItem listarTremMenuItem = new JMenuItem("Listar trens");
        listarTremMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "ListarTrem");
                revalidate(); // Atualiza o layout do ListarTrem
                repaint(); // Redesenha o painel
                // listarTrem.setArrayComposicao(arrayComposicao);
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

    private void condicoesIniciais(){
        for (int i = 0; i < 6; i++) {
            arrayVagao.add(new Vagao(i, 200, null));
        }
        for (int i = 0; i < 6; i++) {
            arrayLocomotivas.add(new Locomotiva(i, 1000, 10, null));
        }
        for (int i = 0; i < 5; i++) {
            ArrayList<Carro> carro = new ArrayList<Carro>();
            carro.add(arrayLocomotivas.get(i));
            arrayComposicao.add(new Composicao(i, carro));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TransicaoTelas();
            }
        });
    }
}
