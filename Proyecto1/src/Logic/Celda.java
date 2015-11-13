package Logic;

import java.util.*;

/**
 * Clase Celda
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */

public class Celda {
    protected Posicion posMatriz;
    protected Contenido contenido;
    protected Posicion ubicacion;
    
    /**
     * Constructor de la clase Celda.
     * @param p Posición de la celda en la Matriz.
     */
    public  Celda(Posicion p,Posicion u) {
        posMatriz=p;
        ubicacion=u;
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
    	int puntos = contenido.destruir();
		    	if(puntos!=0){
			    	PowerUp p = contenido.getPowerUp();
			       	contenido = new NoPared(p);
		    	}
        return puntos;
    }
    
    public Posicion getPosicion(){
    	return ubicacion;
    }
}