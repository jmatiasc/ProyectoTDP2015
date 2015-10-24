package Logic;

import java.util.*;

/**
 * 
 */
public class Posicion {

    
	protected int ejeX;
    protected int ejeY;
    /**
     * Default constructor
     */
    public Posicion(int x,int y) {
    	ejeX=x;
    	ejeY=y;
    }

    
    /**
     * se retorna a si mismo
     * @return  Posicion 
     */
    public Posicion PosicionActual() {
        return this;
    }

    /**
     * @param int x
     */
    public void setEjeX(int x) {
        ejeX=x;
    }

    /**
     * @param int y
     */
    public void setEjeY(int y) {
        ejeY=y;
    }

   
    
    /**
     * retorna la posicion en x
     * @param int x
     * @return la posicion en x
     */
    public int getEjeX() {
        return ejeX;
    }

    /**
     * retorna la posicion en y
     * @param int y
     * @return la posicion en y
     */
    public int getEjeY() {
        return ejeY;
    }
    
    /**
     * @return true si es igual el estado interno de la posicion pasada por parametro con el que recivio el mensaje , false en caso contrario
     */
    public boolean equals(Posicion p) {
        
        return ejeX==p.getEjeX() && ejeY==p.getEjeY();
    }

}