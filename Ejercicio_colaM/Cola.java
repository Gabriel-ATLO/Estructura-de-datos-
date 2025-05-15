package Ejercicio_colaM;

public class Cola {
    Nodo inicio;
    Nodo fin;
    int tama;

    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.tama = 0;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void glue(int elem) {
        Nodo nuevo = new Nodo(elem);
        if (isEmpty()) {
            inicio = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tama++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        int auxiliar = inicio.dato;
        inicio = inicio.siguiente;
        tama--;
        if (isEmpty()) {
            fin = null;
        }
        return auxiliar;
    }

    public int iniciocola() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        return inicio.dato;
    }

    public int tamacola() {
        return tama;
    }
}