import java.util.Scanner;

public class Grafos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de nodos: ");
        int numNodos = scanner.nextInt();

        if (numNodos > 26) {
            System.out.println("El número de nodos no puede ser mayor a 26.");
            return;
        }

        int[][] matrizAdyacencia = new int[numNodos][numNodos];

        System.out.println("Ingrese las conexiones entre los nodos (1 si hay conexión, 0 si no hay conexión):");
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                char nodoOrigen = (char) ('A' + i); 
                char nodoDestino = (char) ('A' + j); 
                System.out.print("¿Hay conexión entre el nodo " + nodoOrigen + " y el nodo " + nodoDestino + "? (1/0): ");
                matrizAdyacencia[i][j] = scanner.nextInt();
            }
        }

        
        System.out.println("\nMatriz de Adyacencia:");
        System.out.print("  ");
        for (int i = 0; i < numNodos; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < numNodos; i++) {
            System.out.print((char) ('A' + i) + " "); 
            for (int j = 0; j < numNodos; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}