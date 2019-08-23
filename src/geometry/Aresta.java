/**
 *
 * @author Antony Carlos
 */
package geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aresta {
    private final Vertice origem, destino;
    private final int peso;
    
    protected Aresta(Vertice origem, Vertice destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
    
    @Override
    public boolean equals(Object obj) {
        if((obj instanceof Aresta)) return false;
        
        Aresta aresta = ((Aresta)obj);
        List<Vertice> test = new ArrayList<>();
        
        test.add(aresta.destino);
        test.add(aresta.origem);
        
        return (test.contains(this.origem) && test.contains(this.destino)) ;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.origem);
        hash = 23 * hash + Objects.hashCode(this.destino);
        hash = 23 * hash + this.peso;
        return hash;
    }
}
