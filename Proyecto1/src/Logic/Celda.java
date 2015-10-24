package Logic;

import java.util.*;

/**
 * Clase Celda
 * @author BERNAB� DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */

public class Celda {
    protected Posicion posMatriz;
    protected Contenido contenido;
    
    /**
     * Constructor de la clase Celda.
     * @param p Posici�n de la celda en la Matriz.
     */
    public  Celda(Posicion p) {
        posMatriz=p;
    }
    
    /**
     * Setea el contenido de la Celda.
     * @param c
     */
    public void setContenido(Contenido c) {
        contenido = c;
    }
    
    /**
     * Consulta el contenido de la Celda.
     * @return
     */
    public Contenido getContenido(){
    	return contenido;
    }

    /**
     * Invoca al avanzar correspondiente.
     * @param p Personaje que quiere avanzar.
     * @return true si avanza, false en caso contrario.
     */
    public boolean avanzar(Personaje p) {
        return contenido.avanzar(p);
    }

    /**
     * Destruye la Celda y otorga puntos segun corresponda.
     * @return Cantidad de puntos que otorga el contenido de la Celda.
     */
    public int destruir() {
    	int puntos = 0;
        if (contenido.destruir() != 0) {
        	puntos = contenido.getPuntos();
        	PowerUp p = contenido.getPowerUp();
        	contenido = new NoPared(p);
        }
        return puntos;
    }
}