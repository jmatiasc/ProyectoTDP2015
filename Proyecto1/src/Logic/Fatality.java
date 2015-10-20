package Logic;

import java.util.*;

/**
 * 
 */
public class Fatality extends PowerUp {

    /**
     * Default constructor
     */
    public Fatality(Bomberman b) {
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
    	jugador.aumentarAlcance();
    }
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
    public void setUbicacion(Posicion p){
    	ubicacion=p;
    }

}
