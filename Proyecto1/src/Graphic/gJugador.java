package Graphic;
import Logic.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class gJugador extends gEntidad {

	protected Bomberman bomberman;
	private Tablero tablero;
	
	private gTablero gTab;

	
	public gJugador(int velocidad,Bomberman bom, int x, int y,Tablero tablero,gTablero gt) {
		
		//super(velocidad, x, y);
		super(32, x, y);
		
		
		bomberman=bom;
		this.tablero=tablero;
		gTab=gt;
		
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/BattleCity/up.png"));
		this.mImages[1] = new ImageIcon(this.getClass().getResource("/BattleCity/down.png"));
		this.mImages[2] = new ImageIcon(this.getClass().getResource("/BattleCity/left.png"));
		this.mImages[3] = new ImageIcon(this.getClass().getResource("/BattleCity/right.png"));
		
		this.mDestroyedImage = new ImageIcon(this.getClass().getResource("/BattleCity/explotion.png"));
		
	}

	public void mover(int dir){
		
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
		}
	}
	
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
	
	
}
