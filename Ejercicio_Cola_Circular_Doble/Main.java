package Ejercicio_Cola_Circular_Doble;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Cola cola = new Cola();

        // Operaciones con la cola
        System.out.print("Ingrese el número de elementos a agregar a la cola: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int elemento = scanner.nextInt();
            cola.enqueue(elemento);
        }

        // Imprimir el estado de la cola
        cola.imprimirCola();

        // Mostrar el elemento en el frente
        System.out.println("Elemento en el frente: " + cola.peek());

        // Eliminar elementos de la cola
        System.out.println("Eliminando elementos de la cola:");
        while (!cola.isEmpty()) {
            cola.dequeue();
        }

        cola.imprimirCola();

        System.out.println("¿La cola está vacía? " + cola.isEmpty());
    }
}
