package Logic;

import java.util.*;

/**
 * 
 */
public abstract class Personaje {

	protected boolean modoDios;
	protected Posicion ubicacion;
    /**
     * Default constructor
     */
    public Personaje() {
    }
    /**
     * @return
     */
    public Boolean GetModoDios() {
        
        return modoDios;
    }

    public void setPosicion(Posicion p){ubicacion=p;}
    
}