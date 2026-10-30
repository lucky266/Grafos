package org.example;


import java.util.List;
import java.util.ArrayList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws InterruptedException {
        List<Vertice> verticesList = new ArrayList<>();
        List<Aresta> arestaList = new ArrayList<>();
        verticesList = createRandomVertices(verticesList);
        arestaList = createRandomArestas(arestaList,verticesList);

        Grafo G = new Grafo(verticesList, arestaList);
        Output Saida = new Output(G);
        Saida.printGrafo();
    }
    
    static int aleatorio(int min, int max){
        return (int)Math.round(Math.random()*(max-min)+min);
    }

    public static List<Vertice> createRandomVertices(List<Vertice> verticesList){
        List<Aresta> arestasTemp = new ArrayList<>();
        int verticesQuantidade = aleatorio(15,30);
        for(int i = 0 ; i < verticesQuantidade ; i++){
            verticesList.add(new Vertice("v"+ i, arestasTemp));
        }
        return verticesList;
    }

 
    public static List<Aresta> createRandomArestas(List<Aresta> arestaList,List<Vertice> verticesList){
        int arestaQuantidade = aleatorio(30,50);
        int pesoMax = 5;
        int pesoMin = 1;
        int tamanhoVerticesList = verticesList.size() - 1;
        for(int i = 0 ; i < arestaQuantidade ; i++){
            int pesoAleatorio = aleatorio(pesoMin,pesoMax);
            int indiceVerticeAleatorio1 = aleatorio(0, tamanhoVerticesList);
            int indiceVerticeAleatorio2 = aleatorio(0, tamanhoVerticesList);
            arestaList.add(new Aresta(verticesList.get(indiceVerticeAleatorio1),verticesList.get(indiceVerticeAleatorio2),pesoAleatorio,"a"+i));
        }
        return arestaList;
    }
}
