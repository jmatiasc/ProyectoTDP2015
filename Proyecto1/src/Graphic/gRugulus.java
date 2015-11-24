package Graphic;

import java.util.Random;

import javax.swing.ImageIcon;

import Logic.*;

public class gRugulus extends gEntidad {
	private Rugulus mRug;
	private gJugador jugador;
	private MovimientoRugulus movimientoThread;

	public gRugulus(int velocidad, int x, int y, Enemigo rug, gJugador jugador) {
		super(velocidad, x, y);

		mRug = (Rugulus) rug;
		this.jugador = jugador;

		this.mImages[0][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rarr1.png"));
		this.mImages[0][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rarr2.png"));
		this.mImages[0][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rarr3.png"));
		this.mImages[0][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rarr2.png"));

		this.mImages[1][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rabj1.png"));
		this.mImages[1][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rabj2.png"));
		this.mImages[1][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rabj3.png"));
		this.mImages[1][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rabj2.png"));

		this.mImages[2][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rizq2.png"));
		this.mImages[2][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rizq1.png"));
		this.mImages[2][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rizq2.png"));
		this.mImages[2][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rizq3.png"));

		this.mImages[3][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rder2.png"));
		this.mImages[3][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rder1.png"));
		this.mImages[3][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rder2.png"));
		this.mImages[3][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Rder3.png"));

		this.mDestroyedImage = new ImageIcon(this.getClass().getResource(
				"/imagenes/nada.png"));
	}

	public void mover() {
		// Calculo la siguiente direccion aleatoriamente.

		if (mRug.estaVivo()) {
			int n = mRug.mover();
			if (n != -1) {
				switch (n) {

				case MOVIMIENTO_ARRIBA:

					movimientoThread = new MovimientoRugulus(this); // Cambio
					movimientoThread.setDir("arriba");
					movimientoThread.start();
					chequeoColisiones();
					break;
				case MOVIMIENTO_ABAJO:

					movimientoThread = new MovimientoRugulus(this); // Cambio
					movimientoThread.setDir("abajo");
					movimientoThread.start();
					chequeoColisiones();
					break;
				case MOVIMIENTO_IZQUIERDA:
					movimientoThread = new MovimientoRugulus(this); // Cambio
					movimientoThread.setDir("izquierda");
					movimientoThread.start();
					chequeoColisiones();
					break;
				case MOVIMIENTO_DERECHA:
					movimientoThread = new MovimientoRugulus(this); // Cambio
					movimientoThread.setDir("derecha");
					movimientoThread.start();
					chequeoColisiones();
					break;
				}

				super.mover(n);

			}
		} else
			destruir();
	}

	public void destruir() {
		super.destruir();
	}

	private void chequeoColisiones() {
		if (jugador != null && !jugador.getModoDios()) {
			if (mPosicion.equals(jugador.getPosicion())) {
				jugador.morir();
			}
		}
	}

	public void transicionArriba() {
		this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y - 8);
		super.mover(MOVIMIENTO_ARRIBA);
	}

	public void transicionAbajo() {
		this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y + 8);
		super.mover(MOVIMIENTO_ABAJO);
	}

	public void transicionIzquierda() {
		this.mPosicion.setLocation(this.mPosicion.x - 8, this.mPosicion.y);
		super.mover(MOVIMIENTO_IZQUIERDA);
	}

	public void transicionDerecha() {
		this.mPosicion.setLocation(this.mPosicion.x + 8, this.mPosicion.y);
		super.mover(MOVIMIENTO_DERECHA);
	}

}