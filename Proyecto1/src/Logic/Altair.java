package Logic;

import java.util.*;

public class Altair extends Enemigo {

	public void Altair(Posicion p) {
        ubicacion=p;
        velocidad=1;
        modoDios=true;
    }

   
    public void mover() {
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
    }



}