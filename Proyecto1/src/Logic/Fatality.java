package Logic;

import java.util.*;

/**
 * Clase Fatality
 * @author Bernabe - Cabrera - Paez 
 */
public class Fatality extends PowerUp
{
    /**
     * Constructor
     * @param b Bomberman
     */
    public Fatality(Bomberman b) 
    {
    	super(b);
    	puntos=35;
    }
    
    /**
     * Aumenta la velocidad del Bomberman
     */
    public void aumentarVelocidad()
    {}

    /**
     * Duplica el alcance de la explosión de la bomba del personaje principal
     */
    public void duplicarAlcance()
    {
    	jugador.aumentarAlcance();
    }
    
    /**
     * Aumenta la cantidad de bombas que el personaje principal puede colocar
     */
    public void aumentarCantidadBombas()
    {}
    
    /**
     * La cantidad de bombas de Bomberman será ilimitada, podrá atravesar paredes 
     * y será inmune a los malos y las explosiones
     */
    public void fullAtributos()
    {}
    
    /**
     * Establece la posición del powerup Fatality
     * @param Posicion p posición del powerup Fatality
     */
    public void setPosicion(Posicion p) 
    {
    	super.setPosicion(p);	
	}
}
