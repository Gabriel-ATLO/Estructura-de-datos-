package Ejercicio_Tabla_Hash;

import java.util.HashMap;
import java.util.Scanner;

class Persona {
    private String id;
    private String nombre;
    private int edad;

    public Persona(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Edad: " + edad;
    }
}

public class TablaHash {
    public static void main(String[] args) {
        HashMap<String, Persona> tablaPersonas = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ TABLA HASH ---");
            System.out.println("1. Agregar nueva persona");
            System.out.println("2. Buscar persona por ID");
            System.out.println("3. Mostrar todas las personas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar nueva persona
                    System.out.print("\nIngrese el ID de la persona: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la edad: ");
                    int edad = scanner.nextInt();
                    
                    tablaPersonas.put(id, new Persona(id, nombre, edad));
                    System.out.println("Persona agregada correctamente!");
                    break;

                case 2:
                    // Buscar persona por ID
                    System.out.print("\nIngrese el ID a buscar: ");
                    String idBuscar = scanner.nextLine();
                    
                    Persona personaEncontrada = tablaPersonas.get(idBuscar);
                    if (personaEncontrada != null) {
                        System.out.println("\nPERSONA ENCONTRADA:");
                        System.out.println(personaEncontrada);
                    } else {
                        System.out.println("No se encontró ninguna persona con el ID: " + idBuscar);
                    }
                    break;

                case 3:
                    // Mostrar todas las personas
                    System.out.println("\nLISTA COMPLETA DE PERSONAS:");
                    if (tablaPersonas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        for (Persona p : tablaPersonas.values()) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
