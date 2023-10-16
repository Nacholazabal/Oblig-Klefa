package obligatorio;

public class Celda {
    private String simbolo;
    private String color;
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public Celda() {
        this.simbolo = "";
        this.color = "";
    }
    
    public Celda(String unSimbolo, String unColor){
        this.simbolo = unSimbolo;
        this.color = unColor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getColor() {
        return color;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
  @Override
    public String toString() {
    
    return color + simbolo + ANSI_RESET;
}


    // Métodos para cambiar los colores de las diagonales, fila o columna
    public static void cambiarDiagonal1(int fila, int columna, Tablero tablero) {
        int numFilas = tablero.getFilas();
        int numCols = tablero.getColumnas();

       for(int i = 0; i < numFilas; i++){
           for(int j = 0; j < numCols; j++){
               int diferenciaFilas = i-fila;
               int diferenciaCols = j - columna;
               
               if((diferenciaFilas != diferenciaCols) && (Math.abs(i-fila) == Math.abs(j - columna))){
                   if(tablero.celda[i][j].getColor().equals(Celda.ANSI_RED)){
                       tablero.celda[i][j].setColor(ANSI_BLUE);
                   } else {
                       tablero.celda[i][j].setColor(ANSI_RED);
                   }
               }
           }
       }       
    }

    public static void cambiarDiagonal2(int fila, int columna, Tablero tablero) {
        int numFilas = tablero.getFilas();
        int numCols = tablero.getColumnas();

       for(int i = 0; i < numFilas; i++){
           for(int j = 0; j < numCols; j++){
               int diferenciaFilas = i-fila;
                   int diferenciaCols = j - columna;
               
               if(diferenciaFilas == diferenciaCols){
                   if(tablero.celda[i][j].getColor().equals(Celda.ANSI_RED)){
                       tablero.celda[i][j].setColor(ANSI_BLUE);
                   } else {
                       tablero.celda[i][j].setColor(ANSI_RED);
                   }
               }
           }
       }       
    }


    
    

    public static void cambiarFila(int fila, int columna, Tablero tablero) {
        int numFilas = tablero.getFilas();
        int numCols = tablero.getColumnas();

        for(int i = 0; i < numFilas; i++){
            for(int j = 0; j < numCols; j++){
                
                 if(i == fila){
                   if(tablero.celda[i][j].getColor().equals(Celda.ANSI_RED)){
                       tablero.celda[i][j].setColor(ANSI_BLUE);
                   } else {
                       tablero.celda[i][j].setColor(ANSI_RED);
                   }
               }
            }
        }
      
    }

    public static void cambiarColumna(int fila, int columna, Tablero tablero) {
        int numFilas = tablero.getFilas();
        int numCols = tablero.getColumnas();

        for(int i = 0; i < numFilas; i++){
            for(int j = 0; j < numCols; j++){
                
                 if(j == columna){
                   if(tablero.celda[i][j].getColor().equals(Celda.ANSI_RED)){
                       tablero.celda[i][j].setColor(ANSI_BLUE);
                   } else {
                       tablero.celda[i][j].setColor(ANSI_RED);
                   }
               }
            }
        }
      
    }
}
