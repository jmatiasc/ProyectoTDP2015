package Logic;

import java.util.*;

/**
 * Clase Bomberman
 * 
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Bomberman extends Personaje {
	protected int velocidad;
	protected int cantBombas;
	protected int alcanceBomba;
	protected Tablero tablero;
	protected int puntos;

	/**
	 * Constructor de la clase Bomberman.
	 * 
	 * @param t
	 *            Tablero vinculado al Bomberman.
	 */
	public Bomberman(Tablero t) {

		velocidad = 1;
		cantBombas = 1;
		alcanceBomba = 1;
		tablero = t;
		puntos = 0;
	}

	/**
	 * De ser posible, avanza al Bomberman una celda hacia arriba.
	 * 
	 * @return true si avanza, false en caso contrario.
	 */
	public boolean moverArriba() {
		Posicion p = new Posicion(ubicacion.getEjeX(), ubicacion.getEjeY() - 1);
		if (p.ejeY < 0)
			p.setEjeY(0);
		if (tablero.obtenerCelda(p).avanzar(this)) {
			tablero.obtenerCelda(p).getContenido().setBomberman(this);
			tablero.obtenerCelda(p).getContenido().chequeoColisiones();
			tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
			ubicacion = p;

			return true;
		} else
			return false;
	}

	/**
	 * De ser posible, avanza al Bomberman una celda hacia abajo.
	 * 
	 * @return true si avanza, false en caso contrario.
	 */
	public boolean moverAbajo() {

		Posicion p = new Posicion(ubicacion.getEjeX(), ubicacion.getEjeY() + 1);
		if (p.ejeY > 12)
			p.setEjeY(12);
		if (tablero.obtenerCelda(p).avanzar(this)) {
			tablero.obtenerCelda(p).getContenido().setBomberman(this);
			tablero.obtenerCelda(p).getContenido().chequeoColisiones();
			tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
			ubicacion = p;

			return true;
		} else
			return false;
	}

	/**
	 * De ser posible, avanza al Bomberman una celda hacia la izquierda.
	 * 
	 * @return true si avanza, false en caso contrario.
	 */
	public boolean moverIzquierda() {
		Posicion p = new Posicion(ubicacion.getEjeX() - 1, ubicacion.getEjeY());
		if (p.ejeX < 0)
			p.setEjeX(0);
		if (tablero.obtenerCelda(p).avanzar(this)) {
			tablero.obtenerCelda(p).getContenido().setBomberman(this);
			tablero.obtenerCelda(p).getContenido().chequeoColisiones();
			tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
			ubicacion = p;

			return true;
		} else
			return false;
	}

	/**
	 * De ser posible, avanza al Bomberman una celda hacia la derecha.
	 * 
	 * @return true si avanza, false en caso contrario.
	 */
	public boolean moverDerecha() {
		Posicion p = new Posicion(ubicacion.getEjeX() + 1, ubicacion.getEjeY());
		if (p.ejeX > 30)
			p.setEjeX(30);
		if (tablero.obtenerCelda(p).avanzar(this)) {
			tablero.obtenerCelda(p).getContenido().setBomberman(this);
			tablero.obtenerCelda(p).getContenido().chequeoColisiones();
			tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
			ubicacion = p;

			return true;
		} else
			return false;
	}

	/**
	 * Si la cantidad de bombas es mayor que cero, deja una bomba.
	 * 
	 * @return bomba si se pudo plantar, null en caso contrario.
	 */
	public Bomba dejarBomba() {
		if (cantBombas != 0) {
			if (!modoDios)
				cantBombas--;
			Bomba miBomba = new Bomba(ubicacion, alcanceBomba, tablero, this);
			tablero.obtenerCelda(ubicacion).getContenido().setBomba(miBomba);
			return miBomba;
		} else
			return null;
	}

	/**
	 * Duplica la velocidad de Bomberman.
	 */
	public void aumentarVelocidad() {

		velocidad = velocidad * 2;

	}

	/**
	 * Aumenta la cantidad de bombas en uno.
	 */
	public void aumentarCantBombas() {
		cantBombas++;
	}

	/**
	 * Duplica el alcance de la bomba.
	 */
	public void aumentarAlcance() {
		alcanceBomba = alcanceBomba * 2;

	}

	/**
	 * Mata al bomberman y lo devuelve a su posición inicial.
	 */
	public void morir() {
		tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
		ubicacion.setEjeY(1);
		ubicacion.setEjeX(1);
		tablero.obtenerCelda(ubicacion).getContenido().setBomberman(this);
		tablero.borrarBomberman();
	}

	/**
	 * Activa el PowerUp y mejora a Bomberman.
	 * 
	 * @param p
	 *            Powerup a activar.
	 */
	public void powerUp(PowerUp p) {
		p.aumentarCantidadBombas();
		p.aumentarVelocidad();
		p.duplicarAlcance();
		p.fullAtributos();
	}

	/**
	 * Activa el modo dios, durante 5 segundos.
	 */
	public void activarModoDios() {
		modoDios = true;

	}

	public void desactivarModoDios() {
		modoDios = false;

	}

	/**
	 * Consulta la posición de Bomberman.
	 * 
	 * @return
	 */
	public Posicion getPosicion() {
		return ubicacion;
	}

	/**
	 * Consulta la velocidad de Bomberman.
	 * 
	 * @return
	 */
	public int getVelocidad() {
		return velocidad;
	}

	public int getPuntos() {
		return puntos;
	}

	public void sumarPuntos(int p) {
		puntos += p;

	}
}