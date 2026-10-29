package org.example;
public class Aresta {
    private Vertice v1;
    private Vertice v2;
    private int peso;
    private String nome;
    public Aresta(Vertice v1, Vertice v2, int peso, String nome) {
        this.v1 = v1;
        this.v2 = v2;
        this.peso = peso;
        this.nome = nome;
    }
    public Vertice getV1() {
        return v1;
    }
    public Vertice getV2() {
        return v2;
    }
    public int getPeso() {
        return peso;
    }
    public String getNome() {
        return nome;
    }
}