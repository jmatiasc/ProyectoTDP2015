package Logic;

import java.util.*;

/**
 * Clase Altair
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Altair extends Enemigo {
	/**
     * Constructor de Altair.
     * Inicializa el tablero de Enemigo.
     * 
     */
	public Altair(Tablero t) {
		super(t);
	}
	
	/**
	 * Inicializa los atributos de Altair.
	 * @param t Tablero en donde se encuentra Altair.
	 * @param p Posición de Altair en el tablero.
	 */
	public void Altair(Tablero t,Posicion p) {
        ubicacion=p;
        velocidad=32;
        modoDios=true;
    }
}