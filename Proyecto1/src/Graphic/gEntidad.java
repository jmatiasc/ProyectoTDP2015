package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class gEntidad {
	
	public static final int MOVIMIENTO_ARRIBA    = 0;
	public static final int MOVIMIENTO_ABAJO     = 1;
	public static final int MOVIMIENTO_IZQUIERDA = 2;
	public static final int MOVIMIENTO_DERECHA   = 3;
	
	protected JLabel mGrafico;
	
	protected Icon mImages[];
	protected Icon mDestroyedImage;
	
	
	protected final int mWidth  = 32;
	protected final int mHeight = 32;
	
	protected int mVelocidad;
	
	protected Point mPosicion;
	
	protected gEntidad(int velocidad, int x, int y) {
		this.mPosicion  = new Point(x, y);
		this.mVelocidad = velocidad;
		this.mImages    = new Icon[4];
	}
	
	public int getVelocidad() {
		return this.mVelocidad;
	}

	public Point getPosicion() {
		return this.mPosicion;
	}
	
	protected void mover(int dir) {
		if(this.mGrafico != null){
			this.mGrafico.setIcon(this.mImages[dir]);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
			
		}
	}
	
	protected void destruir() {
		if(this.mGrafico != null){
			this.mGrafico.setIcon(this.mDestroyedImage);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
		}
	}
	
	public JLabel getGrafico() {
		if(this.mGrafico == null){
			this.mGrafico = new JLabel(this.mImages[0]);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
		}
		return this.mGrafico;
	}
	

		
	}
	
	

