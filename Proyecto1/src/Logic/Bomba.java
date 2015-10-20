package Logic;

import java.util.*;

/**
 * 
 */
public class Bomba {

	/**
     * @param Position p inicializa ubicacion con p
     * @param int alcan
     */
	protected Bomberman bomberman;
	 protected int alcance;
	 protected Tablero miTablero;
	 protected Posicion ubicacion;
	 public  Bomba(Posicion p,  int alcan,Tablero tab,Bomberman b) {
	       ubicacion=p;
	       alcance=alcan;
	       miTablero=tab;
	       bomberman=b;
	    }
   
   


    /**
     * calcula las posiciones alcansadas,
     * luego busca todas las paredes que esten dentro del alcance(x+alance,x-alcance,y+alcance,y-alcance), las agrega a una estructura y luego invoca a destruir
     * Modificar la bomba del bomberman, agregarle un NULL
     */
    public void explotar() {
    	
        
    }

    
   

}