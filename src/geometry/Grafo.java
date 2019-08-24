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

    public void setVertices(Grafo grafo) {
        this.vertices = grafo.getVertices();
    }
    
    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    //cria ligaçoes entre os vertices com indices pertencentes ao array
    public void setLigacao(int index_v1, int index_v2, int peso) {
        int q_vertices = this.vertices.size();
        
        if(index_v1 > q_vertices -1 || index_v2> q_vertices -1){
            return;
        }
        
        Vertice v1 = this.vertices.get(index_v1);
        Vertice v2 = this.vertices.get(index_v2);
        
        v1.setLigacao(v1, v2, peso);
        v2.setLigacao(v1, v2, peso);
    }
    
    public void setLigacao(String nome_v1, String nome_v2, int peso) {
        int q_vertices = this.vertices.size();
        
        int index_v1 = indexOf(nome_v1);
        int index_v2 = indexOf(nome_v2);
        
        if(index_v1 == -1 || index_v2 == -1){
            return;
        }
        
        setLigacao(index_v1, index_v2, peso);
    }
    
    public List<Vertice> getVertices() {
        return this.vertices;
    }
    
    public void addVertice(String nome){
        this.vertices.add(new Vertice(this.vertices.size(), nome.toUpperCase()));
    }
    
    public void addAresta(String origem, String destino, int peso){
        if(indexOf(origem) == -1 || indexOf(destino) == -1){
            System.out.println("Vertice inexistente!");
        } 
        
        else {
            Vertice v_origem = this.vertices.get(indexOf(origem));
            Vertice v_destino = this.vertices.get(indexOf(origem));
            
            v_origem.setLigacao(v_origem, v_destino, peso);
        }
    }
    
    private int indexOf(String nome){
        
        for(int i=0;i<this.vertices.size();i++){
            if(this.vertices.get(i).getNome().equals(nome.toUpperCase())){
                return i;
            }
        }
        return -1;
    }
}
