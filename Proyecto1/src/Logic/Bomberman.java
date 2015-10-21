package Logic;

import java.util.*;

/**
 * 
 */
public class Bomberman extends Personaje {

    protected int vidas;
    protected int velocidad;
    protected int cantBombas;
    protected int alcanceBomba;
    protected Bomba miBomba;
    protected Tablero tablero;
    
    public  Bomberman(Tablero t) {
        vidas=3;
        velocidad=32;
        cantBombas=1;
        alcanceBomba=1;
        tablero = t;
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
     * crea una bomba(new bomba(Poscion ubicacion,alcanceBomba))
     */
    public void dejarBomba() {
    	miBomba=new Bomba(ubicacion,alcanceBomba,tablero,this);
    	tablero.obtenerCelda(ubicacion).getContenido().setBomba(miBomba);
    	//falta agregarla al tablero??????
    }

    /**
     * 
     */
    public void aumentarVelocidad() {
        velocidad++;
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
        vidas--;
    	
    	tablero.obtenerCelda(ubicacion).getContenido().setBomberman(null);
    	
    	
        ubicacion.setEjeY(1);
        ubicacion.setEjeX(1);
        
        tablero.obtenerCelda(ubicacion).getContenido().setBomberman(this);
        
        if(vidas==0)tablero.borrarBomberman();
        	
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
        //PASAN 5 SEGUNDOS Y LO MODIFICADO VUELVE A LOS VALORES ANTES OBTENIDOS
        modoDios=false;
        int velocidad=auxVel;
        int cantBombas=auxCB;
        
        
        
    }

    public Posicion getPosicion(){
    	return ubicacion;
    }
    
    public int getVelocidad() {
    	return velocidad;
    }
}