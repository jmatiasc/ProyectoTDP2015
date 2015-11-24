package Logic;

import java.util.*;

/**
 * Clase NoPared
 * 
 * @author Bernabe - Cabrera - Paez
 */
public class NoPared extends Contenido {
	/**
	 * Constructor
	 * 
	 * @param pu
	 *            Powerup
	 */
	public NoPared(PowerUp pu) {
		super();
		powerUp = pu;
	}

	/**
	 * Establece el estado de la pared
	 * 
	 * @param e
	 *            EstadoPared
	 */
	public void setEstado(EstadoPared e) {
		miEstado = new Indestructible();
	}

	/**
	 * Agrega o quita al Bomberman del contenido de una celda
	 * 
	 * @param b
	 *            Bomberman
	 * @return true si el Bomberman pudo ser agregado, false en caso contrario
	 */
	public boolean setBomberman(Bomberman b) {
		if (bomberman == null && bomba == null) {
			bomberman = b;
			return true;
		} else if (bomberman != null && b == null) {
			bomberman = null;
		}
		return false;
	}

	/**
	 * Agrega o quita un enemigo al contenido de una celda
	 * 
	 * @param e
	 *            Enemigo
	 * @return true si el enemigo pudo ser agregado, false en caso contrario
	 */
	public boolean setEnemigo(Enemigo e) {
		if (enemigo == null && bomba == null) {
			enemigo = e;
			return true;
		} else if (enemigo != null && e == null) {
			enemigo = null;
		}
		return false;
	}

	/**
	 * Agrega o quita una bomba al contenido de una celda
	 * 
	 * @param bm
	 *            Bomba
	 * @return true si la bomba pudo ser agregada, false en caso contrario
	 */
	public void setBomba(Bomba bm) {

		bomba = bm;

	}

	/**
     * 
     */
	public void chequeoColisiones() {
		if (bomberman != null && enemigo != null && !bomberman.GetModoDios())
			bomberman.morir();
		else if (bomberman != null && powerUp != null) {
			bomberman.powerUp(powerUp);
			bomberman.sumarPuntos(powerUp.getPuntos());
			powerUp = null;
		}
	}

	/**
	 * Determina si un personaje puede avanzar sobre el contenido de una celda
	 * 
	 * @param p
	 *            Personaje
	 * @return true si puede avanzar, false en caso contrario
	 */
	public boolean avanzar(Personaje p) {
		if (bomba != null)
			return false;
		return true;
	}

	/**
	 * Destruye el contenido de una celda y devuelve un valor según lo que había
	 * en ella
	 * 
	 * @return p puntaje de la destrucción de un enemigo
	 * @return -1 si se encontraba el bomberman
	 * @return 0 si no se encontraba el bomberman o un enemigo
	 */
	public int destruir() {
		if (enemigo != null) {

			int p = enemigo.destruir();
			enemigo = null;

			return p;
		}
		if (bomberman != null) {
			if (!bomberman.GetModoDios()) {
				bomberman.morir();
				bomberman = null;
				return -1;
			}
		}
		return 0;
	}

	/**
	 * Devuelve el puntaje de la destrucción del contenido de una celda
	 * 
	 * @return 0
	 */
	public int getPuntos() {
		return 0;
	}

	/**
	 * Devuelve powerup del contenido de una celda
	 * 
	 * @return powerUp si no tiene powerup retorna null
	 */
	public PowerUp getPowerUp() {
		return powerUp;
	}

	/**
	 * Establece un powerup en el contenido de una celda
	 * 
	 * @param p
	 *            PowerUp
	 */
	public void setPowerUp(PowerUp p) {
		powerUp = p;
	}

}