package Graphic;

import java.util.Random;

import javax.swing.ImageIcon;

import Logic.*;

public class gRugulus extends gEntidad {
	Rugulus mRug;
	gJugador jugador;
	
	public gRugulus(int velocidad, int x, int y, Enemigo rug,gJugador jugador ) {
		super(velocidad, x, y);
		
		
		mRug=(Rugulus) rug;
		this.jugador=jugador;
		
		
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/BattleCity/up2.png"));
		this.mImages[1] = new ImageIcon(this.getClass().getResource("/BattleCity/down2.png"));
		this.mImages[2] = new ImageIcon(this.getClass().getResource("/BattleCity/left2.png"));
		this.mImages[3] = new ImageIcon(this.getClass().getResource("/BattleCity/right2.png"));
		
		//this.mDestroyedImage = new ImageIcon(this.getClass().getResource("/BattleCity/explotion.png"));
	}
	
	public void mover() {
		// Calculo la siguiente direccion aleatoriamente.
		
		
		int n=mRug.mover();
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
		
		}
	}
	
	
	public void destruir() {
		super.destruir();
	}
	
	
	private void chequeoColisiones(){
		if(mPosicion.equals(jugador.getPosicion())){
			jugador.morir();
		}
	}
	
	
	
	
	
	
}