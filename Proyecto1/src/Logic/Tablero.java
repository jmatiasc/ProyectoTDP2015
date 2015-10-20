package Logic;

import java.util.*;

/**
 * 
 */
public class Tablero {

	protected int Alto;
	protected int Ancho;
    protected Bomberman personaje;
    protected Enemigo [] misEnemigos;
    protected Pared[] paredes;
    protected Celda[][] matrizCeldas;

    /**
     * @param Alto 
     * @param Ancho
     */
    public Tablero(int Alto, int Ancho) {
    	//BOMBERMAN
    	personaje=new Bomberman(this);
    	personaje.setPosicion(new Posicion(1,1));
    	
    	//ENEMIGOS
    	Enemigo rugulus1=new Rugulus();
    	rugulus1.setPosicion(new Posicion(22,11));
    	
    	Enemigo rugulus2=new Rugulus();
    	rugulus2.setPosicion(new Posicion(17,2));
    	
    	Enemigo rugulus3=new Rugulus();
    	rugulus3.setPosicion(new Posicion(12,9));
    	
    	Enemigo altair1=new Altair();
    	altair1.setPosicion(new Posicion(2,6));
    	
    	Enemigo altair2=new Altair();
    	altair2.setPosicion(new Posicion(23,6));
    	
    	Enemigo sirius=new Sirius(personaje);
    	sirius.setPosicion(new Posicion(20,11));
  
    //lleno el arreglo de enemigos
    	misEnemigos=new Enemigo[6];
    	misEnemigos[0]=rugulus1;
    	misEnemigos[1]=rugulus2;
    	misEnemigos[2]=rugulus3;
    	misEnemigos[3]=altair1;
    	misEnemigos[4]=altair2;
    	misEnemigos[5]=sirius;
    
    	this.Ancho = Ancho;
    	this.Alto = Alto;
    	
        matrizCeldas=new Celda[Ancho][Alto];
        
        
        //LLENO DE CELDAS LA MATRIZ
        for(int i=0; i< Ancho;i++){
        	for(int j=0;j<Alto;j++){
        		matrizCeldas[i][j]=new Celda(new Posicion(i,j));
        	}
        	
        }
        
        
        //AGREGO LAS PAREDES INDESTRUCTIBLES A LAS CELDAS
        for(int h=0;h<Ancho;h++){
	        for(int n=0;n<Alto;n++){
	        	
	        	if(n==0){
		        	matrizCeldas[h][n].setContenido(new Pared());  
		        	matrizCeldas[h][n].getContenido().setEstado(new Indestructible());  
		        	}
		        	else 
		        		if(h==0){
			        	matrizCeldas[h][n].setContenido(new Pared());  
			        	matrizCeldas[h][n].getContenido().setEstado(new Indestructible());  
			        	}
		        		else
		        			if(n==12){
		    		        	matrizCeldas[h][n].setContenido(new Pared());  
		    		        	matrizCeldas[h][n].getContenido().setEstado(new Indestructible());  
		    		        	}
		    		        	else 
		    		        		if(h==30){
		    			        	matrizCeldas[h][n].setContenido(new Pared());  
		    			        	matrizCeldas[h][n].getContenido().setEstado(new Indestructible());  
		    			        	}
			        	else 
			        		if(h%2==0 && n%2==0){
				        	matrizCeldas[h][n].setContenido(new Pared());  
				        	matrizCeldas[h][n].getContenido().setEstado(new Indestructible());  
				        	}
	        				//AGREGO AL RESTO TODAS NoPared para prototipo
			        		else{
			        			matrizCeldas[h][n].setContenido(new NoPared(null));  
				        	  }
			        			
	        }
        }
        
        
        
        //LAS PAREDES DESTRUCTIBLES SE AGREGAN EN LUGARES AL AZAR, el 50% de las celdas que aun no han sido ocupadas(TOTAL 403,TOTAL DE DESOCUPADAS 160, TOTAL OCUPADAS(INDESTRUCTIBLES)=243)
        
        /**for(int t=0;t<81;t++){
        	
        }
        **/
        
        
        
        
    }

    
    public void borrarBomberman(){
    	Posicion p=personaje.getPosicion();
    	obtenerCelda(p).getContenido().setBomberman(null);
    	personaje.setPosicion(null);
    	personaje=null;
    }

    public Celda obtenerCelda(Posicion p){
    	return matrizCeldas[p.getEjeX()][p.getEjeY()];
    }
    
    public Bomberman getBomberman() {
    	return personaje;
    }
    
    public Enemigo[] getEnemigos() {
    	return misEnemigos;
    }
    
    public Celda[][] getMatrizCeldas() {
    	return matrizCeldas;
    }
 
}