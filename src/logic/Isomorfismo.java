/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Grafo;
import geometry.Vertice;
import java.util.ArrayList;
import java.util.List;

public abstract class Isomorfismo {
    
    public static boolean isIsomorfic(Grafo grafo1, Grafo grafo2) {
        List<Integer> v_ligacoes_g1 = getListByConnections(grafo1);
        List<Integer> v_ligacoes_g2 = getListByConnections(grafo2);
        
        //retorna false, caso o numero de vertices seja diferente
        if(v_ligacoes_g1.size() != v_ligacoes_g2.size()) return false;

        //retorna false, caso o numero de arestas por vertice seja diferente
        for(int i = 0; i < v_ligacoes_g1.size(); i++) {
            
            int index_vertice_g1 = v_ligacoes_g1.get(i);
            int index_vertice_g2 = v_ligacoes_g2.get(i);
            
            if(!(index_vertice_g1 == index_vertice_g2)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * metodo: getListByConnections
     * 
     * @param grafo
     * @return List <Integer>
     * 
     * retorna uma lista do numero de conexoes de cada vertice do grafo
     * retorna uma lista em ordem crescente
     */
    private static List<Integer> getListByConnections(Grafo grafo) {
        List<Vertice> vertices = grafo.getVertices();
        List<Integer> v_organizados = new ArrayList<>();
        
        //adiciona em v_organizados o numero de arestas de cada vertice
        for (int i = 0; i < vertices.size(); i++) {
            Vertice vertice = vertices.get(i);
            
            v_organizados.add(vertice.getLigacoes().size());
        }
        
        //organiza em ordem crescente
        v_organizados.sort((Object o1, Object o2) -> {
            Integer valor1 = (Integer) o1;
            Integer valor2 = (Integer) o2;
            
            return valor1.compareTo(valor2);
        });
        
        return v_organizados;
    }
}