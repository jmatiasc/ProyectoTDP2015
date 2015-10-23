package Logic;

import java.util.*;

/**
 * 
 */
public class Bomberman extends Personaje {

   
    protected int velocidad;
    protected int cantBombas;
    protected int alcanceBomba;
 
    protected Tablero tablero;
    protected int puntos;
    
    public  Bomberman(Tablero t) {
        
        velocidad=32;
        cantBombas=1;
        alcanceBomba=1;
        tablero = t;
        puntos=0;
    }
    /**
     * 
     */
    public boolean moverArriba() {
    	Posicion p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-1);
    	if(p.ejeY<0)
    		p.setEjeY(0);
    	if(tablero.obtenerCelda(p).avanzar(this)){  	
    		tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
	        ubicacion=p;
	        tablero.obtenerCelda(p).getContenido().setBomberman(this);
	        tablero.obtenerCelda(p).getContenido().chequeoColisiones();
        return true;
    	}
    	else return false;
    }

    /**
     * 
     */
    public boolean moverAbajo() {
    	
    	Posicion p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+1);
    	if(p.ejeY>12)p.setEjeY(12);
    	if(tablero.obtenerCelda(p).avanzar(this)) { 
    		tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
	        ubicacion=p;
	        tablero.obtenerCelda(p).getContenido().setBomberman(this);
	        tablero.obtenerCelda(p).getContenido().chequeoColisiones();
	        return true;
    	}
    	else return false;
    }

    /**
     * 
     */
    public boolean moverIzquierda() {
    	Posicion p=new Posicion(ubicacion.getEjeX()-1,ubicacion.getEjeY());
    	if(p.ejeX<0)p.setEjeX(0);
    	if(tablero.obtenerCelda(p).avanzar(this))  	{
    		tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
	        ubicacion=p;
	        tablero.obtenerCelda(p).getContenido().setBomberman(this);
	        tablero.obtenerCelda(p).getContenido().chequeoColisiones();
	        return true;
	    	}
	    	else return false;
    }

    /**
     * 
     */
    public boolean moverDerecha() {
    	Posicion p=new Posicion(ubicacion.getEjeX()+1,ubicacion.getEjeY());
    	if(p.ejeX>30)p.setEjeX(30);
    	if(tablero.obtenerCelda(p).avanzar(this))  {	
    		tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
        ubicacion=p;
        tablero.obtenerCelda(p).getContenido().setBomberman(this);
        tablero.obtenerCelda(p).getContenido().chequeoColisiones();
        return true;
    	}
    	else return false;
    }

    /**
     * 
     */
    public Bomba dejarBomba() {
    	if(cantBombas!=0){
	    	cantBombas--;
	    	Bomba miBomba=new Bomba(ubicacion,alcanceBomba,tablero,this);
	    	tablero.obtenerCelda(ubicacion).getContenido().setBomba(miBomba);
	    	puntos+=miBomba.activar();
	    	return miBomba;
	    	
	    	}
    	else return null;
	    	
    }

    /**
     * 
     */
    public void aumentarVelocidad() {
        velocidad=velocidad*2;
    }

    /**
     * 
     */
    
    public void aumentarCantBombas(){
    	cantBombas++;
    }
    
    /**
     * 
     */
    public void aumentarAlcance(){
    	alcanceBomba=alcanceBomba*2;
    }
    /**
     * 
     */
    
    public void morir() {
      
    	
    	tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
    	
    	
        ubicacion.setEjeY(1);
        ubicacion.setEjeX(1);
        
        tablero.obtenerCelda(ubicacion).getContenido().setBomberman(this);
        
        
        tablero.borrarBomberman();
    }

    /**
     * @param PowerUp p
     */
    public void powerUp(PowerUp p) {
        p.aumentarCantidadBombas();
        p.aumentarVelocidad();
        p.duplicarAlcance();
        p.fullAtributos();
    }

    /**
     * 
     */
    public void activarModoDios(){
    	modoDios=true;
    	int auxVel=velocidad;
        int auxCB=cantBombas;
    	velocidad=99999999;
        cantBombas=99999999;
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        modoDios=false;
        int velocidad=auxVel;
        int cantBombas=auxCB;
        
        
        
    }
    
    
    public void desactibarModoDios(){
    	
    }

    public Posicion getPosicion(){
    	return ubicacion;
    }
    
    public int getVelocidad() {
    	return velocidad;
    }
}