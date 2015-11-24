package Graphic;

public class threadCronometro extends Thread {
	private int minutos;
	private int segundos;
	private int horas;
	private boolean andar;
	private GUI gui;

	public threadCronometro(GUI gui) {
		horas = 0;
		minutos = 0;
		segundos = 0;
		this.gui = gui;
		andar = true;
	}

	public void run() {
		while (andar) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (segundos != 59)
				segundos++;
			else {
				if (minutos != 59) {
					minutos++;
					segundos = 0;
				} else {
					minutos = 0;
					segundos = 0;
					horas++;
				}
			}
			gui.setHora(horas, minutos, segundos);
		}
	}

	public void deternerCronometro() {
		andar = false;
	}
}
