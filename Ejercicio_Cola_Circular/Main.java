public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        ColaCircular cola = new ColaCircular();

    
        System.out.print("Ingrese el número de elementos a agregar a la cola circular: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int elemento = scanner.nextInt();
            cola.enqueue(elemento);
        }

    
        cola.imprimirCola();

    
        System.out.println("Elemento en el frente: " + cola.peek());

    
        System.out.println("Eliminando elementos de la cola circular:");
        while (!cola.isEmpty()) {
            cola.dequeue();
        }

        cola.imprimirCola();

        System.out.println("¿La cola está vacía? " + cola.isEmpty());
    }
}
