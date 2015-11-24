package Logic;

import java.util.*;

/**
 * Clase EstadoPared
 * 
 * @author Bernabe - Cabrera - Paez
 */
public abstract class EstadoPared {
	protected int puntos;
	protected PowerUp pw;

	/**
	 * Constructor
	 */
	public EstadoPared() {
	}

	/**
	 * Si es posible destruye una pared y devuelve el puntaje de su destrucción
	 * 
	 * @return puntos si la pared es indestructible devuelve 0
	 */
	public abstract int destruir();

	/**
	 * Determina si el personaje puede atravesar una pared
	 * 
	 * @param p
	 *            personaje
	 * @return true si el personaje puede atravesar la pared,false en caso
	 *         contrario
	 */
	public abstract boolean avanzar(Personaje p);

	/**
	 * Devuelve el puntaje de la destrucción de una pared
	 * 
	 * @return puntos
	 */
	public abstract int getPuntos();

	/**
	 * Devuelve powerup de la pared
	 * 
	 * @return pw si no tiene powerup retorna null
	 */
	public abstract PowerUp getPowerUp();
}