package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class powerUpsGrafico {

	protected JLabel mGrafico;
	protected Icon imagen;

	protected final int mWidth = 32;
	protected final int mHeight = 32;

	protected Point mPosicion;

	protected powerUpsGrafico(int x, int y) {
		this.mPosicion = new Point(x, y);
		imagen = new ImageIcon(this.getClass()
				.getResource("/imagenes/nada.png"));
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
