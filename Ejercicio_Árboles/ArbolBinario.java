package Ejercicio_Árboles;

class Nodo<T extends Comparable<T>> {
    T dato;
    int id;
    Nodo<T> izquierdo;
    Nodo<T> derecho;

    public Nodo(T dato, int id) {
        this.dato = dato;
        this.id = id;
        this.izquierdo = null;
        this.derecho = null;
    }
}

public class ArbolBinario<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(T dato, int id) {
        raiz = insertarRec(raiz, dato, id);
    }

    private Nodo<T> insertarRec(Nodo<T> nodo, T dato, int id) {
        if (nodo == null) {
            return new Nodo<>(dato, id);
        }

        if (id < nodo.id) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, dato, id);
        } else if (id > nodo.id) {
            nodo.derecho = insertarRec(nodo.derecho, dato, id);
        }

        return nodo;
    }

    public boolean existe(int id) {
        return existeRec(raiz, id);
    }

    private boolean existeRec(Nodo<T> nodo, int id) {
        if (nodo == null) {
            return false;
        }

        if (id == nodo.id) {
            return true;
        }

        return id < nodo.id ? existeRec(nodo.izquierdo, id) : existeRec(nodo.derecho, id);
    }

    public T obtener(int id) {
        Nodo<T> nodo = obtenerRec(raiz, id);
        return (nodo != null) ? nodo.dato : null;
    }

    private Nodo<T> obtenerRec(Nodo<T> nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id == nodo.id) {
            return nodo;
        }

        return id < nodo.id ? obtenerRec(nodo.izquierdo, id) : obtenerRec(nodo.derecho, id);
    }

    public boolean esHoja() {
        return raiz != null && raiz.izquierdo == null && raiz.derecho == null;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.id + ":" + nodo.dato + " ");
            preordenRec(nodo.izquierdo);
            preordenRec(nodo.derecho);
        }
    }

    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo<T> nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.print(nodo.id + ":" + nodo.dato + " ");
            inordenRec(nodo.derecho);
        }
    }

    public void postorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo<T> nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierdo);
            postordenRec(nodo.derecho);
            System.out.print(nodo.id + ":" + nodo.dato + " ");
        }
    }

    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    private Nodo<T> eliminarRec(Nodo<T> nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (id < nodo.id) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, id);
        } else if (id > nodo.id) {
            nodo.derecho = eliminarRec(nodo.derecho, id);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            nodo.id = minimoValor(nodo.derecho);
            nodo.dato = obtener(nodo.id);
            
            nodo.derecho = eliminarRec(nodo.derecho, nodo.id);
        }

        return nodo;
    }

    private int minimoValor(Nodo<T> nodo) {
        int min = nodo.id;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.id;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    public int compareTo(ArbolBinario<T> otro) {
        return Integer.compare(this.contarNodos(), otro.contarNodos());
    }

    private int contarNodos() {
        return contarNodosRec(raiz);
    }

    private int contarNodosRec(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodosRec(nodo.izquierdo) + contarNodosRec(nodo.derecho);
    }
}
