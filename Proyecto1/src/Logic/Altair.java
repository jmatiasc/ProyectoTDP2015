package Logic;

import java.util.*;

/**
 * Clase Altair
 * @author BERNAB� DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Altair extends Enemigo {
	
	/**
	 * Inicializa los atributos de Altair.
	 * @param t Tablero en donde se encuentra Altair.
	 * @param p Posici�n de Altair en el tablero.
	 */
	public  Altair(Posicion p,Tablero t) {
		super(t);
        ubicacion=p;
        velocidad=32;
        modoDios=true;
        puntos=20;
    }
}