/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<Vertice> vertices;
    
    public Grafo(){
        this.vertices = new ArrayList<>();
    }
    
    public Grafo(int q_vertices) {
        this();
        
        for (int i = 0; i < q_vertices; i++) {
            this.vertices.add(new Vertice(i));
        }
    }
    
    /**
     * metodo setVertices
     * 
     * @param grafo 
     * 
     * define os vertices a partir de um grafo ja existente
     */
    public void setVertices(Grafo grafo) {
        this.vertices = grafo.getVertices();
    }
    
    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    /**
     * metodo: setLigacao
     * 
     * @param index_v1 (int)
     * @param index_v2 (int)
     * @param peso (int)
     * 
     * cria ligacoes entre os vertices utilizando o nome dos vertices
     * o parametro peso corresponde ao peso da aresta a ser criada
     */
    public void setLigacao(int index_v1, int index_v2, int peso) {
        int q_vertices = this.vertices.size();
        
        if(index_v1 > q_vertices -1 || index_v2 > q_vertices -1){
            return;
        }
        else if(index_v1 < 0 || index_v2 < 0){
            return;
        }
        
        Vertice v1 = this.vertices.get(index_v1);
        Vertice v2 = this.vertices.get(index_v2);
        
        v1.setLigacao(v1, v2, peso);
        v2.setLigacao(v1, v2, peso);
    }
    
    /**
     * metodo: setLigacao
     * 
     * @param nome_v1 (String)
     * @param nome_v2 (String)
     * @param peso (int)
     * 
     * cria ligacoes entre os vertices utilizando o nome dos vertices
     * o parametro peso corresponde ao peso da aresta a ser criada
     */
    public void setLigacao(String nome_v1, String nome_v2, int peso) {
        int index_v1 = indexOf(nome_v1);
        int index_v2 = indexOf(nome_v2);
        
        if(index_v1 == -1 || index_v2 == -1){
            return;
        }
        
        setLigacao(index_v1, index_v2, peso);
    }
    
    /**
     * metodo: getVertices
     * 
     * @return List (Vertice)
     * 
     * retorna uma lista com todos os vertices pertencentes ao grafo
     */
    public List<Vertice> getVertices() {
        return this.vertices;
    }
    
    /**
     * metodo: addVertice
     * 
     * @param nome 
     * 
     * adiciona um novo vertice com um nome especifico ao grafo 
     */
    public void addVertice(String nome){
        this.vertices.add(new Vertice(this.vertices.size(), nome.toUpperCase()));
    }
    
    /**
     * metodo: addAresta
     * 
     * @param origem (String)
     * @param destino (String)
     * @param peso (int)
     * 
     * cria uma nova aresta a partir de dois vertices, e do peso da aresta
     * o nome de cada vertice e passado como parametro
     */
    public void addAresta(String origem, String destino, int peso){
        int index_origem = indexOf(origem);
        int index_destino = indexOf(destino);
        
        
        if(index_origem == -1 || index_destino == -1){
            System.out.println("Vertice inexistente!");
        } 
        
        else {
            Vertice v_origem = this.vertices.get(index_origem);
            Vertice v_destino = this.vertices.get(index_destino);
            
            v_origem.setLigacao(v_origem, v_destino, peso);
        }
    }
    
    /**
     * metodo: indexOf
     * 
     * @param nome
     * @return index (int)
     * 
     * retorna o local do vertice na lista geral a partir do nome
     * retorna -1 caso o vertice nao exista
     */
    private int indexOf(String nome){
        
        for(int i=0;i<this.vertices.size();i++){
            if(this.vertices.get(i).getNome().equals(nome.toUpperCase())){
                return i;
            }
        }
        return -1;
    }
}
