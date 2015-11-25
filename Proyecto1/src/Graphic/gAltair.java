package Graphic;

import java.util.Random;

import javax.swing.ImageIcon;

import Logic.*;

public class gAltair extends gEntidad {

	Altair mAlt;
	gJugador jugador;
	private MovimientoAltair movimientoThread;
	private boolean seMueve;
	
	public gAltair(int velocidad, int x, int y, Enemigo alt, gJugador jugador) {
		super(velocidad, x, y);

		mAlt = (Altair) alt;
		this.jugador = jugador;

		this.mImages[0][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aarr1.png"));
		this.mImages[0][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aarr2.png"));
		this.mImages[0][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aarr3.png"));
		this.mImages[0][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aarr2.png"));

		this.mImages[1][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Abaj1.png"));
		this.mImages[1][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Abaj2.png"));
		this.mImages[1][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Abaj3.png"));
		this.mImages[1][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Abaj2.png"));

		this.mImages[2][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aizq2.png"));
		this.mImages[2][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aizq1.png"));
		this.mImages[2][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aizq2.png"));
		this.mImages[2][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Aizq3.png"));

		this.mImages[3][0] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Ader2.png"));
		this.mImages[3][1] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Ader1.png"));
		this.mImages[3][2] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Ader2.png"));
		this.mImages[3][3] = new ImageIcon(this.getClass().getResource(
				"/imagenes/Ader3.png"));

		this.mDestroyedImage = new ImageIcon(this.getClass().getResource(
				"/imagenes/nada.png"));
	}

	public void mover() {
		// Calculo la siguiente direccion aleatoriamente.

		if (mAlt.estaVivo() ) {
			if (!seMueve){
			int n = mAlt.mover();
			if (n != -1) {
				switch (n) {

				case MOVIMIENTO_ARRIBA:

					movimientoThread = new MovimientoAltair(this); // Cambio
					movimientoThread.setDir("arriba");
					movimientoThread.start();
					chequeoColisiones();
					break;
				case MOVIMIENTO_ABAJO:

					movimientoThread = new MovimientoAltair(this); // Cambio
					movimientoThread.setDir("abajo");
					movimientoThread.start();
					chequeoColisiones();
					break;
				case MOVIMIENTO_IZQUIERDA:
					movimientoThread = new MovimientoAltair(this); // Cambio
					movimientoThread.setDir("izquierda");
					movimientoThread.start();
					chequeoColisiones();
					break;
				case MOVIMIENTO_DERECHA:
					movimientoThread = new MovimientoAltair(this); // Cambio
					movimientoThread.setDir("derecha");
					movimientoThread.start();
					chequeoColisiones();
					break;
				}

				super.mover(n);
			}
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
	
	public void comenzarAMover() {
		seMueve = true;
	}

	public void dejarDeMover() {
		seMueve = false;
	}

}
