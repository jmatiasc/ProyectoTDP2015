package Logic;

import java.util.*;

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
	public int activar() {
		/* Celda actual=miTablero.obtenerCelda(ubicacion);
		Celda arriba[]=new Celda[alcance];
		Celda abajo[]=new Celda[alcance];
    	Celda izquierda[]=new Celda[alcance];
    	Celda derecha[]=new Celda[alcance];
    	 
    	for(int i=0; i<alcance;i++){
    		arriba[i]=miTablero.obtenerCelda(new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-(i+1)));
    		abajo[i]=miTablero.obtenerCelda(new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+(i+1)));
    		izquierda[i]=miTablero.obtenerCelda(new Posicion(ubicacion.getEjeX()-(i+1),ubicacion.getEjeY()));
    		derecha[i]=miTablero.obtenerCelda(new Posicion(ubicacion.getEjeX()+(i+1),ubicacion.getEjeY()));}
    	 
    	//deben transcurrir 3 segundos antes de que explote
    	int puntos=actual.destruir();
    	 
    	puntos+=explosion(arriba);
    	puntos+=explosion(abajo);
    	puntos+=explosion(izquierda);
    	puntos+=explosion(derecha); 
    	 
    	return puntos;*/
    	
    	return 0;
    }
    
	/**
	 * Aumenta la cantidad de bombas de Bomberman luego de que la bomba explota.
	 */
    public void explotar() {
    	if(!bomberman.GetModoDios())
    	bomberman.aumentarCantBombas();
    }
    
    /**
     * Calcula los puntos que otorga una Celda si es alcanzada por la explosión de la bomba.
     * @param arreglo Arreglo de celdas.
     * @return Puntos otorgados por la explosión de la bomba.
     */
    private int explosion(Celda arreglo[]) {
    	int suma=0;
    	int aux=0;
    	boolean listo=false;
    	int j=0;
    	while((!listo) || (j!=arreglo.length)) {
	    	aux = suma;
	    	suma += arreglo[j].destruir();
	    	if (suma-aux!=0)
	    		listo=true;
			else
				j++;
	   	}	
	    return suma;
    }
    public int getAlcance(){
    	return alcance;
    }
}