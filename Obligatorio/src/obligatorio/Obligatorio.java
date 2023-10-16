package obligatorio;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;


public class Obligatorio {
    

    public static void main(String[] args) {
        iniciarJuego();
    }

  

 public static void iniciarJuego(){
     Scanner in = new Scanner(System.in);

        System.out.print("¿Deseas jugar? (S/N): ");

        String jugar = in.nextLine();
        
        System.out.println("¡Bienvenido a Soliflips!");

        if (jugar.equalsIgnoreCase("S")) {
            System.out.println("Selecciona una opción:");
            System.out.println("a) Tomar datos del archivo 'datos.txt'");
            System.out.println("b) Usar un tablero predefinido");
            System.out.println("c) Usar un tablero al azar");
            
            
            
            String opcion = in.nextLine();
            switch (opcion) {
                case "a":
                    Tablero.jugarConArchivo();
                    break;
                case "b":
                    Tablero.jugarConTableroPredefinido();
                    break;
                case "c":
                    System.out.print("Ingrese la cantidad de filas: ");
                    int filas = in.nextInt();
                    
                    while(filas < 3 || filas > 9){
                        System.out.println("Ingrese cantidad de filas nuevamente (de 3 a 9):");
                        filas = in.nextInt();
                    }
                    //Tablero tablero = new Tablero();
                    //tablero.setFilas(filas);
                    
                    System.out.print("Ingrese la cantidad de columnas: ");
                    int cols = in.nextInt();
                    
                    while(cols < 3 || cols > 9){
                        System.out.println("Ingrese cantidad de columnas nuevamente (de 3 a 9):");
                        cols = in.nextInt();
                    }
                    //tablero.setColumnas(cols);
                    
                    System.out.print("Ingrese el nivel (1 a 8): ");
                    int nivel = in.nextInt();
                    
                    while(nivel < 1 || nivel > 8){
                        System.out.println("Ingrese el nivel nuevamente (de 1 a 8):");
                        nivel = in.nextInt();
                    }
                    //tablero.setNivel(nivel);
                    Tablero.generarTableroAleatorio(filas, cols, nivel);
                    
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Hasta luego.");
        }
 }
    
   
}





