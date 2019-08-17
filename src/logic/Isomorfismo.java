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
            if(!(v_ligacoes_g1.get(i).equals(v_ligacoes_g2.get(i)))) return false; 
        }
        
        return true;
    }
    
    private static List<Integer> getListByConnections(Grafo grafo1) {
        List<Vertice> vertices = grafo1.getVertices();
        List<Integer> v_organizados = new ArrayList<>();
        
        //adiciona em v_organizados o numero de arestas de cada vertice
        for (int i = 0; i < vertices.size(); i++) {
            v_organizados.add(vertices.get(i).getLigacoes().size());
        }
        
        //organiza em ordem crescente
        v_organizados.sort((Object o1, Object o2) -> {
            Integer c1 = (Integer) o1;
            Integer c2 = (Integer) o2;
            return c1.compareTo(c2);
        });
        
        return v_organizados;
    }
}