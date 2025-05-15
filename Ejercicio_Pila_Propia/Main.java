package Ejercicio_Pila_Propia;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Pila pilaPostfija = new Pila();

        while (true) {
            try {
                String expresion = JOptionPane.showInputDialog(null,
                        "Ingrese la expresión postfija a evaluar (ej. 3 4 +)\n"
                        + "O presione Cancelar para salir.",
                        "Evaluar Expresión Postfija", JOptionPane.INFORMATION_MESSAGE);

                if (expresion == null) {
                    JOptionPane.showMessageDialog(null, "Aplicación Finalizada",
                            "FIN", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }

                try {
                    int resultado = pilaPostfija.evaluarPostfija(expresion.replaceAll("\\s+", ""));
                    JOptionPane.showMessageDialog(null, "El resultado de la expresión es: " + resultado,
                            "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al evaluar la expresión: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}