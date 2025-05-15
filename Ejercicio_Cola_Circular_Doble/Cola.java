package Ejercicio_Cola_Circular_Doble;

class Cola {
    private Nodo frente;
    private Nodo fondo;

    public Cola() {
        this.frente = null;
        this.fondo = null;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return frente == null;
    }

    // Método para agregar un elemento a la cola (enqueue)
    public void enqueue(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            frente = fondo = nuevoNodo;
        } else {
            fondo.siguiente = nuevoNodo;
            nuevoNodo.anterior = fondo;
            fondo = nuevoNodo;
        }
        System.out.println(dato + " ha sido agregado a la cola.");
    }

    // Método para eliminar un elemento de la cola (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No se puede realizar dequeue.");
            return -1; // Valor indicativo
        }
        int dato = frente.dato;
        frente = frente.siguiente;
        if (frente != null) {
            frente.anterior = null;
        } else {
            fondo = null; // La cola está vacía
        }
        System.out.println(dato + " ha sido eliminado de la cola.");
        return dato;
    }

    // Método para ver el elemento en el frente de la cola (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1; // Valor indicativo
        }
        return frente.dato;
    }

    // Método para imprimir la cola
    public void imprimirCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo actual = frente;
        System.out.print("Cola: ");
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}