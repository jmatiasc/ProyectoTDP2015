package Logic;

import java.util.*;

/**
 * Clase Sirius
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Sirius extends Enemigo {

	protected Bomberman bomberman;
	
    public Sirius(Posicion p,Tablero t,Bomberman b) {    
    	super(t);
    	ubicacion=p;
        velocidad=1;
        bomberman=b;
        modoDios=false;
    }

    
    
    //FALTA IMPLEMENTAR LA MANERA EN QUE EL SIRIUS VA A SEGUIR AL BOMBERMAN
    public int mover() {

    	
    	if(ubicacion.getEjeX()!=0 && ubicacion.getEjeY()!=0)
    	{
    		
    		Posicion p;
    		
    		
    		int n=elegirDireccion();
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
    
   
    
    private int elegirDireccion(){
    	int n;
    	Posicion posBomb=bomberman.getPosicion();
    	Posicion p;
    	
    	if(ubicacion.getEjeY()>posBomb.getEjeY()){
    		p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()-1);
    			if(tablero.obtenerCelda(p).avanzar(this))
    			return 0;
    		}
    	if(ubicacion.getEjeY()<posBomb.getEjeY()){
    		p=new Posicion(ubicacion.getEjeX(),ubicacion.getEjeY()+1);
    		if(tablero.obtenerCelda(p).avanzar(this))
    		return 1;
    	}
    	if(ubicacion.getEjeX()>posBomb.getEjeX()){
    		p=new Posicion(ubicacion.getEjeX()-1,ubicacion.getEjeY());
    		if(tablero.obtenerCelda(p).avanzar(this))
    			return 2;   	
    	}
    	return 3;
    	
    }
}

    	
    	
    	
    	
    	
    	
    	
    

