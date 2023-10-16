
package obligatorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Juego {

    public Tablero tablero;
    private long inicioPartida;
    //private int minutos;
    //private int segundos;
    
    
    public Juego(Tablero tablero, long inicioPartida) {
      this.tablero = tablero;
      this.inicioPartida = inicioPartida;
    }
    
    @Override
    public String toString(){
        return "El juego duró un tiempo total de " + getInicioPartida() + " miniutos";
    }

    public Tablero getTablero() {
        return tablero;
    }

    public long getInicioPartida() {
        return inicioPartida;
    }

   

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setInicioPartida(long inicioPartida) {
        this.inicioPartida = inicioPartida;
    }
    
    
    

    public static void jugarPartida(Tablero tablero) {
        
    long inicioPartida = System.currentTimeMillis();
        
    Juego juego = new Juego(tablero, inicioPartida);
        
    Scanner in = new Scanner(System.in);
    boolean juegoTerminado = false;

    int numFilas = tablero.getFilas();
    int numCols = tablero.getColumnas();

    
    while (!juegoTerminado) {
        // Imprimir el tablero actualizado con los colores
        
        System.out.println("Realiza un movimiento (fila columna) o ingresar letra: ");
        String movimiento = in.nextLine();
        
        //Movimiento mov = new Movimiento();
        
        if (movimiento.equalsIgnoreCase("X")) {
            juegoTerminado = true;
            tiempoTotal(juego);
            Obligatorio.iniciarJuego();
            
        } else if (movimiento.equalsIgnoreCase("H")) {
            Movimiento.mostrarHistoriaMovimientos(tablero.movimientos);
            
        } else if (movimiento.equalsIgnoreCase("S")) {
            Movimiento.obtenerSolucion(tablero);
            
        } else {
            if (Movimiento.validarMovimiento(movimiento, tablero)) {

                Movimiento.realizarMovimiento(movimiento, tablero);
                
                Tablero.imprimirDosTableros(tablero, tabero);
                
                 if(juegoResuelto(tablero)){
                     juegoTerminado = true;
                     tiempoTotal(juego);
                     Obligatorio.iniciarJuego();
                 }
                
            } else {
                       
                if(movimiento.equalsIgnoreCase("-1 -1")){
                    Movimiento.retrocederMovimiento(tablero.movimientos, tablero);
                    
                    Tablero.imprimirDosTableros(tablero, tabero);
                    
                } else{
                    System.out.println("Movimiento inválido. Intente nuevamente.");
                    
                }
                
            }
        }  
        
}
    }
    
    
    public static void tiempoTotal(Juego juego){
        
        long inicioPartida = juego.getInicioPartida();
        long finPartida = System.currentTimeMillis(); 

        long duracionMillis = finPartida - inicioPartida;
        long duracionSegundos = duracionMillis / 1000;
        long minutos = duracionSegundos / 60;
        long segundos = duracionSegundos % 60;

        System.out.println("Juego terminado. Duración: " 
            + minutos + " minutos " 
            + segundos + " segundos.");
    }    
    
    public static boolean juegoResuelto(Tablero tablero){
        
        boolean estaResuelto = true;
        boolean hayRojo = false;
        boolean hayAzul = false;
        
        int filas = tablero.getFilas();
        int cols = tablero.getColumnas();
        
        for(int i = 0; i < filas && estaResuelto; i++){
            for(int j = 0; j < cols && estaResuelto; j++){
                Celda celda = tablero.celda[i][j];
                
                if(celda.getColor().equals(Celda.ANSI_RED)){
                    hayRojo = true;
                } else{
                    hayAzul = true;
                }
                
                if(hayRojo && hayAzul){
                    estaResuelto = false;
                }
                
            }
        }
    return estaResuelto;
    }
    

}

    

    


