package org.example;
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
        // Gerando grafo simples completo pra testes:
        G.gerarGrafoAleatorio(5, 5, 100, 100, 0, 0);
        G.subgrafoSimples();
        Saida.updateGrafo();
        Saida.printText();


        JOptionPane.showMessageDialog(null, "Pressione ENTER para continuar...");
        // Area pronta para testes:

        Saida.updateGrafo();
        Saida.printText();
        

        
    }
}
