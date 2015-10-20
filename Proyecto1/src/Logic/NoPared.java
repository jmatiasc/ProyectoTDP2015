package Logic;

import java.util.*;

/**
 * 
 */
public class NoPared extends Contenido {
	

    
	 public  NoPared(PowerUp pu) {
		 	super();
	        powerUp=pu;
	    }
    /**
     * @param b 
     * @return
     */
	 public void setEstado(EstadoPared e) {
	       miEstado=new Indestructible();    }
	 
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
        else if(bomberman!=null && powerUp!=null)
        	bomberman.powerUp(powerUp);
        
    }

    /**
     * @return
     */
    public boolean Destruir() {
        return false;
    }
	
	public boolean avanzar(Personaje p) {
		
		return true;
	}
	
	public boolean destruir() {
		return false;
	}
	
	public int getPuntos() {
		return 0;
	}
	
	public PowerUp getPowerUp(){
		return powerUp;
	}

}