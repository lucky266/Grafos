package org.example;
import javax.swing.JOptionPane;
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        Grafo G = new Grafo("G1");
        Output Saida = new Output(G);
        Saida.mostrarGrafo();
        JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        System.out.println("Gerar Grafo");
        // Gerando grafo simples completo pra testes:
        G.gerarGrafoAleatorio(5, 5, 10000, 10000, 1, 20);
        G.subgrafoSimples();
        Saida.updateGrafo();
        Saida.printText();


        JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        // Area pronta para testes:
        Algoritmo TSP = new Algoritmo(G.clone());
        TSP.TSPNearestNeighbor();
        Output Saida2 = new Output(TSP.getGrafoSaida());
        Saida2.mostrarGrafo();
        Saida2.updateGrafo();   
        System.out.printf("\nGrafo Saida:\n");
        Saida2.printText();
    }
}
