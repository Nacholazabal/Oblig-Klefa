package obligatorio;

import java.util.ArrayList;
import java.util.List;


public class Movimiento {
    private int movFila;
    private int movCol;

    public Movimiento(int movFila, int movCol) {
        this.movFila = movFila;
        this.movCol = movCol;
    }
    
    public Movimiento(){
    
    }

    public int getMovFila() {
        return movFila;
    }

    public int getMovCol() {
        return movCol;
    }

    public void setMovFila(int movFila) {
        this.movFila = movFila;
    }

    public void setMovCol(int movCol) {
        this.movCol = movCol;
    }

    @Override
    public String toString() {
        return "(" +  movFila + ", " + movCol + ")";
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Movimiento otroMovimiento = (Movimiento) obj;
    return movFila == otroMovimiento.movFila && movCol == otroMovimiento.movCol;
}

        /*
    
      public static boolean validarMovimiento(String movimiento, int numFilas, int numCols) {
        String[] partes = movimiento.split(" ");
        if (partes.length != 2) {
            return false;
        }

        try {
            int fila = Integer.parseInt(partes[0]) - 1;
            int columna = Integer.parseInt(partes[1]) - 1;

            return fila >= 0 && fila < numFilas && columna >= 0 && columna < numCols;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    */
    
     public static boolean validarMovimiento(String movimiento, Tablero tablero) {
         
         boolean movimientoValido = false;

        if(movimiento.length() == 5){
             int fila = movimiento.charAt(1) - '0';
             int col = movimiento.charAt(3) - '0';  
             
            if(movimiento.charAt(0) == '(' && movimiento.charAt(4) == ')' && movimiento.charAt(2) == ',' && fila <= tablero.getFilas() && fila > 0 && col <= tablero.getColumnas() && fila > 0){
                 movimientoValido = true;
            }
        } 
        
         
         
         return movimientoValido;
     }
      

    public static void realizarMovimiento(String movimiento, Tablero tablero) {
        
        int fila = (movimiento.charAt(1) - '0') - 1;
        int col = (movimiento.charAt(3) - '0') - 1;
        
        //String[] partes = movimiento.split(" ");
        
        //int fila = Integer.parseInt(partes[0]) - 1;  // Restamos 1 para convertir a índice base-0
        //int col = Integer.parseInt(partes[1]) - 1;  // Restamos 1 para convertir a índice base-0
        
        Movimiento mov = new Movimiento(fila + 1, col + 1);      
        tablero.movimientos.add(mov);
        

        switch (tablero.celda[fila][col].getSimbolo()) {
            case "|":
                Celda.cambiarColumna(fila, col, tablero);
                break;
            case "-":
                Celda.cambiarFila(fila, col, tablero);
                break;
            case "/":
                Celda.cambiarDiagonal1(fila, col, tablero);
                break;
            case "\\":
                Celda.cambiarDiagonal2(fila, col, tablero);
                break;
        }
        
    }
    
    
        public static void mostrarHistoriaMovimientos(ArrayList <Movimiento> movimientos) {
        System.out.println("Historia de Movimientos:");
        for (Movimiento movimiento : movimientos) {
            System.out.println(movimiento);
        }
    }
        
        
        
        public static void retrocederMovimiento(ArrayList <Movimiento> movimientos, Tablero tablero){
            
            if(movimientos.isEmpty()){
                System.out.println("No se puede retroceder más movimientos");
            
            } else {
                
                Movimiento mov = movimientos.get(movimientos.size()-1);

                int fila = mov.movFila - 1;           
                int col = mov.movCol - 1;           
             
                switch (tablero.celda[fila][col].getSimbolo()) {              
                case "|":
                    Celda.cambiarColumna(fila, col, tablero);
                    break;
                case "-":
                    Celda.cambiarFila(fila, col, tablero);
                    break;
                case "/":
                    Celda.cambiarDiagonal1(fila, col, tablero);
                    break;
                case "\\":
                    Celda.cambiarDiagonal2(fila, col, tablero);
                    break;
                }      
            
                movimientos.remove(movimientos.size()-1);
         
                System.out.println("Se retrocedió un movimiento");
            
            
            }

        }
        
        public static void obtenerSolucion(Tablero tablero){
            ArrayList<Movimiento> movimientos = tablero.movimientos;
            ArrayList<Movimiento> solucion = tablero.solucionMovimientos;
            ArrayList<Movimiento> pasosADar = new ArrayList<>();
            
            boolean movIncorrecto = false;
            
            if(movimientos.isEmpty()){
                mostrarSecuenciaMovimientos(solucion);
            } else {
                for(int i = 0; i < movimientos.size() && !movIncorrecto; i++){
                    
                    if(!solucion.get(i).equals(movimientos.get(i))){
                        pasosADar.clear();
                        System.out.println(solucion.get(i));
                        System.out.println(movimientos.get(i));
                        
                        for(int j = 0; j < movimientos.size() - i; j++){
                            Movimiento mov = new Movimiento(-1, -1);
                            pasosADar.add(mov);
                        }
                    
                        for(int k = i; k < solucion.size(); k++){
                            pasosADar.add(solucion.get(k));
                        }
                        
                        movIncorrecto = true;
                        
                    } else{
                        pasosADar.clear();
                        for(int k = i+1; k < solucion.size(); k++){
                            pasosADar.add(solucion.get(k));
                        }
                    }
                    
                    
                }
            mostrarSecuenciaMovimientos(pasosADar);
            
            }
        }

    public static void mostrarSecuenciaMovimientos(ArrayList<Movimiento> pasosADar) {
        System.out.println("Secuencia de Movimientos para Solución:");
        for (Movimiento movimiento : pasosADar) {
            System.out.println(movimiento);
        }
    }
    
}
