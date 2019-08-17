/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Grafo;
import geometry.Vertice;

public abstract class ListaAdjacencia {
    
    
    public static String getList(Grafo grafo){
        String list = "";
        
        for (Vertice vertice : grafo.getVertices()) {
            list += vertice.getLocal();
            for(Vertice vertice_ligado : vertice.getLigacoes()) {
                list += " -> "+vertice_ligado.getLocal();
            }
            list += "\n";
        }
        
        return list;
    }
}
