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
		mContentPane.setBackground(new Color(0, 128, 128));
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 1009, 452);
		setBounds(100, 100, 1009, 520);
		
		
		this.mTablero = new gTablero(this);
		
		
		
	}
	
	protected void accion(KeyEvent key){	
		
		
			this.mTablero.mover(key.getKeyCode());
		}
	
	
	public void sumarPuntos(int p){
		puntos+=p;		
		lblCambioPuntos.setText(""+puntos);
	}
	
	
	
}