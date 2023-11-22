package com.teste.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.teste.Model.Carro;
import com.teste.Model.Composicao;
import com.teste.Model.Locomotiva;
import com.teste.Model.Vagao;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListarTrem extends JPanel {
    private int trensDeletados = 0; // Variável para contar os trens deletados

    private ArrayList<Locomotiva> arrayLocomotivas = new ArrayList<Locomotiva>();
    private ArrayList<Vagao> arrayVagao = new ArrayList<Vagao>();
    private ArrayList<Composicao> arrayComposicao = new ArrayList<Composicao>();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel contentPanel = new JPanel(new GridBagLayout());

    public ListarTrem() {
        for (int i = 0; i < 6; i++) {
            arrayVagao.add(new Vagao(i, 200, null));
        }
        for (int i = 0; i < 6; i++) {
            arrayLocomotivas.add(new Locomotiva(i, 1000, 10, null));
        }

        setLayout(new BorderLayout());
        //JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(63, 55, 55));
//        GridBagConstraints gbc = new GridBagConstraints();
         gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        for (int i = 0; i < arrayComposicao.size(); i++) {
            addLine(contentPanel, gbc, i);
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel); // JScrollPane para o conteúdo
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Desabilita a barra
                                                                                         // horizontal

        add(scrollPane, BorderLayout.CENTER); // Adiciona o JScrollPane ao painel principal
    }
    public void addLine() {
        addLine(contentPanel, gbc, arrayComposicao.size()-1);
    }

    private void addLine(JPanel contentPanel, GridBagConstraints gbc, int i) {
        JPanel containerTrem = new JPanel(new FlowLayout(FlowLayout.LEADING));
        containerTrem.setMinimumSize(new Dimension(900, 45));
        containerTrem.setPreferredSize(new Dimension(900, 45));
        containerTrem.setBorder(new EmptyBorder(5, 10, 5, 10));
        containerTrem.setBackground(new Color(63, 55, 55));

        // Cria um novo JPanel para conter os componentes
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        innerPanel.setPreferredSize(new Dimension(800, 45));
        innerPanel.setMaximumSize(new Dimension(800, 40));
        innerPanel.setMinimumSize(new Dimension(800, 40));

        // Valores do trem (simulação)
        int idTrem = arrayComposicao.get(i).getidComposicao();
        int numVagoes = arrayComposicao.get(i).getQtdVagao(); 
        int numLocomotivas = arrayComposicao.get(i).getQtdLocomotivas(); 

        // Cria os componentes para o trem
        JLabel labelID = new JLabel("ID Trem: " + idTrem);
        JLabel labelVagoes = new JLabel("Vagões: " + numVagoes);
        JLabel labelLocomotivas = new JLabel("Locomotivas: " + numLocomotivas);

        ImageIcon lixeiraIcon = new ImageIcon("TFPOO/src/main/java/com/teste/Images/IconLixeira.png");
        JLabel labelLixeira = new JLabel(lixeiraIcon);

        labelLixeira.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                containerTrem.remove(innerPanel); // Oculta o container do trem
                trensDeletados++; // Incrementa o contador de trens deletados
                contentPanel.remove(containerTrem); // Remove o containerTrem do contentPanel
                contentPanel.revalidate(); // Revalida o layout do contentPanel
                revalidate(); // Atualiza o layout do ListarTrem
                repaint(); // Redesenha o painel
            }
        });

        innerPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        innerPanel.add(labelID);
        innerPanel.add(Box.createRigidArea(new Dimension(120, 0))); // Espaçamento entre os labels
        innerPanel.add(labelVagoes);
        innerPanel.add(Box.createRigidArea(new Dimension(120, 0))); // Espaçamento entre os labels
        innerPanel.add(labelLocomotivas);
        innerPanel.add(Box.createRigidArea(new Dimension(120, 0))); // Espaçamento entre os labels
        innerPanel.add(labelLixeira);

        containerTrem.add(innerPanel);
        contentPanel.add(containerTrem, gbc); // Adiciona o container do trem ao painel de conteúdo
        gbc.gridy++; // Incrementa a coordenada Y para o próximo trem
    }

    @Override
    public void repaint() {
        // TODO Auto-generated method stub
        super.repaint();        
        
    }

    public int getTrensDeletados() {
        return trensDeletados;
    }

    // public void setArrayComposicao(Object object) {
        
    // }

    public ArrayList<Composicao>getArrayComposicao(){
        return arrayComposicao;
    }

    public ArrayList<Locomotiva>getArrayLocomotiva(){
        return arrayLocomotivas;
    }

    
}
