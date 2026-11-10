package org.example;
import java.util.ArrayList;
import java.util.List;
public class Vertice {
    private String nome;
    private List<Aresta> arestas = new ArrayList<>();
    private int custo;
    private Aresta pai;
    private boolean visitado;
    public Vertice(String nome, List<Aresta> arestas) {
        this.nome = nome;
        this.arestas = new ArrayList<>(arestas);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Aresta> getArestas() {
        return arestas;
    }
    public void setArestas(List<Aresta> arestas) {
        this.arestas = new ArrayList<>(arestas);
    }   
    void vincularAresta(Aresta aresta){
        arestas.add(aresta);
    }
    void desvincularAresta(Aresta aresta){
        arestas.remove(aresta);
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Aresta getPai() {
        return pai;
    }

    public void setPai(Aresta pai) {
        this.pai = pai;
    }
    public boolean isVisitado() {
        return visitado;
    }
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}