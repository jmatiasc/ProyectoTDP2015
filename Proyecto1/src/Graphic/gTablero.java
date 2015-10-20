package Graphic;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.*;


public class gTablero {
	
	private Tablero t;
	
	private MaloThread mMalos[];
	
	private gJugador mJugador;
	
	
	
	private GUI gui;
	
	public gTablero(GUI gui){
		this.gui=gui;	

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

}