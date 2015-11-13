package Graphic;

import javax.swing.ImageIcon;

public class ThreadRetardo extends Thread{

	private Explosion [] arreglo;
	private GUI gui;
	
	public ThreadRetardo(Explosion [] a ,GUI gui){
		arreglo=a;
		this.gui=gui;
	}
	
	public void run(){
		
		try {
			
	
			
			sleep(1000);
			ImageIcon pasto = new ImageIcon(this.getClass().getResource("/imagenes/nada.png"));
			
			for(int i=0; i<arreglo.length;i++){
				if(arreglo[i]!=null){
				gui.add(arreglo[i].getGrafico());
				arreglo[i].getGrafico().setIcon(pasto);
				
			}}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
}
