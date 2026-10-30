package org.example;
import java.util.List;
import java.util.ArrayList;
public class Grafo {
    private List<Vertice> vertices = new ArrayList<>();
    private List<Aresta> arestas = new ArrayList<>();
    private String grafoNome = new String();
    
    public Grafo(String grafoNome) {
        this.grafoNome = grafoNome;
    }
    public List<Vertice> getVertices() {
        return vertices;
    }
    public List<Aresta> getArestas() {
        return arestas;
    }
    public void setVertices(List<Vertice> vertices) {
        this.vertices = new ArrayList<Vertice>(vertices);
    }
    public void setArestas(List<Aresta> arestas) {
        this.arestas = new ArrayList<Aresta>(arestas);
    }
    public String getGrafoNome() {
        return grafoNome;
    }
    public void setGrafoNome(String grafoNome) {
        this.grafoNome = grafoNome;
    }


    // gerar grafos aleatorios:
    public void gerarGrafoAleatorio(int vMin, int vMax, int aMin, int aMax, int aPesoMin, int aPesoMax){
        vertices = createRandomVertices(vertices,vMin,vMax);
        arestas = createRandomArestas(arestas,vertices,aMin,aMax,aPesoMin,aPesoMax);
    }

    int aleatorio(int min, int max){
        return (int)Math.round(Math.random()*(max-min)+min);
    }

    List<Vertice> createRandomVertices(List<Vertice> verticesList, int vMin, int vMax){
        List<Aresta> arestasTemp = new ArrayList<>();
        int verticesQuantidade = aleatorio(vMin,vMax);
        for(int i = 0 ; i < verticesQuantidade ; i++){
            if(i > verticesList.size() - 1){
                verticesList.add(new Vertice("v"+ i, arestasTemp));
            }else{               
                verticesList.set(i,new Vertice("v"+i,arestasTemp));
            }
        }
        return verticesList;
    }
    List<Aresta> createRandomArestas(List<Aresta> arestaList,List<Vertice> verticesList, int aMin, int aMax, int aPesoMin, int aPesoMax){
        int arestaQuantidade = aleatorio(aMin,aMax);
        int tamanhoVerticesList = verticesList.size() - 1;
        for(int i = 0 ; i < arestaQuantidade ; i++){
            int pesoAleatorio = aleatorio(aPesoMin,aPesoMax);
            int randVIndex1 = aleatorio(0, tamanhoVerticesList);
            int randVIndex2 = aleatorio(0, tamanhoVerticesList);
            if(i > arestaList.size() - 1){
                arestaList.add(new Aresta(verticesList.get(randVIndex1),verticesList.get(randVIndex2),pesoAleatorio,"a"+i));
            }else{
                arestaList.set(i,new Aresta(verticesList.get(randVIndex1),verticesList.get(randVIndex2),pesoAleatorio,"a"+i));
            }
        }
        return arestaList;
    }
 
    
    
    
}   