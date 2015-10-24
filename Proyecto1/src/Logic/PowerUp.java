package Logic;

import java.util.*;

/**
 * Clase PowerUp
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public abstract class PowerUp {

	protected Posicion ubicacion;
	protected Bomberman jugador;
	
    public PowerUp(Bomberman b) {
    	jugador=b;
    }

    

    /**
     * @param Bomberman b
     */
    public abstract void aumentarVelocidad();

    /**
     * @param Bomberman b
     */
    public abstract void duplicarAlcance();

    /**
     * @param Bomberman b
     */
    public abstract void aumentarCantidadBombas();

    /**
     * @param Bomberman b
     */
    public abstract void fullAtributos();

    /**
     * @param Posicion p
     */
    public void setPosicion(Posicion p){
    	ubicacion=p;
    }

    /**
     * retorna el atributo ubicacion 
     * @return Posicion
     */
    public Posicion getPosicion(){return ubicacion;}
    
}