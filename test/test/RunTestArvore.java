/**
 *
 * @author Antony Carlos
 */
package test;

import geometry.Arvore;
import geometry.Grafo;
import logic.Kruskal;
import logic.ListaAdjacencia;

public class RunTestArvore {
    public static void main(String[] args) {
        Grafo g1 = new Grafo();
        Arvore ar = new Arvore(g1);
        
        //adiciona vertices ao grafo
        g1.addVertice("A");
        g1.addVertice("B");
        g1.addVertice("C");
        g1.addVertice("D");
        g1.addVertice("E");
        g1.addVertice("F");
        
        //define as arestas dos vertices
        g1.setLigacao("A", "B", 2);
        g1.setLigacao("A", "C", 2);
        g1.setLigacao("D", "C", 2);
        g1.setLigacao("A", "F", 8);
        g1.setLigacao("D", "E", 1);
        g1.setLigacao("B", "F", 6);
        
        //imprime a lista de adjacencia da arvore
        String lista_adj = ListaAdjacencia.getListNome(ar);
        System.out.println(lista_adj);
        
        //define a arvore minima
        Arvore ar_minima =  Kruskal.getMinima(ar);
        
        //imprime a lista de adjacencia da arvore minima
        String lista_adj_ar_minima = ListaAdjacencia.getListNome(ar_minima);
        System.out.println(lista_adj_ar_minima);
    }
}
