package Logic;

import java.util.*;

/**
 * Clase Masacrality
 * 
 * @author Bernabe - Cabrera - Paez
 */
public class Masacrality extends PowerUp {
	/**
	 * Constructor
	 * 
	 * @param b
	 *            Bomberman
	 */
	public Masacrality(Bomberman b) {
		super(b);
		puntos = 50;
	}

	/**
	 * Aumenta la velocidad del Bomberman
	 */
	public void aumentarVelocidad() {
	}

	/**
	 * Duplica el alcance de la explosión de la bomba del personaje principal
	 */
	public void duplicarAlcance() {
	}

	/**
	 * Aumenta la cantidad de bombas que el personaje principal puede colocar
	 */
	public void aumentarCantidadBombas() {
	}

	/**
	 * La cantidad de bombas de Bomberman será ilimitada, podrá atravesar
	 * paredes y será inmune a los malos y las explosiones
	 */
	public void fullAtributos() {
		jugador.activarModoDios();
	}

	/**
	 * Establece la posición del powerup Masacrality
	 * 
	 * @param Posicion
	 *            p posición del powerup Masacrality
	 */
	public void setPosicion(Posicion p) {
		super.setPosicion(p);
	}
}
