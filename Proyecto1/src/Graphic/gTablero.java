package Graphic;

import java.awt.Component;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.*;


public class gTablero {
	
	private Tablero t;
	
	private MaloThread mMalos[];
	
	private gJugador mJugador;
	
	private ImageIcon paredI;
	
	
	private GUI gui;
	
	public gTablero(GUI gui){
		
		paredI= new ImageIcon((this.getClass().getResource("/BattleCity/pared.png")));
		
		ponerPared(gui);
		
		// Creo el jugador y lo agrego el grafico a la gui.
		t = new Tablero(13,31);
		this.mJugador = new gJugador(t.getBomberman().getVelocidad(),t.getBomberman(), 32, 32,t);
		gui.add(this.mJugador.getGrafico());
		
		// Creo los malos y agrego a la gui su grafico.
		this.mMalos = new MaloThread[3];
		for(int i = 0; i < this.mMalos.length; i++){
			Random r = new Random();
			
			gRugulus malo = new gRugulus(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
			this.mMalos[i] = new MaloThread(malo);
			gui.add(malo.getGrafico());
			
			this.mMalos[i].start();
			
		}
	}
	
	public void mover(int dir){
		this.mJugador.mover(dir);
	}
	
	
	public void destruir(int malo) {
		if(this.mMalos[malo] != null) {
			this.mMalos[malo].destruir();
			this.mMalos[malo] = null;
		}
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
        }
		
		
		
	}
	
	
	
}