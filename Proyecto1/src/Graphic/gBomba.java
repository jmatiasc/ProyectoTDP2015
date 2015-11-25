package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.*;

import java.awt.Point;

public class gBomba {

	protected JLabel mGrafico;
	protected Icon imgBomba;

	protected final int mWidth = 32;
	protected final int mHeight = 32;

	protected Point mPosicion;

	protected Bomba bomba;
	protected gTablero gTab;

	public gBomba(Bomba b, gTablero t) {
		
		bomba = b;
		imgBomba = new ImageIcon(this.getClass().getResource(
				"/imagenes/bomba.gif"));
		this.mGrafico = new JLabel(imgBomba);
		gTab = t; 

	}

	public Point getPosicion() {
		return this.mPosicion;
	}

	public JLabel getGrafico() {

		this.mGrafico.setBounds(mPosicion.x, mPosicion.y, this.mWidth,
				this.mHeight);
		return this.mGrafico;

	}

	protected void destruir() {
		this.mGrafico.setIcon(null);
		Celda[] arreglo = bomba.activar();
		bomba.explotar(arreglo);
		gTab.mostrarExplosion(getPosicion(), arreglo);

	}

	public void setPosicion(Point pos) {
		Point p = new Point(pos.x, pos.y); 
		mPosicion = p;

	}

	public void dejarBomba() {
		mGrafico.setIcon(imgBomba);
	}

}
