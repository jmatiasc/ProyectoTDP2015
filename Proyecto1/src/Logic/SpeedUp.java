package Logic;

import java.util.*;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * Default constructor
     */
    public SpeedUp(Bomberman b) {
    	super(b);
    }

    /**
     * @param Bomberman b
     */
    public void aumentarVelocidad(){
    	jugador.aumentarVelocidad();
    }

    /**
     * @param Bomberman b
     */
    public void duplicarAlcance(){}
    /**
     * @param Bomberman b
     */
    public void aumentarCantidadBombas(){}
    /**
     * @param Bomberman b
     */
    public void fullAtributos(){}
    /**
     * @param Posicion p
     */

	@Override
	public void setPosicion(Posicion p) {
		super.setPosicion(p);
		
	}

}