package Ejercicio_Recorrido_más_corto_Dijkstra;

import java.util.*;

public class Dijkstra {
    public int[] distancia = new int[10];
    public int[][] costo = new int[10][10];
    
    public void calcular(int n, int s) {
        int[] marca = new int[n+1];
        int i, posMin = 1, k, c, minimo;
        
        for(i = 1; i <= n; i++) {  
            marca[i] = 0; 
            this.distancia[i] = this.costo[s][i]; 
        }
        
        c = 2;
        while(c <= n) {
            minimo = 99;
            for(k = 1; k <= n; k++) { 
                if(this.distancia[k] < minimo && marca[k] != 1) {
                    minimo = this.distancia[i];
                    posMin = k;
                }
            } 
            
            marca[posMin] = 1;
            c++;
            
            for(k = 1; k <= n; k++) {
                if(this.distancia[posMin] + this.costo[posMin][k] < this.distancia[k] && marca[k] != 1) {
                    this.distancia[k] = this.distancia[posMin] + this.costo[posMin][k];
                }
            }   
        } 
    }
    
    public static void main(String args[]) {
        int nodos, fuente, i, j;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese el número de nodos \n");
        nodos = entrada.nextInt();
        
        Dijkstra d = new Dijkstra();
        
        System.out.println("Ingrese los pesos de la matriz: \n");
        for(i = 1; i <= nodos; i++) {
            for(j = 1; j <= nodos; j++) {
                d.costo[i][j] = entrada.nextInt();
                if(d.costo[i][j] == 0) {
                    d.costo[i][j] = 999;
                }
            }
        }
        
        System.out.println("Ingrese el vértice fuente:\n");
        fuente = entrada.nextInt();
        
        d.calcular(nodos, fuente);
        
        System.out.println("Los caminos más cortos desde la fuente \t"+fuente+"\t a todos los demás vértices son: \n");
        for(i = 1; i <= nodos; i++) {
            if(i != fuente) {
                System.out.println("fuente: "+fuente+"\t destino: "+i+"\t Costo mínimo es: "+d.distancia[i]+"\t");
            }
        }
    } 
}