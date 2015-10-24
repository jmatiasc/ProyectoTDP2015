package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class PowerUpBombality {

	protected JLabel mGrafico;
	protected Icon mPowerUpB;
	
	protected final int mWidth  = 32;
	protected final int mHeight = 32;
	
	protected Point mPosicion;
	
	
	public PowerUpBombality(int x, int y){
		this.mPosicion  = new Point(x, y);
		mPowerUpB = new ImageIcon(this.getClass().getResource("/imagenes/bombality.png"));
		

		
		
	}
	
	public Point getPosicion() {
		return this.mPosicion;
	}
	
	public JLabel getGrafico() {	
			
		if(this.mGrafico == null){
			this.mGrafico = new JLabel(mPowerUpB);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
		}
		return this.mGrafico;}

	protected void destruir() {
			this.mGrafico.setIcon(null);
			
		
	}
	

}
