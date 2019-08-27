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
        
        if(grafoIsArvore(grafo) == true){
            super.setVertices(grafo);
        }
    }
    
    /**
     * 
     * @param grafo (Grafo)
     * @return grafoIsArvore (boolean)
     * 
     * verifica se um grafo é uma arvore
     */
    private boolean grafoIsArvore(Grafo grafo){
        List<Vertice> vertices = grafo.getVertices();
        
        for (Vertice vertice : vertices) {
            //3: 1 de entrada e no maximo 2 de saida
            if(vertice.getLigacoes().size() > 3){
                System.out.println("O grafo não é uma arvore");
                return false;
            }
        }
        
        return true;
    }
}
