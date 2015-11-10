package Graphic;

public class threadCronometro extends Thread{
	private int minutos;
	private int segundos;
	private boolean andar;
	private GUI gui;
	
	public threadCronometro(GUI gui){
		minutos=0;
		segundos=0;
		this.gui=gui;
		andar=true;
	}
	
	public void run(){
		while(andar){
				try {
					Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				if(segundos!=59)
					segundos++;
				else{
						minutos++;
						segundos=0;
				}
			gui.setHora(minutos,segundos);
				}
		}
	
	
	public void deternerCronometro(){
		andar=false;
	}
}
