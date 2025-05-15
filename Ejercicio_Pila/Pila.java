

class Pila {
    private Nodo cima;
    int tama;

    public Pila() {
        this.cima = null;
        this.tama = 0;      
    }

    public boolean isEmpty() {
        return cima == null;
    }

    public void push(int elem) {
        Nodo nuevoNodo = new Nodo(elem);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tama++;
        System.out.println(elem + " ha sido agregado a la pila.");
    }

    public int pop() {
        int auxiliar = cima.dato;
        cima = cima.siguiente;
        tama--;
        System.out.println(auxiliar + " ha sido eliminado de la pila.");
        return auxiliar;
    }

    public int peek() {
        return cima.dato;
    }

    public int tamaño(){
        return tama;
    }

    public void lim(){
        while (!isEmpty()) {
            pop();
        }
    }
}