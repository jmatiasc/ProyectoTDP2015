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
     * @return el atributo modoDios
     */
    public Boolean GetModoDios() {
        
        return modoDios;
    }

    /**
     * inserta el elemento p en el atributo ubicacion
     * @param p de tipo posicion
     */
    public void setPosicion(Posicion p){ubicacion=p;}
    
}