package Graphic;

public class BombaThread extends Thread{
	private gBomba bomba;
	
	public BombaThread(gBomba b){
		bomba=b;
	}
	
	public void run(){
		
		try {
			
			sleep(5000);
			bomba.destruir();
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
