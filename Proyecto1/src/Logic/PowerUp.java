package Logic;

import java.util.*;


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
    public abstract void setUbicacion(Posicion p);

}