package Logic;

import java.util.*;

/**
 * Clase Sirius
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Sirius extends Enemigo {

	protected Bomberman bomberman;
	
    public Sirius(Bomberman b,Tablero t) {    
    	super(t);
        velocidad=1;
        bomberman=b;
        modoDios=false;
    }

    
    
    //FALTA IMPLEMENTAR LA MANERA EN QUE EL SIRIUS VA A SEGUIR AL BOMBERMAN
    public int mover() {
        Random num=new Random();
        int n=num.nextInt()%4;
        Posicion p;
        if(n==0){
        	p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-1);}
        else
        	if(n==1){
			        p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+1);
        			}
		        else if(n==2){
				        	p=new Posicion(ubicacion.getEjeX()-1,ubicacion.getEjeY());}
					        else {
					        	p=new Posicion(ubicacion.getEjeX()+1,ubicacion.getEjeY());
					        	
					        }
        if(tablero.obtenerCelda(p).avanzar(this))  	{
            ubicacion=p;
            tablero.obtenerCelda(p).getContenido().setEnemigo(this);
	        }
        
        return 0;
    }
   

}