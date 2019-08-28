/**
 *
 * @author Antony Carlos
 */
package test;

import geometry.Arvore;
import logic.Kruskal;
import logic.ListaAdjacencia;

public class TesteCidades {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        
        
        //adicionando cidades
        arvore.addVertice("Nanuque");
        arvore.addVertice("Montes Claros");
        arvore.addVertice("Unai");
        arvore.addVertice("Patos de minas");
        arvore.addVertice("Uberlandia");
        arvore.addVertice("Belo Horizonte");
        arvore.addVertice("JuiNz de Fora");
        
        //adicionando rotas
        arvore.setLigacao("Juiz de Fora", "Belo Horizonte", 300);
        arvore.setLigacao("Belo Horizonte", "Montes Claros", 350);
        arvore.setLigacao("Belo Horizonte", "Nanuque", 600);
        arvore.setLigacao("Belo Horizonte", "Unai", 650);
        arvore.setLigacao("Belo Horizonte", "Patos de minas", 400);
        arvore.setLigacao("Montes Claros", "Nanuque", 250);
        arvore.setLigacao("Unai", "Patos de minas", 200);
        arvore.setLigacao("Patos de minas", "Uberlandia", 280);
        
        //gerando minima a partir de kruskal
        Arvore ar_minima_kruskal =  Kruskal.getArvoreMinima(arvore);
        
        //imprime a lista de adjacencia da arvore minima
        String list_adj_ar_min_kruskal = ListaAdjacencia.getListNome(ar_minima_kruskal);
        
        System.out.println("Arvore minima - kruskal\n");
        System.out.println(list_adj_ar_min_kruskal);
    }
}
