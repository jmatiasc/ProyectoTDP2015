package Logic;

import java.util.*;

/**
 * 
 */
public class Masacrality extends PowerUp {

    /**
     * Default constructor
     */
    public Masacrality(Bomberman b) {
    	super(b);
    }
    /**
     * @param Bomberman b
     */
    public void aumentarVelocidad(){}

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
    public void fullAtributos(){
    	jugador.activarModoDios();
    }
    /**
     * @param Posicion p
     */
    public void setUbicacion(Posicion p){
    	
    	ubicacion=p;
    }

}
