package Graphic;

import java.util.Random;

import javax.swing.ImageIcon;

import Logic.*;

public class gAltair extends gEntidad{

	
	Altair mAlt;
	gJugador jugador;
	
	public gAltair(int velocidad, int x, int y, Enemigo alt,gJugador jugador ) {
		super(velocidad, x, y);
		
		
		mAlt=(Altair) alt;
		this.jugador=jugador;
		
		
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/imagenes/up.png"));
		this.mImages[1] = new ImageIcon(this.getClass().getResource("/imagenes/down.png"));
		this.mImages[2] = new ImageIcon(this.getClass().getResource("/imagenes/left.png"));
		this.mImages[3] = new ImageIcon(this.getClass().getResource("/imagenes/right.png"));
		
		this.mDestroyedImage = new ImageIcon(this.getClass().getResource("/imagenes/explotion.png"));
	}
	
	public void mover() {
		// Calculo la siguiente direccion aleatoriamente.
		
		if(mAlt.estaVivo()){
		int n=mAlt.mover();
		if (n!=-1){
		switch (n) {
			
			case MOVIMIENTO_ARRIBA : 				
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y - this.mVelocidad);
				chequeoColisiones();
				break;
			case MOVIMIENTO_ABAJO :
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y + this.mVelocidad);
				chequeoColisiones();
				break;
			case MOVIMIENTO_IZQUIERDA :
				this.mPosicion.setLocation(this.mPosicion.x - this.mVelocidad, this.mPosicion.y);
				chequeoColisiones();
				break;
			case MOVIMIENTO_DERECHA :
				this.mPosicion.setLocation(this.mPosicion.x + this.mVelocidad, this.mPosicion.y);
				chequeoColisiones();
				break;
		}
		
		
		super.mover(n);
		
		}}
	}
	
	
	public void destruir() {
		super.destruir();
	}
	
	
	private void chequeoColisiones(){
		if(jugador!=null){
		if(mPosicion.equals(jugador.getPosicion())){
			jugador.morir();
		}}
	}
	
	
}
