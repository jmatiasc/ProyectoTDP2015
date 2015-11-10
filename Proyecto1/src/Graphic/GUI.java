package Graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel mContentPane;
	
	private gTablero mTablero;
	private int puntos;
	private JLabel lblCambioPuntos;
	private JLabel lblMinutos;
	private int minutos;
	private int segundos;
	private threadCronometro cronometro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
				accion(e);			}
		});
		
		this.mContentPane = new JPanel();
		mContentPane.setBackground(new Color(72, 61, 139));
		mContentPane.setForeground(new Color(34, 139, 34));
		this.mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mContentPane.setLayout(null);
		
		setContentPane(this.mContentPane);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 412, 993, 70);
		mContentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPuntos = new JLabel("PUNTOS:");
		lblPuntos.setForeground(Color.WHITE);
		lblPuntos.setBackground(Color.WHITE);
		lblPuntos.setBounds(25, 11, 76, 14);
		panel.add(lblPuntos);
		
		lblCambioPuntos = new JLabel("0");
		lblCambioPuntos.setForeground(Color.GREEN);
		lblCambioPuntos.setBounds(111, 11, 46, 14);
		panel.add(lblCambioPuntos);
		
		JLabel lblTiempo = new JLabel("TIEMPO:");
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setBounds(194, 11, 69, 14);
		panel.add(lblTiempo);
		
		lblMinutos= new JLabel("00:00");
		lblMinutos.setForeground(Color.GREEN);
		lblMinutos.setBounds(293, 11, 76, 14);
		panel.add(lblMinutos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1009, 452);
		setBounds(100, 100, 1000, 510);
		
		
		this.mTablero = new gTablero(this);
		
		cronometro=new threadCronometro(this);
		cronometro.start();
		
	}
	
	protected void accion(KeyEvent key){	
		
		
			this.mTablero.mover(key.getKeyCode());
		}
	
	
	public void sumarPuntos(int p){
			
		lblCambioPuntos.setText(""+p);
	}
	
	public void setHora(int m,int s){
		minutos=m;
		segundos=s;
		lblMinutos.setText(minutos+" : "+segundos);
		;
		
	}
}