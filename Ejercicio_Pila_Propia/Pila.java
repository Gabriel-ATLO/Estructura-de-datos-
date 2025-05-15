package Ejercicio_Pila_Propia;

class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    private void push(int elem) {
        Nodo nuevoNodo = new Nodo(elem);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    private int pop() {
        if (cima == null) {
            throw new RuntimeException("La pila está vacía");
        }
        int auxiliar = cima.dato;
        cima = cima.siguiente;
        return auxiliar;
    }

    public int evaluarPostfija(String expresion) {
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isDigit(c)) {
                push(c - '0'); 
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int operando2 = pop();
                int operando1 = pop();
                int resultado = 0;

                switch (c) {
                    case '+':
                        resultado = operando1 + operando2;
                        break;
                    case '-':
                        resultado = operando1 - operando2;
                        break;
                    case '*':
                        resultado = operando1 * operando2;
                        break;
                    case '/':
                        resultado = operando1 / operando2;
                        break;
                }
                push(resultado);
            }
        }
        return pop();
    }
}