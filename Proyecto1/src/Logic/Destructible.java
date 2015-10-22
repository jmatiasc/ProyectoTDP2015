package Logic;

import java.util.*;

/**
 * 
 */


public class Destructible extends EstadoPared {

	
    public Destructible(PowerUp p) {
    puntos=10;
       pw=p;
    }

    /**
     * @return
     */
    public boolean destruir() {
        return true;
    }

    /**
     * @param p 
     * @return
     */
    public boolean avanzar(Personaje p) {
        if(p.GetModoDios())
            return true;
        else 
        	return false;
    }
    
    public PowerUp getPowerUp(){
    	return pw;
    }

	@Override
	public int getPuntos() {
		return puntos;
	}

}