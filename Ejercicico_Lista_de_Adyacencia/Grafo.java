import java.util.LinkedList;

class Grafo {
    private String nombre;
    private int V; 
    private LinkedList<Object>[] listaAdyacencia; 

    public Grafo(String nombre, int v) {
        this.nombre = nombre;
        this.V = v;
        listaAdyacencia = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    public void agregarArista(int v, Object w) {
        listaAdyacencia[v].add(w); 
    }

    public void imprimirListaAdyacencia() {
        System.out.println("Grafo: " + nombre);
        for (int i = 0; i < V; ++i) {
            System.out.print("Vértice " + i + " está conectado a: ");
            for (Object nodo : listaAdyacencia[i]) {
                System.out.print(nodo + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo("Mi Grafo", 5);

        grafo.agregarArista(0, "A");
        grafo.agregarArista(0, "B");
        grafo.agregarArista(1, "C");
        grafo.agregarArista(1, "D");
        grafo.agregarArista(2, "E");
        grafo.agregarArista(3, "F");
        grafo.agregarArista(4, "G");

        grafo.imprimirListaAdyacencia();
    }
}