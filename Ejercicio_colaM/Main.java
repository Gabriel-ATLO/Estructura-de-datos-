package Ejercicio_colaM;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int ops = 0, Elemento = 0;
        Cola cola1 = new Cola();

        do {
            try {
                ops = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Insertar un elemento a la Cola\n"
                        + "2. Quitar un Elemento de la Cola\n"
                        + "3. La Cola está Vacía?\n"
                        + "4. Elemento ubicado al inicio de la Cola\n"
                        + "5. Tamaño de la Cola\n"
                        + "6. Salir", "Menú de Opciones",
                        JOptionPane.QUESTION_MESSAGE));
                switch (ops) {
                    case 1:
                        Elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el Elemento a Empujar en la Cola", "Aplicando Datos",
                                JOptionPane.INFORMATION_MESSAGE));
                        cola1.glue(Elemento);
                        break;

                    case 2:
                        if (!cola1.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El elemento atendido es: " + cola1.dequeue(),
                                    "Quitando elemento de la cola", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola está vacía",
                                    "Cola Vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 3:
                        if (cola1.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La cola está vacía",
                                    "Cola Vacía", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola no está vacía",
                                    "Cola no vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        if (!cola1.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El elemento ubicado al inicio de la cola es: " + cola1.iniciocola(),
                                    "Elemento al inicio", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola está vacía",
                                    "Cola Vacía", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 5:
                        JOptionPane.showMessageDialog(null, "El tamaño de la cola es: " + cola1.tamacola(),
                                "Tamaño de la cola", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Aplicación Finalizada",
                                "FIN", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción Incorrecta",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (ops != 6);
    }
}