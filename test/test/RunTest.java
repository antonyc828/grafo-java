/**
 *
 * @author Antony Carlos
 */
package test;

import geometry.Grafo;
import java.util.Arrays;
import logic.Isomorfismo;
import logic.ListaAdjacencia;
import logic.MatrizAdjacencia;

public class RunTest {

    public static void main(String[] args) {
        Grafo grafo1 = new Grafo(5);
        Grafo grafo2 = new Grafo(5);
        
        //definindo as arestas que ligam cada vertice do grafo 1
        grafo1.setLigacao(0, 1);
        grafo1.setLigacao(0, 4);
        grafo1.setLigacao(0, 3);
        
        grafo1.setLigacao(1, 2);
        
        grafo1.setLigacao(2, 4);
        grafo1.setLigacao(2, 3);
        
        //definindo as arestas que ligam cada vertice do grafo 2
        grafo2.setLigacao(0, 1);
        grafo2.setLigacao(0, 3);
        
        grafo2.setLigacao(1, 2);
        grafo2.setLigacao(1, 4);
        
        grafo2.setLigacao(2, 1);
        grafo2.setLigacao(2, 3);
        
        grafo2.setLigacao(3, 4);
        
        //verificar isomorfismo entre grafo1 e grafo2
        boolean comparacao = Isomorfismo.isIsomorfic(grafo1, grafo2);
        System.out.println("Os Grafos 1 e 2 são isomorfos? "+comparacao);
        
        System.out.println("");
        
        //Caracteristicas Grafo 2 <---
        System.out.println("Grafo 1");
        
        //lista de adjacencia do grafo 1
        String l_adj_grafo1 = ListaAdjacencia.getList(grafo1);
        System.out.println(l_adj_grafo1);
        
        //matriz de adjacencia Grafo 1 <--
        int[][] m_adj_grafo1 = MatrizAdjacencia.getMatriz(grafo1);
        
        //print da matriz de adjacendia grafo2
        for (int[] linha : m_adj_grafo1) {
            System.out.println(Arrays.toString(linha));
        }
        
        System.out.println("\n");
        
        //Caracteristicas Grafo 2 <---
        System.out.println("Grafo 2");
        //lista de adjacencia do grafo2
        String l_adj_grafo2 = ListaAdjacencia.getList(grafo2);
        System.out.println(l_adj_grafo2);
        
        //matriz de adjacencia grafo2
        int[][] m_adj_grafo2 = MatrizAdjacencia.getMatriz(grafo2);
        
        //print da matriz de adjacendia grafo2
        for (int[] linha : m_adj_grafo2) {
            System.out.println(Arrays.toString(linha));
        }
    }
}
