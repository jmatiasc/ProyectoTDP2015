package Logic;

import java.util.*;


public abstract class Enemigo extends Personaje {

   
    protected Posicion ubicacion;
    protected int velocidad;
    protected int puntos;
    protected Tablero tablero;
    
    public Enemigo() {
    }
    /**
     * modifica la ubicacion del enemigo y ademas actualiza su posicion en tablero
     */
    public void mover() {
        // TODO implement here
    }
    public void matarBomberman() {
        // TODO implement here
    }
    /**
     * mata al enemigo, ubicacion=null
     */
    public void destruir() {
        // TODO implement here
    }

    public int getPuntos() {
        // TODO implement here
        return 0;
    }

}