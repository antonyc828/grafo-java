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
        Arvore ar;
        
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
        
        //definindo arvore a partir do grafo
        ar = new Arvore(g1);
        
        //imprime a lista de adjacencia da arvore
        String lista_adj = ListaAdjacencia.getListNome(ar);
        
        System.out.println("Arvore Geradora");
        System.out.println(lista_adj);
        
        //define a arvore minima usando kruskal
        Arvore ar_minima_kruskal =  Kruskal.getArvoreMinima(ar);
        
        //imprime a lista de adjacencia da arvore minima
        String list_adj_ar_min_kruskal = ListaAdjacencia.getListNome(ar_minima_kruskal);
        
        System.out.println("Arvore minima - kruskal");
        System.out.println(list_adj_ar_min_kruskal);
    }
}
