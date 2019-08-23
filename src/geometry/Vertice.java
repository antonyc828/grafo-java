/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private final List<Aresta> arestas;
    private List<Vertice> ligacoes;
    private final int local_vertice;
    private String nome;
    private boolean isAdd;
    
    protected Vertice(int local){
        this.arestas = new ArrayList<>();
        this.local_vertice = local;
        this.isAdd = true;
    }
    
    protected Vertice(int local, String nome){
        this(local);
        this.nome = nome;
    }
    
    protected void setLigacao(Vertice vertice, int peso) {
        Aresta nova_aresta = new Aresta(this, vertice, peso);
        this.arestas.add(nova_aresta);
        
        this.isAdd = true;
    }
    
    public List<Vertice> getLigacoes(){
        if(this.isAdd == true) {
            ArrayList<Vertice> ligacoes_local = new ArrayList<>();

            for (Aresta aresta : arestas) {
                ligacoes_local.add(aresta.getDestino());
            }
            
            this.ligacoes = ligacoes_local;
            this.isAdd = false;
        }
        return this.ligacoes;
    }
    
    public List<Aresta> getArestas() {
        return this.arestas;
    }
    
    public int getLocal(){
        return this.local_vertice;
    }

    public String getNome() {
        if(nome == null) return "Undefined";
        
        return nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Vertice)) return false;
        
        Vertice vertice = (Vertice)obj;
        
        return (vertice.getLocal() == this.local_vertice);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.local_vertice;
        return hash;
    }
}
