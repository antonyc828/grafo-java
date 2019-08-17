/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Grafo;
import geometry.Vertice;
import java.util.List;

public abstract class ListaAdjacencia {
    
    
    public static String getList(Grafo grafo){
        String list = "";
        List<Vertice> vertices = grafo.getVertices();
        
        for (Vertice vertice :vertices) {
            List<Vertice> ligacoes = vertice.getLigacoes();
            
            list += vertice.getLocal();

            for(Vertice vertice_ligado : ligacoes) {
                list += " -> "+vertice_ligado.getLocal();
            }
            
            list += "\n";
        }
        
        return list;
    }
}
