package Ejercicio_Pila_Doble;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        Pila pila = new Pila();

        // Operaciones con la pila
        System.out.print("Ingrese el número de elementos a agregar a la pila: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            int elemento = scanner.nextInt();
            pila.push(elemento);
        }

        // Imprimir el estado de la pila
        pila.imprimirPila();

        // Mostrar el elemento en la cima
        System.out.println("Elemento en la cima: " + pila.peek());

        // Eliminar elementos de la pila
        System.out.println("Eliminando elementos de la pila:");
        while (!pila.isEmpty()) {
            pila.pop();
        }

        pila.imprimirPila();

        System.out.println("¿La pila está vacía? " + pila.isEmpty());
    }
}