package Logic;

import java.util.*;


public abstract class Enemigo extends Personaje {

   
    protected Posicion ubicacion;
    protected int velocidad;
    protected int puntos;
    protected Tablero tablero;
    
    public Enemigo(Tablero t) {
    	tablero=t;
    }
    /**
     * modifica la ubicacion del enemigo y ademas actualiza su posicion en tablero
     */
    public int mover() {
    	
    	Random num=new Random();
        int n=num.nextInt()%4;
        if(n<0)n=Math.abs(n);
        
        Posicion p;
        if(n==0){
        	//muevo arriba
        	p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-1);
        	if(p.ejeY<0)
        		p.setEjeY(0);}
	        else
	        	if(n==1){
	        			//muevo abajo
				        p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+1);
				        if(p.ejeY>12)p.setEjeY(12);
	        			}
			        else if(n==2){
			        			//muevo izquierda
					        	p=new Posicion(ubicacion.getEjeX()-1,ubicacion.getEjeY());
					        	if(p.ejeX<0)p.setEjeX(0);
			        			}
						        else {
						        	//muevo derecha
						        	p=new Posicion(ubicacion.getEjeX()+1,ubicacion.getEjeY());
						        	if(p.ejeX>30)p.setEjeX(30);
						        }
        if(tablero.obtenerCelda(p).avanzar(this))  	{
        	tablero.obtenerCelda(ubicacion).getContenido().setEnemigo(null);
            ubicacion=p;
            tablero.obtenerCelda(p).getContenido().setEnemigo(this);
            tablero.obtenerCelda(p).getContenido().chequeoColisiones();
            return n;
	        }
        return -1;
    }
    public void matarBomberman() {
        // TODO implement here
    }
    /**
     * mata al enemigo, ubicacion=null
     */
    public void destruir() {
        // TODO implement here
    }

    public int getPuntos() {
        // TODO implement here
        return 0;
    }
    
    public Posicion getPosicion(){
    	return ubicacion;
    }

}