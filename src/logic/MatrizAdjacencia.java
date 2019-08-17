/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Grafo;
import geometry.Vertice;
import java.util.Arrays;
import java.util.List;

public abstract class MatrizAdjacencia {
    
    public static int[][] getMatriz(Grafo grafo){
        List<Vertice> vertices = grafo.getVertices();
        int[][] matriz = createMatriz(vertices);
        
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.get(i).getLigacoes().size(); j++) {
                int vertice_index = vertices.get(i).getLigacoes().get(j).getLocal();
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
