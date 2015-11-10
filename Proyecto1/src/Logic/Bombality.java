package Logic;

import java.util.*;

/**
 * Clase Bombality
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Bombality extends PowerUp {
    /**
     * Constructor de la clase Bombality
     * Asigna Bomberman a la clase Powerup.
     */
	public Bombality(Bomberman b) {
    	super(b);
    	puntos=35;
    }
    
    /**
     * Aumenta la velocidad del bomberman.
     */
    public void aumentarVelocidad(){}

    /**
     * Duplica el alcance del bomberman.
     */
    public void duplicarAlcance(){
    	
    }
    
    /**
     * Aumenta la cantidad de bombas.
     */
    public void aumentarCantidadBombas(){
    	jugador.aumentarCantBombas();
    }
    
    /**
     * Atributos
     */
    public void fullAtributos(){}
    
    /**
     * Setea la posición del PowerUp.
     */
    public void setPosicion(Posicion p) {
    	super.setPosicion(p);
	}

}