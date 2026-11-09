package org.example;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {
        Grafo G = new Grafo("G1");
        Output Saida = new Output(G);
        Saida.mostrarGrafo();
        JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        System.out.println("Gerar Grafo");
        // G.gerarGrafoAleatorio(5,5,5,10,1,20);
        List<Vertice> vertices = new ArrayList<>();
        List<Aresta> arestas = new ArrayList<>();

        Vertice v1 = new Vertice("v1", arestas);
        Vertice v2 = new Vertice("v2", arestas);
        Vertice v3 = new Vertice("v3", arestas);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        Aresta a1 = new Aresta(v1, v1, 0, "a1");
        Aresta a2 = new Aresta(v1, v2, 0, "a2");
        Aresta a3 = new Aresta(v2, v3, 0, "a3");
        Aresta a4 = new Aresta(v2, v3, 0, "a4");
        arestas.add(a1);
        arestas.add(a2);
        arestas.add(a3);
        arestas.add(a4);
        G.updateListEmVertice();
        G.setVertices(vertices);
        G.setArestas(arestas);

        
        G.gerarGrafoAleatorio(5, 5, 40, 500, 0, 0);
        
        Saida.updateGrafo();
        Saida.printText();
      
        // JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        // System.out.println("Remover Loop");
        // G.removerLoops();
        /// Saida.updateGrafo();
        // Saida.printText();

        JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        System.out.println("Ordenar Aresta");
        G.ordenarArestas();
        Saida.updateGrafo();
        Saida.printText();

        JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        G.updateListEmVertice();
        System.out.println("Remover Arestas duplas");
        G.removerArestasDuplas();
        Saida.updateGrafo();
        Saida.printText();
        

        
    }
}
