package org.example;
import java.util.ArrayList;
import java.util.List;

public class Algoritmo {
    private Grafo grafoEntrada;
    private Grafo grafoSaida;
    private List<Vertice> verticesAlvo = new ArrayList<>();
    public Algoritmo(Grafo grafoEntrada) {
        this.grafoEntrada = grafoEntrada;
    }
    public Grafo getGrafoEntrada() {
        return grafoEntrada;
    }
    public void setGrafoEntrada(Grafo grafoEntrada) {
        this.grafoEntrada = grafoEntrada;
    }
    public Grafo getGrafoSaida() {
        return grafoSaida;
    }
    public void setGrafoSaida(Grafo grafoSaida) {
        this.grafoSaida = grafoSaida;
    }
    public List<Vertice> getVerticesAlvo() {
        return verticesAlvo;
    }
    public void setVerticesAlvo(List<Vertice> verticesAlvo) {
        this.verticesAlvo = verticesAlvo;
    }
}
