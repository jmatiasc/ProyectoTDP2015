package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Explosion {
	protected JLabel mGrafico;

	protected Icon mPowerUpV;

	protected final int mWidth = 32;
	protected final int mHeight = 32;

	protected Point mPosicion;

	public Explosion(Point p) {
		this.mPosicion = p;
		mPowerUpV = new ImageIcon(this.getClass().getResource(
				"/imagenes/explosion2.png"));

		if (this.mGrafico == null) {
			this.mGrafico = new JLabel(mPowerUpV);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y,
					this.mWidth, this.mHeight);
		}

	}

	public Point getPosicion() {
		return this.mPosicion;
	}

	public JLabel getGrafico() {
		return this.mGrafico;
	}

	protected void destruir() {
		this.mGrafico.setIcon(null);

	}

}
