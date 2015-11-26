package Logic;

import java.util.*;

/**
 * Clase Tablero
 * 
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Tablero {

	protected int Alto;
	protected int Ancho;
	protected Bomberman personaje;
	protected Enemigo[] misEnemigos;
	protected Pared[] paredes;
	protected Celda[][] matrizCeldas;
	protected Posicion[] posDestructible;
	protected int cantParedesD;

	// CAMBIAR POR UN ARREGLO DE POWERUPS
	protected SpeedUp velocidad;
	protected Bombality bombality;
	protected Fatality fatality;
	protected Masacrality masacrality;
	// CAMBIANDO....

	protected PowerUp[] powerArreglo;

	/**
	 * @param Alto
	 * @param Ancho
	 */
	public Tablero(int Alto, int Ancho) {
		// BOMBERMAN
		personaje = new Bomberman(this);
		personaje.setPosicion(new Posicion(1, 1));

		this.Ancho = Ancho;
		this.Alto = Alto;

		matrizCeldas = new Celda[Ancho][Alto];

		// LLENO DE CELDAS LA MATRIZ
		for (int i = 0; i < Ancho; i++) {
			for (int j = 0; j < Alto; j++) {
				matrizCeldas[i][j] = new Celda(new Posicion(i, j),
						new Posicion(i, j), this);
			}

		}

		// AGREGO LAS PAREDES INDESTRUCTIBLES A LAS CELDAS
		//int cantDestructibles = 81;
		
		
		int cantDestructibles = 30;
		
		Random num = new Random();
		int azar1 = 0;
		int azar2 = 0;
		posDestructible = new Posicion[81];
		int ult = 0;

		// CAMBIANDO POR ARREGLO

		powerArreglo = new PowerUp[11];

		powerArreglo[0] = new SpeedUp(personaje);
		powerArreglo[1] = new SpeedUp(personaje);
		powerArreglo[2] = new SpeedUp(personaje);
		powerArreglo[3] = new SpeedUp(personaje);

		powerArreglo[4] = new Fatality(personaje);
		powerArreglo[5] = new Fatality(personaje);
		powerArreglo[6] = new Fatality(personaje);

		powerArreglo[7] = new Bombality(personaje);
		powerArreglo[8] = new Bombality(personaje);
		powerArreglo[9] = new Bombality(personaje);

		powerArreglo[10] = new Masacrality(personaje);

		int cantPU = 0;
		for (int h = 0; h < Ancho; h++) {
			for (int n = 0; n < Alto; n++) {

				if (n == 0) {
					matrizCeldas[h][n].setContenido(new Pared(this));
					matrizCeldas[h][n].getContenido().setEstado(
							new Indestructible(this));
				} else if (h == 0) {
					matrizCeldas[h][n].setContenido(new Pared(this));
					matrizCeldas[h][n].getContenido().setEstado(
							new Indestructible(this));
				} else if (n == 12) {
					matrizCeldas[h][n].setContenido(new Pared(this));
					matrizCeldas[h][n].getContenido().setEstado(
							new Indestructible(this));
				} else if (h == 30) {
					matrizCeldas[h][n].setContenido(new Pared(this));
					matrizCeldas[h][n].getContenido().setEstado(
							new Indestructible(this));
				} else if (h % 2 == 0 && n % 2 == 0) {
					matrizCeldas[h][n].setContenido(new Pared(this));
					matrizCeldas[h][n].getContenido().setEstado(
							new Indestructible(this));
				}
				// AGREGO AL RESTO TODAS NoPared para prototipo
				else {
					if (cantDestructibles != 0 && h != 1 && h != 2 && n != 1
							&& n != 2) {
						azar1 = num.nextInt() % 2;
						azar2 = num.nextInt() % 2;
						if (azar1 == 0 && ult < 80) {
							if (cantPU < 11 && azar2 == 0) {

								matrizCeldas[h][n].setContenido(new Pared(this));
								matrizCeldas[h][n].getContenido().setEstado(
										new Destructible(this,powerArreglo[cantPU]));
								powerArreglo[cantPU].setPosicion(new Posicion(
										h, n));
								posDestructible[ult] = new Posicion(h, n);
								ult++;
								cantPU++;
								cantDestructibles--;
								cantParedesD++;
							}

							else {
								matrizCeldas[h][n].setContenido(new Pared(this));
								matrizCeldas[h][n].getContenido().setEstado(
										new Destructible(this, null));
								posDestructible[ult] = new Posicion(h, n);
								ult++;
								cantDestructibles--;
								cantParedesD++;
							}

						} else
							matrizCeldas[h][n].setContenido(new NoPared(this,null));
					} else
						matrizCeldas[h][n].setContenido(new NoPared(this,null));
				}

			}
		}
		
		
		// LAS PAREDES DESTRUCTIBLES SE AGREGAN EN LUGARES AL AZAR, el 50% de
		// las celdas que aun no han sido ocupadas(TOTAL 403,TOTAL DE
		// DESOCUPADAS 160, TOTAL OCUPADAS(INDESTRUCTIBLES)=243)
		// DEBO AGREGAR 81 PAREDES DESTRUCTIBLES

		

		// ENEMIGOS
		Enemigo rugulus1 = new Rugulus(new Posicion(22, 11), this);
		this.obtenerCelda(rugulus1.getPosicion()).getContenido()
				.setEnemigo(rugulus1);

		Enemigo rugulus2 = new Rugulus(new Posicion(17, 2), this);
		this.obtenerCelda(rugulus2.getPosicion()).getContenido()
				.setEnemigo(rugulus2);

		Enemigo rugulus3 = new Rugulus(new Posicion(12, 9), this);
		this.obtenerCelda(rugulus3.getPosicion()).getContenido()
				.setEnemigo(rugulus3);

		Enemigo altair1 = new Altair(new Posicion(2, 6), this);
		this.obtenerCelda(altair1.getPosicion()).getContenido()
				.setEnemigo(altair1);

		Enemigo altair2 = new Altair(new Posicion(23, 6), this);
		this.obtenerCelda(altair2.getPosicion()).getContenido()
				.setEnemigo(altair2);

		Enemigo sirius = new Sirius(new Posicion(20, 11), this, personaje);
		this.obtenerCelda(sirius.getPosicion()).getContenido()
				.setEnemigo(sirius);

		// lleno el arreglo de enemigos
		misEnemigos = new Enemigo[6];
		misEnemigos[0] = rugulus1;
		misEnemigos[1] = rugulus2;
		misEnemigos[2] = rugulus3;
		misEnemigos[3] = altair1;
		misEnemigos[4] = altair2;
		misEnemigos[5] = sirius;



	}

	public void borrarBomberman() {
		Posicion p = personaje.getPosicion();
		obtenerCelda(p).getContenido().setBomberman(null);
		personaje.setPosicion(null);
		personaje = null;
	}

	public Celda obtenerCelda(Posicion p) {

		return matrizCeldas[p.getEjeX()][p.getEjeY()];
	}

	public Bomberman getBomberman() {
		return personaje;
	}

	public Enemigo[] getEnemigos() {
		return misEnemigos;
	}

	public Celda[][] getMatrizCeldas() {
		return matrizCeldas;
	}

	public Posicion[] getPosDestructibles() {
		return posDestructible;
	}

	public PowerUp[] obtenerPowerUp() {
		return powerArreglo;
	}

	public int cantDestructibles() {
		return cantParedesD;
	}

	public void disminuirParedes() {
		cantParedesD--;
	}
}