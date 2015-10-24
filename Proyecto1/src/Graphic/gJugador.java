package Graphic;
import Logic.*;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class gJugador extends gEntidad {

	protected Bomberman bomberman;
	private Tablero tablero;
	
	private gTablero gTab;

	private gBomba bomba;
	
	private MovimientoThread movimientoThread;
	
	public gJugador(int velocidad,Bomberman bom, int x, int y,Tablero tablero,gTablero gt) {
		
		
		super(32, x, y);
		
		
		bomberman=bom;
		this.tablero=tablero;
		gTab=gt;
		
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/imagenes/up.png"));
		this.mImages[1] = new ImageIcon(this.getClass().getResource("/imagenes/down.png"));
		this.mImages[2] = new ImageIcon(this.getClass().getResource("/imagenes/left.png"));
		this.mImages[3] = new ImageIcon(this.getClass().getResource("/imagenes/right.png"));
		
		this.mDestroyedImage = new ImageIcon(this.getClass().getResource("/imagenes/explotion.png"));
		;
		
		
	}

	/*public void mover(int dir){
		
		switch (dir){
			case KeyEvent.VK_UP :
				if(bomberman.moverArriba()){
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y - this.mVelocidad);
				super.mover(MOVIMIENTO_ARRIBA);}
				break;
			case KeyEvent.VK_DOWN :
				if(bomberman.moverAbajo()){
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y + this.mVelocidad);
				super.mover(MOVIMIENTO_ABAJO);}
				break;
			case KeyEvent.VK_LEFT :
				if(bomberman.moverIzquierda()){
				this.mPosicion.setLocation(this.mPosicion.x - this.mVelocidad, this.mPosicion.y);
				super.mover(MOVIMIENTO_IZQUIERDA);}
				break;
			case KeyEvent.VK_RIGHT :
				if(bomberman.moverDerecha()){
				this.mPosicion.setLocation(this.mPosicion.x + this.mVelocidad, this.mPosicion.y);
				super.mover(MOVIMIENTO_DERECHA);}
				break;
			case KeyEvent.VK_A :
				Bomba b=bomberman.dejarBomba();
				if(b!=null)
				{
				
					gTab.dejarBomba(mPosicion,b);
				
				}
				break;
				
		}
	}*/
	
	private int obtenerPosicionX(int x) {
		int aux = x/32;
		if (aux == 31)
			return 30;
		return aux;
	}
	
	private int obtenerPosicionY(int y) {
		int aux = y/13;
		if (aux == 12)
			return 11;
		return aux;
	}
	
	
	public void morir(){
		gTab.matarBomberman();
		mPosicion.x=0;
		mPosicion.y=0;
		
		
	}
	
	public void aumentarVelocidad(){
		mVelocidad*=2;
	}
	
	public void aumentarBombas(){
		
		//bomberman.aumentarCantBombas();
	}

	public void transicionArriba() {
		this.mPosicion.setLocation(this.mPosicion.x,this.mPosicion.y-8);
		super.mover(MOVIMIENTO_ARRIBA);
	}
	
	public void transicionAbajo() {
		this.mPosicion.setLocation(this.mPosicion.x,this.mPosicion.y+8);
		super.mover(MOVIMIENTO_ABAJO);
	}
	
	public void transicionIzquierda() {
		this.mPosicion.setLocation(this.mPosicion.x-8,this.mPosicion.y);
		super.mover(MOVIMIENTO_IZQUIERDA);
	}
	
	public void transicionDerecha() {
		this.mPosicion.setLocation(this.mPosicion.x+8,this.mPosicion.y);
		super.mover(MOVIMIENTO_DERECHA);
	}

	public void mover(int dir){
		if(bomberman!=null){
		switch (dir){
			case KeyEvent.VK_UP :
				if(bomberman.moverArriba()){
					movimientoThread = new MovimientoThread(this); //Cambio
					movimientoThread.setDir("arriba");
					movimientoThread.start();
				}
				break;
			case KeyEvent.VK_DOWN :
				if(bomberman.moverAbajo()){
					movimientoThread = new MovimientoThread(this); //Cambio
					movimientoThread.setDir("abajo");
					movimientoThread.start();
				}
				break;
			case KeyEvent.VK_LEFT :
				if(bomberman.moverIzquierda()){
					movimientoThread = new MovimientoThread(this); //Cambio
					movimientoThread.setDir("izquierda");
					movimientoThread.start();
				}
				break;
			case KeyEvent.VK_RIGHT :
				if(bomberman.moverDerecha()){
					movimientoThread = new MovimientoThread(this); //Cambio
					movimientoThread.setDir("derecha");
					movimientoThread.start();
				}
				break;
			case KeyEvent.VK_A :
				Bomba b=bomberman.dejarBomba();
				if(b!=null)
				{
				
					gTab.dejarBomba(mPosicion,b);
				
				}
				break;
		}
		}
	}
	
}
