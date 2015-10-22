package Graphic;

import java.awt.Component;
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
	
	PowerUpVelocidad velocidad;
	
	public gTablero(GUI gui){
		
		paredI= new ImageIcon((this.getClass().getResource("/BattleCity/pared.png")));
		
		ponerPared(gui);
		
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
		
		
		velocidad=new PowerUpVelocidad(3*32,6*32,t.getVelocidad());
		gui.add(velocidad.getGrafico());
		
		
		
		
		
		
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
			velocidad=null;}
		
			
		}
	}
	
	public void destruir(int malo) {
		/*if(this.mRugulus[malo] != null) {
			this.mRugulus[malo].destruir();
			this.mRugulus[malo] = null;
		}*/
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
	        				//AGREGO AL RESTO TODAS NoPared para prototipo
			        		else{
			        			//aca van las noparedes o caminos
			        			//matrizCeldas[h][n].setContenido(new NoPared(null));  
				        	  }
			        			
	        }
		}}
		
		public void matarBomberman(){
			mJugador.destruir();
			mJugador=null;
			
		}
		
		
		
		
	}
	
	
	
