package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Logic.*;

import java.awt.Point;

public class PowerUpVelocidad extends powerUpsGrafico {

	public PowerUpVelocidad(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource(
				"/imagenes/SpeedUp.png"));

	}

	public Point getPosicion() {
		return this.mPosicion;
	}

	public JLabel getGrafico() {

		if (this.mGrafico == null) {
			this.mGrafico = new JLabel(imagen);
			this.mGrafico.setBounds(this.mPosicion.x, this.mPosicion.y,
					this.mWidth, this.mHeight);
		}
		return this.mGrafico;
	}

	protected void destruir() {
		this.mGrafico.setIcon(null);

	}

}
