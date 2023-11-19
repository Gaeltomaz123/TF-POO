package com.teste.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarTrem extends JPanel {
    private int trensDeletados = 0; // Variável para contar os trens deletados
    private int quantidadeTrens = 20; // getQtdTrens;

    public ListarTrem() {
        setLayout(new BorderLayout()); // BorderLayout para o JScrollPane

        JPanel contentPanel = new JPanel(new GridBagLayout()); // Painel para o conteúdo com GridBagLayout
        contentPanel.setBackground(new Color(63, 55, 55));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NORTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Aqui você pode ter um loop para adicionar contêineres para cada trem
        for (int i = 1; i <= quantidadeTrens /* NUMERO DE TRENS */; i++) {
            JPanel containerTrem = new JPanel(new FlowLayout(FlowLayout.LEADING));
            containerTrem.setMinimumSize(new Dimension(900, 45));
            containerTrem.setPreferredSize(new Dimension(900, 45));
            containerTrem.setBorder(new EmptyBorder(5, 10, 5, 10));
            containerTrem.setBackground(new Color(63, 55, 55));

            // Cria um novo JPanel para conter os componentes
            JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
            innerPanel.setPreferredSize(new Dimension(800, 45)); // Define o tamanho para 900x30
            innerPanel.setMaximumSize(new Dimension(800, 40));
            innerPanel.setMinimumSize(new Dimension(800, 40));

            // Valores do trem (simulação)
            int idTrem = i;
            int numVagoes = 3; // Obtenha o número de vagões do trem do seu programa
            int numLocomotivas = 4; // Obtenha o número de locomotivas do trem do seu programa

            // Crie os componentes para o trem
            JLabel labelID = new JLabel("ID Trem: " + idTrem);
            JLabel labelVagoes = new JLabel("Vagões: " + numVagoes);
            JLabel labelLocomotivas = new JLabel("Locomotivas: " + numLocomotivas);

            // Crie a imagem da lixeira (simulação)
            ImageIcon lixeiraIcon = new ImageIcon(
                    "TestesPOO\\teste\\src\\main\\java\\com\\teste\\Images\\IconLixeira.png");
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
                    if (getTrensDeletados() >= quantidadeTrens) {
                        JLabel mensagem = new JLabel("Não há mais trens disponíveis");
                        mensagem.setHorizontalAlignment(JLabel.CENTER);
                        mensagem.setForeground(Color.RED);

                        Box horizontalBox = Box.createHorizontalBox();
                        horizontalBox.add(Box.createHorizontalGlue());
                        horizontalBox.add(mensagem);
                        horizontalBox.add(Box.createHorizontalGlue());

                        JPanel messagePanel = new JPanel();
                        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
                        messagePanel.add(Box.createVerticalGlue());
                        messagePanel.add(horizontalBox);
                        messagePanel.add(Box.createVerticalGlue());
                        messagePanel.setBackground(new Color(63, 55, 55));

                        contentPanel.add(messagePanel, gbc);
                        revalidate(); // Atualiza o layout do ListarTrem
                        repaint(); // Redesenha o painel
                    }
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

        JScrollPane scrollPane = new JScrollPane(contentPanel); // JScrollPane para o conteúdo
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Desabilita a barra
                                                                                         // horizontal

        add(scrollPane, BorderLayout.CENTER); // Adiciona o JScrollPane ao painel principal
    }

    public int getTrensDeletados() {
        return trensDeletados;
    }
}
