/**
 *
 * @author Antony Carlos
 */
package test;

import geometry.Grafo;
import logic.ListaAdjacencia;

public class RunTestArvore {
    public static void main(String[] args) {
        Grafo g1 = new Grafo();
        
        g1.addVertice("A");
        g1.addVertice("B");
        g1.addVertice("C");
        g1.addVertice("D");
        g1.addVertice("E");
        g1.addVertice("F");
        
        g1.setLigacao("A", "B", 3);
        g1.setLigacao("A", "C", 3);
        g1.setLigacao("D", "C", 3);
        g1.setLigacao("A", "F", 3);
        g1.setLigacao("D", "E", 3);
        g1.setLigacao("B", "F", 3);
        
        String lista_adj = ListaAdjacencia.getListNome(g1);
        
        System.out.println(lista_adj);
    }
}
