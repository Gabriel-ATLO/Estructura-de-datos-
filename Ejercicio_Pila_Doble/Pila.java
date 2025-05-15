package Ejercicio_Pila_Doble;

class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return cima == null;
    }

    // Método para agregar un elemento a la pila (push)
    public void push(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (!isEmpty()) {
            cima.siguiente = nuevoNodo;
            nuevoNodo.anterior = cima;
        }
        cima = nuevoNodo;
        System.out.println(dato + " ha sido agregado a la pila.");
    }

    // Método para eliminar un elemento de la pila (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía. No se puede realizar pop.");
            return -1; // Valor indicativo
        }
        int dato = cima.dato;
        cima = cima.anterior;
        if (cima != null) {
            cima.siguiente = null;
        }
        System.out.println(dato + " ha sido eliminado de la pila.");
        return dato;
    }

    // Método para ver el elemento en la cima de la pila (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return -1; // Valor indicativo
        }
        return cima.dato;
    }

    // Método para imprimir la pila
    public void imprimirPila() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        Nodo actual = cima;
        System.out.print("Pila (de cima a base): ");
        while (actual != null) {
            System.out.print(actual.dato + " <- ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}