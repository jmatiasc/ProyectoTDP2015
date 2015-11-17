package Logic;

import java.awt.Point;
import java.util.*;

import javax.swing.ImageIcon;

import Graphic.Explosion;
import Graphic.ThreadRetardo;

/**
 * Clase Bomba
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Bomba {
	protected Bomberman bomberman;
	protected int alcance;
	protected Tablero miTablero;
	protected Posicion ubicacion;

	/**
	 * Constructor de bomba
	 * @param p Posición inicial de la bomba.
	 * @param alcan Alcance de la bomba.
	 * @param tab Tablero al que pertenece la bomba.
	 * @param b Bomberman al que estara ligado la bomba.
	 */
	public  Bomba(Posicion p,  int alcan,Tablero tab,Bomberman b) {
		ubicacion=p;
		alcance=alcan;
		miTablero=tab;
		bomberman=b;
	}
	
   /**
    * Calcula las posiciones alcanzadas, luego busca todas las paredes que esten dentro
    * del alcance(x+alance,x-alcance,y+alcance,y-alcance), las agrega a una estructura y luego invoca a destruir
    * Modificar la bomba del bomberman, agregarle un NULL
    */
	public Celda [] activar() {
		
    	
    	Posicion  arriba[]=new Posicion[alcance];
    	Posicion abajo[]=new Posicion[alcance];
    	Posicion izquierda[]=new Posicion[alcance];
    	Posicion derecha[]=new Posicion[alcance];
    	
    	int posArriba=0;
    	int posAbajo=0;
    	int posIzquierda=0;
    	int posDerecha=0;
    	
    	
    	

		for(int i=1; i<alcance+1;i++){
			
			posArriba=ubicacion.getEjeY()-1;
			if(posArriba>0 )
			 arriba[i-1]=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-i);
						
			
			posAbajo=ubicacion.getEjeY()+1;
			 if(posAbajo<12)
			 abajo[i-1]=new Posicion(ubicacion.getEjeX(),(ubicacion.getEjeY()+i));
			 
			 posIzquierda=ubicacion.getEjeX()-1;
			 if(posIzquierda>0)
			 izquierda[i-1]=new Posicion((ubicacion.getEjeX()-i),ubicacion.getEjeY());
			 
			 
			 
			 posDerecha=ubicacion.getEjeY()+1;
			 if(posDerecha<30)
			 derecha[i-1]=new Posicion((ubicacion.getEjeX()+i),ubicacion.getEjeY());
			 
			 
			 }
		
			int cant=alcance*4+1;
			Celda [] arreglo=new Celda[cant];
			arreglo[0]=miTablero.obtenerCelda(ubicacion);
			
			
			
			boolean seguirArriba=true;
	    	boolean seguirAbajo=true;
	    	boolean seguirIzquierda=true;
	    	boolean seguirDerecha=true;
			
			
			int a=1;
			for(int  i=0; i<arriba.length;i++){
				if(arriba[i]!=null && seguirArriba){
					if(!miTablero.obtenerCelda(arriba[i]).avanzar(bomberman))
						seguirArriba=false;
					arreglo[a]=miTablero.obtenerCelda(arriba[i]);}
					a++;
			}
			
			for(int i=0; i<abajo.length;i++){
				if(abajo[i]!=null && seguirAbajo){
					if(!miTablero.obtenerCelda(abajo[i]).avanzar(bomberman)){
						seguirAbajo=false;
						
					}
				arreglo[a]=miTablero.obtenerCelda(abajo[i]);}
				a++;
			}
			
			for(int i=0; i<derecha.length;i++){
				if(derecha[i]!=null && seguirDerecha){
					if(!miTablero.obtenerCelda(derecha[i]).avanzar(bomberman))
						seguirDerecha=false;
				arreglo[a]=miTablero.obtenerCelda(derecha[i]);}
				a++;
			}
			
			for(int i=0; i<izquierda.length;i++){
				if(izquierda[i]!=null && seguirIzquierda){
					if(!miTablero.obtenerCelda(izquierda[i]).avanzar(bomberman))
						seguirIzquierda=false;
				arreglo[a]=miTablero.obtenerCelda(izquierda[i]);}
				a++;
			}
			return arreglo;
    }
    
	/**
	 * Aumenta la cantidad de bombas de Bomberman luego de que la bomba explota.
	 */
    public int explotar(Celda [] arreglo) {
    	
    	
    			int puntos=0;
				
				
				
				for(int i=0; i<arreglo.length;i++){
					if(arreglo[i]!=null)
					puntos+=arreglo[i].destruir();
					
				}
				
			    	if(!bomberman.GetModoDios())
			    	bomberman.aumentarCantBombas();
			    	
			    	miTablero.obtenerCelda(ubicacion).getContenido().setBomba(null);
			    	
			    	bomberman.sumarPuntos(puntos);
			    	
		return puntos;
    }
    
    /**
     * Calcula los puntos que otorga una Celda si es alcanzada por la explosión de la bomba.
     * @param arreglo Arreglo de celdas.
     * @return Puntos otorgados por la explosión de la bomba.
     */

    public int getAlcance(){
    	return alcance;
    }
}