package Ejercicio_Árboles;

public class Main {
    public static void main(String[] args) {
        ArbolBinario<String> arbol = new ArbolBinario<>();
        
        arbol.insertar("Alice", 5);
        arbol.insertar("Bob", 3);
        arbol.insertar("Charlie", 7);
        arbol.insertar("David", 2);
        arbol.insertar("Eve", 4);
        arbol.insertar("Frank", 6);
        arbol.insertar("Grace", 8);
        
        System.out.println("Preorden:");
        arbol.preorden();
        
        System.out.println("Inorden:");
        arbol.inorden();
        
        System.out.println("Postorden:");
        arbol.postorden();
        
        System.out.println("Existe ID 4? " + arbol.existe(4));
        System.out.println("Existe ID 10? " + arbol.existe(10));
        
        System.out.println("Elemento con ID 5: " + arbol.obtener(5));
        
        arbol.eliminar(3);
        System.out.println("Inorden después de eliminar 3:");
        arbol.inorden();
        
        System.out.println("Es hoja? " + arbol.esHoja());
        System.out.println("Está vacío? " + arbol.esVacio());
    }
} 