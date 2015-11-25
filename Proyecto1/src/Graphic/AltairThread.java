package Graphic;

public class AltairThread extends Thread {

	
	private gAltair mLogica;

	
	private volatile boolean mDetener;

	public AltairThread(gAltair logica) {
		this.mLogica = logica;
		this.mDetener = false;
	}

	public void run() {
		
		while (!this.mDetener) {
			
			try {
				Thread.sleep(400);
				
				this.mLogica.mover();
			} catch (InterruptedException e) {
			}
		}
	}

	public void detener() {
		
		this.interrupt();

		
		this.mDetener = true;
	}

	public void destruir() {
	
		this.detener();

	
		this.mLogica.destruir();
	}
}
