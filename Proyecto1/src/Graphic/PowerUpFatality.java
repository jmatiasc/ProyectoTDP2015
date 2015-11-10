package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PowerUpFatality {

	

	protected JLabel mGrafico;
	protected Icon mPowerUpF;
	
	protected final int mWidth  = 32;
	protected final int mHeight = 32;
	
	protected Point mPosicion;
	
	
	public PowerUpFatality(int x, int y){
		this.mPosicion  = new Point(x, y);
		mPowerUpF = new ImageIcon(this.getClass().getResource("/imagenes/fatality.png"));
		

		
		
	}
	
	public Point getPosicion() {
		return this.mPosicion;
	}
	
	public JLabel getGrafico() {	
			
		if(this.mGrafico == null){
			this.mGrafico = new JLabel(mPowerUpF);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y, this.mWidth, this.mHeight);
		}
		return this.mGrafico;}

	protected void destruir() {
			this.mGrafico.setIcon(null);
			
		
	}
}
