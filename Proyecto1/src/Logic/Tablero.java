package Logic;

import java.util.*;

/**
 * Clase Tablero
 * @author BERNABÉ DI MARCO, MATIAS CABRERA, GABRIEL PAEZ
 *
 */
public class Tablero {

	protected int Alto;
	protected int Ancho;
    protected Bomberman personaje;
    protected Enemigo [] misEnemigos;
    protected Pared[] paredes;
    protected Celda[][] matrizCeldas;
    protected Posicion [] posDestructible;
    
    
    //CAMBIAR POR UN ARREGLO DE POWERUPS 
    protected SpeedUp velocidad;
    protected Bombality bombality;
    protected Fatality fatality;
    protected Masacrality masacrality;

    /**
     * @param Alto 
     * @param Ancho
     */
    public Tablero(int Alto, int Ancho) {
    	//BOMBERMAN
    	personaje=new Bomberman(this);
    	personaje.setPosicion(new Posicion(1,1));
    	
    	
    
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
        int cantIndestructibles=81;
        Random num=new Random();
		int azar=0;
		posDestructible=new Posicion[81];
		int ult=0;
		
		
		
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
			        			if(cantIndestructibles!=0 && h!=1 && h!=2 && n!=1 && n!=2){
			        			azar=num.nextInt()%2;
			        			if(azar==1){
			        				matrizCeldas[h][n].setContenido(new Pared());
			        				matrizCeldas[h][n].getContenido().setEstado(new Destructible(null));
			        				posDestructible[ult]=new Posicion(h,n);
			        				ult++;
			        				cantIndestructibles--;
			        				} 
			        			else matrizCeldas[h][n].setContenido(new NoPared(null));  
			        			}
			        			else  matrizCeldas[h][n].setContenido(new NoPared(null));
				        	  }
			        			
	        }
        }
        
       
        //LAS PAREDES DESTRUCTIBLES SE AGREGAN EN LUGARES AL AZAR, el 50% de las celdas que aun no han sido ocupadas(TOTAL 403,TOTAL DE DESOCUPADAS 160, TOTAL OCUPADAS(INDESTRUCTIBLES)=243)
        //DEBO AGREGAR 81 PAREDES DESTRUCTIBLES
        
        
        
        
      //ENEMIGOS
    	Enemigo rugulus1=new Rugulus(new Posicion(22,11),this);
    	this.obtenerCelda(rugulus1.getPosicion()).getContenido().setEnemigo(rugulus1);
    	
    	
    	
    	
    	Enemigo rugulus2=new Rugulus(new Posicion(17,2),this);
    	this.obtenerCelda(rugulus2.getPosicion()).getContenido().setEnemigo(rugulus2);
    	
    	
    	
    	
    	Enemigo rugulus3=new Rugulus(new Posicion(12,9),this);
    	this.obtenerCelda(rugulus3.getPosicion()).getContenido().setEnemigo(rugulus3);
    	
    	
    	Enemigo altair1=new Altair(new Posicion(2,6),this);
    	this.obtenerCelda(altair1.getPosicion()).getContenido().setEnemigo(altair1);
    	
    	Enemigo altair2=new Altair(new Posicion(23,6),this);
    	this.obtenerCelda(altair2.getPosicion()).getContenido().setEnemigo(altair2);
    	
    	Enemigo sirius=new Sirius(new Posicion(20,11),this,personaje);
    	this.obtenerCelda(sirius.getPosicion()).getContenido().setEnemigo(sirius);
    	
  
    //lleno el arreglo de enemigos
    	misEnemigos=new Enemigo[6];
    	misEnemigos[0]=rugulus1;
    	misEnemigos[1]=rugulus2;
    	misEnemigos[2]=rugulus3;
    	misEnemigos[3]=altair1;
    	misEnemigos[4]=altair2;
    	misEnemigos[5]=sirius;
        
    	//creo PowerUp Velocidad
    	velocidad=new SpeedUp(personaje);
    	velocidad.setPosicion(new Posicion(3,6));
    	obtenerCelda(velocidad.getPosicion()).getContenido().setPowerUp(velocidad);
    	
    	
    	bombality=new Bombality(personaje);
    	bombality.setPosicion(new Posicion(3,11));
    	obtenerCelda(bombality.getPosicion()).getContenido().setPowerUp(bombality);
    	
    	
    	fatality=new Fatality(personaje);
    	fatality.setPosicion(new Posicion(6,11));
    	obtenerCelda(fatality.getPosicion()).getContenido().setPowerUp(fatality);
    	
    	
    	masacrality=new Masacrality(personaje);
    	masacrality.setPosicion(new Posicion(10,11));
    	obtenerCelda(masacrality.getPosicion()).getContenido().setPowerUp(masacrality);
    	
    	
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
    
    public Posicion [] getPosDestructibles(){
    	return posDestructible;
    }
    
    
    
    public SpeedUp getVelocidad(){
    	return velocidad;
    }
 
    public Bombality getBombality(){return bombality;}
    
    
    
    public Fatality getFatality(){	return fatality;}
        
    public Masacrality getMasacrality(){return masacrality;}
}