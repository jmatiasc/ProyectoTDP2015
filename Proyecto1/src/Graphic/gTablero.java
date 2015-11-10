package Graphic;

import java.awt.Component;
import java.awt.Point;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.*;


public class gTablero {
	
	private Tablero t;
	
	private Thread Enemigos[];
	
	
	private gJugador mJugador;
	
	private ImageIcon paredI;
	private ImageIcon paredD;

	
	private GUI gui;
	
	
	//HACER ARREGLO 
	private PowerUp [] arregloP;
	
	
	
	private gBomba bomba;
	
	public gTablero(GUI gui){
		this.gui=gui;
		
		paredI= new ImageIcon((this.getClass().getResource("/imagenes/pared.png")));
	
		paredD= new ImageIcon((this.getClass().getResource("/imagenes/paredD.png")));
		
		
		// Creo el jugador y lo agrego el grafico a la gui.
		t = new Tablero(13,31);
		this.mJugador = new gJugador(t.getBomberman().getVelocidad(),t.getBomberman(), 32, 32,t,this);
		gui.add(this.mJugador.getGrafico());
		
		// Creo los malos y agrego a la gui su grafico.
		this.Enemigos = new Thread[6];
		
		//agrego los rugulus en posiciones que coinciden con las que creo los rugulus en el tablero
		Enemigo enemig[]=t.getEnemigos() ;
		
		
		
		gRugulus rugulus1 = new gRugulus(32,enemig[0].getPosicion().getEjeX()*32,enemig[0].getPosicion().getEjeY()*32,enemig[0],mJugador);
		Enemigos[0] = new RugulusThread(rugulus1);
		gui.add(rugulus1.getGrafico());
		
		
		
		
		gRugulus rugulus2 = new gRugulus(32,enemig[1].getPosicion().getEjeX()*32,enemig[1].getPosicion().getEjeY()*32,enemig[1],mJugador);
		Enemigos[1] = new RugulusThread(rugulus2);
		gui.add(rugulus2.getGrafico());
		
		
		
		
		gRugulus rugulus3 = new gRugulus(32,enemig[2].getPosicion().getEjeX()*32,enemig[2].getPosicion().getEjeY()*32,enemig[2],mJugador);
		Enemigos[2] = new RugulusThread(rugulus3);
		gui.add(rugulus3.getGrafico());
		
		
		
		gAltair altair1 = new gAltair(32,enemig[3].getPosicion().getEjeX()*32,enemig[3].getPosicion().getEjeY()*32,enemig[3],mJugador);
		Enemigos[3] = new AltairThread(altair1);
		gui.add(altair1.getGrafico());
		
		
		gAltair altair2 = new gAltair(32,enemig[4].getPosicion().getEjeX()*32,enemig[4].getPosicion().getEjeY()*32,enemig[4],mJugador);
		Enemigos[4] = new AltairThread(altair2);
		gui.add(altair2.getGrafico());
		
		gSirius Sirius = new gSirius(32,enemig[5].getPosicion().getEjeX()*32,enemig[5].getPosicion().getEjeY()*32,enemig[5],mJugador);
		Enemigos[5] = new SiriusThread(Sirius);
		gui.add(Sirius.getGrafico());
		
		
		this.Enemigos[0].start();
		this.Enemigos[1].start();
		this.Enemigos[2].start();
		this.Enemigos[3].start();
		this.Enemigos[4].start();
		this.Enemigos[5].start();
		
		
	
		
		
		
		ponerPared(gui);
		ponerParedD(t.getPosDestructibles(),gui);
		
		
		
		//POWER UPS!!!HACER ARREGLO PLEASE
		
		
		arregloP=t.obtenerPowerUp();
		
		Posicion pos=arregloP[0].getPosicion();
		PowerUpVelocidad velocidad1=new PowerUpVelocidad(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(velocidad1.getGrafico());
		
		pos=arregloP[1].getPosicion();
		PowerUpVelocidad velocidad2=new PowerUpVelocidad(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(velocidad2.getGrafico());
		
		pos=arregloP[2].getPosicion();
		PowerUpVelocidad velocidad3=new PowerUpVelocidad(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(velocidad3.getGrafico());
		
		
		pos=arregloP[3].getPosicion();
		PowerUpVelocidad velocidad4=new PowerUpVelocidad(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(velocidad4.getGrafico());
		//_____________________________________________________________________
		
		pos=arregloP[4].getPosicion();
		PowerUpFatality fatality1=new PowerUpFatality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(fatality1.getGrafico());
		
		
		
		pos=arregloP[5].getPosicion();
		PowerUpFatality fatality2=new PowerUpFatality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(fatality2.getGrafico());
		
		
		pos=arregloP[6].getPosicion();
		PowerUpFatality fatality3=new PowerUpFatality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(fatality3.getGrafico());
		
		//_____________________________________________________
		pos=arregloP[7].getPosicion();
		PowerUpBombality bombality1=new PowerUpBombality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(bombality1.getGrafico());
		
		pos=arregloP[8].getPosicion();
		PowerUpBombality bombality2=new PowerUpBombality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(bombality2.getGrafico());


		pos=arregloP[9].getPosicion();
		PowerUpBombality bombality3=new PowerUpBombality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(bombality3.getGrafico());
		
		//____________________________________________________________________
		
		
		pos=arregloP[10].getPosicion();
		PowerUpMasacrality masacrality=new PowerUpMasacrality(pos.getEjeX()*32,pos.getEjeY()*32);
		gui.add(masacrality.getGrafico());
		
		
	}
	
	public void mover(int dir){
		if(mJugador!=null){
		this.mJugador.mover(dir);
		chequeoColisiones();
		}
		
	}
	
	//el chequeo lo debo cambiar a cada powerUp
	private void chequeoColisiones(){
		
		for(int i=0;i<arregloP.length;i++)
			
				if(arregloP[i].getPosicion().equals(mJugador.getPosicion())){
					ImageIcon nada=new ImageIcon((this.getClass().getResource("/imagenes/nada.png")));
					gui.add(new JLabel(nada));
					arregloP[i]=null;
					
				}	
		
		
	}
	
	public void destruir(int malo) {
	
	}

	
	private void ponerPared(GUI gui){
		
		for(int h=0;h<31;h++){
	        for(int n=0;n<13;n++){
	        	
	        	if(n==0){
	        		JLabel labelPared=new JLabel (paredI);
	        		gui.add(labelPared);
	        		labelPared.setBounds(h*32,0, 32,32);
		        	}
		        	else 
		        		if(h==0){  JLabel labelPared=new JLabel (paredI);
		        		gui.add(labelPared);
		        		labelPared.setBounds(0, n*32, 32,32);
			        	}
		        		else
		        			if(n==12){
		        				 JLabel labelPared=new JLabel (paredI);
		 		        		gui.add(labelPared);
		 		        		labelPared.setBounds(h*32, n*32, 32,32);
		    		        	}
		    		        	else 
		    		        		if(h==30){
		    		        			 JLabel labelPared=new JLabel (paredI);
		 		 		        		gui.add(labelPared);
		 		 		        		labelPared.setBounds(h*32, n*32, 32,32);
		    			        	
		    			        	}
			        	else 
			        		if(h%2==0 && n%2==0){
			        			 JLabel labelPared=new JLabel (paredI);
			 		        		gui.add(labelPared);
			 		        		labelPared.setBounds(h*32, n*32, 32,32);
				        	
				        	}
	        		
			        			 
				        	  
			        			
	        }
		}}
		
	
		private void ponerParedD(Posicion[] pos,GUI gui){
			int i=0;
			while(pos[i+1]!=null || i==pos.length){
				 JLabel labelPared=new JLabel (paredD);
	        		gui.add(labelPared);
	        		labelPared.setBounds(pos[i].getEjeX()*32, pos[i].getEjeY()*32, 32,32);
	        		i++;
			}
		}
	
		
		public void matarBomberman(){
			mJugador.destruir();

			mJugador=null;
			
		}
		
		
		public void dejarBomba(Point p,Bomba b){	
					gBomba bomba=new gBomba(b,this); //Cambio
					bomba.setPosicion(p);
					bomba.dejarBomba();
					gui.add(bomba.getGrafico());
					BombaThread tb=new BombaThread(bomba);
					
					tb.start();
					
					
		
			}
		public void mostrarExplosion(Point p,int alcance){
			//cuando alcance es 1
					Point  arriba[]=new Point[alcance];
					Point abajo[]=new Point[alcance];
					Point izquierda[]=new Point[alcance];
					Point derecha[]=new Point[alcance];
					
			
			
			for(int i=0; i<alcance;i++){
	    		 arriba[i]=new Point(p.x,p.y-(i*32+32));
	    		
	    		 abajo[i]=new Point(p.x,p.y+(i*32+32));
	    		 izquierda[i]=new Point(p.x-(i*32+32),p.y);
	    		 derecha[i]=new Point(p.x+(i*32+32),p.y);
	    		 }
			
				int cant=alcance*4+1;
				Explosion [] arreglo=new Explosion[cant];
				arreglo[0]=new Explosion(p);
				
				int a=1;
				for(int  i=0; i<arriba.length;i++){
				arreglo[a]=new Explosion(arriba[i]);
				a++;
				}
				
				for(int i=0; i<abajo.length;i++){
					arreglo[a]=new Explosion(abajo[i]);
					a++;
				}
				
				for(int i=0; i<derecha.length;i++){
					arreglo[a]=new Explosion(derecha[i]);
					a++;
				}
				
				for(int i=0; i<izquierda.length;i++){
					arreglo[a]=new Explosion(izquierda[i]);
					a++;
				}
				
				
				ImageIcon mPowerUpV = new ImageIcon(this.getClass().getResource("/imagenes/explosion.png")); //Agregue esto 1/2
				for(int i=0; i<arreglo.length;i++){
					gui.add(arreglo[i].getGrafico());
					arreglo[i].getGrafico().setIcon(mPowerUpV);//agregue esto 2/2
					
				}
				
				ThreadRetardo t=new ThreadRetardo(arreglo,gui);
				t.start();
				
				
				
			}
		
		
}