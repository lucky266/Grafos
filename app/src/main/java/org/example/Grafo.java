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
    // Fim gerador de grafos

  
      // Atualizar lista de arestas na classe Vertice
    void updateListEmVertice(){ 
        int tamanhoVerticesList = vertices.size();
        if(tamanhoVerticesList<1){ return ; }
        int tamanhoArestasList = arestas.size();
        for(int i = 0 ; i < tamanhoArestasList ; i++){
            Aresta aresta = arestas.get(i);
            aresta.getV1().vincularAresta(aresta);
            aresta.getV2().vincularAresta(aresta);
        }
    }

    // Operações em grafos:
    void removerAresta(Aresta arestaAlvo){
        // Desvincula
        arestaAlvo.getV1().desvincularAresta(arestaAlvo);
        arestaAlvo.getV2().desvincularAresta(arestaAlvo);
        arestas.remove(arestaAlvo);
        arestaAlvo=null;
    }
    void removerVertice(Vertice verticeAlvo){
        List<Aresta> arestasVinculadas = verticeAlvo.getArestas();
        if(!arestasVinculadas.isEmpty()){
            for(int i = 0; i < arestasVinculadas.size() ; i++){
                removerAresta(arestasVinculadas.get(i));
            }
        }
        vertices.remove(verticeAlvo);
        verticeAlvo=null;
    }
    // Criar subgrafo simples:
    void removerLoops(){
        int tamanhoArestasList = arestas.size();
        // Remove arestas que conectam no mesmo vertice:
        for(int i = 0 ; i < tamanhoArestasList ; i++){
            if(arestas.get(i).getV1()==arestas.get(i).getV2()){
                removerAresta(arestas.get(i));
                tamanhoArestasList = arestas.size();
                i=-1;
            }
        }
    }
    void subgrafoSimples(){
        removerLoops();
    }
    /*void removerArestasDuplas(){ // TODO: Conseguir fazer essa função 
        int tamanhoVerticesList = vertices.size();
        int tamanhoArestasList = arestas.size();
        // Ordenar? 
        for(int i = 0 ; i < tamanhoArestasList ; i++){
            Aresta aresta = arestas.get(i);
            if(aresta.getV1().getNome().compareTo(aresta.getV2().getNome())==-1){
                Vertice tmp = aresta.getV1();
                aresta.setV1(aresta.getV2());
                aresta.setV2(tmp);
            }
        }

        // Metodo 1: 
        for(int i = 0 ; i < tamanhoArestasList ; i++){
            for(int  j = i ; j < tamanhoArestasList ; j++){
                if(arestas.get(i).getV1().getNome() == arestas.get(j).getV2().getNome()){
                    System.out.printf("%d %d \n",i,j);
                    removerAresta(arestas.get(j));
                    tamanhoArestasList = arestas.size();
                    i=0;
                    j=i;
                }
            }
        }
    }*/
}   