package Graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel mContentPane;
	
	private gTablero mTablero;

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
		this.mContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.mContentPane.setLayout(null);
		
		setContentPane(this.mContentPane);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 452);
		
		this.mTablero = new gTablero(this);
	}
	
	protected void accion(KeyEvent key){	
		
		
			this.mTablero.mover(key.getKeyCode());
		}
		
		
	
	
		
	

}