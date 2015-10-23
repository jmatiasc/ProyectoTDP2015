package Graphic;

	import java.awt.Point;

	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JLabel;
	import Logic.*;


	import java.awt.Point;
public class gBomba{
	

	

		protected JLabel mGrafico;
		protected Icon imgBomba;
		
		protected final int mWidth  = 32;
		protected final int mHeight = 32;
		
		protected Point mPosicion;
		
		protected Bomba bomba;
		
		
		
		public gBomba(Bomba b){
			//this.mPosicion  = new Point(x, y);
			bomba=b;
			imgBomba = new ImageIcon(this.getClass().getResource("/BattleCity/muerte.png"));
			this.mGrafico = new JLabel(imgBomba);

			
			
		}
		
		public Point getPosicion() {
			return this.mPosicion;
		}
		
		public JLabel getGrafico() {	
				
			this.mGrafico.setBounds(mPosicion.x,mPosicion.y, this.mWidth, this.mHeight);
				return this.mGrafico;
			
				
			
		}

		protected void destruir() {
				this.mGrafico.setIcon(null);
				bomba.explotar();
				
				
				
			
		}
		
		
		public void setPosicion(Point pos)
		{
			mPosicion = pos;
			
		}
		
		public void dejarBomba(){
			mGrafico.setIcon(imgBomba);
			
		}
		
		
		
	}


