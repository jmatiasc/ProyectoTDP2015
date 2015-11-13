package Graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Inicio extends JFrame {
	private final JLabel Image = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 510);
		getContentPane().setLayout(null);
		
		JButton btnComenzar = new JButton("COMENZAR");
		btnComenzar.setBackground(Color.BLACK);
		btnComenzar.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnComenzar.setForeground(Color.WHITE);
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		btnComenzar.setBounds(437, 354, 180, 54);
		getContentPane().add(btnComenzar);
		Image.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/start.png")));
		Image.setBounds(50, 0, 900, 474);
		getContentPane().add(Image);
	}
}
