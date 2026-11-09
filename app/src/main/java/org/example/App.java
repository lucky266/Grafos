package org.example;
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {

        Grafo G = new Grafo("G1");
        Output Saida = new Output(G);
        Saida.mostrarGrafo();
        while(true){
             G.gerarGrafoAleatorio(1,3,25,25,1,20);
             Saida.updateGrafo();
             Thread.sleep(10000);
             Saida.updateGrafo();
        }
    }
}
