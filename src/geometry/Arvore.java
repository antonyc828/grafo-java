/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.List;
import logic.Kruskal;
import logic.Prim;

public class Arvore {
    private final List<Aresta> arestas;

    public Arvore(List<Aresta> arestas) {
        this.arestas = arestas;
    }
    
    public void getArvoreMinima(Prim prim){
        prim.getMinima();
    }
    
    public void getArvoreMinima(Kruskal kruskal){
        kruskal.getMinima();
    }
}
