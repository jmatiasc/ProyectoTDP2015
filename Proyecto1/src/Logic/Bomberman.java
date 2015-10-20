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
    
    public  Bomberman() {
        vidas=3;
        velocidad=1;
        cantBombas=1;
        alcanceBomba=1;
        
    }
    /**
     * 
     */
    public void moverArriba() {
    	Posicion p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-1);
    	if(tablero.obtenerCelda(p).avanzar(this)){  	
        ubicacion=p;
        tablero.obtenerCelda(p).getContenido().setBomberman(this);
    }
    }

    /**
     * 
     */
    public void moverAbajo() {
    	Posicion p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+1);
    	if(tablero.obtenerCelda(p).avanzar(this)) { 	
        ubicacion=p;
        tablero.obtenerCelda(p).getContenido().setBomberman(this);
        }
    }

    /**
     * 
     */
    public void moverIzquierda() {
    	Posicion p=new Posicion(ubicacion.getEjeX()-1,ubicacion.getEjeY());
    	if(tablero.obtenerCelda(p).avanzar(this))  	{
        ubicacion=p;
        tablero.obtenerCelda(p).getContenido().setBomberman(this);
        }
    }

    /**
     * 
     */
    public void moverDerecha() {
    	Posicion p=new Posicion(ubicacion.getEjeX()+1,ubicacion.getEjeY());
    	if(tablero.obtenerCelda(p).avanzar(this))  {	
        ubicacion=p;
        tablero.obtenerCelda(p).getContenido().setBomberman(this);
        }
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
        ubicacion=new Posicion(0,0);
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
    
}