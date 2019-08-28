/**
 *
 * @author Antony Carlos
 */
package logic;

import geometry.Aresta;
import geometry.Arvore;
import geometry.Vertice;
import java.util.ArrayList;
import java.util.List;

public abstract class ArvoreMinima{
    
    /**
     * metodo: getMinima
     * 
     * @param arestas List 
     * @return arvoreMinima (Arvore)
     * 
     * retorna uma arvore minima a partir de uma arvore geradora
     */
    public static Arvore getMinima(List<Aresta> arestas){
        List<Aresta> arestas_usadas = new ArrayList<>();
        List<Vertice> vertices_arvore = new ArrayList<>();
        
        Arvore arvore_retorno = new Arvore();
        arvore_retorno.setVertices(vertices_arvore);
        
        for (int i = 0; i < arestas.size(); i++) {
            boolean exist_ciclo = false;
            Aresta a_local = arestas.get(i);
            Vertice temporario_o = a_local.getOrigem();
            Vertice temporario_d = a_local.getDestino();
            
            Vertice origem_local = getOnList(arestas_usadas, a_local.getOrigem().getNome());
            Vertice destino_local = getOnList(arestas_usadas, a_local.getDestino().getNome());
            
            //verifica se dois vertices possuem ligaçao em comum
            if((origem_local != null && destino_local != null)){
                exist_ciclo = verificarCiclo(origem_local, destino_local);
            }
            
            //verifica se o vertice origem ja foi utilizado antes
            if(origem_local == null){
                origem_local = new Vertice(temporario_o.getLocal(), temporario_o.getNome());
            }
            
            //verifica se o vertice destino ja foi utilizado antes
            if(destino_local == null){
                destino_local = new Vertice(temporario_d.getLocal(), temporario_d.getNome());
            }
            
            //impede a criacao da ligacao caso formem um ciclo
            if(exist_ciclo == false){
                origem_local.setLigacao(origem_local, destino_local, a_local.getPeso());
                destino_local.setLigacao(origem_local, destino_local, a_local.getPeso());
                
                Aresta aresta_usada = new Aresta(origem_local, destino_local, a_local.getPeso());
                
                arestas_usadas.add(aresta_usada);
                
                //impede adicao de itens ja existentes na lista de vertices
                if(!vertices_arvore.contains(origem_local)){
                    vertices_arvore.add(origem_local);
                }
                if(!vertices_arvore.contains(destino_local)){
                    vertices_arvore.add(destino_local);
                }
            }
        }
        
        return arvore_retorno;
    }
    
    /**
     * metodo: verificarCiclo
     * 
     * @param v1
     * @param v2
     * @return existeCiclo (boolean)
     * 
     * verifica se dois vertices possuem uma ligacao em comum com outro vertice
     */
    private static boolean verificarCiclo(Vertice v1, Vertice v2){
        
        for (Vertice v1_vertice : v1.getLigacoes()) {
            List<Vertice> ligacoes = v2.getLigacoes();
            
//            if(ligacoes.contains(v1_vertice)){
//                return true;
//            }
            
            for (Vertice v2_vertice : v2.getLigacoes()) {
                if(v1_vertice.equals(v2_vertice)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * metodo: getOnList
     * 
     * @param arestas_usadas (List <Aresta>)
     * @param nome (String)
     * @return vertice (Vertice)
     * 
     * retorna um vertice a partir de um nome especifico e de uma lista de arestas
     */
    private static Vertice getOnList(List<Aresta> arestas_usadas, String nome){
        
        for (Aresta aresta : arestas_usadas) {
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();
            
            
            if(origem.getNome().equals(nome)){
                return origem;
            }
            
            else if(destino.getNome().equals(nome)){
                return destino;
            }
        }
        
        return null;
    }
    
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