/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import geometry.Aresta;
import geometry.Vertice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antony Carlos
 */
public abstract class ArvoreMinima {
    
    /**
     * metodo: getArestas
     * 
     * @param vertices (Vertice)
     * @return List (Aresta)
     * 
     * retorna uma lista sem arestas duplicadas a partir de uma lista de vertices
     */ 
    protected static List<Aresta> getArestas(List<Vertice> vertices){
        List<Aresta> arestas_local = new ArrayList<>();
        
        for (Vertice vertice : vertices) {
            for (Aresta aresta : vertice.getArestas()) {
                if(arestas_local.contains(aresta) == false) {
                    arestas_local.add(aresta);
                }
            }
        }
        
        return arestas_local;
    }
}