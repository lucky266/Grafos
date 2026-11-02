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
             G.gerarGrafoAleatorio(1,3,0,5,1,5);
             Saida.updateGrafo();
             Thread.sleep(4500);
        }
    }
}
