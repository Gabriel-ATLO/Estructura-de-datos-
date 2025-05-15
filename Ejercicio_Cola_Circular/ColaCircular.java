class ColaCircular {
    private Nodo frente;
    private Nodo fondo;

    public ColaCircular() {
        this.frente = null;
        this.fondo = null;
    }


    public boolean isEmpty() {
        return frente == null;
    }


    public void enqueue(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (isEmpty()) {
            frente = fondo = nuevoNodo;
            fondo.siguiente = frente; 
        } else {
            fondo.siguiente = nuevoNodo;
            fondo = nuevoNodo;
            fondo.siguiente = frente; 
        }
        System.out.println(dato + " ha sido agregado a la cola circular.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía. No se puede realizar dequeue.");
            return -1;
        }
        int dato = frente.dato;
        if (frente == fondo) { 
            frente = fondo = null;
        } else {
            frente = frente.siguiente;
            fondo.siguiente = frente; 
        }
        System.out.println(dato + " ha sido eliminado de la cola circular.");
        return dato;
    }

    
    public int peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return -1; 
        }
        return frente.dato;
    }

  
    public void imprimirCola() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo actual = frente;
        System.out.print("Cola Circular: ");
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != frente);
        System.out.println("(retorna al frente)");
    }
}