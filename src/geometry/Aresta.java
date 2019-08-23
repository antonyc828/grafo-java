/**
 *
 * @author Antony Carlos
 */
package geometry;

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
}
