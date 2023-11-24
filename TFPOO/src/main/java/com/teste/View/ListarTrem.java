package com.teste.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.teste.Model.Carro;
import com.teste.Model.Composicao;
import com.teste.Model.Locomotiva;
import com.teste.Model.Vagao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ListarTrem extends JPanel {
    private int trensDeletados = 0; // Variável para contar os trens deletados

    private ArrayList<Locomotiva> arrayLocomotivas = new ArrayList<Locomotiva>();
    private ArrayList<Vagao> arrayVagao = new ArrayList<Vagao>();
    private ArrayList<Composicao> arrayComposicao = new ArrayList<Composicao>();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel contentPanel = new JPanel(new GridBagLayout());

    public ListarTrem() {
        String locomotivas = "TFPOO/src/main/java/com/teste/Model/Locomotivas.csv"; 
        String vagoes = "TFPOO/src/main/java/com/teste/Model/Vagoes.csv";  

        lerLinhas(locomotivas);
        lerLinhas(vagoes);
        lerComposicoes();

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

        addButtonSave(contentPanel, gbc);

        JScrollPane scrollPane = new JScrollPane(contentPanel); // JScrollPane para o conteúdo
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Desabilita a barra
                                                                                         // horizontal

        add(scrollPane, BorderLayout.CENTER); // Adiciona o JScrollPane ao painel principal
    }

    private void addButtonSave(JPanel contentPanel, GridBagConstraints gbc) {
        JPanel innerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerPanel.setPreferredSize(new Dimension(150, 30));
        innerPanel.setMaximumSize(new Dimension(150, 25));
        innerPanel.setMinimumSize(new Dimension(150, 25));
        innerPanel.setBackground(new Color(38, 105, 21));

        JButton labelsave = new JButton("Salvar");
        labelsave.setForeground(Color.WHITE);
        labelsave.setBackground(new Color(38, 105, 21));
        labelsave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelsave.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                String locomotivas = "TFPOO/src/main/java/com/teste/Model/Locomotivas.csv";
                String vagoes = "TFPOO/src/main/java/com/teste/Model/Vagoes.csv";
                String composicoes = "TFPOO/src/main/java/com/teste/Model/Composicoes.csv";

                apagarLinhas(locomotivas);
                apagarLinhas(vagoes);
                apagarLinhas(composicoes);

                escreverLinhas(locomotivas);
                escreverLinhas(vagoes);
                escreverComposicao();
            }
    });
        innerPanel.add(labelsave);
        contentPanel.add(innerPanel, gbc);
        gbc.gridy++; 
    }

    public void escreverComposicao() {
        String composicoes = "TFPOO/src/main/java/com/teste/Model/Composicoes.csv";
        
        try { 
            BufferedWriter escritor = new BufferedWriter(new FileWriter(composicoes));
                for(int i=0; i<arrayComposicao.size(); i++) {
                    escritor.write("T" + i);
                    for(int j=0; j<arrayComposicao.get(i).getQtdLocomotivas(); j++){
                        escritor.write(", L" + j);
                    }
                    for(int f=0; f<arrayComposicao.get(i).getQtdVagao(); f++){
                        escritor.write(", V" + f);
                    }
                    escritor.newLine();
                }
                escritor.flush();
                escritor.close();
                } catch (IOException a) {
                    a.printStackTrace();
                } 

    }

    public void lerComposicoes() {
        String composicoes = "TFPOO/src/main/java/com/teste/Model/Composicoes.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(composicoes));
            int count = 0;
            while((line = reader.readLine()) != null) {
                ArrayList<Carro> carro = new ArrayList<Carro>();
                Composicao composicao = new Composicao(count, carro);
                for(int i=0; i<line.length(); i++){
                    int countL = 0;
                    int countV = 0;
                    if(line.charAt(i) == 'L') {
                        carro.add(arrayLocomotivas.get(countL));
                        countL ++;
                    }
                    if(line.charAt(i) == 'V') {
                        carro.add(arrayVagao.get(countV));
                        countV ++;
                    }
                }
                count++;
                arrayComposicao.add(composicao);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void lerLinhas(String caminho) {
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(caminho));
            while((line = reader.readLine()) != null) {
                if(caminho == "TFPOO/src/main/java/com/teste/Model/Locomotivas.csv") {
                    for(int i=0; i<line.lines().count(); i++) {
                        arrayLocomotivas.add(new Locomotiva(i, 1000, 10, null));
                    }
                }
                if(caminho == "TFPOO/src/main/java/com/teste/Model/Vagoes.csv") {
                    for(int i=0; i<line.lines().count(); i++) {
                        arrayVagao.add(new Vagao(i, 200, null));
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void escreverLinhas(String caminho) {
        try { 
                // Abre o escritor para adicionar dados ao arquivo
                BufferedWriter escritor = new BufferedWriter(new FileWriter(caminho));
                if(caminho == "TFPOO/src/main/java/com/teste/Model/Locomotivas.csv") {
                    for(int i=0; i<arrayLocomotivas.size(); i++) {
                    escritor.write("L" + i);
                    escritor.newLine();
                }
                
                }
                if(caminho == "TFPOO/src/main/java/com/teste/Model/Vagoes.csv") {
                    for(int i=0; i<arrayVagao.size(); i++) {
                    escritor.write("V" + i);
                    escritor.newLine();
                }
                }
                escritor.flush();
                escritor.close();
                } catch (IOException a) {
                    a.printStackTrace();
                }  
    }

    public void apagarLinhas(String caminho) {
        BufferedReader reader = null;
        BufferedWriter escritor = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(caminho));
            escritor = new BufferedWriter(new FileWriter(caminho));
            while((line = reader.readLine()) != null) {
                escritor.write("");
                escritor.newLine();
            } 
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addLine() {
        addLine(contentPanel, gbc, arrayComposicao.size()-1);
    }
    public void editLine(int posicao) {
        Component[] a = contentPanel.getComponents();
        JPanel b = (JPanel)a[posicao];
        JPanel inner = (JPanel)b.getComponent(0);
        Component[] componentes = inner.getComponents();
        JLabel vagoes = (JLabel)componentes[3];
        vagoes.setText("Vagões: " + arrayComposicao.get(posicao).getQtdVagao());
        JLabel locomotivas = (JLabel)componentes[5];
        locomotivas.setText("Locomotivas: " + arrayComposicao.get(posicao).getQtdLocomotivas());
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

        ImageIcon lixeiraIcon = new ImageIcon("TFPOO/src/main/java/com/teste/Images/lixo1.png");
        JLabel labelLixeira = new JLabel(lixeiraIcon);

        labelLixeira.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Composicao compoiscao = arrayComposicao.get(i);
                System.out.println(compoiscao.toString());
                for (int i = 0; i < compoiscao.getQtdLocomotivas(); i++) {
                    arrayLocomotivas.add(compoiscao.getLocomotiva(i));
                }
                for (int i = 0; i < compoiscao.getQtdVagao(); i++) {
                    arrayVagao.add(compoiscao.getVagao(i));
                }
                arrayComposicao.remove(compoiscao);
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
        innerPanel.add(Box.createRigidArea(new Dimension(200, 0))); // Espaçamento entre os labels
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

    public ArrayList<Vagao>getArrayVagao(){
        return arrayVagao;
    }

    public int getQtdLocomotivas(){
        return arrayLocomotivas.size();
    }
    public int getQtdVagoes() {
        return arrayVagao.size();
    }
}
