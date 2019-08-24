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

public abstract class Kruskal extends ArvoreMinima{

    @Override
    public Arvore getMinima() {
        return null;
    }
    
    public static Arvore setMinima(Arvore arvore){
        List<Aresta> arestas = sort(arvore.getVertices());
        List<Aresta> arestas_usadas = new ArrayList<>();
        List<Vertice> vertices_arvore = new ArrayList<>();
        
        Arvore arvore_retorno = new Arvore();
        
        for (int i = 0; i < arestas.size(); i++) {
            boolean exist_ciclo = false;
            Aresta a_local = arestas.get(i);
            Vertice temporario_o = a_local.getOrigem();
            Vertice temporario_d = a_local.getDestino();
            
            Vertice origem_local = getOnList(arestas_usadas, a_local.getOrigem().getNome());
            Vertice destino_local = getOnList(arestas_usadas, a_local.getDestino().getNome());
            
            if((origem_local != null && destino_local != null)){
                exist_ciclo = verificarCiclo(origem_local, destino_local);
            }
            if(origem_local == null){
                origem_local = new Vertice(temporario_o.getLocal(), temporario_o.getNome());
            }
            if(destino_local == null){
                destino_local = new Vertice(temporario_d.getLocal(), temporario_d.getNome());
            }
            if(exist_ciclo == false){
                origem_local.setLigacao(origem_local, destino_local, a_local.getPeso());
                destino_local.setLigacao(origem_local, destino_local, a_local.getPeso());
                
                Aresta aresta_usada = new Aresta(origem_local, destino_local, a_local.getPeso());
                
                arestas_usadas.add(aresta_usada);
                if(!vertices_arvore.contains(origem_local)){
                    vertices_arvore.add(origem_local);
                }
                if(!vertices_arvore.contains(destino_local)){
                    vertices_arvore.add(destino_local);
                }
            }
        }
        
        arvore_retorno.setVertices(vertices_arvore);
        
        return arvore_retorno;
    }
    
    private static boolean verificarCiclo(Vertice v1, Vertice v2){
        for (Vertice v1_vertice : v1.getLigacoes()) {
            for (Vertice v2_vertice : v2.getLigacoes()) {
                if(v1_vertice == v2_vertice){
                    return true;
                }
            }
        }
        
        return false;
    }
    
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
