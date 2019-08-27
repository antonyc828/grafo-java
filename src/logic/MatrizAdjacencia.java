/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Grafo;
import geometry.Vertice;
import java.util.List;

public abstract class MatrizAdjacencia {
    
    /**
     * metodo: getMatriz
     * 
     * @param grafo
     * @return 
     * 
     * retorna a matriz de adjacencia de um grafo
     */
    public static int[][] getMatriz(Grafo grafo){
        List<Vertice> vertices = grafo.getVertices();
        int[][] matriz = createMatriz(vertices);
        
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.get(i);
            List<Vertice> ligacoes = vertice.getLigacoes();
            
            for (int j = 0; j < ligacoes.size(); j++) {
                
                int vertice_index = ligacoes.get(j).getLocal();
                matriz[i][vertice_index] = 1;
            }
        }
        
        return matriz;
    }
    
    public static int[][] createMatriz(List<Vertice> vertices) {
        int q_vertices = vertices.size();
        
        int[][] matriz = new int[q_vertices][q_vertices];
        
        return matriz;
    }
}
