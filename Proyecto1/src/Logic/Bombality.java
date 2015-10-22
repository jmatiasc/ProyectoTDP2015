package Logic;

import java.util.*;

/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * Default constructor
     */
    public Bombality(Bomberman b) {
    	super(b);
    }
    /**
     * @param Bomberman b
     */
    public void aumentarVelocidad(){}

    /**
     * @param Bomberman b
     */
    public void duplicarAlcance(){
    	
    }
    /**
     * @param Bomberman b
     */
    public void aumentarCantidadBombas(){
    	jugador.aumentarCantBombas();
    }
    /**
     * @param Bomberman b
     */
    public void fullAtributos(){}
    /**
     * @param Posicion p
     */
    public void setPosicion(Posicion p) {
    	super.setPosicion(p);
		
	}

}