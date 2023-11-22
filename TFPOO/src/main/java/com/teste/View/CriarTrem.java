package com.teste.View;

import javax.swing.*;

import com.teste.Model.Carro;
import com.teste.Model.Composicao;
import com.teste.Model.Locomotiva;
import com.teste.Model.Vagao;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarTrem extends JPanel {
    ArrayList<Locomotiva> arrayLocomotivas = new ArrayList<Locomotiva>();
    ArrayList<Vagao> arrayVagao = new ArrayList<Vagao>();
    ArrayList<Composicao> arrayComposicao = new ArrayList<Composicao>();
    // private TransicaoTelas transicaoTelas = new TransicaoTelas();
    //ListarTrem listarTrem;
    public CriarTrem(ListarTrem listarTrem) {
        //this.listarTrem = listarTrem;
        setBackground(new Color(63, 55, 55));
        setPreferredSize(new Dimension(400, 575));
        setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon("TFPOO/src/main/java/com/teste/Images/TremIcon.png");
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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                
                
                //Pop up
                String id = textFieldID.getText();
                if (id.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(labelID, "SUCESSO! TREM CRIADO - ID: " + id);
                    ArrayList<Carro> carro = new ArrayList<Carro>();
                    carro.add(arrayLocomotivas.get(0));
                    arrayComposicao.add(new Composicao(Integer.parseInt(id), carro));
                    listarTrem.addLine();
                    arrayLocomotivas.remove(0);
                    System.out.println(carro);
                } else {
                    JOptionPane.showMessageDialog(labelID, "ERRO: Digite apenas números");
                }

            }
        });
        gbc.gridy++;
        add(button1, gbc);
    }
    public void setArrayComposicao(ArrayList<Composicao> novoArrayComposicao) {
        arrayComposicao = novoArrayComposicao;
    }

    public void setArrayLocomotivas(ArrayList<Locomotiva> novoArrayLocomotivas) {
        arrayLocomotivas = novoArrayLocomotivas;
    }

    // public void setArray(ArrayList<Composicao> novoArrayComposicao) {
    //     arrayComposicao = novoArrayComposicao;
    // }
}
