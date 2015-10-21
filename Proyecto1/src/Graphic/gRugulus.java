package Graphic;

import java.util.Random;

import javax.swing.ImageIcon;

public class gRugulus extends gEntidad {
	
	public gRugulus(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.mImages[0] = new ImageIcon(this.getClass().getResource("/BattleCity/up2.png"));
		this.mImages[1] = new ImageIcon(this.getClass().getResource("/BattleCity/down2.png"));
		this.mImages[2] = new ImageIcon(this.getClass().getResource("/BattleCity/left2.png"));
		this.mImages[3] = new ImageIcon(this.getClass().getResource("/BattleCity/right2.png"));
		
		this.mDestroyedImage = new ImageIcon(this.getClass().getResource("/BattleCity/explotion.png"));
	}
	
	public void mover() {
		// Calculo la siguiente direccion aleatoriamente.
		Random rnd = new Random();
		int dir = rnd.nextInt(4);
		
		switch (dir) {
			case MOVIMIENTO_ARRIBA : 
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y - this.mVelocidad);
				break;
			case MOVIMIENTO_ABAJO :
				this.mPosicion.setLocation(this.mPosicion.x, this.mPosicion.y + this.mVelocidad);
				break;
			case MOVIMIENTO_IZQUIERDA :
				this.mPosicion.setLocation(this.mPosicion.x - this.mVelocidad, this.mPosicion.y);
				break;
			case MOVIMIENTO_DERECHA :
				this.mPosicion.setLocation(this.mPosicion.x + this.mVelocidad, this.mPosicion.y);
				break;
		}
		
		super.mover(dir);
	}
	
	
	public void destruir() {
		super.destruir();
	}
}