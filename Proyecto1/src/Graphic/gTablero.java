package Graphic;

import java.awt.Component;
import java.awt.Point;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.*;


public class gTablero {
	
	private Tablero t;
	
	private RugulusThread mRugulus[];
	
	private gJugador mJugador;
	
	private ImageIcon paredI;

	
	private GUI gui;
	
	private PowerUpVelocidad velocidad;
	private PowerUpBombality bombality;

	private gBomba bomba;
	
	public gTablero(GUI gui){
		this.gui=gui;
		
		paredI= new ImageIcon((this.getClass().getResource("/imagenes/pared.png")));
	
		
		
		
		// Creo el jugador y lo agrego el grafico a la gui.
		t = new Tablero(13,31);
		this.mJugador = new gJugador(t.getBomberman().getVelocidad(),t.getBomberman(), 32, 32,t,this);
		gui.add(this.mJugador.getGrafico());
		
		// Creo los malos y agrego a la gui su grafico.
		this.mRugulus = new RugulusThread[3];
		
		//agrego los rugulus en posiciones que coinciden con las que creo los rugulus en el tablero
		Enemigo rug[]=t.getEnemigos() ;
		
		//gRugulus rugulus1 = new gRugulus(32,22*32,11*32,rug[0],mJugador);
		gRugulus rugulus1 = new gRugulus(32,rug[0].getPosicion().getEjeX()*32,rug[0].getPosicion().getEjeY()*32,rug[0],mJugador);
		mRugulus[0] = new RugulusThread(rugulus1);
		gui.add(rugulus1.getGrafico());
		
		
		
		//gRugulus rugulus2 = new gRugulus(32,17*32,2*32,rug[1],mJugador);
		gRugulus rugulus2 = new gRugulus(32,rug[1].getPosicion().getEjeX()*32,rug[1].getPosicion().getEjeY()*32,rug[1],mJugador);
		mRugulus[1] = new RugulusThread(rugulus2);
		gui.add(rugulus2.getGrafico());
		
		
		
		//gRugulus rugulus3 = new gRugulus(32,12*32,9*32,rug[2],mJugador);
		gRugulus rugulus3 = new gRugulus(32,rug[2].getPosicion().getEjeX()*32,rug[2].getPosicion().getEjeY()*32,rug[2],mJugador);
		mRugulus[2] = new RugulusThread(rugulus3);
		gui.add(rugulus3.getGrafico());
		
		this.mRugulus[0].start();
		this.mRugulus[1].start();
		this.mRugulus[2].start();
		
		
		velocidad=new PowerUpVelocidad(3*32,6*32);
		gui.add(velocidad.getGrafico());
		
		Posicion pos=t.getBombality().getPosicion();
		bombality=new PowerUpBombality(pos.getEjeX()*32,pos.getEjeY()*32);
		
		gui.add(bombality.getGrafico());
		ponerPared(gui);
		
		
		
		
		
	}
	
	public void mover(int dir){
		if(mJugador!=null){
		this.mJugador.mover(dir);
		chequeoColisiones();
		}
		
	}
	
	//el chequeo lo debo cambiar a cada powerUp
	private void chequeoColisiones(){
		if (velocidad!=null){
				if(velocidad.getPosicion().equals(mJugador.getPosicion())){
					mJugador.aumentarVelocidad();
					velocidad.destruir();
					this.velocidad=null;}	
				}
		if (bombality!=null){
			if(bombality.getPosicion().equals(mJugador.getPosicion())){
				mJugador.aumentarBombas();
				bombality.destruir();
				this.bombality=null;}
			}
	}
	
	public void destruir(int malo) {
	
	}

	
	private void ponerPared(GUI gui){
		
		for(int h=0;h<31;h++){
	        for(int n=0;n<13;n++){
	        	
	        	if(n==0){
	        		JLabel labelPared=new JLabel (paredI);
	        		gui.add(labelPared);
	        		labelPared.setBounds(h*32,0, 32,32);
		        	}
		        	else 
		        		if(h==0){  JLabel labelPared=new JLabel (paredI);
		        		gui.add(labelPared);
		        		labelPared.setBounds(0, n*32, 32,32);
			        	}
		        		else
		        			if(n==12){
		        				 JLabel labelPared=new JLabel (paredI);
		 		        		gui.add(labelPared);
		 		        		labelPared.setBounds(h*32, n*32, 32,32);
		    		        	}
		    		        	else 
		    		        		if(h==30){
		    		        			 JLabel labelPared=new JLabel (paredI);
		 		 		        		gui.add(labelPared);
		 		 		        		labelPared.setBounds(h*32, n*32, 32,32);
		    			        	
		    			        	}
			        	else 
			        		if(h%2==0 && n%2==0){
			        			 JLabel labelPared=new JLabel (paredI);
			 		        		gui.add(labelPared);
			 		        		labelPared.setBounds(h*32, n*32, 32,32);
				        	
				        	}
	        		
			        			 
				        	  
			        			
	        }
		}}
		
		public void matarBomberman(){
			mJugador.destruir();

			mJugador=null;
			
		}
		
		
		public void dejarBomba(Point p,Bomba b){	
					gBomba bomba=new gBomba(b,this); //Cambio
					bomba.setPosicion(p);
					bomba.dejarBomba();
					gui.add(bomba.getGrafico());
					BombaThread tb=new BombaThread(bomba);
					
					tb.start();
					
					
		
			}
		public void mostrarExplosion(Point p){
			//cuando alcance es 1
					Point  arriba[]=new Point[1];
					Point abajo[]=new Point[1];
					Point izquierda[]=new Point[1];
					Point derecha[]=new Point[1];
					
			
			
			for(int i=0; i<1;i++){
	    		 arriba[i]=new Point(p.x,p.y-(i+32));
	    		
	    		 abajo[i]=new Point(p.x,p.y+(i+32));
	    		 izquierda[i]=new Point(p.x-(i+32),p.y);
	    		 derecha[i]=new Point(p.x+(i+32),p.y);
	    		 }
			
				Explosion [] arreglo=new Explosion[5];
			
				int a=0;
				for(int  i=0; i<arriba.length;i++){
				arreglo[a]=new Explosion(arriba[i]);
				a++;
				}
				
				for(int i=0; i<abajo.length;i++){
					arreglo[a]=new Explosion(abajo[i]);
					a++;
				}
				
				for(int i=0; i<derecha.length;i++){
					arreglo[a]=new Explosion(derecha[i]);
					a++;
				}
				
				for(int i=0; i<izquierda.length;i++){
					arreglo[a]=new Explosion(izquierda[i]);
					a++;
				}
				arreglo[4]=new Explosion(p);
				
				ImageIcon mPowerUpV = new ImageIcon(this.getClass().getResource("/imagenes/explosion.png")); //Agregue esto 1/2
				for(int i=0; i<arreglo.length;i++){
					gui.add(arreglo[i].getGrafico());
					arreglo[i].getGrafico().setIcon(mPowerUpV);//agregue esto 2/2
					
				}
				
				ThreadRetardo t=new ThreadRetardo(arreglo,gui);
				t.start();
				
				
				
			}
		
		
}