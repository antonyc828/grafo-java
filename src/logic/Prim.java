/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Aresta;
import geometry.Arvore;
import java.util.List;

public abstract class Prim{
    
    public static Arvore getArvoreMinima(Arvore arvore) {
        List<Aresta> arestas = ArvoreMinima.getArestas(arvore.getVertices());
        
        Arvore arvore_minima = ArvoreMinima.getMinima(arestas);
        
        return arvore_minima;
    }
}
