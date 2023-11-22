package com.teste.Model;

public class Vagao extends Carro {
    private double capMaxdeCarga;

    public Vagao (int id, double capMaxdeCarga, Composicao composicao){
        super(id, composicao);
        this.capMaxdeCarga = capMaxdeCarga;
        this.composicao = composicao;    
    }

    public int getIdVagao() {
        return id;
    }

    public void setIdVagao(int id) {
        this.id = id;
    }

    public double getCapMaxdeCarga() {
        return capMaxdeCarga;
    }

    public void setCapMaxdeCarga(double capMaxdeCarga) {
        this.capMaxdeCarga = capMaxdeCarga;
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }
}
