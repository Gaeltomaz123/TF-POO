package com.teste.Model;

import java.util.ArrayList;

public class Composicao {
    private int idComposicao;
    private ArrayList<Carro> arrayCarro;

    public Composicao(int idComposicao, ArrayList<Carro> arrayCarro) {
        this.idComposicao = idComposicao;
        this.arrayCarro = arrayCarro;
    }

    public int getidComposicao() {
        return idComposicao;
    }

    public int getQtdLocomotivas() {
        int count = 0;
        for(Carro a : arrayCarro) {
            if(a instanceof Locomotiva) {
                count++;
            }
        }
        return count;
    }

    public Locomotiva getLocomotiva(int posicao) {
        ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
        for(Carro a : arrayCarro){
            if(a instanceof Locomotiva) {
                locomotivas.add((Locomotiva) a);
            }
        }
        return locomotivas.get(posicao);
    }

    public int getQtdVagao() {
        int count = 0;
        for(Carro a : arrayCarro) {
            if(a instanceof Vagao) {
                count++;
            }
        }
        return count;
    }

    public Vagao getVagao(int posicao) {
        ArrayList<Vagao> vagoes = new ArrayList<Vagao>();
        for(Carro a : arrayCarro){
            if(a instanceof Vagao) {
                vagoes.add((Vagao) a);
            }
        }
        return vagoes.get(posicao);
    }

    public boolean engataLocomotiva(Locomotiva locomotiva) {
        boolean estado = false;
        arrayCarro.add(locomotiva);
        double reducao = 0.10;
        double capacidadeTotal = locomotiva.getPesoMaximo();
        for (int i = 0; i < getQtdLocomotivas(); i++) {
            Locomotiva l = getLocomotiva(i);
            capacidadeTotal += l.getPesoMaximo() * reducao;
            l.setPesoMaximo(capacidadeTotal);
        }
        System.out.println("Nova capacidade total: " + capacidadeTotal);
        return estado;
    }

    public boolean engataVagao(Vagao vagao) {
        boolean estado = false;
        ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
        for(Carro a : arrayCarro){
            if(a instanceof Locomotiva) {
                locomotivas.add((Locomotiva) a);
            }
        }
        for (Locomotiva locomotiva : locomotivas) {
            if (locomotiva.getPesoMaximo() > 0) {
                estado = true;
                double capacidadeAtual = locomotiva.getPesoMaximo();
                double novaCapacidade = capacidadeAtual - 400;
                if (novaCapacidade < 400) {
                    novaCapacidade = 0;
                }
                novaCapacidade = Math.ceil(novaCapacidade * 10) / 10;
                locomotiva.setPesoMaximo(novaCapacidade);
                System.out.println(
                        "Locomotiva ID: " + locomotiva.getIdLocomotiva() + ", Capacidade Atual: " + novaCapacidade);
            } else {
                estado = false;
                System.out.println("O peso foi excedido!");
            }
        }
        if (estado == true) {
            arrayCarro.add(vagao);
        }
        return estado;
    }

    public boolean desengataLocomotiva(Locomotiva locomotiva) {
        boolean estado = false;
        arrayCarro.remove(locomotiva);
        return estado;
    }

    public boolean desengataVagao(Vagao vagao) {
        boolean estado = false;
        arrayCarro.remove(vagao);
        return estado;
    }

    public void toString(ArrayList<Composicao> composicao, int posicao) {
        System.out.println("Id do Trem:" + composicao.get(posicao).getidComposicao()
                + "\nQuantidade Locomotivas: " + composicao.get(posicao).getQtdLocomotivas()
                + "\nLocomotivas: ");
        for (int i = 0; i < getQtdLocomotivas(); i++) {
            ArrayList<Locomotiva> locomotivas = new ArrayList<Locomotiva>();
            for(Carro a : arrayCarro){
                if(a instanceof Locomotiva) {
                    locomotivas.add((Locomotiva) a);
                }
            }
            System.out.println("Id do Vagao: " + locomotivas.get(i).getIdLocomotiva());
        }
        System.out.println("\nQuantidade Vagoes: " + composicao.get(posicao).getQtdVagao()
                + "\nVagoes: ");
        for (int i = 0; i < getQtdVagao(); i++) {
            ArrayList<Vagao> vagoes = new ArrayList<Vagao>();
            for(Carro a : arrayCarro){
                if(a instanceof Vagao) {
                    vagoes.add((Vagao) a);
                }
            }
            System.out.println("Id do Vagao: " + vagoes.get(i).getIdVagao());
        }
        ;
        System.out.println("..........................");
    }

    public String toString2(ArrayList<Composicao> composicao, int posicao) {
        StringBuilder result = new StringBuilder();
    
        // Recuperar a composição na posição específica
        Composicao comp = composicao.get(posicao);
    
        // Adicionar a representação das locomotivas
        for (int i = 0; i < comp.getQtdLocomotivas(); i++) {
            result.append("L").append(i + 1);
            if (i != comp.getQtdLocomotivas() - 1 || comp.getQtdVagao() > 0) {
                result.append(",");
            }
        }
    
        // Adicionar a representação dos vagões
        for (int i = 0; i < comp.getQtdVagao(); i++) {
            result.append("V").append(i + 1);
            if (i != comp.getQtdVagao() - 1) {
                result.append(",");
            }
        }
    
        return result.toString();
    }
    
}
