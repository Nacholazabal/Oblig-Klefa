package obligatorio;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static obligatorio.Celda.ANSI_BLUE;
import static obligatorio.Celda.ANSI_RED;

public class Tablero {
    private int filas;
    private int cols;
    private int nivel;
    public Celda[][] celda;
    public ArrayList <Movimiento> movimientos = new ArrayList();
    public ArrayList <Movimiento> solucionMovimientos = new ArrayList();
    
     public Tablero() {
        celda = new Celda[filas][cols];
        movimientos = new ArrayList();
        solucionMovimientos = new ArrayList();
    }
    
    public Tablero(int filas, int cols, int nivel){
        this.filas = filas;
        this.cols = cols;
        this.nivel = nivel;
        celda  = new Celda[filas][cols];
        movimientos = new ArrayList();
        solucionMovimientos = new ArrayList();
    }
    
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return cols;
    }

    public int getNivel() {
        return nivel;
    }

    public Celda[][] getCelda() {
        return celda;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.cols = columnas;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setCelda(Celda[][] celda) {
        this.celda = celda;
    }
    
    @Override 
    public String toString(){
        return "El tablero tiene " + getFilas() + " filas y " + getColumnas() + " , con un nivel de " + getNivel();
    }
    
    
    
    public static void jugarConArchivo() {

    try {
        Scanner archivoInput = new Scanner(new File(".\\Test\\datos.txt"));

        // Lee el número de filas y columnas
        int cantFilas = archivoInput.nextInt();
        
        int cantCols = archivoInput.nextInt();
       
        // Valida que coincidan con el tablero del juego
        if (cantFilas < 3 || cantFilas > 9 || cantCols < 3 || cantCols > 9) {
            System.out.println("El tamaño del tablero en el archivo no está dentro del rango permitido.");
            return;
        }

        Tablero tablero = new Tablero(cantFilas, cantCols, 0);
        

        // Leer el contenido del tablero del archivo
        for (int i = 0; i < tablero.filas; i++) {
            for (int j = 0; j < tablero.cols; j++) {
                String simbolos = archivoInput.next();
                String simbolo = String.valueOf(simbolos.charAt(0));
                String color = String.valueOf(simbolos.charAt(1));
                
                
                tablero.celda[i][j] = new Celda();             
                

                if (color.equals("R")) {
                    tablero.celda[i][j].setColor(ANSI_RED);
                    tablero.celda[i][j].setSimbolo(simbolo);
                    
                } else {
                    tablero.celda[i][j].setColor(ANSI_BLUE);
                    tablero.celda[i][j].setSimbolo(simbolo);
                   
                }
            }
        }
        
        int nivel = archivoInput.nextInt();
        tablero.setNivel(nivel);
        
        while(archivoInput.hasNextInt()){
            int fila = archivoInput.nextInt();
            int col = archivoInput.nextInt();
            
            Movimiento movimiento = new Movimiento(fila, col);
            tablero.solucionMovimientos.add(movimiento);
            
        }
        
        
        imprimirTablero(tablero);
        Juego.jugarPartida(tablero);

    } catch (Exception e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }

    
}
    
    
    
    public static void jugarConTableroPredefinido(){       
        Tablero tablero = new Tablero(5, 6, 3);
                                  
       for(int i = 0; i < tablero.filas; i++){
           for(int j = 0; j < tablero.cols; j++){
              
               tablero.celda[i][j] = new Celda();
               
           if(i == 0){
               
               if(j == 0 || j == 1 || j == 4){
                   tablero.celda[i][j].setSimbolo("|");
               } else if(j == 2 || j == 5){
                   tablero.celda[i][j].setSimbolo("-");
               } else{
                   tablero.celda[i][j].setSimbolo("/");
               }
               
               if(j == 0 || j == 1 || j == 3){
                   tablero.celda[i][j].setColor(ANSI_BLUE); 
               } else{
                   tablero.celda[i][j].setColor(ANSI_RED); 
               }
               
           }
           
           if(i == 1){
               
               if(j == 0 || j == 4 || j == 5){
                   tablero.celda[i][j].setSimbolo("-");
               } else if(j == 1 || j == 2){
                   tablero.celda[i][j].setSimbolo("/");
               } else{
                   tablero.celda[i][j].setSimbolo("|");
               }
               
               if(j == 1 || j == 2 || j == 3){
                   tablero.celda[i][j].setColor(ANSI_BLUE); 
               } else{
                   tablero.celda[i][j].setColor(ANSI_RED); 
               }
           }
           
           if(i == 2){
               
               if(j == 0 || j == 1 || j == 3 || j == 5){
                   tablero.celda[i][j].setSimbolo("-");
               } else if(j == 2){
                   tablero.celda[i][j].setSimbolo("|");
               } else{
                   tablero.celda[i][j].setSimbolo("/");
               }
               
              if(j == 2){
                   tablero.celda[i][j].setColor(ANSI_BLUE); 
               } else{
                   tablero.celda[i][j].setColor(ANSI_RED); 
               }
           
           }
           
           if(i == 3){
               
               if(j == 0 || j == 3){
                   tablero.celda[i][j].setSimbolo("\\");
               } else if(j == 2 || j == 4 || j == 5){
                   tablero.celda[i][j].setSimbolo("|");
               } else{
                   tablero.celda[i][j].setSimbolo("-");
               }
               
               if(j == 4){
                   tablero.celda[i][j].setColor(ANSI_BLUE); 
               } else{
                   tablero.celda[i][j].setColor(ANSI_RED); 
               }
           
           }
           
           if(i == 4){
               
               if(j == 0 || j == 5){
                   tablero.celda[i][j].setSimbolo("\\");
               } else if(j == 1 || j == 2 || j == 4){
                   tablero.celda[i][j].setSimbolo("/");
               } else{
                   tablero.celda[i][j].setSimbolo("|");
               }
               
               if(j == 3 || j == 4 || j == 5){
                   tablero.celda[i][j].setColor(ANSI_BLUE); 
               } else{
                   tablero.celda[i][j].setColor(ANSI_RED); 
               }
           }
           
           
           }
       }
       
       Movimiento movimiento1 = new Movimiento(4, 4);
       tablero.solucionMovimientos.add(movimiento1);
       
       Movimiento movimiento2 = new Movimiento(5, 6);
       tablero.solucionMovimientos.add(movimiento2);
       
       Movimiento movimiento3 = new Movimiento(5, 4);
       tablero.solucionMovimientos.add(movimiento3);
         
        imprimirTablero(tablero);
        Juego.jugarPartida(tablero);
    }

    
    public static void generarTableroAleatorio(int filas, int cols, int nivel){
        Random random = new Random();
        String[] simbolos = {"/", "\\", "-", "|"};
        String[] colores = {Celda.ANSI_RED, Celda.ANSI_BLUE};
        int randomColorIndex = random.nextInt(colores.length); // Da un color aleatorio
        String color = colores[randomColorIndex];
        
        Tablero tablero = new Tablero(filas, cols, nivel);
        
        
        
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < cols; j++){
                
                int randomSimboloIndex = random.nextInt(simbolos.length); // Da un simbolo aleatorio 
                
                String simbolo = simbolos[randomSimboloIndex];
                

                tablero.celda[i][j] = new Celda(simbolo, color);
            }
        }
        
          //Hacer movimientos para crear un tablero al azar según el nivel:
        
        while(nivel > 0){
            int randomFila = random.nextInt(tablero.filas);
            int randomCol = random.nextInt((tablero.cols));
            
            boolean mismoMov = false;
            Movimiento movimiento = new Movimiento(randomFila + 1, randomCol + 1);
            
            for(int i = 0; i < tablero.movimientos.size(); i++){
                if(movimiento.equals(tablero.movimientos.get(i))){
                    mismoMov = true;
                }
            }
            
            if(!mismoMov){
            
                Celda celda = tablero.celda[randomFila][randomCol];
                String simbolo = celda.getSimbolo();
            
            
                tablero.solucionMovimientos.add(movimiento);
            
                switch (simbolo) {
                    case "/":                    
                        Celda.cambiarDiagonal1(randomFila, randomCol, tablero);
                        break;
            
                    case "\\":
                        Celda.cambiarDiagonal2(randomFila, randomCol, tablero);
                        break;
            
                    case "-":
                        Celda.cambiarFila(randomFila, randomCol, tablero);
                        break;
           
                    case "|":
                        Celda.cambiarColumna(randomFila, randomCol, tablero);
                        break;
                    default:
                        break;
                }
            
                nivel--;
            } 
        }
        
        System.out.println(tablero.solucionMovimientos);
        imprimirTablero(tablero);
        Juego.jugarPartida(tablero);
    }
    
    

       
    public static void imprimirTablero(Tablero tablero) {
    
    System.out.print("    "); 
    for (int col = 1; col <= tablero.cols; col++) {
        System.out.print(col + "   "); 
    }
    System.out.println();
    
    
    System.out.print("  "); 
    for (int j = 0; j < tablero.cols; j++) {
        System.out.print("+---");
    }
    System.out.println("+");
    
    for (int i = 0; i < tablero.filas; i++) {
        System.out.print((i+1) + " "); 
        
        System.out.print("| "); 
        for (int j = 0; j < tablero.cols; j++) {
            System.out.print(tablero.celda[i][j] + " | ");
        }
        System.out.println(); 

        
        System.out.print("  "); 
        for (int j = 0; j < tablero.cols; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }
} 
    
    
}
