package EXA;

class Nodo{
    int info;
    Nodo sig;
    Nodo ant;

    public Nodo(int x) {
        info = x;
        sig = ant =null;
    }
}
