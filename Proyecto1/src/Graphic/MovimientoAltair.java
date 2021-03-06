package Graphic;

public class MovimientoAltair extends Thread {
	private gAltair jugador;
	private String dir;

	public MovimientoAltair(gAltair j) {
		jugador = j;
	}

	public void run() {
		jugador.comenzarAMover();
		if (dir.equals("arriba"))
			try {
				for (int i = 0; i < 4; i++) {
					jugador.transicionArriba();
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception D:");
			}

		if (dir.equals("abajo"))
			try {
				for (int i = 0; i < 4; i++) {
					jugador.transicionAbajo();
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception D:");
			}

		if (dir.equals("izquierda"))
			try {
				for (int i = 0; i < 4; i++) {
					jugador.transicionIzquierda();
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception D:");
			}

		if (dir.equals("derecha"))
			try {
				for (int i = 0; i < 4; i++) {
					jugador.transicionDerecha();
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception D:");
			}
		jugador.dejarDeMover();
	}

	public void setDir(String d) {
		dir = d;
	}
}
