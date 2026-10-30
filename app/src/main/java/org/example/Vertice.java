package org.example;
import java.util.ArrayList;
import java.util.List;
public class Vertice {
    private String nome;
    private List<Aresta> arestas = new ArrayList<>(); // Não tenho certeza se manter isso é bom mas vou deixar
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
}