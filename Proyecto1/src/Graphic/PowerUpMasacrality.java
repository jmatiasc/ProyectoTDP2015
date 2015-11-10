package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PowerUpMasacrality {

	protected JLabel mGrafico;
	protected Icon mPowerUpM;
	
	protected final int mWidth  = 32;
	protected final int mHeight = 32;
	
	protected Point mPosicion;
	
	
	public PowerUpMasacrality(int x, int y){
		this.mPosicion  = new Point(x, y);
		mPowerUpM = new ImageIcon(this.getClass().getResource("/imagenes/masacrality.png"));
		

		
		
	}
	
	public Point getPosicion() {
		return this.mPosicion;
	}
	
	public JLabel getGrafico() {	
			
		if(this.mGrafico == null){
			this.mGrafico = new JLabel(mPowerUpM);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
		}
		return this.mGrafico;}

	protected void destruir() {
			this.mGrafico.setIcon(null);
			
		
	}
}
