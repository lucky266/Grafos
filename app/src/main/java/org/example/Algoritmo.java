package org.example;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {
    private Grafo grafoEntrada;
    private Grafo grafoSaida = new Grafo("grafoSaida");
    private List<Vertice> verticesAlvo = new ArrayList<>();

    public Algoritmo(Grafo grafoEntrada) {
        this.grafoEntrada = grafoEntrada;
    }

    public Grafo getGrafoEntrada() {
        return grafoEntrada;
    }

    public void setGrafoEntrada(Grafo grafoEntrada) {
        this.grafoEntrada = grafoEntrada;
    }

    public Grafo getGrafoSaida() {
        return grafoSaida;
    }

    public void setGrafoSaida(Grafo grafoSaida) {
        this.grafoSaida = grafoSaida;
    }

    public List<Vertice> getVerticesAlvo() {
        return verticesAlvo;
    }

    public void setVerticesAlvo(List<Vertice> verticesAlvo) {
        this.verticesAlvo = verticesAlvo;
    }
    void TSPNearestNeighborOLD() { // Fazer outro.
        // Caixeiro Viajante com vizinho mais próximo, todos os vertices precisam ser visitados.
        boolean voltarAoPrimeiro = true;
        List<Vertice> vOut = new ArrayList<>();
        List<Aresta> aOut = new ArrayList<>();

        // Gerar grafo gAux pra não mecher no grafoEntrada;
        Grafo gAux = new Grafo("aux");
        
        List<Vertice> vEntrada = grafoEntrada.getVertices(); 
        for(int i = 0 ; i < vEntrada.size() ; i++){  // Seta todos os vertices como não visitado
            vEntrada.get(i).setVisitado(false);
        }

        // Seta vertices e arestas pro grafo auxiliar:
        gAux.setVertices(vEntrada);
        gAux.setArestas(grafoEntrada.getArestas());

        // Iniciar em vertice aleatório:
        double indiceRandom = Math.random() * grafoEntrada.getVertices().size();
        Vertice vAtual = gAux.getVertices().get((int) indiceRandom);
        

        System.out.printf("\n gESize: %d Indice random: %f, nome: %s\n",grafoEntrada.getVertices().size(),indiceRandom,vAtual.getNome());

        vOut.add(vAtual); // Adiciona inicalmnete o vAtual à lista do grafo saida
        vAtual.setVisitado(true); // Seta o primeiro vertice como visitado
        int verticesVisitados = 1; // inicia em 1 pq vAtual ja ta visitado
        int somaDosPesos = 0;
        System.out.printf("Arestas do vertice inicial:");
        for (int i = 0 ; i < vAtual.getArestas().size() ; i++){
            System.out.printf("\t%d",vAtual.getArestas().get(i).getPeso());
        }
        // Inicio do loop aqui:
        while (verticesVisitados < grafoEntrada.getVertices().size()) {
            List<Aresta> arestasAdjacentes = vAtual.getArestas();
            int vAtualGrau = arestasAdjacentes.size();

            Aresta melhorCaminho = arestasAdjacentes.getFirst();
            int j = 0;
            while(vAtual.getPai()!=null && melhorCaminho == vAtual.getPai()){ // Trata do erro de todos os caminhos do novo vertice atual serem maiores que o pai
                melhorCaminho = arestasAdjacentes.get(j);
                j++;
            }
            // Acha a menor aresta adjacente a vAtual:
            for (int i = 0; i < vAtualGrau; i++) { // Varre todas as Arestas do vAtual
                
                Aresta arestaAtual = arestasAdjacentes.get(i);
                // Decisão de qual caminho seguir:
                System.out.printf("\nver se aresta atual com peso: %d eh menor que %d",arestaAtual.getPeso(),melhorCaminho.getPeso());
                if(arestaAtual.getPeso() < melhorCaminho.getPeso()){
                    System.out.printf("\nver se aresta de peso %d pode ser caminho",arestaAtual.getPeso());
                    if(!arestaAtual.getV1().isVisitado() || !arestaAtual.getV2().isVisitado() && arestaAtual != vAtual.getPai()){

                        System.out.printf("\ntroca melhorAresta por aresta de peso: %d ",arestaAtual.getPeso());
                        melhorCaminho = arestaAtual;
                    }
                }  
            }
          
            System.out.printf("\n vAtual será trocado, antigo vAtual: %s",vAtual.getNome());
            // Mover vAtual para o próximo Vertice:

            System.out.printf("\n Vertices Visitados: %d",verticesVisitados);
            
            if (melhorCaminho.getV1() == vAtual) {
                vAtual = melhorCaminho.getV2();
            }else{
                vAtual = melhorCaminho.getV1();
            }
            System.out.printf("\n vAtual trocado, novo vAtual: %s",vAtual.getNome());
            vAtual.setPai(melhorCaminho);
            vAtual.setVisitado(true);
            verticesVisitados++;
            somaDosPesos = somaDosPesos + melhorCaminho.getPeso();

            // Atualizar grafo saida
            vOut.add(vAtual); // Adiciona vAtual à lista do grafo saida
            aOut.add(melhorCaminho); // Adiciona a aresta escolhida à lista do grafo saída
            grafoSaida.setVertices(vOut);
            grafoSaida.setArestas(aOut);
        }
        // Voltar para inicio:
        if(voltarAoPrimeiro){
            List<Aresta> arestasAdjacentes = vAtual.getArestas();
            Aresta arestaAtual = vAtual.getArestas().getFirst();
            for(int i = 0 ; i < arestasAdjacentes.size() ; i ++){ // varre todas arestas
                arestaAtual = arestasAdjacentes.get(i);
                System.out.printf("\n varrendo arestas, peso atual: %d",arestaAtual.getPeso());

                if(arestaAtual.getV1().getPai()==null){ // Achar a sem pai
                    vAtual = arestaAtual.getV1();
                    System.out.printf("\nSem pai encontrado foi: %s",vAtual.getNome());
                }else{
                    vAtual = arestaAtual.getV2();
                    System.out.printf("\nSem pai encontrado foi: %s",vAtual.getNome());
                }
            }
            System.out.printf("\n vAtual trocado, novo vAtual: %s",vAtual.getNome());
            System.out.printf("\nCaminho escolhido: peso: %d", arestaAtual.getPeso());
            vAtual.setPai(arestaAtual);
            aOut.add(arestaAtual);
            grafoSaida.setArestas(aOut);
            somaDosPesos=somaDosPesos+arestaAtual.getPeso();
        }
        System.out.printf("\n Soma dos pesos: %d\n",somaDosPesos);
    }
    void TSPNearestNeighbor(){
        // Organizar o ambiente:
        int somaDosPesos = 0;
        List<Vertice> vOut = new ArrayList<>();
        List<Aresta> aOut = new ArrayList<>();
        // Inicializar todos os vertices como não-visitados:
        List<Vertice> vertices = grafoEntrada.getVertices();
        for(int i = 0 ; i < vertices.size() ; i ++){
            vertices.get(i).setVisitado(false);
        }

        // Selecionar vertice aleatorio:
        double indiceRandom = Math.random()*vertices.size();
        Vertice vAtual = vertices.get((int) indiceRandom);
        Vertice vInicial = vAtual;
        vAtual.setVisitado(true);
        vOut.add(vAtual);
        int arestasVisitadas = 1;

        // Olhar para as arestas conectadas ao vAtual
        while(arestasVisitadas < vertices.size()){
            int melhorIndice = 0;
            // Remove a chance do melhorIndice inicial levar à alguem ja visitado
            while(vAtual.getArestas().get(melhorIndice).getV1().isVisitado() && vAtual.getArestas().get(melhorIndice).getV2().isVisitado()){
                melhorIndice++; // Risco de out of bounds
            }
            for(int i = 0 ; i < vAtual.getArestas().size() ; i++){
                Aresta arestaAtual = vAtual.getArestas().get(i);
                Aresta melhorAresta = vAtual.getArestas().get(melhorIndice);
                if(arestaAtual.getPeso() < melhorAresta.getPeso()){ // Verificação de ser menor
                    if(!arestaAtual.getV1().isVisitado() || !arestaAtual.getV2().isVisitado()){ // Pelo menos uma das pontas não visitadas
                        // Novo melhor indice:
                        melhorIndice = i;
                    }
                }
            }
            Aresta melhorCaminho = vAtual.getArestas().get(melhorIndice);
            // Troca do vAtual e guardar os valores.
            if(melhorCaminho.getV1().isVisitado()){
                vAtual = melhorCaminho.getV2();
            }else{
                vAtual = melhorCaminho.getV1();
            }
            arestasVisitadas++;
            vAtual.setVisitado(true); // Seta o novo vertice como visitado 
            somaDosPesos = somaDosPesos + melhorCaminho.getPeso();
            // Adiciona Vertice e Aresta p saida
            vOut.add(vAtual);
            aOut.add(melhorCaminho);
        }
        // Ligar o ultimo vertice com o inicio
        int indiceFinal = 0;
        for(int i = 0 ; i < vAtual.getArestas().size() ; i++){ // Varrer todos as arestas adjacentes p achar o inicial
            Aresta arestaAtual = vAtual.getArestas().get(i);
            if(arestaAtual.getV1() == vInicial || arestaAtual.getV2() == vInicial){
                indiceFinal = i;
            }
        }
        Aresta caminhoFinal = vAtual.getArestas().get(indiceFinal);
        aOut.add(caminhoFinal);
        somaDosPesos = somaDosPesos + caminhoFinal.getPeso();
        grafoSaida.setVertices(vOut);
        grafoSaida.setArestas(aOut);
        System.out.printf("Soma dos pesos do caminho encontrado: %d",somaDosPesos);
    }
}
