package Graphic;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PowerUpBombality extends powerUpsGrafico {

	public PowerUpBombality(int x, int y) {
		super(x, y);
		imagen = new ImageIcon(this.getClass().getResource(
				"/imagenes/Bombality.png"));

	}

}
