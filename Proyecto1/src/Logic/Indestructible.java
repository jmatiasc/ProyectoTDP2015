package Logic;

import java.util.*;

/**
 * 
 */
public class Indestructible extends EstadoPared {

    /**
     * Default constructor
     */
    public Indestructible() {
    	puntos=0;
    	pw=null;
    }

    /**
     * @return
     */
    public boolean destruir() {
        
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public boolean avanzar(Personaje p) {
        return false;
    }

    public PowerUp getPowerUp(){
    	return pw;
    }

	@Override
	public int getPuntos() {
		
		return 0;
	}

}