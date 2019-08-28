/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Aresta;
import geometry.Arvore;
import geometry.Vertice;
import java.util.List;

public abstract class Kruskal {
    
    
    public static Arvore getArvoreMinima(Arvore arvore){
        List<Aresta> arestas = sort(arvore.getVertices());
        Arvore arvore_minima = ArvoreMinima.getMinima(arestas);
        
        return arvore_minima;
    }
    
    /**
     * metodo: sort
     * @param vertices (List<Vertice>)
     * @return List <Aresta>
     * 
     * retorna uma lista de arestas em ordem crescente com base no peso
     * retorna uma lista de arestas que n possui arestas duplicadas
     */
    private static List<Aresta> sort(List<Vertice> vertices){
        
        //remove objetos duplicados
        List<Aresta> arestas = ArvoreMinima.getArestas(vertices);
        
        //organizar em peso crescente
        arestas.sort((Object o1, Object o2) -> {
            Aresta aresta1 = (Aresta) o1;
            Aresta aresta2 = (Aresta) o2;
            
            Integer peso1 = aresta1.getPeso();
            Integer peso2 = aresta2.getPeso();
            
            return peso1.compareTo(peso2);
        });
        
        return arestas;
    }
}
