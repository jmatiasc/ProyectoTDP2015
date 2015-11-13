package Graphic;

public class MovimientoJugador extends Thread {
	private gJugador jugador;
	private String dir;
	private int velocidad;
	
	public MovimientoJugador(gJugador j) {
		jugador = j;
		
		
		velocidad=(100/jugador.getVelocidad());
	}
	
	public void run() {
		if (dir.equals("arriba"))
			try {
				for(int i=0;i<4;i++) {
					jugador.transicionArriba();
					
					Thread.sleep(velocidad);
				}		
			} catch (InterruptedException e) {System.out.println("Interrupted Exception D:");}
		
		if (dir.equals("abajo"))
			try {
				for(int i=0;i<4;i++) {
					jugador.transicionAbajo();
					
					Thread.sleep(velocidad);
				}		
			} catch (InterruptedException e) {System.out.println("Interrupted Exception D:");}
		
		if (dir.equals("izquierda"))
			try {
				for(int i=0;i<4;i++) {
					jugador.transicionIzquierda();
					
					Thread.sleep(velocidad);
				}		
			} catch (InterruptedException e) {System.out.println("Interrupted Exception D:");}
		
		if (dir.equals("derecha"))
			try {
				for(int i=0;i<4;i++) {
					jugador.transicionDerecha();
					
					Thread.sleep(velocidad);
				}		
			} catch (InterruptedException e) {System.out.println("Interrupted Exception D:");}
	}
	
	public void setDir(String d) {
		dir = d;
	}
}
