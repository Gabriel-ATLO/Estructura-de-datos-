import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcion=0, Elemento=0; 
        Pila pila1 = new Pila();
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Push a la Pila \n"
                        +"2. Sacar un Elemento \n"
                        +"3. La Pila Está Vacia? \n"
                        +"4. Que Elemento Está en la Cima? \n"
                        +"5. Tamaño de la Pila \n"
                        +"6. Vaciar Pila \n"
                        +"7. Salir \n"
                        +"Que Desea Hacer","Menú de Opciones",
                        JOptionPane.INFORMATION_MESSAGE));
                switch (opcion) {
                    case 1:
                        Elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Ingresa el Elemento a Empujar en la Pila","Aplicando Datos",
                        JOptionPane.INFORMATION_MESSAGE));
                        pila1.push(Elemento);
                        break;
                
                    case 2:
                        if (!pila1.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"El Elemento Eliminado es: "
                                    + pila1.pop(),
                                    "Obteniendo Datos de la Pila", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{
                            JOptionPane.showMessageDialog (null,"La Pila Está Vacia",
                                    "Pila Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    
                    case 3:
                        if (pila1.isEmpty()) {
                            JOptionPane.showMessageDialog (null,"La Pila Está Vacia",
                                    "Pila Vacia", JOptionPane.INFORMATION_MESSAGE);
                            
                        }else{
                            JOptionPane.showMessageDialog (null,"La Pila No Está  Vacia",
                                    "La Pila Contiene Datos", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        if (!pila1.isEmpty()) {
                            JOptionPane.showMessageDialog(null,"El Elemento que se Encuentra en la Cima es: " + pila1.peek(),
                                    "Cima de la Pila ", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog (null,"La Pila Está Vacia",
                                    "Pila Vacia", JOptionPane.INFORMATION_MESSAGE);

                        }
                        break;

                    case 5:
                        JOptionPane.showMessageDialog (null,"El Tamaño de la Pila es: " +pila1.tamaño(),
                                    "Tamaño de la Pila", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 6:
                        if (!pila1.isEmpty()) {
                            pila1.lim();
                            JOptionPane.showMessageDialog (null,"La pila se Está Vaciando ",
                                    "Vaciando Pila", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            JOptionPane.showMessageDialog (null,"La Pila Está Vacia, No Hay Nada que Vaciar",
                                    "Pila Vacia", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                        break;

                    case 7:
                        JOptionPane.showMessageDialog (null,"Aplicación Finalizada",
                                    "FIN", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    default:
                        JOptionPane.showMessageDialog (null,"Opción Incorrecta",
                                    "ERROR", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null,"Error" + n.getMessage());
            }
        } while (opcion!=7);
    }

}