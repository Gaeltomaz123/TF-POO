package com.teste.Model;

public abstract class Carro {
    protected int id;
    protected Composicao composicao;
    
    public Carro(int id, Composicao composicao){
        this.id = id;
        this.composicao = composicao;
    }
}
