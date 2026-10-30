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
             Thread.sleep(3000);
             G.gerarGrafoAleatorio(1,50,0,100,1,5);
             Saida.updateGrafo();
        }
    }
}
