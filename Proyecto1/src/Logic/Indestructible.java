package Logic;

import java.util.*;

/**
 * Clase Indestructible
 * 
 * @author Bernabe - Cabrera - Paez
 */
public class Indestructible extends EstadoPared {

	/**
	 * Constructor
	 */
	public Indestructible(Tablero t) {
		super(t);
		puntos = 0;
		pw = null;
	}

	/**
	 * Si es posible destruye una pared y devuelve el puntaje de su destrucción
	 * 
	 * @return puntos si la pared es indestructible devuelve 0
	 */
	public int destruir() {
		return 0;
	}

	/**
	 * Determina si el personaje puede atravesar una pared
	 * 
	 * @param p
	 *            personaje
	 * @return true si el personaje puede atravesar la pared,false en caso
	 *         contrario
	 */
	public boolean avanzar(Personaje p) {
		return false;
	}

	/**
	 * Devuelve powerup de la pared
	 * 
	 * @return pw si no tiene powerup retorna null
	 */
	public PowerUp getPowerUp() {
		return pw;
	}

	/**
	 * Devuelve el puntaje de la destrucción de una pared
	 * 
	 * @Override
	 * @return puntos devuelve 0 porque la pared es indestrutible
	 */
	public int getPuntos() {
		return 0;
	}

	/**
	 * Determina si la pared se puede destruuir
	 * 
	 * @return false
	 */
	public boolean explotar() {
		return false;
	}
}