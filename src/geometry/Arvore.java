/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.List;

public class Arvore extends Grafo{
    
    public Arvore(){
        super();
    }
    
    public Arvore(Grafo grafo){
        this();
        
        if(grafoIsArvore(grafo)){
            super.setVertices(grafo);
        }
    }
    
    private boolean grafoIsArvore(Grafo grafo){
        List<Vertice> vertices = grafo.getVertices();
        
        for (Vertice vertice : vertices) {
            if(vertice.getLigacoes().size() > 2){
                System.out.println("O grafo não é uma arvore");
                return false;
            }
        }
        
        
        return true;
    }
}
