package com.teste.Model;

public class Locomotiva  extends Carro {
    private double pesoMaximo;
    private int numeroMaxVagoes;

    public Locomotiva(int id, double pesoMaximo, int numeroMaxVagoes, Composicao composicao){
        super(id, composicao);
        this.pesoMaximo = pesoMaximo;
        this.numeroMaxVagoes = numeroMaxVagoes;
        
    }

    public int getIdLocomotiva() {
        return id;
    }

    public void setIdLocomotiva(int id) {
        this.id = id;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public int getNumeroMaxVagoes() {
        return numeroMaxVagoes;
    }

    public void setNumeroMaxVagoes(int numeroMaxVagoes) {
        this.numeroMaxVagoes = numeroMaxVagoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }
}