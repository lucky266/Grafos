package org.example;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private Grafo g;
    
    public Output(Grafo g) {
        this.g = g;
    }
    private Graph grafo = new MultiGraph(g.getGrafoNome());

      public Grafo getG() {
        return g;
    }
    public void setG(Grafo g) {
        this.g = g;
    }
    public Graph getGrafo() {
        return grafo;
    }
    public void setGrafo(Graph grafo) {
        this.grafo = grafo;
    }
    
    public void mostrarGrafo(){
        System.setProperty("org.graphstream.ui", "swing");
        grafo.display();
    }
    void updateGrafo(){
        grafo.clear();
        grafo.setAttribute("ui.stylesheet",
                "node { " +
                        "  size: 23px, 23px; " +
                        "  fill-color: #7c7c76; " +
                        "  text-mode: normal; " +
                        "  text-size: 19; }" +
                "edge { text-mode: normal; text-size: 20; text-alignment: under;}");
        System.setProperty("org.graphstream.ui", "swing"); 
        List<Vertice> vertices = new ArrayList<Vertice>(g.getVertices());
        List<Aresta> arestas = new ArrayList<Aresta>(g.getArestas());

        // Vertices:
        int tamanho = vertices.size();
        for(int i = 0 ; i < tamanho ; i++){
            grafo.addNode(vertices.get(i).getNome()).setAttribute("ui.label", vertices.get(i).getNome());
        }

        // Arestas:
        tamanho = arestas.size();
        for(int i = 0 ; i < tamanho ; i++){
            // daria pra melhorar visualização se adicionar condicional pra cada tipo de aresta
            grafo.addEdge(
                arestas.get(i).getNome(),
                arestas.get(i).getV1().getNome(),
                arestas.get(i).getV2().getNome() 
            ).setAttribute("ui.label", arestas.get(i).getPeso());
        }
    }

    void printText(){
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
