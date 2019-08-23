/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private final List<Vertice> vertices;
    
    public Grafo(){
        this.vertices = new ArrayList<>();
    }
    
    public Grafo(int q_vertices) {
        this();
        
        for (int i = 0; i < q_vertices; i++) {
            this.vertices.add(new Vertice(i));
        }
    }
    
    //cria ligaçoes entre os vertices com indices pertencentes ao array
    public void setLigacao(int index_v1, int index_v2, int peso) {
        int q_vertices = this.vertices.size();
        
        if(index_v1 > q_vertices -1 || index_v2> q_vertices -1){
            return;
        }
        
        Vertice v1 = this.vertices.get(index_v1);
        Vertice v2 = this.vertices.get(index_v2);
        
        if(!(v1.getLigacoes().contains(v2))) v1.setLigacao(v2, peso);
        if(!(v2.getLigacoes().contains(v1))) v2.setLigacao(v1, peso);
    }
    
    public void setLigacao(String nome_v1, String nome_v2, int peso) {
        int q_vertices = this.vertices.size();
        
        int index_v1 = indexOf(nome_v1);
        int index_v2 = indexOf(nome_v2);
        
        setLigacao(index_v1, index_v2, peso);
    }
    
    public List<Vertice> getVertices() {
        return this.vertices;
    }
    
    public void addVertice(String nome){
        this.vertices.add(new Vertice(this.vertices.size(), nome));
    }
    
    public void addAresta(String origem, String destino, int peso){
        if(indexOf(origem) == -1 || indexOf(destino) == -1){
            System.out.println("Vertice inexistente!");
        } 
        
        else {
            this.vertices.get(indexOf(origem)).setLigacao(this.vertices.get(indexOf(destino)), peso);
        }
    }
    
    private int indexOf(String nome){
        
        for(int i=0;i<this.vertices.size();i++){
            if(this.vertices.get(i).getNome().equals(nome)){
                return i;
            }
        }
        return -1;
    }
}
