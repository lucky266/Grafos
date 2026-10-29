package org.example;
import java.util.List;
import java.util.ArrayList;
public class Grafo {
    private List<Vertice> vertices = new ArrayList<>();
    private List<Aresta> arestas = new ArrayList<>();
    public Grafo(List<Vertice> vertices, List<Aresta> arestas) {
        this.vertices = new ArrayList<Vertice>(vertices);
        this.arestas = new ArrayList<Aresta>(arestas);
    }
    public List<Vertice> getVertices() {
        return vertices;
    }
    public List<Aresta> getArestas() {
        return arestas;
    }
    public void setVertices(List<Vertice> vertices) {
        this.vertices = new ArrayList<Vertice>(vertices);
    }
    public void setArestas(List<Aresta> arestas) {
        this.arestas = new ArrayList<Aresta>(arestas);
    }
    
    
    
}   