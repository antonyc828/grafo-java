/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private final List<Vertice> vertices;
    
    public Grafo(int q_vertices) {
        this.vertices = new ArrayList<>();
        
        for (int i = 0; i < q_vertices; i++) {
            this.vertices.add(new Vertice(i));
        }
    }
    
    //cria ligaçoes entre os vertices com indices pertencentes ao array
    public void setLigacao(int index_v1, int index_v2) {
        int q_vertices = this.vertices.size();
        
        if(index_v1 > q_vertices -1 || index_v2> q_vertices -1){
            return;
        }
        
        Vertice v1 = this.vertices.get(index_v1);
        Vertice v2 = this.vertices.get(index_v2);
        
        if(!(v1.getLigacoes().contains(v2))) v1.setLigacao(v2);
        if(!(v2.getLigacoes().contains(v1))) v2.setLigacao(v1);
    }
    
    public List<Vertice> getVertices() {
        return this.vertices;
    }
}
