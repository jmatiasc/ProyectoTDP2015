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
        else if (bomberman!=null && b==null){
    		bomberman=null;
    }
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
        else if (enemigo!=null && e==null){
        		enemigo=null;
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
 
	
	public boolean avanzar(Personaje p) {
		
		return true;
	}
	
	/**
     * @return
     */
	public int destruir() {
		if(enemigo!=null){
			int p=enemigo.destruir();
			enemigo=null;
			return p;
		}
		if(bomberman!=null){
			bomberman.morir();
			bomberman=null;
			return -1;
		}
		return 0;
		
	}
	
	/**
     * @return
     */
	public int getPuntos() {
		return 0;
	}
	
	/**
     * @return
     */
	public PowerUp getPowerUp(){
		return powerUp;
	}
	
	public void setPowerUp(PowerUp p){
		powerUp=p;
	}

}