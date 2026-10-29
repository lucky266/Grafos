package org.example;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private Grafo g;

    public Output(Grafo g) {
        this.g = g;
    }
    
    void print(){
        List<Vertice> vertices = new ArrayList<Vertice>(g.getVertices());
        List<Aresta> arestas = new ArrayList<Aresta>(g.getArestas());
        
        // Print:
        // Arestas:
        for(int i = 0 ; i < arestas.size(); i++){
            System.out.printf("%s %s %d %n",arestas.get(i).getV1().getNome(),arestas.get(i).getV2().getNome(),arestas.get(i).getPeso());
        }
        // Sozinhos:
        for(int i = 0 ; i < vertices.size(); i++){
            if(vertices.get(i).getArestas().isEmpty()){
                System.out.printf("%s %n",vertices.get(i).getNome());
            }
        }
    }
}
