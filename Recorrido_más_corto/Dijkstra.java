import java.util.Scanner;

public class Dijkstra {
    private int[] distance;
    private int[][] cost;
    private boolean[] visited;

    public void calc(int n, int s) {
        distance = new int[n];
        visited = new boolean[n];

        // Inicializar distancias
        for (int i = 0; i < n; i++) {
            distance[i] = cost[s][i];
            visited[i] = false;
        }

        distance[s] = 0; // La distancia a sí mismo es 0
        visited[s] = true;

        // Aplicar el algoritmo de Dijkstra
        for (int c = 1; c < n; c++) {
            int min = Integer.MAX_VALUE;
            int minPos = -1;

            // Buscar el nodo con menor distancia no visitado
            for (int k = 0; k < n; k++) {
                if (!visited[k] && distance[k] < min) {
                    min = distance[k];
                    minPos = k;
                }
            }

            visited[minPos] = true;

            // Actualizar distancias
            for (int k = 0; k < n; k++) {
                if (!visited[k] && cost[minPos][k] != Integer.MAX_VALUE && distance[minPos] + cost[minPos][k] < distance[k]) {
                    distance[k] = distance[minPos] + cost[minPos][k];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int nodes = in.nextInt();

        Dijkstra d = new Dijkstra();
        d.cost = new int[nodes][nodes];

        System.out.println("Enter the cost matrix weights:");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                d.cost[i][j] = in.nextInt();
                if (i != j && d.cost[i][j] == 0) {
                    d.cost[i][j] = Integer.MAX_VALUE; // Representa el infinito
                }
            }
        }

        System.out.print("Enter the source vertex (0 to " + (nodes - 1) + "): ");
        int source = in.nextInt();

        d.calc(nodes, source);

        System.out.println("\nThe shortest path from source " + source + " to all other vertices is:");
        for (int i = 0; i < nodes; i++) {
            if (i != source) {
                if (d.distance[i] == Integer.MAX_VALUE) {
                    System.out.println("Source: " + source + " -> Destination: " + i + " is unreachable");
                } else {
                    System.out.println("Source: " + source + " -> Destination: " + i + " MinCost: " + d.distance[i]);
                }
            }
        }

        in.close();
    }
}
