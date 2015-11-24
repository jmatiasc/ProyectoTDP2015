package Logic;

import java.util.*;

/**
 * Clase Rugulus
 * 
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Rugulus extends Enemigo {

	/**
	 * inicializa la velocidad en 1 y ubicacion con p
	 * 
	 * @param Posicion
	 *            p
	 */
	public Rugulus(Posicion p, Tablero t) {
		super(t);
		ubicacion = p;
		velocidad = 32;
		modoDios = false;
		puntos = 15;
	}

}