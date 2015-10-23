package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logic.*;


import java.awt.Point;

public class PowerUpVelocidad {

	protected JLabel mGrafico;
	protected Icon mPowerUpV;
	
	protected final int mWidth  = 32;
	protected final int mHeight = 32;
	
	protected Point mPosicion;
	
	
	public PowerUpVelocidad(int x, int y,SpeedUp velocidad){
		this.mPosicion  = new Point(x, y);
		mPowerUpV = new ImageIcon(this.getClass().getResource("/BattleCity/muerte.png"));
		

		
		
	}
	
	public Point getPosicion() {
		return this.mPosicion;
	}
	
	public JLabel getGrafico() {	
			
		if(this.mGrafico == null){
			this.mGrafico = new JLabel(mPowerUpV);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
		}
		return this.mGrafico;}

	protected void destruir() {
			this.mGrafico.setIcon(null);
			
		
	}
	
}
