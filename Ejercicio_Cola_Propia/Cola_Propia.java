import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Cola_Propia {
    
    private Queue<Integer> cola;

    
    public Cola_Propia() {
        cola = new LinkedList<>();
    }


    public void añadirElementosDesdeTeclado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese números enteros para añadir a la cola (ingrese 'fin' para terminar):");

        while (true) {
            System.out.print("Número: ");
            String entrada = scanner.nextLine();

        
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
            
                int numero = Integer.parseInt(entrada);
                cola.add(numero);
                System.out.println("Número añadido: " + numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        }

        System.out.println("Finalizando la entrada de datos...");
    }


    public void mostrarCola() {
        System.out.println("Contenido de la cola: " + cola);
    }

    
    public static void main(String[] args) {
        Cola_Propia colaDinamica = new Cola_Propia();


        colaDinamica.añadirElementosDesdeTeclado();

        colaDinamica.mostrarCola();
    }
}