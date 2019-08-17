/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private final List<Vertice> ligacoes;
    private final int local_vertice;
    
    public Vertice(int local){
        this.ligacoes = new ArrayList<>();
        this.local_vertice = local;
    }
    
    public void setLigacao(Vertice vertice) {
        this.ligacoes.add(vertice);
    }
    
    public List<Vertice> getLigacoes(){
        return this.ligacoes;
    }
    
    public int getLocal(){
        return this.local_vertice;
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
