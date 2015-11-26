package Graphic;

import java.applet.AudioClip;
import java.awt.Component;
import java.awt.Point;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.*;

public class gTablero {

	private Tablero t;

	private Thread Enemigos[];

	private gJugador mJugador;

	private ImageIcon paredI;
	private ImageIcon paredD;

	private AudioClip SoundExplocion;

	private AudioClip powerU;

	private GUI gui;

	
	private PowerUp[] arregloP;
	private powerUpsGrafico[] arregloPGrafico;

	private gPared[] arregloParedD;

	private gBomba bomba;

	public gTablero(GUI gui) {
		this.gui = gui;

		SoundExplocion = java.applet.Applet.newAudioClip(getClass()
				.getResource("/Sonidos/explotar.wav"));

		powerU = java.applet.Applet.newAudioClip(getClass().getResource(
				"/Sonidos/AgarroPU.wav"));

		// Creo el jugador y lo agrego el grafico a la gui.
		t = new Tablero(13, 31);
		this.mJugador = new gJugador(t.getBomberman().getVelocidad(),
				t.getBomberman(), 32, 32, t, this);
		gui.add(this.mJugador.getGrafico());

		arregloParedD = new gPared[t.getPosDestructibles().length];

		paredI = new ImageIcon(
				(this.getClass().getResource("/imagenes/pared.png")));

		paredD = new ImageIcon(
				(this.getClass().getResource("/imagenes/ParedD.png")));


		// Creo los malos y agrego a la gui su grafico.
		this.Enemigos = new Thread[6];

		// agrego los rugulus en posiciones que coinciden con las que creo los
		// rugulus en el tablero
		Enemigo enemig[] = t.getEnemigos();

		gRugulus rugulus1 = new gRugulus(32,
				enemig[0].getPosicion().getEjeX() * 32, enemig[0].getPosicion()
						.getEjeY() * 32, enemig[0], mJugador);
		Enemigos[0] = new RugulusThread(rugulus1);
		gui.add(rugulus1.getGrafico());

		gRugulus rugulus2 = new gRugulus(32,
				enemig[1].getPosicion().getEjeX() * 32, enemig[1].getPosicion()
						.getEjeY() * 32, enemig[1], mJugador);
		Enemigos[1] = new RugulusThread(rugulus2);
		gui.add(rugulus2.getGrafico());

		gRugulus rugulus3 = new gRugulus(32,
				enemig[2].getPosicion().getEjeX() * 32, enemig[2].getPosicion()
						.getEjeY() * 32, enemig[2], mJugador);
		Enemigos[2] = new RugulusThread(rugulus3);
		gui.add(rugulus3.getGrafico());

		gAltair altair1 = new gAltair(32,
				enemig[3].getPosicion().getEjeX() * 32, enemig[3].getPosicion()
						.getEjeY() * 32, enemig[3], mJugador);
		Enemigos[3] = new AltairThread(altair1);
		gui.add(altair1.getGrafico());

		gAltair altair2 = new gAltair(32,
				enemig[4].getPosicion().getEjeX() * 32, enemig[4].getPosicion()
						.getEjeY() * 32, enemig[4], mJugador);
		Enemigos[4] = new AltairThread(altair2);
		gui.add(altair2.getGrafico());

		gSirius Sirius = new gSirius(32,
				enemig[5].getPosicion().getEjeX() * 32, enemig[5].getPosicion()
						.getEjeY() * 32, enemig[5], mJugador);
		Enemigos[5] = new SiriusThread(Sirius);
		gui.add(Sirius.getGrafico());

		this.Enemigos[0].start();
		this.Enemigos[1].start();
		this.Enemigos[2].start();
		this.Enemigos[3].start();
		this.Enemigos[4].start();
		this.Enemigos[5].start();

		ponerPared(gui);
		ponerParedD(t.getPosDestructibles(), gui);

	

		arregloP = t.obtenerPowerUp();
		arregloPGrafico = new powerUpsGrafico[11];

		Posicion pos = arregloP[0].getPosicion();
		PowerUpVelocidad velocidad1 = new PowerUpVelocidad(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(velocidad1.getGrafico());
		arregloPGrafico[0] = velocidad1;

		pos = arregloP[1].getPosicion();
		PowerUpVelocidad velocidad2 = new PowerUpVelocidad(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(velocidad2.getGrafico());
		arregloPGrafico[1] = velocidad2;

		pos = arregloP[2].getPosicion();
		PowerUpVelocidad velocidad3 = new PowerUpVelocidad(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(velocidad3.getGrafico());
		arregloPGrafico[2] = velocidad3;

		pos = arregloP[3].getPosicion();
		PowerUpVelocidad velocidad4 = new PowerUpVelocidad(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(velocidad4.getGrafico());
		arregloPGrafico[3] = velocidad4;
		// _____________________________________________________________________

		pos = arregloP[4].getPosicion();
		PowerUpFatality fatality1 = new PowerUpFatality(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(fatality1.getGrafico());
		arregloPGrafico[4] = fatality1;

		pos = arregloP[5].getPosicion();
		PowerUpFatality fatality2 = new PowerUpFatality(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(fatality2.getGrafico());
		arregloPGrafico[5] = fatality2;

		pos = arregloP[6].getPosicion();
		PowerUpFatality fatality3 = new PowerUpFatality(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(fatality3.getGrafico());
		arregloPGrafico[6] = fatality3;

		// _____________________________________________________
		pos = arregloP[7].getPosicion();
		PowerUpBombality bombality1 = new PowerUpBombality(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(bombality1.getGrafico());
		arregloPGrafico[7] = bombality1;

		pos = arregloP[8].getPosicion();
		PowerUpBombality bombality2 = new PowerUpBombality(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(bombality2.getGrafico());
		arregloPGrafico[8] = bombality2;

		pos = arregloP[9].getPosicion();
		PowerUpBombality bombality3 = new PowerUpBombality(pos.getEjeX() * 32,
				pos.getEjeY() * 32);
		gui.add(bombality3.getGrafico());
		arregloPGrafico[9] = bombality3;

		// ____________________________________________________________________

		pos = arregloP[10].getPosicion();
		PowerUpMasacrality masacrality = new PowerUpMasacrality(
				pos.getEjeX() * 32, pos.getEjeY() * 32);
		gui.add(masacrality.getGrafico());
		arregloPGrafico[10] = masacrality;

	}

	public void mover(int dir) {
		if (t.getBomberman() != null) {
			this.mJugador.mover(dir);
			chequeoColisiones();
		}

	}


	
	private void chequeoColisiones() {

		for (int i = 0; i < arregloP.length; i++) {
			if (arregloP[i] != null) {
				Point pos = new Point(arregloP[i].getPosicion().getEjeX() * 32,
						arregloP[i].getPosicion().getEjeY() * 32);

				if (pos.equals(mJugador.getPosicion())) {
					powerU.play();
					if (i >= 0 && i <= 3) {

						mJugador.aumentarVelocidad();
					}

					if (i == 10) {
						MasacralityThread activacion = new MasacralityThread(
								t.getBomberman());

						activacion.start();
					}
					ImageIcon nada = new ImageIcon(
							(this.getClass().getResource("/imagenes/nada.png")));
					gui.add(new JLabel(nada));
					arregloPGrafico[i].getGrafico().setIcon(nada);
					arregloP[i] = null;

				}
			}

		}

		gui.sumarPuntos(t.getBomberman().getPuntos());
	}

	public void destruir(int malo) {

	}

	private void ponerPared(GUI gui) {

		for (int h = 0; h < 31; h++) {
			for (int n = 0; n < 13; n++) {

				if (n == 0) {
					JLabel labelPared = new JLabel(paredI);
					gui.add(labelPared);
					labelPared.setBounds(h * 32, 0, 32, 32);
				} else if (h == 0) {
					JLabel labelPared = new JLabel(paredI);
					gui.add(labelPared);
					labelPared.setBounds(0, n * 32, 32, 32);
				} else if (n == 12) {
					JLabel labelPared = new JLabel(paredI);
					gui.add(labelPared);
					labelPared.setBounds(h * 32, n * 32, 32, 32);
				} else if (h == 30) {
					JLabel labelPared = new JLabel(paredI);
					gui.add(labelPared);
					labelPared.setBounds(h * 32, n * 32, 32, 32);

				} else if (h % 2 == 0 && n % 2 == 0) {
					JLabel labelPared = new JLabel(paredI);
					gui.add(labelPared);
					labelPared.setBounds(h * 32, n * 32, 32, 32);

				}

			}
		}
	}

	private void ponerParedD(Posicion[] pos, GUI gui) {
		int i = 0;

		while (pos[i] != null || i == pos.length) {
			gPared nuevo = new gPared(new Point(pos[i].getEjeX() * 32,
					pos[i].getEjeY() * 32));
			arregloParedD[i] = nuevo;
			gui.add(nuevo.getGrafico());

			i++;
		}
	}

	public void matarBomberman() {
		mJugador.destruir();
		mJugador = null;
		((RugulusThread) this.Enemigos[0]).detener();
		((RugulusThread) this.Enemigos[1]).detener();
		((RugulusThread) this.Enemigos[2]).detener();
		((AltairThread) this.Enemigos[3]).detener();
		((AltairThread) this.Enemigos[4]).detener();
		((SiriusThread) this.Enemigos[5]).detener();
		gui.fin(0);

	}

	public void dejarBomba(Point p, Bomba b) {
		gBomba bomba = new gBomba(b, this); // Cambio
		bomba.setPosicion(p);
		bomba.dejarBomba();
		gui.add(bomba.getGrafico());
		BombaThread tb = new BombaThread(bomba);

		tb.start();

	}

	public void mostrarExplosion(Point p, Celda[] celdas) {

		Explosion[] arreglo = new Explosion[celdas.length];
		arreglo[0] = new Explosion(p);

		int x = 0;
		int y = 0;

		for (int i = 0; i < celdas.length; i++) {
			if (celdas[i] != null) {
				x = celdas[i].getPosicion().getEjeX() * 32;

				y = celdas[i].getPosicion().getEjeY() * 32;

				arreglo[i] = new Explosion(new Point(x, y));

			}

		}

		ImageIcon nada = new ImageIcon(this.getClass().getResource(
				"/imagenes/nada.png"));
		ImageIcon mPowerUpV = new ImageIcon(this.getClass().getResource(
				"/imagenes/explosion2.png"));
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i] != null) {

				if (!perteneceAParedD(arreglo[i].getPosicion())) {
					gui.add(arreglo[i].getGrafico());
					arreglo[i].getGrafico().setIcon(mPowerUpV);
				} else {

					
					obtenerPared(arreglo[i].getPosicion()).destruir();
					destruirPared(arreglo[i].getPosicion());
				}
			}
		}
		if (t.getBomberman() != null)
			gui.sumarPuntos(t.getBomberman().getPuntos());
		else
			matarBomberman();

		if (t.cantDestructibles() == 0)
			gui.fin(1);
		SoundExplocion.play();

		ThreadRetardo t = new ThreadRetardo(arreglo, gui);
		t.start();

	}

	private boolean perteneceAParedD(Point p) {

		for (int i = 0; i < arregloParedD.length; i++) {
			if (arregloParedD[i] != null)
				if (arregloParedD[i].getPosicion().equals(p))
					return true;
		}
		return false;

	}

	private gPared obtenerPared(Point p) {
		for (int i = 0; i < arregloParedD.length; i++) {
			if (arregloParedD[i].getPosicion().equals(p))
				return arregloParedD[i];
		}
		return null;
	}

	private void destruirPared(Point p) {

		for (int i = 0; i < arregloParedD.length; i++) {
			if (arregloParedD[i].getPosicion().equals(p))
				arregloParedD[i] = null;
			break;
		}

	}

}