package Logic;

import java.util.*;

/**
 * 
 */
public class Posicion {

    /**
     * Default constructor
     */
	protected int ejeX;
    protected int ejeY;
    public Posicion(int x,int y) {
    	ejeX=x;
    	ejeY=y;
    }

    public Posicion PosicionActual() {
        return this;
    }

    /**
     * @param int x
     */
    public void setEjeX(int x) {
        // TODO implement here
    }

    /**
     * @param int y
     */
    public void setEjeY(int y) {
        // TODO implement here
    }

   
    
    /**
     * @param int x
     */
    public int getEjeX() {
        return ejeX;
    }

    /**
     * @param int y
     */
    public int getEjeY() {
        return ejeY;
    }
    
    /**
     * @return
     */
    public boolean equals(Posicion p) {
        
        return ejeX==p.getEjeX() && ejeY==p.getEjeY();
    }

}