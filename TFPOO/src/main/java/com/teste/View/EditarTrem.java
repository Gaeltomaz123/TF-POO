package com.teste.View;

import javax.swing.*;

import com.teste.Model.Composicao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

public class EditarTrem extends JPanel {
    int idTrem = 0; 
    public EditarTrem(ListarTrem listarTrem) {
        

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

        JButton botaoPesquisar = new JButton("Pesquisar");

        textFieldID.setPreferredSize(new Dimension(200, 25));
        botaoPesquisar.setPreferredSize(new Dimension(200, 25));

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);

        botaoPesquisar.setBorderPainted(false);
        botaoPesquisar.setFocusPainted(false);
        botaoPesquisar.setFont(font);
        botaoPesquisar.setForeground(Color.WHITE);
        botaoPesquisar.setBackground(new Color(38, 105, 21));
        gbc.gridy++;
        add(botaoPesquisar, gbc);

        JButton botaoAdicionarLocomotiva = new JButton("Adicionar locomotiva");
        botaoAdicionarLocomotiva.setPreferredSize(new Dimension(200, 35));
        botaoAdicionarLocomotiva.setBorderPainted(false);
        botaoAdicionarLocomotiva.setFocusPainted(false);
        botaoAdicionarLocomotiva.setFont(font);
        botaoAdicionarLocomotiva.setForeground(Color.WHITE);
        botaoAdicionarLocomotiva.setBackground(new Color(99, 98, 98));
        gbc.gridy++;
        add(botaoAdicionarLocomotiva, gbc);

        JButton botatoAdicionarVagao = new JButton("Adicionar vagão");
        botatoAdicionarVagao.setPreferredSize(new Dimension(200, 35));
        botatoAdicionarVagao.setBorderPainted(false);
        botatoAdicionarVagao.setFocusPainted(false);
        botatoAdicionarVagao.setFont(font);
        botatoAdicionarVagao.setForeground(Color.WHITE);
        botatoAdicionarVagao.setBackground(new Color(99, 98, 98));
        gbc.gridy++;
        add(botatoAdicionarVagao, gbc);

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

        botaoPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean existeNoArray = false;
                int posicao = -1;
                // System.out.println(listarTrem.getArrayComposicao().size());
                idTrem = Integer.parseInt(textFieldID.getText());
                for(int i = 0; i < listarTrem.getArrayComposicao().size(); i++){
                    if(listarTrem.getArrayComposicao().get(i).getidComposicao() == idTrem){
                        existeNoArray = true;
                        posicao = i;
                        //arrayComposicao.get(i).toString(arrayComposicao, i)
                    }else{
                        existeNoArray = false;
                    }
                }
                if(existeNoArray == false){
                    JOptionPane.showMessageDialog(labelID, "ERRO: Esse ID não está contido!");
                }else{
                    textAreaDis.setText(listarTrem.getArrayComposicao().get(posicao).toString2(listarTrem.getArrayComposicao(),posicao));
                    JOptionPane.showMessageDialog(labelID, "O id foi encontrado!");
                }
                //RODAR TODO O ARRAY E ACHAR O COM O ID DO LABEL 
            }
        });
        JButton botaoRemoverUltimo = new JButton("Remover último componente");
        botaoRemoverUltimo.setPreferredSize(new Dimension(200, 35));
        botaoRemoverUltimo.setBorderPainted(false);
        botaoRemoverUltimo.setFocusPainted(false);
        botaoRemoverUltimo.setFont(font);
        botaoRemoverUltimo.setForeground(Color.WHITE);
        botaoRemoverUltimo.setBackground(new Color(244, 24, 18));
        gbc.gridy++;
        add(botaoRemoverUltimo, gbc);
    }

    public void setArrayLocomotivas(Object object) {
        
    }

    public void setArrayComposicao(ArrayList<Composicao> arrayComposicao) {
    }
}