package Logic;

import java.util.*;

/**
 * 
 */
public abstract class Contenido  {
    protected int puntos;
    protected Bomberman bomberman;
	protected Bomba bomba;
	protected PowerUp powerUp;
    protected Enemigo enemigo;
    protected EstadoPared miEstado;
    
    public Contenido() {
    	
    	miEstado=null;
        bomberman=null;
    	bomba=null;
    	powerUp=null;
        enemigo=null;
       
    	
    }
    public abstract void setEstado(EstadoPared e); 
    public abstract boolean avanzar(Personaje p);
    public abstract boolean  destruir();
    public abstract int getPuntos();
    public abstract PowerUp getPowerUp();
	public abstract boolean setBomberman(Bomberman b);
	public abstract  boolean setEnemigo(Enemigo e);
	public abstract boolean setBomba(Bomba bm);
	public abstract void chequeoColisiones();
	public abstract void setPowerUp(PowerUp p);
}
