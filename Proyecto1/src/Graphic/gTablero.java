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
	
	private boolean movimientoBloqueado = false;
	
	private GUI gui;
	
	public gTablero(GUI gui){
		
		paredI= new ImageIcon((this.getClass().getResource("/BattleCity/pared.png")));
		
		ponerPared(gui);
		
		
		// Creo el jugador y lo agrego el grafico a la gui.
		t = new Tablero(13,31);
		this.mJugador = new gJugador(t.getBomberman().getVelocidad(),t.getBomberman(), 32, 32,t,this);
		gui.add(this.mJugador.getGrafico());
		
		// Creo los malos y agrego a la gui su grafico.
		this.mRugulus = new RugulusThread[3];
		/*for(int i = 0; i < this.mRugulus.length; i++){
			Random r = new Random();
			
			gRugulus malo = new gRugulus(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
			this.mRugulus[i] = new RugulusThread(malo);
			gui.add(malo.getGrafico());
			
			this.mRugulus[i].start();	
		}*/
		
		//22 11. 17 2. 12 9 
		
		//agrego los rugulus
		Enemigo rug[]=t.getEnemigos() ;
		
		gRugulus rugulus1 = new gRugulus(32,22*32,11*32,rug[0],mJugador);
		mRugulus[0] = new RugulusThread(rugulus1);
		gui.add(rugulus1.getGrafico());
		
		
		
		gRugulus rugulus2 = new gRugulus(32,17*32,2*32,rug[1],mJugador);
		mRugulus[1] = new RugulusThread(rugulus2);
		gui.add(rugulus2.getGrafico());
		
		
		
		gRugulus rugulus3 = new gRugulus(32,12*32,9*32,rug[2],mJugador);
		mRugulus[2] = new RugulusThread(rugulus3);
		gui.add(rugulus3.getGrafico());
		
		this.mRugulus[0].start();
		this.mRugulus[1].start();
		this.mRugulus[2].start();
		
		
		
		
	}
	
	public void mover(int dir) {
		//if(jugadorThread.getLocked() == false) {
			this.mJugador.mover(dir);
			//jugadorThread.bloquearMovimiento();
		//}
	}
	
	
	public void destruir(int malo) {
		/*if(this.mRugulus[malo] != null) {
			this.mRugulus[malo].destruir();
			this.mRugulus[malo] = null;
		}*/
	}
	
	public void pausar() {
		for (int i=0; i<mRugulus.length;i++)
			mRugulus[i].detener();
	}

	
	private void ponerPared(GUI gui){
		/*JLabel labelPared=new JLabel (paredI);
		gui.add(labelPared);
		labelPared.setBounds(0, 0, 32,32);*/
		
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
			        			//matrizCeldas[h][n].setContenido(new NoPared(null));  
				        	  }
			        			
	        }
		}}
		
		public void matarBomberman() {
			mJugador.destruir();
			//pausar();
			//mJugador=null;
			//mJugador= new gJugador(t.getBomberman().getVelocidad(),t.getBomberman(), 32, 32,t,this);
			//gui.add(mJugador.getGrafico());
		}		
		
	}
	
	
	
