package Graphic;



import Logic.Bomberman;

public class MasacralityThread extends Thread{

	private Bomberman jugador;
	
	public MasacralityThread (Bomberman bom){
		jugador=bom;
	}
	
	public void run(){
		
		try {
			
			jugador.activarModoDios();
			
			sleep(5000);
			
			jugador.desactivarModoDios();
				
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
