package Logic;

import java.util.*;

/**
 * Clase Destructible
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */

	

public class Destructible extends EstadoPared {
	/**
	 * Constructor de la clase Destructible
	 * @param p PowerUp a asignar.
	 */
		protected Enemigo enemigo;
		protected Bomberman bomberman;
		
    public Destructible(PowerUp p) {
    	puntos = 10;
    	pw = p;
    }

    /**
     * Consulta la cantidad de puntos a otorgar.
     */
    public int destruir() {
    	if(enemigo!=null)
        return puntos+enemigo.getPuntos();
    	else return puntos;
    }

    /**
     * Consulta si es posible avanzar.
     * @return true si es posible, false en caso contrario.
     */
    public boolean avanzar(Personaje p) {
        if(p.GetModoDios())
            return true;
        else 
        	return false;
    }
    
    /**
     * Consulta el PowerUp asociado a la pared.
     */
    public PowerUp getPowerUp(){
    	return pw;
    }

	/**
	 * Consulta los puntos que otorga la pared.
	 */
	public int getPuntos() {
		return puntos;
	}

	public boolean setEnemigo(Enemigo e) 
    {
        if(enemigo==null )
        {
        	enemigo = e;
        	return true;    	
        }
        else 
        	if(enemigo!=null && e==null)
        	{
        		enemigo = null;
        	}
        return false;
    }
	

}