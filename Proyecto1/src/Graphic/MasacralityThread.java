package Graphic;



import java.applet.AudioClip;

import Logic.Bomberman;

public class MasacralityThread extends Thread{

	private Bomberman jugador;
	private AudioClip masacrality;
	
	public MasacralityThread (Bomberman bom){
		masacrality=java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Masacrality.wav"));
		jugador=bom;
	}
	
	public void run(){
		
		try {
			
			jugador.activarModoDios();
			masacrality.play();
			masacrality.loop();
			
			sleep(5000);
			jugador.desactivarModoDios();
			masacrality.stop();
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
