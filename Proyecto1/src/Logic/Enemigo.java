package Logic;

import java.util.*;

/**
 * Clase Enemigo
 * @author Bernabe - Cabrera - Paez
 *
 */
public abstract class Enemigo extends Personaje
{
    protected Posicion ubicacion;
    protected int velocidad;
    protected int puntos;
    protected Tablero tablero;
    
    /**
     * Constructor
     * @param t Tablero
     */
    public Enemigo(Tablero t) 
    {
    	tablero=t;
    }
    
    /**
     * Modifica la ubicación del enemigo y ademas actualiza su posicion en tablero
     * @return 0 si el enemigo se mueve hacia arriba
     * @return 1 si el enemigo se mueve hacia abajo
     * @return 2 si el enemigo se mueve hacia la izquierda
     * @return 3 si el enemigo se mueve hacia la derecha
     * @return -1 si el enemigo no se puede mover
     */
    public int mover()
    {
    	if(ubicacion.getEjeX()!=0 && ubicacion.getEjeY()!=0)
    	{
    		Random num=new Random();
    		int n=num.nextInt()%4;
    		if(n<0)
    			n=Math.abs(n);
    		Posicion p;
    		if(n==0)
    		{
    			//muevo arriba
    			p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-1);
    			if(p.ejeY<0)
    				p.setEjeY(0);
    		}
	        else
	        	if(n==1)
	        	{
	        		//muevo abajo
	        		p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+1);
	        		if(p.ejeY>12)p.setEjeY(12);
	       		}
	       		else 
	       			if(n==2)
	        		{
	        			//muevo izquierda
			        	p=new Posicion(ubicacion.getEjeX()-1,ubicacion.getEjeY());
				        if(p.ejeX<0)p.setEjeX(0);
		        	}
					else
					{
			        	//muevo derecha
					    p=new Posicion(ubicacion.getEjeX()+1,ubicacion.getEjeY());
					    if(p.ejeX>30)p.setEjeX(30);
			         }
        if( p!=null && tablero.obtenerCelda(p).avanzar(this) )  
        {	
        	tablero.obtenerCelda(ubicacion).getContenido().setEnemigo(null);
            ubicacion=p;
            tablero.obtenerCelda(p).getContenido().setEnemigo(this);
            tablero.obtenerCelda(p).getContenido().chequeoColisiones();
            return n;
	    }
        return -1;
        }
    	else return -1;
    }
    
    /**
     * Mata al personaje principal del juego (Bomberman)
     */
    public void matarBomberman() 
    {}
    
    /**
     * Mata al enemigo y devuelve el puntaje que otorga al ser destruído
     * @return puntos puntaje de la destrucción del enemigo
     */
    public int destruir() 
    {
       ubicacion=new Posicion(0,0);
       return puntos;
    }

    /**
     * Devuelve el puntaje que otorga un enemigo al ser destruído
     * @return puntos puntaje 
     */
    public int getPuntos() 
    {
        return 0;
    }
    
    /**
     * Devuelve la posición del enemigo en el tablero
     * @return ubicacion posición del enemigo
     */
    public Posicion getPosicion()
    {
    	return ubicacion;
    }

}