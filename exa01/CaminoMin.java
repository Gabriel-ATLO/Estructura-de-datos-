import java.util.*;

class Nodo implements Comparable<Nodo> {
    int vertice, peso;

    public Nodo(int vertice, int peso) {
        this.vertice = vertice;
        this.peso = peso;
    }

    @Override
    public int compareTo(Nodo otro) {
        return Integer.compare(this.peso, otro.peso);
    }
}

public class CaminoMin {
    private static final int INF = Integer.MAX_VALUE;
    private static List<List<Nodo>> grafo = new ArrayList<>();
    private static int[] distancias;
    private static int[] predecesores;

    public static void dijkstra(int inicio) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>();
        distancias[inicio] = 0;
        cola.add(new Nodo(inicio, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            int u = actual.vertice;

            if (actual.peso > distancias[u]) continue;

            for (Nodo adyacente : grafo.get(u)) {
                int v = adyacente.vertice;
                int peso = adyacente.peso;

                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    predecesores[v] = u;
                    cola.add(new Nodo(v, distancias[v]));
                }
            }
        }
    }

    public static List<Integer> obtenerCamino(int destino) {
        List<Integer> camino = new ArrayList<>();
        for (int v = destino; v != -1; v = predecesores[v])
            camino.add(v);
        Collections.reverse(camino);
        return camino;
    }

    public static void main(String[] args) {
        int n = 6; // Nodos del 0 al 5
        distancias = new int[n];
        predecesores = new int[n];
        Arrays.fill(distancias, INF);
        Arrays.fill(predecesores, -1);

        for (int i = 0; i < n; i++) grafo.add(new ArrayList<>());

        // Grafo según el problema
        grafo.get(0).add(new Nodo(1, 2));
        grafo.get(0).add(new Nodo(2, 4));
        grafo.get(1).add(new Nodo(3, 1));
        grafo.get(1).add(new Nodo(4, 4));
        grafo.get(2).add(new Nodo(3, 2));
        grafo.get(3).add(new Nodo(4, 1));
        grafo.get(4).add(new Nodo(5, 2));
        grafo.get(3).add(new Nodo(5, 4));
        grafo.get(1).add(new Nodo(5, 8));

        dijkstra(0);

        List<Integer> camino = obtenerCamino(5);
        System.out.println("Camino mínimo de A a B: " + camino);
        System.out.println("Distancia mínima: " + distancias[5]);
    }
}
