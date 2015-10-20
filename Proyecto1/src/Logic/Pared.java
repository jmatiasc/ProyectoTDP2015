package Logic;

import java.util.*;

/**
 * 
 */
public class Pared extends Contenido {

	protected Tablero tablero;

    /**
     * Default constructor
     */
    public Pared() {
    	super();
    }

    /**
     * @param EstadoPared e
     */
    public void setEstado(EstadoPared e) {
       miEstado=e;    }

    /**
     * @return
     */
    public boolean destruir() {
          return miEstado.destruir();
    }

    /**
     * @param p 
     * @return
     */
    public boolean avanzar(Personaje p) {
    	return miEstado.avanzar(p);
    }

	@Override
	public int getPuntos() {
		
		return miEstado.getPuntos();
	}
	public PowerUp getPowerUp(){
		return miEstado.getPowerUp();
	}
	public boolean setBomberman(Bomberman b) {
        if(bomberman==null && bomba==null){
        bomberman=b;
        return true;
        }
        else
        return false;
    }

    /**
     * @param e 
     * @return
     */
    public boolean setEnemigo(Enemigo e) {
        if(enemigo==null && bomba==null){
        	enemigo=e;
        	return true;    	
        }
        return false;
    }

    /**
     * @param bm 
     * @return
     */
    public boolean setBomba(Bomba bm) {
        if(bomba==null ){
        	bomba=bm;
        	return true;
        }
        return false;
    }

    /**
     * 
     */
    public void chequeoColisiones() {
        if(bomberman!=null && enemigo!=null)
        	bomberman.morir();
        
    }



}