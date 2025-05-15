package EXA;

public class Lista {
    Nodo raiz;
    
    public Lista() {
    raiz = null;
    }

    public void insertar(int x, int b) {
        Nodo temp = new Nodo(x);
        if (raiz == null) raiz=temp;
        else {
            Nodo aux=raiz;
            while(aux!=null && aux.info!=b)
            aux=aux.sig;
            if (aux.sig==null) {
            aux.sig=temp;
            temp.ant=aux;
        }
        else {
            aux.sig.ant= temp;
            temp.sig = aux.sig;
            aux.sig=temp;
            temp.ant=aux;
        }
    }
}
    public void mostrar(){
        Nodo aux=raiz;
        while(aux!=null) {
            System.out.print(aux.info+" ");
            aux=aux.sig;
        }
    }

    public static void main(String []args){
        Lista L = new Lista();
        L.insertar(8,4);
        L.insertar(12,8);
        L.insertar(5,8);
        L.mostrar();
    }
}
