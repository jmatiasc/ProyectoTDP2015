package Logic;

import java.util.*;

/**
 * Clase Pared
 * 
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Pared extends Contenido {

	protected Tablero tablero;

	/**
	 * Default constructor
	 */
	public Pared() {
		super();
	}

	/**
	 * le inserta el elemento e al atributo EstadoPared
	 * 
	 * @param EstadoPared
	 *            e
	 * 
	 */
	public void setEstado(EstadoPared e) {
		miEstado = e;
	}

	/**
	 * llama al metodo destruir del atributo mi estado de tipo EstadoPared
	 * 
	 * @return los puntos del elemento que destruyo
	 * 
	 */
	public int destruir() {
		return miEstado.destruir();
	}

	/**
	 * @param p
	 * @return true si el personaje p puede acceder a la siguiente celda, false
	 *         en caso contrario
	 * 
	 */
	public boolean avanzar(Personaje p) {
		return miEstado.avanzar(p);
	}

	/**
	 * @return retorna lo puntos de mi EstadoPared
	 */

	public int getPuntos() {

		return miEstado.getPuntos();
	}

	/**
	 * 
	 * @return un powerUp que se encuentre en EstadoPared
	 */
	public PowerUp getPowerUp() {
		return miEstado.getPowerUp();
	}

	/**
	 * le inserta el elmento b al atributo bomberman
	 * 
	 * @param b
	 *            de tipo Bomberman
	 * @return true si fue insertado correctamente, false en caso contrario
	 */
	public boolean setBomberman(Bomberman b) {
		if (bomba == null) {
			bomberman = b;
			return true;
		} else
			return false;
	}

	/**
	 * inserta e en el atributo enemigo
	 * 
	 * @param e
	 *            de tipo Enemigo,
	 * @return true si fue insertado correctamente, false en caso contrario
	 */
	public boolean setEnemigo(Enemigo e) {
		if (enemigo == null && bomba == null) {
			enemigo = e;
			return true;
		}
		return false;
	}

	/**
	 * inserta bm en el atributo bomba
	 * 
	 * @param bm
	 *            de tipo Bomba
	 * @return true si fue insertado correctamente, false en caso contrario
	 */
	public void setBomba(Bomba bm) {

		bomba = bm;

	}

	/**
	 * cheuqea si se encuentran un enemigo y el bomberman en la misma celda
	 * 
	 */
	public void chequeoColisiones() {
		if (bomberman != null && enemigo != null)
			bomberman.morir();

	}

	/**
	 * inserta p en el atributo powerUp
	 * 
	 * @param p
	 *            de tipo PowerUp
	 * 
	 */
	public void setPowerUp(PowerUp p) {
		powerUp = p;
	}

}