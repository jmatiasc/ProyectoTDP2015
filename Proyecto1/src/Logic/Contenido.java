package Logic;

import java.util.*;

/**
 * Clase abstracta Contenido
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public abstract class Contenido  {
    protected int puntos;
    protected Bomberman bomberman;
	protected Bomba bomba;
	protected PowerUp powerUp;
    protected Enemigo enemigo;
    protected EstadoPared miEstado;
    
    /**
     * Constructor de la clase Contenido.
     * Inicializa los atributos.
     */
    public Contenido() {
    	miEstado=null;
        bomberman=null;
    	bomba=null;
    	powerUp=null;
        enemigo=null;	
    }
    
    public abstract void setEstado(EstadoPared e); 
    public abstract boolean avanzar(Personaje p);
    public abstract int  destruir();
    public abstract int getPuntos();
    public abstract PowerUp getPowerUp();
	public abstract boolean setBomberman(Bomberman b);
	public abstract  boolean setEnemigo(Enemigo e);
	public abstract void setBomba(Bomba bm);
	public abstract void chequeoColisiones();
	public abstract void setPowerUp(PowerUp p);
}
