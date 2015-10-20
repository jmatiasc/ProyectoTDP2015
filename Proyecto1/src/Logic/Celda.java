package Logic;

import java.util.*;

/**
 * 
 */
public class Celda {
    protected Posicion posMatriz;
    protected Contenido contenido;
    

    
    public  Celda(Posicion p) {
        posMatriz=p;
    }
    /**
     * @param Contenido c
     */
    public void setContenido(Contenido c) {
        contenido=c;
    }
    
    public Contenido getContenido(){
    	return contenido;
    }

    /**
     * @param Personaje 
     * @return
     */
    public boolean avanzar(Personaje p) {
        
        return contenido.avanzar(p);
    }

    /**
     * 
     */
    public int destruir() {
    	int puntos=0;
        if(contenido.destruir()){
        	puntos=contenido.getPuntos();
        	PowerUp p=contenido.getPowerUp();
        	contenido=new NoPared(p);
        }
        return puntos;
    }

}