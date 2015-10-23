package Logic;

import java.util.*;

/**
 * 
 */
public abstract class EstadoPared {
	
	protected int puntos;
	protected PowerUp pw;
    /**
     * Default constructor
     */
    public EstadoPared() {
    }
    /**
     * @return
     */
    public abstract int destruir();

    /**
     * @param p 
     * @return
     */
    public abstract boolean avanzar(Personaje p);

    /**
     * @return
     */
    public abstract int getPuntos();

    public abstract PowerUp getPowerUp();
    

    
}