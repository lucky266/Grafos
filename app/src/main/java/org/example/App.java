package org.example;
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {

        Grafo G = new Grafo("G1");
        G.gerarGrafoAleatorio(10,20,15,25,1,5);
        Output Saida = new Output(G);
        Saida.printGrafo();

    }
}
